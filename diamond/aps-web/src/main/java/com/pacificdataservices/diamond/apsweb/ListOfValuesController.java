package com.pacificdataservices.diamond.apsweb;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.javautil.core.jdbc.metadata.DatabaseMetadata;
import org.javautil.core.sql.Binds;
import org.javautil.core.sql.SqlStatement;
import org.javautil.core.sql.SqlStatements;
import org.javautil.util.ListOfNameValue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ListOfValuesController 
{

	Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private DataSource datasource;

	@RequestMapping("/listOfValues")
	public ListOfNameValue  listOfValues(
			@RequestParam(value="queryName") String queryName,
			@RequestParam(value="key", defaultValue="%") String key) throws SQLException, FileNotFoundException {
		logger.info("invoked with queryName {}",queryName);
		//
	   Connection conn = datasource.getConnection();
       DatabaseMetadata m =  new DatabaseMetadata(conn);
       logger.info("Database Metadata = " + m.toString());
       
       SqlStatement statement = getSqlStatement(conn,queryName);
       
       Binds binds = new Binds();
       binds.put("key",key);
       ListOfNameValue nameValues = statement.getListOfNameValue(binds);
       conn.close();
       return nameValues;
	}
	
	SqlStatement getSqlStatement(Connection conn,String stmtName ) throws FileNotFoundException, SQLException {
		File file = new File("src/main/resources/com/pacificdataservices/diamond/apsweb/list_of_values.yaml"); // TODO
		FileInputStream fis = new FileInputStream(file);
		//InputStream is =   ResourceHelper.getResourceAsInputStream(this,"list_of_values.yaml");
		SqlStatements stmts = new SqlStatements(fis,conn);
        SqlStatement stmt = stmts.getSqlStatement(stmtName);
        if (stmt == null) {
        	throw new IllegalArgumentException("Unable to find SqlStatement " + stmtName);
        }
        logger.info("getSqlStatement: {}\n{}",stmtName, stmt.getSql());
        stmt.setConnection(conn);
		return stmt;
		
	}
}
