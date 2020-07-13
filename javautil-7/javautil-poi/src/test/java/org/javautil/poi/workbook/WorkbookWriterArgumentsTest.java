package org.javautil.poi.workbook;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.math.BigDecimal;

import org.javautil.core.sql.Binds;
import org.javautil.util.Day;
import org.junit.Ignore;
import org.junit.Test;

public class WorkbookWriterArgumentsTest {
	
	
	@Ignore
	@Test
	public void test2() {
		final String  DATASOURCE="integration_postgres_sr";

		String args[] = {"--dataSource",DATASOURCE, "--definition","file.yaml","dt=2020-07-04",
				"nbr=19","text=hello"};
		WorkbookWriterArguments arguments = WorkbookWriterArguments.processArguments(args);
		assertNotNull(arguments);

		assertEquals(DATASOURCE,arguments.getDataSourceName());
		assertEquals("file.yaml",arguments.getDefinition());
		Binds binds = arguments.getBinds();
		assertNotNull(binds);
		assertEquals(new Day(2020,7,4), binds.get("dt"));
		assertEquals(new BigDecimal(19), binds.get("nbr"));
		assertEquals("hello",binds.get("text"));
	}
	
	@Test
	public void showHelp() {
		final String  DATASOURCE="integration_postgres_sr";

		String args[] = {"--help"};
		WorkbookWriterArguments arguments = WorkbookWriterArguments.processArguments(args);

	}

}
