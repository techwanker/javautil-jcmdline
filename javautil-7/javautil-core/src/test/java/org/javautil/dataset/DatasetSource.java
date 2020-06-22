package org.javautil.dataset;

import org.javautil.core.collections.ListHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DatasetSource {

	private final Logger logger = LoggerFactory.getLogger(getClass());

	/**
	 * getDataSet() method moved to this class and created within a method so that
	 * subsequent calls modify their own, unique, dataset
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static MutableDataset getDataset() {

		final DatasetMetadataImpl meta = new DatasetMetadataImpl() {
			{
				addColumn(new ColumnMetadata().withColumnName("STATE").withColumnIndex(0).withDataType(DataType.STRING));
				addColumn(new ColumnMetadata().withColumnName("CITY").withColumnIndex(1).withDataType(DataType.STRING));
				addColumn(new ColumnMetadata().withColumnName("MONTH").withColumnIndex(2).withDataType(DataType.INTEGER));
				addColumn(new ColumnMetadata().withColumnName("TICKETS").withColumnIndex(3).withDataType(DataType.DOUBLE));

				// addColumn(new ColumnMetadata("STATE", 0, DataType.STRING, null, null, null,
				// null, null, null));
//				addColumn(new ColumnMetadata("CITY", 1, DataType.STRING, null, null, null, null, null, null));
//				addColumn(new ColumnMetadata("MONTH", 2, DataType.INTEGER, null, null, null, null, null, null));
//				addColumn(new ColumnMetadata("TICKETS", 3, DataType.DOUBLE, null, null, null, null, null, null));
//			}
			};
		};

		final MatrixDataset matrixDataset = new MatrixDataset(meta) {
			{
				addRow(ListHelper.toList("TX", "DALLAS", new Integer(1), new Double(42)));
				addRow(ListHelper.toList("TX", "DALLAS", new Integer(2), new Double(32.2)));
				addRow(ListHelper.toList("TX", "DALLAS", new Integer(3), new Double(34.2)));
				addRow(ListHelper.toList("TX", "HOUSTON", new Integer(1), new Double(28)));
				addRow(ListHelper.toList("TX", "HOUSTON", null, null));
				addRow(ListHelper.toList("TX", "HOUSTON", new Integer(3), new Double(19)));
			};
		};
		return matrixDataset;
	}

	/**
	 * getDataSet() method moved to this class and created within a method so that
	 * subsequent calls modify their own, unique, dataset
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static MutableDataset getDupeFinesDataset() {

		final DatasetMetadataImpl meta = new DatasetMetadataImpl() {
			{
				addColumn(new ColumnMetadata().withColumnName("STATE").withColumnIndex(0).withDataType(DataType.STRING));
				addColumn(new ColumnMetadata().withColumnName("CITY").withColumnIndex(1).withDataType(DataType.STRING));
				addColumn(new ColumnMetadata().withColumnName("MONTH").withColumnIndex(2).withDataType(DataType.INTEGER));
				addColumn(new ColumnMetadata().withColumnName("FINES").withColumnIndex(3).withDataType(DataType.DOUBLE));
//				addColumn(new ColumnMetadata("STATE", 0, DataType.STRING, null, null, null, null, null, null));
//				addColumn(new ColumnMetadata("CITY", 1, DataType.STRING, null, null, null, null, null, null));
//				addColumn(new ColumnMetadata("MONTH", 2, DataType.INTEGER, null, null, null, null, null, null));
//				addColumn(new ColumnMetadata("FINES", 3, DataType.DOUBLE, null, null, null, null, null, null));
			}
		};

		final MatrixDataset matrixDataset = new MatrixDataset(meta) {
			{
				addRow(ListHelper.toList("TX", "DALLAS", new Integer(1), new Double(42)));
				addRow(ListHelper.toList("TX", "DALLAS", new Integer(2), new Double(32.2)));
				addRow(ListHelper.toList("TX", "DALLAS", new Integer(3), new Double(34.2)));
				addRow(ListHelper.toList("TX", "HOUSTON", new Integer(1), new Double(28)));
				addRow(ListHelper.toList("TX", "HOUSTON", null, null));
				addRow(ListHelper.toList("TX", "HOUSTON", new Integer(3), new Double(28)));
			}
		};

		return matrixDataset;
	}

}
