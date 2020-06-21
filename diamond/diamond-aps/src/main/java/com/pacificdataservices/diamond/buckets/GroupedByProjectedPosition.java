//package com.pacificdataservices.diamond.buckets;
//
//import java.util.ArrayList;
//import java.util.Map.Entry;
//
//import org.javautil.core.misc.DoubleBuckets;
//import org.javautil.core.misc.MultiKey;
//import org.javautil.core.misc.MultiKeyHashMap;
//import org.javautil.core.misc.MultiKeyTreeMapOfLists;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//public class GroupedByProjectedPosition extends MultiKeyTreeMapOfLists<DoubleBuckets> {
//    /**
//	 * 
//	 */
//	private static final long serialVersionUID = 967604551023308029L;
//	private  static final String[] titles = new String[] {"Facility","Supply Pool","Subpool","ID","Item Code","Item Codes"};
//	private Logger logger = LoggerFactory.getLogger(getClass());
//	//private ArrayList<String> identfierNames = new ArrayList<String>();
//	private String[]idNames;
//	private boolean trace;
//	public GroupedByProjectedPosition(SupplyProjectedPosition spp, int... indexes) {
//		idNames = new String[indexes.length];
//		boolean groupByItemCode = false;
//		boolean groupByItemCodes = false;
//		int i = 0;
//		for (int index : indexes ) {
//			idNames[i++] = titles[index];
//			switch (index) {
//			case 4:
//				groupByItemCode = true;
//				break;
//			case 5:
//				groupByItemCodes = true;
//				break;
//			}
//		}
//		if (groupByItemCode) {
//			if (groupByItemCodes) {
//				throw new IllegalArgumentException("groupby on 4 and 5");
//			}
//		} else {
//			if (! groupByItemCodes) {
//				throw new IllegalArgumentException("groupby must be on 4 or 5");
//			}
//		}
//		StringBuilder indexSB = new StringBuilder();
//		indexSB.append("indexes ");
//		for (int n : indexes) {
//			indexSB.append(n);
//			indexSB.append(" ");
//		}
//		MultiKeyHashMap<SupplyBuckets> supmap = spp.getSupplyBucketsMap();
//		logger.info("groupBy grouping bucket count" + supmap.size() + " with " + indexSB.toString());
//		for (Entry<MultiKey,SupplyBuckets> e : supmap.entrySet()) {
//			MultiKey supplyId  = e.getKey();
//			MultiKey groupById = supplyId.getMultiKey(indexes);
//
//			ArrayList<DoubleBuckets> buckets = this.get(groupById);
//			if (buckets == null) {
//				buckets = new ArrayList<DoubleBuckets>();
//				this.put(groupById,buckets);
//			}
//			buckets.add(e.getValue());
//			logger.info("adding to : {}\n value: {} :DONE:s", groupById.format(), e.getValue());
//		}
//		if (trace) {
//			logger.info("groupBy into " + this.size() + " groups");
//			for (Entry<MultiKey,ArrayList<DoubleBuckets>> e : this.entrySet()) {
//				logger.info(("key " + e.getKey().format() + " size " + e.getValue().size()));
//			}
//		}
//	}
//
//}
