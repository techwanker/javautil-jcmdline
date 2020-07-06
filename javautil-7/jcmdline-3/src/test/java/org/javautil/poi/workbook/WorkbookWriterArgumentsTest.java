package org.javautil.poi.workbook;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Collection;

import org.junit.Ignore;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import jcmdline.StringParam;

public class WorkbookWriterArgumentsTest {
	
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@Ignore
	@Test
	public void test2() {
		String args[] = {"--dataSource","integration_postgres_sr","--definition","file.yaml","--outfile=/tmp/out.xls","a=b","c","d"};
		WorkbookWriterArguments arguments = WorkbookWriterArguments.processArguments(args);
		assertNotNull(arguments);

		assertEquals("integration_postgres_sr",arguments.getDataSourceName());
		
		
	}
	@Ignore
	@Test
	public void test3() {
		final String dataSource = "integraton_postgress_sr";
	   final String yamlFile= "file.yaml";
		String args[] = {"--dataSource",dataSource,"--definition",yamlFile,"--outfile=/tmp/out.xls","a=b","c","d"};
		WorkbookWriterArguments parameters = WorkbookWriterArguments.processArguments(args);
		assertNotNull(parameters);

		assertEquals(dataSource,parameters.getDataSourceName());
		assertEquals(yamlFile,parameters.getDefinition().getName());
		Collection<StringParam> bindPairs =  parameters.getBindPair();
		assertNotNull(bindPairs);
		
		logger.info("bindPairs {} size {}",bindPairs, bindPairs.size());
		for (StringParam bp : bindPairs) {
			logger.info("bp {} {}",bp.toString(),bp.getValue());
		}
		// for (Object String v : bindPairs.)
	}
	@Test
	public void test4() {
		final String dataSource = "integraton_postgress_sr";
	   final String yamlFile= "file.yaml";
		String args[] = {"--dataSource",dataSource,"--definition",yamlFile,"--outfile=/tmp/out.xls","a=b","c=d"};
		WorkbookWriterArguments parameters = WorkbookWriterArguments.processArguments(args);
		assertNotNull(parameters);

		assertEquals(dataSource,parameters.getDataSourceName());
		assertEquals(yamlFile,parameters.getDefinition().getName());
		ArrayList<StringParam> bindPairs =  parameters.getBindPair();
		assertEquals(2,bindPairs.size());
		String values = bindPairs.toString();
		assertEquals("a=b",bindPairs.get(0));
		assertEquals("c=d",bindPairs.get(1));
		for (Object i : bindPairs)  {
			logger.info( "bindPairs {} object {}",bindPairs.getClass().getName(), i.getClass().getName());
		}
		logger.info("done");

		
	}
}
