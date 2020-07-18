package org.javautil.joblog.persistence;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.io.Closeable;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.javautil.containers.ListOfNameValue;
import org.javautil.containers.NameValue;
import org.javautil.joblog.JoblogModels;
import org.javautil.joblog.installer.JoblogH2Install;
import org.javautil.sql.SqlStatement;
import org.javautil.sql.TestDataSource;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class JoblogPersistenceSqlTest {
	
	private static DataSource logDataSource;
	private static Connection logConnection;
	private static DataSource appDataSource;
	private static Connection appConnection;
	private static	JoblogPersistence joblog;
	
	@BeforeClass
	public static void beforeClass() throws Exception {
		 logDataSource = TestDataSource.getH2MemoryDataSource();
		 logConnection = logDataSource.getConnection();
		 appDataSource = TestDataSource.getH2MemoryDataSource();
		 appConnection = appDataSource.getConnection();
		JoblogH2Install installer = new  JoblogH2Install(logConnection);
		installer.process();
		joblog = new JoblogPersistenceSql(logConnection, appConnection);
		//installer.drop();
		installer.process();
	}
	
	@AfterClass
	public static void after() throws IOException, SQLException {
		logConnection.close();
		((Closeable) logDataSource).close();
		appConnection.close();
		((Closeable) appDataSource).close();
	}
	
	@Test
	public void testgood() throws SQLException, IOException {
		JoblogPersistence joblog = new JoblogPersistenceSql(logConnection, appConnection);
		String token = joblog.joblogInsert("JobLogPersistenceSqlTest", getClass().getName(), "JobLogPersistenceSqlTest");
		sampleJob(joblog,token);
		JoblogModels model  = new JoblogModels(logConnection);
		NameValue jobStepInfo = model.getJobStepInfo(token);
		assertNotNull(jobStepInfo);
		//
		NameValue jobValues = (NameValue) jobStepInfo.get("job");
		assertEquals("main", jobValues.get("thread_name"));
		assertNotNull(jobValues.get("start_ts"));
		assertEquals("N", jobValues.get("ignore_flg"));
		assertEquals("JobLogPersistenceSqlTest", jobValues.get("module_name"));
		assertEquals(getClass().getName(), jobValues.get("classname"));
		//
		ListOfNameValue stepValues= (ListOfNameValue) jobStepInfo.get("steps");
		assertEquals(1, stepValues.size());
		NameValue step1 = stepValues.get(0);
		assertEquals("tables", step1.get("step_name"));
		assertEquals(getClass().getName(),step1.get("classname"));
		assertNull(step1.get("step_info"));
		assertNotNull(step1.get("start_ts"));
		assertNotNull(step1.get("end_ts"));
		
	}
	
	public void testBad() throws SQLException, IOException {
		String token = joblog.joblogInsert("JobLogPersistenceSqlTest", getClass().getName(), "JobLogPersistenceSqlTest");
			sampleAbortJob(joblog,token);
		JoblogModels model  = new JoblogModels(logConnection);
		NameValue jobStepInfo = model.getJobStepInfo(token);
		assertNotNull(jobStepInfo);
		//
		NameValue jobValues = (NameValue) jobStepInfo.get("job");
		assertEquals("main", jobValues.get("thread_name"));
		assertNotNull(jobValues.get("start_ts"));
		assertEquals("N", jobValues.get("gnore_flg"));
		assertEquals("JoblogForOracleExample", jobValues.get("module_name"));
		assertEquals(getClass().getName(), jobValues.get("classname"));
		//
		ListOfNameValue stepValues= (ListOfNameValue) jobStepInfo.get("steps");
		assertEquals(3, stepValues.size());
		NameValue step1 = stepValues.get(0);
		assertEquals("limitedFullJoin", step1.get("step_name"));
		assertEquals(getClass().getName(),step1.get("classname"));
		assertNull(step1.get("step_info"));
		assertNotNull(step1.get("start_ts"));
		assertNotNull(step1.get("end_ts"));
	}
	
	public String sampleJob(JoblogPersistence joblog, String token) throws SQLException {
		long stepId = joblog.insertStep(token, "tables", getClass(), null);
		SqlStatement ss  = new SqlStatement(appConnection,"select * from information_schema.tables");
		ListOfNameValue lonv  = ss.getListOfNameValue();
		joblog.finishStep(stepId);
		joblog.endJob(token);
		return token;
		
	}
	public String sampleAbortJob(JoblogPersistence joblog, String token) throws SQLException {
		long stepId = joblog.insertStep(token, "tables", getClass(), null);
		try {
			token = joblog.joblogInsert("JobLogPersistenceSqlTest", getClass().getName(), "JobLogPersistenceSqlTest");
			stepId = joblog.insertStep(token, "tables", getClass(), null);
			SqlStatement ss  = new SqlStatement(appConnection,"select * from inform_schema.tables"); // no such schema forced error
			@SuppressWarnings("unused")
			ListOfNameValue lonv  = ss.getListOfNameValue();
			throw new IllegalStateException("should not get here");
		} finally {
		joblog.finishStep(stepId);
		joblog.endJob(token);
		}
		
	}

}
