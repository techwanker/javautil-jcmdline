package org.javautil.sql;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;

public enum Dialect {

	POSTGRES, SQLITE, H2, ORACLE, UNSPECIFIED;

	public static Dialect getDialect(Connection connection) throws SQLException {
		Logger logger = LoggerFactory.getLogger(Dialect.class);
		// logger.info("Connection class is " + connection.getClass().getName());
		DatabaseMetaData metadata = connection.getMetaData();
		if (logger.isDebugEnabled()) {
			StringBuilder sb = new StringBuilder();
			sb.append("Database Product Name: ").append(metadata.getDatabaseProductName()).append("\n");
			sb.append("Database Product Version: ").append(metadata.getDatabaseProductVersion()).append("\n");
			sb.append("Logged User: ").append(metadata.getUserName()).append("\n");
			sb.append("JDBC Driver: ").append(metadata.getDriverName()).append("\n");
			sb.append("Driver Version: ").append(metadata.getDriverVersion()).append("\n");

		}
		if (metadata.getDatabaseProductName().equals("PostgreSQL")) {
			return POSTGRES;
		}
		if (metadata.getDatabaseProductName().equals("Oracle")) {
			return ORACLE;
		}
		/*
		if (connection.isWrapperFor(oracle.jdbc.OracleConnection.class)) {
			return ORACLE;
		}
		*/
		if (connection.isWrapperFor(org.h2.jdbc.JdbcConnection.class)
		    || connection.getClass().equals(org.h2.jdbc.JdbcConnection.class)) {
			return H2;
		}
		throw new IllegalArgumentException("Unknown driver " + connection);
	}

	boolean useQuestionBinds() {
		if (this == Dialect.ORACLE) {
			return false;
		}
		return true;
	}

}
