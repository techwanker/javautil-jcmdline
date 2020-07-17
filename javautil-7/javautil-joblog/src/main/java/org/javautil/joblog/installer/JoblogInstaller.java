package org.javautil.joblog.installer;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import org.javautil.core.sql.SqlSplitterException;
import org.javautil.sql.Dialect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JoblogInstaller {

	private transient Logger logger = LoggerFactory.getLogger(getClass());
	private Connection conn;
	private boolean drop = true;
	private	Dialect dialect;
	private JoblogSchemaCreator creator = null;

	public JoblogInstaller(Connection conn) throws SQLException {
		this.conn = conn;
		this.dialect = Dialect.getDialect(conn);
	}
	
	public void process() throws SqlSplitterException, Exception {
		switch (dialect) {
		case ORACLE:
			JoblogOracleInstall installOracle = new JoblogOracleInstall(conn, true, true);
			creator = new JoblogOracleInstall(conn, true, true);
			installOracle.process();
			break;
		case POSTGRES:
			Statement s = conn.createStatement();
			s.execute("drop table if exists test_table");
			s.execute("create table test_table (test varchar(1))");
			s.close();
			logger.info("test_table created");
			
			JoblogPostgresInstall installPostgres = new JoblogPostgresInstall(conn);
			installPostgres.process();
			break;
		case H2:
			JoblogH2Install installH2 = new JoblogH2Install(conn);
			installH2.process();
			break;
		default:
			throw new IllegalArgumentException("unsupported dialect");
		}
	}
	
	public void drop() {
		
	}


}
