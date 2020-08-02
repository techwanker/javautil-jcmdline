package org.javautil.jdbc.metadata;

import java.util.Map;

public interface Index {
	String getSchemaName();

	String getTableName();

	String getIndexName();

	Map<Short, IndexColumn> getColumnsById();

	Map<String, IndexColumn> getColumnsByColumnName();

	IndexColumn getColumnById(Integer id);

	IndexColumn getByColumnName(String columnName);

	void addIndexColumn(IndexColumn indexColumn);
}
