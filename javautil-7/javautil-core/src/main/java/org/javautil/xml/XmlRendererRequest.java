package org.javautil.xml;

import java.util.List;

import org.javautil.document.renderer.DatasetRendererRequest;

public interface XmlRendererRequest extends DatasetRendererRequest {

	void setResultSetId(String resultSetId);

	String getResultSetId();

	void setEmitColumnsAsElementText(boolean emitColumnsAsElementText);

	boolean isEmitColumnsAsElementText();

	void setEmitColumnsInLowerCase(boolean emitColumnsInLowerCase);

	boolean isEmitColumnsInLowerCase();

	List<String> getBreaks();

	void setBreaks(List<String> breaks);

}
