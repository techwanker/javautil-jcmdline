package org.javautil.jdbc.metdata.renderer.jsonschema;

import org.javautil.jdbc.metadata.ForeignKeys;
import org.javautil.jdbc.metadata.Table;
// TODO looks l8ke a dupe of TableDTO
public class TableJSONSchema {

	private final String      tableName;
	private final String      tableType;
	private final String      remarks;
	private final ForeignKeys exportedKeys;
	private final ForeignKeys importedKeys;

	private TableJSONSchema(Table table) {
		this.tableName = table.getTableName();
		this.tableType = table.getTableType();
		this.remarks = table.getRemarks();
		this.exportedKeys = table.getExportedKeys();
		this.importedKeys = table.getImportedKeys();
	}

}
