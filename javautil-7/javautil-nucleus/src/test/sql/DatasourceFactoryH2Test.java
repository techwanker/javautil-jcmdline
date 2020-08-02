package org.javautil.sql;

import org.junit.Test;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import static org.junit.Assert.assertNotNull;

public class DatasourceFactoryH2Test {

	@Test
	public void test() throws SQLException {
		DataSource dataSource = DataSourceFactory.getInMemoryDataSource();
		Connection conn = dataSource.getConnection();
		Statement statement = conn.createStatement();
		assertNotNull(statement);
		statement.close();
		conn.close();

	}

	// doesn't work TODO @Test
	public void testSingleton() throws SQLException {
		DataSource dataSource = DataSourceFactory.getInMemoryDataSourceSingleton();
		Connection conn = dataSource.getConnection();
		Statement statement = conn.createStatement();
		assertNotNull(statement);
		statement.close();
		conn.close();
	}
}
