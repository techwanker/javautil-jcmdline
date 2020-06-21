package com.pacificdataservices.diamond.planning.filter;

import com.pacificdataservices.diamond.planning.data.PlanningData;
import com.pacificdataservices.diamond.planning.demand.Demand;
import com.pacificdataservices.diamond.planning.supply.Supply;

/**
 * Is the item ordered the supply item?
 * 
 * @author jjs
 *
 */
public class IsSubstitute extends AbstractSupplyEligibilityTest {
	private IsCustomerSubstitute custSubst = new IsCustomerSubstitute();
	private IsGlobalSubstitute globalSubst = new IsGlobalSubstitute();
	
	@Override
	public boolean isSupplyEligibleForDemand(Supply supply, Demand demand, PlanningData planningData) {
		checkArguments(supply, demand, planningData);

		
		return custSubst.isSupplyEligibleForDemand(supply, demand, planningData) ||
				globalSubst.isSupplyEligibleForDemand(supply, demand, planningData);

	}

	
}
