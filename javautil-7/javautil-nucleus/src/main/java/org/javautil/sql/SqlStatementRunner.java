package org.javautil.sql;

import org.javautil.util.Timer;
import org.javautil.sql.Binds;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.SQLException;

public class SqlStatementRunner {
	private final Logger  logger = LoggerFactory.getLogger(this.getClass());

	private final Connection    connection;
	private final SqlStatements sqlStatements;
	private final int           verbosity;

	public SqlStatementRunner(Connection connection, Dialect dialect, SqlStatements sqlStatements, int verbosity) {
		this.connection = connection;
		this.sqlStatements = sqlStatements;
		this.verbosity = verbosity;
	}

	public void process(Binds binds) throws SQLException {
		for (SqlStatement stmt : sqlStatements) {
			stmt.setConnection(connection);

			Timer t = new Timer();
			if (verbosity > 3) {
				logger.info("running " + stmt.getName());
			}
			int updateCount = stmt.executeUpdate(binds);
			if (verbosity > 0) {
				logger.info(stmt.getName() + " records " + updateCount + " millis " + t.getElapsedMillis());
			}
		}

	}

}
