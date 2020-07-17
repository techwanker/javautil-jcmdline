
package org.javautil.dataset;

import java.util.List;

import org.javautil.text.StringBuilderHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DatasetDefinition {

	private transient final Logger logger          = LoggerFactory.getLogger(getClass());

	@SerializedName("name")
	@Expose
	private String                 name;
	@SerializedName("sql")
	@Expose
	private String                 sql;
	@SerializedName("datasourceName")
	@Expose
	private String                 datasourceName;
	@SerializedName("columns")
	@Expose
	private List<ColumnMetadata>           columns         = null;
	private CrosstabColumns        crosstabColumns = null;
	
	

	/**
	 * No args constructor for use in serialization
	 * 
	 */
	public DatasetDefinition() {
	}

	/**
	 * @param sql            The query
	 * @param name           worksheet name
	 * @param datasourceName name of the DataSource
	 * @param crosstabColumns the column names to be used for crosstabbing
	 * @param columns        column definitions
	 */
	public DatasetDefinition(String name, String sql, String datasourceName, List<ColumnMetadata> columns,
	    CrosstabColumns crosstabColumns) {
		super();
		this.name = name;
		this.sql = sql;
		this.datasourceName = datasourceName;
		this.columns = columns;
		this.crosstabColumns = crosstabColumns;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public DatasetDefinition withName(String name) {
		this.name = name;
		return this;
	}

	public String getSql() {
		return sql;
	}

	public void setSql(String sql) {
		this.sql = sql;
	}

	public DatasetDefinition withSql(String sql) {
		this.sql = sql;
		return this;
	}

	public List<ColumnMetadata> getColumns() {
		return columns;
	}

	public void setColumns (List<ColumnMetadata> columns) {
		this.columns = columns;
	}

	public DatasetDefinition withColumns(List<ColumnMetadata> columns) {
		this.columns = columns;
		return this;
	}

	public CrosstabColumns getCrosstabColumns() {
		return crosstabColumns;
	}

	public void setCrosstabColumns(CrosstabColumns crosstabColumns) {
		this.crosstabColumns = crosstabColumns;
	}

	public String getDatasourceName() {
		return datasourceName;
	}

//	@Override
//	public String toString() {
//		StringBuilderHelper sb = new StringBuilderHelper();
//		sb.addNameValue("name", name).addNameValue("sql", sql).addNameValue("connectionName", connectionName)
//		    .addNameValue("columns", columns);
//		String retval = sb.toString();
//		logger.info("toString:\n{}", retval);
//		return sb.toString();
//	}
}
