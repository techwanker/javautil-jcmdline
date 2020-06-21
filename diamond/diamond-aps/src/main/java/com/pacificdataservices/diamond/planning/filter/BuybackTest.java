package com.pacificdataservices.diamond.planning.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.pacificdataservices.diamond.models.ApsSplySubPool;
import com.pacificdataservices.diamond.models.ApsSrcRule;
import com.pacificdataservices.diamond.models.ApsSrcRuleSet;
import com.pacificdataservices.diamond.planning.data.PlanningData;
import com.pacificdataservices.diamond.planning.demand.Demand;
import com.pacificdataservices.diamond.planning.supply.Supply;

/**
 * If this is buyback inventory from the customer many other rules can be skipped.
 * @author jjs
 *
 */
public class BuybackTest extends AbstractSupplyEligibilityTest {
	private final Logger logger = LoggerFactory.getLogger(getClass());
	
	@Override
	public boolean isSupplyEligibleForDemand(Supply supply, Demand demand, PlanningData planningData) {

		Boolean rc = null;
		ApsSrcRuleSet ruleSet = demand.getApsSrcRuleSet();
		ApsSplySubPool subPool = null;
		for (ApsSrcRule rule : ruleSet.getApsSrcRules()) {
			if (rule.getApsSplySubPool().getApsSplySubPoolNbr() == supply.getApsSplySubPoolNbr()) {
				subPool = rule.getApsSplySubPool();
				break;
			}					
		}
		if (subPool == null) {
			rc = Boolean.FALSE;
		} else {
			rc = "B".equals(subPool.getSplyPoolTypeId());
		}

		return rc;
	}
}
