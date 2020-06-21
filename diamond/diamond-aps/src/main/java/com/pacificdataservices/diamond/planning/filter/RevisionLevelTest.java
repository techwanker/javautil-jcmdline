package com.pacificdataservices.diamond.planning.filter;

import com.pacificdataservices.diamond.planning.data.PlanningData;
import com.pacificdataservices.diamond.planning.demand.Demand;
import com.pacificdataservices.diamond.planning.supply.Supply;
import com.pacificdataservices.diamond.planning.supply.SupplyOnhand;

public class RevisionLevelTest extends AbstractSupplyEligibilityTest {
	@Override
	public boolean isSupplyEligibleForDemand(Supply supply, Demand demand, PlanningData planningData) {
		

		Boolean ok = null;
		String demandRevisionLevel = demand.getRevLvl();
		// System.out.println("checking revision level");
		if (demandRevisionLevel == null) {
			ok = Boolean.TRUE;
		} else {
			if (supply.isOnhand()) {
				SupplyOnhand soh = (SupplyOnhand) supply;
				int lotNbr = supply.getLotNbr();
				String lotRevision = soh.getRevLvl();
				if (lotRevision != null && lotRevision != null && lotRevision.equals(demand.getRevLvl())) {
					ok = Boolean.TRUE;
				} else {
					ok = Boolean.FALSE;
				}
			}
			// the revision level can specified only for the primary part on a
			// replen
			// todo doesn't check for
			if (supply.isPurchaseOrder()) {
				// TODO what is with this?
				ok = Boolean.TRUE;
			}

			if (supply.isWorkOrder()) {
				ok = Boolean.TRUE;
			}

		}
		if (ok == null) {
			throw new IllegalStateException("logic error null return");
		}
		return ok;
	}
}
