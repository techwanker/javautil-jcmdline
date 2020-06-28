package org.javautil.core.sql;

import java.beans.PropertyVetoException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

import javax.sql.DataSource;

import org.javautil.core.sql.DataSourceFactory;
import org.javautil.core.sql.Dialect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestDataSource {

	private static final Logger logger = LoggerFactory.getLogger(TestDataSource.class);
	
	private static DataSourceFactory dataSourceFactory = new DataSourceFactory();



	public static DataSource getDataSource(Dialect dialect) throws SQLException, PropertyVetoException, IOException {
		DataSource datasource = null;
		switch (dialect) {
		case H2:
			datasource = getH2FileDataSource();
			break;
		case POSTGRES:
			datasource = getPostgresDataSource();
			break;
		case ORACLE:
			datasource = getOracleDataSource();
			break;
		default:
			throw new IllegalStateException();
		}
		return datasource;
	}

	public static DataSource getH2MemoryDataSource() throws SQLException, PropertyVetoException {
		return DataSourceFactory.getInMemoryDataSource();
	}

	public static DataSource getH2FileDataSource(String dbname) throws SQLException {
		File targetFile = new File(dbname);
		String targetPath;
		try {
			targetPath = targetFile.getCanonicalPath();
		} catch (IOException e) {
			throw new IllegalArgumentException(e);
		}
		HashMap<String, Object> parms = new HashMap<String, Object>();
		parms.put("driver_class", "org.h2.Driver");
		parms.put("url", "jdbc:h2:" + targetPath);
		parms.put("username","sr");
		DataSource ds = DataSourceFactory.getDatasource(parms);
		return ds;
	}
	
	public static DataSource getH2FileDataSource() throws SQLException, PropertyVetoException, IOException {
		return getH2FileDataSource("target/targetdb");
	}
	
	public static DataSource getOracleDataSource() throws PropertyVetoException, SQLException {
		DataSource ds = dataSourceFactory.getDatasource("integration_oracle");
		return ds;
	}

	public static DataSource getPostgresDataSource() throws FileNotFoundException, PropertyVetoException, SQLException {
		logger.debug("getting connection");
		DataSourceFactory dsf = new DataSourceFactory();
		DataSource ds = dsf.getDatasource("integration_postgres");
		Connection conn = ds.getConnection();
		Statement s = conn.createStatement();
		s.execute("drop table if exists test_table");
		s.execute("create table test_table (test_id int)");
		s.close();
		conn.close();
		return ds;
	}
	
	public static DataSource getPostgresSrDataSource() throws FileNotFoundException, PropertyVetoException, SQLException {
		logger.debug("getting connection");
		DataSourceFactory dsf = new DataSourceFactory();
		DataSource ds = dsf.getDatasource("integration_postgres_sr");
		Connection conn = ds.getConnection();
		Statement s = conn.createStatement();
		s.execute("drop table if exists test_table");
		s.execute("create table test_table (test_id int)");
		s.close();
		conn.close();
		return ds;
	}
}
