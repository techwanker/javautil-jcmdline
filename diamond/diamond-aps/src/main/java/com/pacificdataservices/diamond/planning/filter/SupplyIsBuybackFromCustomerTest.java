package com.pacificdataservices.diamond.planning.filter;

import com.pacificdataservices.diamond.models.ApsSrcRule;
import com.pacificdataservices.diamond.planning.data.PlanningData;
import com.pacificdataservices.diamond.planning.demand.Demand;
import com.pacificdataservices.diamond.planning.supply.Supply;

/**
 * Returns true if the supply has been bought from the customer
 * 
 * // todo need unit tests
 * 
 * @author jjs
 * 
 */
public class SupplyIsBuybackFromCustomerTest extends AbstractSupplyEligibilityTest{
	@Override
	public boolean isSupplyEligibleForDemand(Supply supply, Demand demand, PlanningData planningData) {

		boolean rc = false;
		//supply.getSupplyTypeCd();
		// ApsSrcRuleSet sourcingRules = demand.getApsSrcRuleSet();
		ApsSrcRule rule = supply.getSourcingRule(demand);

		// ApsSrcRuleSetVw sourcingRule = sourcingRules.getSourcingRule(supply);
		if (rule == null) {
		} else {

			if ("B".equals(rule.getSplyTypeId())) {
				rc = true;
			}
		}

		return rc;

	}

}
