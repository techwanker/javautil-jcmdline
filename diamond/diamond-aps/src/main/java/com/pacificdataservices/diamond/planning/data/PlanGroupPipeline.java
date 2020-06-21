package com.pacificdataservices.diamond.planning.data;




import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

//import org.javautil.buckets.DateGenerator;
import org.javautil.buckets.DateHelper;
import org.javautil.core.misc.Buckets;
import org.javautil.lang.ThreadHelper;
import org.javautil.util.DateGenerator;
import org.javautil.util.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.pacificdataservices.diamond.models.ApsResultDtlDmd;
import com.pacificdataservices.diamond.planning.PlanningDataException;
import com.pacificdataservices.diamond.planning.demand.Demand;
import com.pacificdataservices.diamond.planning.demand.DemandCustomer;
import com.pacificdataservices.diamond.planning.demand.DemandForecast;
import com.pacificdataservices.diamond.planning.demand.ForecastGroups;
import com.pacificdataservices.diamond.planning.supply.Supply;
import com.pacificdataservices.diamond.planning.supply.SupplyReplen;

/**
 * Section
 *     Supply
 *          Supply Type,  Facility, Subpool
 *     Demand 
 *          Demand Type, Forecast Group
 *          
 *     Position
 *          Forecast Group, 
 * @author jim
 */
public class PlanGroupPipeline {
	private transient Logger logger = LoggerFactory.getLogger(getClass());

	private String nbsp = " ";
	private transient PlanningData data;
	private transient DateGenerator buckets;
	private ArrayList<Date> dateBuckets;
	private ArrayList<String> bucketNames = new ArrayList<String>();

	private transient LinkedHashMap<String, ArrayList<Supply>> bucketedSupplyOnhand = new LinkedHashMap<String, ArrayList<Supply>>();
	private transient LinkedHashMap<String, ArrayList<Supply>> bucketedSupplyReplen = new LinkedHashMap<String, ArrayList<Supply>>();
	private transient LinkedHashMap<String, ArrayList<Supply>> bucketedSupplyWorkorder = new LinkedHashMap<String, ArrayList<Supply>>();
	private transient LinkedHashMap<String, ArrayList<Demand>> bucketedCustomerDemand = new LinkedHashMap<String, ArrayList<Demand>>();
	private transient LinkedHashMap<String, ArrayList<Demand>> bucketedForecastDemand = new LinkedHashMap<String, ArrayList<Demand>>();
	private transient LinkedHashMap<String, ArrayList<Demand>> bucketedWorkorderDemand = new LinkedHashMap<String, ArrayList<Demand>>();
	// TreeMap<String, ArrayList<Allocation>> bucketedAllocations;
	private transient LinkedHashMap<String, ArrayList<ApsResultDtlDmd>> bucketedApsResultDtlDmd;


	private List<PipelineLine> supplyLines = new ArrayList<PipelineLine>();
	private List<PipelineLine> demandLines = new ArrayList<PipelineLine>();

	private PipelineLine allocationLine;	

//	private transient SimpleDateFormat sdf = new SimpleDateFormat(SimpleDateFormats.ISO8601_date_pretty);

	private String beforeBucketName = "Past" + nbsp + "Due";

	private String afterBucketName = "Later";


	
	/** Creates a new instance of PlanGroupSnapshot */
	public PlanGroupPipeline(PlanningData planningData) {
		this.data = planningData;
		if (data.getApsResultDtlDmds() == null) {
			String stackString = ThreadHelper.getStackTraceAsString();
			String message = "PlanGroupPipeLapsResultDtlDmds is null in planning data\n" + stackString;
			logger.error(message);
			throw new PlanningDataException(message);
		}
		process();
	}
	
	// TO
	public String stackTraceToString() {
			StackTraceElement[] stack = Thread.currentThread().getStackTrace();
			StringBuilder sb = new StringBuilder();
			for (int i = 2; i < stack.length; i++) {
				sb.append(stack[i].toString());
				sb.append("\n");
			}
			return sb.toString();
	}

	public void process() {
		buildBuckets(); 
		//
		initializeBucketed(bucketedSupplyOnhand);
		initializeBucketed(bucketedSupplyReplen);
		initializeBucketed(bucketedSupplyWorkorder);
		//
		initializeBucketed(bucketedCustomerDemand);
		initializeBucketed(bucketedForecastDemand);
		initializeBucketed(bucketedWorkorderDemand);
		//
		bucketDemands(data.getDemandCustomerById().values(),bucketedCustomerDemand); 
		bucketDemands(data.getDemandWorkOrders(),bucketedWorkorderDemand);
		bucketDemands(data.getDemandForecastById().values(),bucketedForecastDemand);
		bucketSupply(data.getSupplyOnhandById().values(),bucketedSupplyOnhand);
		bucketSupply(data.getSupplyReplenById().values(),bucketedSupplyReplen);
		bucketSupply(data.getSupplyWorkOrderById().values(),bucketedSupplyWorkorder);
		//		bucketedAllocations = bucketAllocations(data.getSupplyWorkOrderById().values());
		//
		//
		bucketedApsResultDtlDmd = bucketApsResultDtlDmd(data.getApsResultDtlDmds());

		supplyLines.add(supplySumPipeline("Supply","Purchase" + nbsp + "Orders",bucketedSupplyReplen));
		PipelineLine swo = supplySumPipeline("Supply","Work" + nbsp + "Orders", bucketedSupplyWorkorder);
		if (swo.sumValues() > 0) {
			supplyLines.add(swo);
		}
		supplyLines.add(supplySumPipeline("Supply","Onhand", bucketedSupplyOnhand));
		//
		demandLines.add(demandSumPipeline("Demand","Customer" + nbsp + "Orders", bucketedCustomerDemand));
		demandLines.add(getForecastPipelineLine());
		//demandLines.add(demandSumPipeline("Demand","Forecast", bucketedForecastDemand));
		PipelineLine dwo =demandSumPipeline("Demand","Work" + nbsp + "Orders", bucketedWorkorderDemand);
		if (dwo.sumValues() > 0) {
			demandLines.add(dwo);
		}
		
		allocationLine =  aardSumPipeline("Allocations","Allocations", bucketedApsResultDtlDmd);
	}

	
	// TODO
	@Deprecated // now in PlanningData
	private void buildBuckets() {
		java.util.Date firstDayThisMonth = DateUtils.getFirstDateInMonth(data.getEffectiveDate());
		Date maxDate = getMaxDate();
		int monthsBetween = DateUtils.monthsBetween(firstDayThisMonth, maxDate);
		buckets = new DateGenerator();
		buckets.setFirstDate(firstDayThisMonth);
		buckets.setIncrementInMonths(1);
		buckets.generateBuckets(monthsBetween + 1);
		dateBuckets = new ArrayList<Date>();
		bucketNames.add(beforeBucketName);
		for (Iterator<Date> dateIterator = buckets.getDateIterator(); dateIterator.hasNext();) {
			Date dt = dateIterator.next();
			dateBuckets.add(dt);
			String bucketName = DateHelper.toYyMmDd(dt);
			bucketNames.add(bucketName);
			// logger.info("############  added bucket {} ", bucketName);
		}
		logger.info("bucketNames: {}", bucketNames);
	}

	void initializeBucketed(Map<String,? extends Object> tree ) {
		for (String bucketName : bucketNames) {
			tree.put(bucketName,null);
		}
	}

	Date getMaxDate() {
		Date maxDate = new Date();
		for (SupplyReplen po : data.getSupplyReplenById().values()) {
			if (po.getAvailDt().after(maxDate)) {
				maxDate = po.getAvailDate();
			}
		}
		for (DemandForecast fc : data.getDemandForecastById().values()) {
			if (fc.getNeedByDate().after(maxDate)) {
				maxDate = fc.getNeedByDate();
			}
		}
		for (DemandCustomer dc : data.getDemandCustomerById().values()) {
			if (dc.getNeedByDate().after(maxDate)) {
				maxDate = dc.getNeedByDate();
			}
		}
		return maxDate;
	}

	private void bucketDemands(Collection<? extends Demand> demands, Map<String,ArrayList<Demand>> bucketMap) {
		for (Demand demand : demands) {
			String needDtBucket = getBucket(demand.getNeedByDate());
			ArrayList<Demand> demandBucket = bucketMap.get(needDtBucket);
			if (demandBucket == null) {
				demandBucket = new ArrayList<Demand>();
				bucketMap.put(needDtBucket, demandBucket);
			}
			demandBucket.add(demand);
		}
	}

	private void bucketSupply(Collection<? extends Supply> supplies, Map<String,ArrayList<Supply>> bucketMap) {
		for (Supply supply : supplies) {
			String dtBucket = getBucket(supply.getAvailDate());
			ArrayList<Supply> bucket = bucketMap.get(dtBucket);
			if (bucket == null) {
				bucket = new ArrayList<Supply>();
				bucketMap.put(dtBucket, bucket);
			}
			logger.debug("bucketing bucket: {} supply: {}", dtBucket, supply);
			bucket.add(supply);
		}
	}

	private LinkedHashMap<String,ArrayList<ApsResultDtlDmd>> bucketApsResultDtlDmd(Collection<ApsResultDtlDmd> ardds ) {
		LinkedHashMap<String,ArrayList<ApsResultDtlDmd>> bucketMap= new LinkedHashMap<String,ArrayList<ApsResultDtlDmd>>();
		initializeBucketed(bucketMap);

		for (ApsResultDtlDmd ardd : ardds) {
			logger.debug("examining: {}", ardd);
			if (ardd.getAllocQty() != null && ardd.getAllocQty().doubleValue() > 0) {
				Date allocationDate = ardd.getRqstDt().after(ardd.getAvailDt()) ? ardd.getRqstDt() : ardd.getAvailDt();
				String dtBucket = getBucket(allocationDate);
				ArrayList<ApsResultDtlDmd> bucket = bucketMap.get(dtBucket);
				if (bucket == null) {
					bucket = new ArrayList<ApsResultDtlDmd>();
					bucketMap.put(dtBucket, bucket);
				}
				bucket.add(ardd);
			}
		}
		return bucketMap;
	}

	private String getBucket(java.util.Date date) {
		String retval;
		int domain = buckets.getBucketDomain(date);
		switch (domain) {
		case -1:
			retval = beforeBucketName;
			break;
		case 0:
			Date bucketDate = buckets.getBucketDate(date);
			retval = DateHelper.toYyMmDd(bucketDate);
			break;
		case 1:
			retval = afterBucketName;
			break;
		default:
			throw new IllegalStateException("unknown bucket error");
		}
		return retval;
	}


	
	private PipelineLine aardSumPipeline(String string, String string2, Map<String, ArrayList<ApsResultDtlDmd>> bucketMap) {
		PipelineLine rv  = new PipelineLine(string,string2);
		for (String key : bucketMap.keySet()) {
			double sum = 0.0;
			List<ApsResultDtlDmd> aards = bucketMap.get(key);
			if (aards != null) {
				for (ApsResultDtlDmd a : aards) {
					sum += a.getAllocQty().doubleValue();
				}
			}
			logger.debug("aardSum processing key: {} sum: {} " ,key, sum);
			rv.put(key,new Double(sum));
		}
		return rv;
	}


	private PipelineLine getForecastPipelineLine() {
		PipelineLine rv  = new PipelineLine("Demand","Forecast");
		ForecastGroups groups = data.getForecastGroups();
		Buckets<Double> buckets = groups.getUnallocatedBuckets();
	//	PipelineLine forecastLine = new PipelineLine("Demand","Forecast"); 
		LinkedHashMap<String, Double> bucketMap = buckets.getBucketMap(true,false);
		for (String k : bucketMap.keySet()) {
			rv.put(k,bucketMap.get(k));
		}
		return rv;
		
	}
	private PipelineLine supplySumPipeline(String string, String string2,
			Map<String, ArrayList<Supply>> bucketMap) {
		
		logger.info("supplySumPipeline {}", string2);
		PipelineLine rv  = new PipelineLine(string,string2);
		for (String key : bucketMap.keySet()) {
			double sum = 0.0;
			List<Supply> supplies = bucketMap.get(key);
			if (supplies != null) {
				for (Supply s : supplies) {
					sum += s.getGrossAvailQty().doubleValue();
			//		logger.debug("supplySum processing: {} qty: {}, key: {} sum: {} " ,s.getAvailDate(), s.getGrossAvailQty(), key, sum);
				}
			} else {
				logger.debug("no supply for: {}",key);
			}
			rv.put(key,new Double(sum));
		}
		return rv;
	}

	private PipelineLine demandSumPipeline(String string, String string2, Map<String, ArrayList<Demand>> bucketMap) {
		List<Double> retval = new ArrayList<Double>(bucketMap.size());
		PipelineLine rv  = new PipelineLine(string,string2);
		for (String key : bucketMap.keySet()) {
			double sum = 0.0;
			List<Demand> demands = bucketMap.get(key);
			if (demands != null) {
				for (Demand d : demands) {
					sum += d.getGrossOpenQty();
			//		logger.info("demandSumPipeline key: {} demand {}", key,d);
				}
			}
			rv.put(key,new Double(sum));
		}
		return rv;
	}
	

	public PipelineLine getAllocationLine() {
		return allocationLine;
	}

//	public List<PipelineLine> getForecastGroupLines() {
//		ArrayList<PipelineLine> retval =new ArrayList<PipelineLine>();
//		TreeMap<String,TreeMap<String,Double>> forecastGroups = getForecastGroups();
//		for (String key : forecastGroups.keySet()) {
//			//logger.info("creating forecastGroup str2 {}",key);
//			PipelineLine pl = new PipelineLine("FcstGrp",key);
//			
//			TreeMap<String,Double> forecast = forecastGroups.get(key);
//			for (String k : forecast.keySet()) {
//				pl.put(k,forecast.get(k));
//			}
//			retval.add(pl);
//		}
//		return retval;
//	}
//
//	public TreeMap<String,TreeMap<String,Double>> getForecastGroups() {
//		TreeMap<String,TreeMap<String,Double>> forecastGroups = new TreeMap<String,TreeMap<String,Double>>();
//		for (Demand d : data.getDemandForecastById().values()) {
//			TreeMap<String,Double> forecastGroup = forecastGroups.get(d.getFcstGrp());
//			if (forecastGroup == null) {
//				forecastGroup = new TreeMap<String,Double>();
//				forecastGroups.put(d.getFcstGrp(),forecastGroup);
//				for (String bucketName : bucketNames) {
//				//	logger.info("fcstGrp {} bucket {}",d.getFcstGrp(),bucketName);
//					forecastGroup.put(bucketName,0.0);
//				}
//			}
//			String bucketName = getBucket(d.getNeedByDate());
//			forecastGroup.put(bucketName,d.getGrossOpenQty());	
//		}
//		return forecastGroups;
//	}
//
//	public TreeSet<String> getFcstGroupNames() {
//		TreeSet<String> fcstGrpNames = new TreeSet<String>();
//		for (Demand d : data.getDemandForecastById().values()) {
//			fcstGrpNames.add(d.getFcstGrp());
//		}
//		return fcstGrpNames;
//	}

	/**
	 * @return the lines
	 */
	public List<PipelineLine> getSupplyLines() {
		return supplyLines;
	}

	public List<PipelineLine> getDemandLines() {
		return demandLines;
	}

	/**
	 * @return the bucketNames
	 */
	public ArrayList<String> getBucketNames() {
		return bucketNames;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("PlanGroupPipeline: \n");
		sb.append(bucketNames.toString());
		sb.append("\n");
		for (PipelineLine line : supplyLines) { 
			sb.append(line.toString());
			sb.append("\n");
		}
		for (PipelineLine line : demandLines) { 
			sb.append(line.toString());
			sb.append("\n");
		}
		sb.append(allocationLine.toString());
		return sb.toString();
	}
}
