package org.javautil.dataset.csv;

import org.javautil.dataset.Dataset;
import org.javautil.document.renderer.CsvRenderer;
import org.javautil.document.renderer.CsvRendererRequest;
import org.javautil.document.renderer.CsvRendererRequestImpl;

import javax.xml.transform.stream.StreamResult;
import java.io.*;

/**
 * 
 * @author jjs@dbexperts.com
 * 
 */
public class DatasetCsvMarshaller {

	public static String toString(final Dataset ds) {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		try {
			write(ds, baos);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		return baos.toString();
	}

	public static void write(final Dataset ds, final OutputStream os) throws IOException {
		if (ds == null) {
			throw new IllegalArgumentException("ds is null");
		}
		if (os == null) {
			throw new IllegalArgumentException("os is null");
		}
		final CsvRendererRequest crr = new CsvRendererRequestImpl();
		final StreamResult sr = new StreamResult(os);

		crr.setStreamResult(sr);
		crr.setColumnSeparator(",");
		crr.setDataset(ds);
		crr.setDateFormat("YYYY-MM-DD");

		final CsvRenderer cr = new CsvRenderer();
		cr.setRequest(crr);
		cr.process();

	}

	public static void writeToFile(final Dataset ds, final File file) throws IOException {
		if (file == null) {
			throw new IllegalArgumentException("file is null");
		}
		final FileOutputStream fos = new FileOutputStream(file);
		write(ds, fos);
	}

	public static void writeToFileName(final Dataset ds, final String fileName) throws IOException {
		final FileOutputStream fos = new FileOutputStream(fileName);
		write(ds, fos);
	}

}
