package com.pacificdataservices.diamond.planninglogic;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map.Entry;
import java.util.TreeMap;

import org.javautil.core.misc.Timer;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.pacificdataservices.diamond.planning.Allocator;
import com.pacificdataservices.diamond.planning.EligibleSupplies;
import com.pacificdataservices.diamond.planning.data.PlanningData;
import com.pacificdataservices.diamond.planning.demand.Demand;
import com.pacificdataservices.diamond.planning.json.PlanningDataMarshallable;
import com.pacificdataservices.diamond.planning.services.SpringBootTests;
import com.pacificdataservices.diamond.planning.supply.Supply;
public abstract class AbstractPlanTest {
	private final Logger logger = LoggerFactory.getLogger(getClass());

	private PlanningData pd;
	
	private AbstractPlanTestExpectedValues expected;


	@Before
	public void before() throws IOException, InstantiationException, IllegalAccessException, ParseException {
		if (pd == null) {
			pd = PlanningDataMarshallable.planningDataFromFile(new File(SpringBootTests.planGroup15DataFile));
		}
	}

	@Ignore
	@Test
	public void testPlanningEngine() throws IOException, InstantiationException, IllegalAccessException, ParseException {

		Timer t = new Timer();
		int loopCount = 1;
		long minEla = Long.MAX_VALUE;
		for (int i = 0; i < loopCount; i++) {
		    Timer innerTimer = new Timer();	
		    bigTest();
			long innerEla = innerTimer.getElapsedMicros();
			if (innerEla < minEla) {
				minEla = innerEla;
			}
		}
		long ela = t.getElapsedMicros();
		logger.info(" micros: {} for {} loops {} micros/loop minimum {}", ela, loopCount, ela / loopCount,
				minEla);
	}

	@Test
	public void bigTest() throws InstantiationException, IllegalAccessException, IOException, ParseException {
		//before();
		Timer t = new Timer();
		Allocator allocator = new Allocator(pd);
		// ##################################
		// test planning data
		// ##################################
		if (pd == null) {
			throw new IllegalArgumentException("pd is null");
		}
		ArrayList<String> messages = pd.checkIntegrity();
		for (String message : messages) {
			logger.error("--------------> {}", message);
		}
		assertEquals(0, messages.size()); // all of the selects are semantically correct
		assertEquals(expected.getExpectedCustomerDemandSize(), pd.getDemandCustomers().size());
		assertEquals(expected.getExpectedCustomerDemandSize(), pd.getDemandCustomerById().size());
		assertEquals(expected.getExpectedApsAvailOnhandsSize(), pd.getApsAvailOnhands().size());
		assertEquals(expected.getExpectedIcItemMastSize(), pd.getIcItemMasts().size());
	
		// ##################################
		// test prioritization 
		// ##################################
		allocator.prioritizeDemands();
		TreeMap<String, Demand> prioritized = pd.getPrioritizedDemands();
		Entry<String, Demand> firstEntry = prioritized.ceilingEntry("");
		assertEquals(expected.getExpectedFirstDemand(), firstEntry.getKey());
		// ##################################
		// test eligible supplies
		// ##################################
		allocator.associateEligibleSupplies();
		Collection<Supply> supplies = pd.getSupplies();
		assertEquals(expected.getExpectedSuppliesSize(), supplies.size());
		Demand dmd = firstEntry.getValue();
		allocator.associateEligibleSupplies();
		EligibleSupplies eligible = dmd.getEligibleSupplies();
		assertEquals(expected.getExpectedEligibleSize(), eligible.size());
		Demand demand = firstEntry.getValue();
		logger.debug("{}",demand.getPrioritizedSuppliesFormatted());
		logger.info("testEligibleSupplies {} micros", t.getElapsedMicros());
		// ##################################
		// test supply prioritizer 
		// ##################################
		logger.debug("{}",demand.getPrioritizedSuppliesFormatted());
		logger.info("testSupplyPrioritizer {} micros", t.getElapsedMicros());
	}

	@Test
	public void testAllocator() throws InstantiationException, IllegalAccessException, IOException, ParseException {
		//before();  // TODO WTF
		Allocator allocator = new Allocator(pd);
		allocator.allocate();
	}

public AbstractPlanTestExpectedValues getExpected() {
		return expected;
	}

	public void setExpected(AbstractPlanTestExpectedValues expected) {
		this.expected = expected;
	}

	public PlanningData getPlanningData() {
		return pd;
	}

	public void setPlanningData(PlanningData pd) {
		this.pd = pd;
	}
	
}