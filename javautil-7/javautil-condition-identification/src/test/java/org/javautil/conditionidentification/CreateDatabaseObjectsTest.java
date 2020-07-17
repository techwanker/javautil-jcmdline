package org.javautil.conditionidentification;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import org.javautil.sql.DataSourceFactory;
import org.javautil.sql.Dialect;
import org.junit.Test;

public class CreateDatabaseObjectsTest {

	@Test
	public void createObjectsTest() throws SQLException, IOException {
		Connection conn = org.javautil.sql.DataSourceFactory.getInMemoryDataSourceSingletonConnection();
		CreateUtConditionDatabaseObjects creator = new CreateUtConditionDatabaseObjects(conn,  true);
		creator.process();
		// TODO check the schema
	}
}
