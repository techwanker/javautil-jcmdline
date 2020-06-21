package com.pacificdataservices.diamond.planning.filter;

import java.util.ArrayList;

import com.pacificdataservices.diamond.planning.data.PlanningData;
import com.pacificdataservices.diamond.planning.demand.Demand;
import com.pacificdataservices.diamond.planning.supply.Supply;

// TODO this needs to go away
public class ContractAerospaceEligibilityCompositeTest extends AbstractSupplyEligibilityTest {

	private ArrayList<SupplyEligibilityTest> tests = new ArrayList<SupplyEligibilityTest>() {
		{
			add(new SourcingRuleTest());
			// certed to or substitute
			add(new CountryOfOriginTest());
			//add(new LotDateTest());
			//add(new ManufacturerTest());
			add(new RevisionLevelTest());
			add(new CertTest());
		}
	};

	@Override
	public boolean isSupplyEligibleForDemand(Supply s, Demand d, PlanningData planningData) {
		Boolean returnValue = null;
		for (int i = 0; i < tests.size(); i++) {
			SupplyEligibilityTest test = tests.get(i);
			if (returnValue = test.isSupplyEligibleForDemand(s, d, planningData)) {
				if (returnValue != null) {
					break;
				}
			}
		}
		return returnValue;
	}

}
