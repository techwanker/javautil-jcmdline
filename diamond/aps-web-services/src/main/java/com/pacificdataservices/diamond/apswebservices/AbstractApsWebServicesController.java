package com.pacificdataservices.diamond.apswebservices;

import java.beans.PropertyVetoException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.javautil.core.sql.DataSourceFactory;
import org.javautil.core.sql.SqlStatement;
import org.javautil.core.sql.SqlStatements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class AbstractApsWebServicesController {
	
	Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private DataSource datasource;
	
	private SqlStatements stmts;
	private static final File file = new File("src/main/resources/com/pacificdataservices/diamond/apsweb/list_of_values.yaml"); // TODO
	
	public AbstractApsWebServicesController() throws PropertyVetoException, FileNotFoundException {
		if (datasource == null) {
			logger.warn("autowiring failed");
			DataSourceFactory dsf = new DataSourceFactory();
			datasource = dsf.getDatasource("aerodemo_postgres");;			
			
			stmts  = new SqlStatements(file);
		}
	}
	
	SqlStatement getSqlStatement(String stmtName ) throws FileNotFoundException, SQLException {
		Connection conn = datasource.getConnection();
        SqlStatement stmt = stmts.getSqlStatement(stmtName);
        if (stmt == null) {
        	throw new IllegalArgumentException("Unable to find SqlStatement " + stmtName);
        }
        logger.info("getSqlStatement: {}\n{}",stmtName, stmt.getSql());
        stmt.setConnection(conn);
        conn.close();
		return stmt;
	}
}
