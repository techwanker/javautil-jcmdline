package com.pacificdataservices.diamond.planning.filter;

import com.pacificdataservices.diamond.planning.data.PlanningData;
import com.pacificdataservices.diamond.planning.demand.Demand;
import com.pacificdataservices.diamond.planning.supply.Supply;

public interface EligibleSupplyFilter {

	void setEligibleSuppliesForDemand(Demand demand, PlanningData planningData);
	
	boolean isApplicable();

	boolean isEligible(Demand demand, Supply supply, PlanningData planningData);
}