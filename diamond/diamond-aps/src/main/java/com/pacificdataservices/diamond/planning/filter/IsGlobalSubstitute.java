package com.pacificdataservices.diamond.planning.filter;

import java.util.List;

import com.pacificdataservices.diamond.models.ApsItemGlobalSubst;
import com.pacificdataservices.diamond.planning.data.PlanningData;
import com.pacificdataservices.diamond.planning.demand.Demand;
import com.pacificdataservices.diamond.planning.supply.Supply;

/**
 * Is the item ordered the supply item?
 * 
 * @author jjs
 *
 */
public class IsGlobalSubstitute extends AbstractSupplyEligibilityTest {
	@Override
	public boolean isSupplyEligibleForDemand(Supply supply, Demand demand, PlanningData planningData) {
		checkArguments(supply, demand, planningData);

		boolean rc = false;
		List<ApsItemGlobalSubst> globalSubstitutes = planningData.getApsItemGlobalSubsts();
		for (ApsItemGlobalSubst subst : globalSubstitutes) {
			if (subst.getId().getItemNbr() == demand.getItemNbrDmd()
					&& subst.getId().getItemNbrSubst() == supply.getItemNbr()) {
				rc = true;
				break;
			}

		}
		return rc;
	}
}
