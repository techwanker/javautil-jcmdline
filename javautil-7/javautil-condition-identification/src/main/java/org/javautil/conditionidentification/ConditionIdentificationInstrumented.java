package org.javautil.conditionidentification;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.javautil.core.misc.Timer;
import org.javautil.core.sql.Binds;
import org.javautil.core.sql.Dialect;
import org.javautil.core.sql.SqlStatement;
import org.javautil.joblog.persistence.JoblogPersistence;
import org.javautil.util.NameValue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.yaml.snakeyaml.Yaml;

/**
 * Runs a series of sql statements that return as the first column, the primary
 * key of a table being examined an 0 or more fields used in formatting a
 * message.
 * 
 */
public class ConditionIdentificationInstrumented
{
	private final Logger                       logger = LoggerFactory.getLogger(this.getClass());

	private List<Map<String, Object>>          rules;

	private List<ConditionRule>                conditionRules;

	private Connection                         connection;

	private ConditionIdentificationPersistence persister;

	private ArrayList<String>                  messages;


	private int                                verbosity;

	private JoblogPersistence joblog;

	private String jobToken;

	public ConditionIdentificationInstrumented(Connection conn, JoblogPersistence joblog, List<Map<String, Object>> rules, boolean verbose, Dialect dialect,
			int verbosity) throws FileNotFoundException, SQLException {
		this.rules = rules;
		this.joblog = joblog;
		initialize(conn, verbose, dialect, verbosity);

	}

	public ConditionIdentificationInstrumented(Connection conn, JoblogPersistence joblog, String yamlRuleFileName, boolean verbose, Dialect dialect,
			int verbosity) throws FileNotFoundException, SQLException {
		this.joblog = joblog;
		FileInputStream fis = new FileInputStream(yamlRuleFileName);
		BufferedInputStream bis = new BufferedInputStream(fis);
		loadRules(bis);
		initialize(conn, verbose, dialect, verbosity);
	}

	public ConditionIdentificationInstrumented(Connection conn, JoblogPersistence joblog, InputStream yamlRules, boolean verbose, Dialect dialect,
			int verbosity) throws FileNotFoundException, SQLException {
		this.joblog = joblog;
		loadRules(yamlRules);
		initialize(conn, verbose, dialect, verbosity);
	}

	public void initialize(Connection conn, boolean verbose, Dialect dialect, int verbosity) throws SQLException {
		jobToken = joblog.joblogInsert("ConditionIdentification", getClass().getName(), "ConditionIdentification", null);
		this.connection = conn;

		this.verbosity = verbosity;
		logger.info("======   Condition Identification initialize dialect is " + dialect);
		persister = new ConditionIdentificationPersistence(conn, true, 1);

		conditionRules = new ArrayList<ConditionRule>();
		for (Map<String, Object> ruleMap : rules) {
			ConditionRule rule = new ConditionRule(ruleMap);
			conditionRules.add(rule);
		}
	}

	@SuppressWarnings("unchecked")
	private void loadRules(InputStream is) throws FileNotFoundException {
		Yaml yaml = new Yaml();
		rules = (List<Map<String, Object>>) yaml.load(is);
	}

	/**
	 * A row is inserted into ut_condition_run TODO get to work in sphinx The bind
	 * variables are inserted into ut_condition_run_parm for each rule The rule is
	 * retrieved from ut_condition and created if necessary. For each row returned a
	 * row is inserted into ut_condition_row_msg A row is inserted into
	 * ut_condition_run_step
	 * 
	 * @param binds     for the sql statements
	 * @param verbosity message level
	 * @return the generated messages
	 * @throws SQLException Unlikely
	 */
	public List<String> process(Binds binds, int verbosity) throws SQLException {
		long processStepId = joblog.insertStep(jobToken, "Process Rule", getClass().getName(), binds.toString());
		Timer t = new Timer(getClass(), getClass().getName(), binds.toString());
		messages = new ArrayList<String>();
		long utConditionRunId = persister.startRun(binds); // # Record the start of the run

		for (ConditionRule rule : conditionRules) {
			long start_ts = System.nanoTime();
			long stepId = joblog.insertStep(jobToken, "Process Rule", getClass().getName(), rule.getRuleName() + " " + binds.toString()); 
			try { 
				long run_step_id = persister.utConditionRunStepInsert(utConditionRunId, start_ts, rule);
				processRule(run_step_id, rule, binds);
				joblog.finishStep(stepId);
			} catch (SQLException sqe) {
				joblog.abortStep(stepId, sqe, sqe.getMessage());
			}

		}
		t.logElapsed();

		joblog.finishStep(processStepId);
		return messages;

	}

	/**
	 * @param runStepId the run step number
	 * @param rule      the condition rule
	 * @param binds     sql bind variables
	 * @return number of rows
	 * @throws SQLException Unlikely
	 */
	int processRule(long runStepId, ConditionRule rule, Binds binds) throws SQLException {
		Timer t = new Timer(getClass(), "ConditionIdentification:processRule", rule.getRuleName() + " " + binds.toString());

		int rowCount = 0;
		Savepoint savepoint = connection.setSavepoint(rule.getRuleName());
		try {
			if (verbosity > 6) {
				logger.info("processing rule " + rule.getRuleName());
			}
			String conditionSql = rule.getSqlText();

			SqlStatement sh = new SqlStatement(conditionSql, connection);
			ResultSet rset = sh.executeQuery(binds);
			int columnCount = rset.getMetaData().getColumnCount();
			while (rset.next()) {
				rowCount++;

				Integer pk = rset.getInt(1);
				ArrayList<Object> argList = new ArrayList<Object>();
				for (int i = 1; i <= columnCount; i++) {
					argList.add(rset.getObject(i));
				}

				Object[] args = argList.toArray();
				String formattedString = null;

				try {
					formattedString = String.format(rule.getJavaFormat(), args);
				} catch (java.util.MissingFormatArgumentException e) {
					throw new java.util.MissingFormatArgumentException("rule '" + rule + "' " + args + " " + e.getMessage());
				}
				persister.utConditionRowMsgInsert(runStepId, pk, formattedString);
				if (verbosity > 5) {
					logger.info(formattedString);
				}
				messages.add(formattedString);

			}
			connection.releaseSavepoint(savepoint);
		} catch (SQLException sqe) {
			connection.rollback(savepoint);
			throw sqe;
		}
		logger.info("processed rule " + rule.getRuleName() + " rows: " + rowCount);
		return rowCount;
	}

}