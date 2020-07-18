package org.javautil.joblog.persistence;

import java.io.IOException;
import java.io.Reader;
import java.sql.CallableStatement;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.javautil.containers.NameValue;
import org.javautil.lang.ThreadUtil;
import org.javautil.sql.Binds;
import org.javautil.sql.Dialect;
import org.javautil.sql.NamedSqlStatements;
import org.javautil.sql.SequenceHelper;
import org.javautil.sql.SqlStatement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/*
create or replace view my_session_process as 
select 
s.SADDR, s.SID, s.SERIAL#, s.AUDSID , s.PADDR,
s.USER#, s.USERNAME, s.COMMAND, s.OWNERID, s.TADDR, 
s.LOCKWAIT, s.STATUS , s.SERVER , s.SCHEMA#, s.SCHEMANAME, 
s.OSUSER , s.PROCESS, s.MACHINE, s.PORT, s.TERMINAL, 
s.PROGRAM, s.TYPE, s.SQL_ADDRESS, s.SQL_HASH_VALUE, s.SQL_ID ,
s.SQL_CHILD_NUMBER, s.SQL_EXEC_START , s.SQL_EXEC_ID, 
s.PREV_SQL_ADDR, s.PREV_HASH_VALUE, s.PREV_SQL_ID, s.PREV_CHILD_NUMBER, s.PREV_EXEC_START, s.PREV_EXEC_ID, 
s.PLSQL_ENTRY_OBJECT_ID, s.PLSQL_ENTRY_SUBPROGRAM_ID, s.PLSQL_OBJECT_ID, s.PLSQL_SUBPROGRAM_ID, s.MODULE , 
s.MODULE_HASH, s.ACTION , s.ACTION_HASH, s.CLIENT_INFO, s.FIXED_TABLE_SEQUENCE,
s.ROW_WAIT_OBJ#, s.ROW_WAIT_FILE# , s.ROW_WAIT_BLOCK#, s.ROW_WAIT_ROW#, s.TOP_LEVEL_CALL#,
s.LOGON_TIME, s.LAST_CALL_ET, s.PDML_ENABLED, s.FAILOVER_TYPE, s.FAILOVER_METHOD,
s.FAILED_OVER, s.RESOURCE_CONSUMER_GROUP,
s.PDML_STATUS, s.PDDL_STATUS, s.PQ_STATUS, s.CURRENT_QUEUE_DURATION , s.CLIENT_IDENTIFIER, s.BLOCKING_SESSION_STATUS,
s.BLOCKING_INSTANCE, s.BLOCKING_SESSION, s.FINAL_BLOCKING_SESSION_STATUS, s.FINAL_BLOCKING_INSTANCE, s.FINAL_BLOCKING_SESSION ,
s.SEQ#, s.EVENT# , s.EVENT, s.P1TEXT , s.P1,
s.P1RAW, s.P2TEXT , s.P2, s.P2RAW, s.P3TEXT ,
s.P3, s.P3RAW, s.WAIT_CLASS_ID, s.WAIT_CLASS#, s.WAIT_CLASS,
s.WAIT_TIME, s.SECONDS_IN_WAIT, s.STATE, s.WAIT_TIME_MICRO, s.TIME_REMAINING_MICRO,
s.TIME_SINCE_LAST_WAIT_MICRO, s.SERVICE_NAME, s.SQL_TRACE, s.SQL_TRACE_WAITS, s.SQL_TRACE_BINDS,
s.SQL_TRACE_PLAN_STATS, s.SESSION_EDITION_ID, s.CREATOR_ADDR, s.CREATOR_SERIAL#, s.ECID,
s.SQL_TRANSLATION_PROFILE_ID, s.PGA_TUNABLE_MEM, s.SHARD_DDL_STATUS, s.CON_ID , s.EXTERNAL_NAME,
s.PLSQL_DEBUGGER_CONNECTED, p.PID, p.SOSID, p.SPID, p.STID,
p.EXECUTION_TYPE , p.PNAME, p.TRACEID, p.TRACEFILE, p.BACKGROUND,
p.LATCHWAIT, p.LATCHSPIN, p.PGA_USED_MEM, p.PGA_ALLOC_MEM, p.PGA_FREEABLE_MEM,
p.PGA_MAX_MEM, p.NUMA_DEFAULT, p.NUMA_CURR 
from    sys.v$session s, sys.v$process p
where s.audsid = userenv('sessionid') and
s.paddr = p.addr;
*/
// TODO these should all throw Dblogger exception, don't want
//  to blow up a job because of an error in the logger
public class JoblogPersistenceSql extends AbstractJoblogPersistence implements JoblogPersistence {

	private Logger logger = LoggerFactory.getLogger(JoblogPersistenceSql.class);

	SequenceHelper sequenceHelper;
	protected List<CallableStatement> callableStatements = new ArrayList<>();
	protected final Connection joblogConnection;
	private boolean isJoblogConnectionOracle = false;
	protected final Connection applicationConnection;
	protected NamedSqlStatements statements;
	//private long jobLogId = -1;
	private long jobStepId;
	private SqlStatement jobLogSelectSqlStatement2;
	
	private static transient final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH-mm-ss.SSS");
	private int verbosity = 1;

	private boolean throwExceptions;
	public JoblogPersistenceSql(Connection joblogConnection,
			Connection applogConnection) throws IOException, SQLException {
		this.joblogConnection = joblogConnection;
		this.applicationConnection = applogConnection;
		statements = NamedSqlStatements.getNameSqlStatementsFromSqlSplitterResource(this, "ddl/logjob_dml.ss.sql");
		sequenceHelper = new SequenceHelper(joblogConnection);
		isJoblogConnectionOracle = Dialect.getDialect(joblogConnection).equals(Dialect.ORACLE);
	//	isJoblogConnectionOracle = OracleConnectionHelper.isOracleConnection(joblogConnection) ;

	}

	CallableStatement prepareCall(String sql) throws SQLException {
		final CallableStatement retval = joblogConnection.prepareCall(sql);
		callableStatements.add(retval);
		return retval;
	}

	public void dispose() throws SQLException {
		statements.close();
	}

	String generateToken () {
		return sdf.format(new Date());

	}

	@Override
	public String joblogInsert(final String processName, 
			String className, String moduleName, String statusMsg 
			) throws SQLException {
		if (logger.isDebugEnabled()) {
			SqlStatement ss = new SqlStatement(joblogConnection,
					"select max(job_log_id) max_job_log_id, "
					+ "count(job_log_id) count_job_log_id from job_log");
			NameValue nv = ss.getNameValue();
			Integer max_job_log_id = nv.getInteger("max_job_log_id");
			Integer count_job_log_id = nv.getInteger("count_job_log_id");
			logger.debug("log_job_id max {}, count {}",max_job_log_id, count_job_log_id);
			ss.close();
		}
		SequenceHelper sh = new SequenceHelper(joblogConnection); // TOdo make class level
		long joblogId = sh.getSequence("JOB_LOG_ID_SEQ");
		
		String token = generateToken();
		SqlStatement ss = statements.getSqlStatement("job_log_insert");
		ss.setConnection(joblogConnection);
		Binds binds = new Binds();
		binds.put("job_log_id", joblogId,Types.INTEGER);
		binds.put("job_token",token,Types.VARCHAR);
		binds.put("process_name", processName,Types.VARCHAR);
		binds.put("classname", className,Types.VARCHAR);
		binds.put("module_name", moduleName,Types.VARCHAR);
		binds.put("status_msg", statusMsg,Types.VARCHAR);
		binds.put("thread_name", Thread.currentThread().getName());
		binds.put("start_ts", new java.sql.Timestamp(System.currentTimeMillis()));
		logger.debug("job_log_insert\n{}", ss.getSql());
		ss.executeUpdate(binds);
		joblogConnection.commit();
		if (logger.isDebugEnabled()) {
			logger.debug("started job {} ", joblogId);
			if (jobLogSelectSqlStatement2 == null) {
				jobLogSelectSqlStatement2 = new SqlStatement("select * from job_log where job_token = :job_token");
			}
			jobLogSelectSqlStatement2.setConnection(joblogConnection);
			Binds selBinds = new Binds();
			selBinds.put("job_token", token);
			NameValue nvs = jobLogSelectSqlStatement2.getNameValue(selBinds, true);
			logger.debug("persistJob select: {}", nvs.toString());
		}
		return token;
	}

	private void finishJob(String token, SqlStatement ss) throws SQLException {
		logger.debug("finishJob {} {}", token , ss.getSql());
		ss.setConnection(joblogConnection);
		Binds binds = new Binds();
		binds.put("job_token",token );
		binds.put("end_ts", new java.sql.Timestamp(System.currentTimeMillis()));
		int rowcount = ss.executeUpdate(binds);
		if (rowcount != 1) {
			logger.warn("job_log not updated for {}", token);
		} else {
			if (verbosity > 0) {
			logger.info("finishJob: {}", token);
			}
		}

		joblogConnection.commit();
	}

	public Binds getSessionInfo(Connection conn) throws SQLException {
		Binds binds;
		
		String sessionSql= "select * from my_session";
		SqlStatement ss = new SqlStatement(conn,sessionSql);
		NameValue  sessionValues = ss.getNameValue();
		ss.close();
		
		binds = new Binds(sessionValues);
		
		
		String sql = "SELECT VALUE FROM V$DIAG_INFO WHERE NAME = 'Default Trace File'";
		ss = new SqlStatement(conn,sql);
		NameValue nv = ss.getNameValue();
		ss.close();
		binds.put("tracefile_name", nv.get("value"));
        binds.put("serial_nbr",binds.get("serial#"));
		return binds;
	}


	@Override
	public long insertStep(String jobToken, String stepName, Class clazz, String stepInfo ) throws SQLException {
		long retval = -1;
		try {
			if (sequenceHelper == null) {
				throw new IllegalStateException("sequencehelper is null");
			}
			this.jobStepId = sequenceHelper.getSequence("job_step_id_seq");
			
			Binds binds;
			if (isJoblogConnectionOracle) {
				binds = getSessionInfo(applicationConnection);
			} else {
				binds = new Binds();
				binds.putNull("tracefile_name",Types.VARCHAR);
				binds.putNull("sid",Types.INTEGER);
				binds.putNull("serial_nbr",Types.INTEGER);
			}
			//
			SqlStatement ssJob = new SqlStatement(joblogConnection,
					"select * from job_log where job_token = :token");
			binds.put("token",jobToken);
			NameValue nvJob = null;
			try {
				nvJob = ssJob.getNameValue(binds,true);
			} catch (org.javautil.sql.DataNotFoundException e) {
				throw new IllegalArgumentException("no job_log found for " + jobToken);
			}
			//
			binds.put("job_step_id", jobStepId);
			binds.put("job_log_id", nvJob.get("job_log_id"));
			binds.put("step_name", stepName,Types.VARCHAR);
			binds.put("step_info", stepInfo, Types.VARCHAR);
			binds.put("classname", clazz.getName(),Types.VARCHAR);
			binds.put("start_ts", new java.sql.Timestamp(System.currentTimeMillis()));
			binds.putNull("stack_trace", Types.VARCHAR);
			binds.putType("module_name", Types.VARCHAR);
			binds.putNull("instance_name", Types.VARCHAR);
			if (statements == null) {
				throw new IllegalStateException("statements is null");
			}
			SqlStatement ss = statements.get("job_step_insert");
			ss.setConnection(joblogConnection);
			logger.debug("job_step_id: {}",binds.get("job_step_id"));
			//logger.debug("token: {}",binds.get("token"));
			ss.executeUpdate(binds);
			joblogConnection.commit(); // TODO should be autocommit on transaction or
			logger.debug("insertStep {} with binds {} " + stepName, binds);
			retval = jobStepId;
		} catch (SQLException sqe) {
			sqe.printStackTrace();
			logger.error(sqe.getMessage());
			throw sqe;
		}
		return retval;
	}

	@Override
	public void finishStep(long jobStepId) throws SQLException {
		Binds binds = new Binds();
		binds.put("job_step_id", jobStepId);
		binds.put("end_ts", new java.sql.Timestamp(System.currentTimeMillis()));
		SqlStatement ss = statements.get("end_step");
		ss.setConnection(joblogConnection);
		int rowCount = ss.executeUpdate(binds);
		if (rowCount != 1) {
			logger.error(String.format("finishStep stepId %d updated %d rows", jobStepId, rowCount));
		}
		joblogConnection.commit();
	}
	
//	// TODO move to core lang
//	public String formatStackTrace(StackTraceElement[] stackTraceElements) {
//		StringBuilder sb = new StringBuilder();
//		for (StackTraceElement ste : stackTraceElements)) {
//			sb.append(ste.toString());
//			sb.append("\n");
//		}
//	}
	@Override
	public void abortStep(long stepId, SQLException sqe, String message) throws SQLException {
		Binds binds = new Binds();
		binds.put("job_step_id", jobStepId);
		binds.put("end_ts", new java.sql.Timestamp(System.currentTimeMillis()));
		binds.put("exception_message",sqe.toString());
		String stackTrace = ThreadUtil.getStackTrace(3);
		binds.put("stack_trace", stackTrace);
		SqlStatement ss = statements.get("abort_step");
		ss.setConnection(joblogConnection);
		int rowCount = ss.executeUpdate(binds);
		if (rowCount != 1) {
			logger.error(String.format("abort stepId %d updated %d rows", jobStepId, rowCount));
		}
		joblogConnection.commit();
		
	}


	@Override
	public void abortJob(String token,Exception e) throws SQLException {
		finishJob(token,statements.getSqlStatement("abort_job"));
	}

	@Override
	public void endJob(String token) throws SQLException {

		finishJob(token,statements.getSqlStatement("end_job"));
	}


	public Connection getConnection() {
		return joblogConnection;
	}


	@Override
	public void persistenceUpdateTrace(long jobId, Clob traceClob) throws SQLException {
		if (traceClob == null) {
			throw new IllegalArgumentException("null traceClob");
		}
		Clob clob = joblogConnection.createClob();
		String upd = "update job_log " + "set tracefile_data =  ? " + "where job_log_id = ?";

		Reader traceReader = traceClob.getCharacterStream();

		PreparedStatement updateTraceFile = joblogConnection.prepareStatement(upd);

		updateTraceFile.setCharacterStream(1, traceReader);
		updateTraceFile.setLong(2, jobId);

		int rowcount = updateTraceFile.executeUpdate();

		if (rowcount != 1) {
			throw new IllegalArgumentException("unable to update job_log_id " + jobId);
		}

	}

	@Override
	public void ensureDatabaseObjects() throws SQLException {
	 logger.warn("Not implemented");	
	}

	public int getVerbosity() {
		return verbosity;
	}

	public void setVerbosity(int verbosity) {
		this.verbosity = verbosity;
	}

	
}
