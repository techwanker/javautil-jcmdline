package org.javautil.joblog.installer;

import java.beans.PropertyVetoException;
import java.io.Closeable;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import org.javautil.core.sql.Binds;
import org.javautil.core.sql.DataSourceFactory;
import org.javautil.core.sql.Dialect;
import org.javautil.core.sql.SqlStatement;
import org.javautil.core.sql.TestDataSource;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class PostgresInstallTest {

	private Logger logger = LoggerFactory.getLogger(getClass());

	private static DataSource jobDataSource;
	private static Connection jobConnection;

	@BeforeClass
	public static void beforeClass() throws SQLException, PropertyVetoException, IOException {
		if (jobDataSource == null) {
			jobDataSource = new TestDataSource().getDataSource(Dialect.POSTGRES);
//			String url= "jdbc:postgresql://localhost/joblog";
//			String username = System.getenv("USER");
//			String password = "";
//			jobDataSource = getDataSource(url,username,password);
			jobConnection = jobDataSource.getConnection();
		}
	}

	public static void afterClass() throws IOException, SQLException {
		jobConnection.close();
		((Closeable) jobDataSource).close();
	}
	@Test
	public void testJoblogPostgresInstall() throws Exception  {
		Statement s = jobConnection.createStatement();
		s.execute("drop table if exists test_table");
		s.execute("create table test_table (test_id varchar(1))");
		logger.info("testJobLogPostgresInstall created test_table");
		JoblogPostgresInstall installer = new  JoblogPostgresInstall(jobConnection);
		installer.dropObjects();
		installer.process();
	}
	
	public static DataSource getDataSource(String url, String username, String password) {
		final HikariConfig config = new HikariConfig();
		config.setJdbcUrl(url);
		config.setUsername(username);
		config.setPassword(password);
		config.setAutoCommit(false);
		return new HikariDataSource(config);
	}
}