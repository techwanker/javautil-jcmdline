package org.javautil.joblog.installer;

import java.io.IOException;
import java.sql.SQLException;

import org.javautil.sql.SqlSplitterException;

public interface JoblogSchemaCreator {

	void process() throws Exception, SqlSplitterException;

	JoblogSchemaCreator setDrop(boolean drop);

	JoblogSchemaCreator setNoFail(boolean noFail);

	JoblogSchemaCreator setShowSql(boolean showSql);



	boolean isDrop();

	void dropObjects() throws SQLException, SqlSplitterException, IOException;

	boolean isNoFail();

}