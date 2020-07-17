package org.javautil.joblog.installer;

import java.io.Closeable;
import java.sql.Connection;

import javax.sql.DataSource;

import org.javautil.sql.SqlStatement;
import org.junit.Test;

public class H2InstallTest {

	// TODO WTF

	@Test
	public void testDrop() throws Exception  {
		
		DataSource jobDatasource = org.javautil.sql.DataSourceFactory.getH2Permanent("/tmp/H2InstallTest", "sa", "tutorial");
		Connection jobConnection = jobDatasource.getConnection();	
		SqlStatement dropAllStmt = new SqlStatement(jobConnection,"drop all objects");
		dropAllStmt.execute(new org.javautil.sql.Binds());
		JoblogH2Install installer = new  JoblogH2Install(jobConnection);
		//installer.drop();
		installer.process();
		jobConnection.close();
		((Closeable) jobDatasource).close();
	}

//	public static void ensureLoggerPackage(Connection connection) throws SQLException {
//		String sql = "select object_type, status from user_objects\n" + 
//				"where object_name = 'LOGGER'";
//
//		SqlStatement ss = new SqlStatement(connection,sql);
//		NameValue nv = ss.getNameValue();
//		assertEquals("VALID",nv.get("status"));
//		ss.close();	
//	}
}