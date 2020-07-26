package com.pacificdataservices.diamond.planning.data;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

import org.javautil.containers.Buckets;
import org.javautil.containers.MultiKey;
import org.javautil.util.DateGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.pacificdataservices.diamond.models.FcItemMast;
import com.pacificdataservices.diamond.models.IcItemMast;
import com.pacificdataservices.diamond.planning.AllocationMode;
import com.pacificdataservices.diamond.planning.demand.DemandCustomer;
import com.pacificdataservices.diamond.planning.demand.DemandForecast;

public class ForecastBuckets {

	private transient Logger logger = LoggerFactory.getLogger(getClass());
	private transient List<DemandForecast> forecasts = new ArrayList<>();
	private transient DateGenerator dateGenerator;

	private Buckets<DemandForecast> bucketedForecasts;
	private transient String forecastGroup;
	private transient FcItemMast fcItemMast;
	
	private transient IcItemMast icItemMast;

	public ForecastBuckets(String forecastGroup, DateGenerator dg) {
		logger.debug("creating {} " , forecastGroup);
		this.forecastGroup = forecastGroup;
		this.dateGenerator = dg;
		bucketedForecasts = new Buckets<DemandForecast>(dg);
	}	

	public ForecastBuckets(Collection<DemandForecast> forecasts, String forecastGroup, DateGenerator dg) {
		logger.debug("creating {}" , forecastGroup);
		this.forecastGroup = forecastGroup;
		this.dateGenerator = dg;
		bucketedForecasts = new Buckets<DemandForecast>(dg);
		for (DemandForecast forecast : forecasts) {
			add(forecast);
		}
	}

	public void add(DemandForecast forecast) {
		this.forecasts.add(forecast);
		bucketedForecasts.put(forecast.getNeedByDate(),forecast); 
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("forecastGroup: ");
		sb.append(forecastGroup);
		sb.append("\n");
		sb.append(bucketedForecasts.toString());
		return sb.toString();
	}

	public String stringSummary() {
		StringBuilder sb = new StringBuilder();
		sb.append(String.format("forecastGroup: %-8s",forecastGroup));
		sb.append(" size: ");
		Set<String> bucketKeys = bucketedForecasts.getBucketMap(true, true).keySet();
		sb.append(bucketKeys.size());
		sb.append(" ");
		sb.append(bucketedForecasts.getBucketMap(true, true).keySet().toString());
		return sb.toString();
	}

	public void consumeForecastForDemand(DemandCustomer demand, AllocationMode mode) {
		if (!demand.getFcstGrp().equals(forecastGroup)) {
			String message = String.format("demand.fcstGrp: %s, this fcstGrp: %s",demand.getFcstGrp(),forecastGroup);
			logger.error(message);
			throw new IllegalArgumentException(message);
		};

		DemandForecast fcstToConsume = bucketedForecasts.getBucketData(demand.getNeedByDate());
		if (fcstToConsume == null) {

			//			String message = String.format("Unable find bucket for forecast Group %s date %s demand: %s\n in forecastBuckets group %s %s", 
			//					demand.getFcstGrp(), demand.getNeedByDate(), demand.toString(), 
			//					forecastGroup,
			//					bucketedForecasts );
			String message = String.format("Unable find bucket for forecast Group %s date %s demand: %s\n in forecastBuckets group %s ", 
					demand.getFcstGrp(), demand.getNeedByDate(), demand.toString(), 
					forecastGroup); 
			//logger.info(message);
			//throw new PlanningDataException(message);
		} else {
			fcstToConsume.consumeThisForecast(demand,mode);
		}
	}

	/**
	 * @return the bucketedForecasts
	 */
	public Buckets<DemandForecast> getBucketedForecasts() {
		return bucketedForecasts;
	}
	
	public String format() {
		StringBuilder sb = new StringBuilder();
		sb.append("forecastGroup: ");
		sb.append(forecastGroup);
		sb.append("\n");
		LinkedHashMap<String,DemandForecast> map = bucketedForecasts.getBucketMap(false,false);
		for (String k : map.keySet()) {
			sb.append(k);
			sb.append(": ");
			DemandForecast forecast = map.get(k);
			if (forecast == null) {
				sb.append("null");
			} else {
				sb.append("adj: ");
				sb.append(forecast.getGrossOpenQty());
				sb.append(" consumed: ");
				sb.append(forecast.getQuantityConsumed(AllocationMode.FIRST_PASS));
			}
			sb.append("\n");
		}
		sb.append(bucketedForecasts.toString());
		return sb.toString();
		
	}

	public String formatDoubleList(List<Double> values) {
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
		LinkedHashMap<String,DemandForecast> map = bucketedForecasts.getBucketMap(false,false);
		sb.append(String.format("%-16s ",forecastGroup));
		for (String k : map.keySet()) {
			sb.append(String.format("%10s ",k));
		}
		sb.append("\n");
		sb.append(String.format("%-16s %s\n","Adjusted",formatDoubleList(getAdjustedForecasts())));
		sb.append(String.format("%-16s %s\n","Consumed Qty",formatDoubleList(getConsumedQty())));
		sb.append(String.format("%-16s %s\n","UnConsumed Qty",formatDoubleList(getUnConsumedQty())));
		sb.append(String.format("%-16s %s\n","Allocated Qty",formatDoubleList(getUnConsumedQty())));
		sb.append(String.format("%-16s %s\n","Unallocated Qty",formatDoubleList(getUnallocatedQty())));
		return sb.toString();
		
	}
	
	public List<Double> getAdjustedForecasts() {
		List<Double> retval = new ArrayList<>();
		for (DemandForecast fcst : bucketedForecasts.getBucketMap(false,false).values()) {
			retval.add(fcst == null ? null : fcst.getGrossOpenQty());
		}
		return retval;
	}

	public List<Double> getConsumedQty() {
		List<Double> retval = new ArrayList<>();
		for (DemandForecast fcst : bucketedForecasts.getBucketMap(false,false).values()) {
			retval.add(fcst == null ? null : fcst.getQuantityConsumed(AllocationMode.FIRST_PASS));
		}
		return retval;
	}
	
	public List<Double> getUnConsumedQty() {
		List<Double> retval = new ArrayList<>();
		for (DemandForecast fcst : bucketedForecasts.getBucketMap(false,false).values()) {
			Double unconsumed = null;
			if (fcst != null) {
				unconsumed = fcst.getGrossOpenQty() - fcst.getQuantityConsumed(AllocationMode.FIRST_PASS);
			}
			retval.add(unconsumed);
		}
		return retval;
	}
	
	// TODO Could be late must report ontime
	public List<Double> getAllocatedQty() {
		List<Double> retval = new ArrayList<>();
		for (DemandForecast fcst : bucketedForecasts.getBucketMap(false,false).values()) {
			retval.add(fcst == null ? null : fcst.getQtyAllocatedFirstPass());
		}
		return retval;
	}

	private Buckets<Double> getNewBuckets(String bucketType) {
		Buckets<Double> retval =new Buckets<Double>(dateGenerator);
		ArrayList<String> identifier = new ArrayList<String>(2);
		identifier.add(forecastGroup);
		identifier.add(bucketType);
		MultiKey id = new MultiKey(identifier);;
		retval.setIdentifiers(identifier);
		return retval;
	}
	
	public Buckets<Double> getAdjustedForecastBuckets() {
		Buckets<Double> retval = getNewBuckets("Adjusted");
		for (Entry<Date, DemandForecast> e : bucketedForecasts.getDateMap().entrySet()) {
			Double v = e.getValue() == null ? null : e.getValue().getGrossOpenQty();
			retval.put(e.getKey(),v);
		}
		return retval;
	}
	
	public Buckets<Double> getAllocatedBuckets() {
		Buckets<Double> retval = getNewBuckets("Allocated");
		for (Entry<Date, DemandForecast> e : bucketedForecasts.getDateMap().entrySet()) {
			Double v = e.getValue() == null ? null : e.getValue().getQtyAllocatedFirstPass();
			retval.put(e.getKey(),v);
		}
		return retval;
	}
	
	public Buckets<Double> getUnconsumedForecastBuckets() {
		Buckets<Double> retval = getNewBuckets("Unconsumed");
		for (Entry<Date, DemandForecast> e : bucketedForecasts.getDateMap().entrySet()) {
			DemandForecast fcst = e.getValue();
			Double value = null;
			if (fcst != null) {
			     value = fcst.getGrossOpenQty() - fcst.getQuantityConsumed(AllocationMode.FIRST_PASS);
			}
			retval.put(e.getKey(),value);
		}
		return retval;
	}
	
	public Buckets<Double> getConsumedForecastBuckets() {
		Buckets<Double> retval = getNewBuckets("Consumed");
		for (Entry<Date, DemandForecast> e : bucketedForecasts.getDateMap().entrySet()) {
			Double v = e.getValue() == null ? null : e.getValue().getQuantityConsumed(AllocationMode.FIRST_PASS);
			retval.put(e.getKey(),v);
		}
		return retval;
	}
	
	public Buckets<Double> getUnallocatedBuckets() {
		Buckets<Double> retval = getNewBuckets("Unallocated");
		for (Entry<Date, DemandForecast> e : bucketedForecasts.getDateMap().entrySet()) {
			Double value = null;
			DemandForecast fcst = e.getValue();
			if (fcst != null) {
				value =  fcst.getGrossOpenQty() - fcst.getQuantityConsumed(AllocationMode.FIRST_PASS) - fcst.getQtyAllocatedFirstPass();
				logger.debug("getUnallocatedBuckets value {} for {}", value, fcst.format());
			}
			retval.put(e.getKey(), value);
		}
		return retval;
	}
	
	public List<Buckets<Double>> getListOfBuckets() {
		LinkedHashMap<String, DemandForecast> map = bucketedForecasts.getBucketMap(false,false);
		logger.debug("Keys={}",map.keySet());
		
		List<Buckets<Double>> l = new ArrayList<>();
		l.add(getAdjustedForecastBuckets());
		l.add(getConsumedForecastBuckets());
		l.add(getUnconsumedForecastBuckets());
		l.add(getAllocatedBuckets());
		l.add(getUnallocatedBuckets());
		return l;
		
	}

	public List<Double> getUnallocatedQty() {
		List<Double> retval = new ArrayList<>();
		for (DemandForecast fcst : bucketedForecasts.getBucketMap(false,false).values()) {
			Double unallocated = null;
			if (fcst != null) {
				double grossOpenQty = fcst.getGrossOpenQty();
				double quantityConsumed = fcst.getQuantityConsumed(AllocationMode.FIRST_PASS);
				double quantityAllocated = fcst.getQtyAllocatedFirstPass();
				unallocated = fcst.getGrossOpenQty() - fcst.getQuantityConsumed(AllocationMode.FIRST_PASS) - fcst.getQtyAllocatedFirstPass();
				logger.debug("getUnnallocateQty List fcstGrp {}, getUnallocatedQty grossOpenQty={}, quantityConsumed={}, quantityAllocated={}, unallocated={}",
							forecastGroup, grossOpenQty,quantityConsumed,quantityAllocated,unallocated);
			}
			retval.add(unallocated);
		}
		return retval;
	}
	
	/**
	 * @return the forecastGroup
	 */
	public String getForecastGroup() {
		return forecastGroup;
	}

	public void setFcItemMast(FcItemMast fcItemMast) {
		if (fcItemMast == null) {
			throw new IllegalArgumentException("fcItemMast is null");
		}
		this.fcItemMast = fcItemMast;
	}
	
	public FcItemMast getFcItemMast() {
		return fcItemMast;
	}
	
	public void setIcItemMast(IcItemMast icItemMast) {
		if (icItemMast == null) {
			throw new IllegalArgumentException("icItemMast is null");
		}
		this.icItemMast = icItemMast;
	}
	
	public IcItemMast getIcItemMast() {
		return icItemMast;
	}

}
