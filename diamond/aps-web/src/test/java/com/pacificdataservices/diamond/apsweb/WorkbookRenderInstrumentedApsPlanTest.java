package com.pacificdataservices.diamond.apsweb;

import static org.junit.Assert.assertTrue;

import java.beans.PropertyVetoException;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.javautil.core.sql.Binds;
import org.javautil.core.sql.DataSourceFactory;
import org.javautil.core.workbook.WorkbookDefinition;
import org.javautil.joblog.DataSources;
import org.javautil.poi.workbook.WorkbookRenderer;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
public class WorkbookRenderInstrumentedApsPlanTest {
	private Logger logger = LoggerFactory.getLogger(getClass());

	private Connection loggingConnection = null;
	private Connection conn;
	DataSource dataSource = null;
	@Before
	public void before() throws Exception {
		//DataSource jobDatasource = DataSourceFactory.getH2Permanent("./target/joblogging", "sa", "tutorial");
		///DataSource jobDatasource = DataSourceFactory.getH2Permanent("/tmp/joblogging", "sa", "tutorial");\
		DataSource jobDatasource = DataSources.getPostgresDataSource();

		loggingConnection = jobDatasource.getConnection();	

	}


	@Test
	public void simpleTest() throws JsonParseException, JsonMappingException, IOException, PropertyVetoException,
	SQLException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		File file = new File("src/main/resources/workbook/APSWorkbook.yaml");
		DataSourceFactory dataSourceFactory = new DataSourceFactory();
		// TODO move to TestDataSource
		DataSource dataSource = dataSourceFactory.getDatasource("aerodemo_postgres");
		Connection conn = dataSource.getConnection();
		WorkbookDefinition wd = WorkbookDefinition.getWorkbookDefinition(file);
		Binds binds = new Binds();
	//	binds.put("item_nbr", 34461);
		//binds.put("item_nbr_rqst", 34461);
		binds.put("item_nbr", 33793);
		binds.put("item_nbr_rqst", 33793);
		WorkbookRenderer workbookRenderer = new WorkbookRenderer(conn, wd, binds);
		workbookRenderer.process();
		conn.close();
		String tmpDir = "target/tmp/";
		File f = new File(tmpDir);
		f.mkdirs();
		String outFileName = tmpDir + "ApsWorkbook.xls";
		File outFile = new File(outFileName);
		workbookRenderer.write(new File(outFileName));
		logger.warn("wrote {}", outFile.getAbsoluteFile());
		assertTrue(outFile.canRead());
	} 

}