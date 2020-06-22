package com.pacificdataservices.pdssr.schema;

import static org.junit.Assert.assertEquals;

import java.beans.PropertyVetoException;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import org.javautil.conditionidentification.CreateUtConditionDatabaseObjects;
import org.javautil.core.jdbc.metadata.containers.DatabaseTables;
import org.javautil.core.jdbc.metadata.dao.TableDaoJdbc;
import org.javautil.core.misc.Timer;
import org.javautil.core.sql.Binds;
import org.javautil.core.sql.Dialect;
import org.javautil.core.sql.SqlRunner;
import org.javautil.core.sql.SqlSplitterException;
import org.javautil.core.sql.SqlStatement;
import org.javautil.core.sql.TestDataSource;
import org.javautil.file.Checkpoint;
import org.javautil.joblog.installer.JoblogInstaller;
import org.javautil.joblog.persistence.JoblogPersistence;
import org.javautil.util.ListOfNameValue;
import org.javautil.util.NameValue;
import org.junit.BeforeClass;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.pacificdataservices.pdssr.schema.SeedSalesReportingDatabase;
import java.io.Closeable;
public class Setup {

	private static Logger logger = LoggerFactory.getLogger(Setup.class);
	private boolean showSqlOnCreate = true;



	private static final String logDatabasePath = "target" + "/" + "logdb";
	private static final File logDatabaseFile = new File(logDatabasePath);
	public final static String logDatabaseFullPath = logDatabaseFile.getAbsolutePath();

	private static final String appDatabasePath = "target" + "/" + "appdb";
	private static final  File appDatabaseFile = new File(appDatabasePath);
	public final static String appDatabaseFullPath = appDatabaseFile.getAbsolutePath();



	public static  void beforeClassSetup() throws SqlSplitterException, Exception {
		Checkpoint cp = new Checkpoint("target/setup.checkpoint");
		cp.delete();
		//	if (!cp.exists()) {
		setupOracleJoblog();
		setupOracleApp();
		setupPostgresApp();

		//
		DataSource h2AppDataSource = null;
		Connection h2AppConn = null;
		try {
		h2AppDataSource = TestDataSource.getH2FileDataSource(appDatabaseFullPath);
		h2AppConn = h2AppDataSource.getConnection();
		Setup setup = new Setup();
		setupH2App(h2AppDataSource,false);
		setup.validateVendingSchema(h2AppConn);
		} finally {
			((Closeable) h2AppDataSource).close();
			h2AppConn.close();
		}
		//
		DataSource joblogDataSource = null;
		Connection joblogConnection = null;
		try {
			joblogDataSource = TestDataSource.getH2FileDataSource(logDatabaseFullPath);
			joblogConnection = joblogDataSource.getConnection();
			setupH2Joblog(joblogConnection);
		Setup setup = new Setup();
			setup.validateJobLogSchema(joblogConnection);
		} finally {
			((Closeable) joblogDataSource).close();
			joblogConnection.close();
		}
		// Oracle


	}

	public static void setupOracleJoblog() throws SqlSplitterException, Exception {
		DataSource joblogDataSource = TestDataSource.getDataSource(Dialect.ORACLE);
		Connection joblogConnection = joblogDataSource.getConnection();
		Setup.nukeSchema(joblogConnection,"joblog");  // app
		Setup setup = new Setup();
		setup.createJoblogSchema(joblogConnection);
		joblogConnection.commit();
	}

	public static void setupOracleApp() throws SqlSplitterException, Exception {
		DataSource appDataSource = TestDataSource.getDataSource(Dialect.ORACLE);
		Connection appConnection = appDataSource.getConnection();
		Setup.nukeSchema(appConnection,"app");  // app
		createAppSchema(appDataSource,true);
	}

	public static void setupPostgresApp() throws SqlSplitterException, Exception {
		logger.info("Postgres test begins");
		DataSource appDataSource = TestDataSource.getDataSource(Dialect.POSTGRES);
		createAppSchema(appDataSource,true);
	}

	public static void setupH2App(DataSource ds, boolean closeDataSource) throws SqlSplitterException, Exception {
		logger.info("H2 begins");
		//DataSource h2AppDataSource = TestDataSource.getH2FileDataSource(appDatabaseFullPath);
		createAppSchema(ds,closeDataSource);
	}

	public static void createAppSchema(DataSource ds, boolean closeDataSource) throws SqlSplitterException, Exception  {
		Connection  appConnection = null ;
		try {
			appConnection = ds.getConnection();
			Setup setup = new Setup();
			Setup.nukeSchema(appConnection, "app");
			setup.createSalesSchema(appConnection);
			setup.validateVendingSchema(appConnection);
		} finally {
			appConnection.commit();
			appConnection.close();
			if (closeDataSource) {
				((Closeable) ds).close();
			}
		}
	}

	public static void setupH2Joblog(Connection joblogConnection) throws SqlSplitterException, Exception {
		logger.info("H2 begins");
		Setup setup = new Setup();
		Setup.nukeSchema(joblogConnection, "app");
		setup.createJoblogSchema(joblogConnection);
	}



	public boolean createJoblogSchema(Connection conn) throws SqlSplitterException, Exception {
		Checkpoint cp = new Checkpoint("target/checkpoint." + Dialect.getDialect(conn) + ".joblog");
		boolean retval = true;
		if (!cp.exists()) {
			JoblogInstaller	joblogInstaller = new JoblogInstaller(conn);
			joblogInstaller.process();
		} else {
			retval = false;
		}
		return retval;
	}

	public boolean createSalesSchema(Connection conn) throws SqlSplitterException, Exception {

		Checkpoint cp = new Checkpoint("target/checkpoint." + Dialect.getDialect(conn) + ".sales");
		boolean retval = true;
		//		if (! cp.exists()) {
		//			logger.warn("not creating sales schema because " + cp.name() + " exists");
		//			nukeSchema(conn);
		CreateUtConditionDatabaseObjects condi = new CreateUtConditionDatabaseObjects(conn,  showSqlOnCreate);
		condi.process();
		InputStream salesReportingDdl;
		switch (Dialect.getDialect(conn)) {
		case H2:
			salesReportingDdl = getResource("sales_reporting_ddl.h2.sql");
			break;
		case POSTGRES:
			salesReportingDdl = getResource("sales_reporting_ddl.postgres.sr.sql");
			break;
		case ORACLE:
			salesReportingDdl = getResource("sales_reporting_ddl.oracle.sr.sql");
			break;
		default:
			throw new IllegalArgumentException("unsupported dialect " );
		}
		SqlRunner runner;
		logger.info("about to create sales tables " + salesReportingDdl);
		runner = new SqlRunner(salesReportingDdl);
		runner.setConnection(conn).setShowError(true).setContinueOnError(false).setShowSql(showSqlOnCreate);
		runner.process();
		seedDatabase(conn);
		salesReportingDdl.close();
		conn.commit();
		cp.create();
		logger.info("createSalesSchema performed complete for " + Dialect.getDialect(conn));
		//		}  else {
		//			logger.info("createSalesSchema skipped complete for " + Dialect.getDialect(conn));
		//			retval = false;
		//		}
		return retval;
	}

	InputStream getResource(String resourceName) {
		InputStream is = this.getClass().getResourceAsStream(resourceName);
		if (is == null) {
			throw new IllegalStateException("resource " + resourceName + " failed to load");
		}
		return is;
	}


	public static void nukeSchema(Connection conn, String schemaName) throws SQLException {
		Checkpoint cp = new Checkpoint("target/checkpoint." + Dialect.getDialect(conn) + "." + schemaName);
		//	if (!cp.exists()) {
		switch (Dialect.getDialect(conn)) {
		case ORACLE:
			nukeOracleSchema(conn);
			break;
		case H2:
			nukeH2Schema(conn);
			break;
		case POSTGRES:
			nukePostgresSchema(conn);
			break;
		default:
			throw new IllegalArgumentException();
		}
		//	}
	}
	private static void nukePostgresSchema(Connection conn) throws SQLException {
		SqlStatement schemaSS = new SqlStatement(conn,"select current_schema");
		NameValue nv = schemaSS.getNameValue();
		schemaSS.close();
		String dropSchema = "drop schema " + nv.getString("current_schema") + " cascade";
		Statement stmt  = conn.createStatement();
		stmt.execute(dropSchema);
		String createSchema = "create schema " + nv.getString("current_schema");
		stmt.execute(createSchema);
		stmt.close();
	}


	private static void nukeH2Schema(Connection conn) throws SQLException {
		Statement s = conn.createStatement();
		s.execute("drop all objects"); // drop all objects delete files
		s.close();
	}


	public static void nukeOracleSchema(Connection conn) throws SQLException {
		if (!Dialect.ORACLE.equals(Dialect.getDialect(conn))) {
			throw new IllegalArgumentException("not an oracle connnection");
		}
		String dropObjects = 
				"declare\n" + 
						"	stmt varchar(255);   \n" + 
						"begin\n" + 
						"	for table_rec in (select table_name from user_tables)\n" + 
						"	loop\n" + 
						"		stmt :=  'drop table ' || table_rec.table_name || ' cascade constraints';\n" + 
						"		dbms_output.put_line(stmt);\n" + 
						"		execute immediate stmt;\n" + 
						"	end loop;\n" + 
						"\n" + 
						"	for obj_rec in (\n" + 
						"		select object_type, object_name \n" + 
						"		from user_objects\n" + 
						"		where object_type not like '%LOB'"
						+ "     and object_type != 'PACKAGE BODY')\n" + 
						"	loop\n" + 
						"		stmt :=  'drop ' || obj_rec.object_type || ' ' ||  obj_rec.object_name ;\n" + 
						"		        dbms_output.put_line(stmt);\n" + 
						"		        execute immediate stmt;\n" + 
						"	end loop;\n" + 
						"end;";
		logger.info("nuking oracle schema");
		Statement stmt = conn.createStatement();
		stmt.execute(dropObjects);
		logger.info("nuked oracle schema");
	}




	private void seedDatabase(Connection conn) throws SQLException, IOException {
		logger.info("seedDatabase");
		Timer t = new Timer("seedDatabase");
		SeedSalesReportingDatabase seeder = new SeedSalesReportingDatabase(conn);
		seeder.process();
		t.logElapsed();
	}

	public boolean validateVendingSchema(Connection conn) throws SQLException {  
		DatabaseMetaData meta = conn.getMetaData();
		TableDaoJdbc dao = new TableDaoJdbc(conn, meta, "SR", null, "%");
		dao.process();
		DatabaseTables tables = dao.getDatabaseTables();
		assert(tables != null);
		logger.info("tables {}",tables);
		SqlStatement ss = new SqlStatement(conn,"select * from org");
		ListOfNameValue lonv = ss.getListOfNameValue(new Binds());
		ss.close();
		logger.info("orgs {}",lonv);
		return true;
	}

	public boolean validateJobLogSchema(Connection conn) throws SQLException {
		DatabaseMetaData meta = conn.getMetaData();
		TableDaoJdbc dao = new TableDaoJdbc(conn, meta, "SR", null, "%");
		dao.process();
		DatabaseTables tables = dao.getDatabaseTables();
		assert(tables != null);
		logger.info("tables {}",tables);
		SqlStatement ss = new SqlStatement(conn,
				"select count(*) job_log_count, max(job_log_id) max_job_log_id from job_log");
		NameValue lonv = ss.getNameValue(new Binds(), true);
		Integer jobLogCount = lonv.getInteger("job_log_count");
		assertEquals(new Integer(0),jobLogCount);
		ss.close();
		logger.info("joblog {}",lonv);
		return true;

	}


	public static void main(String[] args) {

	}


}
