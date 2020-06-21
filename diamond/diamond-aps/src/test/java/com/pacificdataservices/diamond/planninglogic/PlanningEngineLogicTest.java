//package com.pacificdataservices.diamond.planninglogic;
//
//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertNotNull;
//
//import java.io.IOException;
//import java.text.ParseException;
//import java.util.ArrayList;
//import java.util.Collection;
//import java.util.List;
//import java.util.Map.Entry;
//import java.util.TreeMap;
//
//import org.javautil.io.IOUtils;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import com.pacificdataservices.diamond.models.FcstGrp;
//import com.pacificdataservices.diamond.planning.Allocator;
//import com.pacificdataservices.diamond.planning.PlanningData;
//import com.pacificdataservices.diamond.planning.demand.Demand;
//import com.pacificdataservices.diamond.planning.marshall.PlanningDataJsonMarshaller;
//import com.pacificdataservices.diamond.planning.services.DiamondPlanningDataServiceTests;
//import com.pacificdataservices.diamond.planning.services.PlanningEngine;
//import com.pacificdataservices.diamond.planning.services.PlanningEngineImpl;
//import com.pacificdataservices.diamond.planning.services.SpringBootTests;
//
//@RunWith(SpringRunner.class)
////@SpringBootTest
//public class PlanningEngineLogicTest {
//	private final Logger logger = LoggerFactory.getLogger(getClass());
//	private static final int MILLION = 1000000;
//
//	//@Autowired
//	private PlanningEngine planningEngine = new PlanningEngineImpl();
//
//	private PlanningData pd;
//	
//	
//	public void setPlanningData(PlanningData pd) {
//		this.pd = pd;
//	}
//	
//	@Before
//	public void before() throws IOException, InstantiationException, IllegalAccessException, ParseException {
//		String fileName = SpringBootTests.planDataFile98565;
//	
//		String jsonIn = IOUtils.readFileAsString(fileName);
//		pd = dillon.unmarshall(jsonIn);
//		List<String> integrityMessages = pd.checkIntegrity();
//		
//		assertEquals(0,integrityMessages.size());
//		Collection<FcstGrp> fcstGrps = pd.getFcstGrps();
//		assertNotNull(fcstGrps);
//	}
//	
//
//
//	// TOOD it runs, now to test results
//	@Test
//	public void testPlanningEngine() throws IOException {
//
//		long testStart = System.nanoTime(); // should be nanos
//	
//		testPlanningData(pd);
//		testAllocator(pd);
//	}
//
//	private void testPlanningData(PlanningData pd) {
//		ArrayList<String> messages = pd.checkIntegrity();
//
//		for (String message : messages) {
//			logger.error("-------------->" + message);
//		}
//		
//		assertEquals(0, messages.size());     // all of the selects are semantically correct
//		assertEquals(5, pd.getDemandCustomers().size());
//	}
//
//	
//	private void testAllocator(PlanningData pd) {
//		Allocator allocator = new Allocator(pd);
//		int demandsSize = pd.getDemands().size();
//		allocator.prioritizeDemands();
//		TreeMap<String, Demand> prioritized = pd.getPrioritizedDemands();
//		assertEquals(53,prioritized.size());
//		assertEquals(demandsSize,prioritized.size());
//		StringBuilder sb = new StringBuilder();
//		sb.append("prioritized demands\n");
//		for (Entry<String, Demand> entry : prioritized.entrySet()) {
//			sb.append(String.format("priority: '%s' value: %s\n", entry.getKey(), entry.getValue()));
//		}
//		logger.info(sb.toString());
//		// Ensure DemandPrioritizer is working 	
//		Entry<String,Demand> firstEntry = prioritized.ceilingEntry("");
//		assertEquals("TYPE:-2-OO-LEADTIME:1-DMDPRTY:0020-NEEDBY:2008-06-17-1DMDCD:REG-292228-00001",firstEntry.getKey());
//		allocator.allocate();
//	}
//
//
////}