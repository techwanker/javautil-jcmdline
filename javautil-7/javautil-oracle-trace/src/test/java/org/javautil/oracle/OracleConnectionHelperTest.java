package org.javautil.oracle;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.javautil.sql.Binds;
import org.javautil.sql.DataSourceFactory;
import org.javautil.sql.SqlStatement;
import org.javautil.oracle.trace.BaseTest;
import org.javautil.containers.ListOfNameValue;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class OracleConnectionHelperTest extends BaseTest{

	private transient Logger logger = LoggerFactory.getLogger(getClass());
	private DataSourceFactory dsf       = new DataSourceFactory();
	private DataSource        ds;
	private boolean           hasOracle = true;
	private Connection        conn;

	public OracleConnectionHelperTest() {

	}

	@Before
	public void before() {
		try {
			ds = dsf.getDatasource("integration");
			conn = ds.getConnection();
		} catch (Exception e) {
			logger.warn("oracle is not available skipping tests");
			logger.error("Oracle is not available " + e.getMessage());
			hasOracle = false;
		}
	}

	@After
	public void after() throws SQLException {
		if (conn != null) {
			conn.close();
		}
	}

	// TODO choose a file and select one in file system at runtime
	@Ignore
	@Test
	public void getTextFromRdbmsFile() throws SQLException, IOException {
		logger.info("hasOracle {}", hasOracle);
		if (hasOracle) {
			// create a trace file
			OracleConnectionHelper.enableTrace(conn, true, true);
			// my trace file name
			String filesSql = "SELECT VALUE trace_filename FROM V$DIAG_INFO WHERE NAME = 'Default Trace File'";
			SqlStatement ss = new SqlStatement(conn, filesSql);
			ListOfNameValue lonv = ss.getListOfNameValue(new Binds(), true);
			String traceFileName = lonv.get(0).getString("trace_filename");
			logger.info("gettting traceFile {}", traceFileName);
			//
			String text = OracleConnectionHelper.getTextFromRdbmsFile(conn, "UDUMP_DIR", traceFileName);
			assertNotNull(text);
			logger.info("text " + text);
		}
	}

	@Test
	public void getMyTraceFileNameTest() throws SQLException {
		if (hasOracle) {
			String retval = OracleConnectionHelper.getMyTraceFileName(conn);
			assertNotNull(retval);
		}
	}

	@Ignore
	@Test
	public void getMyTraceFile() throws SQLException, IOException {
		if (hasOracle) {
			OracleConnectionHelper.enableTrace(conn, true, false);
			String retval = OracleConnectionHelper.getMyTraceFile(conn);
			assertNotNull(retval);
		}
	}
	@Test
	public void traceFileSystemDirTest() throws SQLException {
		Connection conn = getAppConnection();
		String dirName = OracleConnectionHelper.getFileSystemDirectoryForTraceFiles(conn);
		assertNotNull(dirName);
		logger.warn("trace dir {}",dirName);
		File f = new File(dirName);
		assertTrue(f.exists());
	}
	
	public void dbmsTraceDir() throws SQLException {
		Connection conn = getAppConnection();
		 String dirName = OracleConnectionHelper.getDBMSDirectoryForTraceFiles(conn);
		 assertNotNull(dirName);
	}

}