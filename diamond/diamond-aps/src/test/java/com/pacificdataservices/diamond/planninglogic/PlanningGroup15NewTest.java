package com.pacificdataservices.diamond.planninglogic;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;

import org.junit.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.pacificdataservices.diamond.planning.json.PlanningDataMarshallable;
import com.pacificdataservices.diamond.planning.services.SpringBootTests;

public class PlanningGroup15NewTest extends AbstractPlanTest {
	private final Logger logger = LoggerFactory.getLogger(getClass());

	@Before
	public void before() throws IOException, InstantiationException, IllegalAccessException, ParseException {
		if (getPlanningData() == null) {
			setPlanningData(PlanningDataMarshallable.planningDataFromFile(new File(SpringBootTests.planGroup15DataFile)));
		}
		AbstractPlanTestExpectedValues expected = new AbstractPlanTestExpectedValues();
		expected.setExpectedFirstDemand ("TYPE:-2-OO-LEADTIME:1-DMDPRTY:0007-NEEDBY:2019-03-21-1DMDCD:JIT255644-790");
		expected.setExpectedCustomerDemandSize ( 16);
		expected.setExpectedEligibleSize ( 11);
		expected.setExpectedSuppliesSize ( 24);
		expected.setExpectedIcItemMastSize ( 4);
		expected.setExpectedApsAvailOnhandsSize ( 0);
		super.setExpected(expected);
	}

}