package com.pacificdataservices.diamond.planning.services;

import static org.junit.Assert.assertNotNull;

import java.sql.SQLException;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
@RunWith(SpringRunner.class)
@SpringBootTest
public class PlanningDataResultServiceTest {

	Logger logger = LoggerFactory.getLogger(getClass());
	@Autowired
	PlanningDataResultService  pdrs;
	@Ignore
	@Test
	public void testOneItem() throws SQLException {
		String json = pdrs.getPlanningDataJsonForItem(253491);
		assertNotNull(json);
		logger.info("json {}",json);
	}
	
	@Test
	public void testOneItemInstrumented() throws SQLException {
		String json = pdrs.getPlanningDataJsonForItem(253491);
		assertNotNull(json);
		logger.info("json {}",json);
	}
	
}
