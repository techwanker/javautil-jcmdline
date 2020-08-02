package org.javautil.document.renderer;

import org.javautil.dataset.ColumnMetadata;

import java.util.List;

public interface ReorderColumnsRendererRequest {

	List<String> getColumnOrder();

	List<ColumnMetadata> getColumnMetadata();

}
