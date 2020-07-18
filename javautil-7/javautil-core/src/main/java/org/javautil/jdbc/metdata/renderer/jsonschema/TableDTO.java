package org.javautil.jdbc.metdata.renderer.jsonschema;

import org.javautil.jdbc.metadata.ForeignKeys;
import org.javautil.jdbc.metadata.Table;

@Deprecated
public class TableDTO {

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public String getTableType() {
		return tableType;
	}

	public void setTableType(String tableType) {
		this.tableType = tableType;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public ForeignKeys getExportedKeys() {
		return exportedKeys;
	}

	public void setExportedKeys(ForeignKeys exportedKeys) {
		this.exportedKeys = exportedKeys;
	}

	public ForeignKeys getImportedKeys() {
		return importedKeys;
	}

	public void setImportedKeys(ForeignKeys importedKeys) {
		this.importedKeys = importedKeys;
	}

	private String      tableName;
	private String      tableType;
	private String      remarks;
	private ForeignKeys exportedKeys;
	private ForeignKeys importedKeys;

	private TableDTO(Table table) {
		this.tableName = table.getTableName();
		this.tableType = table.getTableType();
		this.remarks = table.getRemarks();
		this.exportedKeys = table.getExportedKeys();
		this.importedKeys = table.getImportedKeys();
	}

}
