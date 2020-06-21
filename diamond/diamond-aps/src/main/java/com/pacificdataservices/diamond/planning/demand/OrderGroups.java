package com.pacificdataservices.diamond.planning.demand;

import java.util.ArrayList;
import java.util.Collection;
import java.util.TreeMap;

import org.javautil.core.collections.ListComparator;
import org.javautil.util.DateGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class OrderGroups {
	
	private Logger logger = LoggerFactory.getLogger(getClass());

	private TreeMap<ArrayList<String>,OrderBuckets> demandBucketMap = new TreeMap<>(new ListComparator());
	
	private DateGenerator dateGenerator;

	public OrderGroups(Collection<DemandCustomer> demands, DateGenerator dateGenerator ) {
		this.dateGenerator = dateGenerator;
		for (DemandCustomer dmd : demands) {
			ArrayList<String> dmdKey = new ArrayList<String>(2);
			dmdKey.add(dmd.getFcstGrp());
			dmdKey.add(dmd.getIcItemMast().getItemCd());
			ArrayList<String> k = demandBucketMap.floorKey(dmdKey);
			OrderBuckets buckets;
			if (k == null || ! k.equals(dmdKey)) {
				buckets = new OrderBuckets(dmdKey,dateGenerator);
				demandBucketMap.put(dmdKey,buckets);
			} else {
				buckets = demandBucketMap.get(k) ;
			}
			buckets.add(dmd);
		}
	}
	
	public Collection<String> getBucketNames() {
		ArrayList<String> firstkey = demandBucketMap.firstKey();
		OrderBuckets buckets = demandBucketMap.get(firstkey);
		return buckets.getBucketNames();
		
	}
	
	public Collection<OrderBuckets> getOrderBuckets() {
		return demandBucketMap.values();
	}
/*
	public ForecastBuckets get(String forecastGroup) {
		ForecastBuckets retval = forecastBucketsByGroup.get(forecastGroup);
		if (retval == null) {
			throw new IllegalArgumentException("forecastgroup: " + forecastGroup + 
					" not found in " + forecastBucketsByGroup.keySet());
		}
		return retval;
	}
*/
	
	public String formatMatrix() {
		StringBuilder sb  = new StringBuilder();
		for (ArrayList<String> key : demandBucketMap.keySet()) {
			OrderBuckets ob = demandBucketMap.get(key);
			sb.append(String.format("%-16s",key.get(0)));
			sb.append(" ");
			sb.append(String.format("%-16s",key.get(1)));
			sb.append(" ");
			sb.append(ob.formatMatrix());
			sb.append("\n");
		}
		return sb.toString();
	}

	/*
	public String format() {
		StringBuilder sb  = new StringBuilder();
		for (String key : forecastBucketsByGroup.keySet()) {
			ForecastBuckets fb = forecastBucketsByGroup.get(key);
			sb.append("ForecastBuckets forecast group: ");
			sb.append(key);
			sb.append("\n");
			sb.append(fb.format());
			sb.append("\n");
		}
		return sb.toString();
	}	
	
	private Buckets<Double> getNewBuckets(String bucketType) {
		Buckets<Double> retval =new Buckets<Double>(dateGenerator);
		List<String> identifier = new ArrayList<String>(2);
		identifier.add("Aggregate");
		identifier.add(bucketType);
		retval.setIdentifiers(identifier);
		return retval;
	}
	
	
	public Buckets<Double> getUnallocatedBuckets() {
		Buckets<Double> retval = getNewBuckets("Unconsumed");
			for (ForecastBuckets buckets : forecastBucketsByGroup.values()) {
				Buckets<Double> unconsumed = buckets.getUnconsumedForecastBuckets();
				for (Entry<Date,Double> e : unconsumed.getDateMap().entrySet()) {
					Double d = retval.getBucketData(e.getKey());
					double v = d == null ? 0.0 : d;
					//
					Double u = unconsumed.getBucketData(e.getKey());
					double w = u == null ? 0.0 : u;
					v += w;
					retval.put(e.getKey(),v);
			}
		}
			return retval;
	}
	
	public Collection<ForecastBuckets>  getForecastBuckets() {
		Collection<ForecastBuckets>  retval = forecastBucketsByGroup.values();
		logger.info("returning forecast buckets size: {} " ,retval.size());
		return retval;
	}
	
	public List<Buckets<Double>> getListOfBuckets()  {
	
		ArrayList<Buckets<Double>> l = new ArrayList<>();
		for (ForecastBuckets fb : forecastBucketsByGroup.values()) {
			l.addAll(fb.getListOfBuckets());
		}
		return l;
		
	}
	
	public List<String> getBucketNames() {
		return dateGenerator.getBucketNames();
	}
	*/
}
