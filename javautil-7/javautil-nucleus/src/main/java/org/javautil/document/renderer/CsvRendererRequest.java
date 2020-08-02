package org.javautil.document.renderer;

import org.javautil.dataset.Dataset;

/**
 * 
 * @author jjs@dbexperts.com
 * 
 */
public interface CsvRendererRequest extends DatasetRendererRequest {
	String getColumnSeparator();

	void setColumnSeparator(String val);

	@Override
    void setDataset(Dataset ds);

	boolean isEmitHeader();

	void setEmitHeader(boolean val);

	String getNewline();

	void setNewline(String newline);

	@Override
    void setDateFormat(String string);

	void setUseDefaultDateFormatForAllDates(boolean value);

	@Override
    String getDateFormat();

}
