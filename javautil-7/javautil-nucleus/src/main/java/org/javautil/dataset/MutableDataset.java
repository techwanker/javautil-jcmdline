package org.javautil.dataset;

import org.javautil.dataset.filter.MutableDatasetFilter;
import org.javautil.dataset.math.CollectionMathOperation;

import java.util.ArrayList;

public interface MutableDataset extends Dataset {

	void addColumn(ColumnMetadata columnMeta);

	// todo resolve if we want this, I believe this should be handled by the
	// renderer
    void addFooter(int columnIndex, CollectionMathOperation footerMathOper);

	void appendToRow(Integer rownum, Object[] values);

	void applyFilters(MutableDatasetFilter... filters);

	void applySorts(SortColumn... sorts);

	void appendFooter();

	void appendToRow(Integer rownum, final ArrayList<Object> values);

	void appendRow(ArrayList<Object> list);

}
