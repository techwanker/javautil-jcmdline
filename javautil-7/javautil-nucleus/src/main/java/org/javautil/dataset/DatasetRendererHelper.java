package org.javautil.dataset;

import org.javautil.document.renderer.CsvRenderer;
import org.javautil.document.renderer.CsvRendererRequest;
import org.javautil.document.renderer.CsvRendererRequestImpl;

import javax.xml.transform.stream.StreamResult;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * 
 * @author jjs@dbexperts.com
 * 
 *         TODO how many variants of this are there?
 * 
 */
public class DatasetRendererHelper {

	public static byte[] getCsvMarshalledDataset(final Dataset dataset, final String separator) throws IOException {
		final CsvRendererRequest crr = new CsvRendererRequestImpl();
		final ByteArrayOutputStream baos = new ByteArrayOutputStream();

		crr.setStreamResult(new StreamResult(baos));
		if (separator != null) {
			crr.setColumnSeparator(separator);
		}
		crr.setDataset(dataset);

		final CsvRenderer cr = new CsvRenderer();
		cr.setRequest(crr);
		cr.process();
		return baos.toByteArray();
	}

	public static String getDatasetAsCsvString(final Dataset dataset) throws IOException {
		final byte[] bytes = getCsvMarshalledDataset(dataset, ",");
		return bytes.toString();
	}

}
