package com.pacificdataservices.pdssr;

import static org.junit.Assert.assertNotNull;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.text.ParseException;

import org.javautil.poi.workbook.WorkbookWriterArguments;
import org.junit.Test;
import org.slf4j.Logger;


import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;


public class WorkbookWriterArgumentsTest {
	
	private transient final Logger logger = org.slf4j.LoggerFactory.getLogger(getClass());
	@Test
	public void simpleTest() throws JsonParseException, JsonMappingException, IOException, PropertyVetoException,
	SQLException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, ParseException {
		String definition = "src/main/resources/DataLoadWorkbookMeta2.yaml";
		String [] args = {"--dataSource","integration_postgres_sr","--definition",definition,"--outfile","target/load.xls",
				"etl_file_id=12"};
		System.out.println("version " + WorkbookWriterArguments.version);
		WorkbookWriterArguments parms = WorkbookWriterArguments.processArguments(args);
		assertNotNull(parms);
		Object efi = parms.getBinds().get("etl_file_id");
		logger.info("etl_file_id class {} {}",efi.getClass(),efi);
		assert(new BigDecimal(12).equals(parms.getBinds().get("etl_file_id")));
		
	}
	
	
}
