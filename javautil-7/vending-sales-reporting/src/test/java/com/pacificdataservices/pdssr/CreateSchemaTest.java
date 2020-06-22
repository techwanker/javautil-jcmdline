package com.pacificdataservices.pdssr;

import java.beans.PropertyVetoException;
import java.io.Closeable;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;

import javax.sql.DataSource;

import org.javautil.core.sql.TestDataSource;
import org.javautil.core.sql.Dialect;
import org.javautil.core.sql.SqlSplitterException;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.pacificdataservices.pdssr.schema.CreateSchema;

public class CreateSchemaTest  {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	private Dialect dialect = Dialect.ORACLE;

	@Test
	public void test1() throws SqlSplitterException, Exception {
		DataSource ds = null;
		Connection conn = null;
		try {
			ds = TestDataSource.getDataSource(Dialect.ORACLE);
			conn = ds.getConnection(); 
			CreateSchema cs = new CreateSchema(conn);
			cs.process();
		} finally { 
			conn.close();
			((Closeable) ds).close();
		}
	}
}