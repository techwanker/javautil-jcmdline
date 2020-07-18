package com.pacificdataservices.pdssr.schema;

import java.beans.PropertyVetoException;
import java.io.Closeable;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.javautil.sql.SqlSplitterException;
import org.javautil.sql.TestDataSource;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;;
public class SetupTest extends Setup {

	private Logger logger = LoggerFactory.getLogger(getClass());

	@BeforeClass
	public static void beforeClass() throws SqlSplitterException, Exception {
		beforeClassSetup();
		
	}

	@Test
	public void h2AppSchemaTest() throws SQLException, IOException {
		DataSource ds = TestDataSource.getH2FileDataSource(appDatabaseFullPath);
		testAppSchema(ds);
	}
	
	
	@Test
	public void postgresAppTest() throws SQLException, IOException, PropertyVetoException {
		DataSource ds =  TestDataSource.getPostgresSrDataSource();
		testAppSchema(ds);
	}
	
	@Ignore
	@Test
	public void oracleAppTest() throws SQLException, IOException, PropertyVetoException {
		DataSource ds = new TestDataSource().getOracleDataSource();
		testAppSchema(ds);
	}
	
	
	
	void testAppSchema(DataSource ds) throws SQLException, IOException {
		Connection conn = null;
		try {
		conn = ds.getConnection();
		Setup setup  = new Setup();
		Setup.validateVendingSchema(conn);
		} finally {
			conn.close();
			((Closeable) ds).close();
		}
		
	}

}
