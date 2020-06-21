package com.pacificdataservices.diamond.planning.filter;

import com.pacificdataservices.diamond.models.IcItemMast;
import com.pacificdataservices.diamond.planning.data.PlanningData;
import com.pacificdataservices.diamond.planning.demand.Demand;
import com.pacificdataservices.diamond.planning.supply.Supply;
import com.pacificdataservices.diamond.planning.supply.SupplyOnhand;

/**
 * Is the item ordered the supply item or a substitute?
 * 
 * @author jjs
 *
 */
public class IsItemOrSubstitute extends AbstractSupplyEligibilityTest {
	private IsCustomerSubstitute custSubst = new IsCustomerSubstitute();
	private IsGlobalSubstitute globalSubst = new IsGlobalSubstitute();

	@Override
	public boolean isSupplyEligibleForDemand(Supply supply, Demand demand, PlanningData planningData) {
		checkArguments(supply, demand, planningData);

		boolean retval = false;
		out:
			while (true) {
				if (supply.isOnhand()) {
					SupplyOnhand so = (SupplyOnhand) supply;
					for (IcItemMast iim : so.getIcItemMastByItemCd().values()) {
						if (demand.getItemNbrDmd()==iim.getItemNbr()) {
							retval = true;
							break  out;
						}
					} 
				} else  { // purchase  orders dual CERT  too TODO
					if (demand.getItemNbrDmd() == supply.getItemNbr()) {
						retval = true;
						break;
					}
				}
				if (custSubst.isSupplyEligibleForDemand(supply, demand, planningData)) {
					retval = true;
					break;
				}
				if (globalSubst.isSupplyEligibleForDemand(supply, demand, planningData)) {
					retval = true;
					break;
				}
				break;
			}
		return retval;
	}

}



