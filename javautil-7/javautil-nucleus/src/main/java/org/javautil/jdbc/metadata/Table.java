package org.javautil.jdbc.metadata;

import org.javautil.sql.ColumnAttributes;

import java.sql.DatabaseMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public interface Table {

	String TABLE = "TABLE";

	int getIndexInfosMillis();

	int getImportedKeysMillis();

	void addColumn(Column column);

	ColumnAttributes getColumnAttributes(final String columnName);

	String getSQLColumnList();

	String getJavaColumnList();

	List<ColumnAttributes> getColumnAttributes();

	ForeignKeys getExportedKeys();

	ForeignKeys getExportedKeys(final DatabaseMetaData meta) throws SQLException;

	/**
	 * @return the exportedKeysDone
	 */
    long getExportedKeysDone();

	ForeignKeys getImportedKeys();

	ForeignKeys getImportedKeys(final DatabaseMetaData meta) throws SQLException;

	/**
	 * @return the importedKeysDone
	 */
    long getImportedKeysDone();

	// public abstract IndexColumns getIndexInfos(final Connection meta)
	// throws SQLException;

	/**
	 * @return the indexInfosDone
	 */
    long getIndexInfosDone();

	/**
	 * @return the metaDataColumnsDone
	 */
    long getMetaDataColumnsDone();

	/**
	 * @return the metaDataRetrieveStart
	 */
    long getMetaDataRetrieveStart();

	PrimaryKey getPrimaryKey();

	PrimaryKey getPrimaryKey(final DatabaseMetaData meta) throws SQLException;

	// public abstract List<ColumnAttributes> getPrimaryKeyColumns();

	// /**
	// * @return the primaryKeyDone
	// */
	// public abstract long getPrimaryKeyDone();

	/**
	 * @return the referencedBy
	 */
    ArrayList<ForeignKeyImpl> getReferencedBy();

	/**
	 * @return the references
	 */
    ArrayList<ForeignKeyImpl> getReferences();

	/**
	 * @return the remarks
	 */
    String getRemarks();

	/**
	 * @return the schemaName
	 */
    String getSchemaName();

	String getJavaSelectStatement();

	String getSelectStatement();

	// public abstract String[] getSelectStatementLines();

	String getTableName();

	// public abstract String getTableNameAsAttributeName();

	String getTableType();

	Iterator<ColumnAttributes> iterator();

	// public abstract void setColumns(final List<ColumnAttributes> columns);

	// public abstract void setColumns(final Collection<ColumnAttributes> columns);

	/**
	 * @param exportedKeys the exportedKeys to set
	 */
    void setExportedKeys(final ForeignKeys exportedKeys);

	/**
	 * @param importedKeys the importedKeys to set
	 */
    void setImportedKeys(final ForeignKeys importedKeys);

	/**
	 * @param primaryKey the primaryKey to set
	 */
    void setPrimaryKey(final PrimaryKey primaryKey);

	/**
	 * @param references the references to set
	 */
    void setReferences(final ArrayList<ForeignKeyImpl> references);

	/**
	 * @param remarks the remarks to set
	 */
    void setRemarks(final String remarks);

	int size();

	List<String> getColumnNames();

	String getInsertText();

	List<ColumnAttributes> getCommonColumns(Table other);

	/**
	 * Constructs a <code>String</code> with all attributes in name = value format.
	 * 
	 * @return a <code>String</code> representation of this object.
	 */
	@Override
    String toString();

	Map<String, Index> getIndexesByName();
	// public abstract DDL getDDL();

	List<ColumnAttributes> getColumnAttributesList();

	List<Column> getColumns();

}