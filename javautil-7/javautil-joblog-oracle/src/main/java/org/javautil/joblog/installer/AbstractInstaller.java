package org.javautil.joblog.installer;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.javautil.core.sql.DataSourceFactory;
import org.javautil.core.sql.Dialect;
import org.javautil.core.sql.SqlSplitterException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class AbstractInstaller implements JoblogSchemaCreator{

	protected final Connection connection;
	protected boolean showSql = true;

	private boolean drop;
	private boolean noFail;
	private transient Logger logger = LoggerFactory.getLogger(getClass());
	

	public AbstractInstaller(Connection conn) {
		super();
		this.connection = conn;
	}

	public AbstractInstaller(Connection connection, boolean drop, boolean showSql) throws SQLException {
		super();
		if (connection == null) {
			throw new IllegalArgumentException("conn is null");
		}
		Dialect dialect = Dialect.getDialect(connection);
		logger.info("dialect is {}",dialect);
		this.connection = connection;
		this.drop  = drop;
		this.showSql = showSql;
	}

	public boolean isShowSql() {
		return showSql;
	}

	@Override
	public JoblogSchemaCreator setShowSql(boolean showSql) {
		this.showSql = showSql;
		return this;
	}
	
	public JoblogSchemaCreator setDrop(boolean drop) {
		return this;
	}

	@Override
	public boolean isDrop() {
		return drop;
	}
	
	@Override
	public JoblogSchemaCreator setNoFail(boolean noFail) {
		this.noFail = noFail;
		return this;
	}
	
	@Override
	public boolean isNoFail(){
		return noFail;
	}


}