package org.javautil.jdbc;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import javax.sql.DataSource;
import java.util.Properties;

public class EnvironmentDataSource {

	public static final String DATABASE_URL      = "DATABASE_URL";
	public static final String DATABASE_USERNAME = "DATABASE_USERNAME";
	public static final String DATABASE_PASSWORD = "DATABASE_PASSWORD";

	public EnvironmentDataSource() {
		super();
	}

	static String getNotNull(Properties properties, String propertyName) {
		final String retval = properties.getProperty(propertyName);
		if (retval == null) {
			throw new IllegalArgumentException("No such property: " + propertyName);
		}
		return retval;
	}

	static String getEnv(String name) {
		final String retval = System.getenv(name);
		if (retval == null) {
			throw new IllegalArgumentException("Unable to get environment variable " + name);
		}
		return retval;
	}

	public static Properties getEnvironmentProperties() {
		final Properties properties = new Properties();
		properties.put(DATABASE_URL, getEnv(DATABASE_URL));
		properties.put(DATABASE_USERNAME, getEnv(DATABASE_USERNAME));
		properties.put(DATABASE_PASSWORD, getEnv(DATABASE_PASSWORD));
		return properties;
	}

	public static HikariDataSource getDataSource() {
		return getDataSource(getEnvironmentProperties());
	}

	public static HikariDataSource getDataSource(Properties properties) {
		final HikariConfig config = new HikariConfig();
		config.setJdbcUrl(getNotNull(properties, DATABASE_URL));
		config.setUsername(getNotNull(properties, DATABASE_USERNAME));
		config.setPassword(getNotNull(properties, DATABASE_PASSWORD));
		config.setAutoCommit(false);
		return new HikariDataSource(config);
	}
	 

	public static DataSource dataSource() {
		System.getenv().put(DATABASE_URL,"jdbc:h2:mem");
		System.getenv().put(DATABASE_USERNAME,"sr");
		System.getenv().put(DATABASE_PASSWORD, "tutorial");
		Properties props = EnvironmentDataSource.getEnvironmentProperties();
		return getDataSource(props);
		
	}
}
