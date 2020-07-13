package com.pacificdataservices.pdssr;

import java.beans.PropertyVetoException;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.text.ParseException;

import org.javautil.poi.workbook.WorkbookWriter;
import org.junit.Ignore;
import org.junit.Test;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

public class WorkbookWriterTest {
	@Test
	public void simpleTest() throws JsonParseException, JsonMappingException, IOException, PropertyVetoException,
	SQLException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, ParseException {
		String definition = "src/main/resources/DataLoadWorkbookMeta2.yaml";
		String [] args = {"--dataSource","integration_postgres_sr","--definition",definition,"--outfile","target/load.xls",
				"etl_file_id=12"};
		WorkbookWriter.main(args);

	}
	
	
}
