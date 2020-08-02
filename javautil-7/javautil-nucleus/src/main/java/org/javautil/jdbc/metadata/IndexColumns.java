package org.javautil.jdbc.metadata;

import java.util.List;

public interface IndexColumns {

	List<IndexColumn> getIndexColumns();

	String getTableName();

	String getSchemaName();

	boolean isUnique();

	// public List<IndexColumn> getInfoList();
}