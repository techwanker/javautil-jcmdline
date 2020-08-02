package com.pacificdataservices.diamond.planning.data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

import org.javautil.buckets.DateHelper;
import org.javautil.util.Timer;
import org.javautil.hibernate.HibernateMarshallerFactory;
import org.javautil.properties.PropertyManager;
import org.javautil.text.SimpleDateFormats;
import org.javautil.util.DateGenerator;
import org.javautil.util.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.Gson;
import com.pacificdataservices.diamond.models.ApsAllocOnhandFc;
import com.pacificdataservices.diamond.models.ApsAllocOnhandOo;
import com.pacificdataservices.diamond.models.ApsAllocOnhandSs;
import com.pacificdataservices.diamond.models.ApsAllocOnhandWo;
import com.pacificdataservices.diamond.models.ApsAllocReplenFc;
import com.pacificdataservices.diamond.models.ApsAllocReplenOo;
import com.pacificdataservices.diamond.models.ApsAllocReplenSs;
import com.pacificdataservices.diamond.models.ApsAllocReplenWo;
import com.pacificdataservices.diamond.models.ApsAllocWoFc;
import com.pacificdataservices.diamond.models.ApsAllocWoOo;
import com.pacificdataservices.diamond.models.ApsAllocWoSs;
import com.pacificdataservices.diamond.models.ApsAllocWoWo;
import com.pacificdataservices.diamond.models.ApsAvailOnhand;
import com.pacificdataservices.diamond.models.ApsAvailReplen;
import com.pacificdataservices.diamond.models.ApsAvailWo;
//import com.pacificdataservices.diamond.models.ApsCustMfrVw;
import com.pacificdataservices.diamond.models.ApsDmdFc;
import com.pacificdataservices.diamond.models.ApsDmdOo;
import com.pacificdataservices.diamond.models.ApsDmdSs;
import com.pacificdataservices.diamond.models.ApsDmdWo;
import com.pacificdataservices.diamond.models.ApsItemGlobalSubst;
import com.pacificdataservices.diamond.models.ApsResultDtlDmd;
import com.pacificdataservices.diamond.models.ApsSplyPool;
import com.pacificdataservices.diamond.models.ApsSplySubPool;
import com.pacificdataservices.diamond.models.ApsSrcRule;
import com.pacificdataservices.diamond.models.ApsSrcRulePrimary;
import com.pacificdataservices.diamond.models.ApsSrcRuleSet;
import com.pacificdataservices.diamond.models.FcItemMast;
import com.pacificdataservices.diamond.models.FcstGrp;
import com.pacificdataservices.diamond.models.IcCertCd;
import com.pacificdataservices.diamond.models.IcItemCustSubst;
import com.pacificdataservices.diamond.models.IcItemMast;
import com.pacificdataservices.diamond.models.IcItemMastEquiv;
import com.pacificdataservices.diamond.models.IcItemRevLvl;
import com.pacificdataservices.diamond.models.IcLotMast;
import com.pacificdataservices.diamond.models.NaOrg;
import com.pacificdataservices.diamond.models.OeCustMast;
import com.pacificdataservices.diamond.models.OeCustMfr;
import com.pacificdataservices.diamond.models.OeItemHistFcstGrp;
import com.pacificdataservices.diamond.models.OeOrdDtlCert;
import com.pacificdataservices.diamond.models.OeOrdDtlHist;
import com.pacificdataservices.diamond.models.TmpItem;
import com.pacificdataservices.diamond.models.UtFacility;
import com.pacificdataservices.diamond.models.VqQteVw;
import com.pacificdataservices.diamond.planning.Allocation;
import com.pacificdataservices.diamond.planning.AllocationMode;
import com.pacificdataservices.diamond.planning.EligibleSupplies;
import com.pacificdataservices.diamond.planning.PlanningDataException;
import com.pacificdataservices.diamond.planning.StringBean;
import com.pacificdataservices.diamond.planning.container.ApsSrcRuleSetExt;
import com.pacificdataservices.diamond.planning.container.CustomerItemManufacturers;
import com.pacificdataservices.diamond.planning.demand.Demand;
import com.pacificdataservices.diamond.planning.demand.DemandCustomer;
import com.pacificdataservices.diamond.planning.demand.DemandForecast;
import com.pacificdataservices.diamond.planning.demand.DemandSafetyStock;
import com.pacificdataservices.diamond.planning.demand.DemandWorkOrder;
import com.pacificdataservices.diamond.planning.demand.ForecastGroups;
import com.pacificdataservices.diamond.planning.demand.OrderGroups;
import com.pacificdataservices.diamond.planning.marshall.GenerateMockData;
import com.pacificdataservices.diamond.planning.supply.Supply;
import com.pacificdataservices.diamond.planning.supply.SupplyOnhand;
import com.pacificdataservices.diamond.planning.supply.SupplyReplen;
import com.pacificdataservices.diamond.planning.supply.SupplyWorkOrder;
import com.pacificdataservices.diamond.rules.CustomerItemManufacturerRules;

/**
 * Everything necessary to plan a group of items is contained here.
 * 
 * This may be populated by a web service, xml or any other mechanism.
 * 
 * As this implementatio the data is populated by PlanningDataService.
 * 
 * It is expected that
 * 
 * @author jjs
 * 
 *         TODO make sure that a customer record exists for each customer demand
 *         *
 * 
 *         Note: FIXES.sql mods APS_SRC_RULE_SET
 * 
 */
public class PlanningData implements Serializable {
	transient ArrayList<Timer> timers = new ArrayList<>();
	transient public static final int INTEGRITY_INVALID = 1;
	transient public static final int INTEGRITY_UNCHECKED = -1;
	transient public static final int INTEGRITY_VALID = 0;

	
	private ForecastGroups forecastGroups;

	private int nextAllocationNumber;
	/**
	 * 
	 */
	private static final long serialVersionUID = -3110347699532651715L;


	/**
	 * All data that should be populated from the database are set to empty lists in
	 * case this is populated from another source and there is no corresponding
	 * data.
	 * 
	 * @return
	 */
	transient private Map<AllocationMode, List<Allocation>> allocations;
	private transient int allocToReplenWindow;
	// Input data
	// ###
	// ### Allocations
	// ###
	// Onhand Allocations
	private List<ApsAllocOnhandFc> apsAllocOnhandFcs;
	private List<ApsAllocOnhandOo> apsAllocOnhandOos;
	private List<ApsAllocOnhandSs> apsAllocOnhandSss;
	private List<ApsAllocOnhandWo> apsAllocOnhandWos;
	// Replenishment Allocations
	private List<ApsAllocReplenFc> apsAllocReplenFcs;
	private List<ApsAllocReplenOo> apsAllocReplenOos;
	private List<ApsAllocReplenSs> apsAllocReplenSss;
	private List<ApsAllocReplenWo> apsAllocReplenWos;
	// Work Order Allocations
	private List<ApsAllocWoFc> apsAllocWoFcs;
	private List<ApsAllocWoOo> apsAllocWoOos;
	private List<ApsAllocWoSs> apsAllocWoSss;
	private List<ApsAllocWoWo> apsAllocWoWos;
	// supplies
	private List<ApsAvailOnhand> apsAvailOnhands;
	transient private Map<Integer, ApsAvailReplen> apsAvailReplenById;

	private List<ApsAvailReplen> apsAvailReplens;
	private List<ApsAvailWo> apsAvailWos;
	// Demands
	private List<ApsDmdFc> apsDmdFcs;
	private List<ApsDmdOo> apsDmdOos;
	private List<ApsDmdSs> apsDmdSss;
	private List<ApsDmdWo> apsDmdWos;
	//
	private List<ApsItemGlobalSubst> apsItemGlobalSubsts;
	private ArrayList<ApsResultDtlDmd> apsResultDtlDmds;

	private TreeMap<String, ApsSplyPool> apsSplyPoolById;
	transient private TreeMap<Integer, ApsSplySubPool> apsSplySubPoolById;
	/**
	 * Aggregate Lists
	 */

	private Collection<ApsSplySubPool> apsSplySubPools;
	transient private TreeMap<Integer, ApsSrcRule> apsSrcRuleById;
	transient private TreeMap<Integer, ApsSrcRulePrimary> apsSrcRulePrimaryById;
//	private Collection<ApsSrcRulePrimary> apsSrcRulePrimarys;
	private Collection<ApsSrcRule> apsSrcRules;
	// private List<ApsSupply> apsSupplies;
	/**
	 * Maps
	 */

	transient private TreeMap<Integer, ApsSrcRuleSetExt> apsSrcRuleSetExtById;
	private Collection<ApsSrcRuleSet> apsSrcRuleSets;
	transient private CustomerItemManufacturerRules customerItemManufacturerRules = null;
	transient private CustomerItemManufacturers customerItemManufacturers;
	transient private ArrayList<Allocation> customerPrioritizedAllocations;
	// ## demands
//	transient private TreeMap<String, DemandCustomer> customerDemandsById;
	transient private TreeMap<Integer, DemandCustomer> demandCustomerById; // WTF? this is a dupe TODO
	transient private Map<String, DemandForecast> demandForecastById;
	transient private TreeMap<Integer, DemandSafetyStock> demandSafetyStockById;
	transient private TreeMap<Integer, ArrayList<DemandCustomer>> demandsByCustomer;
	transient private TreeMap<Integer, DemandWorkOrder> demandWorkOrderById;
	transient private List<Demand> demands;
	// ####################################################################################
	// Fetched Lists
	// ####################################################################################
	//
	// Supply
	//
	private Gson dillon = HibernateMarshallerFactory.getHibernateGsonWithProxyDateFormatter();
	transient private Date effectiveDate;
	transient private TreeMap<Integer, FcItemMast> fcItemMastById;
	private List<FcItemMast> fcItemMasts;

	transient private TreeMap<String, FcstGrp> fcstGrpById;

	private List<FcstGrp> fcstGrps;

	/**
	 * TODO should probably be a sub class of Supply
	 */
	transient private ArrayList<Allocation> firstPassAllocations;

	private PlanningDataGraphBuilder grapher = new PlanningDataGraphBuilder(this);

	transient private Map<String, IcCertCd> icCertCdById;
	private List<IcCertCd> icCertCds;
	private ArrayList<IcItemCustSubst> icCustItemSubsts;

	private List<IcItemCustSubst> icItemCustsSubsts;
	private List<IcItemMastEquiv> icItemMastEquivs;

//	private List<IcItemMast> icItemMasts;

	transient private TreeMap<Integer, IcItemMast> icItemMastsById;

	transient private Map<Integer, IcLotMast> icLotMastById;
	transient private ArrayList<String> integrityMessages;

//	transient private int integrityState = INTEGRITY_UNCHECKED;
	transient private Logger logger = LoggerFactory.getLogger(getClass());

	transient private boolean mapsAndReferencesBuilt = false;

	private Map<Integer, NaOrg> naOrgById;

	private Map<Integer, OeCustMast> oeCustMastById;

//	transient private Map<OeCustMfrId, OeCustMfr> oeCustMfrById;

	private List<OeCustMfr> oeCustMfrs;

	private List<OeOrdDtlCert> oeOrdDtlCerts;
	//
	// Rules
	//
	transient private Map<String, Supply> onhandById;
	transient private ArrayList<Allocation> overshipAllocations;
	transient private ArrayList<Allocation> pickRestoreAllocations;
	transient private ArrayList<Allocation> previousAllocations;
	transient private TreeMap<String, Demand> prioritizedDemands;
	transient private TreeSet<Demand> prioritizedDemandsWithinLeadTime;
	private StringBean stringBean = new StringBean();
	//
	// ## supplies
	//
	transient private List<Supply> supplies;
	transient private TreeMap<String, Supply> suppliesById;
	transient private TreeMap<String, SupplyOnhand> supplyOnhandById;

	transient private TreeMap<String, SupplyReplen> supplyReplenById;

	transient private TreeMap<String, SupplyWorkOrder> supplyWorkOrderById;
	//
	private List<TmpItem> tmpItems;
	transient private boolean trace = false;
//	transient private boolean traceFileSet;
	transient private SimpleDateFormat sdf = new SimpleDateFormat(SimpleDateFormats.ISO8601_date_pretty);
	//
	private List<UtFacility> utFacilities;
	private TreeMap<String, UtFacility> utFacilityById;

	private PlanningDataValidator validator = new PlanningDataValidator(this);

	transient private ArrayList<String> verificationMessages;
	private int planGrpNbr;
//	private int startingAllocationId;
	private Collection<Integer> itemNumbers;
	private List<VqQteVw> vqQteVws;
	private List<OeOrdDtlHist> oeOrdDtlHists;
	private int apsResultDtlDmdId;
	private List<OeItemHistFcstGrp> oeItemHistFcstGrps;
	private DateGenerator dateGenerator;
	private java.util.Date firstDayThisMonth;
//	private OrderBuckets orderBuckets;
	private OrderGroups orderGroups;
//	private List<IcMultipleCert> icMutipleCerts;
 	
//	private MultiKeyHashMapOfLists<IcMultipleCert> icMultipleCertsByLotNbr;
	private Map<Integer, ArrayList<Integer>> itemNbrsByLotNbr;
	
	transient private HashMap<Integer,List<Object>> missingOrgNbrs = new HashMap<>();
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static PlanningData getInitialized() {
		final ArrayList emptyList = new ArrayList();
		PlanningData pd = new PlanningData();
		pd.setApsAllocOnhandSss(emptyList); // TODO continue
		pd.setApsAllocOnhandFcs(new ArrayList<ApsAllocOnhandFc>());
		pd.setApsAllocOnhandOos(new ArrayList<ApsAllocOnhandOo>());
		pd.setApsAllocOnhandSss(new ArrayList());
		pd.setApsAllocOnhandWos(new ArrayList<ApsAllocOnhandWo>());
		pd.setApsAllocReplenFcs(new ArrayList<ApsAllocReplenFc>());
		pd.setApsAllocReplenOos(new ArrayList<ApsAllocReplenOo>());
		pd.setApsAllocReplenSss(new ArrayList<ApsAllocReplenSs>());
		pd.setApsAllocReplenWos(new ArrayList<ApsAllocReplenWo>());
		pd.setApsAllocWoFcs(new ArrayList<ApsAllocWoFc>());
		pd.setApsAllocWoOos(new ArrayList<ApsAllocWoOo>());
		pd.setApsAllocWoSss(new ArrayList<ApsAllocWoSs>());
		pd.setApsAllocWoWos(new ArrayList<ApsAllocWoWo>());

		pd.setApsAvailOnhands(new ArrayList<ApsAvailOnhand>());
		pd.setApsAvailReplens(new ArrayList<ApsAvailReplen>());
		pd.setApsAvailWos(new ArrayList<ApsAvailWo>());

		pd.setApsDmdFcs(emptyList);
		pd.setApsDmdWos(emptyList);
		pd.setApsDmdOos(emptyList);
		pd.setApsDmdSss(emptyList);
		//
		pd.setIcItemMastEquivs(new ArrayList<IcItemMastEquiv>());
		pd.setIcItemCustsSubsts(new ArrayList<IcItemCustSubst>());
		pd.setIcLotMasts(new ArrayList());
		// supplies
		pd.setApsSplySubPools(new ArrayList());
		pd.setOeOrdDtlCerts(new ArrayList<OeOrdDtlCert>());
		pd.setApsItemGlobalSubsts(new ArrayList<ApsItemGlobalSubst>());

		pd.setIcItemMasts(new ArrayList());
		pd.setFcstGrps(new ArrayList<FcstGrp>());
		pd.setApsSrcRuleSets(new ArrayList<ApsSrcRuleSet>());

		pd.setOeCustMasts(new ArrayList());
		return pd;

	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public void addCustomerPrioritizedAllocations(List<Allocation> allocations) {
		if (customerPrioritizedAllocations == null) {
			if (trace) {
				logger.debug("customerPrioritizedAllocations instantiated");
			}
			customerPrioritizedAllocations = new ArrayList<Allocation>();
		}
		customerPrioritizedAllocations.addAll(allocations);
	}

	public void addLots(Collection<IcLotMast> lots) {
		for (IcLotMast lot : lots) {
			icLotMastById.put(lot.getLotNbr(), lot);
		}
	}

	void assertSizes(Collection<?> col, Map<?,?> map) {
		if (col.size() != map.size()) {
			GenerateMockData mocker = new GenerateMockData();
			String colString = mocker.toJson(col);
			String message = "Collection size: " + col.size() + " map.size(): " + map.size() + "\n" + colString;
			Thread.dumpStack();
			logger.error(message);
			throw new PlanningDataException(message);
		}
	}

	public void buildMapsAndReferences() {
		grapher.process();
		if (missingOrgNbrs.size() > 0) {
			StringBuilder message =  new StringBuilder();
			for (Entry<Integer, List<Object>> e : missingOrgNbrs.entrySet()) {
				message.append("missing org: " + e.getKey() + " for " + e.getValue() + "\n");
				message.append("todo get missing orgs and rebuild");
			}
		}
	}

	public ArrayList<String> checkIntegrity() {
		return validator.checkIntegrity(true);
	}

	// *****************************************************************
	// references
	// *****************************************************************
	/**
	 * After all the data has been retrieved from a persistent store this should be
	 * called.
	 */

	void checkSumAlloc(Demand demand) {
		double allowable = 0.0001;
		double sumOfAllocations = 0.0;
		for (Allocation allocation : demand.getAllocations(AllocationMode.FIRST_PASS)) {
			sumOfAllocations += allocation.getAllocQty().doubleValue();
		}
		double diff = sumOfAllocations - demand.getQuantityAllocated(AllocationMode.FIRST_PASS);
		if (diff < 0) {
			diff *= -1;
		}
		if (diff > allowable) {
			throw new IllegalStateException(
					"sumOfAllocations: " + sumOfAllocations + " demand.getQtyAllocated(AllocationMode.FIRST_PASS) "
							+ demand.getQuantityAllocated(AllocationMode.FIRST_PASS) + " + > " + allowable);
		}
	}

	public String formatSourcingRules() {
		StringBuilder sb = new StringBuilder();
		sb.append("ApsSrcRuleSets.size(): " + apsSrcRuleSets.size() + "\n");
		for (ApsSrcRuleSet ruleSet : apsSrcRuleSets) {
			sb.append(stringBean.asString(ruleSet));
			sb.append("\n");
		}
		return sb.toString();
	}

	public Map<AllocationMode, List<Allocation>> getAllocations() {
		return allocations;
	}

	public ArrayList<Allocation> getAllocations(AllocationMode mode) {
		ArrayList<Allocation> retval = null;
		switch (mode) {
		case CUSTOMER_PRIORITIZED:
			retval = customerPrioritizedAllocations;
			break;
		case FIRST_PASS:
			retval = firstPassAllocations;
			break;
		case OVERSHIP:
			retval = overshipAllocations;
			break;
		case PICK_RESTORE:
			retval = pickRestoreAllocations;
		default:
			throw new IllegalStateException("Unknown mode");

		}
		if (retval == null) {
			throw new IllegalStateException("allocations not set for " + mode);
		}
		return retval;
	}

	public int getAllocToReplenWindow() {
		return allocToReplenWindow;
	}



	/**
	 * @param supplyList
	 * @todo move this somewhere
	 */
	public Collection<IcCertCd> getApplicableCertifications(ArrayList<Supply> supplyList) {
	//	TreeSet<String> usedCertCodes = new TreeSet<String>();
		List<IcCertCd> usedCerts = new ArrayList<IcCertCd>();

		return usedCerts;
	}

	public List<ApsAllocOnhandFc> getApsAllocOnhandFcs() {
		return apsAllocOnhandFcs;
	}

	public List<ApsAllocOnhandOo> getApsAllocOnhandOos() {
		return apsAllocOnhandOos;
	}

	public List<ApsAllocOnhandSs> getApsAllocOnhandSss() {
		return apsAllocOnhandSss;
	}

	public List<ApsAllocOnhandWo> getApsAllocOnhandWos() {
		return apsAllocOnhandWos;
	}

	public List<ApsAllocReplenFc> getApsAllocReplenFcs() {
		return apsAllocReplenFcs;
	}

	public List<ApsAllocReplenOo> getApsAllocReplenOos() {
		return apsAllocReplenOos;
	}

	public List<ApsAllocReplenSs> getApsAllocReplenSss() {
		return apsAllocReplenSss;
	}

	public List<ApsAllocReplenWo> getApsAllocReplenWos() {
		return apsAllocReplenWos;
	}

	public List<ApsAllocWoFc> getApsAllocWoFcs() {
		return apsAllocWoFcs;
	}

	public List<ApsAllocWoOo> getApsAllocWoOos() {
		return apsAllocWoOos;
	}

	public List<ApsAllocWoSs> getApsAllocWoSss() {
		return apsAllocWoSss;
	}

	public List<ApsAllocWoWo> getApsAllocWoWos() {
		return apsAllocWoWos;
	}

	public List<ApsAvailOnhand> getApsAvailOnhands() {
		return apsAvailOnhands;
	}

	public Map<Integer, ApsAvailReplen> getApsAvailReplenById() {
		return apsAvailReplenById;
	}

	public List<ApsAvailReplen> getApsAvailReplens() {
		return apsAvailReplens;
	}

	public List<ApsAvailWo> getApsAvailWos() {
		return apsAvailWos;
	}

	public List<ApsDmdFc> getApsDmdFcs() {
		return apsDmdFcs;
	}

	public List<ApsDmdOo> getApsDmdOos() {
		return apsDmdOos;
	}

	public List<ApsDmdSs> getApsDmdSss() {
		return apsDmdSss;
	}

	public List<ApsDmdWo> getApsDmdWos() {
		return apsDmdWos;
	}

	public List<ApsItemGlobalSubst> getApsItemGlobalSubsts() {
		return apsItemGlobalSubsts;
	}

	public ApsSplySubPool getApsSplySubPool(Integer subpoolNbr) {
		ApsSplySubPool retval = apsSplySubPoolById.get(subpoolNbr);
		if (retval == null) {
			throw new PlanningDataException("no such ApsSplySubPool " + subpoolNbr);
		}
		return retval;
	}

	public TreeMap<Integer, ApsSplySubPool> getApsSplySubPoolById() {
		return apsSplySubPoolById;
	}

	public Collection<ApsSplySubPool> getApsSplySubPools() {
		return apsSplySubPools;
	}
	/**
	 * The demand musthave a sourcing rule with the facility matching the supply facility.
	 * And it must be in the same subpool.
	 * 
	 * Find the set of sourcing rules for a given facility.
	 * 
	 * get the facility from the supply
	 * get the subpool from the supply
	 * put a colon between the two "DALLAS:GENERAL"
	 * Map<String,Set<ApsSrcRuleSet>> with key facility:subpoolcd do a lookup 
	 * @param demand
	 * @param supply
	 * @return
	 */

	public ApsSrcRule getApsSrcRule(Demand demand, Supply supply) {
		ApsSrcRule retval = null;
		int supplySubPoolNbr = supply.getApsSplySubPoolNbr();
		ApsSrcRuleSet ruleSet = demand.getApsSrcRuleSet();
		Set<ApsSrcRule> rules = ruleSet.getApsSrcRules();
		logger.debug("supplycd: {} subPoolNbr: {}", supply.getId(), supply.getApsSplySubPoolNbr());
		logger.debug("getApsSrcRule: demand {}", demand.getDmdCd());
		logger.debug("getApsSrcRule: ruleSet {} ", ruleSet);
		logger.debug("getApsSrcRule # rules: {}", rules.size());
		for (ApsSrcRule srcRule : ruleSet.getApsSrcRules()) {
			ApsSplySubPool subPool = srcRule.getApsSplySubPool();
			if (subPool == null) {
				String message = String.format("ApsSrcRule #%d %s has null ApsSplySubPool", srcRule.getApsSrcRuleNbr(),
						srcRule.toString());
				logger.error(message);
				throw new IllegalStateException(message);
			}
			int subpoolNbr = subPool.getApsSplySubPoolNbr();
			if (subpoolNbr == supplySubPoolNbr) {
				retval = srcRule;
				break;
			}
		}
		return retval;
	}

	public ApsSrcRule getApsSrcRule(Integer apsSrcRuleNbr) {
		if (apsSrcRuleNbr == null) {
			throw new PlanningDataException("apsSrcRuleNbr is null");
		}
		if (apsSrcRuleById == null) {
			throw new PlanningDataException("apsSrcRuleById is null");
		}
		ApsSrcRule retval = apsSrcRuleById.get(apsSrcRuleNbr);
		if (retval == null) {
			throw new IllegalArgumentException(
					"apsSrcRuleNbr " + apsSrcRuleNbr + " not found in " + apsSrcRuleById.size() + " rules");
		}
		return retval;
	}

	public TreeMap<Integer, ApsSrcRule> getApsSrcRuleById() {
		return apsSrcRuleById;
	}

	public TreeMap<Integer, ApsSrcRulePrimary> getApsSrcRulePrimaryById() {
		if (apsSrcRulePrimaryById == null) {
			throw new IllegalStateException("PlanningData.apsSrcRulePrimaryId is null");
		}
		return apsSrcRulePrimaryById;
	}

	public Collection<ApsSrcRule> getApsSrcRules() {
		return apsSrcRules;
	}

	public ApsSrcRuleSet getApsSrcRuleSet(int apsSrcRuleSetNbr) {
		throw new UnsupportedOperationException();
	}

	public ApsSrcRuleSetExt getApsSrcRuleSetExt(int apsSrcRuleSetNbr) {
		ApsSrcRuleSetExt retval = apsSrcRuleSetExtById.get(apsSrcRuleSetNbr);
		if (retval == null) {
			String keys = apsSrcRuleSetExtById.keySet().toString();
			throw new PlanningDataException("Unable to locate ApsSrcRuleSet for " + apsSrcRuleSetNbr + " in " + keys);
		}
		return retval;
	}

	public TreeMap<Integer, ApsSrcRuleSetExt> getApsSrcRuleSetExtById() {
		return apsSrcRuleSetExtById;
	}

	public Collection<ApsSrcRuleSet> getApsSrcRuleSets() {
		return apsSrcRuleSets;
	}

	public Demand getDemandCustomer(String id) {
		Demand demand = demandCustomerById.get(id);
		if (demand == null) {
			throw new IllegalArgumentException("no such demand '" + id + "'");
		}
		return demand;
	}

	public DemandCustomer getCustomerDemandByPk(int demandPk) {
		DemandCustomer demand = demandCustomerById.get(demandPk);
		if (demand == null) {
			throw new IllegalStateException("unable to find customer demand for " + demandPk);
		}
		return demand;
	}

	
	public EligibleSupplies getCustomerEligibleSupplies(Integer orgNbrCst) {
		throw new UnsupportedOperationException(); // TODO if reprioritized within customer option elected

	}

	public CustomerItemManufacturerRules getCustomerItemManufacturerRules() {
		if (customerItemManufacturerRules == null) {
			throw new IllegalStateException("customerItemManufacturerRules has not been set");
		}
		return customerItemManufacturerRules;
	}

	public CustomerItemManufacturers getCustomerItemManufacturers() {
		if (customerItemManufacturers == null) {
			throw new IllegalStateException("customerItemManufacturers is null");
		}
		return customerItemManufacturers;
	}

	public DemandCustomer getCustomerOrder(Integer demandPk) {

		return demandCustomerById.get(demandPk);
	}

	// Todo ApsDmdOo by pk needs to be populated
	@Deprecated
	public ApsDmdOo getCustomerOrderByPk(int demandPk) {
		throw new UnsupportedOperationException();
	}

	/**
	 * Needs to blow up if not found
	 * 
	 * @param demandId
	 * @return
	 */
	public DemandCustomer getCustomerOrderByPk(String demandId) {
		throw new UnsupportedOperationException();
	}


	public List<Allocation> getCustomerPrioritizedAllocations() {
		return customerPrioritizedAllocations;
	}

	public TreeMap<Integer, DemandCustomer> getDemandCustomerById() {
		if (demandCustomerById == null) {
			throw new IllegalStateException("demandCustomerById is null");
		}
		return demandCustomerById;
	}

	public Collection<DemandCustomer> getDemandCustomers() {
		if (demandCustomerById == null) {
			throw new IllegalStateException("demandCustomerById is null");
		}
		return demandCustomerById.values();
	}

	public Map<String, DemandForecast> getDemandForecastById() {
		return demandForecastById;
	}

	public List<Demand> getDemands() {
		if (demands == null) {
			demands = new ArrayList<Demand>();
			demands.addAll(getDemandWorkOrders());
			demands.addAll(getDemandSafetyStocks());
			demands.addAll(demandForecastById.values());
			demands.addAll(demandCustomerById.values());
			for (Demand demand : demands) {
				demand.setIcItemMast(getIcItemMastById(demand.getItemNbrDmd())); // TODO
				String id = demand.getFcstGrp();
				FcstGrp fcstGrp = fcstGrpById.get(id);
				if (fcstGrp == null) {
					throw new IllegalStateException(
							"fcstGrp is null for FcstGrpCd " + demand.getFcstGrp() + " demand is " + demand.getDmdCd());
				}
				demand.setDemandFcstGrp(fcstGrp);
				demand.setApsSrcRuleSetExt(getApsSrcRuleSetExt(demand.getApsSrcRuleSetNbr())); 
			}
		}
		return demands;

	}

	public Map<Integer, DemandSafetyStock> getDemandSafetyStockById() {
		return demandSafetyStockById;
	}

	public Collection<DemandSafetyStock> getDemandSafetyStocks() {
		return demandSafetyStockById.values();
	}

	public TreeMap<Integer, ArrayList<DemandCustomer>> getDemandsByCustomer() {
		if (demandsByCustomer == null) {
			throw new PlanningDataException("dmdsByCustomer is null");
		}
		return demandsByCustomer;
	}

	public Map<Integer, DemandWorkOrder> getDemandWorkOrderById() {
		return demandWorkOrderById;
	}

	public Collection<DemandWorkOrder> getDemandWorkOrders() {
		return demandWorkOrderById.values();
	}

	public Date getEffectiveDate() {
		if  (effectiveDate == null) {
			throw new PlanningDataException("effective date is null");
		}
		return effectiveDate;
	}

	public List<FcItemMast> getFcItemMasts() {
		return fcItemMasts;
	}

	public TreeMap<String, FcstGrp> getFcstGrpById() {
		if (fcstGrpById == null) {
			throw new PlanningDataException("fcstGrpById is null");
		}
		return fcstGrpById;
	}

	public List<FcstGrp> getFcstGrps() {
		return fcstGrps;
	}

	public List<Allocation> getFirstPassAllocations() {

		return firstPassAllocations;
	}


	public DemandForecast getForecastByDemandPk(int fcItemMastNbr, Date fcstDt) {
		String key = DemandForecast.getIdentifier(fcItemMastNbr, fcstDt);
		DemandForecast demand = demandForecastById.get(key);
		if (demand == null) {
			throw new IllegalArgumentException("Cannot find demand for " + key);
		}

		return demand;
	}

	public DemandForecast getForecastDemand(int fcItemMastNbr, Date fcstDt) {
		String key = fcItemMastNbr + fcstDt.toString(); // TODO should call a
		// state method in
		// DemandForecast
		DemandForecast demandForecast = demandForecastById.get(key);
		if (demandForecast == null) {
			throw new IllegalArgumentException("demand not found " + key);
		}

		return demandForecast;
	}

	public ApsDmdFc getForecastToConsume(Demand demand) {
		throw new UnsupportedOperationException();
	}

	public Map<String, IcCertCd> getIcCertCdById() {
		return icCertCdById;
	}

	public IcCertCd getIcCertCdById(String key) {
		return icCertCdById.get(key);
	}

	public List<IcCertCd> getIcCertCds() {
		return icCertCds;
	}

	public ArrayList<IcItemCustSubst> getIcCustItemSubsts() {
		return icCustItemSubsts;
	}

	public List<IcItemCustSubst> getIcItemCustsSubsts() {
		return icItemCustsSubsts;
	}

	public List<IcItemCustSubst> getIcItemCustSubsts() {
		return icItemCustsSubsts;
	}

	public IcItemMast getIcItemMastById(int itemNbr) {
		if (icItemMastsById == null) {
			throw new IllegalStateException("icItemMastsById is null");
		}
		IcItemMast iim = icItemMastsById.get(itemNbr);
		if (iim == null) {
			throw new IllegalStateException("can't find icItemMast for " + itemNbr);
		}
		return iim;
	}

	public List<IcItemMastEquiv> getIcItemMastEquivs() {
		return icItemMastEquivs;
	}

	public List<IcItemMastEquiv> getIcItemMastEquivsForItem(int itemNbr) {
		throw new UnsupportedOperationException(); // TODO
	}

	public Collection<IcItemMast> getIcItemMasts() {
		return icItemMastsById.values();
	}

	public TreeMap<Integer, IcItemMast> getIcItemMastsById() {
		return icItemMastsById;

	}

	public Collection<IcItemRevLvl> getIcItemRevLvls() {
		throw new UnsupportedOperationException();
	}

	public IcLotMast getIcLotMast(Integer lotNbr) {
		IcLotMast lot = icLotMastById.get(lotNbr);
		if (lot == null) {
			throw new IllegalArgumentException("no such lot " + lotNbr);
		}
		return lot;
	}

	/**
	 * @return the lotsById
	 */
	public Map<Integer, IcLotMast> getIcLotMastById() {
		return icLotMastById;
	}

	public ArrayList<String> getIntegrityMessages() {
		return integrityMessages;
	}

	public String getItemNbrsAsString() {
		StringBuilder b = new StringBuilder();
		for (Integer itemNbr : icItemMastsById.keySet()) {
			b.append(itemNbr);
			b.append(" ");
		}
		return b.toString();
	}

	public Logger getLogger() {
		return logger;
	}

	public NaOrg getNaOrg(int orgNbr) {
		if (naOrgById == null) {
			throw new IllegalStateException("naOrgById is null");
		}
		NaOrg retval = naOrgById.get(orgNbr);
		if (retval == null) {
			throw new PlanningDataException("no such org " + orgNbr);
		}
		return retval;
	}
	
	public NaOrg getNaOrg(int orgNbr, Object o) {
		if (naOrgById == null) {
			throw new IllegalStateException("naOrgById is null");
		}
		NaOrg retval = naOrgById.get(orgNbr);
		if (retval == null) {
			List<Object> l = missingOrgNbrs.get(orgNbr);
			if (l == null) {
				l = new ArrayList<Object>();
				missingOrgNbrs.put(orgNbr,l);
			}
			l.add(o);
			
			throw new PlanningDataException("no such org " + orgNbr + " in " + o);
		}
		return retval;
	}

	public Map<Integer, NaOrg> getNaOrgById() {
		return naOrgById;
	}

	public double getNetAvailableForCustomer(Demand demand) {
		throw new UnsupportedOperationException(); 
		// TODO for repriortized within customer option
		
	}

	public OeCustMast getOeCustMast(int orgNbrCust) {
		OeCustMast retval = oeCustMastById.get(orgNbrCust);
		if (oeCustMastById == null) {
			throw new IllegalStateException("oeCustMastById is null");
		}
		if (retval == null) {
			throw new IllegalArgumentException("no such customer " + orgNbrCust);
		}
		return retval;
	}

	OeCustMast getOeCustMast(Integer orgNbrCust) {
		OeCustMast retval = oeCustMastById.get(orgNbrCust);
		if (retval == null) {
			throw new IllegalStateException("Customer not found " + orgNbrCust);
		}
		return retval;
	}

	/**
	 * @return the oeCustMastById
	 */
	public Map<Integer, OeCustMast> getOeCustMastById() {
		if (oeCustMastById == null) {
			throw new IllegalStateException("setOeCustMasts has not been called");
		}
		return oeCustMastById;
	}

	public Collection<OeCustMast> getOeCustMasts() {
		return oeCustMastById.values();
	}


	public List<OeCustMfr> getOeCustMfrs() {
		return oeCustMfrs;
	}

	/**
	 * @return the oeOrdDtlCerts
	 */
	public List<OeOrdDtlCert> getOeOrdDtlCerts() {
		return oeOrdDtlCerts;
	}

	/**
	 * @return the onhandById
	 */
	public Map<String, Supply> getOnhandById() {
		return onhandById;
	}

	public Supply getOnhandSupplyById(String id) {
		Supply supply = onhandById.get(id);
		if (supply == null) {
			throw new IllegalArgumentException("no such onhand '" + id + "'");
		}
		return supply;
	}

	public ArrayList<Allocation> getOvershipAllocations() {
		return overshipAllocations;
	}

	public ArrayList<Allocation> getPickRestoreAllocations() {
		return pickRestoreAllocations;
	}

	public ArrayList<Allocation> getPreviousAllocations() {
		if (previousAllocations == null) {
			throw new IllegalStateException("previousAllocations is null");
		}
		return previousAllocations;
	}

	public boolean isDemandPrioritized() {
		return prioritizedDemands != null;
	}
	public TreeMap<String, Demand> getPrioritizedDemands() {
		if (prioritizedDemands == null) {
			throw new IllegalStateException("demands have not been prioritized");
		}
		return prioritizedDemands;
	}

	public TreeSet<Demand> getPrioritizedDemandsWithinLeadTime() {
		return prioritizedDemandsWithinLeadTime;
	}

	public PropertyManager getPropertyManager() {
		throw new UnsupportedOperationException(); // TODO
	}

	public DemandSafetyStock getSafetyStockDemandByPk(int demandPk) {
		DemandSafetyStock demand = demandSafetyStockById.get(demandPk);
		if (demand == null) {
			throw new IllegalStateException("unable to find customer demand for " + demandPk);
		}
		return demand;
	}

	@Deprecated
	public ApsSrcRule getSourcingRule(Demand demand, Supply supply) {
		return getSourcingRule(supply, demand);
	}

	public ApsSrcRule getSourcingRule(Supply supply, Demand demand) {
		Integer supplySubPoolNbr = supply.getApsSplySubPoolNbr();
		StringBuilder sb = null;
		if (logger.isDebugEnabled()) {
			sb = new StringBuilder();
			sb.append("supplySubPoolNbr: " + supplySubPoolNbr + "\n");
		}
		ApsSrcRuleSet demandSourceRuleSet = demand.getApsSrcRuleSet();
		if (logger.isDebugEnabled()) {
			sb.append(stringBean.asString(demandSourceRuleSet));
		}
		if (demand.getApsSrcRuleSet() == null) {
			throw new IllegalStateException("demand.getApsSrcRuleSet returns null");
		}
		ApsSrcRule retval = null;
		if (logger.isDebugEnabled()) {
			sb.append("ApsSrcRules.size() " + demandSourceRuleSet.getApsSrcRules().size());
		}
		for (ApsSrcRule rule : demandSourceRuleSet.getApsSrcRules()) {
			if (logger.isDebugEnabled()) {
				sb.append("ruleSubPoolNbr: " + rule.getApsSplySubPool().getApsSplySubPoolNbr() + "\n");
			}
			if (supplySubPoolNbr == rule.getApsSplySubPool().getApsSplySubPoolNbr()) {
				retval = rule;
				break;
			}
		}
		if (logger.isDebugEnabled()) {
			sb.append("rule " + retval);
			logger.debug(sb.toString());
		}
		return retval;

	}

	/**
	 * This should only be used while trimming the sourcing rules for serialization
	 * for unit tests.
	 * 
	 * @param pd
	 */

	public Collection<Supply> getSupplies() {
		if (supplies == null) {
			supplies = new ArrayList<Supply>();
			supplies.addAll(supplyOnhandById.values());
			supplies.addAll(supplyWorkOrderById.values());
			supplies.addAll(supplyReplenById.values());
		}
		for (Supply supply : supplies) {
			supply.setIcItemMast(getIcItemMastById(supply.getItemNbr()));
		}
		if (trace) {
			logger.debug("returning supplies " + supplies.size());
		}
		return supplies;

	}

	public Map<String, Supply> getSuppliesById() {

		if (suppliesById == null) {
			int expected =   supplyOnhandById.size() + supplyWorkOrderById.size() + supplyReplenById.size();
			suppliesById = new TreeMap<String,Supply>();
			suppliesById.putAll(supplyOnhandById);
			suppliesById.putAll(supplyWorkOrderById);
			suppliesById.putAll(supplyReplenById);
			assert(expected == suppliesById.size());
		}

		return suppliesById;
	}

	public SupplyOnhand getSupplyOnhand(String id) {
		// TODO Auto-generated method stub
		SupplyOnhand supply = supplyOnhandById.get(id);
		if (supply == null) {
			throw new IllegalStateException("apsAvailOnhandById does not contain " + id);
		}
		return supply;
	}

	public TreeMap<String, SupplyOnhand> getSupplyOnhandById() {
		return supplyOnhandById;
	}

	public TreeMap<String, SupplyReplen> getSupplyReplenById() {
		return supplyReplenById;
	}

	public Supply getSupplyReplenById(String id) {
		Supply supply = supplyReplenById.get(id);
		if (supply == null) {
			throw new IllegalArgumentException("no such SupplyReplen '" + id + "'");
		}
		return supply;
	}

	public SupplyWorkOrder getSupplyWorkOrder(String supplyPk) {

		SupplyWorkOrder wo = supplyWorkOrderById.get(supplyPk);

		if (wo == null) {
			String message = " could not find Work	Order supply for allocKey " + supplyPk;
			logger.error(message);
		}
		return wo;
	}

	public Map<String, SupplyWorkOrder> getSupplyWorkOrderById() {
		return supplyWorkOrderById;
	}

	public List<TmpItem> getTmpItems() {
		return tmpItems;
	}

	public List<UtFacility> getUtFacilities() {
		return utFacilities;
	}

	public UtFacility getUtFacility(String facilityName) {

		UtFacility retval = utFacilityById.get(facilityName);
		if (retval == null) {
			String message = String.format("Cannot find facility '%s' in\n %s", facilityName,
					stringBean.asString(utFacilityById));
			logger.error(message);
			throw new PlanningDataException(message);
		}
		return retval;
	}

	public Object getUtFacilityById() {
		return utFacilityById;
	}

	public ArrayList<String> getVerificationMessages() {
		return verificationMessages;
	}

	public DemandWorkOrder getWorkOrderByPk(int demandPk) {
		DemandWorkOrder demand = demandWorkOrderById.get(demandPk);
		if (demand == null) {
			throw new IllegalStateException("unable to find customer demand for " + demandPk);
		}
		return demand;
	}

	public Demand getWorkOrderDemand(Integer demandPk) {
		Demand wod = demandWorkOrderById.get(demandPk);

		return wod;
	}

	public boolean isMapsAndReferencesBuilt() {
		return mapsAndReferencesBuilt;
	}

	public boolean isPopulatingResultSupplyDetails() {
		throw new UnsupportedOperationException(); // TODO
	}

	public boolean isTrace() {
		return trace;
	}

	public void setAllocations(AllocationMode mode, ArrayList<Allocation> allocations) {
		switch (mode) {
		case CUSTOMER_PRIORITIZED:
			customerPrioritizedAllocations = allocations;
			break;
		case FIRST_PASS:
			firstPassAllocations = allocations;
			break;
		case OVERSHIP:
			overshipAllocations = allocations;
			break;
		case PICK_RESTORE:
			pickRestoreAllocations = allocations;
			break;
		default:
			throw new IllegalStateException("Unknown mode");

		}

	}

	public void setAllocations(Map<AllocationMode, List<Allocation>> allocations) {
		this.allocations = allocations;
	}

	public void setAllocToReplenWindow(int allocToReplenWindow) {
		this.allocToReplenWindow = allocToReplenWindow;

	}

	/**
	 * }
	 * 
	 * /**
	 * 
	 * @param apsAllocOnhandFcs the apsAllocOnhandFcs to set
	 */
	public void setApsAllocOnhandFcs(List<ApsAllocOnhandFc> apsAllocOnhandFcs) {
		this.apsAllocOnhandFcs = apsAllocOnhandFcs;
	}

	/**
	 * @param apsAllocOnhandOos the apsAllocOnhandOos to set
	 */
	public void setApsAllocOnhandOos(List<ApsAllocOnhandOo> apsAllocOnhandOos) {
		this.apsAllocOnhandOos = apsAllocOnhandOos;
	}

	/**
	 * @param apsAllocOnhandSss the apsAllocOnhandSss to set
	 */
	public void setApsAllocOnhandSss(List<ApsAllocOnhandSs> apsAllocOnhandSss) {
		this.apsAllocOnhandSss = apsAllocOnhandSss;
	}

	/**
	 * @param apsAllocOnhandWos the apsAllocOnhandWos to set
	 */
	public void setApsAllocOnhandWos(List<ApsAllocOnhandWo> apsAllocOnhandWos) {
		this.apsAllocOnhandWos = apsAllocOnhandWos;
	}

	/**
	 * @param apsAllocReplenFcs the apsAllocReplenFcs to set
	 */
	public void setApsAllocReplenFcs(List<ApsAllocReplenFc> apsAllocReplenFcs) {
		this.apsAllocReplenFcs = apsAllocReplenFcs;
	}

	/**
	 * @param apsAllocReplenOos the apsAllocReplenOos to set
	 */
	public void setApsAllocReplenOos(List<ApsAllocReplenOo> apsAllocReplenOos) {
		this.apsAllocReplenOos = apsAllocReplenOos;
	}

	/**
	 * @param apsAllocReplenSss the apsAllocReplenSss to set
	 */
	public void setApsAllocReplenSss(List<ApsAllocReplenSs> apsAllocReplenSss) {
		this.apsAllocReplenSss = apsAllocReplenSss;
	}

	/**
	 * @param apsAllocReplenWos the apsAllocReplenWos to set
	 */
	public void setApsAllocReplenWos(List<ApsAllocReplenWo> apsAllocReplenWos) {
		this.apsAllocReplenWos = apsAllocReplenWos;
	}

	/**
	 * @param apsAllocWoFcs the apsAllocWoFcs to set
	 */
	public void setApsAllocWoFcs(List<ApsAllocWoFc> apsAllocWoFcs) {
		this.apsAllocWoFcs = apsAllocWoFcs;
	}

	/**
	 * @param apsAllocWoOos the apsAllocWoOos to set
	 */
	public void setApsAllocWoOos(List<ApsAllocWoOo> apsAllocWoOos) {
		this.apsAllocWoOos = apsAllocWoOos;
	}

	/**
	 * @param list the apsAllocWoSss to set
	 */
	public void setApsAllocWoSss(List<ApsAllocWoSs> list) {
		this.apsAllocWoSss = list;
	}

	/**
	 * @param apsAllocWoWos the apsAllocWoWos to set
	 */
	public void setApsAllocWoWos(List<ApsAllocWoWo> apsAllocWoWos) {
		this.apsAllocWoWos = apsAllocWoWos;
	}

	public void setApsAvailOnhands(List<ApsAvailOnhand> list) {
		this.apsAvailOnhands = list;
		this.supplies = null;
		this.suppliesById = null;
		supplyOnhandById = new TreeMap<String, SupplyOnhand>();

		for (ApsAvailOnhand as : list) {
			SupplyOnhand so = new SupplyOnhand(as);
			SupplyOnhand old = supplyOnhandById.put(so.getSplyIdentifier(), so);
			if (old != null) {
				String message = String.format("While processing id %s\nformer id %s\nsupplyOnHand %s\nformer %s",
						so.getSplyIdentifier(), old.getSplyIdentifier(), so, old);
				logger.error(message);
			}
		}
		assertSizes(list, supplyOnhandById);
	}

	public void setApsAvailReplens(List<ApsAvailReplen> list) {
		supplies = null;
		suppliesById = null;
		this.apsAvailReplens = list;
		supplyReplenById = new TreeMap<String, SupplyReplen>();
		for (ApsAvailReplen as : list) {
			SupplyReplen so = new SupplyReplen(as);
			supplyReplenById.put(so.getSplyIdentifier(), so);
		}
		assertSizes(list, supplyReplenById);
	}

	public void setApsAvailWos(List<ApsAvailWo> list) {
		if (list == null) {
			throw new IllegalArgumentException("list is null");
		}
		this.supplies = null;
		this.suppliesById = null;
		this.apsAvailWos = list;
		this.supplyWorkOrderById = new TreeMap<String, SupplyWorkOrder>();
		for (ApsAvailWo as : list) {
			SupplyWorkOrder so = new SupplyWorkOrder(as);
			supplyWorkOrderById.put(so.getSplyIdentifier(), so);
		}
		assertSizes(list, supplyWorkOrderById);
	}

	public void setApsDmdFcs(List<ApsDmdFc> list) {
		demands = null;
		this.apsDmdFcs = list;
		List<DemandForecast> demands = new ArrayList<DemandForecast>(list.size());
		for (ApsDmdFc demand : list) {
			if (! demand.getRqstDt().before(firstDayThisMonth)) {
			DemandForecast dc = new DemandForecast(demand,sdf);
			dc.setPlanningData(this);
			demands.add(dc);
			}
			else {
				logger.debug("ignoring: demand forecastGroup {} rqstDt {}  before first day of this month {}", demand.getFcstGrp(),demand.getRqstDt(), firstDayThisMonth);
			}
		}
		setDemandForecasts(demands);
	}

	public void setApsDmdOos(List<ApsDmdOo> list) {
		this.apsDmdOos = list;
		TreeMap<Integer, ArrayList<DemandCustomer>> demandsByCustomer = new TreeMap<>();
		// demands = new ArrayList<DemandCustomer>();
		TreeMap<Integer, DemandCustomer> map = new TreeMap<Integer, DemandCustomer>();
		for (ApsDmdOo dmd : list) {
			DemandCustomer demand = new DemandCustomer(dmd);
			demand.setPlanningData(this);
			Integer id = demand.getOeOrdDtlNbr();
		//	String message = "setApsDmdOos " + stringBean.asString(dmd);
			//System.out.println(message);
			Demand old = map.put(id, demand);
			if (old != null) {
				throw new PlanningDataException(String.format("duplicate demand %d", id));
			}
			ArrayList<DemandCustomer> customerDemands = demandsByCustomer.get(demand.getOrgNbrCust());
			if (customerDemands == null) {
				customerDemands = new ArrayList<DemandCustomer>();
				customerDemands.add(demand);
			}
			demandsByCustomer.put(demand.getOrgNbrCust(), customerDemands);
		}
		this.demandsByCustomer = demandsByCustomer;
		this.demandCustomerById = map;
	}

	public void setApsDmdSss(List<ApsDmdSs> list) {
		demands = null;
		this.apsDmdSss = list;
		List<DemandSafetyStock> demands = new ArrayList<DemandSafetyStock>();
		for (ApsDmdSs demand : list) {
			DemandSafetyStock d = new DemandSafetyStock(demand);
			d.setPlanningData(this);
			demands.add(d);
		}
		setDemandSafetyStocks(demands);
		assertSizes(list, demandSafetyStockById);
	}

	public void setApsDmdWos(List<ApsDmdWo> list) {
		demands = null;
		this.apsDmdWos = list;
		List<DemandWorkOrder> demands = new ArrayList<DemandWorkOrder>();
		for (ApsDmdWo demand : list) {
			DemandWorkOrder d = new DemandWorkOrder(demand);
			d.setPlanningData(this);
			demands.add(d);
		}
		setDemandWorkOrders(demands);
	}

	public void setApsItemGlobalSubsts(List<ApsItemGlobalSubst> list) {
		this.apsItemGlobalSubsts = list;
	}

	/**
	 * @param list the apsSplySubPools to set
	 */
	public void setApsSplySubPools(Collection<ApsSplySubPool> list) {
		this.apsSplySubPools = list;
		apsSplySubPoolById = new TreeMap<Integer, ApsSplySubPool>();
		for (ApsSplySubPool subPool : list) {
			apsSplySubPoolById.put(subPool.getApsSplySubPoolNbr(), subPool);
		}
		assertSizes(list, apsSplySubPoolById);
	}

	public void setApsSrcRuleById(TreeMap<Integer, ApsSrcRule> apsSrcRuleById) {
		this.apsSrcRuleById = apsSrcRuleById;
	}

	public void setApsSrcRulePrimarys(Collection<ApsSrcRulePrimary> collection) {
		if (collection == null ) {
			throw new IllegalArgumentException("collection is null");
		}
//		this.apsSrcRulePrimarys = collection;
		this.apsSrcRulePrimaryById = new TreeMap<Integer, ApsSrcRulePrimary>();
		for (ApsSrcRulePrimary prim : collection) {
			ApsSrcRulePrimary old = apsSrcRulePrimaryById.put(prim.getApsSrcRuleSetNbr(), prim);
			if (old != null) {
				throw new PlanningDataException("dupe ApsSrcRulePrimary " + old.getApsSrcRuleSetNbr());
			}
		}
	}

	public void setApsSrcRules(Collection<ApsSrcRule> list) {
		this.apsSrcRules = list;
		TreeMap<Integer, ApsSrcRule> byId = new TreeMap<Integer, ApsSrcRule>();
		for (ApsSrcRule rule : list) {
			byId.put(rule.getApsSrcRuleNbr(), rule);
		}
		assertSizes(list, byId);
		apsSrcRuleById = byId;
	}

	public void setApsSrcRuleSetExtById(TreeMap<Integer, ApsSrcRuleSetExt> treeMap) {
		this.apsSrcRuleSetExtById = treeMap;
	}

	public void setApsSrcRuleSets(Collection<ApsSrcRuleSet> collection) {
		this.apsSrcRuleSets = collection;
		apsSrcRuleSetExtById = new TreeMap<Integer, ApsSrcRuleSetExt>();
		for (ApsSrcRuleSet set : collection) {
			ApsSrcRuleSetExt ext = new ApsSrcRuleSetExt(set);
			apsSrcRuleSetExtById.put(set.getApsSrcRuleSetNbr(), ext);
		}
		assertSizes(collection, apsSrcRuleSetExtById);
	}

	public void setCustomerItemManufacturers(CustomerItemManufacturers customerItemManufacturers) {
		this.customerItemManufacturers = customerItemManufacturers;
	}

	public void setCustomerPrioritizedAllocations(ArrayList<Allocation> customerPrioritizedAllocations) {
		this.customerPrioritizedAllocations = customerPrioritizedAllocations;
	}

	public void setDemandCustomers(Collection<DemandCustomer> demandCustomers) {
		demands = null;
		prioritizedDemands = null;
		demandCustomerById = new TreeMap<Integer, DemandCustomer>();
		demandsByCustomer = new TreeMap<Integer, ArrayList<DemandCustomer>>();
		for (DemandCustomer demand : demandCustomers) {
			demandCustomerById.put(demand.getOeOrdDtlNbr(), demand);
			ArrayList<DemandCustomer> demandsForCustomer = demandsByCustomer.get(demand.getOrgNbrCust());
			if (demandsForCustomer == null) {
				demandsForCustomer = new ArrayList<DemandCustomer>();
				demandsByCustomer.put(demand.getOrgNbrCust(), demandsForCustomer);
			}
			demandsForCustomer.add(demand);
		}
	}

	public void setDemandForecasts(Collection<DemandForecast> list) {
		demands = null;
		demandForecastById = new TreeMap<String, DemandForecast>();
		for (DemandForecast f : list) {
			DemandForecast old = demandForecastById.put(f.getIdentifier(), f);
			if (old != null) {
				String message = String.format("old id: '%s'\n    id:%s\nold: %s\nnew:%s", old.getIdentifier(),
						f.getIdentifier(), old, f);
				logger.error(message);
				Thread.dumpStack();
				throw new IllegalStateException(message);
			}
		}
		assertSizes(list, demandForecastById);
	}

	public void setDemands(List<Demand> demands) {
		this.demands = demands;
	}

	public void setDemandSafetyStocks(Collection<DemandSafetyStock> list) {
		demands = null;
		prioritizedDemands = null;
		demandSafetyStockById = new TreeMap<Integer, DemandSafetyStock>();
		for (DemandSafetyStock demand : list) {
			demandSafetyStockById.put(demand.getFcItemMastNbr(), demand);
		}
	}

	public void setDemandWorkOrders(List<DemandWorkOrder> demandWorkOrders) {
		this.demands = null;
		this.prioritizedDemands = null;
		demandWorkOrderById = new TreeMap<Integer, DemandWorkOrder>();
		for (DemandWorkOrder demand : demandWorkOrders) {
			demandWorkOrderById.put(demand.getWoDtlNbr(), demand);
		}
		assertSizes(demandWorkOrders, demandWorkOrderById);
	}

	public void setEffectiveDate(Date effectiveDate) {
		this.effectiveDate = effectiveDate;
		firstDayThisMonth = DateHelper.getFirstDateInMonth(getEffectiveDate());
	}

	public void setFcItemMasts(List<FcItemMast> fcItemMasts) {
		this.fcItemMasts = fcItemMasts;
		fcItemMastById = new TreeMap<Integer, FcItemMast>();
		for (FcItemMast fim : fcItemMasts) {
			fcItemMastById.put(fim.getFcItemMastNbr(), fim);
		}
	}

	public void setFcstGrps(List<FcstGrp> list) {
		fcstGrps = list;
		fcstGrpById = new TreeMap<String, FcstGrp>();
		for (FcstGrp f : list) {
	//		String key = f.getFcstGrp();
			FcstGrp old = fcstGrpById.put(f.getFcstGrp(), f);
			if (old != null) {
				String message = "duplicate FcstGrp " + old + " " + f;
				logger.error(message);
				throw new PlanningDataException(message);
			}
		}
		logger.debug("fcstGrps size " + fcstGrps.size());
	}

	// TODO this should be replaced with mode
	public void setFirstPassAllocations(ArrayList<Allocation> firstPassAllocations) {
		this.firstPassAllocations = firstPassAllocations;
	}

	public void setIcCertCds(List<IcCertCd> icCertCds) {
		this.icCertCds = icCertCds;
		icCertCdById = new TreeMap<String, IcCertCd>();
		for (IcCertCd cert : icCertCds) {
			icCertCdById.put(cert.getCertCd(), cert);
		}
	}
	
	
	public void populateApsResultDtlDmds() {

		int id = getApsResultDtlDmdId();

		ArrayList<ApsResultDtlDmd> ardds = new ArrayList<>();
		for (Demand demand : getDemands()) {
			ApsResultDtlDmd ardd = new ApsResultDtlDmd();
			ardd.setAvailDt(demand.getAvailDt(AllocationMode.FIRST_PASS));
			ardd.setRqstDtAllocQty(new BigDecimal(demand.getAllocatedOnTimeQty(AllocationMode.FIRST_PASS)));
			ardd.setApsResultDtlDmdNbr(id++);
			ardd.setFacilityDmd(demand.getPrimarySourcingFacility());
			ardd.setItemNbrRqst(demand.getItemNbrDmd());
			ardd.setDmdIdentifier(demand.getDmdCd());
			if (demand.isCustomerDemand()) {
				DemandCustomer oo =  (DemandCustomer) demand;
				ardd.setOeOrdDtlNbr(oo.getOeOrdDtlNbr());
				ardd.setOrgNbrMfrRqst(oo.getOrgNbrMfrRqst());
				ardd.setPromDtCurr(oo.getPromDtCurr());
			}
			if (demand.isWorkOrderDemand()) {
				DemandWorkOrder wo = (DemandWorkOrder) demand;
				ardd.setWoDtlNbr(wo.getWoDtlNbr());
			}
			if (demand.isForecastDemand()) {
				DemandForecast fc = (DemandForecast) demand;
				ardd.setFcFcstNbr(fc.getFcFcstNbr());
				ardd.setFcItemMastNbr(fc.getFcItemMastNbr());
			}
			if (demand.isSafetyStockDemand()) {
				DemandSafetyStock ss = (DemandSafetyStock) demand;
				ardd.setFcItemMastNbr(ss.getFcItemMastNbr());
			}
			if (demand.isForecastDemand()) {
				DemandForecast fc1 = (DemandForecast) demand;
				ardd.setDmdQty(new BigDecimal(fc1.getUnconsumedQty(AllocationMode.FIRST_PASS)));
			} else {
				ardd.setDmdQty(demand.getOpenQty());
			}
			ardd.setDmdQtyAdj(ardd.getDmdQty());
			ardd.setAllocQty(new BigDecimal(demand.getAllocatedQty(AllocationMode.FIRST_PASS)));
			ardd.setRqstDt(demand.getNeedByDate());
			ardd.setApsSrcRuleSetNbrDmd(demand.getApsSrcRuleSetNbr());
			ardd.setOrgNbrCust(demand.getOrgNbrCust());
			//ardd.setAvailDt(demand.getAvailDt(AllocationMode.FIRST_PASS));
			ardds.add(ardd);
		}
		setApsResultDtlDmds(ardds);
	}

	public void setIcCustItemSubsts(ArrayList<IcItemCustSubst> icCustItemSubsts) {
		this.icCustItemSubsts = icCustItemSubsts;
	}

	public void setIcItemCustsSubsts(List<IcItemCustSubst> list) {
		this.icItemCustsSubsts = list;
	}

	public void setIcItemMastEquivs(List<IcItemMastEquiv> list) {
		this.icItemMastEquivs = list;
	}

	public void setIcItemMasts(List<IcItemMast> list) {
		icItemMastsById = new TreeMap<Integer, IcItemMast>();
		for (IcItemMast iim : list) {
			icItemMastsById.put(iim.getItemNbr(), iim);
		}
		assertSizes(list, icItemMastsById);
	}

	public void setIcLotMasts(Collection<IcLotMast> list) {
		icLotMastById = new TreeMap<Integer, IcLotMast>();
		for (IcLotMast ilm : list) {
			// logger.debug("ilm.getLotNbr() {}",ilm.getLotNbr());
			icLotMastById.put(ilm.getLotNbr(), ilm);
		}
		if (list.size() != icLotMastById.size()) {
			throw new IllegalStateException(
					"list size: " + list.size() + " icLotMastById.size() " + icLotMastById.size());
		}
		assertSizes(list, icLotMastById);
	}

	public void setNaOrgById(Map<Integer, NaOrg> naOrgById) {
		if (naOrgById == null) {
			throw new IllegalArgumentException("naOrgById is null");
		}
		if (this.naOrgById != null) {
			throw new IllegalStateException("naOrgBy has already been set");
		}
		this.naOrgById = naOrgById;
	}

	public void setOeCustMasts(Collection<OeCustMast> oeCustMastList) {
		logger.debug("setOeCustMasts: inputSize {}" + oeCustMastList.size());
		//oeCustMasts = oeCustMastList;
		oeCustMastById = new TreeMap<Integer, OeCustMast>();
		for (OeCustMast cust : oeCustMastList) {
			OeCustMast old = oeCustMastById.put(cust.getOrgNbrCust(), cust);
			if (old != null) {
				String message = String.format("Duplicate customer: %s\n%s", stringBean.asString(old),
						stringBean.asString(cust));
				logger.error(message);
				throw new PlanningDataException(message);
			}
		}
		assertSizes(oeCustMastList, oeCustMastById);
	}

	public void setOeCustMfrs(List<OeCustMfr> oeCustMfrList) {
		this.oeCustMfrs = oeCustMfrList;
	//	this.customerItemManufacturerRules = new CustomerItemManufacturerRules(oeCustMfrs);
	}
	
	public void setCustomerItemManufacturerRules(CustomerItemManufacturerRules cimr) {
		this.customerItemManufacturerRules = cimr;
	}

	/**
	 * @param oeOrdDtlCerts the oeOrdDtlCerts to set
	 */
	public void setOeOrdDtlCerts(List<OeOrdDtlCert> oeOrdDtlCerts) {
		this.oeOrdDtlCerts = oeOrdDtlCerts;
	}

	public void setOvershipAllocations(ArrayList<Allocation> overshipAllocations) {
		this.overshipAllocations = overshipAllocations;
	}

	public void setPickRestoreAllocations(ArrayList<Allocation> pickRestoreAllocations) {
		this.pickRestoreAllocations = pickRestoreAllocations;
	}

	public void setPreviousAllocations(ArrayList<Allocation> previousAllocations) {
		this.previousAllocations = previousAllocations;
	}

	public void setPrioritizedDemands(TreeMap<String, Demand> prioritizedDemands) {
		assertSizes(getDemands(), prioritizedDemands);
		this.prioritizedDemands = prioritizedDemands;
	}

	public void setPrioritizedDemandsWithinLeadTime(TreeSet<Demand> prioritizedDemandsWithinLeadTime) {
		this.prioritizedDemandsWithinLeadTime = prioritizedDemandsWithinLeadTime;
	}


	public void setTmpItems(List<TmpItem> tmpItems) {
		this.tmpItems = tmpItems;

	}

//	/**
//	 * @param traceFileSet the traceFileSet to set
//	 */
//	public void setTraceFileSet(boolean traceFileSet) {
//		this.traceFileSet = traceFileSet;
//	}

	public void setUtFacilities(List<UtFacility> utFacilities) {
		if (utFacilities == null) {
			throw new IllegalArgumentException("utFacilities is null");
		}
		logger.debug("setUtFacilities: utFacilities.size() %d", utFacilities.size());
		this.utFacilities = utFacilities;
		utFacilityById = new TreeMap<String, UtFacility>();
		for (UtFacility uf : utFacilities) {
			if (logger.isDebugEnabled()) {
				logger.debug("adding facility: {}", stringBean.asString(uf));
			}
			utFacilityById.put(uf.getFacility(), uf);
		}
	}

	public void updateException(int itemNbr, String message) {
		throw new UnsupportedOperationException(); // TODO
	}

	public ArrayList<String> verifyAllocations() {
		verificationMessages = new ArrayList<String>();
		for (Demand demand : getDemands()) {
			double totalAlloc = 0;
			for (Allocation allocation : demand.getAllocations(AllocationMode.FIRST_PASS)) {
				totalAlloc += allocation.getAllocQty();
			}
			if (totalAlloc > demand.getGrossOpenQty()) {
				verificationMessages.add("overAllocated grossOpen " + demand.getGrossOpenQty() + " allocated "
						+ totalAlloc + " for demand: " + demand.toString());
			}
		}
		return verificationMessages;
	}

	public void setOeCustMastById(Map<Integer, OeCustMast> oeCustMastById) {
		this.oeCustMastById =  oeCustMastById;
	}

	public void setApsSplyPools(Collection<ApsSplyPool> pools)  {
		apsSplyPoolById = new TreeMap<>();
		for (ApsSplyPool apsSplyPool : pools) {
			apsSplyPoolById.put(apsSplyPool.getApsSplyPoolCd(),apsSplyPool);
		}
	}
	public ApsSplyPool getApsSplyPool(String apsSplyPoolCd) {
		if (apsSplyPoolById == null) {
			throw new  IllegalStateException("apsSplyPoolById  is null");
		}
		ApsSplyPool retval =  apsSplyPoolById.get(apsSplyPoolCd);
		if (retval == null) {
			throw new IllegalArgumentException("key for aps_sply_pool" + apsSplyPoolCd + " not found");
		}
		return retval;
	}

	public Map<String, ApsSplyPool> getApsSplyPoolById() {
		return apsSplyPoolById;
	}

	public void addTimer(Timer timer) {
		timers.add(timer);
	}

	public List<Timer> getTimers() {
		return timers;
	}
	public int getPlanGrpNbr() {
		return planGrpNbr;
	}

	public int getNextAllocationNumber() {
		return nextAllocationNumber;
	}

	public void setNextAllocationNumber(int nextAllocationNumber) {
		this.nextAllocationNumber = nextAllocationNumber;
	}

	public TreeMap<String,ApsSrcRuleSetExt> getReferencedSourcingRuleSets() {	
		TreeMap<String,ApsSrcRuleSetExt> ruleSet = new TreeMap<String, ApsSrcRuleSetExt>();
		for (Demand d : demands) {
			ApsSrcRuleSet set  = d.getApsSrcRuleSet();
			ApsSrcRuleSetExt setx = getApsSrcRuleSetExt(set.getApsSrcRuleSetNbr());
			ruleSet.put(setx.getApsSrcRuleSetCd(), setx);
		}
		return ruleSet;
	}

	public Map<String,FcstGrp> getReferencedFcstGrpById() {
		TreeMap<String,FcstGrp> referred = new TreeMap<>();
		for (ApsDmdFc d : apsDmdFcs) {
			referred.put(d.getFcstGrp(),fcstGrpById.get(d.getFcstGrp()));
		}
		return referred;
	}
	public TreeMap<Integer, FcItemMast> getFcItemMastById() {
		return fcItemMastById; 
	}
	public void setItemNumbers(Collection<Integer> itemNumbers) {
		this.itemNumbers =  itemNumbers;
	}
	public Collection<Integer> getItemNumbers() {
		return itemNumbers;
	}
	public void setVqQteVws(List<VqQteVw> vqQteVws) {
		this.vqQteVws = vqQteVws;
	}
	
	public List<VqQteVw> getVqQteVws() {
		return vqQteVws;
	}
	public void setOeOrdDtlHists(List<OeOrdDtlHist> oeOrdDtlHists) {
		this.oeOrdDtlHists = oeOrdDtlHists;
		
	}
	
	public List<OeOrdDtlHist> getOeOrdDtlHists() {
		return oeOrdDtlHists;
	}
	
	public int getApsResultDtlDmdId() {
		return apsResultDtlDmdId;
	}
	
	public void setApsResultDtlDmdId(int next) {
		apsResultDtlDmdId = next;
	}
	public void setOeItemHistFcstGrps(List<OeItemHistFcstGrp> oeItemHistFcstGrps) {
		this.oeItemHistFcstGrps = oeItemHistFcstGrps;
	}
	
	public List<OeItemHistFcstGrp> getOeItemHistFcstGrps() {
		return oeItemHistFcstGrps;
	}
	
	/**
	 * @return the apsResultDtlDmds
	 */
	public ArrayList<ApsResultDtlDmd> getApsResultDtlDmds() {
		return apsResultDtlDmds;
	}
	/**
	 * @param apsResultDtlDmds the apsResultDtlDmds to set
	 */
	public void setApsResultDtlDmds(ArrayList<ApsResultDtlDmd> apsResultDtlDmds) {
		this.apsResultDtlDmds = apsResultDtlDmds;
	}
	
	public void populateForecastBucketsByForecastGroup() {
		//forecastBucketsbyForecastGroup
		buildBuckets();
		forecastGroups = new ForecastGroups(demandForecastById.values(),dateGenerator, icItemMastsById, fcItemMastById);
	}
	
	void populateOrderGroups() {
		orderGroups = new OrderGroups(demandCustomerById.values(),dateGenerator);
	}
	
	public TreeSet<String> getDemandForecastGroupNames() {
		TreeSet<String> names = new TreeSet<>();
		for (ApsDmdOo oo : apsDmdOos) {
			names.add(oo.getFcstGrp());
		}
		for (ApsDmdWo wo : apsDmdWos) {
			names.add(wo.getFcstGrp());
		}
		for (ApsDmdSs ss: apsDmdSss) {
			names.add(ss.getFcstGrp());
		}
		for (ApsDmdFc fc : apsDmdFcs) {
			names.add(fc.getFcstGrp());
		}
		return names;
	}
	Date getMaxDate() {
		Date maxDate = new Date();
		for (SupplyReplen po : getSupplyReplenById().values()) {
			if (po.getAvailDt().after(maxDate)) {
				maxDate = po.getAvailDate();
			}
		}
		for (DemandForecast fc : getDemandForecastById().values()) {
			if (fc.getNeedByDate().after(maxDate)) {
				maxDate = fc.getNeedByDate();
			}
		}
		for (DemandCustomer dc : getDemandCustomerById().values()) {
			if (dc.getNeedByDate().after(maxDate)) {
				maxDate = dc.getNeedByDate();
			}
		}
		return maxDate;
	}
	
	private void setDateGenerator() {
		java.util.Date firstDayThisMonth = DateHelper.getFirstDateInMonth(getEffectiveDate());
		Date maxDate = getMaxDate();
		int monthsBetween = DateUtils.monthsBetween(firstDayThisMonth, maxDate);
		dateGenerator = new DateGenerator();
		dateGenerator.setFirstDate(firstDayThisMonth);
		dateGenerator.setIncrementInMonths(1);
		dateGenerator.generateBuckets(monthsBetween + 1);
	}

	private void buildBuckets() {
		setDateGenerator();
	}
	
	public ForecastGroups getForecastGroups() {
		return forecastGroups;
	}
	public OrderGroups getOrderGroups() {
		return orderGroups;
	}
	
	public String getPlanGroupPipelineDtoAsJson() {
		PlanGroupPipeline pipe = new PlanGroupPipeline(this);
		PlanGroupPipelineDTO dto = new PlanGroupPipelineDTO(pipe);
		return dto.toJson(dillon);
	}
	
	public String getForecastGroupsDtoAsJson() {
		ForecastGroupsDTO dto = new ForecastGroupsDTO(getForecastGroups());
		return dto.toJson(dillon);
		
	}
	public DateGenerator getDateGenerator() {
		return dateGenerator;
	}
	
	public void setItemNbrsByLotNbr(Map<Integer,ArrayList<Integer>> map) {
		itemNbrsByLotNbr = map;
	}
	public Map<Integer,ArrayList<Integer>>  getItemNbrsByLotNbr() {
		return itemNbrsByLotNbr;
	}
	
	public HashMap<Integer, List<Object>> getMissingOrgNbrs() {
		return missingOrgNbrs;
	}
	
	public String toJson(Object o)  {
		return dillon.toJson(o);
	}
}
