package com.pacificdataservices.diamond.planning.filter;

import com.pacificdataservices.diamond.models.ApsDmdOo;
import com.pacificdataservices.diamond.planning.data.PlanningData;
import com.pacificdataservices.diamond.planning.demand.Demand;
import com.pacificdataservices.diamond.planning.supply.Supply;

public class CountryOfOriginTest extends AbstractSupplyEligibilityTest {
	@Override
	public boolean isSupplyEligibleForDemand(Supply supply, Demand d, PlanningData planningData) {
		boolean ok = true;
		if (d instanceof ApsDmdOo) {
			ApsDmdOo demand = (ApsDmdOo) d;

			if (demand.getCntryCdOrigin() != null) {
				if (supply.getCntryCdOrigin() == null) {
					// addIneligibleReason("No country of origin ");
					ok = false;
				} else if (!supply.getCntryCdOrigin().equals(demand.getCntryCdOrigin())) {
					// addIneligibleReason("Invalid country of origin ");
					ok = false;
				}
			}

		}
		return ok;
	}

}
