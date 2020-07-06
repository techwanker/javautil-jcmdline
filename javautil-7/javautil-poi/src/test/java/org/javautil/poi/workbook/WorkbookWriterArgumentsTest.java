package org.javautil.poi.workbook;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Ignore;
import org.junit.Test;

public class WorkbookWriterArgumentsTest {
	
	@Ignore
	@Test
	public void test2() {
		String args[] = {"--dataSource","integration_postgres_sr","--definition","file.yaml","a=b","c","d"};
		WorkbookWriterArguments arguments = WorkbookWriterArguments.processArguments(args);
		assertNotNull(arguments);

		assertEquals("integration_postgres_sr",arguments.getDataSourceName());
	}

}
