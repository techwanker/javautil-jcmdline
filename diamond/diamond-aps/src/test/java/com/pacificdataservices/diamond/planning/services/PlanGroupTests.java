package com.pacificdataservices.diamond.planning.services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.math.BigInteger;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PlanGroupTests {
	private transient final Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	PlanGroupPopulatorService planGroupPopulator;
	
	@Autowired RequestPopulateService requestPopulator;
	
	@Autowired
	PlanningQueueService planningQueueService;
	
	@Test
	public void testPopulatorService() {
		assertNotNull(planGroupPopulator);
		planGroupPopulator.process();
		logger.info("process() complete");
		Map<String,BigInteger> stats = planGroupPopulator.getStats();
		
		BigInteger itemMasterCount = stats.get("item_mast_count");
		BigInteger planGroupCount = stats.get("plan_group_count");
		assertEquals(itemMasterCount,planGroupCount);
	}
	
}
