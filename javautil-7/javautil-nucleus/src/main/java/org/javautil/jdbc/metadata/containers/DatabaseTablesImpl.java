package org.javautil.jdbc.metadata.containers;

import org.javautil.jdbc.metadata.Table;

import java.util.TreeMap;

public class DatabaseTablesImpl extends TreeMap<String, Table> implements DatabaseTables {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void addTable(final Table table) {
		put(table.getTableName(), table);
	}

}