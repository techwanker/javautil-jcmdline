package com.pacificdataservices.diamond.apswebservices;

import static org.junit.Assert.assertNotNull;

import java.beans.PropertyVetoException;
import java.io.FileNotFoundException;
import java.sql.SQLException;

import org.javautil.core.sql.SqlStatement;
import org.junit.Test;


public class ListOfValuesControllerTest {

	@Test
	public void getSqlStatementTest() throws FileNotFoundException, SQLException, PropertyVetoException {
		ListOfValuesController controller = new ListOfValuesController();
	
		SqlStatement ss = controller.getSqlStatement("fcst_grp");
		assertNotNull(ss);
	}
}
