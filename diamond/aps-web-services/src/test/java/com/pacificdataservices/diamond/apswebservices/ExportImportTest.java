package com.pacificdataservices.diamond.apswebservices;

import static org.junit.Assert.assertNotNull;

import java.io.File;
import java.io.IOException;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.pacificdataservices.diamond.planning.services.ExportImport;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ExportImportTest {
	
	@Autowired
	private ExportImport ei;

	private Logger logger = LoggerFactory.getLogger(getClass());
	@Ignore
	@Test
	public void exportAll() throws IOException {
		if (ei == null) {
			logger.error("ei is null");
		}
		assertNotNull(ei);
		File exportDir = new File("target/exportData");
		exportDir.mkdirs();
		ei.exportAll(exportDir);
	}
	
	@Ignore
	@Test 
	public  void testGroup9() throws IOException {
		if (ei == null) {
			logger.error("ei is null");
		}
		assertNotNull(ei);
		File exportDir = new File("target/exportData");
		exportDir.mkdirs();
		ei.exportPlanningGroup(9, exportDir);
	}
	
}