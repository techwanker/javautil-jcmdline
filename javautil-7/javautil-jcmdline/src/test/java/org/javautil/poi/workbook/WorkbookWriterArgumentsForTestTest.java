package org.javautil.poi.workbook;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.GregorianCalendar;

import org.javautil.commandline.BindsFactory;
import org.javautil.sql.Binds;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WorkbookWriterArgumentsForTestTest {
	
	private final Logger logger = LoggerFactory.getLogger(getClass());
	

	@Test
	public void test2() {
		String[] args = {"--dataSource","integration_postgres_sr","--definition","file.yaml","--outfile=/tmp/out.xls","a=b","c","d"};
		WorkbookWriterArgumentsForTest arguments = WorkbookWriterArgumentsForTest.processArguments(args);
		assertNotNull(arguments);

		assertEquals("integration_postgres_sr",arguments.getDataSourceName());		
	}
	
	@Test
	public void test3() {
		final String dataSource = "integraton_postgress_sr";
	   final String yamlFile= "file.yaml";
		String[] args = {"--dataSource",dataSource,"--definition",yamlFile,"--outfile=/tmp/out.xls","a=b","c","d"};
		WorkbookWriterArgumentsForTest parameters = WorkbookWriterArgumentsForTest.processArguments(args);
		assertNotNull(parameters);

		assertEquals(dataSource,parameters.getDataSourceName());
		assertEquals(yamlFile,parameters.getDefinition().getName());
		Collection<String> bindPairs =  parameters.getBindPair();
		assertNotNull(bindPairs);
		
		logger.info("bindPairs {} size {}",bindPairs, bindPairs.size());
		for (String bp : bindPairs) {
			logger.info("bp {} {}", bp,bp);
		}
		// for (Object String v : bindPairs.)
	}
	
	@Test
	public void test4() {
		final String dataSource = "integraton_postgress_sr";
	   final String yamlFile= "file.yaml";
		String[] args = {"--dataSource",dataSource,"--definition",yamlFile,"--outfile=/tmp/out.xls","a=b","c=d"};
		WorkbookWriterArgumentsForTest parameters = WorkbookWriterArgumentsForTest.processArguments(args);
		assertNotNull(parameters);

		assertEquals(dataSource,parameters.getDataSourceName());
		assertEquals(yamlFile,parameters.getDefinition().getName());
		ArrayList<String> bindPairs =  parameters.getBindPair();
		assertEquals(2,bindPairs.size());
		String values = bindPairs.toString();
		assertEquals("a=b",bindPairs.get(0));
		assertEquals("c=d",bindPairs.get(1));
		for (Object i : bindPairs)  {
			logger.info( "bindPairs {} object {}",bindPairs.getClass().getName(), i.getClass().getName());
		}
		logger.info("done");

		
	}
	
	@Test
	public void test5() {
		final String dataSource = "integraton_postgress_sr";
	   final String yamlFile= "file.yaml";
		String[] args = {"--dataSource",dataSource,"--definition",yamlFile,"--outfile=/tmp/out.xls","fromdate=2020-07-04","file=d3",
				"distributor=txexotic"};
		WorkbookWriterArgumentsForTest parameters = WorkbookWriterArgumentsForTest.processArguments(args);
		assertNotNull(parameters);

		assertEquals(dataSource,parameters.getDataSourceName());
		assertEquals(yamlFile,parameters.getDefinition().getName());
		ArrayList<String> bindPairs =  parameters.getBindPair();
		assertEquals(3,bindPairs.size());
		String values = bindPairs.toString();
		Object o = bindPairs.get(0);
		assertEquals("java.lang.String",o.getClass().getCanonicalName());
		
		assertEquals("fromdate=2020-07-04",bindPairs.get(0));
		assertEquals("file=d3",bindPairs.get(1));
		for (Object i : bindPairs)  {
			logger.info( "bindPairs {} object {}",bindPairs.getClass().getName(), i.getClass().getName());
		}
	
		logger.info("done");

		
	}
	
	@Test
	public void bindsExample() {
		final String dataSource = "integraton_postgress_sr";
		   final String yamlFile= "file.yaml";
			String[] args = {"--dataSource",dataSource,"--definition",yamlFile,"--outfile=/tmp/out.xls","fromdate=2020-07-04","file=d3",
					"distributor=txexotic"};
			WorkbookWriterArgumentsForTest parameters = WorkbookWriterArgumentsForTest.processArguments(args);
			BindsFactory bf = new BindsFactory();
			Binds b =  bf.getStringParamBinds(parameters.getBindPair());
			assertEquals(3,b.size());
			assertEquals("d3",b.get("file"));
			assertEquals(new GregorianCalendar(2020, Calendar.JULY,4).getTime(),b.get("fromdate"));
			assertEquals("txexotic",b.get("distributor"));
		
			logger.info("done");

			
	}
}
