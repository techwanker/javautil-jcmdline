package org.javautil.dataset;

import org.javautil.document.style.HorizontalAlignment;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 
 * @author jjs
 * 
 */
public interface DatasetMetadata {
	int getColumnCount() throws DatasetException;
	
	/**
	 * 
	 * @param columnName  Name of the column, case sensitive
	 * @return the index, relative zero of the specified column name
	 */
	Integer getColumnIndex(String columnName);

	/**
	 * columnIndex is relative 0 as in everything sane in java not 1 as in jdbc
	 * 
	 * @param columnIndex the index of the column relative 0
	 * @return the column metadata
	 */
    ColumnMetadata getColumnMetaData(int columnIndex);

	/**
	 * 
	 * @param index the column index
	 * @return the metadata associated with the column 
	 */
    ColumnMetadata getColumnMetaData(Integer index);

    /**
     * 
     * @param columnName The columnName 
     * @return the ColumnMetadata
     */
	ColumnMetadata getColumnMetaData(String columnName);

	ArrayList<ColumnMetadata> getColumnMetadata();

	LinkedHashMap<String, ColumnMetadata> getColumnMetadataMap();
	
	Map<String,Integer> getSqlTypeMap();
	/**
	 * Returns the name of the column at the specified index.
	 * 
	 * @param index the column index
	 * @return the column name
	 * @throws DatasetException Not likely
	 */
    String getColumnName(int index) throws DatasetException;

	DataType getColumnType(int index) throws DatasetException;

	MutableDatasetMetadata getMutable();

	/**
	 * Get the designated column's number of decimal digits.
	 * 
	 * Indexes are relative 0. This may return a null result. Get the designated
	 * column's number of decimal digits.
	 * 
	 * @param columnNumber the column index
	 * @return the precision
	 * @throws DatasetException Not likely
	 */
    Integer getPrecision(int columnNumber) throws DatasetException;

	Integer getScale(int columnNumber) throws DatasetException;

	/**
	 * @return the number of rows in the dataset.
	 * @throws DatasetException Possible.
	 */
    int getRowCount() throws DatasetException;

	HorizontalAlignment getAlignment(int index);

	/**
	 * Returns the ExcelFormat associated with the column at the specified index.
	 * 
	 * @param index column index
	 * @return The formula
	 */
    String getExcelFormat(int index);

	/**
	 * TODO what is this?
	 * 
	 * @param index column index
	 * @return The java format
	 */
    String getJavaFormat(int index);

	/**
	 * Return the indexes, relative 0 of columns with the specified name. More than
	 * one column may have the same name if this is a crosstabbed Dataset.
	 * 
	 * @param columnName the name of the column
	 * @return The column indexes
	 */
    Collection<Integer> getColumnIndexes(String columnName);

	int[] getColumnIndexes(String... columnNames);

	/*
	 * Returns the indexes of everyColumn except those indicated.
	 * 
	 * @param columnNames
	 * 
	 * @return
	 */
    int[] getNonColumnIndexes(String... columnNames);

	MutableDatasetMetadata getMetadataForColumns(String... columnNames);

	DatasetMetadata getMetadataForNonColumns(String... columnNames);

	/*
	 * @param meta
	 */
    void enhance(Map<String, ColumnMetadata> meta);

	String getColumnTypeName(int columnNumber);

	ArrayList<String> getColumnNames();
	Integer getColumnDisplaySize(int columnNumber) throws DatasetException;
	
}

