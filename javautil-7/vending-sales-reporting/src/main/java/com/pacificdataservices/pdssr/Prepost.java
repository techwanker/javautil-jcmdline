package com.pacificdataservices.pdssr;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;

import org.javautil.core.sql.Binds;
import org.javautil.core.sql.Dialect;
import org.javautil.core.sql.MappedResultSetIterator;
import org.javautil.core.sql.SqlStatement;
import org.javautil.core.sql.SqlStatementRunner;
import org.javautil.core.sql.SqlStatements;
import org.javautil.joblog.persistence.JoblogPersistence;
import org.javautil.util.ListOfNameValue;
import org.javautil.util.NameValue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Populates post_sale record from qualifying etl_sale records // // Updates the
 * 
 * etl_sale.product_id based on case_gtin // // Upserts product_nomen with
 * distributor identifier for authoritative manufacturer information // """
 * 
 * @author jjs TODO this was just copy paste of POST, clean up common
 */
public class Prepost {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	private Connection connection;

	private SqlStatements prepostQueries;
	private Dialect dialect;
	private int verbosity;
	private JoblogPersistence joblog;
	Prepost() {


	}

	public Prepost(Connection conn, JoblogPersistence joblog,  int verbosity) throws IOException, SQLException {
		this.connection = conn;
		this.dialect = Dialect.getDialect(conn);
		this.verbosity = verbosity;
		this.joblog = joblog;
		prepostQueries = loadDml();
	}

	// TODO isn't this in post?
	Date getEffectiveDate(long etlFileId) throws SQLException, InvalidLoadFileException {

		Date retval = null;
		String sql = "select file_create_dt from etl_sale_tot " + "where etl_file_id = :ETL_FILE_ID";
		SqlStatement ss = new SqlStatement(connection, sql);
		Binds binds = new Binds();
		binds.put("ETL_FILE_ID", etlFileId);
		// TODO get one row
		
		ListOfNameValue lonv = ss.getListOfNameValue(binds, true);
		if (lonv.size() == 1) {
			retval = (Date) lonv.get(0).get("file_create_dt");
		} else {
			throw new InvalidLoadFileException("load " + etlFileId + " has no etl_sale_tot");
		}
		MappedResultSetIterator it = ss.iterator(binds);
		// TODO should get use a get one method
		return retval;
	}

	public void process(long etlFileId) throws SQLException, InvalidLoadFileException {
		String jobToken = joblog.joblogInsert("Prepost", getClass().getName(), "Post");
		long stepId = joblog.insertStep(jobToken, "Prepost", getClass().getName(), null);
		logger.info("preposting processing etl_file_id " + etlFileId);
		Binds binds = new Binds();
		Date effectiveDate = getEffectiveDate(etlFileId);
		binds.put("EFF_DT", effectiveDate);
		binds.put("ETL_FILE_ID", etlFileId);

		SqlStatementRunner runner = new SqlStatementRunner(connection, dialect, prepostQueries, verbosity);
		runner.process(binds);
		connection.commit();
		joblog.finishStep(stepId);
		joblog.endJob(jobToken);
	}

	// TODO every dialect is wired in could be externalized but that is just more
	// external coding
	// TODO could infer name
	// TODO
	SqlStatements loadDml() throws IOException {
		String path = null;
		String qpath = null;
		path = "com/pacificdataservices/pdssr/prepost_dml.yaml";

		InputStream is = getClass().getResourceAsStream("prepost_dml.yaml");
		prepostQueries = new SqlStatements(is, connection);
		return prepostQueries;
	}

}
