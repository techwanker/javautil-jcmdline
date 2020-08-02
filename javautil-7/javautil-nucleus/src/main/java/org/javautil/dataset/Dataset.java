package org.javautil.dataset;

import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * A DataSet is conceptually a two dimensional in memory table. 
 * 
 * This should not be confused with a JDBC ResulSet, however we frequently encapsulate the
 * results of a ResultSet in a DataSet and release the cursor. This disposes of
 * resources and allows the DataSet to be passed around.
 * 
 * Think of it as the contents of a spreadsheet where all of the objects in a
 * given column are of the same type. A DataSet may be used to store the results
 * of a SQL Query to be passed around after the query has been closed and the
 * connection returned to the connection pool.
 * 
 * Although a DataSet is a simple repository of data, significant
 * functionality is provided by classes that use this data and the metadata.
 * 
 * Dataset columns are scalar values of 
 * 
 *   <ul>
 *     <li>String</li>
 *     <li>Number</li>
 *     <li>Date</li>
 *  <ul>
 *  
 * Numbers 
 * 
 *     
 * 
 * The metadata for a DataSet provides for rendering information. 
 * 
 * @see DatasetMetadata.
 * 
 * @author jjs
 * 
 *         TODO needs positional getRow()
 * 
 *         TODO needs getById()
 * 
 */
public interface Dataset {

	/**
	 * No further rows will be retrieved from the underlying data source. Any open
	 * resources should be closed or released.
	 * 
	 * @throws DatasetException TODO
	 */
    void close() throws DatasetException;

	/**
	 * Returns an iterator positioned before the first row of data with every call.
	 * 
	 * @return DatasetIterator The dataset iterator
	 */
    DatasetIterator<?> getDatasetIterator();

	/**
	 * @return DatasetMetadata The DatasetMetadata
	 */
    DatasetMetadata getMetadata();

	/**
	 * @return the name of the Dataset
	 */
    String getName();

	/**
	 * Set the name of the Dataset.
	 * 
	 * @param _name the name of the Dataset
	 */
    void setName(String _name);

	Collection<String> getColumnNames();

	List<Object> getRowAsList(int rowIndex);

	Map<String,Object> getRowAsMap(int rowIhdex);

	int getRowCount();

	Object getValue(final int rowIndex, final int columnIndex);

	Object getValue(final int rowIndex, String columnName);
}
