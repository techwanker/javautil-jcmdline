package org.javautil.sql;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static org.junit.Assert.assertEquals;

public class DatasourceFactoryTest {
	private Logger              logger   = LoggerFactory.getLogger(getClass());

	private static final String username = System.getProperty("user.name");

	private void testConnection(DataSource ds) throws SQLException {
		Connection conn = ds.getConnection();
		org.junit.Assert.assertNotNull("conn", conn);
		logger.debug("got connection");
		PreparedStatement ps = conn.prepareStatement("select 'x'");
		ResultSet rset = ps.executeQuery();
		while (rset.next()) {
			String x = rset.getString(1);
			assertEquals(x, "x");
		}
		logger.debug("connection worked");
		conn.close();
	}

	@Test
	public void testYaml() throws FileNotFoundException, PropertyVetoException, SQLException {
		logger.debug("testYaml");
		String homeDir = System.getProperty("user.home");
		String yamlName = homeDir + "/connections_java.yaml";
		String datasourceName = "integration_postgres_sr";
		DataSourceFactory dsf = new DataSourceFactory(yamlName);
		logger.debug("getting datasourceName {} from {}", datasourceName, yamlName);
		DataSource ds = dsf.getDatasource(datasourceName);
		logger.debug("got datasourceName {} ", datasourceName);
		testConnection(ds);
		logger.debug("testedYaml");
	}
}
