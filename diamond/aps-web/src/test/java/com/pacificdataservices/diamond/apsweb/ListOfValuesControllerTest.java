package com.pacificdataservices.diamond.apsweb;

import static org.junit.Assert.assertNotNull;

import java.io.FileNotFoundException;
import java.sql.SQLException;

import org.javautil.core.sql.SqlStatement;
import org.junit.Ignore;
import org.junit.Test;


public class ListOfValuesControllerTest {

	@Ignore // It should be an injected Datasource
	@Test
	public void getSqlStatementTest() throws FileNotFoundException, SQLException {
		ListOfValuesController controller = new ListOfValuesController();
		SqlStatement ss = controller.getSqlStatement(null, "fcst_grp");
		assertNotNull(ss);
	}
}
