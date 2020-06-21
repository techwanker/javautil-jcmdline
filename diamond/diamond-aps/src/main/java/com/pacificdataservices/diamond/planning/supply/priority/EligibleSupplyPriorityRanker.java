package com.pacificdataservices.diamond.planning.supply.priority;

import com.pacificdataservices.diamond.planning.EligibleSupply;
import com.pacificdataservices.diamond.planning.data.PlanningData;

public interface EligibleSupplyPriorityRanker {
	public String getPriority(EligibleSupply eligibleSupply, PlanningData planningData);
	
}
