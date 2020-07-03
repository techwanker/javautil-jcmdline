package com.pacificdataservices.pdssr;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Ignore;
import org.junit.Test;

public class CdsDataLoaderArgsTest {
	
	@Ignore
	@Test
	public void test1() {
		String args[] = {"x.cds"};
		CdsDataLoaderArgs arguments = CdsDataLoader.processArguments(args);
		assertNotNull(arguments);
	}
	
	@Test
	public void test2() {
		String args[] = {"--input=x.cds","--distributor","EXOTICTX","--dataSource","integration_postgres_sr"};
		CdsDataLoaderArgs arguments = CdsDataLoader.processArguments(args);
		assertNotNull(arguments);
		assertEquals("x.cds",arguments.getInputFile().getName());
		assertEquals("EXOTICTX",arguments.getDistributorCode());
		assertEquals("integration_postgres_sr",arguments.getDataSourceName());
	}
	
	@Test
	public void testRun() throws Exception {
		String args[] = {"--input=src/test/resources/dataloads/201502.cds","--distributor","EXOTICTX","--dataSource","integration_postgres_sr"};
		CdsDataLoader.main(args);

	}

}
