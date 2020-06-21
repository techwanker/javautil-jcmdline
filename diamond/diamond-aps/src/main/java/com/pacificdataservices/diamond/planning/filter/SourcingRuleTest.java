package com.pacificdataservices.diamond.planning.filter;

import com.pacificdataservices.diamond.models.ApsSrcRule;
import com.pacificdataservices.diamond.planning.data.PlanningData;
import com.pacificdataservices.diamond.planning.demand.Demand;
import com.pacificdataservices.diamond.planning.supply.Supply;

public class SourcingRuleTest extends AbstractSupplyEligibilityTest {
	@Override
	public boolean isSupplyEligibleForDemand(Supply supply, Demand demand, PlanningData planningData) {
		Boolean isOk = null;
		
		ApsSrcRule sourcingRule = planningData.getSourcingRule(supply,demand);
	
		isOk = sourcingRule == null ? Boolean.FALSE : Boolean.TRUE;

		return isOk.booleanValue();
	}
}
