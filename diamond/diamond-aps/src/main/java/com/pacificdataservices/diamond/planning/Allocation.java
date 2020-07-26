package com.pacificdataservices.diamond.planning;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.javautil.containers.NameValue;
import org.javautil.text.SimpleDateFormatFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.pacificdataservices.diamond.planning.demand.Demand;
import com.pacificdataservices.diamond.planning.supply.Supply;
import com.pacificdataservices.jdbc.PersistenceAction;

/**
 * Highest level inventory allocation class.
 */
public  class Allocation {
	private Logger logger = LoggerFactory.getLogger(getClass());

	private boolean debugging = logger.isDebugEnabled();
	/**
	 * The Demand.
	 */
	private Demand demand;
	/**
	 * The Supply.
	 */
	private Supply supply;

	/**
	 * Quantity allocated from the supply for this demand.  TODO what is the unit of measure?
	 */
	private Double allocQty = null;

	/**
	 * @TODO what is this
	 */
	private BoundState boundState;

	private String allocTypeId;

	public String getAllocTypeId() {
		return allocTypeId;
	}
	public void setAllocTypeId(String allocTypeId) {
		this.allocTypeId = allocTypeId;
	}
	/**
	 * The action that should be taken on this allocation when the planning state is written.
	 */
	private PersistenceAction persistenceAction;

	protected Allocation() {

	}
	@SuppressWarnings("null")
	public Allocation(
			Demand demand, 
			Supply supply, 
			Double allocQty, 
			AllocationMode mode, 
			PersistenceAction action)
					throws com.pacificdataservices.diamond.planning.SupplyOverAllocationException {
		if (action == null) {
			throw new IllegalArgumentException("action is null");
		}
		this.persistenceAction = action;

		this.demand = demand;
		this.supply = supply;
		this.allocQty  = allocQty;
		logger.debug("Demand: {}\nSupply: {}\nallocQty: {} mode: {}",demand,supply,allocQty,mode);
	}

	public AllocationType getAllocationType() {
		return AllocationType.getAllocationType(demand,supply);
	}

	public Demand getDemand() {
		return this.demand;
	}
	public Supply getSupply() {
		return this.supply;
	}

	public Double getAllocQty() {
		return allocQty;
	}

	public void setAllocQty(Double allocQty) {
		this.allocQty = allocQty;
	}

	public void setAllocQty(double val, boolean isNull) {
		setAllocQty(isNull ? null : new Double(val));
	}

	public void incrementAllocQty(Double additional) {
		setAllocQty(new Double(getAllocQty().doubleValue()  + additional.doubleValue()));
	}

	public java.util.Date getAllocationDate() {
		try {
			Date needBy = demand.getNeedByDate();
			Date availDate = supply.getAvailDate();
			Date retval = needBy.before(availDate) ? availDate : needBy;
			if (debugging) {
				SimpleDateFormat sdf = SimpleDateFormatFactory.getYyyyDashMmDashDd();
				logger.debug("needBy {} availDate {} allocationDate {}", sdf.format(needBy), sdf.format(availDate), sdf.format(retval));
			} 

			return retval;
		} catch (java.lang.NullPointerException n) {
			if (demand == null) {
				throw new java.lang.NullPointerException("demand is null");
			}
			if (supply == null) {
				throw new java.lang.NullPointerException("supply is null");
			}
			throw n;
		}

	}

	public PersistenceAction getPersistenceAction() {
		return persistenceAction;
	}
	public double getQtyInPick() {
		throw new UnsupportedOperationException(); // TODO
	}

	public void setBoundState(BoundState bound) {
		this.boundState = bound;	
	}
	public void setPreserve(int allocationPk) {
		throw new UnsupportedOperationException(); // todo

	}
	public Double getAllocRqstQty() {
		throw new UnsupportedOperationException(); // TODO
	}
	public Integer getAllocationPk() {
		throw new UnsupportedOperationException(); // TODO
	}

	@Override
	public String toString() {
		return "Allocation toString:: " + demand.toString() + "\n" + supply.toString() + "\n" + allocQty;
	}

	public String allocSupplyToString() {
		return "allocSupplytoString:: " + "allocQty: " + allocQty + " " + supply.toString();
	}

	public String bucketString() {
		NameValue nv = new NameValue();
		SimpleDateFormat sdf = SimpleDateFormatFactory.getYyyyDashMmDashDd();
		nv.put("dafuk","dis");
		nv.put("supply",supply.getSupplyIdentifier());
		nv.put("demand",demand.getDemandIdentifier());
		nv.put("allocation",sdf.format(getAllocationDate()));
		nv.put("needBy",sdf.format(getDemand().getNeedByDate()));
		nv.put("avail",sdf.format(getSupply().getAvailDate()));
		nv.put("allocQty",allocQty);
		return nv.toString();
	}
}
