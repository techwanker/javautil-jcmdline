package org.javautil.joblog.installer;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import org.javautil.core.sql.SqlRunner;
import org.javautil.sql.Dialect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JoblogH2Install extends AbstractInstaller  {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

// huh
	public JoblogH2Install(Connection conn) throws SQLException {
		super(conn);
		if (conn == null) {
			throw new IllegalArgumentException("conn is null");
		}
		if (!Dialect.getDialect(conn).equals(Dialect.H2)) {
			throw new IllegalArgumentException("not an H2 connection");
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.javautil.dblogging.CreateDbloggerDatabaseObjects#process()
	 */
	@Override
	public void process() throws Exception {
		if (isDrop()) {
			dropObjects();
		}
		logger.info("creating logger tables for h2");
		final String createTablesResource = "ddl/oracle/job_tables.sr.sql";
		logger.info("about to call SqlRunner showSql {}", showSql);
		dropObjects();
		new SqlRunner(this, createTablesResource).setConnection(connection).setShowSql(showSql)
				.setContinueOnError(isNoFail()).process();
		logger.info("SqlRunner complete");
		connection.commit();
		System.out.println("H2Install:process logger tables installed");
	}

	@Override
	public void dropObjects() throws SQLException {

		final Statement dropAll = connection.createStatement();
		System.out.println("drop everything");
		logger.info("drop everything");
		dropAll.execute("DROP ALL OBJECTS");
		System.out.println("All objects  dropped not datafile!!!!");

	}

	
}
