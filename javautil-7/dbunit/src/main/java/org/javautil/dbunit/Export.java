package org.javautil.dbunit;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.dbunit.DatabaseUnitException;
import org.dbunit.database.DatabaseConfig;
import org.dbunit.database.DatabaseConnection;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.database.search.TablesDependencyHelper;
import org.dbunit.dataset.DataSetException;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSet;
import org.javautil.core.sql.TestDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.impl.Log4jLoggerFactory;

import java.io.Closeable;

public class Export {

	private static transient final Logger logger = LoggerFactory.getLogger(Export.class);


	//	public void partial() {
	//		
	////        // database connection
	////        Class driverClass = Class.forName("org.hsqldb.jdbcDriver");
	////        Connection jdbcConnection = DriverManager.getConnection(
	////                "jdbc:hsqldb:sample", "sa", "");
	////        IDatabaseConnection connection = new DatabaseConnection(jdbcConnection);
	//        DataSource ds = TestDataSource.
	//
	//        // partial database export
	//        QueryDataSet partialDataSet = new QueryDataSet(connection);
	//        partialDataSet.addTable("FOO", "SELECT * FROM TABLE WHERE COL='VALUE'");
	//        partialDataSet.addTable("BAR");
	//        FlatXmlDataSet.write(partialDataSet, new FileOutputStream("partial.xml"));
	//
	//	}
	//	
	
	public void dependentTables(Connection conn) throws DatabaseUnitException, SQLException, FileNotFoundException, IOException {
		IDatabaseConnection connection = new DatabaseConnection(conn);
//		IDataSet fullDataSet = connection.createDataSet();
//		FlatXmlDataSet.write(fullDataSet, new FileOutputStream("full.xml"));

		// dependent tables database export: export table X and all tables that
		// have a PK which is a FK on X, in the right order for insertion
		String[] depTableNames = 
				TablesDependencyHelper.getAllDependentTables( connection, "X" );
		IDataSet depDataSet = connection.createDataSet( depTableNames );
		FlatXmlDataSet.write(depDataSet, new FileOutputStream("dependents.xml"));
	}
	public void full(Connection conn) throws FileNotFoundException, IOException, DatabaseUnitException, SQLException {
		IDatabaseConnection connection = new DatabaseConnection(conn,"aerodemo");
		DatabaseConfig dbConfig = connection.getConfig();

		dbConfig.setFeature(DatabaseConfig.FEATURE_CASE_SENSITIVE_TABLE_NAMES , Boolean.TRUE); 
	   
		IDataSet fullDataSet = connection.createDataSet();
		FlatXmlDataSet.write(fullDataSet, new FileOutputStream("/tmp/full.xml"));


	}

	public static void main(String[] args) throws Exception {

		DataSource ds = null;
		Connection conn = null;
	//	try {
			ds =TestDataSource.getPostgresSrDataSource();
			logger.info("ds is {}",ds.toString());
			conn = ds.getConnection();
			Export export  = new Export();
			export.full(conn);
//		}
//		finally {
//			conn.close();
//			((Closeable) ds).close();
//		}

	}
}