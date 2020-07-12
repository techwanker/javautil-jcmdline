package org.javautil.poi.workbook;
//
//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertNotNull;

import java.beans.PropertyVetoException;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.sql.DataSource;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.javautil.commandline.CommandLineHandlerDelete;
import org.javautil.core.misc.Timer;
import org.javautil.core.sql.BindPair;
import org.javautil.core.sql.Binds;
import org.javautil.core.sql.DataSourceFactory;
import org.javautil.core.sql.SqlSplitterException;
import org.javautil.core.sql.SqlStatement;
import org.javautil.core.workbook.WorkbookDefinition;
import org.javautil.core.workbook.Worksheet;
import org.javautil.dataset.ListOfNameValueDataset;
import org.javautil.joblog.persistence.JoblogPersistenceSql;
import org.javautil.document.style.StyleFactory;
import org.javautil.poi.sheet.ListWorksheetRenderer;
import org.javautil.poi.style.HSSFCellStyleFactory;
import org.javautil.util.Day;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

import jcmdline.StringParam;

public class WorkbookWriter  {

	private Logger logger = LoggerFactory.getLogger(getClass());
	private Connection conn;
	private WorkbookDefinition workbookDefinition;
	private Binds binds;
	private StyleFactory styleFactory;
	private HSSFWorkbook workbook;
	private HSSFCellStyleFactory cellStyleFactory;
	private Connection loggerConnection;
	private	JoblogPersistenceSql dbLogger;

	public WorkbookWriter(Connection conn, Connection loggerConnection,WorkbookDefinition wd, Binds binds) {
		this.conn = conn;
		this.loggerConnection = loggerConnection;
		this.workbookDefinition = wd;
		this.binds = binds;
		this.workbook = new HSSFWorkbook();
		this.cellStyleFactory = new HSSFCellStyleFactory(workbook);
	}

	public WorkbookWriter() {

	}



	private void process(WorkbookWriterArguments arguments) throws PropertyVetoException, SQLException, JsonParseException, JsonMappingException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, IOException {
		DataSourceFactory dsf = new DataSourceFactory();
		DataSource datasource = dsf.getDatasource(arguments.getDataSourceName());
		this.conn = datasource.getConnection();
		this.loggerConnection = loggerConnection;
		File fileDefinition = arguments.getDefinition();
		WorkbookDefinition wd = WorkbookDefinition.getWorkbookDefinition(fileDefinition);
		this.workbookDefinition = wd;
		setBinds(arguments.getBinds());
//		this.binds = arguments.getBinds();
		this.workbook = new HSSFWorkbook();
		this.cellStyleFactory = new HSSFCellStyleFactory(workbook);
		conn.close();
		// TODO Auto-generated method stub
		
	}

	private void setBinds(Binds binds) {
		this.binds = binds;
		
	}

	private void setBindPairs(ArrayList<StringParam> bindPair) {
		Binds binds  = new Binds();
		for (StringParam pairs : bindPair) {
		   Collection values = pairs.getValues();
		    
			for (Object pair  : values) {
				String pairload = (String) pair;
				BindPair bp = new BindPair(pairload);
				binds.put(bp.getName(),bp.getStringValue());
			}
		}
	}

	public void process() throws SQLException {
		try {
			dbLogger = new JoblogPersistenceSql(loggerConnection, conn);
		} catch (SqlSplitterException e) {
			throw new RuntimeException(e);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		final String token = dbLogger.joblogInsert("WorkbookWriter", getClass().getName(), null);
		try {
			runJob(token);
			dbLogger.endJob(token);
			logger.info("finished job {}",token);
		}
		catch(SQLException e) {
			dbLogger.abortJob(token,e);
			throw e;
		}
	}


	private void runJob(String token) throws SQLException {
		for (Worksheet worksheet : workbookDefinition.getWorksheets().values()) {
			long stepId = dbLogger.insertStep(token, "sheet " + worksheet.getName(), getClass());
			Timer sqlTime = new Timer();
			// create the sheet
			logger.info("processing {}", worksheet);
			HSSFSheet sheet = workbook.createSheet(worksheet.getName());
			ListWorksheetRenderer sheetRenderer = new ListWorksheetRenderer(sheet, cellStyleFactory);
			// get the data
			String sql = worksheet.getSql();
			SqlStatement ss = new SqlStatement(conn, sql);
			ListOfNameValueDataset dataset = ss.getListOfNameValueDataSet(binds,workbookDefinition.getColumns());
			logger.info("worksheet {} sql ms {}",worksheet.getName(),sqlTime.getElapsedMillis());
			sheetRenderer.emitRegion(dataset);
			dbLogger.finishStep(stepId);

		}
	}
	public void write(File file) throws IOException {
		workbook.write(file);
	}
	
	public static void main(String[] args) throws SQLException, IOException, ParseException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, PropertyVetoException {
		
		WorkbookWriterArguments arguments = WorkbookWriterArguments.processArguments(args);
		new WorkbookWriter().process(arguments);
//		invocation.process(arguments);
//		WorkbookWriter invocation = new WorkbookWriter();
//		invocation.process(arguments);

	}


}
