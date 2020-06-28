package com.pacificdataservices.diamond.planning.services;



import static org.junit.Assert.assertNotNull;

import java.io.IOException;
import java.sql.SQLException;

import org.javautil.core.misc.Timer;
import org.javautil.hibernate.HibernateMarshallerFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.google.gson.Gson;
import com.pacificdataservices.diamond.planning.data.PlanningData;
import com.pacificdataservices.diamond.planning.json.PlanningDataMarshallable;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PlanningDataServiceTest {
	private transient final Logger logger = LoggerFactory.getLogger(getClass());

	private Gson dillon  = HibernateMarshallerFactory.getHibernateGsonWithProxyDateFormatter();
	@Autowired
	PlanGroupPopulatorService planGroupPopulator;
	
	@Autowired
	private PlanningDataService pds;
	
	private PlanningData pd;

	private int loopCounts = 1;
	
	private int loopNbr = 0;
	 
	public void testPartCd() throws IOException, SQLException {
		Timer t = new Timer();
		String partCd = "B0206001AG6-3";
		Timer dataTimer = new Timer();
		pd = pds.getPlanningDataForPartCd(partCd);
		assertNotNull(pd);
		logger.info("dataTimer loop {} time: {} micros",loopNbr,dataTimer.getElapsedMicros());
		
		Timer marshallTimer  = new Timer();
		PlanningDataMarshallable pdm = new PlanningDataMarshallable(pd);
		logger.info("marshall loop {} time: {} micros",loopNbr,marshallTimer.getElapsedMicros());
		
		
		String json = dillon.toJson(pdm);
		logger.info("loop {} time: {} micros",loopNbr,t.getElapsedMicros());
	}
	
	@Test 
	public void testPartCdBurn() throws IOException, SQLException {
		while (++loopNbr < loopCounts) {
			testPartCd();
		}
	}
	
	
}
