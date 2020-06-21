package com.pacificdataservices.diamond.buckets;

import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.SortedMap;
import java.util.TreeMap;

import org.javautil.core.misc.DoubleBuckets;
import org.javautil.core.misc.MultiKey;
import org.javautil.core.text.SimpleDateFormats;
import org.javautil.util.DateGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.pacificdataservices.diamond.planning.Allocation;
import com.pacificdataservices.diamond.planning.AllocationMode;
import com.pacificdataservices.diamond.planning.supply.Supply;

public class SupplyBuckets extends DoubleBuckets {

	private Supply supply;
	private boolean trace = false;
	private SimpleDateFormat sdf = new SimpleDateFormat(SimpleDateFormats.ISO8601_date);
	private Logger logger = LoggerFactory.getLogger(getClass());

	public SupplyBuckets(Supply supply, DateGenerator dateGenerator) {
		super(dateGenerator);
		this.supply = supply;
	}

//	private void populateBuckets(DateGenerator dateGenerator) {
//		for (String partCd : supply.getIcItemMastByItemCd().keySet()) {
//			// PartsBucketIdentifier id = new
//			// PartsBucketIdentifier(supply).useItemCd(partCd).useFacility().useSupplyPoolCd();
//			// PartsBucket projPos = new PartsBucket(supply,dateGenerator,id);
//			supply.setProjectedPositionBuckets(this);
//			List<Allocation> allocations = supply.getAllocations(AllocationMode.FIRST_PASS);
//			// initialize all buckets from availDt on to grossQty
//			initialize();
//			TreeMap<Date, Double> projMap = getDateMap();
//			// for each allocation find the starting bucket and decrement it and all
//			// subsequent buckets
//			for (Allocation allocation : allocations) {
//				Date firstBucketDate = getFirstBucketDate(allocation);
//				SortedMap<Date, Double> projTail = projMap.tailMap(firstBucketDate);
//
//				if (trace) {
//					Date firstKey = projTail.firstKey();
//					int keyCount = projTail.size();
//					if (trace) {
//						logger.info("adjusting {} values starting with key {} for availDt {} needBy {}", keyCount,
//								sdf.format(firstKey), sdf.format(supply.getAvailDate()),
//								sdf.format(allocation.getDemand().getNeedByDate()));
//					}
//				}
//				boolean logged = false;
//				for (Entry<Date, Double> tailEntry : projTail.entrySet()) {
//					Double oldValue = tailEntry.getValue();
//					if (oldValue == null) {
//						throw new IllegalStateException(
//								"bucket " + sdf.format(tailEntry.getKey()) + " has null value ");
//					}
//					double newPosition = oldValue - allocation.getAllocQty();
//					if (trace) {
//						if (!logged) {
//							logger.info("Supply id {}  grossAvail: {}  oldValue: {} allocQty: {} newPosition: {}",
//									supply.getSupplyIdentifier(), sdf.format(tailEntry.getKey()),
//									supply.getGrossAvailQty(), oldValue, allocation.getAllocQty(), newPosition);
//							logged = true;
//						}
//					}
//					super.put(tailEntry.getKey(), newPosition);
//				}
//			}
//			// buckets.add(projPos);
//		}
//	}

	public Date getFirstBucketDate(Allocation allocation) {
		Date needByDate = allocation.getDemand().getNeedByDate();
		Date availDate = allocation.getSupply().getAvailDate();
		Date allocDate = needByDate.after(availDate) ? needByDate : availDate;
		Date firstBucketDate = getDateMap().floorKey(allocDate);
		if (trace) {
			logger.trace("Supply id {} availDate {} needBy: {} allocDate: {} firstBucketDate {}",
					allocation.getSupply().getSupplyIdentifier(), sdf.format(availDate), sdf.format(needByDate),
					sdf.format(allocDate), sdf.format(firstBucketDate));
		}
		return firstBucketDate;
	}

	public void initialize() {
		Date availDate = supply.getAvailDate();
		Date startKey = getDateMap().floorKey(availDate);
		Map<Date, Double> tail = getDateMap().tailMap(startKey);
		Double grossAvail = supply.getGrossAvailQty().doubleValue();
		boolean logged = false;
		for (Entry<Date, Double> tailEntry : tail.entrySet()) {
			if (!logged) {
				logger.info("initializing {} availDt {} {} to {}", supply.getIdentifierString(),
						sdf.format(supply.getAvailDate()), sdf.format(tailEntry.getKey()), grossAvail);
				logged = true;
			}
			tail.put(tailEntry.getKey(), grossAvail);
		}
	}

	/*
	 * public String toString() { //String pad = String.format("%16s","");
	 * StringBuilder sb = new StringBuilder();
	 * sb.append(String.format("id: %-20s",supply.getSupplyIdentifier())); for
	 * (String ident : id.getIdentifierMap().values()) {
	 * sb.append(String.format("%-16s ",ident)); } for (Double v : getValues()) { if
	 * (v == null) { sb.append("            0"); } else {
	 * sb.append(String.format("%12.2f ",v)); } } return sb.toString(); }
	 */
	/*
	 * public String toCSV() { //String pad = String.format("%16s","");
	 * StringBuilder sb = new StringBuilder();
	 * sb.append(String.format("id: %-16s",supply.getSupplyIdentifier())); boolean
	 * needsComma = false; for (String ident : getIdentifiers()) { if (needsComma) {
	 * sb.append(","); } sb.append(String.format("\"%s\"",ident)); needsComma =
	 * true; } for (Double v : getValues()) { if (v != null) {
	 * sb.append(String.format(",%f",v)); } } return sb.toString(); }
	 */

	public Supply getSupply() {
		return supply;
	}

	// public PartsBucketIdentifier getId() {
	// return id;
	// }
	//
	// public PartsBucketIdentifier getGroupById() {
	// return groupById;
	// }

	public static double[] sum(List<SupplyBuckets> buckets) {
		double sums[] = new double[buckets.get(0).getDateMap().size()];
		for (SupplyBuckets b : buckets) {
			Collection<Double> values = b.getDateMap().values();
			int i = 0;
			for (Double value : values) {
				sums[i++] += value == null ? 0 : value;
			}
		}
		return sums;

	}

	public static TreeMap<Date, Double> getSumMap(List<SupplyBuckets> buckets) {
		double sums[] = sum(buckets);
		SupplyBuckets pb = buckets.get(0);
		TreeMap<Date, Double> map = new TreeMap<Date, Double>();
		int i = 0;
		for (Date date : pb.getDateMap().keySet()) {
			map.put(date, sums[i++]);
		}
		return map;
	}

	// TODO dupe
	public String formatKeyAndValues(MultiKey key, int maxIndex) {
		StringBuilder sb = new StringBuilder();
		List<String> kv = key.asStringList();
		int index  = 0;
		//String fmt = String.format("%-8s %-8s %-8s %-20s items: %-20s",kv.get(0), kv.get(1), kv.get(2), kv.get(3), kv.get(5) );
		String fmt = String.format("%-8s %-16s %-8s %-20s" ,kv.get(0), kv.get(1), kv.get(2), kv.get(3) );
		sb.append(fmt);
		sb.append(" ");
		for (Double v : getValues()) {
			if (v == null) {
				sb.append("            0");
			} else {
				sb.append(String.format("%12.2f ", v));

			}
			if (maxIndex >= 0 && ++index > maxIndex) {
				break;
			}
		}
		return sb.toString();
	}

}
