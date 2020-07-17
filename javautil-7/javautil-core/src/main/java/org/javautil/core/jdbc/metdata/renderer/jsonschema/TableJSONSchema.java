package org.javautil.core.jdbc.metdata.renderer.jsonschema;

import org.javautil.jdbc.metadata.ForeignKeys;
import org.javautil.jdbc.metadata.Table;
// TODO looks l8ke a dupe of TableDTO
public class TableJSONSchema {

	private String      tableName;
	private String      tableType;
	private String      remarks;
	private ForeignKeys exportedKeys;
	private ForeignKeys importedKeys;

	private TableJSONSchema(Table table) {
		this.tableName = table.getTableName();
		this.tableType = table.getTableType();
		this.remarks = table.getRemarks();
		this.exportedKeys = table.getExportedKeys();
		this.importedKeys = table.getImportedKeys();
	}

}
