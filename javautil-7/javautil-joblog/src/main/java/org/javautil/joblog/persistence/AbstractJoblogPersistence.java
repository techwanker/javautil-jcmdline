package org.javautil.joblog.persistence;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.Map;

import org.javautil.core.sql.Binds;
import org.javautil.core.sql.SequenceHelper;
import org.javautil.core.sql.SqlStatement;
import org.javautil.util.ListOfNameValue;
import org.javautil.util.NameValue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class AbstractJoblogPersistence  implements JoblogPersistence{

	private Logger logger  = LoggerFactory.getLogger(getClass());
	private boolean persistTraceOnJobCompletion;
	private boolean persistPlansOnJobCompletion;
	private SequenceHelper sequenceHelper;
	private boolean throwExceptions;
	private boolean persistPlans;
	//void setPersistPlansOnSQLExceptionJobCompletion(boolean persistPlans)o	void setPersistPlansOnSQLExceptionJobCompletion(boolean persistPlans);
	public AbstractJoblogPersistence() {
		super();
	}

	@Override
	public void setPersistTraceOnJobCompletion(boolean persistTrace) {
		this.persistTraceOnJobCompletion = persistTrace;
	}

	@Override
	public long insertStep(String jobToken, String stepName, Class clazz) throws SQLException {
		return insertStep(jobToken,stepName,clazz,null);

	}


	@Override
	public long insertStep(String jobToken, String stepName, Class clazz, String stepInfo) throws SQLException {
		return insertStep(jobToken,stepName,clazz,stepInfo);
	}
	@Override
	public void setPersistPlansOnJobCompletion(boolean persistPlans) {
		this.persistPlansOnJobCompletion = persistPlans;
	}

	@Override
	public long getNextJobLogId() {
		long retval = -1L;
		try {
			retval = sequenceHelper.getSequence("job_log_id_seq");
		} catch (SQLException e) {
			if (throwExceptions) {
				throw new RuntimeException(e);
			} else {
				logger.error(e.getMessage());
			}
		}
		return retval;
	}
	@Override
	public String joblogInsert(final String processName, String className, String moduleName 
			) throws SQLException {
		return joblogInsert(processName, className, moduleName,"");
	}

	@Override
	public void prepareConnection() throws SQLException {
		// TODO Auto-generated method s

	}

	@Override
	public void setModule(String module, String action) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void setAction(String string) {
		// TODO Auto-generated method stub

	}
	
	public static Map<String, Object> getJob(Connection logConnection, String token) throws SQLException {
		
		SqlStatement jobSS = null;
		SqlStatement stepSS = null;
		
		try {
			Binds binds = new Binds();
			binds.put("token",token);
		
			jobSS = new SqlStatement(logConnection,"select * from log_job where job_token = :token");
			
			NameValue jobValues = jobSS.getNameValue(binds, true);
			binds.put("job_id",jobValues.get("job_log_id"));
			stepSS = new SqlStatement(logConnection,"select * from job_step where job_log_id = :job_id`");
			ListOfNameValue stepValues = stepSS.getListOfNameValue(binds, true);
			Map<String,Object> retval = new LinkedHashMap<String,Object>();
			retval.put("job",jobValues);
			retval.put("steps",stepValues);
			return retval;
			
		}
		finally {
			jobSS.close();
			stepSS.close();
		}
	}



}