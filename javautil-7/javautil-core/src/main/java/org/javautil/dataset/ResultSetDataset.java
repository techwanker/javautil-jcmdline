package org.javautil.dataset;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * 
 * @author jjs@dbexperts.com
 * 
 */
public class ResultSetDataset extends AbstractDataset {

	private DatasetMetadata meta;

	private final ResultSet rset;

	private DatasetIterator rsetIter;

	public ResultSetDataset(final ResultSet _rset) {
		this.rset = _rset;
	}

	@Override
	public void close() throws DatasetException {
		try {
			rset.close();
		} catch (final SQLException e) {
			throw new DatasetException(e);
		}
	}

	@Override
	public DatasetIterator getDatasetIterator() {
		if (rsetIter == null) {
			rsetIter = new ResultSetIterator(this, rset);
		}
		return rsetIter;
	}

	@Override
	public DatasetMetadata getMetadata() {
		if (meta == null) {
			try {
				meta = DatasetMetadataFactory.getInstance(rset.getMetaData());
			} catch (final SQLException e) {
				throw new DatasetException(e);
			}
		}
		return meta;
	}


	public List<Object> getRowAsList(int rowIndex) {
		throw new UnsupportedOperationException("This is a resultstreaming class, no caching or forwardlooking, just iterate");
	}

	//@Override
	public Map<String, Object> getRowAsMap(int rowIhdex) {
		throw new UnsupportedOperationException("This is a resultstreaming class, no caching or forwardlooking, just iterate");
	}

	//@Override
	public int getRowCount() {
		throw new UnsupportedOperationException("streaming dataset");
	}

	//@Override
	public Object getValue(int rowIndex, int columnIndex) {
		throw new UnsupportedOperationException("streaming dataset");
	}

	//@Override
	public Object getValue(int rowIndex, String columnName) {
		throw new UnsupportedOperationException("streaming dataset");
	}

}
