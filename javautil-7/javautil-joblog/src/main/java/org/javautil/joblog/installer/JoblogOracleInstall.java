package org.javautil.joblog.installer;



import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import org.javautil.containers.ListOfLists;
import org.javautil.containers.ListOfNameValue;
import org.javautil.containers.NameValue;
import org.javautil.sql.Binds;
import org.javautil.sql.Dialect;
import org.javautil.sql.SqlParmRunner;
import org.javautil.sql.SqlRunner;
import org.javautil.sql.SqlRunnerParms;
import org.javautil.sql.SqlSplitterException;
import org.javautil.sql.SqlStatement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JoblogOracleInstall extends AbstractInstaller {

	private final  transient static Logger logger = LoggerFactory.getLogger(JoblogOracleInstall.class);

	public JoblogOracleInstall(Connection connection, boolean drop, boolean showSql) throws SQLException {
		super(connection,drop,showSql);	
		if (!Dialect.ORACLE.equals(Dialect.getDialect(connection))) {
			throw  new IllegalArgumentException("must be an Oracle connection is " + Dialect.getDialect(connection));
		}
	}

	public void process() throws Exception, SqlSplitterException {
		logger.info("process begins===================================");
		logger.info("existing tables ==================");
		SqlStatement ss = new SqlStatement("select table_name from user_tables order by table_name");
		ss.setConnection(connection);
		ListOfLists lols = ss.getListOfLists(new Binds());
		StringBuilder sb = new StringBuilder();
		for (ArrayList<? extends Object> tablename : lols) {
			sb.append(tablename.get(0));
			sb.append("\n");
		}

		logger.info("tables: {}", sb.toString());
		ss.close();

		logger.info("creating tables showSql ");
		loggerObjectInstall();

	}

	void testResourceStream(Connection conn, String resourceName) throws IOException {
		InputStream is = conn.getClass().getResourceAsStream(resourceName);
		logger.warn("is is {} for {}", is, resourceName);
		if (is == null) {
			throw new IllegalStateException("unable to open " + resourceName);
		}
		is.close();
	}

	void createTheTables() throws SQLException, IOException {
		ArrayList<SqlRunnerParms> parmList = new ArrayList<>();

		if (isDrop()) {
			drop();
//			String dropName = "/ddl/oracle/joblog_drop.sr.sql";
//			//InputStream dropIs = new FileInputStream(dropName);
//			SqlRunnerParms dropParms = new SqlRunnerParms(connection, connection, dropName, 3);
//			dropParms.setContinueOnError(true);
//			dropParms.setShowSql(true);
//			parmList.add(dropParms);
		}

		//String loggerTablesName = "src/main/resources/ddl/oracle/logger_tables.sr.sql";
		String loggerTablesResourceName = "/ddl/oracle/logger_tables.sr.sql";
		testResourceStream(connection, loggerTablesResourceName);
		SqlRunnerParms loggerTablesParms = new SqlRunnerParms(connection, connection, loggerTablesResourceName, 3);
		loggerTablesParms.setContinueOnError(true);
		loggerTablesParms.setShowSql(true);
		parmList.add(loggerTablesParms);




		String isname = "/ddl/oracle/job_tables.sr.sql";
		//InputStream is = new FileInputStream(isname);
		SqlRunnerParms installParms = new SqlRunnerParms(connection, connection, isname, 3);
		installParms.setShowSql(true);
		parmList.add(installParms);

		SqlParmRunner spr = new SqlParmRunner(parmList, new Binds());

		spr.process();
	}

	public void loggerObjectInstall() throws SqlSplitterException, SQLException, IOException {

		final String loggerSpec = "ddl/oracle/logger.pks.sr.sql";
		final String loggerBody = "ddl/oracle/logger.pkb.sr.sql";
		final String joblogSpec = "ddl/oracle/joblog.pks.sr.sql";
		final String joblogBody = "ddl/oracle/joblog.pkb.sr.sql";

		logger.info("loggerObjectInstall showSql: {}", showSql);

		createTheTables();

		logger.info("======= about to compile specs " + loggerSpec);
		SqlRunner runner = new SqlRunner(this, loggerSpec).setConnection(connection).
				setShowSql(showSql)
				.setContinueOnError(true);
		runner.setSqlSplitterTrace(3);
		runner.process();

		logger.info("======== creating logger package body " + loggerBody);
		new SqlRunner(this, loggerBody).setConnection(connection).setShowSql(showSql).
		setContinueOnError(true).process();

		runner = new SqlRunner(this, joblogSpec).setConnection(connection).
				setShowSql(showSql)
				.setContinueOnError(true);
		runner.setSqlSplitterTrace(3);
		runner.process();

		new SqlRunner(this, joblogBody).setConnection(connection).setShowSql(showSql).
		setContinueOnError(true).process();

		ensureLoggerPackage(connection);

	}

	public void drop() throws SQLException, FileNotFoundException {
		ArrayList<SqlRunnerParms> parmList = new ArrayList<>();
		String dropName = "/ddl/oracle/joblog_drop.sr.sql";
		//InputStream dropIs = new FileInputStream(dropName);
		SqlRunnerParms dropParms = new SqlRunnerParms(connection, connection, dropName, 3);
		dropParms.setContinueOnError(true);
		dropParms.setShowSql(true);
		parmList.add(dropParms);
		SqlParmRunner spr = new SqlParmRunner(parmList, new Binds());

		spr.process();

	}

	public boolean ensureLoggerPackage(Connection connection) throws SQLException {
		boolean		retval = true;
		String sql = "select object_name, object_type, status from user_objects\n" + 
				"where object_name in ('LOGGER', 'JOBLOG')";

		SqlStatement ss = new SqlStatement(connection,sql);
		ListOfNameValue lonv = ss.getListOfNameValue();
		logger.debug("lnnv {}",lonv);
		ss.close();	
		for (NameValue nv : lonv) {
			if (! "VALID".equals(nv.get("status"))) {
				logger.error("package {} is {}",nv.get("object_name"),nv.get("status"));
				retval = false;
			}
		}
		if (!retval) {
			throw new IllegalStateException("invalid packages");
		}
		return retval;
	}

	@Override
	public void dropObjects() throws SQLException, SqlSplitterException, IOException {
		// TODO Auto-generated method stub
		
	}

}
