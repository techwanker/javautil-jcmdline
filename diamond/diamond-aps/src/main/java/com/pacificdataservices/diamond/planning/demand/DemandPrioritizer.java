package com.pacificdataservices.diamond.planning.demand;

import com.pacificdataservices.diamond.planning.data.PlanningData;

public interface DemandPrioritizer {
	/**
	 * Updates the priorityCode of each demand.
	 * 
	 * The priority code should be collatable and distinct.
	 * @param planningData
	 */
	void prioritize(PlanningData planningData);

}
