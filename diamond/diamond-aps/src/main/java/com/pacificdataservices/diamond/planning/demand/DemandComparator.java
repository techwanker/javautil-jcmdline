package com.pacificdataservices.diamond.planning.demand;

import java.util.Comparator;

//import org.slf4j.Logger;

/**
 * DemandComparator determines the order in which orders are evaluated on the first pass
 *
 * <ol>
 * <li> Demand of the same forecast group are prioritized
 * <ol>
 *   <li> Work Orders</li>
 *   <li> Customer Orders</li>
 *   <li> Safety Stock</li>
 *   <li> Forecasted Demand</li>
 * </ol>
 * <li> Demand of the different forecast group are prioritized
 * <ol>
 *   <li> Safety Stock</li>
 *   <li> Work Orders</li>
 *   <li> Customer Orders</li>
 *   <li> Forecasted Demand</li>
 * </ol>
 * <li> Demand is bucketed by period, in accordance with the calendar specified in allocation control.</li>
 * <li> Demand in the same period are prioritized based on DemandPriority</li>
 * <li>If everything else is equal, the primary key of the demand is used as a tie breaker.
 */
public class DemandComparator implements Comparator<Demand> {


	@Override
	public int compare(Demand demand1, Demand demand2) {
          return demand1.getPriorityCode().compareTo(demand2.getPriorityCode());
	}		

}
