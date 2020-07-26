package com.pacificdataservices.uploadingfiles.database;

import static org.junit.Assert.assertNotNull;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.pacificdataservices.tables.User;

@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
@SpringBootTest
public class DatasourceServiceTest {

	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired 
	private DataSource dataSource;
	
	@Test public void testOne() {
		assertNotNull(dataSource);
	}
	
	
	@Test public void testCreateUser() throws SQLException {
		Connection conn = dataSource.getConnection();
		Statement stmt = conn.createStatement();
		stmt.execute(User.createTable);
		PreparedStatement ps = conn.prepareStatement(User.insert);
		ps.setInt(1, 1);
		ps.setString(2, "admin");
		ps.execute();
		conn.commit();
		System.out.println("A user has been added");
		logger.info("added a user");
	}
}
