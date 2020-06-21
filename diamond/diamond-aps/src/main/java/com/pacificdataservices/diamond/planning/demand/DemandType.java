/**
 * 
 */
package com.pacificdataservices.diamond.planning.demand;

/**
 * @author jim
 *
 */
public enum DemandType {
  WORK_ORDER, FORECAST, SAFETY_STOCK, CUSTOMER_ORDER;

  
/**
 * TODO eliminate this is part of mapping all demands to a single view
 * @param demandTypeCd
 * @return
 */
public static DemandType getDemandType(String demandTypeCd) {
	if (demandTypeCd == null) {
		throw new IllegalArgumentException("demandTypeCode is null");
	}
	DemandType retval = null;
	if ("OO".equals(demandTypeCd)) {
		retval = DemandType.CUSTOMER_ORDER;
	} else if ("WO".equals(demandTypeCd)) {
		retval = DemandType.WORK_ORDER;
	} else if ("FC".equals(demandTypeCd)) {
		retval = DemandType.FORECAST;
	} else if ("SS".equals(demandTypeCd)) {
		retval = DemandType.SAFETY_STOCK;
	} else {
		throw new IllegalStateException("unknown demand type+'" + demandTypeCd + ": '" +  demandTypeCd );
	}
	return retval;
}
}