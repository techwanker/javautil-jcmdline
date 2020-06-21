package com.pacificdataservices.diamond.planning.filter;

import java.util.ArrayList;
import java.util.List;

public class EligibilityFiltersImpl {
	private List<SupplyEligibilityTest> testList  = new ArrayList<SupplyEligibilityTest>();
	
	public List<SupplyEligibilityTest> getSupplyEligibilityTests () {
	
	//testList.add(new BuybackTest()); // TODO must be used with another test
		testList.add(new SourcingRuleTest());
	//testList.add(new CertTest()); // TODO fix
	// testList.add(new ConsignmentTest());
	//testList.add(new ContractAerospaceEligibilityCompositeTest());
	//testList.add(new ContractTest());
	testList.add(new CountryOfOriginTest());
	testList.add(new ExpiryDateTest());
	//testList.add(new ExplicitManufacturerTest());
	//testList.add(new ItemOrderedTest());
	testList.add(new ExpiryDateTest());
	testList.add(new CustomerItemManufacturerTest());
	testList.add(new RevisionLevelTest());

	//testList.add(new SupplyIsBuybackFromCustomerTest());
	return testList;

}

}
