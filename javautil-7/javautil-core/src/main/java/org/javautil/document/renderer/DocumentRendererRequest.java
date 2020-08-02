package org.javautil.document.renderer;

import java.io.IOException;
import java.text.SimpleDateFormat;

import javax.xml.transform.stream.StreamResult;

import org.javautil.dataset.render.typewriter.TypewriterContents;
import org.javautil.document.Document;

public interface DocumentRendererRequest {

	DocumentRenderStatus getStatus();

	TypewriterContents<?, ?> getContents();

	Document getDocument();

	StreamResult getStreamResult();

	void setStreamResult(StreamResult streamResult);

	void setDateFormatter(SimpleDateFormat dateFormatter);

	SimpleDateFormat getDateFormatter();

	void write() throws IOException;
}
