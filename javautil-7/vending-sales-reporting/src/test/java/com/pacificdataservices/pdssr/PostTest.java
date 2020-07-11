package com.pacificdataservices.pdssr;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Ignore;
import org.junit.Test;

public class PostTest {
	

	
	@Test
	public void test2() {
		String args[] = {"--dataSource","integration_postgres_sr","--fileNbr","2"};
		PostArgs arguments = Post.processArguments(args);
		assertNotNull(arguments);

		assertEquals("integration_postgres_sr",arguments.getDataSourceName());
	}
	
	@Ignore
	@Test(expected=com.pacificdataservices.pdssr.InvalidLoadFileException.class)
	public void testRun() throws Exception {
		String args[] = {"--dataSource","integration_postgres_sr","--fileNbr","3"};
		Post.main(args);

	}

}
