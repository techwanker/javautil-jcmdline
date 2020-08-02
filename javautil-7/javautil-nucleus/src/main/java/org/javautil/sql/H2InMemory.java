package org.javautil.sql;

import java.sql.Connection;
import java.sql.DriverManager;

public class H2InMemory {

	public static Connection getConnection() {
		try {
			Class.forName("org.h2.Driver");
            return DriverManager.getConnection("jdbc:h2:mem:", "", "");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e);
		}

	}

}
