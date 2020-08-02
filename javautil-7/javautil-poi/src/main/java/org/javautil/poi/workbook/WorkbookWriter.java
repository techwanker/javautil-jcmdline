package org.javautil.poi.workbook;
//
//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertNotNull;

import java.beans.PropertyVetoException;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;

import javax.sql.DataSource;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.javautil.util.Timer;
import org.javautil.dataset.ListOfNameValueDataset;
import org.javautil.document.style.StyleFactory;
import org.javautil.joblog.persistence.JoblogPersistence;
import org.javautil.joblog.persistence.JoblogPersistenceNoOperation;
import org.javautil.joblog.persistence.JoblogPersistenceSql;
import org.javautil.poi.sheet.ListWorksheetRenderer;
import org.javautil.poi.style.HSSFCellStyleFactory;
import org.javautil.sql.Binds;
import org.javautil.sql.DataSourceFactory;
import org.javautil.sql.SqlStatement;
import org.javautil.workbook.WorkbookDefinition;
import org.javautil.workbook.Worksheet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

public class WorkbookWriter  {

	private Logger logger = LoggerFactory.getLogger(getClass());
	private DataSourceFactory dsf = new DataSourceFactory();
	private DataSource loggerDataSource;
	private DataSource datasource;
	private Connection conn;
	private Connection loggerConnection;
	private WorkbookDefinition workbookDefinition;
	private Binds binds;
	private StyleFactory styleFactory;
	private HSSFWorkbook workbook;
	private HSSFCellStyleFactory cellStyleFactory;
	private File outfile;

	private	JoblogPersistence dbLogger = new JoblogPersistenceNoOperation();
	private WorkbookWriterArguments arguments;

	public WorkbookWriter(Connection conn, Connection loggerConnection,WorkbookDefinition wd, Binds binds, File outfile) {
		this.conn = conn;
		this.loggerConnection = loggerConnection;
		this.workbookDefinition = wd;
		this.binds = binds;
		this.workbook = new HSSFWorkbook();
		this.cellStyleFactory = new HSSFCellStyleFactory(workbook);
		this.outfile = outfile;
	}

	public WorkbookWriter() {

	}


//	private JoblogPersistence getLogger(WorkbookWriterArguments parms) throws PropertyVetoException, SQLException, IOException {
//		JoblogPersistence logger = new JoblogPersistenceNoOperation();
//		if (parms.getLoggerDataSourceName() != null) {
//			loggerDataSource = dsf.getDatasource(parms.getDataSourceName());
//			loggerConnection = loggerDataSource.getConnection();
//			logger = new JoblogPersistenceSql(loggerConnection, conn);
//		}
//		return logger;
//	}
//

	public  void process() throws SQLException, IOException {

		final String token = dbLogger.joblogInsert("WorkbookWriter", getClass().getName(), null);
		try {
			runJob(token);
			dbLogger.endJob(token);
			logger.info("finished job {}",token);
		}
		catch(SQLException e) {
			dbLogger.abortJob(token,e);
			throw e;
		} finally {
			conn.close();
			if (loggerConnection != null) {
				loggerConnection.close();
			}
			if (loggerDataSource != null) {
				((Closeable) loggerDataSource).close();
			}
			if (datasource != null) {
				((Closeable) datasource).close();
			}
			conn.close();
		}
	}

//	private void process(WorkbookWriterArguments arguments) throws PropertyVetoException, SQLException, JsonParseException, JsonMappingException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, IOException {
//
//		this.arguments = arguments;
//		DataSource datasource = dsf.getDatasource(arguments.getDataSourceName());
//		this.conn = datasource.getConnection();
//
//		File fileDefinition = arguments.getDefinition();
//		WorkbookDefinition wd = WorkbookDefinition.getWorkbookDefinition(fileDefinition);
//		this.workbookDefinition = wd;
//		setBinds(arguments.getBinds());
//		//		this.binds = arguments.getBinds();
//		this.workbook = new HSSFWorkbook();
//		this.cellStyleFactory = new HSSFCellStyleFactory(workbook);
//		dbLogger = getLogger(arguments);
//		outfile = arguments.getOutfile();
//		process();
//
//	}



	private void setBinds(Binds binds) {
		this.binds = binds;

	}


	private void runJob(String token) throws SQLException, IOException {
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
		write(outfile);

	}

	public void write(File file) throws IOException {
		workbook.write(file);
	}

//	public static void main(String[] args) throws SQLException, IOException, ParseException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, PropertyVetoException {
//
//		WorkbookWriterArguments arguments = WorkbookWriterArguments.processArguments(args);
//		new WorkbookWriter().process(arguments);
//	}
}
