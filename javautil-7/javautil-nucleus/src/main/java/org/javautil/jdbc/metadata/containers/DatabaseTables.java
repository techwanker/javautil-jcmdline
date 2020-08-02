package org.javautil.jdbc.metadata.containers;

import org.javautil.jdbc.metadata.Table;

import java.util.Map;

public interface DatabaseTables extends Map<String, Table> {

	void addTable(final Table table);

	@Override
    String toString();

}