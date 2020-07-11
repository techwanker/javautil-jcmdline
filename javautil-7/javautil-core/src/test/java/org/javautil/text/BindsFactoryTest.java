package org.javautil.text;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.javautil.core.sql.Binds;
import org.javautil.util.Day;
import org.javautil.util.NameValueTest;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class BindsFactoryTest {
	private final static   DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	private static final transient Logger logger = LoggerFactory.getLogger(NameValueTest.class);

	BindsFactory nof = new BindsFactory();	
	LocalDate date = LocalDate.now();
	String text = date.format(formatter);
	LocalDate parsedDate = LocalDate.parse(text, formatter);


	@Test
	public void test() {

		Object o = nof.asObject("2020-07-04");
		assertEquals(java.util.Date.class,o.getClass());
		Date d = (Date) o;
		assertEquals(120,d.getYear());
		assertEquals(6,d.getMonth());
		assertEquals(4,d.getDate());
		logger.warn("o {} ",o);
	}

	@Test
	public void test2() {

		Object o = nof.asObject("2020-07-04");
		assertEquals(java.util.Date.class,o.getClass());
		Date d = (Date) o;
		assertEquals(120,d.getYear());
		assertEquals(6,d.getMonth());
		assertEquals(4,d.getDate());
		logger.warn("o {} ",o);
	}

	@Test
	public void test3() {

		Object o = nof.asObject("2020-jul-04");
		Class expected = java.lang.String.class;
		assertEquals(expected,o.getClass());
		assertEquals(o,"2020-jul-04");

	}

	@Test
	public void testOpen() {

		Object o = nof.asObject("\"2020-07-04\"");
		assertEquals(java.lang.String.class,o.getClass());
		assertEquals("2020-07-04",o);

	}
	@Test
	public void testNull() {

		Object o = nof.asObject("null");
		assert(null == o);
		assertNull(o);

	}
	
	
	@Test public void bindArgs() {
		String args [] = { "dt=2010-07-04", "cust=32", "name=joe", "lastname=\"curry\""};
		BindsFactory bf = new BindsFactory();
		List<String> argList = Arrays.asList(args);
		Binds binds = bf.getBinds(argList);
		assertNotNull(binds);
		assertEquals(4,  binds.size());
		assertEquals(new Day(2010,7,4),binds.get("dt"));
		assertEquals(new BigDecimal(32),binds.get("cust"));
		assertEquals("joe",binds.get("name"));
		assertEquals("curry",binds.get("lastname"));
		
	}

	//	@Test
	//	public void testOpenQuote() {
	//
	//		Object o = nof.asObject("\"2020-07-04\"");
	//		assertEquals(java.lang.String.class,o.getClass());
	//		assertEquals(o,new BigDecimal("\"2020-07-04\""));
	//		
	//	}
	//	
	//	@Test
	//	public void testOpen() {
	//
	//		Object o = nof.asObject("\"2020-07-04\"");
	//		assertEquals(java.lang.String.class,o.getClass());
	//		assertEquals(o,new BigDecimal("\"2020-07-04\""));
	//		
	//	}

}
