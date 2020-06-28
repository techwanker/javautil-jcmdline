package org.javautil.joblog;

import java.sql.Connection;
import java.sql.SQLException;

import org.javautil.core.sql.Binds;
import org.javautil.core.sql.ConnectionHelper;
import org.javautil.core.sql.Dialect;
import org.javautil.core.sql.SqlStatement;
import org.javautil.joblog.persistence.JoblogPersistence;
import org.javautil.util.NameValue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JoblogForDictionaryExample {

	private JoblogPersistence joblog;
	private Connection connection;
	private String processName;
	private boolean testAbort = false;
	private final Logger logger = LoggerFactory.getLogger(getClass());
	private String jobToken;
	
	private static final String tablesOracle = 
			"select  owner table_catalog,\n" + 
			"            owner table_schema,\n" + 
			"            object_name table_name,\n" + 
			"            object_type table_type\n" + 
			"from   all_objects\n" + 
			"where object_type in ('VIEW', 'TABLE');\n" + 
			"";
	
	private static final String tablesAnsi = 
			"select  table_catalog,\n" + 
			"            table_schema,\n" + 
			"            table_name,\n" + 
			"            table_type\n" + 
			"from   information_schema.tables" + 
	
			"";
	
	private static final String columnsOracle  = "select  owner table_catalog,\n" + 
			"            owner table_schema,\n" + 
			"            table_name, \n" + 
			"            column_name \n" + 
			"from   all_tab_columns\n";
		
			
			private static final String columnsAnsi = "select  owner table_catalog,\n" + 
					"            owner table_schema,\n" + 
					"            table_name, \n" + 
					"            column_name \n" + 
					"from   information_schema.columns\n";
				
			
			private static String tabColumnsOracle = "select * from user_tab_columns, user_tables";
					
					private static final String tabColumnsAnsi = "select * from information_schema.columns, information_schema.tables";	
					
					Dialect dialect;

	public JoblogForDictionaryExample(Connection connection, JoblogPersistence joblog, String processName, boolean testAbort,
			int traceLevel) throws SQLException {
		this.connection = connection;
		this.joblog = joblog;
		this.processName = processName;
		this.testAbort = testAbort;
		this.dialect = Dialect.getDialect(connection);
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
		String q;
		switch (dialect) {
		case ORACLE:
			q = tabColumnsOracle + " where rownum < 200";
			break;
		default:
			q  = tabColumnsAnsi + " limit 200";
		}

		ConnectionHelper.exhaustQuery(connection, q);
		joblog.finishStep(stepId);
	}

	private void fullJoin() throws SQLException {
		// TODO insertStep should set the action
		long stepId = joblog.insertStep(jobToken,"fullJoin",  getClass().getName(), "info2");
		
		String q;
		switch (dialect) {
		case ORACLE:
			q = tabColumnsOracle;
			break;
		default:
			q  = tabColumnsAnsi;
		}
		ConnectionHelper.exhaustQuery(connection, q);
		joblog.finishStep(stepId);
	}

	private void userTablesCount() throws SQLException {
		long stepId = joblog.insertStep(jobToken,"count full", getClass().getName(),"userTablesCount");

		String q;
		switch (dialect) {
		case ORACLE:
			q = "select count(*) from (" + tablesOracle + ")";
			break;
		default:
			q = "select count(*) from (" + tablesAnsi + ")";
		}
		ConnectionHelper.exhaustQuery(connection, "q");
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
