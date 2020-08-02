package org.javautil.document.renderer;

import org.javautil.dataset.Dataset;
import org.javautil.document.MimeType;

import javax.xml.transform.stream.StreamResult;

/**
 * 
 * @author jjs
 */
public interface RendererRequest {

	MimeType getMimeType();

	void setMimeType(final MimeType mimeType);
    // TODO make output Stream
    StreamResult getStreamResult();

	void setStreamResult(StreamResult sr);

	Dataset getDataset();

	/**
	 * 
	 * @param DateFormat a String compatible with SimpleDateFormat
	 */
    void setDateFormat(String DateFormat);

	/**
	 * A String compatible with SimpleDateFormat
	 * 
	 * @return the SimpleDateFormat string
	 */
    String getDateFormat();

}
