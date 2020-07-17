package org.javautil.joblog.persistence;

import java.io.Closeable;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.javautil.containers.NameValue;
import org.javautil.core.sql.SqlSplitterException;
import org.javautil.joblog.DataSources;
import org.javautil.joblog.installer.JoblogPostgresInstall;
import org.javautil.sql.Binds;
import org.javautil.sql.DataSourceFactory;
import org.javautil.sql.SqlStatement;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JoblogPostgresExampleTest  {

	private Logger logger = LoggerFactory.getLogger(getClass());
	static DataSource applicationDataSource;
	static Connection applicationConnection;

	static DataSource jobDataSource;
	static Connection joblogConnection;
	static JoblogPersistence joblogPersistence;
	static JoblogPersistence oraclePackagePersistence;
	boolean showSql = false;

	@BeforeClass
	public static void beforeClass() throws SqlSplitterException, Exception {
		DataSourceFactory dsf = new DataSourceFactory();

		applicationDataSource = DataSources.getOracleDataSource();
		applicationConnection = applicationDataSource.getConnection();

		jobDataSource = DataSources.getPostgresJoblogDataSource();
		joblogConnection = jobDataSource.getConnection();
		DataSources.initializePostgresJoblogConnection(joblogConnection);

		joblogPersistence = new JoblogPersistenceSql(joblogConnection, applicationConnection);
		new  JoblogPostgresInstall(joblogConnection).process();
		oraclePackagePersistence = new JoblogPersistencePackage(applicationConnection);
	}

	@AfterClass
	public static void afterClass() throws IOException {
		((Closeable) applicationDataSource).close();
		((Closeable) jobDataSource).close();
	}

	//	@Test
	public void testDirectly() throws SQLException {
		String token = joblogPersistence.joblogInsert("DbLoggerForOracle", getClass().getName(), "ExampleLogging");
		SqlStatement ss = new SqlStatement("select * from job_log where job_token = :token");
		ss.setConnection(joblogConnection);
		Binds binds = new Binds();
		binds.put("token", token);
		NameValue jobNv = ss.getNameValue(binds, true);
		String jobId2 = joblogPersistence.joblogInsert("DbLoggerForOracle", getClass().getName(), "ExampleLogging");
	}

//	@Test
//	public void testSql() throws SQLException, IOException {
//		test1(joblogPersistence);
//	}   

//	// TODO should be commo9n with Oracle
//	public void test1(JoblogPersistence joblogPersistence) throws SQLException, IOException {
//		// TODO look for waits
//		JoblogForOracleExample example = new JoblogForOracleExample(applicationConnection, joblogPersistence, "example",
//				false, 12);
//		String token = example.process();
//		logger.info("test1 token {}", token);
//		assertNotNull(token);
//		logger.debug("token: {}",token);
//		SqlStatement ss = new SqlStatement("select * from job_log where job_token = :token");
//		ss.setConnection(joblogConnection);
//		Binds binds = new Binds();
//		binds.put("token", token);
//		NameValue jobNv = ss.getNameValue(binds, true);
//		binds.put("job_log_id",jobNv.get("job_log_id"));
//		logger.info("jobNv {}", jobNv.toString());
//		assertEquals("main", jobNv.get("thread_name"));
//		assertNotNull(jobNv.get("start_ts"));
//		assertEquals("N", jobNv.get("ignore_flg"));
//		assertEquals("JoblogForOracleExample", jobNv.get("module_name"));
//		assertEquals("org.javautil.joblog.JoblogForOracleExample", jobNv.get("classname"));
//		//
//		SqlStatement stepSs = new SqlStatement(
//				"select * from job_step where job_log_id = :job_log_id order by job_step_id ");
//		stepSs.setConnection(joblogConnection);
//		ListOfNameValue nvSteps = stepSs.getListOfNameValue(binds, true);
//		assertEquals(3, nvSteps.size());
//		logger.debug(nvSteps.toString());
//		NameValue step1 = nvSteps.get(0);
//		assertEquals("limitedFullJoin", step1.get("step_name"));
//		assertEquals("org.javautil.joblog.JoblogForOracleExample",step1.get("classname"));
//		assertEquals("info1",step1.get("step_info"));
//		assertNotNull(step1.get("start_ts"));
//		assertNotNull(step1.get("end_ts"));
//		// TODO continue with cursor stuff
//	}

}
