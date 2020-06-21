package com.pacificdataservices.diamond.planning.demand;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;

import org.javautil.core.misc.Buckets;
import org.javautil.util.DateGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.pacificdataservices.diamond.planning.AllocationMode;

public class OrderBuckets {

	private ArrayList<String> key;
	private List<DemandCustomer> orders = new ArrayList<>();
	private DateGenerator dateGenerator;
	private Buckets<ArrayList<DemandCustomer>> orderBuckets;
	private Buckets<Double> openQtyBuckets;
	private Buckets<Double> allocQtyBuckets;
	private Buckets<Double> unallocQtyBuckets;
	private Logger logger = LoggerFactory.getLogger(getClass());

	public OrderBuckets(ArrayList<String> key,DateGenerator dg) {
		if (key == null) {
			throw new IllegalArgumentException("key is null");
		}
		if (dg == null) {
			throw new IllegalArgumentException("dg is null");
		}
		this.key = key;
		this.dateGenerator =dg;
		orderBuckets = new Buckets<ArrayList<DemandCustomer>>(dg);
	
		openQtyBuckets = new Buckets<Double>(dg,0.0);
		ArrayList<String> openQtyId = new ArrayList<String>();
		logger.info("========================================= openQtyId {} key {}",openQtyId,key);
		openQtyId.addAll(key);
		openQtyId.add("Open Qty");
		openQtyBuckets.setIdentifiers(openQtyId);

		allocQtyBuckets = new Buckets<Double>(dg,0.0);
		ArrayList<String> allocatedId = new ArrayList<String>();
		allocatedId.addAll(key);
		allocatedId.add("Allocated");
		allocQtyBuckets.setIdentifiers(allocatedId);
		
		unallocQtyBuckets = new Buckets<Double>(dg,0.0);
		ArrayList<String> unallocatedId = new ArrayList<String>();
		unallocatedId.addAll(key);
		unallocatedId.add("Anallocated");
		unallocQtyBuckets.setIdentifiers(unallocatedId);
	}
	
	public Collection<String> getBucketNames() {
		return orderBuckets.getBucketMap(true, true).keySet();
	}

	public void add(DemandCustomer dmd) {
		orders.add(dmd);
		ArrayList<DemandCustomer> bucketOrders = orderBuckets.getBucketData(dmd.getRqstDt());
		if (bucketOrders == null) {
			bucketOrders = new ArrayList<DemandCustomer>();
		}
		bucketOrders.add(dmd);
		orderBuckets.put(dmd.getRqstDt(), bucketOrders);
		openQtyBuckets.increment(dmd.getRqstDt(),dmd.getOpenQty().doubleValue());
		allocQtyBuckets.increment(dmd.getRqstDt(),dmd.getAllocatedOnTimeQty(AllocationMode.FIRST_PASS));
		unallocQtyBuckets.increment(dmd.getRqstDt(),dmd.getUnallocatedQty(AllocationMode.FIRST_PASS));
	}
	
	public List<Buckets<Double>> getBucketList() {
		ArrayList<Buckets<Double>> retval =new ArrayList<>();
		retval.add(openQtyBuckets);
		retval.add(allocQtyBuckets);
		retval.add(unallocQtyBuckets);
		return retval;
	}

	public String formatDoubleList(Collection<Double> values) {
		StringBuilder sb = new StringBuilder();
		for (Double v : values) {
			if (v == null) {
				sb.append(String.format("%10s",""));
			} else {
				String value = String.format("%10f ",v);
				//logger.info(String.format("v %d '%s'",value.length(),value));
				sb.append(value);
			}
		}
		return sb.toString();
	}
	public String formatMatrix() {
		StringBuilder sb = new StringBuilder();
		LinkedHashMap<String,ArrayList<DemandCustomer>> map = orderBuckets.getBucketMap(true,false);
		for (String k : map.keySet()) {
			sb.append(String.format("%10s ",k));
		}
		sb.append("\n");
		sb.append(String.format("%-16s %-16s %s\n","","Open Qty",formatDoubleList(openQtyBuckets.getBucketMap(true, true).values())));
		sb.append(String.format("%-16s %-16s %s\n","","Alloc Qty",formatDoubleList(allocQtyBuckets.getBucketMap(true, true).values())));
		sb.append(String.format("%-16s %-16s %s\n","","Unalloc Qty",formatDoubleList(unallocQtyBuckets.getBucketMap(true, true).values())));
		return sb.toString();

	}
	
	public ArrayList<String> getKey() {
		return key;
	}
}
