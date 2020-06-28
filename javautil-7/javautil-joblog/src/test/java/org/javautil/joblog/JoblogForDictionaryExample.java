package org.javautil.joblog;

import java.sql.Connection;
import java.sql.SQLException;

import org.javautil.core.sql.Binds;
import org.javautil.core.sql.ConnectionHelper;
import org.javautil.core.sql.SqlStatement;
import org.javautil.joblog.persistence.JoblogPersistence;
import org.javautil.util.NameValue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JoblogForOracleExample {

	private JoblogPersistence joblog;
	private Connection connection;
	private String processName;
	private boolean testAbort = false;
	private final Logger logger = LoggerFactory.getLogger(getClass());
	private String jobToken;

	public JoblogForOracleExample(Connection connection, JoblogPersistence joblog, String processName, boolean testAbort,
			int traceLevel) {
		this.connection = connection;
		this.joblog = joblog;
		this.processName = processName;
		this.testAbort = testAbort;
	}

	public String process() throws SQLException {
		joblog.prepareConnection();

		try {
			jobToken = joblog.joblogInsert(processName, getClass().getName(), "JoblogForOracleExample");
			logger.debug("============================ token: {}", jobToken);
			limitedFullJoin();
			fullJoin();
			userTablesCount();
			if (testAbort) {
				int x = 1 / 0;
			}
			logger.debug("calling endJob");
			joblog.endJob(jobToken);
		} catch (Exception e) {
			logger.error(e.getMessage());
			e.printStackTrace();
			joblog.abortJob(jobToken,e);
			throw e;
		}
		return jobToken;
	}

	/**
	 * This will set the v$session.action
	 */
	private void limitedFullJoin() throws SQLException {
		long stepId = 	joblog.insertStep(jobToken, "limitedFullJoin",  getClass().getName(), "info1");
		ConnectionHelper.exhaustQuery(connection, "select * from user_tab_columns, user_tables where rownum < 200");
		joblog.finishStep(stepId);
	}

	private void fullJoin() throws SQLException {
		// TODO insertStep should set the action
		long stepId = joblog.insertStep(jobToken,"fullJoin",  getClass().getName(), "info2");
		ConnectionHelper.exhaustQuery(connection, "select * from user_tab_columns, user_tables");
		joblog.finishStep(stepId);
	}

	private void userTablesCount() throws SQLException {
		long stepId = joblog.insertStep(jobToken,"count full", getClass().getName(),"userTablesCount");
		ConnectionHelper.exhaustQuery(connection, "select count(*) dracula from user_tables");
		joblog.finishStep(stepId);
		// TODO support implicit finish step
	}

	NameValue getJobLog(Connection connection, long id) throws SQLException {
		final String sql = "select * from job_log " + "where job_log_id = :job_stat_id";
		final SqlStatement ss = new SqlStatement(connection, sql);
		Binds binds = new Binds();
		binds.put("job_stat_id", id);
		final NameValue retval = ss.getNameValue();
		ss.close();
		return retval;
	}
}
