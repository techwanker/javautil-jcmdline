package org.javautil.dataset.testdata;

import org.javautil.core.collections.ListHelper;
import org.javautil.dataset.ColumnMetadata;
import org.javautil.dataset.DataType;
import org.javautil.dataset.DatasetMetadataImpl;
import org.javautil.dataset.MatrixDataset;
import org.javautil.dataset.MutableDataset;

/**
 * Nulls, nulls
 * 
 * @author jjs
 * 
 */

public class TrailingNullsDataset {
	private static final String        TX            = "TX";
	private static final String        DALLAS        = "DALLAS";

	private static DatasetMetadataImpl meta          = new DatasetMetadataImpl() {
																											{
																												// TODO dedupe
																												addColumn(new ColumnMetadata().withColumnName("STATE")
																												    .withColumnIndex(0).withDataType(DataType.STRING));
																												addColumn(new ColumnMetadata().withColumnName("CITY")
																												    .withColumnIndex(1).withDataType(DataType.STRING));
																												addColumn(new ColumnMetadata().withColumnName("MONTH")
																												    .withColumnIndex(2).withDataType(DataType.INTEGER));
																												addColumn(new ColumnMetadata().withColumnName("TICKETS")
																												    .withColumnIndex(3).withDataType(DataType.DOUBLE));
																												// addColumn(new ColumnMetadata("STATE", 0, DataType.STRING,
																												// null, null, null, null, null, null));
//			addColumn(new ColumnMetadata("CITY", 1, DataType.STRING, null, null, null, null, null, null));
//			addColumn(new ColumnMetadata("MONTH", 2, DataType.INTEGER, null, null, null, null, null, null));
//			addColumn(new ColumnMetadata("TICKETS", 3, DataType.DOUBLE, null, null, null, null, null, null));
																											}
																										};

	private static MatrixDataset       trailingNulls = new MatrixDataset(meta) {

																											{                                                                                                  // Number
																											                                                                                                   // n
																											                                                                                                   // =
																											                                                                                                   // null;
																												addRow(ListHelper.toList(TX, DALLAS, new Integer(1),
																												    new Double(42)));
																												addRow(ListHelper.toList(TX, DALLAS, new Integer(2), null));
																												addRow(ListHelper.toList(TX, "HOUSTON", null, null));
																												addRow(ListHelper.toList(TX, null, null, null));

																												addRow(ListHelper.toList(null, null, null, null));

																											}
																										};

	public static MutableDataset getDataset() {
		return trailingNulls;
	}

}
