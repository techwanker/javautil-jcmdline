/*
 * AllocationType.java
 *
 * Created on February 9, 2006, 9:58 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package com.pacificdataservices.diamond.planning;

import com.pacificdataservices.diamond.planning.demand.Demand;
import com.pacificdataservices.diamond.planning.demand.DemandType;
import com.pacificdataservices.diamond.planning.supply.Supply;

/**
 * 
 * @author jim
 */
public enum AllocationType {
	// customer work order safety stock forecast
	ONHAND_OO, ONHAND_WO, ONHAND_SS, ONHAND_FC, // onhand supplies
	REPLEN_OO, REPLEN_WO, REPLEN_SS, REPLEN_FC, // replenishment supplies
	WO_OO, WO_WO, WO_SS, WO_FC; // work order supplies

//	public static final int ONHAND_OO_INT = 1;
//	public static final int ONHAND_WO_INT = 2;
//	public static final int ONHAND_SS_INT = 3;
//	public static final int ONHAND_FC_INT = 4;
//	public static final int REPLEN_OO_INT = 5;
//	public static final int REPLEN_WO_INT = 6;
//	public static final int REPLEN_SS_INT = 7;
//	public static final int REPLEN_FC_INT = 8;
//	public static final int WO_OO_INT = 9;
//	public static final int WO_WO_INT = 10;
//	public static final int WO_SS_INT = 11;
//	public static final int WO_FC_INT = 12;

//	/**
//	 * Returns and int corresponding to the allocation type.
//	 * 
//	 * 
//	 */
//	public int getRecordType() {
//		int retval = -1;
//		switch (this) {
//		case ONHAND_OO:
//			retval = ONHAND_OO_INT;
//			break;
//		case ONHAND_WO:
//			retval = ONHAND_WO_INT;
//			break;
//		case ONHAND_SS:
//			retval = ONHAND_SS_INT;
//			break;
//		case ONHAND_FC:
//			retval = ONHAND_FC_INT;
//			break;
//		case REPLEN_OO:
//			retval = REPLEN_OO_INT;
//			break;
//		case REPLEN_WO:
//			retval = REPLEN_WO_INT;
//			break;
//		case REPLEN_SS:
//			retval = REPLEN_SS_INT;
//			break;
//		case REPLEN_FC:
//			retval = REPLEN_FC_INT;
//			break;
//		case WO_OO:
//			retval = WO_OO_INT;
//			break;
//		case WO_WO:
//			retval = WO_WO_INT;
//			break;
//		case WO_SS:
//			retval = WO_SS_INT;
//			break;
//		case WO_FC:
//			retval = WO_FC_INT;
//			break;
//		default:
//			throw new IllegalStateException("unhandled record type " + this.toString());
//
//		}
//		return retval;
//	}

	public static AllocationType getAllocationType(Demand demand, Supply supply) {
		DemandType demandType = demand.getDemandType();
		SupplyType supplyType = supply.getSupplyType();
		AllocationType type = null;
		switch (demandType) {
		case CUSTOMER_ORDER:
			switch (supplyType) {
			case ONHAND:
				type = ONHAND_OO;
				break;
			case PURCHASE:
				type = REPLEN_OO;
				break;
			case WORK_ORDER:
				type = WO_OO;
				break;
			default:
				throw new IllegalStateException("Unknown Supply Type: " + supplyType);

			}
			break;
		case FORECAST:
			switch (supplyType) {
			case ONHAND:
				type = ONHAND_FC;
				break;
			case PURCHASE:
				type = REPLEN_FC;
				break;
			case WORK_ORDER:
				type = WO_FC;
				break;
			default:
				throw new IllegalStateException("Unknown Supply Type: " + supplyType);

			}
			break;
		case SAFETY_STOCK:
			switch (supplyType) {
			case ONHAND:
				type = ONHAND_SS;
				break;
			case PURCHASE:
				type = REPLEN_SS;
				break;
			case WORK_ORDER:
				type = WO_SS;
				break;
			default:
				throw new IllegalStateException("Unknown Supply Type: " + supplyType);

			}
			break;
		case WORK_ORDER:
			switch (supplyType) {
			case ONHAND:
				type = ONHAND_WO;
				break;
			case PURCHASE:
				type = REPLEN_WO;
				break;
			case WORK_ORDER:
				type = WO_WO;
				break;
			default:
				throw new IllegalStateException("Unknown Supply Type: " + supplyType);

			}
			break;
		default:
			throw new IllegalArgumentException();
		}
		return type;

	}

	@SuppressWarnings("incomplete-switch")
	public boolean isCustomerOrderDemand() {
		boolean retval = false;
		switch (this) {
		case ONHAND_OO:
		case REPLEN_OO:
		case WO_OO:
			retval = true;
			break;
		}
		return retval;
	}

	@SuppressWarnings("incomplete-switch")
	public boolean isWorkOrderDemand() {
		boolean retval = false;
		switch (this) {
		case ONHAND_WO:
		case REPLEN_WO:
		case WO_WO:
			retval = true;
			break;
		}
		return retval;
	}

	@SuppressWarnings("incomplete-switch")
	public boolean isSafetyStockDemand() {
		boolean retval = false;
		switch (this) {
		case ONHAND_SS:
		case REPLEN_SS:
		case WO_SS:
			retval = true;
			break;
		}
		return retval;
	}

	@SuppressWarnings("incomplete-switch")
	public boolean isForecastDemand() {
		boolean retval = false;
		switch (this) {
		case ONHAND_FC:
		case REPLEN_FC:
		case WO_FC:
			retval = true;
			break;
		}
		return retval;
	}

	@SuppressWarnings("incomplete-switch")
	public boolean isOnhandSupply() {
		boolean retval = false;
		switch (this) {
		case ONHAND_OO:
		case ONHAND_WO:
		case ONHAND_SS:
		case ONHAND_FC:
			retval = true;
		}
		return retval;
	}

	@SuppressWarnings("incomplete-switch")
	public boolean isReplenSupply() {
		boolean retval = false;
		switch (this) {
		case REPLEN_OO:
		case REPLEN_WO:
		case REPLEN_SS:
		case REPLEN_FC:
			retval = true;
		}
		return retval;
	}

	@SuppressWarnings("incomplete-switch")
	public boolean isWorkOrderSupply() {
		boolean retval = false;
		switch (this) {
		case WO_OO:
		case WO_WO:
		case WO_SS:
		case WO_FC:
			retval = true;
		}
		return retval;
	}
}
