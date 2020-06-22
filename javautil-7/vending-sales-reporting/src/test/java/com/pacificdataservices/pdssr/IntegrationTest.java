package com.pacificdataservices.pdssr;

import java.beans.PropertyVetoException;
import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FilenameFilter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.util.Arrays;

import javax.sql.DataSource;

import org.javautil.conditionidentification.DropUtConditionDatabaseObjects;
import org.javautil.core.sql.Binds;
import org.javautil.core.sql.Dialect;
import org.javautil.core.sql.SqlSplitterException;
import org.javautil.core.sql.SqlStatement;
import org.javautil.core.sql.TestDataSource;
import org.javautil.joblog.installer.JoblogOracleInstall;
import org.javautil.joblog.persistence.JoblogPersistence;
import org.javautil.joblog.persistence.JoblogPersistenceFactory;
import org.javautil.core.misc.Timer;
import org.javautil.util.NameValue;
import org.junit.Ignore;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.pacificdataservices.pdssr.schema.DropSchema;
import com.pacificdataservices.pdssr.schema.SeedSalesReportingDatabase;
import com.pacificdataservices.pdssr.schema.Setup;
import com.pacificdataservices.pdssr.schema.SetupTest;

public class IntegrationTest extends SetupTest implements FilenameFilter {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	private	Connection joblogConnection;
	private	Connection  appConnection ;
	int loadCount = 2;


	private JoblogPersistence joblog;
	public IntegrationTest() throws FileNotFoundException, PropertyVetoException, SQLException {
	}
	//@Ignore
	@Test
	public void fullOracleDialectTest() throws SqlSplitterException, Exception {
		DataSource joblogDataSource = TestDataSource.getDataSource(Dialect.ORACLE);
		joblogConnection = joblogDataSource.getConnection();
		appConnection = joblogDataSource.getConnection();
		Setup setup = new Setup();
		setup.validateVendingSchema(appConnection);
		try {
			logger.info("Oracle test begins");

			joblog = JoblogPersistenceFactory.getJoblogPersistence(joblogConnection, appConnection, true);
			fullTest(Dialect.ORACLE);
			logger.info("Oracle test ends");
		} finally {
			joblogConnection.close();
			appConnection.close();
			((Closeable) joblogDataSource).close();
		}
	}

	//@Ignore
	@Test
	public void postgresAppH2JoblogTest() throws SqlSplitterException, Exception {
		logger.info("Postgres test begins");
		DataSource joblogDataSource = TestDataSource.getH2FileDataSource(logDatabaseFullPath);
		DataSource appDataSource = TestDataSource.getDataSource(Dialect.POSTGRES);

		joblogConnection = joblogDataSource.getConnection();
		appConnection = appDataSource.getConnection();
		try {
			joblog = JoblogPersistenceFactory.getJoblogPersistence(joblogConnection, appConnection, false);
			fullTest(Dialect.POSTGRES);
		} finally {
			joblogConnection.close();
			appConnection.close();
			((Closeable) joblogDataSource).close();
			((Closeable) appDataSource).close();
		}
		logger.info("Postgres test ends");
	}

	@Test
	public void H2AppH2JoblogTest() throws SqlSplitterException, Exception {
		logger.info("H2 test begins");

		DataSource joblogDataSource = TestDataSource.getH2FileDataSource(logDatabaseFullPath);
		DataSource appDataSource = TestDataSource.getH2FileDataSource(appDatabaseFullPath);

		try {
			joblogConnection = joblogDataSource.getConnection();
			appConnection = appDataSource.getConnection();
			Setup setup = new Setup();
			setup.validateVendingSchema(appConnection);
			joblog = JoblogPersistenceFactory.getJoblogPersistence(joblogConnection, appConnection, false);
			setup.validateVendingSchema(appConnection);
			fullTest(Dialect.H2);
			logger.info("H2 test ends");
		} finally {
			joblogConnection.close();
			appConnection.close();
			((Closeable) joblogDataSource).close();
			((Closeable) appDataSource).close();
		}
	}

	public void fullTest(Dialect dialect) throws SqlSplitterException, Exception {
		logger.info("fullTest dialect is " + dialect);
		Timer t = new Timer("fullTest " + dialect);
		loadFiles(null);
		runConditionsAll();
		prepostAll();
		postAll();
		//		unloadAll();
		t.logElapsed();
		appConnection.commit();
	}



	public void loadFiles(String dir) throws Exception {
		logger.info("loadFiles");
		Timer t = new Timer("loadFiles");
		String loadFileDir = "src/test/resources/dataloads";
		if (dir != null) {
			loadFileDir = dir;
		}
		File loadDirFile = new File(loadFileDir);
		FilenameFilter filter = this;
		CdsDataLoader loader = new CdsDataLoader(appConnection, joblog);
		loader.infoStatements();

		File[] files = loadDirFile.listFiles(filter);
		// TODO 
		//		logger.info("files:\n" + files);
		Arrays.sort(files);

		int fileCount = 0;
		for (File f : files) {
			if (++fileCount > loadCount) {
				break;
			}
			loader.process(f.getAbsolutePath(), appConnection, "EXOTICTX", false);
			logger.info("fileCount " + fileCount);
		}
		loader.dispose();

		t.logElapsed();
	}

	private void runConditionsAll() throws FileNotFoundException, SQLException {
		Timer t = new Timer("runConditionsAll");
		logger.info("runConditionsAll");
		LoadConditionIdentification lci = new LoadConditionIdentification(appConnection, joblog);
		SqlStatement loads = new SqlStatement("select etl_file_id from etl_file");
		loads.setConnection(appConnection);

		int fileCount = 0;
		for (NameValue nv : loads.iterator(new Binds())) {
			logger.info("run conditions for file {}",fileCount);
			Binds binds = new Binds();		
			binds.put("ETL_FILE_ID",nv.getLong("ETL_FILE_ID"));
			if (++fileCount > loadCount) {
				break;
			} else {
				lci.process(binds, 3);
			}
		}
		t.logElapsed();
	}

	// TODO dedup from postall
	private void prepostAll() throws SQLException, IOException, InvalidLoadFileException {
		Timer t = new Timer("prepostAll");
		logger.info("prepostAll");
		Prepost prepost = new Prepost(appConnection, joblog,  5);
		SqlStatement loads = new SqlStatement(appConnection, "select etl_file_id from etl_file");
		int fileCount = 0;
		// TODO should just get a tuple
		for (NameValue binds : loads.iterator(new Binds())) {
			try {
				if (++fileCount > loadCount) {
					break;
				}
				prepost.process(binds.getLong("ETL_FILE_ID"));
			} catch (InvalidLoadFileException e) {
				logger.error(e.getMessage());
				throw e;
			}
		}
		t.logElapsed();
	}

	private void postAll() throws SQLException, IOException {
		Timer t = new Timer("postAll");
		logger.info("postAll");
		Post post = new Post(appConnection, joblog,  5);
		SqlStatement loads = new SqlStatement(appConnection, "select etl_file_id from etl_file");
		int fileCount = 0;
		for (NameValue binds : loads.iterator(new Binds())) {
			try {
				if (++fileCount > loadCount) {
					break;
				}
				post.process(binds.getLong("ETL_FILE_ID"));
			} catch (InvalidLoadFileException e) {
				logger.error(e.getMessage());
			}
		}
		t.logElapsed();
	}

	private void unloadAll() throws SQLException, IOException {
		Timer t = new Timer("unloadAll");
		SqlStatement loads = new SqlStatement("select etl_file_id from etl_file");
		String destDir = "/tmp/";
		CdsUnload unloader = new CdsUnload(appConnection,  false);
		int fileCount = 0;
		// for (Binds binds : loads.iterator(conn, dialect, new Binds())) {
		for (NameValue binds : loads.iterator(new Binds())) {
			long etlFileId = binds.getLong("ETL_FILE_ID");
			String fileName = destDir + etlFileId + ".cds";
			unloader.process(etlFileId, fileName, false);
			if (++fileCount >= loadCount) {
				break;
			}
		}

		t.logElapsed();
	}

	@Override
	public boolean accept(File dir, String fileName) {
		return fileName.endsWith(".cds");
	}






}
