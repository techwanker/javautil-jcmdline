package org.javautil.joblog.installer;

import java.beans.PropertyVetoException;
import java.io.Closeable;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

import org.javautil.sql.Binds;
import org.javautil.sql.Dialect;
import org.javautil.sql.SqlParmRunner;
import org.javautil.sql.SqlRunnerParms;
import org.javautil.sql.TestDataSource;
import org.junit.Test;





public class SqlParmRunnerTest {


	//@Test
	public void installLogger() throws SQLException, PropertyVetoException, IOException {
		DataSource  ds = null;
		Connection conn = null;
		try {
			ds = new TestDataSource().getDataSource(Dialect.ORACLE);
			conn = ds.getConnection();
			
			String isname = "src/test/resources/testsr/job_tables.sr.sql";
			InputStream is = new FileInputStream(isname);
			SqlRunnerParms installParms = new SqlRunnerParms(conn, is, isname, 3);
			
			SqlParmRunner spr = new SqlParmRunner(installParms, new Binds());
			
			spr.process();
		}
		finally {
			if (conn != null) {
				conn.close();
			}
			if (ds != null) {
				((Closeable)ds).close();
			}
		}

	}
	
//	@Test
//	public void dropAndInstallLogger() throws SQLException, PropertyVetoException, IOException {
//		DataSource  ds = null;
//		Connection conn = null;
//		try {
//			ArrayList<SqlRunnerParms> parmList = new ArrayList<>();
//			ds = TestDataSource.getDataSource(Dialect.ORACLE);
//			conn = ds.getConnection();
//			
//			String dropName = "src/test/resources/testsr/joblog_drop.sr.sql";
//			InputStream dropIs = new FileInputStream(dropName);
//			SqlRunnerParms dropParms = new SqlRunnerParms(conn, dropIs, dropName, 3);
//			dropParms.setContinueOnError(true);
//			dropParms.setShowSql(true);
//			parmList.add(dropParms);
//			
//			
//			String isname = "src/test/resources/testsr/job_tables.sr.sql";
//			InputStream is = new FileInputStream(isname);
//			SqlRunnerParms installParms = new SqlRunnerParms(conn, is, isname, 3);
//			installParms.setShowSql(true);
//			parmList.add(installParms);
//			
//			SqlParmRunner spr = new SqlParmRunner(parmList, new Binds());
//			
//			spr.process();
//		}
//		finally {
//			if (conn != null) {
//				conn.close();
//			}
//			if (ds != null) {
//				((Closeable)ds).close();
//			}
//		}
//
//	}
	
	@Test
	public void dropAndInstallLoggerFromResource() throws SQLException, PropertyVetoException, IOException {
		DataSource  ds = null;
		Connection conn = null;
		try {
			ArrayList<SqlRunnerParms> parmList = new ArrayList<>();
			ds = new TestDataSource().getDataSource(Dialect.POSTGRES);
			conn = ds.getConnection();
			
			String dropNameResource = "/ddl/postgresql/job_tables_drop.sr.sql";
			SqlRunnerParms dropParms = new SqlRunnerParms(conn, this, dropNameResource, 3);
			dropParms.setContinueOnError(true);
			dropParms.setShowSql(true);
			parmList.add(dropParms);
			
			
			String isnameResource = "/ddl/postgresql/job_tables.sr.sql";
			SqlRunnerParms installParms = new SqlRunnerParms(conn, this, isnameResource, 3);
			installParms.setShowSql(true);
			parmList.add(installParms);
			
			SqlParmRunner spr = new SqlParmRunner(parmList, new Binds());
			
			spr.process();
		}
		finally {
			if (conn != null) {
				conn.close();
			}
			if (ds != null) {
				((Closeable)ds).close();
			}
		}

	}
}
