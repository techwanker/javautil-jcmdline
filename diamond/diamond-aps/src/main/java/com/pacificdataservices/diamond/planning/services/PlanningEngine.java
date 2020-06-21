package com.pacificdataservices.diamond.planning.services;

import java.util.Collection;

import com.pacificdataservices.diamond.planning.data.PlanningData;

public interface PlanningEngine {

	void run();

	/**
	 * @todo fix to create work orders
	 * @todo passing this an itemNbr is goofy By now, the items to be planned
	 *       should be in tmp_item. Steps
	 *       <ol>
	 *       <li>delete prior summary information</li>
	 *       <li>delete all allocations for this set of items not in pick or
	 *       bound or requested to be bound</lI>
	 *       <li>get ic_item_mast for plan group</li>
	 *       <li>get the supplies</li>
	 *       </ol>
	 *       
	 * TODO needs to restore allocations 
	 */
	PlanningData planItem(Collection<Integer> itemNbrs);

}