package com.pacificdataservices.diamond.planning;

import com.pacificdataservices.diamond.planning.data.PlanningData;
import com.pacificdataservices.diamond.planning.demand.DemandPrioritizer;

public class Planner {

	private PlanningData planningData;
	private DemandPrioritizer demandPrioritizer;
	
	public void plan(PlanningData planningData) {
		demandPrioritizer.prioritize(planningData);
	}
}
