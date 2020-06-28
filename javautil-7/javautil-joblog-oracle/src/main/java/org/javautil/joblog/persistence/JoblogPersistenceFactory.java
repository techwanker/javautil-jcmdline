package org.javautil.joblog.persistence;

import java.sql.Connection;

import org.javautil.core.sql.SqlSplitterException;
import org.javautil.joblog.installer.JoblogInstaller;

public class JoblogPersistenceFactory {

	public static JoblogPersistence getJoblogPersistence(Connection loggerConnection, Connection appConnection, boolean createObjects) throws SqlSplitterException, Exception {
		if (loggerConnection == null) {
			throw new IllegalArgumentException("loggerConnection is null");
		}
		if (appConnection == null) {
			throw new IllegalArgumentException("appConnection is null");
		}
		if (createObjects) {
			JoblogInstaller installer = new JoblogInstaller(loggerConnection);
			installer.process();
		}
		JoblogPersistence joblogger = new JoblogPersistenceSql(loggerConnection, appConnection);
		return joblogger;
	}
}
