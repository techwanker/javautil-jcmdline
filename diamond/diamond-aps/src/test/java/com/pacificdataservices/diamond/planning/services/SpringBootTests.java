package com.pacificdataservices.diamond.planning.services;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootTests {
//	public static final String planDataFile98565 = "src/test/resources/testdata/98565.plandata.json";
	public static final String planGroup10DataFile = "src/test/resources/testdata/planGroup.10.json";
	public static final String planGroup15DataFile = "src/test/resources/testdata/planGroup.15.json";
//	private transient final Logger logger = LoggerFactory.getLogger(getClass());
//
//	private File dbsnapshotDir = new File("target/dbsnapshots");
//	private long runId = 10l;	
////	private Gson dillon  = HibernateMarshallerFactory.getHibernateGsonWithProxyDateFormatter();
//	@Autowired
//	PlanGroupPopulatorService planGroupPopulator;
//	
	@Autowired
	AllocationNumberService allocationNumberService;
//	
//	@Autowired RequestPopulateService requestPopulator;
//	
//	@Autowired
//	PlanningQueueService planningQueueService;
//	
//	@Autowired
//	PlanningResultsPersistence planningResultsPersistence;
//	
//	@Autowired
//	private PlanningDataService pds;
//	
//	private PlanningData pd;
//
//	private boolean initted = false;
//	
////	@Before
//	public void beforeClass () {
//		if (! initted) {
//			testPlanGroupPopulatorService();
//			initted = true;
//		}
//	}
//	
	@Test
	public void testAllocationNumberService() {
		int before = allocationNumberService.getAllocationNumber(10);
		int after = allocationNumberService.getAllocationNumber(15);
		assertEquals(10, after - before);
	}
//	
//	@Test 
//	public void testGroup10() throws IOException {
//		Timer t = new Timer();
//		pd = pds.getPlanningDataForGroup(10);
//		//
//
//		//
//		Allocator allocator = new Allocator(pd);
//		allocator.allocate();
//		//
////		PlanXmlSnapshot dillon  = new PlanXmlSnapshot(dbsnapshotDir);
////		dillon.generateTrace(runId, pd);
////		//
//		PlanningGroup10Tests tests = new PlanningGroup10Tests();
//		//tests.fullTest();
//		logger.info("testGroup10 micros %d",t.getElapsedMicros());
//		//
//		List<Allocation> allocations = pd.getAllocations(AllocationMode.FIRST_PASS);
//		assertNotNull(allocations);
//		logger.info("\n{}",pd.getForecastGroups().formatMatrix());
//			
//		int nextAllocationNumber = allocationNumberService.getAllocationNumber(allocations.size());
//		pd.setNextAllocationNumber(nextAllocationNumber);
//		PlanningResultExtractor extractor = new PlanningResultExtractor(pd);
//		PlanningResult pr = extractor.getPlanningResult();
//		List<ApsResultDtlDmd> apsResultDtlDmds = pr.getApsResultDtlDmds();
//		assertNotNull(apsResultDtlDmds);
//		pd.setApsResultDtlDmds(apsResultDtlDmds);
//		planningResultsPersistence.persistPlanningResult(pr);
//		// TODO must come after PlanningResult as that populates apsResultDtlDmdss
//		PlanningDataMarshallable pdmOut = new PlanningDataMarshallable(pd);
//		File file = new File(planGroup10DataFile);
//		logger.info("writing planningGroup10 to " + file.getCanonicalPath());
//		logger.info("OrderGroups\n{}", pd.getOrderGroups().formatMatrix());
//		pdmOut.writeToFile(file);	
//		// generate test data for website
//		File f = new File("src/test/resources/testdata/pipelineGroup10.json");
//		IOUtils.writeString(f,pd.getPlanGroupPipelineDtoAsJson());
//		
//		File g = new File("src/test/resources/testdata/forecastGroup10.json");
//		IOUtils.writeString(g, pd.getForecastGroupsDtoAsJson());
//		
//		testMultipleCertifications(pd);
//	}
//	
//	//@Test 
//	public void getApsSrcRuleSetExt() {
//		List<ApsSrcRuleSetExt> x = pds.getAllApsSrcRuleSetExt();
//		assertNotNull(x);
//		assert(x.size() > 0);
//	}
////	//@Test 
////	public void testGroup15() throws IOException {
////		Timer t = new Timer();
////		pd = pds.getPlanningDataForGroup(15);
////		assertEquals(2,pd.getIcItemMasts().size());
////		assertEquals(5,pd.getApsDmdOos().size());
////		PlanningDataMarshallable pdmOut = new PlanningDataMarshallable(pd);
////		File file = new File(planGroup15DataFile);
////		logger.info("Writing file {}",file.getAbsolutePath());
////		pdmOut.writeToFile(file);
////		PlanningGroup15Tests tests = new PlanningGroup15Tests();
////		tests.testPlanningEngine();
////		logger.info("testGroup10 micros %d",t.getElapsedMicros());
////	}
//	
//	public void testPlanGroupPopulatorService() {
//		Timer t = new Timer();
//		planGroupPopulator.process();
//		Map<String,BigInteger> stats = planGroupPopulator.getStats();
//		BigInteger itemMasterCount = stats.get("item_mast_count");
//		BigInteger planGroupCount = stats.get("plan_group_count");
//		assertEquals(itemMasterCount,planGroupCount);
//		logger.info("planGroupPopulator micros " + t.getElapsedMicros());
//	}
//	
//	public void testPlanningQueueService()  {
//		requestPopulator.process();
//		List<ApsRqstQueue> queue = requestPopulator.getApsRqstQueue();
//		assert(queue.size() > 0);
//		logger.info("queue size " + queue.size());	
//		Timer t = new Timer();
//		Collection<Integer> itemNumbers = planningQueueService.getItemNumbers();
//		logger.info("returned from getItemNumbers()");
//		assert(itemNumbers.size() > 0);
//		logger.info("micros " + t.getElapsedMicros());
//	}
//	
//	public void testMultipleCertifications(PlanningData pd) throws IOException {
//		logger.info("testMultipleCertifications: ");
//		assertNotNull(pd.getItemNbrsByLotNbr());
//		assertEquals(4,pd.getItemNbrsByLotNbr().size());
//		PlanningDataMarshallable pdm = new PlanningDataMarshallable(pd);
//		assertNotNull(pdm.getItemNbrsByLotNbr());
//		assertEquals(4,pdm.getItemNbrsByLotNbr().size());
//		Map<String, SupplyOnhand> soid = pd.getSupplyOnhandById();
//		for (SupplyOnhand so : soid.values()) {
//			logger.info("id: {} #items {}", so.getIdentifierString(), so.getIcItemMastByItemCd().keySet());
//		}
//		PlanningData pd2 = pdm.toPlanningData();
//		assertNotNull(pd2.getItemNbrsByLotNbr());
//		assertEquals(4,pd2.getItemNbrsByLotNbr().size());
//	
//}
//
//	//@Test
//	public void saveTest() {
//		    pds.save(pd);
//	}
}
