/*
 * GenericAllocation.java
 *
 * Created on February 22, 2006, 1:43 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package com.pacificdataservices.diamond.planning;

import java.math.BigDecimal;

//TODO throw this out

//import com.pacificdataservices.diamond.planning.supply.SupplyOnhand;

/**
 * Class for holding any type of allocation as retrieved from the persistent store.
 * Not aware of the demand or supply.
 * 
 * TODO this mapping to and from should occur in AllocationType
 * 
 * TODO this is an undesirable level of indirection hit the allocation tables directly and resolve foreign keys out of second level cache.
 * Allocation type
 * <ul>
 * <li>1 - aps_alloc_onhand_oo</li>
 * <li>2 - aps_alloc_onhand_wo</li>
 * <li>3 - aps_alloc_onhand_fc</li>
 * <li>4 - aps_alloc_onhand_ss</li>
 * <li>5 - aps_alloc_replen_oo</li>
 * <li>6 - aps_alloc_replen_wo</li>
 * <li>7 - aps_alloc_replen_fc</li>
 * <li>8 - aps_alloc_replen_ss</li>
 * <li>9 - aps_alloc_wo_oo</li>
 * <li>10 - aps_alloc_wo_wo</li>
 * <li>11 - aps_alloc_wo_fc</li>
 * <li>12 - aps_alloc_wo_ss</li>
 * </ul>
 */
public class GenericAllocation {
	public static final int APS_ALLOC_ONHAND_OO = 1;

	public static final int APS_ALLOC_ONHAND_WO = 2;

	public static final int APS_ALLOC_ONHAND_FC = 3;

	public static final int APS_ALLOC_ONHAND_SS = 4;

	public static final int APS_ALLOC_REPLEN_OO = 5;

	public static final int APS_ALLOC_REPLEN_WO = 6;

	public static final int APS_ALLOC_REPLEN_FC = 7;

	public static final int APS_ALLOC_REPLEN_SS = 8;

	public static final int APS_ALLOC_WO_OO = 9;

	public static final int APS_ALLOC_WO_WO = 10;

	public static final int APS_ALLOC_WO_FC = 11;

	public static final int APS_ALLOC_WO_SS = 12;

	private AllocationType allocationType;
	
	private BoundState boundState = BoundState.UNKNOWN;
//	private int recordType;

	private int allocationPk;

	private int demandPk;

	private int supplyPk;

	private double allocationQty;

//	private int isBound;
//
//	private String allocTypeId;

	private String facilityAct;

	private String facilityRqst;

	private int itemNbrRqst;

	private int subPool;

	private int facilityTransNbrInt;

	private Integer facilityTransNbr;

	private java.sql.Timestamp availTime;

	private java.sql.Date availDate;

	private String availDtType;

	private double qtyInPick;

	private int fcItemMastNbr;

	private java.sql.Date fcstDt;

	private BigDecimal allocRqstQty;

	private String onhandKey;
	
	public GenericAllocation() {
	}

//	public int getRecordType() {
//		return recordType;
//	}

	public void setAllocationType(int interfaceType) {
		switch (interfaceType) {
			case APS_ALLOC_ONHAND_OO:
				setAllocationType(AllocationType.ONHAND_OO);
				break;
			case APS_ALLOC_ONHAND_WO:
				setAllocationType(AllocationType.ONHAND_WO);
				break;
			case APS_ALLOC_ONHAND_FC:
				setAllocationType(AllocationType.ONHAND_FC);
				break;
			case APS_ALLOC_ONHAND_SS:
				setAllocationType(AllocationType.ONHAND_SS);
				break;
			case APS_ALLOC_REPLEN_OO:
				setAllocationType(AllocationType.REPLEN_OO);
				break;
			case APS_ALLOC_REPLEN_WO:
				setAllocationType(AllocationType.REPLEN_WO);
				break;
			case APS_ALLOC_REPLEN_FC:
				setAllocationType(AllocationType.REPLEN_FC);
				break;
			case APS_ALLOC_REPLEN_SS:
				setAllocationType(AllocationType.REPLEN_SS);
				break;
			case APS_ALLOC_WO_OO:
				setAllocationType(AllocationType.WO_OO);
				break;
			case APS_ALLOC_WO_WO:
				setAllocationType(AllocationType.WO_WO);
				break;
			case APS_ALLOC_WO_FC:
				setAllocationType(AllocationType.WO_FC);
				break;
			case APS_ALLOC_WO_SS:
				setAllocationType(AllocationType.WO_SS);
				break;
				default:
					throw new IllegalArgumentException("value " + interfaceType + " is not mappable");
		}


	}
	public void setAllocationType(AllocationType allocationType) {
		this.allocationType = allocationType;
	}

	public int getAllocationPk() {
		return allocationPk;
	}

	public void setAllocationPk(int allocationPk) {
		this.allocationPk = allocationPk;
	}

	public int getDemandPk() {
		return demandPk;
	}

	public void setDemandPk(int demandPk) {
		this.demandPk = demandPk;
	}

	public int getSupplyPk() {
		return supplyPk;
	}

	public void setSupplyPk(int supplyPk) {
		this.supplyPk = supplyPk;
	}

	public double getAllocationQty() {
		return allocationQty;
	}

	public void setAllocationQty(double allocationQty) {
		this.allocationQty = allocationQty;
	}

//	public int getIsBound() {
//		return isBound;
//	}
//
//	public void setIsBound(int isBound) {
//		this.isBound = isBound;
//	}
//
//	public String getAllocTypeId() {
//		return allocTypeId;
//	}
//
//	public void setAllocTypeId(String allocTypeId) {
//		this.allocTypeId = allocTypeId;
//	}

	public String getFacilityAct() {
		return facilityAct;
	}

	public void setFacilityAct(String facilityAct) {
		this.facilityAct = facilityAct;
	}

	public String getFacilityRqst() {
		return facilityRqst;
	}

	public void setFacilityRqst(String facilityRqst) {
		this.facilityRqst = facilityRqst;
	}

	public int getItemNbrRqst() {
		return itemNbrRqst;
	}

	public void setItemNbrRqst(int itemNbrRqst) {
		this.itemNbrRqst = itemNbrRqst;
	}

	public int getSubPool() {
		return subPool;
	}

	public void setSubPool(int subPool) {
		this.subPool = subPool;
	}

	public int getFacilityTransNbrInt() {
		return facilityTransNbrInt;
	}

	public void setFacilityTransNbrInt(int facilityTransNbrInt) {
		this.facilityTransNbrInt = facilityTransNbrInt;
	}

	public Integer getFacilityTransNbr() {
		return facilityTransNbr;
	}

	public void setFacilityTransNbr(Integer facilityTransNbr) {
		this.facilityTransNbr = facilityTransNbr;
	}

	public java.sql.Timestamp getAvailTime() {
		return availTime;
	}

	public void setAvailTime(java.sql.Timestamp availTime) {
		this.availTime = availTime;
	}

	public java.sql.Date getAvailDate() {
		return availDate;
	}

	public void setAvailDate(java.sql.Date availDate) {
		this.availDate = availDate;
	}

	public String getAvailDtType() {
		return availDtType;
	}

	public void setAvailDtType(String availDtType) {
		this.availDtType = availDtType;
	}

	public double getQtyInPick() {
		return qtyInPick;
	}

	public void setQtyInPick(double qtyInPick) {
		this.qtyInPick = qtyInPick;
	}

	/**
	 * @param fcItemMastNbr The fcItemMastNbr to set.
	 */
	public void setFcItemMastNbr(int fcItemMastNbr) {
		this.fcItemMastNbr = fcItemMastNbr;
	}

	/**
	 * @return Returns the fcItemMastNbr.
	 */
	public int getFcItemMastNbr() {
		return fcItemMastNbr;
	}

	/**
	 * @param fcstDt The fcstDt to set.
	 */
	public void setFcstDt(java.sql.Date fcstDt) {
		this.fcstDt = fcstDt;
	}

	/**
	 * @return Returns the fcstDt.
	 */
	public java.sql.Date getFcstDt() {
		return fcstDt;
	}

	/**
	 * @param allocRqstQty The allocRqstQty to set.
	 */
	public void setAllocRqstQty(BigDecimal allocRqstQty) {
		this.allocRqstQty = allocRqstQty;
	}

	/**
	 * @return Returns the allocRqstQty.
	 */
	public BigDecimal getAllocRqstQty() {
		return allocRqstQty;
	}

	public AllocationType getAllocationType() {
		return allocationType;
	}

	public BoundState getBoundState() {
		return boundState;
	}

	public void setBoundState(BoundState boundState) {
		this.boundState = boundState;
	}
	
//	// TODO this doesn't feel right, what is this used for 
//	public String getOnhandKey() {
//		if (onhandKey == null) {
//			onhandKey = SupplyOnhand.getId(supplyPk, subPool, facilityAct, availDate);
//		}
//		return onhandKey;
//	}
	
	
}
