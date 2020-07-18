package org.javautil.core.sql;

import static org.junit.Assert.assertNotNull;

import java.beans.PropertyVetoException;
import java.io.Closeable;
import java.io.IOException;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.javautil.sql.Dialect;
import org.javautil.sql.TestDataSource;
import org.junit.Test;

public class TestDataSourceTest {


	@Test
	public void testPostgres() throws SQLException, PropertyVetoException, IOException {
		DataSource ds = new TestDataSource().getDataSource(Dialect.POSTGRES);
		assertNotNull(ds);
		((Closeable) ds).close();
	}
	@Test
	public void testH2() throws SQLException, PropertyVetoException, IOException {
		DataSource ds = new TestDataSource().getDataSource(Dialect.H2);
		assertNotNull(ds);
		((Closeable) ds).close();
	}
	
}
