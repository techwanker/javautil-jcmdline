package org.javautil.poi.workbook;

import java.beans.PropertyVetoException;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.text.ParseException;

import org.junit.Test;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

public class WorkbookWriterTest {
	@Test
	public void simpleTest() throws JsonParseException, JsonMappingException, IOException, PropertyVetoException,
	SQLException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, ParseException {
		String definition = "src/test/resources/workbook/DataLoadWorkbookMeta2.yaml";
		String [] args = {"--dataSource","integration_postgres_sr","--definition",definition,"--outfile","target/load.xls",
				"etl_file_id=12"};
		WorkbookWriter.main(args);

	}
	
//	@Ignore // TODO needs column meta data
	@Test
	public void simpleTest2() throws JsonParseException, JsonMappingException, IOException, PropertyVetoException,
	SQLException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, ParseException {
		String definition = "src/test/resources/workbook/DataLoadWorkbook.yaml";
	//	Stri8ng definition = "src/test/resources/workbook/DataLoadWorkbookMeta2.yaml");
		String [] args = {"--dataSource","integration_postgres_sr","--definition",definition,"--outfile","target/load.xls",
				"etl_file_id=12"};
		WorkbookWriter.main(args);

	}
}
