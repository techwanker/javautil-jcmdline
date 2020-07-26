package com.pacificdataservices.diamond.planning.demand;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;
import java.util.TreeSet;

import org.javautil.containers.Buckets;
import org.javautil.hibernate.HibernateMarshallerFactory;
import org.javautil.util.DateGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.Gson;
import com.pacificdataservices.diamond.models.FcItemMast;
import com.pacificdataservices.diamond.models.IcItemMast;
import com.pacificdataservices.diamond.planning.data.ForecastBuckets;
import com.pacificdataservices.diamond.planning.data.NoForecastGroupException;

public class ForecastGroups {

	private transient Logger logger = LoggerFactory.getLogger(getClass());

	private TreeMap<String, ForecastBuckets> forecastBucketsByGroup = new TreeMap<>();

	private transient DateGenerator dateGenerator;
	
	public ForecastGroups(Collection<DemandForecast> forecasts, DateGenerator dateGenerator,
			Map<Integer, IcItemMast> icItemMastById, Map<Integer, FcItemMast> fcItemMastById) {
		this.dateGenerator = dateGenerator;
//		this.forecasts = forecasts;
		for (DemandForecast dmd : forecasts) {
			ForecastBuckets buckets = forecastBucketsByGroup.get(dmd.getFcstGrp());
			
			if (buckets == null) {
				logger.debug("adding FcstGrp {}",dmd.getFcstGrp());
				buckets = new ForecastBuckets(dmd.getFcstGrp(), dateGenerator);
				FcItemMast fim = fcItemMastById.get(dmd.getFcItemMastNbr());
				buckets.setFcItemMast(fim);
				IcItemMast iim = icItemMastById.get(fim.getItemNbr());
				buckets.setIcItemMast(iim);
				forecastBucketsByGroup.put(dmd.getFcstGrp(), buckets);
			}
			buckets.add(dmd);
		}
		logger.debug("Forecast Groups Summary:\n{}",summaryInfo());
	}
	

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ForecastGroups ");
		builder.append(forecastBucketsByGroup.toString());
		return builder.toString();
	}


	public ForecastBuckets get(String forecastGroup) {
		ForecastBuckets retval = forecastBucketsByGroup.get(forecastGroup);
		if (retval == null) {
			String message = String.format("forecastGroup %s not found in:\n%s", forecastGroup, summaryInfo() );
			throw new NoForecastGroupException(message);
		}
		return retval;
	}

	public TreeSet<String> getForecastGroupNames() {
		TreeSet<String> names = new TreeSet<>();
		for (String key : forecastBucketsByGroup.keySet()) {
			names.add(key);
		}
		return names;

	}

	public String formatMatrix() {
		StringBuilder sb = new StringBuilder();
		for (String key : forecastBucketsByGroup.keySet()) {
			ForecastBuckets fb = forecastBucketsByGroup.get(key);
			sb.append(fb.formatMatrix());
			sb.append("\n");
		}
		return sb.toString();
	}

	public String summaryInfo() {
		StringBuilder sb = new StringBuilder();
		for (String key : forecastBucketsByGroup.keySet()) {
			ForecastBuckets fb = forecastBucketsByGroup.get(key);
			sb.append(fb.stringSummary());
			sb.append("\n");
		}
		return sb.toString();
	}

	public String format() {
		StringBuilder sb = new StringBuilder();
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
		Buckets<Double> retval = new Buckets<Double>(dateGenerator);
		ArrayList<String> identifier = new ArrayList<String>(2);
		identifier.add("Aggregate");
		identifier.add(bucketType);
		retval.setIdentifiers(identifier);
		return retval;
	}

	public Buckets<Double> getUnallocatedBuckets() {
		Buckets<Double> retval = getNewBuckets("Unconsumed");
		for (ForecastBuckets buckets : forecastBucketsByGroup.values()) {
			Buckets<Double> unconsumed = buckets.getUnconsumedForecastBuckets();
			for (Entry<Date, Double> e : unconsumed.getDateMap().entrySet()) {
				Double d = retval.getBucketData(e.getKey());
				double v = d == null ? 0.0 : d;
				//
				Double u = unconsumed.getBucketData(e.getKey());
				double w = u == null ? 0.0 : u;
				v += w;
				retval.put(e.getKey(), v);
			}
		}
		return retval;
	}

	public Collection<ForecastBuckets> getForecastBuckets() {
		Collection<ForecastBuckets> retval = forecastBucketsByGroup.values();
		logger.info("returning forecast buckets size: {} ", retval.size());
		return retval;
	}

	public List<Buckets<Double>> getListOfBuckets() {

		ArrayList<Buckets<Double>> l = new ArrayList<>();
		for (ForecastBuckets fb : forecastBucketsByGroup.values()) {
			l.addAll(fb.getListOfBuckets());
		}
		return l;

	}

	public List<String> getBucketNames() {
		return dateGenerator.getBucketNames();
	}
	
	public String toJson() {
		Gson dillon  = HibernateMarshallerFactory.getHibernateGsonWithProxyDateFormatter();
		return dillon.toJson(this);
	}
	
	public String forecastBucketsToString() {
		Gson dillon  = HibernateMarshallerFactory.getHibernateGsonWithProxyDateFormatter();
		StringBuilder sb = new StringBuilder();
		for (String nm : forecastBucketsByGroup.keySet()) {
			String groupString = "group " + nm + "\n" + dillon.toJson(forecastBucketsByGroup.get(nm)) + "\n";
			sb.append(groupString);
		}
		return sb.toString(); 
	}
}
