package com.pacificdataservices.diamond.planning.filter;

import java.util.List;

import com.pacificdataservices.diamond.models.IcItemCustSubst;
import com.pacificdataservices.diamond.planning.data.PlanningData;
import com.pacificdataservices.diamond.planning.demand.Demand;
import com.pacificdataservices.diamond.planning.supply.Supply;

/**
 * Is the item ordered the supply item?
 * 
 * @author jjs
 *
 */
public class IsCustomerSubstitute extends AbstractSupplyEligibilityTest {
	@Override
	public boolean isSupplyEligibleForDemand(Supply supply, Demand demand, PlanningData planningData) {
		checkArguments(supply, demand, planningData);

		
		boolean retval = false;

		List<IcItemCustSubst> customerItemSubstitutes = planningData.getIcItemCustSubsts();
		for (IcItemCustSubst subst : customerItemSubstitutes) {
			// TODO what about other items this supply is certed to?
			if (subst.getId().getOrgNbrCust() == demand.getOrgNbrCust()
					&& subst.getId().getItemNbr() == demand.getItemNbrDmd()
					&& subst.getId().getItemNbrSubst() == supply.getItemNbr()) { 
				retval = true;
				break;
			}
	
		}
		return retval;

	}

	
}
