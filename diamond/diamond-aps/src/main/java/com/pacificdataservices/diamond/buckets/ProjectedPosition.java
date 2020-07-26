package com.pacificdataservices.diamond.buckets;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.SortedMap;
import java.util.TreeMap;

import org.javautil.containers.Buckets;
import org.javautil.containers.DoubleBuckets;
import org.javautil.containers.MultiKey;
import org.javautil.containers.MultiKeyHashMap;
import org.javautil.containers.MultiKeyHashMapOfLists;
import org.javautil.text.SimpleDateFormatFactory;
import org.javautil.util.DateGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.pacificdataservices.diamond.planning.Allocation;
import com.pacificdataservices.diamond.planning.AllocationMode;
import com.pacificdataservices.diamond.planning.supply.Supply;

/**
 * Calculates the bucketed project position of Supply.
 * 
 * First pass is to bucket lowest level of supply.  
 * 
 * It appears in the first bucket based on availability date.
 * Subsequent buckets are decremented by the allocations in that bucket.
 * 
 * Higher level views are created by aggregation of the appropriate lower level views.
 * 
 * Identifiers are 
 * <ul>
 *    <li>Facility</li>
 *    <li>Supply Pool</li>
 *    <li>Item Number<li>
 *    <li>Manufacturer<li>
 * </ul>
 * 
 * Note that a given supply may be aggregated in two different part numbers if it is dual certified.
 * Thus, the sum of subsets may aggregate to more than the whole set.
 * 
 * The allocation date is the greater of the supply available date and the demand need by date.
 * 
 * 
 * Initialize all buckets from availDt on to grossQty.
 * 
 *for each allocation find the starting bucket and decrement it and all subsequent buckets
 * 
 * TODO look at the TEST, this could be done much easier SupplyProjectedPositionTest
 * 
 * Example groupBy
 * 
 * Specify a group by 
 * 
 * 	SupplyBucketsIdentifier groupById = new PartsBucketIdentifier(dtl.getSupply()).useItemCd(itemCd).useFacility();
 * 
 * TODO need IcMultipleCert in eligiblity and planning, set in AbstractSupply
 */
public class ProjectedPosition  {

	private Logger logger = LoggerFactory.getLogger(getClass());
	private Logger generateLogger = LoggerFactory.getLogger("SupplyProjectedPosition.generateDetailedPosition");
	private boolean isGenerateLoggerDebugEnabled = generateLogger.isDebugEnabled();
	private boolean logDetail = isGenerateLoggerDebugEnabled;
	private boolean trace = true;
	private Collection<Supply> supplies;
	private DateGenerator dateGenerator;
	//private ArrayList<SupplyBuckets> buckets = new ArrayList<>();
	private MultiKeyHashMap<SupplyBuckets> supplyBucketsMap = new MultiKeyHashMap<SupplyBuckets>();
	private SimpleDateFormat sdf = SimpleDateFormatFactory.getYyyyDashMmDashDd();
	private MultiKeyHashMapOfLists<SupplyBuckets> groupedBy;

	public ProjectedPosition(Collection<Supply> supplies, DateGenerator dateGenerator) {
		this.supplies = supplies;
		this.dateGenerator = dateGenerator;
		generateDetailedProjectedPosition();
	}

	private void generateDetailedProjectedPosition() {
		int  i = 0;
		for (Supply supply : supplies) {
			generateLogger.debug("i = " + i + " supply: " + supply.getSupplyIdentifier());
			SupplyBuckets supplyHmmBuckets = new SupplyBuckets(supply,dateGenerator);
			supplyHmmBuckets.setNoId();
			supply.setProjectedPositionBuckets(supplyHmmBuckets);
			List<Allocation> allocations = supply.getAllocations(AllocationMode.FIRST_PASS);
			// initialize all buckets from availDt on to grossQty
			initialize(supplyHmmBuckets);
			TreeMap<Date,Double> projMap = supplyHmmBuckets.getDateMap();
			// for each allocation find the starting bucket and decrement it and all subsequent buckets
			for (Allocation allocation : allocations) {
				Date firstBucketDate = getFirstAllocationBucketDate(supplyHmmBuckets, allocation);
				SortedMap<Date,Double> projTail = projMap.tailMap(firstBucketDate);

				if (logDetail) {
					Date firstKey = projTail.firstKey();
					int keyCount = projTail.size();
					if (trace) {
						logger.debug("adjusting {} values starting with key {} for availDt {} needBy {}", keyCount, sdf.format(firstKey), sdf.format(supply.getAvailDate()), 
								sdf.format(allocation.getDemand().getNeedByDate()));
					}
				}
				boolean logged = false;
				for (Entry<Date, Double> tailEntry : projTail.entrySet()) {
					Double oldValue = tailEntry.getValue();
					if (oldValue == null) {
						throw new IllegalStateException("bucket " + sdf.format(tailEntry.getKey()) + " has null value ");
					}
					double newPosition = oldValue - allocation.getAllocQty();
					if (logDetail) {
						if (!logged) {
							logger.debug("Supply id {}  grossAvail: {}  oldValue: {} allocQty: {} newPosition: {}",
									supply.getSupplyIdentifier(), sdf.format(tailEntry.getKey()), supply.getGrossAvailQty(), oldValue, allocation.getAllocQty(), newPosition);
							logged = true;
						}
					}
					supplyHmmBuckets.put(tailEntry.getKey(),newPosition);
				}
			}
		
			MultiKey itemCodes = supply.getItemCodeMultiKey();
			for (String itemCd : supply.getIcItemMastByItemCd().keySet()) {
				MultiKey id = new MultiKey(supply.getFacility(),supply.getApsSplyPool().getApsSplyPoolCd(),
						supply.getApsSplySubPool().getApsSplySubPoolCd(),  supply.getSupplyIdentifier(), itemCd, itemCodes);
				SupplyBuckets old =  supplyBucketsMap.put(id,supplyHmmBuckets);
				if (old != null) {
					String message = "for key " + id.format() + " i " +  i +  "\nexists: "  + old +  "\nnew: "+ supplyHmmBuckets;
					logger.error(message);
					throw new IllegalStateException(message);
				}
			}
			i++;
		}
		if (supplies.size() > supplyBucketsMap.size())  {
			throw new IllegalStateException("supplies.size = " + supplies.size() +  "map size "  + supplyBucketsMap.size() );
		}
	}

	public void initialize(SupplyBuckets partsBucket) {
		Date availDate = partsBucket.getSupply().getAvailDate();
		Date startKey = partsBucket.getDateMap().floorKey(availDate);
		Map<Date,Double> tail = partsBucket.getDateMap().tailMap(startKey);
		Supply supply = partsBucket.getSupply();
		Double grossAvail = supply.getGrossAvailQty().doubleValue();
		for (Entry<Date, Double> tailEntry : tail.entrySet()) {
			if (logDetail) {
				logger.debug("initializing {} availDt {} {} to {}", supply.getIdentifierString(), 
						sdf.format(supply.getAvailDate()),
						sdf.format(tailEntry.getKey()), grossAvail);
			}
			tail.put(tailEntry.getKey(),grossAvail);
		}
	}

	public Date getFirstAllocationBucketDate(SupplyBuckets buckets, Allocation allocation) {
		Date needByDate = allocation.getDemand().getNeedByDate();
		Date availDate = allocation.getSupply().getAvailDate();
		Date allocDate = needByDate.after(availDate) ? needByDate : availDate;
		Date firstBucketDate = buckets.getDateMap().floorKey(allocDate);
//		if (trace) {
//			logger.debug("Supply id {} availDate {} needBy: {} allocDate: {} firstBucketDate {}",
//					allocation.getSupply().getSupplyIdentifier(),
//					sdf.format(availDate), 
//					sdf.format(needByDate), 
//					sdf.format(allocDate),
//					sdf.format(firstBucketDate)
//					);
//		}
		return firstBucketDate;
	}


	// TODO take a list of Strings for groupBy these will be key fields for identfier
	/**
	 * <ol>
	 *    <li>0 - Facility</li>
	 *    <li>1 - Pool</li>
	 *    <li>2 - Subpool</li>
	 *    <li>3 - identifier</li>
	 *    <li>4 - itemCd </li>
	 *    <li>5 - itemCd list<li>
	 *    	MultiKey id = new MultiKey(supply.getFacility(),supply.getApsSplyPool().getApsSplyPoolCd(),
						supply.getApsSplySubPool().getApsSplySubPoolCd(),  supply.getSupplyIdentifier(), itemCd, itemCodes);
	 * @param indicies
	 * @return
	 */
	public MultiKeyHashMapOfLists<SupplyBuckets> groupBy(int... indicies) {
		boolean groupByItemCode = false;
		boolean groupByItemCodes = false;
		for (int index : indicies ) {
			switch (index) {
			case 4:
				groupByItemCode = true;
				break;
			case 5:
				groupByItemCodes = true;
				break;
			}
		}
		if (groupByItemCode) {
			if (groupByItemCodes) {
				throw new IllegalArgumentException("groupby on 4 and 5");
			}
		} else {
			if (! groupByItemCodes) {
				throw new IllegalArgumentException("groupby must be on 4 or 5");
			}
		}
		MultiKeyHashMapOfLists<SupplyBuckets> grouped = new MultiKeyHashMapOfLists<SupplyBuckets>();
		StringBuilder indexSB = new StringBuilder();
		indexSB.append("indexes ");
		for (int n : indicies) {
			indexSB.append(n);
			indexSB.append(" ");
		}
		logger.debug("groupBy grouping bucket count" + supplyBucketsMap.size() + " with " + indexSB.toString());
		for (Entry<MultiKey,SupplyBuckets> e : supplyBucketsMap.entrySet()) {
			MultiKey supplyId  = e.getKey();
			MultiKey groupById = supplyId.getMultiKey(indicies);

			ArrayList<SupplyBuckets> buckets = grouped.get(groupById);
			if (buckets == null) {
				buckets = new ArrayList<SupplyBuckets>();
				grouped.put(groupById,buckets);
			}
			buckets.add(e.getValue());
			logger.debug("adding to : {}\n value: {} :DONE:s", groupById.format(), e.getValue());
		}
		this.groupedBy = grouped;
		if (trace) {
			logger.debug("groupBy into " + grouped.size() + " groups");
			for (Entry<MultiKey,ArrayList<SupplyBuckets>> e : grouped.entrySet()) {
				logger.debug(("key " + e.getKey().format() + " size " + e.getValue().size()));
			}
		}
		return this.groupedBy;
	}


	public String format(int maxIndex) {
		StringBuilder sb = new StringBuilder();
		for (Entry<MultiKey,SupplyBuckets> e: supplyBucketsMap.entrySet()) {
			sb.append(e.getValue().formatKeyAndValues(e.getKey(),maxIndex));
			sb.append("\n");
		}
		return sb.toString();
	}


	public String formatGroupBy(List<SupplyBuckets> details) {
		//testSupplyBucketsDetail(details);
		StringBuilder sb = new StringBuilder();
		for (SupplyBuckets detail : details) {
			sb.append(detail.format(false));
			sb.append("\n");
		}
		return sb.toString();
	}

	public String formatGroupByAndSum(List<SupplyBuckets> details, Buckets<Double> sum) {
		StringBuilder sb = new StringBuilder();
		sb.append(formatGroupBy(details));
		sb.append(sum.format(false));
		sb.append("\n");
		return sb.toString();
	}

	public MultiKeyHashMap<DoubleBuckets> sum(MultiKeyHashMapOfLists<SupplyBuckets> groupedBy) { // TreeMap<String[],List<SupplyBuckets>> groupedBy) {
//		StringBuilder sb = null;
//		boolean trace = true;
//		if (trace) { 
//			sb = new StringBuilder();
//		}
		MultiKeyHashMap<DoubleBuckets> retval  = new MultiKeyHashMap<DoubleBuckets>();

		for (Entry<MultiKey,ArrayList<SupplyBuckets>> e : groupedBy.entrySet()) {
			List<SupplyBuckets> bucketList = e.getValue();
			TreeMap<Date,Double> dateMap = SupplyBuckets.getSumMap(bucketList);
			DoubleBuckets bucketSum = new DoubleBuckets (e.getKey(),dateMap);
			retval.put(e.getKey(),bucketSum);
		}
		return retval;
	}

	/**
	 * @return the supplyBucketsMap
	 */
	public MultiKeyHashMap<SupplyBuckets> getSupplyBucketsMap() {
		return supplyBucketsMap;
	}

	/**
	 * @return the groupedBy
	 */
	public MultiKeyHashMapOfLists<SupplyBuckets> getGroupedBy() {
		return groupedBy;
	}
}
