package org.javautil.poi.workbook;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.beans.PropertyVetoException;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.LinkedHashMap;

import javax.sql.DataSource;

import org.javautil.core.workbook.WorkbookDefinition;
import org.javautil.dataset.ColumnMetadata;
import org.javautil.dataset.DataType;
import org.javautil.joblog.DataSources;
import org.javautil.joblog.installer.JoblogPostgresInstall;
import org.javautil.sql.Binds;
import org.javautil.sql.DataSourceFactory;
import org.javautil.text.YamlUtils;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

public class WorkbookRenderInstrumentedTest {
	private Logger logger = LoggerFactory.getLogger(getClass());

	private Connection loggingConnection = null;
	private Connection conn;
	DataSource dataSource = null;
	@Before
	public void before() throws Exception {
		//DataSource jobDatasource = DataSourceFactory.getH2Permanent("./target/joblogging", "sa", "tutorial");
		//DataSource jobDatasource = DataSourceFactory.getH2Permanent("/tmp/joblogging", "sa", "tutorial");\
		DataSource jobDatasource = DataSources.getPostgresDataSource();

		loggingConnection = jobDatasource.getConnection();	

		JoblogPostgresInstall installer = new JoblogPostgresInstall(loggingConnection);
		installer.dropObjects();
		installer.process();

		DataSourceFactory dataSourceFactory = new DataSourceFactory();
		dataSource = dataSourceFactory.getDatasource("integration_postgres_sr");
		conn = dataSource.getConnection();
	}

	@Test
	public void metaTest() throws JsonParseException, JsonMappingException, IOException, PropertyVetoException,
	SQLException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		File file = new File("src/test/resources/workbook/DataLoadWorkbookMeta2.yaml");
		logger.info("processing file: '{}'", file.getAbsoluteFile());
		WorkbookDefinition wd = WorkbookDefinition.getWorkbookDefinition(file);
		logger.info("input file: {}\n{}",file.getAbsoluteFile(),wd.getFileAsString());
		//
		//String wdAsYaml = YamlUtils.asYaml(wd);
		logger.info("WorkbookDefinition asYaml:\n{}", YamlUtils.asYaml(wd));
		LinkedHashMap<String,ColumnMetadata> columns = wd.getColumns();
		assertNotNull(columns);
		ColumnMetadata shipDt = columns.get("ship_dt");
		assertNotNull(shipDt);
		String dataTypeName = shipDt.getDataTypeName();
		assertNotNull(dataTypeName);

		DataType shipDtDataType = shipDt.getDataType();
		assertNotNull(shipDtDataType);

		Binds binds = new Binds();
		binds.put("etl_file_id", 1);
		// write
		String tmpDir = "target/tmp/";
		File f = new File(tmpDir);
		f.mkdirs();
	
		String outFileName = tmpDir + "LoadFileWorkbook.xls";
		File outFile = new File(outFileName);
		if (outFile.exists()) {
			outFile.delete();
		}
	
		WorkbookWriter workbookRenderer = new WorkbookWriter(conn, loggingConnection, wd, binds,outFile);
		workbookRenderer.process();
		conn.close();
		((Closeable) dataSource).close();

		workbookRenderer.write(new File(outFileName));
		logger.warn("wrote {}", outFile.getAbsoluteFile());
		assertTrue(outFile.canRead());
	}
	@Ignore
	@Test
	public void simpleTest() throws JsonParseException, JsonMappingException, IOException, PropertyVetoException,
	SQLException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		File file = new File("src/test/resources/workbook/DataLoadWorkbook.yaml");
		DataSourceFactory dataSourceFactory = new DataSourceFactory();
		DataSource dataSource = dataSourceFactory.getDatasource("integration_postgres");
		Connection conn = dataSource.getConnection();
		WorkbookDefinition wd = WorkbookDefinition.getWorkbookDefinition(file);
		Binds binds = new Binds();
		binds.put("etl_file_id", 1);
		WorkbookRenderer workbookRenderer = new WorkbookRenderer(conn, wd, binds);
		workbookRenderer.process();
		conn.close();
		String tmpDir = "target/tmp/";
		File f = new File(tmpDir);
		f.mkdirs();
		String outFileName = tmpDir + "LoadFileWorkbook.xls";
		File outFile = new File(outFileName);
		workbookRenderer.write(new File(outFileName));
		logger.warn("wrote {}", outFile.getAbsoluteFile());
		assertTrue(outFile.canRead());
	}



}