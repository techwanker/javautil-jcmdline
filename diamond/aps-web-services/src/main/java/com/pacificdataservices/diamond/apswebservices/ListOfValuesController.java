package com.pacificdataservices.diamond.apswebservices;
import static org.junit.Assert.assertNotNull;

import java.beans.PropertyVetoException;
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
public class ListOfValuesController extends AbstractApsWebServicesController {
	Logger logger = LoggerFactory.getLogger(getClass());
	
	public ListOfValuesController() throws PropertyVetoException, FileNotFoundException {
		super();
	}

	@RequestMapping("/listOfValues")
	public ListOfNameValue  listOfValues(
			@RequestParam(value="queryName") String queryName,
			@RequestParam(value="key", defaultValue="%") String key) throws SQLException, FileNotFoundException {
		logger.info("invoked with queryName {}",queryName);
       SqlStatement statement = getSqlStatement(queryName);
       
       Binds binds = new Binds();
       binds.put("key",key);
       ListOfNameValue nameValues = statement.getListOfNameValue(binds);
      // conn.close();
       return nameValues;
	}
}
