package com.pacificdataservices.diamond.planning.data;
/*
 * PlanGroupSnapshot.java
 *
 * Created on February 18, 2006, 7:19 AM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */



import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.dom4j.Document;
import org.dom4j.DocumentFactory;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;
//import org.javautil.buckets.DateGenerator;
import org.javautil.buckets.DateHelper;
import org.javautil.core.text.SimpleDateFormats;
import org.javautil.util.DateGenerator;
import org.javautil.util.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.pacificdataservices.diamond.models.ApsSrcRule;
import com.pacificdataservices.diamond.models.FcItemMast;
import com.pacificdataservices.diamond.models.FcstGrp;
import com.pacificdataservices.diamond.models.IcCertCd;
import com.pacificdataservices.diamond.models.IcItemCustSubst;
import com.pacificdataservices.diamond.models.IcItemMast;
import com.pacificdataservices.diamond.models.IcItemMastEquiv;
import com.pacificdataservices.diamond.models.NaOrg;
import com.pacificdataservices.diamond.models.OeCustMfr;
import com.pacificdataservices.diamond.models.OeItemHistFcstGrp;
import com.pacificdataservices.diamond.models.OeOrdDtlHist;
import com.pacificdataservices.diamond.models.VqQteVw;
import com.pacificdataservices.diamond.planning.Allocation;
import com.pacificdataservices.diamond.planning.AllocationMode;
import com.pacificdataservices.diamond.planning.Allocator;
import com.pacificdataservices.diamond.planning.EligibleSupplies;
import com.pacificdataservices.diamond.planning.EligibleSupply;
import com.pacificdataservices.diamond.planning.PlanningDataException;
import com.pacificdataservices.diamond.planning.container.ApsSrcRuleSetExt;
import com.pacificdataservices.diamond.planning.demand.Demand;
import com.pacificdataservices.diamond.planning.demand.DemandCustomer;
import com.pacificdataservices.diamond.planning.filter.SupplyEligibilityTest;
import com.pacificdataservices.diamond.planning.supply.Supply;
import com.pacificdataservices.diamond.planning.supply.SupplyReplen;
import com.pacificdataservices.diamond.planning.supply.SupplyWorkOrder;
import com.pacificdataservices.diamond.rules.CustomerItemManufacturerRules;

/**
 * 
 * @author jim
 */
public class PlanGroupSnapshot {
	private PlanningData data;
	//	public static final String revision = "$Revision: 1.1 $";
	//
	//	private static final Logger logger = Logger.getLogger(PlanGroupSnapshot.class.getName());
	//
	private Document doc;
	//
	//	private PlanningManager engine;
	//
	private List<Demand> demands;
	//
	//	private Set<Demand> prioritizedDemands;
	//
	private Element root;
	//
	//	private AllSupplyJDBCPersister supplies;
	//
	private Collection<Supply> supplies;
	private static final String beforeBucketName = "Past Due";

	private static final String afterBucketName = "Later";

	private static final String allocationBucket = "allocationBucket";

	private ArrayList<Supply> supplyList = new ArrayList<Supply>();

	private Map<String, SupplyReplen> supplyOnhand;

	private Map<String, SupplyReplen> purchases;

	private Map<String, SupplyWorkOrder> workOrderSupply;
	//
	private TreeMap<String, Supply> supplyMap = new TreeMap<String, Supply>();
	//
	private Collection<IcItemMast> icItemMasts;

	//	private Allocator allocator;

	private List<IcItemMastEquiv> itemEquivs;
	//
	//
	private ArrayList<IcItemCustSubst> custSubsts;
	//
	//	// private PoReschedS rescheds;
	//
	private int idNbr = 1;

	private DateGenerator buckets;

	private ArrayList<Date> dateBuckets;
	//
	private HashMap<String, ArrayList<Supply>> intervalBucketedSupply = new HashMap<String, ArrayList<Supply>>();
	private HashMap<String, ArrayList<Demand>> intervalBucketedDemand = new HashMap<String, ArrayList<Demand>>();
	//
	//	// private HashMap<String,Double> intervalBucketedPosition = new HashMap<String,Double>();
	//
	//	private CustomerItemManufacturerRuleS customerItemManufacturerRuleS;
	//
	//	private static final Integer RestrictToApproved = new Integer(1);
	private Logger logger = LoggerFactory.getLogger(getClass());
	private CustomerItemManufacturerRules customerItemManufacturerRules; 
	// attribute names
	private static final String splyXmlId = "splyXmlId";

	private static final String dmdXmlId = "dmdXmlId";

	private SimpleDateFormat sdf = new SimpleDateFormat(SimpleDateFormats.ISO8601_date_pretty);

	/** Creates a new instance of PlanGroupSnapshot */
	public PlanGroupSnapshot(PlanningData planningData) {
		this.data = planningData;
	}

	public Document getXmlDocument() {
		// new cleanup jjs 8-13-2006
		supplyMap.clear();
		intervalBucketedSupply.clear();           
		intervalBucketedDemand.clear();
		//rescheds = engine.getPoReschedS();
		supplies = data.getSupplies();
		demands = data.getDemands();
		supplyOnhand = data.getSupplyReplenById();
		purchases = data.getSupplyReplenById();
		workOrderSupply = data.getSupplyWorkOrderById();
		Collection<IcItemMast> icItemMasts = data.getIcItemMasts();
		itemEquivs = data.getIcItemMastEquivs();
		custSubsts = data.getIcCustItemSubsts();
		customerItemManufacturerRules = data.getCustomerItemManufacturerRules();
		//
		doc = DocumentFactory.getInstance().createDocument();

		doc.addProcessingInstruction("xml-stylesheet", "type='text/xsl' href='pipeline.xsl'");
		root = doc.addElement("PlanGroup");
		root.addAttribute("version", "19.3");
		idNbr = 1;
		//populateSupplyList();
		//
		buildBuckets();
		emitBuckets();
		//	idSupplies();
		emitIcItemMasts();
		emitFcstGrps();
		emitFcItemMasts();
		addCertifications();
		//	idDemand();

		addAllocations();
		addCustomerItemManufacturerRules();
		Element supplyElement = root.addElement("supplies");
		emitSupplies(supplyElement, data.getSuppliesById().values());
		emitPrioritizedDemands();
		addProjectedPosition();
		emitSourcingRules();
		emitVqQteVw();
	//	emitOeOrdDtlHists();
		emitOeItemHistFcstGrps();
		//emitSalesHistory();
		//emitVendorQuotes();
		//	emitRequisitions();
		return doc;
	}

	private void emitIcItemMasts() {
		Element mastersElement = root.addElement("icItemMasts");
		Collection<IcItemMast>  icItemMasts = data.getIcItemMasts();
		for (IcItemMast master : icItemMasts) {
			Element imElement = mastersElement.addElement("icItemMast");
			imElement.addAttribute("itemNbr", asString(master.getItemNbr()));
			imElement.addAttribute("itemCd", master.getItemCd());
			imElement.addAttribute("descr", master.getItemDescr());

			imElement.addAttribute("stkUm", master.  getStkUm());
			imElement.addAttribute("itemCdVertical", rotateText(master.getItemCd()));
			if (master.getLeadTmDy() != null) {
				imElement.addAttribute("leadTm", Double.toString(master.getLeadTmDy() / 7));
			}
			//
			for (IcItemMastEquiv iime : itemEquivs) {
				if (iime.getId().getItemNbr() == master.getItemNbr()) { // TODO should this be equiv?
					Element equivEl = imElement.addElement("equiv");
					equivEl.addAttribute("itemNbrEquiv", Integer.toString(iime.getId().getItemNbrEquiv()));
				}
			}

			for (IcItemCustSubst subst : data.getIcItemCustsSubsts()) {
				Element substEl = imElement.addElement("custSubst");
				int custNbr = subst.getOeCustMast().getNaOrg().getOrgNbr();
				substEl.addAttribute("custNbr", asString(custNbr));
				int substItemNbr = subst.getId().getItemNbrSubst();
				substEl.addAttribute("substItem", asString(substItemNbr));
			}
		}
	}

	private void emitFcstGrps() {
		Element el = root.addElement("fcstGrps");
		Map<String,FcstGrp> fcstGrps =  data.getReferencedFcstGrpById();
		logger.debug("fcstGrps.size() " + fcstGrps.size());
		for (String fcstGrpId : fcstGrps.keySet()) {
			Element gel = el.addElement("fcstGrp");
			FcstGrp fg = fcstGrps.get(fcstGrpId);
			gel.addAttribute("fcstGrpCd", fg.getFcstGrp());
			gel.addAttribute("fcstGrpDescr", fg.getFcstGrpDescr());
		}
	}

	/**
	 * @todo clean this up, it is a quick and dirty cut and paste.
	 * 
	 */
	private void addAllocations() {
		addAllocations(AllocationMode.FIRST_PASS);
		addAllocations(AllocationMode.CUSTOMER_PRIORITIZED);
	}

	private void addAllocations(AllocationMode mode) {
		String allocationLabel = null;

		switch (mode) {
		case FIRST_PASS:
			allocationLabel = "initialAllocations";
			break;
		case CUSTOMER_PRIORITIZED:
			allocationLabel = "allocations";
			break;
		default:
			throw new IllegalArgumentException("unsupported mode " + mode);

		}
		Element allocationsElement = root.addElement(allocationLabel);
		for (Supply supply : supplyMap.values()) {
			for (Allocation allocation : supply.getAllocations(mode)) {
				Element el = allocationsElement.addElement("allocation");
				el.addAttribute(splyXmlId, supply.getIdentifierString());
				el.addAttribute(dmdXmlId, allocation.getDemand().getIdentifierString());
				el.addAttribute("allocQty", allocation.getAllocQty().toString());
				Date availDt = supply.getAvailDate();
				Date dmdDt = allocation.getDemand().getNeedByDate();
				Date allocationDate = availDt.after(dmdDt) ? availDt : dmdDt;
				el.addAttribute(allocationBucket, getBucket(allocationDate));
			}
		}

	}

	private void addCertifications() {
		Element attrCertsElement = root.addElement("attributeCerts");
		for (IcCertCd cert : data.getApplicableCertifications(supplyList)) {
			Element el = attrCertsElement.addElement("attributeCert");
			el.addAttribute("cd", cert.getCertCd());
			el.addAttribute("descr", cert.getCertCdDescr());
			el.addAttribute("value", Integer.toString(cert.getCertValue()));
		}
	}


	private String asString(int in) {
		return String.format("%d",in);
	}

	private String formatDate(Date date) {
		return sdf.format(date);

	}

	private Element  emitSupply(Element toElement, Supply supply) {
		Element el = toElement.addElement("supply");
		el.addAttribute("pk", supply.getId());
		el.addAttribute(splyXmlId, supply.getIdentifierString());
		el.addAttribute("splyId", supply.getId());
		el.addAttribute("itemNbr", asString(supply.getItemNbr()));
		el.addAttribute("itemCd", supply.getIcItemMast().getItemCd());
		el.addAttribute("grossQty ", supply.getGrossAvailQty().toString());
		el.addAttribute("qtyAllocated", Double.toString(supply.getQtyAllocated(AllocationMode.FIRST_PASS)));
		double unalloc = supply.getGrossAvailQty().doubleValue() - supply.getQtyAllocated(AllocationMode.FIRST_PASS);

		el.addAttribute("qtyUnallocated", String.format("%8.3f",unalloc));
		el.addAttribute("facility", supply.getFacility());
		el.addAttribute("apsSplySubPoolNbr", Integer.toString(supply.getApsSplySubPoolNbr()));
		el.addAttribute("poolCd", supply.getApsSplyPool().getApsSplyPoolCd());
		el.addAttribute("subPoolCd", supply.getApsSplySubPool().getApsSplySubPoolCd());
		el.addAttribute("lotCost", supply.getLotCost().toString());
		double extLotCost = supply.getLotCost().doubleValue() * supply.getGrossAvailQty().doubleValue();
		el.addAttribute("extLotCost", String.format("%f",extLotCost));

		Date  availDt  = supply.getAvailDate();
		el.addAttribute("availDt", formatDate(supply.getAvailDate()));
		Date adjAvailDt=supply.getAdjustedAvailDate();
		if (adjAvailDt != null) {
			el.addAttribute("adjAvailDt", formatDate(supply.getAdjustedAvailDate()));
		}
		Date bucketDate = adjAvailDt  != null ?  adjAvailDt : availDt;
		String availDtBucket = getBucket(bucketDate);
		ArrayList<Supply> supplyBucket = intervalBucketedSupply.get(availDtBucket);
		if (supplyBucket == null) {
			supplyBucket = new ArrayList<Supply>();
			intervalBucketedSupply.put(availDtBucket, supplyBucket);
		}
		supplyBucket.add(supply);
		el.addAttribute("availDtBucket", availDtBucket);
		// TODO restore after allocating
		//			if (supply.getMinimumDemandDate() != null) {
		//				el.addAttribute("earliestDmdBucket", getBucket(supply.getMinimumDemandDate()));
		//			}
		el.addAttribute("cntryOrig", supply.getCntryCdOrigin());
		el.addAttribute("type", supply.getSupplyType().toString());
		// TODO rrestore
		//el.addAttribute("xferOut", Double.toString(supply.getPlannedTransferOutQty()));
		//			Collection<IcItemRevLvl> revisions = data.getIcItemRevLvls();
		//			for (IcItemRevLvl revision : revisions) {
		//				Element revisionEl = el.addElement("revision");
		//				revisionEl.addAttribute("itemNbr", asString(revision.getIcItemMast().getItemNbr()));
		//				//	TODO		revisionEl.addAttribute("revLvl", revision.getRevLvl());
		//			}

		//			if (supply.getPlannedTransferNbr() != null) {
		//				el.addAttribute("xfrNbr", supply.getPlannedTransferNbr().toString());
		//			}
		if (supply.getManufacturerCode() != null) {
			el.addAttribute("mfr",supply.getManufacturerCode());
		}
		return el;

	}
	/**
	 * @todo delete "xmlId" attribute names
	 * 
	 */
	private void emitSupplies(Element toElement, Collection<Supply> supplies) {
		//Map<String, Supply> suppliesById =  data.getSuppliesById();
		//Element supplyElement = root.addElement("supplies");
		for (Supply supply : supplies) {
			emitSupply(toElement,supply);
		}
		//			
		//			Element el = toElement.addElement("supply");
		//			el.addAttribute("pk", supply.getId());
		//			el.addAttribute(splyXmlId, supply.getIdentifierString());
		//			el.addAttribute("splyId", supply.getId());
		//			el.addAttribute("itemNbr", asString(supply.getItemNbr()));
		//			el.addAttribute("grossQty ", supply.getGrossAvailQty().toString());
		//			el.addAttribute("qtyAllocated", Double.toString(supply.getQtyAllocated(AllocationMode.FIRST_PASS)));
		//			double unalloc = supply.getGrossAvailQty().doubleValue() - supply.getQtyAllocated(AllocationMode.FIRST_PASS);
		//			
		//			el.addAttribute("qtyUnallocated", String.format("%8.3f",unalloc));
		//			el.addAttribute("facility", supply.getFacility());
		//			el.addAttribute("apsSplySubPoolNbr", Integer.toString(supply.getApsSplySubPoolNbr()));
		//			el.addAttribute("poolCd", supply.getApsSplyPool().getApsSplyPoolCd());
		//			el.addAttribute("subPoolCd", supply.getApsSplySubPool().getApsSplySubPoolCd());
		//			el.addAttribute("lotCost", supply.getLotCost().toString());
		//			double extLotCost = supply.getLotCost().doubleValue() * supply.getGrossAvailQty().doubleValue();
		//			el.addAttribute("extLotCost", String.format("%f",extLotCost));
		//
		//			Date  availDt  = supply.getAvailDate();
		//				el.addAttribute("availDt", formatDate(supply.getAvailDate()));
		//			Date adjAvailDt=supply.getAdjustedAvailDate();
		//			if (adjAvailDt != null) {
		//				el.addAttribute("adjAvailDt", formatDate(supply.getAdjustedAvailDate()));
		//			}
		//			Date bucketDate = adjAvailDt  != null ?  adjAvailDt : availDt;
		//			String availDtBucket = getBucket(bucketDate);
		//			ArrayList<Supply> supplyBucket = intervalBucketedSupply.get(availDtBucket);
		//			if (supplyBucket == null) {
		//				supplyBucket = new ArrayList<Supply>();
		//				intervalBucketedSupply.put(availDtBucket, supplyBucket);
		//			}
		//			supplyBucket.add(supply);
		//			el.addAttribute("availDtBucket", availDtBucket);
		//			// TODO restore after allocating
		////			if (supply.getMinimumDemandDate() != null) {
		////				el.addAttribute("earliestDmdBucket", getBucket(supply.getMinimumDemandDate()));
		////			}
		//			el.addAttribute("cntryOrig", supply.getCntryCdOrigin());
		//			el.addAttribute("type", supply.getSupplyType().toString());
		//			// TODO rrestore
		//			//el.addAttribute("xferOut", Double.toString(supply.getPlannedTransferOutQty()));
		////			Collection<IcItemRevLvl> revisions = data.getIcItemRevLvls();
		////			for (IcItemRevLvl revision : revisions) {
		////				Element revisionEl = el.addElement("revision");
		////				revisionEl.addAttribute("itemNbr", asString(revision.getIcItemMast().getItemNbr()));
		////				//	TODO		revisionEl.addAttribute("revLvl", revision.getRevLvl());
		////			}
		//
		////			if (supply.getPlannedTransferNbr() != null) {
		////				el.addAttribute("xfrNbr", supply.getPlannedTransferNbr().toString());
		////			}
		//			if (supply.getManufacturerCode() != null) {
		//				el.addAttribute("mfr",supply.getManufacturerCode());
		//			}
		//			
		//			// certs
		////			Collection <IcLotMastCert> certs = supply.getCertifications();
		////			if (certs != null) {
		////				// Element certsElement = el.addElement("attributes");
		////				for (IcLotMastCert cert : certs) {
		////					Element certEl = el.addElement("attribute");
		////					certEl.addAttribute("id", cert.getIcCertCd().getCertCd());
		////					certEl.addAttribute("status", cert.getIcCertCd().getStatId());
		////				}
		////			}
		//		}
	}


	private void emitPrioritizedDemands() {
		Element pdElement = root.addElement("prioritizedDemands");
		for (Demand demand : data.getPrioritizedDemands().values()) {
			Element demandElement = pdElement.addElement("demand");
			demandElement.addAttribute(dmdXmlId, demand.getDmdCd());
			demandElement.addAttribute("type", demand.getDmdTypeCd());
			//demandElement.addAttribute("pk", demand.getIdentifier());  // this used to be primary key TODO chec
			demandElement.addAttribute("rqstDate", formatDate(demand.getNeedByDate()));
			demandElement.addAttribute("rqstDateBucket", getBucket(demand.getNeedByDate()));
			demandElement.addAttribute("itemOrdered", asString(demand.getItemNbrDmd()));
			demandElement.addAttribute("itemCd", demand.getIcItemMast().getItemCd());
			NaOrg mfrRqst = demand.getNaOrgMfrRqst();
			if (mfrRqst != null) {
				demandElement.addAttribute("mfr", mfrRqst.getOrgCd());
			}
			demandElement.addAttribute("custCd", demand.getOrgCdCust());
			demandElement.addAttribute("orgNbrCust", asString(demand.getOrgNbrCust()));
			demandElement.addAttribute("qtyOrd", demand.getOpenQty().toString());
			demandElement.addAttribute("fcstGrp", demand.getFcstGrp());
			demandElement.addAttribute("srcRuleSetCd", demand.getApsSrcRuleSet().getApsSrcRuleSetCd());
			demandElement.addAttribute("priorityCd", demand.getPriorityCode());
			demandElement.addAttribute("withinLeadTime", demand.getWithinLeadTime() ? "true" : "false");
			demandElement.addAttribute("customerPriority", demand.getPriorityWithinCustomer());
			if (demand instanceof DemandCustomer) {
				DemandCustomer dc = (DemandCustomer) demand;
				String cntryOfOrigin = dc.getCntryCdOrigin();
				if (cntryOfOrigin != null) {
					demandElement.addAttribute("cntryOrigin", demand.getCntryCdOrigin());
				}
			}
			demandElement.addAttribute("revLvl", demand.getRevLvl());
			if (demand.getEndLeadTime() != null) {
				demandElement.addAttribute("endLeadTime", demand.getEndLeadTime().toString());
			}
			String needDtBucket = getBucket(demand.getNeedByDate());
			ArrayList<Demand> demandBucket = intervalBucketedDemand.get(needDtBucket);
			if (demandBucket == null) {
				demandBucket = new ArrayList<Demand>();
				intervalBucketedDemand.put(needDtBucket, demandBucket);
			}
			demandBucket.add(demand);

			demandElement.addAttribute("unAlloc", Double.toString(demand.getQuantityUnallocated(AllocationMode.FIRST_PASS)));
			demandElement.addAttribute("onTimeQty", Double.toString(demand.getOnTimeQty(AllocationMode.FIRST_PASS)));
			demandElement.addAttribute("totalAlloc", Double.toString(demand.getAllocatedQty(AllocationMode.FIRST_PASS)));
			//		addSwizzle(demand, demandElement);
			List<IcCertCd> certs = demand.getIcCertCds();
			if (certs != null) {
				for (IcCertCd cert : certs) {
					Element certsElement = demandElement.addElement("attributes");
					String certCd = cert.getCertCd();
					Element certEl = certsElement.addElement("attribute");
					certEl.addAttribute("id", certCd);

				}
			}
			addEligibleSupplies(demandElement, demand);
			// TODO restore after customer prioritization 
			//			addAvailableSupplies(demandElement, demand);
			//			addIneligibleSupplies(demandElement, demand);
		}
	}

	/**
	 * Report differences in allocation due to customer prioritization.
	 * @see Allocator
	 * @param demand the data source
	 * @param demandElement the Xml Element to which this information is to be attached.
	 */
	private void addSwizzle(Demand demand, Element demandElement) {
		java.util.Date firstPass = demand.getAvailDt(AllocationMode.FIRST_PASS);
		java.util.Date prioritizedPass = demand.getAvailDt(AllocationMode.CUSTOMER_PRIORITIZED);

		int comparison = -2;
		if (firstPass != null && prioritizedPass != null) {
			comparison = prioritizedPass.compareTo(firstPass);
		}
		if (firstPass == null && prioritizedPass != null) {
			comparison = -1;
		}
		if (firstPass != null && prioritizedPass == null) {
			comparison = 1;
		}
		String label = "swizzle";
		if (comparison < 0) {
			demandElement.addAttribute(label, "improve");
		} else if (comparison == 0) {
			demandElement.addAttribute(label, "no effect");
		} else if (comparison == 1) {
			demandElement.addAttribute(label, "degrade");
		} else {
			logger.warn("swizzle status indeterminate");
		}
	}

	private void addAvailableSupplies(Element demandElement, Demand demand) {
		List<EligibleSupply> eligibleSupplies = demand.getCustomerEligibleSupplies();
		Element eligiblesElement = demandElement.addElement("availableSupply");
		for (EligibleSupply es : eligibleSupplies) {
			Element supplyElement = eligiblesElement.addElement("supply");
			Supply supply = es.getSupply();
			supplyElement.addAttribute(splyXmlId, supply.getIdentifierString());
		}
	}

	private void addEligibleSupplies(Element demandElement, Demand demand) {
		EligibleSupplies eligibleSupplies = demand.getEligibleSupplies();
		Map<String,Allocation>  allocationBySupplyId = demand.getAllocationBySupplyXmlId();
		TreeMap<String, EligibleSupply> prioritizedSupply  = eligibleSupplies.getPrioritizedSupply();
		if (prioritizedSupply == null)  {
			throw new PlanningDataException("prioritizedSupply is  null for demand " + demand.toString());
		}
		Element eligiblesElement = demandElement.addElement("eligibleSupply");
		for (String key : prioritizedSupply.keySet()) {
			Element supplyElement = eligiblesElement.addElement("supply");
			// TODO  dedupe
			EligibleSupply  eligible = prioritizedSupply.get(key);
			Allocation allocation = allocationBySupplyId.get(eligible.getSupply().getSupplyIdentifier());
			Supply supply = eligible.getSupply();
			//			Element supplyElement = emitSupply(eligiblesElement,supply);
			//			Element supplyElement = eligiblesElement.addElement("supply");
			//			supplyElement.addAttribute(splyXmlId, supply.getSupplyIdentifier());
			//			supplyElement.addAttribute("type", supply.getSupplyType().toString());
			//			supplyElement.addAttribute("facility", supply.getFacility());
			//			supplyElement.addAttribute("subPool",supply.getApsSplySubPool().getApsSplySubPoolCd());
			//			supplyElement.addAttribute("grossQty ",String.format("%f",supply.getGrossAvailQty().doubleValue()));
			//			supplyElement.addAttribute("availDate ",formatDate(supply.getAvailDate()));
			//			if (allocation != null) {
			//				supplyElement.addAttribute("allocatedQty ",String.format("%f",allocation.getAllocQty()));
			//			}
			//			supplyElement.addAttribute("cntryCdOrigin", supply.getCntryCdOrigin());
			//			supplyElement.addAttribute("mfrCd",supply.getManufacturerCode());
			//			supplyElement.addAttribute("certValue",String.format("%d",supply.getCertValue()));
			//			//  TODO show allocated
			supplyElement.addAttribute("splyXmlId",supply.getSupplyIdentifier());
			if (allocation != null) {
				supplyElement.addAttribute("allocatedQty ",String.format("%f",allocation.getAllocQty()));
			}
		}
	}

	private void addIneligibleSupplies(Element demandElement, Demand demand) {

		Map<Supply, Set<SupplyEligibilityTest>> ineligibleSupplies = demand.getIneligibleSupplies();
		if (ineligibleSupplies.size() > 0) {
			Element inel = demandElement.addElement("ineligible");

			for (Supply ineligibleSupply : ineligibleSupplies.keySet()) {
				Element supplyElement = inel.addElement("supply");
				supplyElement.addAttribute(splyXmlId, ineligibleSupply.getIdentifierString());
				for (SupplyEligibilityTest test : ineligibleSupplies.get(ineligibleSupply))  {
					String testName = test.getClass().getSimpleName();
					Element testElement = supplyElement.addElement("test");
					testElement.addAttribute("testname",testName);
				}
			}
		}
	}


	private void addFlag(Element el, String label, String flagFilter, String flagValue) {
		if (flagValue.equals(flagFilter)) {
			el.addAttribute(label, flagValue);
		}
	}

	private void addFlag(Element el, String label, boolean flagFilter , boolean flagValue) {
		if (flagValue == flagFilter) {
			el.addAttribute(label, flagValue ? "true" : "false");
		}
	}

	private String getIdNbr() {
		if (idNbr < 10) {
			return "00" + idNbr++;
		}
		if (idNbr < 100) {
			return "0" + idNbr++;
		}
		return Integer.toString(idNbr++);
	}

	private String rotateText(String text) {
		StringBuffer buff = new StringBuffer();
		for (int i = 0; i < text.length(); i++) {
			char c = text.charAt(i);
			if (c == ' ') {
				buff.append("&nbsp;");
			} else {
				buff.append(text.charAt(i));
			}
			buff.append("<br/>");
		}
		return buff.toString();
	}


	Date getMaxDate() {
		Date maxDate = new Date();
		for (SupplyReplen po : data.getSupplyReplenById().values()) {
			if (po.getAvailDt().after(maxDate)) {
				maxDate = po.getAvailDate();
			}
		}
		return maxDate;
	}

	private void buildBuckets() {
		java.util.Date firstDayThisMonth = DateHelper.getFirstDateInMonth(data.getEffectiveDate());
		Date maxDate = getMaxDate();
		int monthsBetween = DateUtils.monthsBetween(firstDayThisMonth, maxDate);
		buckets = new DateGenerator();
		buckets.setFirstDate(firstDayThisMonth);
		buckets.setIncrementInMonths(1);
		buckets.generateBuckets(monthsBetween + 1);
		dateBuckets = new ArrayList<Date>();
		for (Iterator<Date> dateIterator = buckets.getDateIterator(); dateIterator.hasNext();) {
			Date dt = dateIterator.next();
			dateBuckets.add(dt);
		}
	}

	private Collection<String> getBucketNames() {
		ArrayList<String> returnValue = new ArrayList<String>();
		returnValue.add(beforeBucketName);
		for (Date bucket : buckets.getDays()) {
			returnValue.add(DateHelper.toYyMmDd(bucket));
		}
		returnValue.add(afterBucketName);
		return returnValue;
	}

	private String getBucket(java.util.Date date) {
		String retval;
		int domain = buckets.getBucketDomain(date);
		switch (domain) {
		case -1:
			retval = beforeBucketName;
			break;
		case 0:
			Date bucketDate = buckets.getBucketDate(date);
			retval = DateHelper.toYyMmDd(bucketDate);
			break;
		case 1:
			retval = afterBucketName;
			break;
		default:
			throw new IllegalStateException("unknown bucket error");
		}
		return retval;
	}

	private void addCustomerItemManufacturerRules() {
		if (customerItemManufacturerRules.getRules().size() > 0) {
			//
			Element mfrRuleElement = root.addElement("customerItemManufacturerRules");

			Element cimCustCdsElement = mfrRuleElement.addElement("cimCustCds");
			for (String custCd : customerItemManufacturerRules.getDistinctCustCd()) {
				Element cimCustCdElement = cimCustCdsElement.addElement("custCd").addAttribute("custCd",custCd);
			}

			Element cimMfrCdsElement = mfrRuleElement.addElement("cimMfrCds");
			for (String mfrCd : customerItemManufacturerRules.getDistinctMfrCd()) {
				cimMfrCdsElement.addElement("mfrCd").addAttribute("mfrCd",mfrCd);
			}



			for (OeCustMfr rule : customerItemManufacturerRules.getRules().values()) {

				Element cimElement = mfrRuleElement.addElement("customerItemMfr");

				cimElement.addAttribute("custCd", 	rule.getOeCustMast().getNaOrg().getOrgCd());
				cimElement.addAttribute("itemNbr",Integer.toString(rule.getIcItemMast().getItemNbr()));
				cimElement.addAttribute("itemCd", rule.getIcItemMast().getItemCd());
				int mfrNbr = rule.getId().getOrgNbrMfr();
				String mfrCd = data.getNaOrg(mfrNbr).getOrgCd();
				cimElement.addAttribute("mfrCd", mfrCd);
				if ("I".equals(rule.getMfrRestrictId())) {
					cimElement.addAttribute("ruleType", "approved");
				} else {
					cimElement.addAttribute("ruleType", "blacklisted");
				}
			}
		}
	}

	private void addProjectedPosition() {
		Element elp = root.addElement("projectedPositions");

		double projectedPosition = 0;

		for (String bucketNm : getBucketNames()) {
			Element el = elp.addElement("projectedPosition");
			el.addAttribute("positionBucket", bucketNm);
			double dmdSum = 0;
			ArrayList<Demand> demands = intervalBucketedDemand.get(bucketNm);
			if (demands != null) {
				for (Demand demand : demands) {
					dmdSum += demand.getOpenQty().doubleValue();
				}
			}
			el.addAttribute("dmdSum", Double.toString(dmdSum));

			double splySum = 0;
			ArrayList<Supply> supplies = intervalBucketedSupply.get(bucketNm);
			if (supplies != null) {
				for (Supply supply : supplies) {
					splySum += supply.getGrossAvailQty().doubleValue();
				}
			}
			el.addAttribute("splySum", Double.toString(splySum));
			projectedPosition += splySum;
			projectedPosition -= dmdSum;
			el.addAttribute("projPos", Double.toString(projectedPosition));
		}

	}

	private void emitBuckets() {
		Element elp = root.addElement("buckets");
		Element el = elp.addElement("bucket");
		el.addAttribute("nm", beforeBucketName);
		for (Date d : dateBuckets) {
			el = elp.addElement("bucket");
			el.addAttribute("nm", DateHelper.toYyMmDd(d));
		}
		el = elp.addElement("bucket");
		el.addAttribute("nm", afterBucketName);

	}

	public void emitSourcingRules() {
		Element elp = root.addElement("apsSrcRuleSets");
		TreeMap<String,ApsSrcRuleSetExt> ruleSets =  data.getReferencedSourcingRuleSets();
		for (ApsSrcRuleSetExt set : ruleSets.values()) {
			Element esrs = elp.addElement("apsSrcRuleSet");
			esrs.addAttribute("srcRuleSetCd",set.getApsSrcRuleSetCd());
			esrs.addAttribute("descr",set.getApsSrcRuleSetDescr());
			String asreString = null;
			for (ApsSrcRule rule : set.getPrioritizedRules().values()) {
				Element asre = esrs.addElement("apsSrcRule");
				asre.addAttribute("apsSrcRuleNbr",Integer.toString(rule.getApsSrcRuleNbr()));
				asre.addAttribute("facility",rule.getFacility());
				asre.addAttribute("poolCd",rule.getApsSplySubPool().getApsSplyPoolCd());
				asre.addAttribute("subPoolCd",rule.getApsSplySubPool().getApsSplySubPoolCd());
				asre.addAttribute("supplyType",rule.getSplyTypeId());
				asre.addAttribute("priority",Integer.toString(rule.getSrcPrty()));
				asreString = asre.toString();
				logger.info(asreString);
			}
			logger.info("esrs:\n" + elementToString(esrs));
		}
		logger.info(elementToString(elp));
		logger.info("root:\n" + elementToString(root)); 
	}

	void emitFcItemMasts() {
		Collection<FcItemMast> fcItemMasts = data.getFcItemMastById().values();
		Element elp = root.addElement("fcItemMasts");
		for (FcItemMast fim : fcItemMasts) {
			Element fimel = elp.addElement("fcItemMast");
			fimel.addAttribute("fcItemMastNbr",Integer.toString(fim.getFcItemMastNbr()));
			fimel.addAttribute("itemNbr",Integer.toString(fim.getItemNbr()));
			fimel.addAttribute("fcItemMastDescr",fim.getFcItemMastDescr());
			//			fimel.addAttribute("custCd",fim.getOeCustMast().getNaOrg().getOrgCd());;
			fimel.addAttribute("fcstGrp",fim.getFcstGrp());
			//fimel.addAttribute("fcstGrpDescr",fim.getFcstGrp().getFcstGrpDescr());
		}
	}

	void addAttribute(Element el, String attributeName, Object value) {
		if (value != null) {
			String payload = null;
			if (java.util.Date.class.isAssignableFrom(value.getClass())) {
				payload = formatDate((Date) value); 
			}
			if (java.lang.Number.class.isAssignableFrom(value.getClass())) {
				payload = value.toString();
			}
			if (java.lang.String.class.isAssignableFrom(value.getClass())) {
				payload = (String) value;
			}
			el.addAttribute(attributeName,payload);
		}

	}

	void emitVqQteVw() {
		Element elp = root.addElement("vqQteVws");
		for (VqQteVw r : data.getVqQteVws()) {
			Element el = elp.addElement("vqQteVw");
			addAttribute(el,"vqQteHdrnbr",r.getVqQteHdrNbr());
			addAttribute(el,"vqQteCd",r.getVqQteCd());
			addAttribute(el,"orgNbrVnd",r.getOrgNbrVnd());
			addAttribute(el,"vqQteCd",r.getVqQteCd());
			addAttribute(el,"orgNbrVnd",r.getOrgNbrVnd());
			addAttribute(el,"vqQteDt",formatDate(r.getVqQteDt()));
			addAttribute(el,"orgCd",r.getOrgCd());
			addAttribute(el,"orgNm",r.getOrgNm());
			addAttribute(el,"currCdQte",r.getCurrCdQte());
			addAttribute(el,"indivNmSpokenTo",r.getIndivNmSpokenTo());
			addAttribute(el,"vqQteEffDt",formatDate(r.getVqQteEffDt()));
			addAttribute(el,"vqQteExpDt",formatDate(r.getVqQteExpDt()));
			addAttribute(el,"vndQteRefCd",r.getVndQteRefCd());
			addAttribute(el,"vqQteIndivNbr",Integer.toString(r.getVqQteIndivNbr()));
			addAttribute(el,"transmitFlg",r.getTransmitFlg());
			addAttribute(el,"vqQteDtlNbr",Integer.toString(r.getVqQteDtlNbr()));
			addAttribute(el,"itemNbrQte",Integer.toString(r.getItemNbrQte()));
			addAttribute(el,"itemCdQte",r.getItemCdQte());
			addAttribute(el,"itemCdVnd",r.getItemCdVnd());
			addAttribute(el,"qteUm",r.getQteUm());
			addAttribute(el,"qteQty",r.getQteQty());
			addAttribute(el,"qteQtyStkUm",r.getQteQtyStkUm());
			addAttribute(el,"qteCost",r.getQteCost());
			addAttribute(el,"qteCostDenom",r.getQteCostDenom());
			addAttribute(el,"qteCostStkUm",r.getQteCostStkUm());
			addAttribute(el,"qteCostDenomStkUm",r.getQteCostDenomStkUm());
			addAttribute(el,"orgNbrMfrRqst",r.getOrgNbrMfrRqst());
			addAttribute(el,"revLvl",r.getRevLvl());
			addAttribute(el,"rqstDt",r.getRqstDt());
			addAttribute(el,"leadTmWkProm",r.getLeadTmWkProm());
			addAttribute(el,"promDt",r.getPromDt());
			addAttribute(el,"vqLostCd",r.getVqLostCd());
			addAttribute(el,"vqQteDt",r.getVqQteDt());
			addAttribute(el,"orgCd",r.getOrgCd());
			addAttribute(el,"orgNm",r.getOrgNm());
			addAttribute(el,"currCdQte",r.getCurrCdQte());
			addAttribute(el,"indivNmSpokenTo",r.getIndivNmSpokenTo());
			addAttribute(el,"indivPhnNbr",r.getIndivPhnNbr());
			addAttribute(el,"indivFaxNbr",r.getIndivFaxNbr());
			addAttribute(el,"vqQteEffDt",formatDate(r.getVqQteEffDt()));
			addAttribute(el,"vqQteExpDt",formatDate(r.getVqQteExpDt()));
			addAttribute(el,"vndQteRefCd",r.getVndQteRefCd());
			addAttribute(el,"vqQteIndivNbr",r.getVqQteIndivNbr());
			addAttribute(el,"transmitFlg",r.getTransmitFlg());
			addAttribute(el,"vqQteDtlNbr",r.getVqQteDtlNbr());
			addAttribute(el,"orgNbrMfrRqst",r.getOrgNbrMfrRqst());
			addAttribute(el,"leadTmWkProm",r.getLeadTmWkProm());
			addAttribute(el,"vqLostCd",r.getVqLostCd());
		}
	}

	void emitOeOrdDtlHists() {
		Element elp = root.addElement("oeOrdDtlHists");
		for (OeOrdDtlHist r : data.getOeOrdDtlHists()) {
			Element el = elp.addElement("oeOrdDtlHist");
			addAttribute(el,"oeOrdHdrNbr",	r.getOeOrdHdrNbr());
			addAttribute(el,"ordDt",	r.getOrdDt());
			addAttribute(el,"ordStatId",	r.getOrdStatId());
			addAttribute(el,"orgNbrCust",	r.getOrgNbrCust());
			addAttribute(el,"orgCdCust",	r.getOrgCdCust());
			addAttribute(el,"custPoCd",	r.getCustPoCd());
			addAttribute(el,"custPoDt",	r.getCustPoDt());
			addAttribute(el,"fobCd",	r.getFobCd());
			addAttribute(el,"currCd",	r.getCurrCd());
			addAttribute(el,"trdFlg",	r.getTrdFlg());
			addAttribute(el,"ordTypeCd",	r.getOrdTypeCd());
			addAttribute(el,"ordCd",	r.getOrdCd());
			addAttribute(el,"salesTerrCd",	r.getSalesTerrCd());
			addAttribute(el,"transmitFlg",	r.getTransmitFlg());
			addAttribute(el,"lineNbr",	r.getLineNbr());
			addAttribute(el,"custLineCd",	r.getCustLineCd());
			addAttribute(el,"itemNbrRQst",	r.getItemNbrRqst());
			addAttribute(el,"itemNbrOrd",	r.getItemNbrOrd());
			addAttribute(el,"qtyOrd",	r.getQtyOrd());
			addAttribute(el,"qtyOrdStkUm",	r.getQtyOrdStkUm());
			addAttribute(el,"sellUm",	r.getSellUm());
			addAttribute(el,"rqstDt",	r.getRqstDt());
			addAttribute(el,"shipToAddrNbr",	r.getShipToAddrNbr());
			addAttribute(el,"promDtOrig",	r.getPromDtOrig());
			addAttribute(el,"promDtCurr",	r.getPromDtCurr());
			addAttribute(el,"unitPriceSellUm",	r.getUnitPriceSellUm());
			addAttribute(el,"unitPriceDenomSellUm",	r.getUnitPriceDenomSellUm());
			addAttribute(el,"unitPriceStkUm",	r.getUnitPriceStkUm());
			addAttribute(el,"unitPriceDenomStkUm",	r.getUnitPriceDenomStkUm());
			addAttribute(el,"itemCdCust",	r.getItemCdCust());
			addAttribute(el,"apsSrcRuleSetNbr",	r.getApsSrcRuleSetNbr());
			addAttribute(el,"orgNbrMfrRqst",	r.getOrgNbrMfrRqst());
			addAttribute(el,"lotNotExpireBeforeDt",	r.getLotNotExpireBeforeDt());
			addAttribute(el,"lotManufactureAfterDt",	r.getLotManufactureAfterDt());
			addAttribute(el,"cntryCdOrigin",	r.getCntryCdOrigin());
			addAttribute(el,"revLvl",	r.getRevLvl());
			addAttribute(el,"shipViaCd",	r.getShipViaCd());
			addAttribute(el,"contractCd",	r.getContractCd());
			addAttribute(el,"custBinCd",	r.getCustBinCd());
			addAttribute(el,"qtyShip",	r.getQtyShip());
			addAttribute(el,"qtyShipStkUm",	r.getQtyShipStkUm());
			addAttribute(el,"qtyAlloc",	r.getQtyAlloc());
			addAttribute(el,"qtyAllocStkUm",	r.getQtyAllocStkUm());
			addAttribute(el,"partMismatchReasonCd",	r.getPartMismatchReasonCd());
			addAttribute(el,"custRef",	r.getCustRef());
			addAttribute(el,"shipFromFacility",	r.getShipFromFacility());
			addAttribute(el,"shipCmpltFlg",	r.getShipCmpltFlg());
			addAttribute(el,"hotFlg",	r.getHotFlg());
			addAttribute(el,"shipLinePct",	r.getShipLinePct());
			addAttribute(el,"cancelCd",	r.getCancelCd());
			addAttribute(el,"cancelDt",	r.getCancelDt());
			addAttribute(el,"oeOrdDtlNbr",	r.getOeOrdDtlNbr());
		}
	}

	void emitOeItemHistFcstGrps() {
		Element elp = root.addElement("oeItemHistFcstGrps");
		List<OeItemHistFcstGrp> h = data.getOeItemHistFcstGrps();
		if (h != null) {
		int count = h.size();
		logger.info("oeItemHistFcstGrps count is " + count);
		int i = 0;
		for (OeItemHistFcstGrp r : h) {
			logger.info("i " + i++ + " r "  + r);
			Element el = elp.addElement("oeItemHistFcstGrp");
			addAttribute(el,"itemNbrRqst",	r.getId().getItemNbrRqst());
			addAttribute(el,"itemCd",	r.getId().getItemCd());
			addAttribute(el,"fcstGrp",	r.getId().getFcstGrp());
			addAttribute(el,"ordDtMm",	r.getId().getOrdDtMm());
			addAttribute(el,"qtyOrdSum",	r.getQtyOrdSum());
		}
		
		}
	}

	public String elementToString(Element el)  {
		OutputFormat format = OutputFormat.createPrettyPrint();
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		OutputStreamWriter osw = new OutputStreamWriter(baos);
		BufferedWriter fwb = new BufferedWriter(osw);
		XMLWriter writer = new XMLWriter(fwb, format);
		try {
			writer.write(el);
			writer.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return baos.toString();
	}


}
