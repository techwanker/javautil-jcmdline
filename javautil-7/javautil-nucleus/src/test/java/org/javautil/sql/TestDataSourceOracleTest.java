//package org.javautil.core.sql;
//
//import static org.junit.Assert.assertNotNull;
//
//import java.beans.PropertyVetoException;
//import java.io.Closeable;
//import java.io.FileNotFoundException;
//import java.io.IOException;
//import java.sql.SQLException;
//
//import javax.sql.DataSource;
//
//import org.junit.Test;
//
//public class TestDataSourceOracleTest {
//
//	@Test
//	public void testOracle() throws SQLException, PropertyVetoException, IOException {
//		DataSource ds = TestDataSource.getDataSource(Dialect.ORACLE);
//		assertNotNull(ds);
//		((Closeable) ds).close();
//	}
//
//}
