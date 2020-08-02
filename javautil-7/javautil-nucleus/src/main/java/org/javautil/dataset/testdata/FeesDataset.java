package org.javautil.dataset.testdata;

import org.javautil.collections.ListHelper;
import org.javautil.dataset.*;

public class FeesDataset {
	private static final DatasetMetadataImpl deferredAdjudicationMeta = new DatasetMetadataImpl() {
		{
			addColumn(new ColumnMetadata().withColumnName("STATE")
					.withColumnIndex(0)
					.withDataType(DataType.STRING));
			addColumn(new ColumnMetadata().withColumnName("CITY")
					.withColumnIndex(1)
					.withDataType(DataType.STRING));
			addColumn(new ColumnMetadata().withColumnName("MONTH")
					.withColumnIndex(2)
					.withDataType(DataType.INTEGER));
			addColumn(new ColumnMetadata().withColumnName("Fine")
					.withColumnIndex(3)
					.withDataType(DataType.DOUBLE));
			addColumn(new ColumnMetadata()
					.withColumnName("Legal Fee").withColumnIndex(4)
					.withDataType(DataType.DOUBLE));

		}
	};

	private static final MatrixDataset       fees                     = new MatrixDataset(deferredAdjudicationMeta) {
		{
			addRow(
					ListHelper.toList("TX", "DALLAS", new Integer(1),
							new Double(311), new Double(380)));
			addRow(ListHelper.toList("TX", "DALLAS",
					new Integer(2), new Double(321), null));
			addRow(ListHelper.toList("TX", "HOUSTON",
					new Integer(1), new Double(312), new Double(0)));
			addRow(ListHelper.toList("TX", "Southlake",
					new Integer(3), new Double(333), null));

		}
	};

	public static MutableDataset getDataset() {
		return fees;
	}
}
