package com.pacificdataservices.diamond.planning.demand;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

import org.javautil.buckets.DateHelper;
import org.javautil.hibernate.HibernateMarshallerFactory;
import org.javautil.util.Day;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.Gson;
import com.pacificdataservices.diamond.models.ApsSrcRuleSet;
import com.pacificdataservices.diamond.models.FcstGrp;
import com.pacificdataservices.diamond.models.IcCertCd;
import com.pacificdataservices.diamond.models.IcItemMast;
import com.pacificdataservices.diamond.models.NaOrg;
import com.pacificdataservices.diamond.models.OeCustMast;
import com.pacificdataservices.diamond.models.UtFacility;
import com.pacificdataservices.diamond.planning.Allocation;
import com.pacificdataservices.diamond.planning.AllocationMode;
import com.pacificdataservices.diamond.planning.EligibleSupplies;
import com.pacificdataservices.diamond.planning.EligibleSupply;
import com.pacificdataservices.diamond.planning.PlanningDataException;
import com.pacificdataservices.diamond.planning.container.ApsSrcRuleSetExt;
import com.pacificdataservices.diamond.planning.data.PlanningData;
import com.pacificdataservices.diamond.planning.filter.SupplyEligibilityTest;
import com.pacificdataservices.diamond.planning.supply.Supply;
import com.pacificdataservices.jdbc.PersistenceAction;

/**
 * @author Jim Schmidt TODO difference between needbydt and rqstdt
 */
public abstract class AbstractDemand implements Demand {
	transient protected Logger logger = LoggerFactory.getLogger(getClass());

	//private static transient final Gson dillon = HibernateMarshallerFactory.getHibernateGsonWithProxyDateFormatter();

	private Map<AllocationMode, List<Allocation>> allocationsByMode = new HashMap<AllocationMode, List<Allocation>>() {
		private static final long serialVersionUID = 6863088545524330120L;
		{
			put(AllocationMode.FIRST_PASS, allocationsFirstPass);
			put(AllocationMode.CUSTOMER_PRIORITIZED, customerAvailableAllocations);
			put(AllocationMode.OVERSHIP, overshipAllocations);
		}
	};

	private Map<String, Allocation> allocationsBySupplyXmlId = new LinkedHashMap<>();
	private List<Allocation> allocationsFirstPass = new ArrayList<Allocation>();
//	private transient ApsSrcRuleSet apsSrcRuleSet;
	private transient ApsSrcRuleSetExt apsSrcRuleSetExt;
	private int apsSrcRuleSetNbr;
	private String contractCustFlg;
	private BigDecimal custAllocPrty;
	private List<Allocation> customerAvailableAllocations = new ArrayList<Allocation>();
	private List<EligibleSupply> customerEligibleSupplies;
	private FcstGrp demandFcstGrp;
	private int demandPriority;
	private String dmdCd;
	private String dmdTypeCd;
	private EligibleSupplies eligibleSupplies;
	//
	// Not from the persistent bean
	//
	private java.sql.Date endLeadTime;
	private int fcItemMastNbr;
	private String fcstGrp;
	private List<IcCertCd> icCertCds = new ArrayList<IcCertCd>();
	private IcItemMast icItemMast;
	private Serializable identifier;
	private Map<Supply, Set<SupplyEligibilityTest>> ineligibleSupplies = new HashMap<>();
	private int itemNbrAllocRqst;
	private int itemNbrDmd;
	private NaOrg naOrgMfrRqst;
	private transient OeCustMast oeCustMast;
	private BigDecimal openQty;
	private BigDecimal openQtyAdj;
	private String orgCdCust;
	private int orgNbrCust;
	private Integer orgNbrMfrRqst;
	private List<Allocation> overshipAllocations = new ArrayList<Allocation>();
	transient private PlanningData planningData;
	private List<Allocation> previousAllocations = new ArrayList<Allocation>();
	private transient UtFacility primarySourcingFacility;
	private TreeSet<Demand> prioritizedDemandsWithinLeadTime;
	private String priorityCode;
	private String priorityWithinCustomer;
	private Map<AllocationMode, Double> quantityAllocatedByMode = new TreeMap<AllocationMode, Double>();
	private String revLvl;
	private Date rqstDt;
	private Boolean withinLeadTime;
	private String xmlId;

	private Date setLotNotExpireBeforeDt;

	private Date lotNotExpireBeforeDt;

	/**
	 * add this allocation to the container of allocations for this demand.
	 * 
	 * @param val
	 */
	@Override
	public final void addAllocation(Allocation val, AllocationMode mode) {
		Supply supply = val.getSupply();
		String xmlId = supply.getSupplyIdentifier();
		allocationsBySupplyXmlId.put(xmlId, val);
		getAllocations(mode).add(val);
		Double qtyAlloc = quantityAllocatedByMode.get(mode);
		Double newAllocQty = val.getAllocQty();
		if (qtyAlloc == null) {
			newAllocQty = new Double(val.getAllocQty());
		} else {
			newAllocQty = qtyAlloc.doubleValue() + newAllocQty.doubleValue();
		}
		quantityAllocatedByMode.put(mode, newAllocQty);
	}

	public void addCertification(IcCertCd certCd) {
		icCertCds.add(certCd);
	}

	public void addIneligibleReason(Supply supply, SupplyEligibilityTest test) {
		Set<SupplyEligibilityTest> ineligibleReasons = ineligibleSupplies.get(supply);
		if (ineligibleReasons == null) {
			ineligibleReasons = new HashSet<SupplyEligibilityTest>();
			ineligibleSupplies.put(supply, ineligibleReasons);
		}
		ineligibleReasons.add(test);
	}

	public final void addPreviousAllocation(Allocation allocation) {
		previousAllocations.add(allocation);
	}

	/**
	 * @return
	 */
	@Override
	// TODO what is with this quantityToAllocate
	public ArrayList<Allocation> allocate(AllocationMode mode) {
		logger.debug("============================= allocate ========================================");
		if ("LACORE".equals(fcstGrp)) {
			logger.debug("================ LACORE =================");
		}
		ArrayList<Allocation> allocations = new ArrayList<Allocation>();
		if (eligibleSupplies == null) {
			throw new IllegalStateException("eligible supplies is null");
		}

		double allocationNeedForThisDemand = getQuantityUnallocated(mode); // Current allocation shortage for this
																			// demand
		double allocateToThisDemand = allocationNeedForThisDemand; // Takes into consideration remaining availability
		boolean dontMixLots = isMixMfrLot();
		logger.debug("allocationNeedForThisDemand: {}\n{}", allocationNeedForThisDemand, this);

		for (EligibleSupply eligible : eligibleSupplies) {
			// logger.info("demand: {}\neligible:{}\nopenQty: {}
			// ",this.toString(),eligible.toString(),openQty);
			if (allocationNeedForThisDemand <= 0) {
				break;
			}
			double availQty = 0;
			switch (mode) {
			case FIRST_PASS:
				availQty = eligible.getSupply().getUnallocatedQty(mode);
				break;
			case CUSTOMER_PRIORITIZED:
				availQty = eligible.getSupply().getNetAvailableForCustomer(this.getCustomerNumber());
				break;
			case OVERSHIP:
				availQty = eligible.getSupply().getUnallocatedQty(mode);
				break;
			default:
				throw new IllegalStateException("unsupported mode " + mode);
			}
			if (availQty > 0.0) {
				if (allocationNeedForThisDemand >= availQty) {
					allocateToThisDemand = availQty;
					allocationNeedForThisDemand -= availQty;
				}

				if (dontMixLots && this instanceof DemandWorkOrder) {
					DemandWorkOrder wo = (DemandWorkOrder) this;
					int fullLotAllocations = (int) (allocateToThisDemand / wo.getComponentQtyPerUnit().doubleValue());
					double residualLotQty = allocateToThisDemand
							- (fullLotAllocations * wo.getComponentQtyPerUnit().doubleValue());
					allocateToThisDemand -= residualLotQty;
					allocationNeedForThisDemand += residualLotQty;
				}
				if (allocateToThisDemand > 0) {
					Allocation allocation = new Allocation(this, eligible.getSupply(), allocateToThisDemand, mode,
							PersistenceAction.INSERT);
					allocateToThisDemand = 0.0;
					allocations.add(allocation);
					this.addAllocation(allocation, mode);
					eligible.getSupply().addAllocation(allocation, mode);
				}
			}
		}
		return allocations;
	}

	public List<String> check() {
		ArrayList<String> checkMessages = new ArrayList<String>();
		// TODO check that everything has been set
		if (icItemMast == null) {
			checkMessages.add("icItemMast is null");
		}
		return checkMessages;
	}

	public void checkIntegrity() {
		if (primarySourcingFacility == null) {
			throw new IllegalStateException("primarySourcingFacility is null");
		}
	}

	/**
	 * 
	 * @return double
	 */
	public double getAllocatedQty(AllocationMode mode) {
		double allocatedSum = 0.0;
		List<Allocation> allocations = getAllocations(mode);
		for (int i = 0; i < allocations.size(); i++) {
			Allocation allocation = allocations.get(i);
			allocatedSum += allocation.getAllocQty();
		}
		return allocatedSum;
	}

	@Override
	public final List<Allocation> getAllocations(AllocationMode mode) {
		List<Allocation> returnValue = null;
		switch (mode) {
		case FIRST_PASS:
			returnValue = allocationsFirstPass;
			break;
		case PICK_RESTORE:
			returnValue = allocationsFirstPass; // TODO shouldn't this be pick
			// Restore?
			break;
		case CUSTOMER_PRIORITIZED:
			returnValue = customerAvailableAllocations;
			break;
		case OVERSHIP:
			returnValue = overshipAllocations;
			break;
		default:
			throw new IllegalArgumentException("unsupported mode " + mode);
		}
		return returnValue;
	}

	public Map<AllocationMode, List<Allocation>> getAllocationsByMode() {
		return allocationsByMode;
	}

	public List<Allocation> getAllocationsFirstPass() {
		return allocationsFirstPass;
	}

	public ApsSrcRuleSet getApsSrcRuleSet() {
		return getApsSrcRuleSetExt();
	}

	public ApsSrcRuleSetExt getApsSrcRuleSetExt() {
		return apsSrcRuleSetExt;
	}

	/**
	 * @return the allocationsBySupplyXmlId
	 */
	public Map<String, Allocation> getAllocationBySupplyXmlId() {
		return allocationsBySupplyXmlId;
	}

	@Override
	public int getApsSrcRuleSetNbr() {
		return apsSrcRuleSetNbr;
	}

	/**
	 * @todo must differentiate between a null availDt as everything is onhand and a
	 *       null because of no allocations.
	 */
	public Date getAvailDt(AllocationMode mode) {
		// Date rc = null;
		Date maxAvailDt = null;
		double allocatedQty = 0.0;
		Supply supply = null;
		Date availDt = null;

		for (Allocation allocation : getAllocations(mode)) {
			if (allocation.getSupply().isOnhand()) {
				availDt = planningData.getEffectiveDate(); // doesn't consider
				// transit
			} else {
				supply = allocation.getSupply();
				availDt = supply.getAvailDate();
			}
			allocatedQty += allocation.getAllocQty().doubleValue();
			if (maxAvailDt != null) {
				if (availDt != null && availDt.after(maxAvailDt)) {
					maxAvailDt = availDt;
				}
			} else {
				maxAvailDt = availDt;
			}
		}

		return maxAvailDt;

	}

	@Override
	public String getCntryCdOrigin() {
		throw new UnsupportedOperationException();
	}

	public String getContractCustFlg() {
		return contractCustFlg;
	}

	public BigDecimal getCustAllocPrty() {
		return custAllocPrty;
	}

	public List<Allocation> getCustomerAvailableAllocations() {
		return customerAvailableAllocations;
	}

	public final List<EligibleSupply> getCustomerEligibleSupplies() {
		return customerEligibleSupplies;
	}

	@Override
	public BigDecimal getCustomerNumber() {
		throw new UnsupportedOperationException();
	}

	@Override
	public FcstGrp getDemandFcstGrp() {
		return demandFcstGrp;
	}

	@Override
	public int getDemandPriority() {
		return demandPriority;
	}

	@Override
	public DemandType getDemandType() {
		return DemandType.getDemandType(dmdTypeCd);
	}

	@Override
	public String getDmdCd() {
		return dmdCd;
	}

	@Override
	public String getDmdTypeCd() {
		return dmdTypeCd;
	}

	@Override
	public EligibleSupplies getEligibleSupplies() {
		return eligibleSupplies;
	}

	public TreeMap<String, EligibleSupply> getEligibleSuppliesByPriority() {
		if (eligibleSupplies == null) {
			throw new IllegalStateException("eligibleSupplies is null");
		}
		return eligibleSupplies.getPrioritizedSupply();
	}

	public java.sql.Date getEndLeadTime() {
		return endLeadTime;
	}

	public int getFcItemMastNbr() {
		return fcItemMastNbr;
	}

	@Override
	public String getFcstGrp() {
		return fcstGrp;
	}

	@Override
	public double getGrossOpenQty() {
		return openQty.doubleValue();
	}

	@Override
	public List<IcCertCd> getIcCertCds() {
		return icCertCds;
	}

	/**
	 * The icItemMast for the requested Demand item
	 * 
	 * @return
	 */
	@Override
	public IcItemMast getIcItemMast() {
		return icItemMast;
	}

	// public Set<Supply> getIneligibleSupplies() {
	// return ineligibleSupplies;
	// }

	public String getIdentifierString() {
		return dmdCd;
	}

	@Override
	public List<Supply> getInapplicable() {
		throw new UnsupportedOperationException();
	}

	public Map<Supply, Set<SupplyEligibilityTest>> getIneligibleSupplies() {
		return ineligibleSupplies;
	}

	public int getItemNbrAllocRqst() {
		return itemNbrAllocRqst;
	}

	@Override
	public int getItemNbrDmd() {
		return itemNbrDmd;
	}

	public double getLateQty(AllocationMode mode) {
		double allocatedTimely = 0.0;
		Supply supply = null;
		Date availDt = null;
		Date needByDt = null;
		Iterator<?> it = getAllocations(mode).iterator();
		try {

			while (it.hasNext()) {
				Allocation allocation = (Allocation) it.next();
				supply = allocation.getSupply();

				availDt = supply.getAvailDate();
				needByDt = this.getNeedByDate();
				;
				if (availDt.after(needByDt)) {
					allocatedTimely += allocation.getAllocQty().doubleValue();
				}
			}
		} catch (java.lang.NullPointerException n) {
			if (supply == null) {
				throw new java.lang.NullPointerException("supply is null");
			}
			if (availDt == null) {
				throw new java.lang.NullPointerException("availDt is null");
			}
			if (needByDt == null) {
				throw new java.lang.NullPointerException("needByDt is null");
			}
			throw n;
		}

		return this.getGrossOpenQty() - allocatedTimely;
	}

	/**
	 * This returns the maximum availability date of any supply allocated to this
	 * demand. It is possible that the item is still not fully allocated by this
	 * date.
	 * 
	 * @return Date
	 */
	protected java.util.Date getMaximumAllocationDate(AllocationMode mode) {
		java.util.Date max = null;
		java.util.Date today = planningData.getEffectiveDate();
		java.util.Date allocationDate = null;
		List<Allocation> allocations = getAllocations(mode);

		for (int i = 0; i < allocations.size(); i++) {
			Allocation allocation = allocations.get(i);
			Supply tmpSupply = allocation.getSupply();
			allocationDate = tmpSupply.getAvailDate();
			if (max == null || allocationDate.after(max)) {
				max = allocationDate;
			}
			if (max != null && max.before(today)) {
				// TODO WTF? how about effective Date?
				// todo what about
				max = new java.sql.Date(today.getTime());
			}

		}

		return max;
	}

	@Override
	public String getMfrCd() {

		throw new UnsupportedOperationException();
	}

	public NaOrg getNaOrgMfrRqst() {
		return naOrgMfrRqst;
	}

	@Override
	public OeCustMast getOeCustMast() {
		if (oeCustMast == null) {
			throw new IllegalStateException("OeCustMast not found for " + this.toString());
		}
		return oeCustMast;
	}

	public double getOnTimeQty(AllocationMode mode) {
		double allocatedTimely = 0.0;
		Supply supply = null;
		Date availDt = null;
		for (Allocation allocation : getAllocations(mode)) {
			supply = allocation.getSupply();
			availDt = supply.getAvailDate();
			if (availDt == null) {
				throw new PlanningDataException("supply has null availDt " + supply.toString());
			}
			if (planningData == null) {
				throw new IllegalStateException("PlanningData is null for demand " + this.toString());
			}
			Date effectiveDate = planningData.getEffectiveDate();
			boolean isOnhand = supply.isOnhand();
			if (!availDt.after(effectiveDate) && isOnhand) { // what about purchase orders
				allocatedTimely += allocation.getAllocQty().doubleValue();
			}
		}
		return allocatedTimely;
	}

	@Override
	public BigDecimal getOpenQty() {
		return openQty;
	}

	public BigDecimal getOpenQtyAdj() {
		return openQtyAdj;
	}

	public String getOrgCdCust() {
		return orgCdCust;
	}

	@Override
	public int getOrgNbrCust() {
		return orgNbrCust;
	}

	@Override
	public Integer getOrgNbrMfrRqst() {
		return orgNbrMfrRqst;
	}

	public List<Allocation> getOvershipAllocations() {
		return overshipAllocations;
	}

	public PlanningData getPlanningData() {
		return planningData;
	}

	@Override
	public double getPreviousAllocationQty() {
		double previousQty = 0.0;
		for (Allocation allocation : previousAllocations) {
			previousQty += allocation.getAllocQty();
		}
		return previousQty;
	}

	public List<Allocation> getPreviousAllocations() {
		return previousAllocations;
	}

	public Date getPreviousMaxAvailDate() {
		Date retval = null;
		for (Allocation allocation : previousAllocations) {
			if (retval == null || allocation.getSupply().getAvailDate().after(retval))
				retval = allocation.getSupply().getAvailDate();
		}
		return retval;
	}

	@Override
	public String getPrimarySourcingFacility() {
		return primarySourcingFacility.getFacility();

	}

	public String getPrioritizedSuppliesFormatted() {
		if (eligibleSupplies == null) {
			throw new IllegalStateException("eligibleSupplies is null");
		}
		return eligibleSupplies.getPrioritizedSuppliesFormatted();
	}

	@Override
	public String getPriorityCode() {
		return priorityCode;
	}

	public String getPriorityWithinCustomer() {
		return priorityWithinCustomer;
	}

	public final double getQuantityAllocated(AllocationMode mode) {
		double retval = 0.0;

		for (Allocation allocation : getAllocations(mode)) {
			retval += allocation.getAllocQty().doubleValue();
		}
		return retval;
	}

	@Override
	public String getRevLvl() {
		return revLvl;
	}

	public Date getRqstDt() {
		return rqstDt;
	}

	@Override
	public double getUnallocatedQty(AllocationMode mode) {
		return openQty.doubleValue() - getQuantityAllocated(mode);
	}

	@Override
	public boolean getWithinLeadTime() {
		if (withinLeadTime == null) {
			if (getIcItemMast() == null) {
				throw new IllegalStateException("icItemMast is null for " + this.toString());
			}
			throw new IllegalStateException("withinLeadTime is null, should have been set in call to setIcItemMast");
		}
		return withinLeadTime.booleanValue();

	}

	public String getXmlId() {
		// TODO Auto-generated method stub
		return xmlId;
	}

	public boolean isAllocable() {
		throw new UnsupportedOperationException();
		// return false;
	}

	@Override
	public boolean isDegraded(AllocationMode previousMode, AllocationMode currentMode) {
		boolean returnValue = true;
		while (true) {

			if (getOnTimeQty(currentMode) >= getGrossOpenQty()) {
				returnValue = false;
				break;
			}
			if (getOnTimeQty(previousMode) > getOnTimeQty(currentMode)) {
				returnValue = true;
				break;
			}
			break;
		}
		return returnValue;
	}

	@Override
	public boolean isForecast() {
		return this instanceof DemandForecast;
	}

	public boolean isInPick() {
		boolean rc = false;
		List<Allocation> previous = getAllocations(AllocationMode.FIRST_PASS);
		for (Allocation allocation : previous) {
			if (allocation.getQtyInPick() > 0.0) {
				rc = true;
				break;
			}
		}
		return rc;
	}

	/**
	 * Implemented in DemandWorkOrder
	 * 
	 * @return
	 */
	@Override
	public boolean isMixMfrLot() {
		return false;
	}

	/**
	 * 
	 * @return true if the full gross open quantity (the non adjusted open quantity)
	 *         is not fully allocated.
	 */
	public final boolean isNotFullyAllocated(AllocationMode mode) {
		boolean rc = false;
		double requestedQuantity = getGrossOpenQty();
		double allocatedQty = getAllocatedQty(mode);
		BigDecimal bigAlloc = new BigDecimal(allocatedQty);
		double diff = requestedQuantity - allocatedQty;
		if (diff > 0) {
			rc = true;
		}
		return rc;
	}

	public boolean isPreserveAllocWithinLeadTime() {
		return true;
	}

	/**
	 * True if the needByDate falls within lead time days.
	 */
	@Override
	public boolean isWithinLeadTime() {
		Day today = new Day();
		int leadTime = getIcItemMast().getLeadTmDy();
		Date endLeadTime = DateHelper.addDays(today, leadTime + 1);
		return this.getNeedByDate().before(endLeadTime);

	}

	public final void setAllocations(ArrayList<Allocation> allocations, AllocationMode mode) {
		this.allocationsFirstPass = allocations;
	}

	public void setAllocationsByMode(Map<AllocationMode, List<Allocation>> allocationsByMode) {
		this.allocationsByMode = allocationsByMode;
	}

	public void setAllocationsFirstPass(List<Allocation> allocationsFirstPass) {
		this.allocationsFirstPass = allocationsFirstPass;
	}

	public void setApsSrcRuleSetExt(ApsSrcRuleSetExt set) {
		this.apsSrcRuleSetExt = set;
	}

	@Override
	public void setApsSrcRuleSetNbr(int apsSrcRuleSetNbr) {
		this.apsSrcRuleSetNbr = apsSrcRuleSetNbr;
	}

	public void setContractCustFlg(String contractCustFlg) {
		this.contractCustFlg = contractCustFlg;
	}

	public void setCustAllocPrty(BigDecimal custAllocPrty) {
		this.custAllocPrty = custAllocPrty;
	}

	public void setCustomerAvailableAllocations(List<Allocation> customerAvailableAllocations) {
		this.customerAvailableAllocations = customerAvailableAllocations;
	}

	public final void setCustomerEligibleSupplies(List<EligibleSupply> eligible) {
		this.customerEligibleSupplies = eligible;
	}

	@Override
	public void setDemandFcstGrp(FcstGrp fcstGrp) {
		this.demandFcstGrp = fcstGrp;
	}

	@Override
	public void setDmdCd(String dmdCd) {
		this.dmdCd = dmdCd;
	}

	@Override
	public void setDmdTypeCd(String dmdTypeCd) {
		this.dmdTypeCd = dmdTypeCd;
	}

	/**
	 * given all supplies, determine which are eligible and return the eligible set
	 */
	@Override

	public final void setEligibleSupplies(EligibleSupplies eligible) {
		this.eligibleSupplies = eligible;
		if (eligible.getPrioritizedSupply() == null) {
			throw new IllegalStateException("eligible has null prioritizedSupply");
		}
		logger.debug("setEligibleSupplies:\nDemand: {}\nprioritizedSupply:{}", this, getPrioritizedSuppliesFormatted());
	}

	public void setEndLeadTime(java.sql.Date endLeadTime) {
		this.endLeadTime = endLeadTime;
	}

	public void setFcItemMastNbr(int fcItemMastNbr) {
		this.fcItemMastNbr = fcItemMastNbr;
	}

	@Override
	public void setFcstGrp(String fcstGrp) {
		this.fcstGrp = fcstGrp;
	}

	public void setIcCertCds(List<IcCertCd> icCertCds) {
		this.icCertCds = icCertCds;
	}

	@Override
	public final void setIcItemMast(IcItemMast icItemMast) {
		this.icItemMast = icItemMast;

		int comp;

		if (icItemMast.getLeadTmDy() != null) {
			Day today = new Day(); // todo should use app_ctl or property
			// float lp = new
			// Double(appCtlS.get("leadTimePaddingFactor").getPropertyVal()).floatValue();
			float lp = 1.2f; // TODO should use property
			float totalLeadTime = lp * icItemMast.getLeadTmDy().floatValue();
			endLeadTime = DateHelper.toSqlDate(DateHelper.addDays(today, java.lang.Math.round(totalLeadTime)));
//			synchronized (dillon) {
//				logger.debug("setIcItemMast() {}", dillon.toJson(icItemMast));
//			}
			logger.debug("endLeadTime() {} needByDate {} this {}", endLeadTime, this.getNeedByDate(), this);
			comp = this.getNeedByDate().compareTo(endLeadTime);
			if (comp == 1) {
				withinLeadTime = false;
			} else {
				withinLeadTime = true;
			}
		} else {
			logger.warn("item " + icItemMast.getItemNbr() + " has no lead time");
			withinLeadTime = false;
		}
		if (withinLeadTime == null) {
			throw new IllegalStateException("logic error in setting withinLeadTime");
		}
	}

	public void setIcItemMast(IcItemMast itemMaster, Date today) {
		this.icItemMast = itemMaster;

		int comp;

		if (itemMaster.getLeadTmDy() != null) {
			float lp = 1.25f; // TODO
			// float lp = new
			// Double(appCtlS.get("leadTimePaddingFactor").getPropertyVal()).floatValue();
			float totalLeadTime = lp * itemMaster.getLeadTmDy().floatValue();
			endLeadTime = DateHelper.toSqlDate(DateHelper.addDays(today, java.lang.Math.round(totalLeadTime)));
			comp = this.getNeedByDate().compareTo(endLeadTime);
			if (comp == 1) {
				withinLeadTime = false;
			} else {
				withinLeadTime = true;
			}
		} else {
			logger.warn("item " + itemMaster.getItemNbr() + " has no lead time");
			withinLeadTime = false;
		}

	}

	public void setIdentifier(Serializable identifier) {
		this.identifier = identifier;
	}

	public void setItemNbrAllocRqst(int itemNbrAllocRqst) {
		this.itemNbrAllocRqst = itemNbrAllocRqst;
	}

	@Override
	public void setItemNbrDmd(int itemNbrDmd) {
		this.itemNbrDmd = itemNbrDmd;
	}

	public void setNaOrgMfrRqst(NaOrg naOrgMfrRqst) {
		this.naOrgMfrRqst = naOrgMfrRqst;
	}

	@Override
	public void setOeCustMast(OeCustMast oeCustMast) {
		this.oeCustMast = oeCustMast;
	}

	public void setOpenQty(BigDecimal openQty) {
		this.openQty = openQty;
	}

	public void setOpenQtyAdj(BigDecimal openQtyAdj) {
		this.openQtyAdj = openQtyAdj;
	}

	public void setOrgCdCust(String orgCdCust) {
		this.orgCdCust = orgCdCust;
	}

	@Override
	public void setOrgNbrCust(int orgNbrCust) {
		this.orgNbrCust = orgNbrCust;
	}

	public void setOrgNbrMfrRqst(Integer orgNbrMfrRqst) {
		this.orgNbrMfrRqst = orgNbrMfrRqst;
	}

	public void setOvershipAllocations(List<Allocation> overshipAllocations) {
		this.overshipAllocations = overshipAllocations;
	}

	public void setPlanningData(PlanningData planningData) {
		this.planningData = planningData;
	}

	public void setPreviousAllocations(List<Allocation> previousAllocations) {
		this.previousAllocations = previousAllocations;
	}

	public void setPrimarySourcingFacility(UtFacility facility) {
		this.primarySourcingFacility = facility;
	}

	public void setPrioritizedDemandsWithinLeadTime(TreeSet<Demand> prioritizedDemandsWithinLeadTime) {
		this.prioritizedDemandsWithinLeadTime = prioritizedDemandsWithinLeadTime;
	}

	@Override
	public void setPriorityCode(String priorityCode) {
		this.priorityCode = priorityCode;
	}

	public void setPriorityWithinCustomer(String priorityWithinCustomer) {
		this.priorityWithinCustomer = priorityWithinCustomer;
	}

	@Override
	public void setRevisionLevel(String string) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void setRevLvl(String revLvl) {
		this.revLvl = revLvl;
	}

	public void setRqstDt(Date rqstDt) {
		this.rqstDt = rqstDt;
	}

	public void setXmlId(String string) {
		this.xmlId = string;

	}

	@Override
	public String toString() {
		return "[dmdCd=" + dmdCd + ", dmdTypeCd=" + dmdTypeCd + ", itemNbrDmd=" + itemNbrDmd + ", itemNbrAllocRqst="
				+ itemNbrAllocRqst + ", fcItemMastNbr=" + fcItemMastNbr + ", rqstDt=" + rqstDt + ", apsSrcRuleSetNbr="
				+ apsSrcRuleSetNbr + ", orgNbrCust=" + orgNbrCust + ", orgCdCust=" + orgCdCust + ", openQty=" + openQty
				+ ", openQtyAdj=" + openQtyAdj + ", contractCustFlg=" + contractCustFlg + ", custAllocPrty="
				+ custAllocPrty + ", revLvl=" + revLvl + ", orgNbrMfrRqst=" + orgNbrMfrRqst + ", fcstGrp=" + fcstGrp
				+ ", identifier=" + identifier + ", icCertCds=" + icCertCds + ", demandPriority=" + demandPriority
				+ ", demandFcstGrp=" + demandFcstGrp + "]";
	}

	public double getQuantityUnallocated(AllocationMode mode) {
		logger.debug("AbstractDemand unallocateQty");
		double rc = -01;
		rc = getGrossOpenQty() - getAllocatedQty(mode);
		if (rc < 0) {
			String message = String.format("1039 demand is overallocated:\n%s\n grossOpenQty: %f,  allocated: %f ",
					this.toString(), getGrossOpenQty(), getAllocatedQty(mode));
			logger.warn(message);
		}
		if (rc < 0) {
			if (mode != AllocationMode.OVERSHIP) {
				logger.warn("Changing unallocated qty from {} to {}", rc, 0.0);
				rc = 0;
			} else {
				rc = 0;
			}
		}
		return rc;
	}

	public double getQtyAllocatedFirstPass() {
		return getQuantityAllocated(AllocationMode.FIRST_PASS);
	}

	public double getAllocatedOnTimeQty(AllocationMode mode) {
		double qty = 0.0;
		for (Allocation allocation : getAllocations(mode)) {
			Supply s = allocation.getSupply();
			if (!s.getAvailDate().after(getRqstDt())) {
				qty += allocation.getAllocQty();
			}
		}
		return qty;

	}

	@Override
	@Deprecated
	public boolean isCustomerOrder() {
		return false;
	}

	@Override
	public boolean isCustomerDemand() {
		return false;
	}

	@Override
	public boolean isSafetyStockDemand() {
		return false;
	}

	@Override
	public boolean isWorkOrderDemand() {
		return false;
	}

	@Override
	public boolean isForecastDemand() {
		return false;
	}

	public void setLotNotExpireBeforeDt(Date date) {
		this.lotNotExpireBeforeDt = date;
	}

	public Date getLotNotExpireBeforeDt() {
		return lotNotExpireBeforeDt;
	}
}