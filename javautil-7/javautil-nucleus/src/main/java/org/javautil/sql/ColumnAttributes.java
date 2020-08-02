package org.javautil.sql;

/**
 * jjs from dbexperts
 */
public interface ColumnAttributes {

	String getAttributeName();

	String getColumnName();

	/**
	 * @return the columnSize
	 */
    Integer getColumnSize();

	/**
	 * The database-specific type name.
	 * 
	 * Populate from ResultSetMetaData.getColumnTypeName.
	 * 
	 * @return columnTypeName
	 */
    String getColumnTypeName();

	/**
	 * Domain is java.sql.Types Retrieves the designated column's SQL type.
	 * 
	 * Populated from ResultSetMetadata.getColumnType().
	 * 
	 * @return the ColumnType
	 */
    Integer getColumnType();

	String getComments();

	Boolean isNullable();

	/**
	 * Gets the designated column's number of digits to right of the decimal point.
	 * 0 is returned for data types where the scale is not applicable.
	 * 
	 * @return The scale
	 */
    Integer getScale();

	// public abstract Column setComments(String comments);
}