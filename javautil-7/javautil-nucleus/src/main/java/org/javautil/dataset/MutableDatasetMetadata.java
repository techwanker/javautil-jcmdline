package org.javautil.dataset;

import java.util.ArrayList;

/**
 * 
 * @author jjs@dbexperts.com
 * 
 */
public interface MutableDatasetMetadata extends DatasetMetadata {

	void addColumn(ColumnMetadata column);

	void addColumn(int index, ColumnMetadata column);

	@Override
    ArrayList<ColumnMetadata> getColumnMetadata();

}
