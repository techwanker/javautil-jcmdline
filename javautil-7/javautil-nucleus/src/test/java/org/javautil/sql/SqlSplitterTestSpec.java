package org.javautil.sql;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

// TODO ensure works with no databases up
public class SqlSplitterTestSpec {

	private final Logger logger = LoggerFactory.getLogger(getClass());
	

	@Test
	public void testPackageSpec() throws IOException, SqlSplitterException {

		SqlStatements sqls = new SqlSplitter(this, "testsr/package_spec.sr.sql").getSqlStatements();
		logger.debug("sqls.size() {}", sqls.size());
		String sqls_0 = sqls.get(0).getSql();
		logger.debug("sqls.get(0) {}", sqls_0);
		String[] sqllines = sqls_0.split("\n");
		
		String sqls_0_0 = sqllines[0].trim();
		assertEquals("--%```",sqls_0_0);
		String sqls_0_last = sqllines[sqllines.length - 1];
		
		assertEquals("END logger;",sqls_0_last);

		assertEquals(1, sqls.size());
	}
	
}
