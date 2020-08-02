package org.javautil.dataset.filter;

/**
 * 
 * 
 * 
 * TODO jjs review this
 * 
 */
public interface MutableDatasetFilter {
	String getColumnName();

	Object getColumnValue();

	boolean isInverseMatch();

	boolean isMatch(Object value);

	void setColumnName(String columnName);

	void setColumnValue(Object value);

	void setInverseMatch(boolean isInverse);
}
