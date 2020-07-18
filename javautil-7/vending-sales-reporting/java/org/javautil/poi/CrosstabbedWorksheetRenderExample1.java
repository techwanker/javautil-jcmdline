package org.javautil.poi;

import java.awt.Color;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Collection;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.javautil.dataset.ColumnMetadata;
import org.javautil.dataset.Dataset;
import org.javautil.dataset.DatasetMetadata;
import org.javautil.document.style.ColorUtil;
import org.javautil.document.style.Style;
import org.javautil.document.style.StyleImpl;
import org.javautil.poi.sheet.CrosstabbedWorksheetRenderer;
import org.javautil.poi.style.HSSFCellStyleFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CrosstabbedWorksheetRenderExample1 {

	private final Logger logger = LoggerFactory.getLogger(getClass());

	//
	protected void initializeStyles(final HSSFCellStyleFactory styleFactory) {

		final Color c = ColorUtil.parseColor("#6996AD");
		final Color c1 = ColorUtil.parseColor("#FFFFFF");
		final Style headingStyle = new StyleImpl();
		headingStyle.setBackgroundColor(c);
		headingStyle.setFontColor(c1);
		styleFactory.setBaseHeaderStyle(headingStyle);

		styleFactory.setBaseDataStyle(new StyleImpl());
		styleFactory.setBaseFooterStyle(new StyleImpl());

	}

	//
	// @Ignore
	// @Test
	// public void test1() throws IOException {
	// CrosstabDataset datasetCrosstabbed = new CrosstabDataset();
	// Dataset ds = datasetCrosstabbed.getCrosstabbedDataset();
	// if (logger.isDebugEnabled()) {
	// DatasetMetadata dm = ds.getMetadata();
	// logger.debug(dm);
	// // todo not properly marshalling crosstabbed info
	// //DatasetCSVMetadataMarshaller.write(ds, System.out, System.out);
	// }
	// List<String> rowIdentifyingColumns =
	// datasetCrosstabbed.getRowIdentifyingColumns();
	// String columnIdentifyColumns =
	// datasetCrosstabbed.getColumnIdentifyingColumns();
	//
	// HSSFWorkbook workbook = new HSSFWorkbook();
	// HSSFSheet sheet = workbook.createSheet();
	// HSSFCellStyleFactory styleFactory = new HSSFCellStyleFactory(workbook);
	// initializeStyles(styleFactory);
	//
	// CrosstabbedWorksheetRenderer crosstabSheet = new
	// CrosstabbedWorksheetRenderer(sheet, styleFactory);
	// Collection<ColumnMetadata> columnMeta =
	// ds.getMetadata().getColumnMetadata();
	// // List<String> nonRowIdentifyingColumns = new ArrayList<String>();
	// // nonRowIdentifyingColumns.add(columnIdentifyColumns);
	// List<String> cellColumns = datasetCrosstabbed.getCellColumnNames();
	//
	// int startingRow = 0;
	// int startingColumn = 0;
	// crosstabSheet.emitCrosstabRegion(ds, startingRow,
	// startingColumn, rowIdentifyingColumns,
	// cellColumns,
	// // nonRowIdentifyingColumns,
	// columnMeta);
	// File actualFile = File.createTempFile("Crosstab", ".xls");
	//
	// OutputStream os = new FileOutputStream(actualFile);
	//
	// workbook.write(os);
	// os.close();
	// FileInputStream actual = new FileInputStream(actualFile);
	// FileInputStream expected = new
	// FileInputStream("src/test/data/org/javautil/poi/CrosstabbedWorksheetTest1.xls");
	// InputStreamComparator isc = new InputStreamComparator();
	// int result = isc.compare(actual,expected);
	// actual.close();
	// expected.close();
	// actualFile.delete();
	// assertEquals(0,result);
	//
	//
	// }
	//

	File getOutputFile(final String filename) {
		final String directory = "target/generated-data";
		final File f = new File(directory);
		f.mkdirs();
		final String outputFileName = directory + "/" + filename;
		return new File(outputFileName);

	}

	// TODO this is cut and paste from test1 strip out common code
	// @Test
	public void test2() throws IOException {
		// get a crosstabbed dataset
		final CrosstabDataset datasetCrosstabbed = new CrosstabDataset();
		final Dataset ds = datasetCrosstabbed.getCrosstabbedDataset();
		if (logger.isDebugEnabled()) {
			final DatasetMetadata dm = ds.getMetadata();
			// logger.debug(dm);
			// TODO not properly marshalling crosstabbed info
			// DatasetCSVMetadataMarshaller.write(ds, System.out, System.out);
		}
		//
		final List<String> rowIdentifyingColumns = datasetCrosstabbed.getRowIdentifyingColumns();
		datasetCrosstabbed.getColumnIdentifyingColumns();
		//
		final HSSFWorkbook workbook = new HSSFWorkbook();
		final HSSFSheet sheet = workbook.createSheet();
		final HSSFCellStyleFactory styleFactory = new HSSFCellStyleFactory(workbook);
		initializeStyles(styleFactory);

		final CrosstabbedWorksheetRenderer crosstabSheet = new CrosstabbedWorksheetRenderer(sheet, styleFactory);
		final Collection<ColumnMetadata> columnMeta = ds.getMetadata().getColumnMetadata();

		final List<String> cellColumns = datasetCrosstabbed.getCellColumnNames();

		final int startingRow = 0;
		final int startingColumn = 0;
		crosstabSheet.setSingleCellCrosstabColumnHeading(false); // the only
																	// difference
		crosstabSheet.emitCrosstabRegion(ds, startingRow, startingColumn, rowIdentifyingColumns, cellColumns,
				// nonRowIdentifyingColumns,
				columnMeta);

		// File actualFile = File.createTempFile("Crosstab", ".xls");
		final File actualFile = getOutputFile("Crosstab.xls");
		logger.debug("created temporary file " + actualFile.getAbsolutePath());
		final OutputStream os = new FileOutputStream(actualFile);

		workbook.write(os);
		os.close();
		// FileInputStream actual = new FileInputStream(actualFile);
		// FileInputStream expected = new
		// FileInputStream("src/test/data/org/javautil/poi/CrosstabbedWorksheetTest2.xls");
		// InputStreamComparator isc = new InputStreamComparator();
		// int result = isc.compare(actual,expected);
		// actual.close();
		// expected.close();
		// actualFile.delete();
		// assertEquals(0,result);

	}

	// TODO this is cut and paste from test1 strip out common code
	// TODO make this a separate example
	// @Test
	// public void testCrosstabbedFormulas() throws IOException {
	// // get a crosstabbed dataset
	// SalesDataset datasetCrosstabbed = new SalesDataset();
	// Dataset ds = datasetCrosstabbed.getCrosstabbedDataset();
	// // if (logger.isDebugEnabled()) {
	// // DatasetMetadata dm = ds.getMetadata();
	// // logger.debug(dm);
	// // // todo not properly marshalling crosstabbed info
	// // DatasetCSVMetadataMarshaller.write(ds, System.out, System.out);
	// // }
	// //
	// List<String> rowIdentifyingColumns =
	// datasetCrosstabbed.getRowIdentifyingColumns();
	// String columnIdentifyColumns =
	// datasetCrosstabbed.getColumnIdentifyingColumns();
	// //
	// HSSFWorkbook workbook = new HSSFWorkbook();
	// HSSFSheet sheet = workbook.createSheet();
	// HSSFCellStyleFactory styleFactory = new HSSFCellStyleFactory(workbook);
	// initializeStyles(styleFactory);
	// //
	//
	// CrosstabbedWorksheetHelper crosstabSheet = new
	// CrosstabbedWorksheetHelper(sheet, styleFactory);
	// Collection<ColumnMetadata> columnMeta =
	// datasetCrosstabbed.getColumnMetadata();
	// //
	// List<String> cellColumns = datasetCrosstabbed.getCellColumnNames();
	//
	// int startingRow = 0;
	// int startingColumn = 0;
	// crosstabSheet.setSingleCellCrosstabColumnHeading(false); // the only
	// difference
	// crosstabSheet.emitCrosstabRegion(ds, startingRow,
	// startingColumn, rowIdentifyingColumns,
	// datasetCrosstabbed.getRenderCellColumnNames(),
	// //cellColumns,
	// columnMeta);
	// File actualFile = File.createTempFile("Crosstab", ".xls");
	// logger.debug("created temporary file " + actualFile.getAbsolutePath());
	// OutputStream os = new FileOutputStream(actualFile);
	//
	// workbook.write(os);
	// os.close();
	// FileInputStream actual = new FileInputStream(actualFile);
	// FileInputStream expected = new
	// FileInputStream("src/test/data/org/javautil/poi/testCrosstabbedFormulas1.xls");
	// InputStreamComparator isc = new InputStreamComparator();
	// int result = isc.compare(actual,expected);
	// actual.close();
	// expected.close();
	// // actualFile.delete();
	// assertEquals(0,result);
	//
	//
	// }

	// TODO need a test that has multiple cell values for a crosstab
}
