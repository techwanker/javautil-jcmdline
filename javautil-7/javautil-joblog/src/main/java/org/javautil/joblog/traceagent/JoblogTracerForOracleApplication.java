package org.javautil.joblog.traceagent;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.javautil.core.sql.SequenceHelper;
import org.javautil.core.sql.SqlSplitterException;
import org.javautil.oracle.OracleConnectionHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JoblogTracerForOracleApplication implements JoblogTracer {

	protected Logger logger = LoggerFactory.getLogger(getClass());

	protected List<CallableStatement> callableStatements = new ArrayList<>();
	private CallableStatement beginJobStatement;
	protected CallableStatement prepareConnectionStatement;
	protected CallableStatement setActionStatement;
	private CallableStatement setModuleStatement;
	private CallableStatement getTraceFileStatement;
	private CallableStatement getMyTraceFileStatement;
	private CallableStatement openFileStatement;
	private CallableStatement pushStepStatement;
	private CallableStatement setTraceStepStatement;
	private CallableStatement setTracefileIdentifierStatement;
	private SequenceHelper sh;
	private CallableStatement updateTracefileNameStatement;
	private Connection connection;
	private boolean throwExceptions = true;
	private SequenceHelper sequenceHelper;

	public JoblogTracerForOracleApplication(Connection connection) throws SQLException, SqlSplitterException, IOException {
		this.connection = connection;
	}

	CallableStatement prepareCall(String sql) throws SQLException {
		final CallableStatement retval = connection.prepareCall(sql);
		callableStatements.add(retval);
		return retval;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see org.javautil.dblogging.DatabaseInstrumentation#prepareConnection()
	 */
	@Override
	public void prepareConnection() throws SQLException {
		final String sql = "begin logger.prepare_connection; end;";
		if (prepareConnectionStatement == null) {
			prepareConnectionStatement = prepareCall(sql);
		}
		prepareConnectionStatement.execute();
		prepareConnectionStatement.close();
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * org.javautil.dblogging.DatabaseInstrumentation#beginJob(java.lang.String,
	 * java.lang.String, java.lang.String, java.lang.String, java.lang.String)
	 */

//    long appJobStart(String processName, String className, String moduleName, String statusMsg, String threadName,
//          String tracefileName, int traceLevel) throws SQLException;

	// String tracefileName = applicationLogger.appJobStart(processName, moduleName,
	// statusMsg, jobId, traceLevel);
	@Override
	public String jobStart(final String processName, String className, String moduleName, String statusMsg,
			long jobLogId, int traceLevel) throws SQLException {
//		
//		final String enableTrace = "begin sys.DBMS_MONITOR.session_trace_enable(waits=>TRUE, binds=>FALSE); end;";
//		final CallableStatement traceon = prepareCall(enableTrace);
//		traceon.execute();
		
		OracleConnectionHelper.enableTrace(connection, true, true);
		// TODO externalize
		final String sql = 
				  "begin\n" 
		        + "  :p_tracefile_name := logger.begin_java_job (\n"
				+ "    p_process_name => :p_process_name,  -- VARCHAR2,\n"
				+ "    p_classname    => :p_classname,    -- varchar2,\n"
				+ "    p_module_name  => :p_module_name,   -- varchar2,\n"
				+ "    p_status_msg   => :p_status_msg,    -- varchar2,\n"
				+ "    p_thread_name  => :p_thread_name,   -- varchar2,\n"
				+ "    p_job_log_id   => :p_job_log_id, \n" 
				+ "    p_trace_level  => :p_trace_level "
				+ "  );\n" 
				+ "end;\n" + "";

		if (beginJobStatement == null) {
			beginJobStatement = prepareCall(sql);
			beginJobStatement.registerOutParameter("p_tracefile_name", java.sql.Types.VARCHAR);
		}
		final CallableStatement cs = beginJobStatement;
		cs.setString("p_process_name", processName);
		cs.setString("p_classname", className);
		cs.setString("p_module_name", moduleName);
		cs.setString("p_status_msg", statusMsg);
		cs.setString("p_thread_name", Thread.currentThread().getName());
		cs.setLong("p_job_log_id", jobLogId);
		cs.setInt("p_trace_level", traceLevel);
		cs.execute();
		final String retval = cs.getString("p_tracefile_name");

		logger.info("started job {} " + retval);
		return retval;

	}

	@Override
	public Clob getMyTraceFile() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setAction(String actionName) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setModule(String moduleName, String actionName) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setTraceStep(String stepName, long jobStepId) throws SQLException {
		// TODO Auto-generated method stub
		
	}

//	/*
//	 * (non-Javadoc)
//	 *
//	 * @see
//	 * org.javautil.dblogging.DatabaseInstrumentation#setAction(java.lang.String)
//	 */
//	@Override
//	public void setAction(final String actionName) throws SQLException {
//		final String sql = "begin logger.set_action(p_action => :p_action_name); end;";
//		if (setActionStatement == null) {
//			setActionStatement = prepareCall(sql);
//		}
//		setActionStatement.setString("p_action_name", actionName);
//		setActionStatement.execute();
//
//	}
//
//	@Override
//	public void setTraceStep(final String stepName, long jobStepId) throws SQLException {
//		final String sql = "begin logger.trace_step(p_step_name => :p_step_name, p_job_step_id => :p_job_step_id); end;";
//		if (setTraceStepStatement == null) {
//			setTraceStepStatement = prepareCall(sql);
//		}
//		setTraceStepStatement.setString("p_step_name", stepName);
//		setTraceStepStatement.setLong("p_job_step_id", jobStepId);
//		setTraceStepStatement.execute();
//
//	}
//
//	/*
//	 * (non-Javadoc)
//	 *
//	 * @see
//	 * org.javautil.dblogging.DatabaseInstrumentation#setModule(java.lang.String,
//	 * java.lang.String)
//	 */
//	@Override
//	public void setModule(final String moduleName, final String actionName) throws SQLException {
//		final String sql = "begin \n" + "   logger.set_module(p_module_name => :p_module_name, \n"
//				+ "                        p_action_name => :p_action_name); \n" + "end;";
//
//		if (moduleName == null) {
//			throw new IllegalArgumentException("moduleName is null");
//		}
//		final String actionNameUsed = actionName == null ? " " : actionName;
//		if (setModuleStatement == null) {
//			setModuleStatement = prepareCall(sql);
//		}
//		setModuleStatement.setString("p_module_name", moduleName);
//		setModuleStatement.setString("p_action_name", actionNameUsed);
//		setModuleStatement.execute();
//	}
//
//	public void pushStep(final String stepName) throws SQLException {
//		final String sql = "begin logger.push_step(p_step_name => :p_step_name); end;";
//		if (stepName == null) {
//			throw new IllegalArgumentException("stepName is null");
//		}
//		if (pushStepStatement == null) {
//			pushStepStatement = prepareCall(sql);
//		}
//		pushStepStatement.setString("p_step_name", stepName);
//		setModuleStatement.execute();
//	}
//
//	/*
//	 * (non-Javadoc)
//	 *
//	 * @see org.javautil.dblogging.DatabaseInstrumentation#getTraceFileName()
//	 */
//	@Override
//	public String getTraceFileName() throws SQLException {
//		if (getTraceFileStatement == null) {
//			getTraceFileStatement = prepareCall("begin :trace_file_name := logger.get_my_tracefile_name(); end;");
//			getTraceFileStatement.registerOutParameter("trace_file_name", java.sql.Types.VARCHAR);
//		}
//		getTraceFileStatement.execute();
//		final String retval = getTraceFileStatement.getString("trace_file_name");
//		logger.info("tracefile: {}", retval);
//		return retval;
//	}
//
//	@Override
//	public String setTracefileIdentifier(long identifier) {
//		String retval = null;
//		try {
//			if (setTracefileIdentifierStatement == null) {
//				setTracefileIdentifierStatement = prepareCall(
//						"begin :trace_file_name := logger.set_tracefile_identifier(:p_identifier); end;");
//				setTracefileIdentifierStatement.registerOutParameter("trace_file_name", java.sql.Types.VARCHAR);
//			}
//
//			setTracefileIdentifierStatement.setLong("p_identifier", identifier);
//			setTracefileIdentifierStatement.execute();
//
//			retval = setTracefileIdentifierStatement.getString("trace_file_name");
//			return retval;
//		} catch (SQLException sqe) {
//			logger.error(sqe.getMessage());
//			if (throwExceptions) {
//				throw new RuntimeException(sqe);
//			}
//		}
//		return retval;
//	}
//
//	/*
//	 * (non-Javadoc)
//	 *
//	 * @see
//	 * org.javautil.dblogging.DatabaseInstrumentation#getMyTraceFile(java.io.File)
//	 */
//	@Override
//	public void getMyTraceFile(File file) throws IOException, SQLException {
//		final FileWriter fw = new FileWriter(file);
//		getMyTraceFile(fw);
//		fw.close();
//	}
//
//	@Override
//	public String openFile(String fileName) throws SQLException {
//		if (openFileStatement == null) {
//			openFileStatement = prepareCall(
//					"begin :log_file_name := logger.open_log_file(p_file_name => :p_file_name); end;");
//			openFileStatement.registerOutParameter("log_file_name", java.sql.Types.VARCHAR);
//		}
//		final Binds binds = new Binds();
//		binds.put("p_file_name", null);
//		openFileStatement.setString("p_file_name", null);
//		openFileStatement.execute();
//		final String retval = openFileStatement.getString("LOG_FILE_NAME");
//		return retval;
//	}
//
//	/*
//	 * (non-Javadoc)
//	 *
//	 * @see
//	 * org.javautil.dblogging.DatabaseInstrumentation#getMyTraceFile(java.io.Writer)
//	 */
//	@Override
//	public void getMyTraceFile(Writer writer) throws SQLException {
//		if (getMyTraceFileStatement == null) {
//			getMyTraceFileStatement = prepareCall("begin :my_tracefile_data := logger.get_my_tracefile(); end;");
//			getMyTraceFileStatement.registerOutParameter(1, java.sql.Types.CLOB);
//		}
//		getMyTraceFileStatement.execute();
//
//		final Clob clob = getMyTraceFileStatement.getClob(1);
//		try {
//			ConnectionHelper.clobWrite(clob, writer);
//		} catch (IOException e) {
//			logger.error("Unable to write trace file " + e.getMessage());
//		}
//	}
//
//	@Override
//	public Clob getMyTraceFile() throws SQLException {
//		if (getMyTraceFileStatement == null) {
//			getMyTraceFileStatement = prepareCall("begin :my_tracefile_data := logger.get_my_tracefile(); end;");
//			getMyTraceFileStatement.registerOutParameter(1, java.sql.Types.CLOB);
//		}
//		getMyTraceFileStatement.execute();
//		Clob retval = getMyTraceFileStatement.getClob(1);
//		if (retval == null) {
//			throw new IllegalStateException("null returned from logger.get_my_trace_file");
//		}
//		return getMyTraceFileStatement.getClob(1);
//
//	}
//
//	/*
//	 * (non-Javadoc)
//	 *
//	 * @see org.javautil.dblogging.DatabaseInstrumentation#dispose()
//	 */
//	@Override
//	public void dispose() throws SQLExchttps://news.google.com/topstories?hl=en-US&gl=US&ceid=US:eneption {
//		for (final CallableStatement cs : callableStatements) {
//			cs.close();
//		}
//		callableStatements = new ArrayList<>();
//	}
//
//	@Override
//	public void showConnectionInformation() {
//		// TODO Auto-generated method stub
//
//	}
//
//	@Override
//	public long getNextJobId() {
//		long retval = -1;
//		try {
//			retval = sequenceHelper.getSequence("job_id_seq");
//		} catch (SQLException e) {
//			logger.error(e.getMessage(), e);
//			if (throwExceptions) {
//				throw new RuntimeException(e);
//			}
//		}
//		return retval;
//	}

}
