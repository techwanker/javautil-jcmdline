package com.pacificdataservices.diamond.planning.services;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.pacificdataservices.diamond.planning.data.PlanningData;
import com.pacificdataservices.diamond.planning.demand.ForecastGroups;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ExportPlanningResultsTest {
	
	@Autowired
	private ExportPlanningResult exporter;
	
	@Autowired
	private PlanningDataService pds;
	
	private Logger logger = LoggerFactory.getLogger(getClass());
	@Test
	public void exportAll() throws IOException, SQLException {
		//File exportDir = new File("target/exportData");
		File exportDir = new File("target/results");
		exportDir.mkdirs();
		exporter.exportAll(exportDir);
	}
	
	@Test
	public void exportForecastGroupsTest() throws SQLException {
		PlanningData planningData = pds.getPlanningDataForGroup(9);
		ForecastGroups forecastGroups= planningData.getForecastGroups();
		logger.info("forecastGroups {}", forecastGroups.toJson());
	}
}
