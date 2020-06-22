package org.javautil.joblog.installer;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import org.javautil.core.sql.Binds;
import org.javautil.core.sql.Dialect;
import org.javautil.core.sql.SqlRunner;
import org.javautil.core.sql.SqlSplitterException;
import org.javautil.core.sql.SqlStatement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// TOD collapse these installers
public class JoblogPostgresInstall extends AbstractInstaller {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

//	private final Connection connection;

	private int verbosity = 1;

	public JoblogPostgresInstall(Connection conn) throws SQLException {
		super(conn);
		
		if (!Dialect.POSTGRES.equals(Dialect.getDialect(conn))) {
			throw new IllegalArgumentException("not a postgresql connection " + Dialect.getDialect(conn));
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
		//		SqlStatement ss = new SqlStatement(connection,"create schema joblob");
		//		ss.execute(new Binds());
		SqlStatement ss;
		//		ss = new SqlStatement(connection,"set search_path to joblog");
		//		ss.execute(new Binds());

		logger.info("creating logger tables for postgr");
		final String createTablesResource = "ddl/postgresql/job_tables.sr.sql";
		logger.info("about to call SqlRunner showSql {}", showSql);

		new SqlRunner(this, createTablesResource).setConnection(connection).setShowSql(showSql)
		.setContinueOnError(isNoFail()).process();
		logger.info("SqlRunner complete");
		connection.commit();
		System.out.println("Postgres :process logger tables installed");
	}

	@Override
	public void dropObjects() throws SQLException, SqlSplitterException, IOException {

		logger.info("dropping logger tables for postgr");
		final String dropTablesResource = "ddl/postgresql/job_tables_drop.sr.sql";
		logger.info("about to call SqlRunner showSql {}", isShowSql());

		new SqlRunner(this, dropTablesResource).setConnection(connection).setShowSql(showSql)
		.setContinueOnError(isNoFail()).process();
		logger.info("SqlRunner complete");
		connection.commit();
		if (verbosity > 0) {
			System.out.println("Postgres :process logger tables dropped");
		}

	}

}
