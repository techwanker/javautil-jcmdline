package org.javautil.sql;

import java.beans.PropertyVetoException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

import javax.sql.DataSource;

import org.javautil.sql.DataSourceFactory;
import org.javautil.sql.Dialect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestDataSource {

	private static final Logger logger = LoggerFactory.getLogger(TestDataSource.class);

	private static DataSourceFactory dataSourceFactory = new DataSourceFactory();

	public TestDataSource() throws FileNotFoundException {
		String connectionsYaml =System.getenv("CONNECTIONS_YAML");
		if (connectionsYaml != null) {
			dataSourceFactory  = new DataSourceFactory(connectionsYaml);
			logger.info("using connections {}",connectionsYaml);
		} else {
			dataSourceFactory  = new DataSourceFactory();
		}
	}

	public DataSource getDataSource(Dialect dialect) throws SQLException, PropertyVetoException, IOException {
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

	public  DataSource getH2FileDataSource() throws SQLException, PropertyVetoException, IOException {
		return getH2FileDataSource("target/targetdb");
	}

	public DataSource getOracleDataSource() throws PropertyVetoException, SQLException {
		DataSource ds = dataSourceFactory.getDatasource("integration_oracle");
		return ds;
	}

	public DataSource getPostgresDataSource() throws FileNotFoundException, PropertyVetoException, SQLException {
		return getPostgresSrDataSource();
	}

	public static DataSource getPostgresSrDataSource() throws SQLException, PropertyVetoException {
		logger.debug("getting connection");

		DataSource ds = null;
		Statement s = null;
		Connection conn = null;
//		try {
			ds = dataSourceFactory.getDatasource("integration_postgres_sr");

			conn = ds.getConnection();
			s = conn.createStatement();
			s.execute("drop table if exists test_table");
			s.execute("create table test_table (test_id int)");
			s.close();
			conn.close();
//		} catch (PropertyVetoException e) {
//			logger.error(e.getMessage());
//			throw new IllegalStateException(e.getMessage());
//		} catch (SQLException e) {
//			logger.error(e.getMessage());
//			throw e;
//		} finally {
//			if (s != null) {
//				s.close();
//				conn.close();
//			}
//		}

		return ds;
	}
}
