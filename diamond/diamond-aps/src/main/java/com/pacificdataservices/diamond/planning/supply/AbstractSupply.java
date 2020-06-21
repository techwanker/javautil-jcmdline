package com.pacificdataservices.diamond.planning.supply;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.javautil.core.misc.Buckets;
import org.javautil.core.misc.MultiKey;
import org.javautil.core.text.SimpleDateFormatFactory;
import org.javautil.util.NameValue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.pacificdataservices.diamond.models.ApsSplyPool;
import com.pacificdataservices.diamond.models.ApsSplySubPool;
import com.pacificdataservices.diamond.models.ApsSrcRule;
import com.pacificdataservices.diamond.models.ApsSrcRuleSet;
import com.pacificdataservices.diamond.models.IcCertCd;
import com.pacificdataservices.diamond.models.IcItemMast;
import com.pacificdataservices.diamond.models.IcLotMast;
import com.pacificdataservices.diamond.models.IcLotMastCert;
import com.pacificdataservices.diamond.planning.Allocation;
import com.pacificdataservices.diamond.planning.AllocationMode;
import com.pacificdataservices.diamond.planning.demand.Demand;

/**
 * TODO has a plannedOutQty and transferOutQty figure out why and fix. TODO does
 * this have something to do with picks? Abstract class for maintaining temporal
 * representation of any supply for goods are services that are currently
 * available or scheduled to become available to satisfy demand.
 * 
 * @see Supply
 * @see Demand
 * @see Allocation
 */
public abstract class AbstractSupply implements Supply {
	transient private Logger logger = LoggerFactory.getLogger(getClass());

	transient private IcItemMast icItemMast;
	private SimpleDateFormat sdf = SimpleDateFormatFactory.getYyyyDashMmDashDd();
	private String xmlId;
	private Date adjustedAvailDate;
	private String id;
	transient private IcLotMast icLotMast;
	transient private ApsSplySubPool apsSplySubPool;
	private BigDecimal grossAvailQty;
	private String supplyIdentifier;
	private String facility;
	private Integer apsSplySubPoolNbr;
	private Integer orgNbrMfr;
	private int orgNbrVnd;
	private Integer lotNbr;
	private String lotUm;
	private int itemNbr;
	private String revLvl;
	private int pkSupply;
	private BigDecimal lotCost;
	private String cntryCdOrigin;
	private Date mfrDate;
	private Date expireDt;
	private Date rcptDt;
	private String availDtId;
	private Date effectiveDate;
	private Date availDt;

	/*
	 * allocations
	 */
	transient private ArrayList<Allocation> firstPassAllocations = new ArrayList<Allocation>();
	transient private TreeMap<Integer, ArrayList<Allocation>> customerPrioritizedAllocations = new TreeMap<Integer, ArrayList<Allocation>>();
	transient private ArrayList<Allocation> overShipAllocations = new ArrayList<Allocation>();
	transient private HashMap<Integer, Double> availabilityByCustomer;
	transient private Map<String, IcCertCd> icCertCdMap = new HashMap<String, IcCertCd>();
	private ApsSplyPool apsSplyPool;
	private Buckets<Double> projectedPositionBuckets;

	private TreeMap<String, IcItemMast> icItemMastByItemCd;

	@Override
	public void addAllocation(Allocation allocation, AllocationMode mode) {
		List<Allocation> allocations = getAllocations(mode);
		allocations.add(allocation);
	}

	@Override
	public Date getAdjustedAvailDate() {
		// TODO Auto-generated method stub
		return adjustedAvailDate;
	}

	@Override
	public ArrayList<Allocation> getAllocations(AllocationMode mode) {
		ArrayList<Allocation> allocations = null;
		switch (mode) {
		case FIRST_PASS:
			allocations = firstPassAllocations;
			break;
		case PICK_RESTORE:
			allocations = firstPassAllocations;
			break;
		case CUSTOMER_PRIORITIZED:
			allocations = new ArrayList<Allocation>();
			for (ArrayList<Allocation> customerAllocations : customerPrioritizedAllocations.values())
				allocations.addAll(customerAllocations);
			break;
		case OVERSHIP:
			allocations = overShipAllocations;
			break;

		default:
			throw new IllegalArgumentException("unsupported mode " + mode);
		}
		// logger.info("MODE IS " + mode + " AND ALLOCATION SIZE IS " +
		// allocations.size());
		return allocations;
	}

	public ArrayList<Allocation>getAllocationsForBucket(AllocationMode mode,  Date onOrAfter, Date dateBefore) {
		ArrayList<Allocation> allocations = getAllocations(mode);
		ArrayList<Allocation> retval  = new ArrayList<Allocation>();
		double bucketAlloc = 0;
		for (Allocation allocation :allocations) {
			Date allocationDate = allocation.getAllocationDate();
			if ( allocationDate.before(dateBefore)) {
				if(! allocationDate.before(onOrAfter)) {
					retval.add(allocation);
					bucketAlloc += allocation.getAllocQty();
				}
			}
		}
		logger.debug("bucketAlloc {}",bucketAlloc);
		return retval;
	}

	public ArrayList<Allocation>getAllocationsForBucket(AllocationMode mode, Supply supply, Date onOrAfter, Date dateBefore) {
		ArrayList<Allocation> allocations = getAllocations(mode);
		ArrayList<Allocation> retval  = new ArrayList<Allocation>();
		double bucketAlloc = 0;
		for (Allocation allocation :allocations) {
			Date allocationDate = allocation.getAllocationDate();
			boolean added = false;
			if (allocation.getSupply().getSupplyIdentifier().equals(supply.getSupplyIdentifier())) {
				if ( allocationDate.before(dateBefore)) {
					if(! allocationDate.before(onOrAfter)) {
						retval.add(allocation);
						bucketAlloc += allocation.getAllocQty();
						added = true;
					}
				}
			}
			if  (added) {
				logger.debug("\nadded {} bucketAlloc {} mode: {} onOraAfter {}, before {}",allocation.bucketString(), bucketAlloc, mode, onOrAfter, dateBefore);
			} else {
				logger.debug("\ndid not add {} bucketAlloc {} mode: {} onOraAfter {}, before {}",allocation.bucketString(), bucketAlloc, mode, onOrAfter, dateBefore);
			}
		}
		if (logger.isDebugEnabled()) {
			StringBuilder sb = new StringBuilder();
			for (Allocation allocation : retval) {
				sb.append(allocation.bucketString());
				sb.append("\n");
			}
			logger.debug("allocations:\n{}" ,sb.toString());
			logger.debug("\nfinal Supply {} size {} bucketAlloc {} mode: {} onOraAfter {}, before {}", supply.getSupplyIdentifier(), retval.size(), bucketAlloc, mode, onOrAfter, dateBefore);
		}
		return retval;
	}
	
	@Override
	public double getQtyAllocatedBucket(AllocationMode mode,  Date onOrAfter, Date dateBefore ) {
		List<Allocation> allocations = getAllocationsForBucket(mode,onOrAfter,dateBefore);
		double bucketAllocQty = 0;
		for (Allocation allocation :allocations) {
			bucketAllocQty += allocation.getAllocQty();
		}
		return bucketAllocQty;
	}

//	@Override
//	public double getQtyAllocatedBucket(AllocationMode mode, Supply supply, Date onOrAfter, Date dateBefore ) {
//		boolean debugging = logger.isDebugEnabled();
//
//		List<Allocation> allocations = getAllocationsForBucket(mode,supply,onOrAfter,dateBefore);
//		double bucketAllocQty = 0;
//		NameValue nv = new NameValue();
//		for (Allocation allocation :allocations) {
//			bucketAllocQty += allocation.getAllocQty();
//			//			nv.put("allocationDate",sdf.format(allocation.getAllocationDate()));
//			//			nv.put("allocationQty",allocation.getAllocQty());
//			//			nv.put("bucketAlloc",bucketAllocQty);
//			//
//			//			logger.debug("\n{}",nv);
//		}
//		logger.debug("final\n{}",nv);
//
//		return bucketAllocQty;
//	}

	public double getQtyAllocated(AllocationMode mode) {
		double qtyAllocated = 0.0;
		List<Allocation> allocations = getAllocations(mode);
		for (Allocation allocation :allocations) {
			qtyAllocated += allocation.getAllocQty();
		}
		return qtyAllocated;
	}

	public HashMap<Integer, Double> getAvailabilityByCustomer() {

		if (availabilityByCustomer == null) {
			availabilityByCustomer = new HashMap<Integer, Double>();
			for (Allocation allocation : firstPassAllocations) {
				Integer customer = allocation.getDemand().getOeCustMast().getOrgNbrCust();
				Double allocated = availabilityByCustomer.get(customer);
				if (allocated == null) {
					allocated = allocation.getAllocQty();
					availabilityByCustomer.put(customer, allocated);
				} else {
					// TODO what is this? only the first is ever used?
					// implicit unboxing and boxing in one op
					allocated += allocation.getAllocQty().doubleValue();
				}
			}
		}
		return availabilityByCustomer;
	}

	// /**
	// * P and F planned and Firm ?
	// * @return
	// */
	// public String getAvailDateTypeId() {
	// throw new UnsupportedOperationException();
	// // TODO Auto-generated method stub
	// }

	/**
	 * TOOD unreferenced and I don't even know what it is supposed to do.
	 * 
	 * @param mode
	 * @return
	 */
	// @Override
	// public double getAvailQty(AllocationMode mode) {
	// // TODO Auto-generated method stub
	// throw new UnsupportedOperationException();
	// }

	@Override
	public int getCertValue() {
		// TODO
		return 0;
	}

	@Override
	public Map<String, IcCertCd> getIcCertCds() {
		return icCertCdMap;
	}

	public Date getMinimumDemandDate(AllocationMode mode) {
		List<Allocation> allocations = getAllocations(mode);
		Date minDate = null;
		for (Allocation allocation : allocations) {
			Date demandDate = allocation.getDemand().getNeedByDate();
			if (minDate == null || demandDate.before(minDate)) {
				minDate = demandDate;
			}
		}
		return minDate;
	}

	@Override
	@Deprecated
	public double getNetAvailableForCustomer(Object customerNumber) {
		throw new UnsupportedOperationException();
	}


	@Override
	@Deprecated
	// TODO FEATURE 
	public Integer getPlannedTransferNbr() {
		throw new UnsupportedOperationException(); // TODO
	}

	// TODO
	@Deprecated
	public double getPlannedTransferOutQty() {
		throw new UnsupportedOperationException(); // TODO
	}

	// TODO cache results
	// TODO  review  does the  facility  hae to matcch
	@ Override
	public ApsSrcRule getSourcingRule(Demand demand) {
		ApsSrcRule retval = null;

		ApsSrcRuleSet ruleSet = demand.getApsSrcRuleSet();

		for (ApsSrcRule rule : ruleSet.getApsSrcRules()) {
			boolean facilityMatch = getFacility().equals(rule.getUtFacility().getFacility());
			boolean subPoolMatch = getApsSplySubPoolNbr().equals(rule.getApsSrcRuleNbr());
			boolean splyTypeMatch = getSplyTypeId().equals(rule.getSplyTypeId());
			if (facilityMatch && subPoolMatch && splyTypeMatch) {
				retval = rule;
				break;
			}
		}
		if (retval == null) {
			throw new java.lang.IllegalStateException("null rule for supply \n" + toString() + "\n from ruleset \n"
					+ ruleSet.getApsSrcRuleSetCd() + "\n for demand \n" + demand);
		}
		return retval;
	}


	public void setApsSplyPool (ApsSplyPool apsSplyPool) { this.apsSplyPool = apsSplyPool; }
	public ApsSplyPool getApsSplyPool() { return apsSplyPool; } 
	//	public String getSplyPoolCd() {
	//		return apsSplySubPool.getApsSplyPool().getApsSplyPoolCd();
	//	}

	public String getXmlId() { return xmlId; } 
	public void setXmlId(String string) { this.xmlId = string; } 
	@Override
	public void addCertification(IcCertCd certCd) {
		if (certCd == null) {
			throw new IllegalArgumentException("certCd is null");
		}
		icCertCdMap.put(certCd.getCertCd(), certCd);
	}

	public void setId(String id) { this.id = id; }

	@Override public String getId() { return id; }

	// TODO this should only be in SupplyOnhand
	@Override public void setIcLotMast(IcLotMast lot) { this.icLotMast = lot; }

	@Override public String getSplyTypeId() { return getApsSplySubPool().getSplyPoolTypeId(); }

	// public void setApsSplySubPool(ApsSplySubPool apsSplySubPool) {
	// if (apsSplySubPool == null) {
	// throw new IllegalArgumentException("apsSplySubPool is null");
	// }
	// this.apsSplySubPool = apsSplySubPool;
	// }

	public List<Allocation> getFirstPassAllocations() { return firstPassAllocations; }
	public void setFirstPassAllocations(ArrayList<Allocation> firstPassAllocations) { this.firstPassAllocations = firstPassAllocations; }
	public TreeMap<Integer, ArrayList<Allocation>> getCustomerPrioritizedAllocations() { return customerPrioritizedAllocations; }
	public void setCustomerPrioritizedAllocations( TreeMap<Integer, ArrayList<Allocation>> customerPrioritizedAllocations) { this.customerPrioritizedAllocations = customerPrioritizedAllocations; }
	public List<Allocation> getOverShipAllocations() { return overShipAllocations; }
	public void setOverShipAllocations(ArrayList<Allocation> overShipAllocations) { this.overShipAllocations = overShipAllocations; }
	public Map<String, IcCertCd> getIcCertCdMap() { return icCertCdMap; }
	public void setIcCertCdMap(Map<String, IcCertCd> icCertCdMap) { this.icCertCdMap = icCertCdMap; }
	public IcLotMast getIcLotMast() { return icLotMast; }

	@Override
	public ApsSplySubPool getApsSplySubPool() {
		if (apsSplySubPool == null) {
			throw new IllegalStateException("apsSplySubPool is null");
		}
		return apsSplySubPool;
	}

	public void setAvailabilityByCustomer(HashMap<Integer, Double> availabilityByCustomer) {
		this.availabilityByCustomer = availabilityByCustomer;
	}

	public void setAdjustedAvailDate(Date adjustedAvailDate) { this.adjustedAvailDate = adjustedAvailDate; }
	@Override public void setIcItemMast(IcItemMast icItemMast) { this.icItemMast = icItemMast; }

	@Override
	public IcItemMast getIcItemMast() {
		if (icItemMast == null) {
			throw new IllegalStateException("icItemMast is null");
		}
		return icItemMast;
	}

//	@Override
//	@Deprecated
//	public Character getSupplyTypeCd() {
//		throw new UnsupportedOperationException("use isPurchaseOrder etc.");
//	}

	@Override
	public void setApsSplySubPool(ApsSplySubPool subPool) {
		if (subPool == null) {
			throw new IllegalArgumentException("subPool is null");
		}
		if (subPool.getApsSplySubPoolNbr() != this.getApsSplySubPoolNbr()) {
			throw new IllegalArgumentException(
					"expected apsSplySubPoolNbr" + this.getApsSplySubPoolNbr() + " " + subPool);
		}
		this.apsSplySubPool = subPool;
	}

	//	public static String getId(Integer lotNbr, Integer apsSplySubPoolNbr, String facility, Date availDate) {
	//
	//		String id = lotNbr + "~" + apsSplySubPoolNbr + "~" + facility + "~" + availDate;
	//
	//		return id;
	//	}

	double getAllocatedQty(AllocationMode mode) {
		double allocatedQty = 0;
		int count = 0;
		for (Allocation allocation : getAllocations(mode)) {
			allocatedQty += allocation.getAllocQty();
			count++;
		}
		//logger.info("getAllocatedQty:: gross avail " + getGrossAvailQty() + " allocated: " + allocatedQty + " count " + count);
		return allocatedQty;
	}

	@Override
	public double getUnallocatedQty(AllocationMode mode) {
		double grossAvail = getGrossAvailQty().doubleValue();
		double allocatedQty = getAllocatedQty(mode);
		return grossAvail - allocatedQty;
	}

	@Override public boolean isOnhand() { return this instanceof SupplyOnhand; }
	@Override public boolean isWorkOrder() { return this instanceof SupplyWorkOrder; } 
	@Override public boolean isPurchaseOrder() { return this instanceof SupplyReplen; } 
	@Deprecated
	@Override public boolean isItem(int itemNbr) { throw new UnsupportedOperationException(); } 
	@Deprecated
	@Override public Date getMinimumDemandDate() { throw new UnsupportedOperationException(); } 
	@Deprecated
	@Override public Collection<IcLotMastCert> getCertifications() { throw new UnsupportedOperationException(); }
	@Override public String getManufacturerCode() { return null; } 
	public Date getEffectiveDate() { return effectiveDate; } 
	public String getSplyIdentifier() { return supplyIdentifier; } 
	@Override public String getFacility() { return facility; }
	@Override public Integer getApsSplySubPoolNbr() { return apsSplySubPoolNbr; }
	@Override public Integer getOrgNbrMfr() { return orgNbrMfr; }
	public int getOrgNbrVnd() { return orgNbrVnd; } 
	@Override public Integer getLotNbr() { return lotNbr; }
	public String getLotUm() { return lotUm; }
	@Override public int getItemNbr() { return itemNbr; } 
	public Date getAvailDt() { return availDt; }
	public BigDecimal getGrossAvailQty() { return grossAvailQty; } 
	public String getRevLvl() { return revLvl; } 
	public int getPkSupply() { return pkSupply; } 
	public BigDecimal getLotCost() { return lotCost; } 
	@Override public String getCntryCdOrigin() { return cntryCdOrigin; }
	@Override public Date getExpireDt() { return expireDt; }
	public Date getRcptDt() { return rcptDt; }
	public String getAvailDtId() { return availDtId; } 
	@Override public Date getDateOfManufacture() { return mfrDate; }
	@Override public Date LotExpirationDate() { return expireDt; }
	@Deprecated // use getSupplyIdentifier
	@Override public String getIdentifierString() { return supplyIdentifier; }
	@Override public Date getAvailDate() { return availDt; }
	@Override public String getSupplyIdentifier() { return supplyIdentifier; }
	@Override public double getAvailQty(AllocationMode mode) { return grossAvailQty.doubleValue(); }
	protected void setGrossAvailQty(BigDecimal grossAvailQty) { this.grossAvailQty = grossAvailQty; }
	protected void setSupplyIdentifier(String supplyIdentifier) { this.supplyIdentifier = supplyIdentifier; }
	protected void setFacility(String facility) { this.facility = facility; }
	protected void setApsSplySubPoolNbr(Integer apsSplySubPoolNbr) { this.apsSplySubPoolNbr = apsSplySubPoolNbr; }
	public void setOrgNbrMfr(Integer orgNbrMfr) { this.orgNbrMfr = orgNbrMfr; }
	protected void setOrgNbrVnd(int orgNbrVnd) { this.orgNbrVnd = orgNbrVnd; }
	protected void setLotNbr(Integer lotNbr) { this.lotNbr = lotNbr; }
	protected void setLotUm(String lotUm) { this.lotUm = lotUm; }
	protected void setItemNbr(int itemNbr) { this.itemNbr = itemNbr; }
	protected void setRevLvl(String revLvl) { this.revLvl = revLvl; }
	protected void setPkSupply(int pkSupply) { this.pkSupply = pkSupply; }
	protected void setLotCost(BigDecimal lotCost) { this.lotCost = lotCost; }
	protected void setCntryCdOrigin(String cntryCdOrigin) { this.cntryCdOrigin = cntryCdOrigin; }
	protected void setMfrDate(Date mfrDate) { this.mfrDate = mfrDate; }
	public void setExpireDt(Date expireDt) { this.expireDt = expireDt; }
	protected void setRcptDt(Date rcptDt) { this.rcptDt = rcptDt; }
	protected void setAvailDt(Date availDt) { this.availDt = availDt; }
	protected void setAvailDtId(String availDtId) { this.availDtId = availDtId; }
	public double getQtyAllocatedFirstPass() { return getQtyAllocated(AllocationMode.FIRST_PASS); }
	public double getQtyUnallocatedFirstPass() { return grossAvailQty.doubleValue() - getQtyAllocatedFirstPass(); }
	public void setProjectedPositionBuckets(Buckets<Double> buckets)  { this.projectedPositionBuckets = buckets; }
	public Buckets<Double> getProjectedPositionBuckets() { return this.projectedPositionBuckets; }
	public void setIcItemMastByItemCd(TreeMap<String,IcItemMast> map) { icItemMastByItemCd = map; }
	public Map<String,IcItemMast> getIcItemMastByItemCd() {
		if (icItemMastByItemCd == null) {
			logger.warn("icItemMastByItemCd is null, setting to the icItemMast");
			TreeMap<String,IcItemMast> w = new TreeMap<>();
			w.put(icItemMast.getItemCd(),icItemMast);
			this.icItemMastByItemCd = w;
		}
		return icItemMastByItemCd;
	}

	public ArrayList<String> getItemCdList() {
		Collection<String>itemCodes= getIcItemMastByItemCd().keySet();
		ArrayList<String> retval = new ArrayList<String>(itemCodes.size());
		for (String itemCode : itemCodes) {
			retval.add(itemCode);
		}
		return retval;
	}

	public MultiKey  getItemCodeMultiKey() {
		return new MultiKey(getItemCdList());
	}

	public Date getFirstAllocationDate() {
		Date retval = null;

		for (Allocation a : firstPassAllocations)  {
			if (retval  == null || a.getAllocationDate().before(retval)) {
				retval = a.getAllocationDate();
			}
		}
		return retval;
	}


}
