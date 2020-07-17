package org.javautil.joblog;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import org.javautil.containers.ListOfNameValue;
import org.javautil.containers.NameValue;
import org.javautil.sql.Binds;
import org.javautil.sql.SqlStatement;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class JoblogModels {

	private Connection connection;

	public JoblogModels(Connection connection) throws IOException, SQLException { 
		this.connection = connection;
	}

	public NameValue getJobInfo(String token) throws SQLException {
		String jobLogSql = "select * from job_log where job_token = :token";
		SqlStatement jobLogSS = new SqlStatement(connection, jobLogSql);
		Binds binds = new Binds();
		binds.put("token", token);
		NameValue retval;
		try {
			retval = jobLogSS.getNameValue(binds, true);
		} finally {
			jobLogSS.close();
		}
		return retval;
	}

	public ListOfNameValue getStepInfo(long jobId) throws SQLException {
		String stepVwSql = "select * from job_step_vw where job_log_id = :job_log_id order by job_step_id";
		SqlStatement stepVwSs = new SqlStatement(connection, stepVwSql);
		Binds binds = new Binds();
		binds.put("job_log_id", jobId);
		ListOfNameValue stepVwNameValue = stepVwSs.getListOfNameValue(binds);
		stepVwSs.close();
		return stepVwNameValue;
	}

	public NameValue getJobStepInfo(String token) throws SQLException {
		NameValue lhm = new NameValue();
		NameValue jobValues = getJobInfo(token);
		lhm.put("job", getJobInfo(token));
		long jobId = jobValues.getLong("job_log_id"); 
		ListOfNameValue stepInfo = getStepInfo(jobId);
		lhm.put("steps", stepInfo);
		return lhm;
	}
	
//	public static Map<String, Object> getJob(Connection logConnection, String token) throws SQLException {
//		
//		SqlStatement jobSS = null;
//		SqlStatement stepSS = null;
//		
//		try {
//			Binds binds = new Binds();
//			binds.put("token",token);
//		
//			jobSS = new SqlStatement(logConnection,"select * from log_job where job_token = :token");
//			
//			NameValue jobValues = jobSS.getNameValue(binds, true);
//			binds.put("job_id",jobValues.get("job_log_id"));
//			stepSS = new SqlStatement(logConnection,"select * from job_step where job_log_id = :job_id`");
//			ListOfNameValue stepValues = stepSS.getListOfNameValue(binds, true);
//			Map<String,Object> retval = new LinkedHashMap<String,Object>();
//			retval.put("job",jobValues);
//			retval.put("steps",stepValues);
//			return retval;
//			
//		}
//		finally {
//			jobSS.close();
//			stepSS.close();
//		}
//	}

	public String getJobStepInfoJson(String jobToken) throws SQLException {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		NameValue jobStepInfoNv = getJobStepInfo(jobToken);
		String json = gson.toJson(jobStepInfoNv);
		return json;
	}

}
