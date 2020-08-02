package org.javautil.jdbc.metadata.dto;

import org.javautil.jdbc.metadata.Column;
import org.javautil.jdbc.metadata.Table;
import org.javautil.json.JsonSerializerJackson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class JsonSchemaTable {

	private final String                 tableName;

	private final String                 remarks;
	private final List<JsonSchemaColumn> columns = new ArrayList<>();

	public JsonSchemaTable(Table table) {
		tableName = table.getTableName();
		remarks = table.getRemarks();
		Logger logger = LoggerFactory.getLogger(this.getClass().getName());
		logger.info("table {}", tableName);
		for (Column col : table.getColumns()) {
			logger.info("adding column {} to table {}", tableName, col.getColumnName());
			columns.add(new JsonSchemaColumn(col));
		}
		logger.info(toJson());
	}

	/**
	 * @return the tableName
	 */
	public String getTableName() {
		return tableName;
	}

	/**
	 * @return the remarks
	 */
	public String getRemarks() {
		return remarks;
	}

	public List<JsonSchemaColumn> getColumns() {
		return columns;
	}

	public String toJson() {
		JsonSerializerJackson dillon = new JsonSerializerJackson();
		return dillon.toJsonPretty(this);
	}

}