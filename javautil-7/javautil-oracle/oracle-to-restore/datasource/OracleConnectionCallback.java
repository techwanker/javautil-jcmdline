package com.dbexperts.oracle.datasource;

import java.sql.SQLException;

import javax.sql.DataSource;

import oracle.jdbc.OracleConnection;
import oracle.jdbc.pool.OracleConnectionCacheCallback;

import org.slf4j.Logger;

import com.dbexperts.java.StackTraceHelper;
import com.dbexperts.jdbc.ConnectionCacheEntry;

public class OracleConnectionCallback implements OracleConnectionCacheCallback {

	private static final String newline = System.getProperty("line.separator");

	private final Logger logger = LoggerFactory.getLogger(getClass().getName());

	/*
	 * (non-Javadoc)
	 *
	 * @see com.dbexperts.oracle.datasource.ConnectionCacheCallback#handleAbandonedConnection(oracle.jdbc.OracleConnection,
	 *      java.lang.Object)
	 */
	public boolean handleAbandonedConnection(final OracleConnection arg0, final Object cce) {

		if (cce != null && cce instanceof ConnectionCacheEntry) {
			final ConnectionCacheEntry entry = (ConnectionCacheEntry) cce;
			final String message = StackTraceHelper.getCallStackAsString(entry
					.getCallStack());
			final DataSource ds = entry.getDataSource();
			logger.error("abandoned connection " + newline + "leased at "
					+ entry.getNanoTimeLeased() + newline + message);
			String action = "rollback";
			try {
				arg0.rollback();
				action = "close";
				arg0.close();
			} catch (final SQLException sqe) {
				logger.error("on abandoned connection" + newline
						+ entry.getConn().toString() + " " + action + " "
						+ newline + sqe.getMessage());
			}
		}
		return true;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see com.dbexperts.oracle.datasource.ConnectionCacheCallback#releaseConnection(oracle.jdbc.OracleConnection,
	 *      java.lang.Object)
	 */
	public void releaseConnection(final OracleConnection arg0, final Object arg1) {
		// TODO Auto-generated method stub

	}
}
