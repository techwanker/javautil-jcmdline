package org.javautil.dataset;

import java.util.Date;
import java.util.List;
import java.util.Map;

/*
 * All of the get... methods that take an index reference columns relative to 0.
 * 
 * @author jjs
 * 
 *         TODO document
 * 
 */
public interface DatasetIterator<T> {

	DatasetMetadata getDatasetMetadata();

	/*
	 * Retrieves the value of the designated column (index, relative 0) in the
	 * current row of this DatasetIterator object as a java.util.Date object in the
	 * Java programming language.
	 **/
    Date getDate(int column) throws DatasetException;

	/**
	 * Retrieves the value of the designated column, by name, in the current row of
	 * this DatasetIterator object as a java.util.Date.
	 * 
	 * If the column occurs more than once as in a crosstabbed dataset, this throws
	 * a DatasetException.
	 * 
	 * @param columnName - the name of the column
	 * @return the column value
	 * @throws DatasetException Sometimes -
	 **/
    Date getDate(String columnName) throws DatasetException;

	/*
	 * Retrieves the value of the designated column (index, relative 0) in the
	 * current row of this DatasetIterator object as a java.lang.Double.
	 */
    Double getDouble(int column) throws DatasetException;

	/*
	 * Retrieves the value of the designated column, by name, in the current row of
	 * this DatasetIterator object as a java.lang.Double.
	 * 
	 * If the column occurs more than once as in a crosstabbed dataset, this throws
	 * an exception.
	 */
    Double getDouble(String column) throws DatasetException;

	/*
	 * Retrieves the value of the designated column (index, relative 0) in the
	 * current row of this DatasetIterator object as a java.lang.Integer.
	 */
    Integer getInteger(int column) throws DatasetException;

	/*
	 * Retrieves the value of the designated column, by name, in the current row of
	 * this DatasetIterator object as a java.lang.Integer.
	 * 
	 * If the column occurs more than once as in a crosstabbed dataset, this throws
	 * an exception.
	 */
    Integer getInteger(String column) throws DatasetException;

	Number getNumber(int columnIndex) throws DatasetException;

	/*
	 * Retrieves the value of the designated column, by name, in the current row of
	 * this DatasetIterator object as a class that implements java.lang.Number.
	 * 
	 * If the column occurs more than once as in a crosstabbed dataset, this throws
	 * an exception.
	 */
    Number getNumber(String column) throws DatasetException;

	T getObject(int columnIndex) throws DatasetException;

	T getObject(String column) throws DatasetException;

	List<T> getRowAsList() throws DatasetException;

	Map<String, Object> getRowAsMap() throws DatasetException;

	/*
	 * Retrieves the value of the designated column (index, relative 0) in the
	 * current row of this DatasetIterator object as a java.util.String object in
	 * the Java programming language.
	 */
    String getString(int column) throws DatasetException;

	/*
	 * Retrieves the value of the designated column, by name, in the current row of
	 * this DatasetIterator object as a java.lang.String.
	 * 
	 * If the column occurs more than once as in a crosstabbed dataset, this throws
	 * an exception.
	 */
    String getString(String column) throws DatasetException;

	Date getTimestamp(int column) throws DatasetException;

	/*
	 * Retrieves the value of the designated column, by name, in the current row of
	 * this DatasetIterator object as a java.util.Date.
	 * 
	 * If the column occurs more than once as in a crosstabbed dataset, this throws
	 * an exception.
	 */
    Date getTimestamp(String column) throws DatasetException;

	boolean hasNext() throws DatasetException;

	boolean next() throws DatasetException;

	int getRowCount() throws DatasetException;

}
