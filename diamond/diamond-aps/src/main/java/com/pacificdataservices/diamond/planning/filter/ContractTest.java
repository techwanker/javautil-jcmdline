package com.pacificdataservices.diamond.planning.filter;

import com.pacificdataservices.diamond.planning.data.PlanningData;
import com.pacificdataservices.diamond.planning.demand.Demand;
import com.pacificdataservices.diamond.planning.supply.Supply;

public class ContractTest extends AbstractSupplyEligibilityTest {
	@Override
	public boolean isSupplyEligibleForDemand(Supply supply, Demand demand, PlanningData planningData) {
		Boolean rc = null;
//		if (supply.isConsignmentOrBuyback()) {
//
//			// ApsSrcRuleSetVw sourcingRule =
//			// sourcingRules.getSourcingRule(supply);
//			ApsSrcRule srcRule = supply.getSourcingRule(demand);
//			if (srcRule == null) {
//				// todo can't determine eligibility yet
//			} else {
//				if ("C".equals(supply.getSplyTypeId())) {
//					rc = Boolean.TRUE;
//				}
//			}
//
//		}
//		return rc;
		return rc;
	}
}
