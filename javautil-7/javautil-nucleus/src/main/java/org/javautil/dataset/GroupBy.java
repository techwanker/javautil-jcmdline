/**
 * 
 */
package org.javautil.dataset;

import org.javautil.collections.Tuple;
import org.javautil.collections.TupleSorter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * @author jjs
 * 
 *         TODO need primary order by on the grouped columns
 * 
 *         TODO need secondary order by on the non grouped columns
 * 
 *         TODO we could provide a dense matrix such as the one we got in and
 *         allow the sort to occur on either order alternatively we could create
 *         a two dimensional array to support this without copying the data all
 *         over again
 */
public class GroupBy {

	private final Logger             logger  = LoggerFactory.getLogger(getClass());

	public static final String       newline = System.getProperty("line.separator");

	private final String[]           groupByColumnNames;

	private final Dataset            dataset;

	private MutableDatasetMetadata   groupedByMeta;

	private DatasetMetadata          nonGroupedByMeta;

	private boolean                  initted = false;

	private LinkedHashSet<GroupedBy> groupedBy;

	public GroupBy(final Dataset _dataset, final String... _groupByColumnNames) {
		this.groupByColumnNames = _groupByColumnNames;
		this.dataset = _dataset;
	}

	public void sort(final SortIndex... sortIndexes) {
		final ArrayList<Tuple> groupedById = new ArrayList<Tuple>();
		final HashMap<Tuple<?>, GroupedBy> grouped = new HashMap<Tuple<?>, GroupedBy>();
		for (final GroupedBy gb : groupedBy) {
			groupedById.add(gb.getGroupColumns());
			grouped.put(gb.getGroupColumns(), gb);
		}

		final TupleSorter ts = new TupleSorter(groupedById, sortIndexes);
		ts.sort();

		final LinkedHashSet<GroupedBy> orderedSet = new LinkedHashSet<GroupedBy>();
		for (final Tuple tuple : groupedById) {
			logger.debug("after sort: " + tuple);
			orderedSet.add(grouped.get(tuple));
		}
		groupedBy = orderedSet;
	}

	public void init() {
		if (!initted) {
			setGroupedByMeta();
			setNonGroupedByMeta();
			initted = true;
		}
	}

	private void setGroupedByMeta() {
		groupedByMeta = dataset.getMetadata().getMetadataForColumns(groupByColumnNames);
	}

	private void setNonGroupedByMeta() {
		nonGroupedByMeta = dataset.getMetadata().getMetadataForNonColumns(groupByColumnNames);
	}

	public Set<GroupedBy> getGroupedBy() {

		init();

		final HashMap<Tuple<?>, GroupedBy> grouped = new HashMap<Tuple<?>, GroupedBy>();

		final DatasetIterator di = dataset.getDatasetIterator();

		final int[] groupByColumnIndexes = dataset.getMetadata().getColumnIndexes(groupByColumnNames);
		final int[] otherColumnsIndexes = dataset.getMetadata().getNonColumnIndexes(groupByColumnNames);

		while (di.next()) {
			final Object[] objects = new Object[groupByColumnNames.length];
			int tupleIndex = 0;

			for (final int groupByColumnIndexe : groupByColumnIndexes) {
				objects[tupleIndex++] = di.getObject(groupByColumnIndexe);
			}
			final Tuple<?> tuple = new Tuple(objects);
			GroupedBy gb = grouped.get(tuple);
			if (gb == null) {
				gb = new GroupedBy(tuple, groupedByMeta, nonGroupedByMeta);
				grouped.put(tuple, gb);
			}
			// get the non group by columms
			final Object[] nonGroup = new Object[otherColumnsIndexes.length];
			int nonGroupIndex = 0;
			for (final int k : otherColumnsIndexes) {
				nonGroup[nonGroupIndex++] = di.getObject(k);
			}
			gb.addNonGroupedColumns(new Tuple(nonGroup));
		}
		final LinkedHashSet<GroupedBy> retval = new LinkedHashSet<GroupedBy>(grouped.values());
		groupedBy = retval;
		return retval;
	}

	@Override
	public String toString() {
		final StringBuilder b = new StringBuilder();

		b.append(newline);
		b.append("groupedByMeta: ").append(newline);
		b.append(groupedByMeta.toString());
		b.append("nongrouped").append(newline);
		b.append(nonGroupedByMeta.toString()).append(newline);
		if (groupedBy != null) {
			for (final GroupedBy gb : groupedBy) {
				b.append(gb.toStringNoMeta());
				b.append(newline);
			}
		}
		return b.toString();
	}

	public MutableDatasetMetadata getGroupedByMeta() {
		init();
		return groupedByMeta;
	}

	public DatasetMetadata getNonGroupedByMeta() {
		init();
		return nonGroupedByMeta;
	}
}
