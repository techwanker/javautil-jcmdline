package com.pacificdataservices.diamond.planning.services;

import java.io.File;
import java.io.IOException;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ExportImportTest {
	
	@Autowired
	private ExportImport exportImport;

    @Ignore // takes too long to run
	@Test
	public void exportAll() throws IOException {
		//File exportDir = new File("target/exportData");
		File exportDir = new File("src/test/resources/testdata");
		exportDir.mkdirs();
		exportImport.exportAll(exportDir);
	}
	@Test
	public void createTestData() throws IOException {
		File exportDir = new File("src/test/resources/testdata");
		exportDir.mkdirs();
		if (exportImport == null) {
			throw new IllegalStateException("exportImport is null");
		}
		exportImport.exportPlanningGroup(9, exportDir);
		exportImport.exportPlanningGroup(10, exportDir);
		exportImport.exportPlanningGroup(15, exportDir);
	}
	
	@Test 
	public  void testGroup9() throws IOException {
		File exportDir = new File("target/exportData");
		exportDir.mkdirs();
		if (exportImport == null) {
			throw new IllegalStateException("exportImport is null");
		}
		exportImport.exportPlanningGroup(9, exportDir);
	}
	
}
