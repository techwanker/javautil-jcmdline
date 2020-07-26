package com.pacificdataservices.diamond.planning.demand;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;

import org.javautil.text.SimpleDateFormatFactory;
import org.javautil.text.SimpleDateFormats;

import com.pacificdataservices.diamond.models.ApsDmdFc;
import com.pacificdataservices.diamond.planning.Allocation;
import com.pacificdataservices.diamond.planning.AllocationMode;

public class DemandForecast extends AbstractDemand {

	private LinkedHashMap<AllocationMode, Double> quantityConsumedByMode = new LinkedHashMap<AllocationMode, Double>();
	private LinkedHashMap<AllocationMode, ArrayList<Demand>> demandsByMode = new LinkedHashMap<AllocationMode, ArrayList<Demand>>();
	private int fcFcstNbr;
	//private transient SimpleDateFormat sdf; 
	private String id;
	public DemandForecast(ApsDmdFc demand, SimpleDateFormat sdf) {
		quantityConsumedByMode.put(AllocationMode.FIRST_PASS, 0.0);
		quantityConsumedByMode.put(AllocationMode.CUSTOMER_PRIORITIZED, 0.0);
		quantityConsumedByMode.put(AllocationMode.OVERSHIP, 0.0);
		demandsByMode.put(AllocationMode.FIRST_PASS, new ArrayList<Demand>());
		demandsByMode.put(AllocationMode.CUSTOMER_PRIORITIZED, new ArrayList<Demand>());
		demandsByMode.put(AllocationMode.OVERSHIP, new ArrayList<Demand>());
		
		setDmdCd(demand.getDmdCd());
		setDmdTypeCd(demand.getDmdTypeCd());
		setItemNbrDmd(demand.getItemNbrDmd());
		setFcItemMastNbr(demand.getFcItemMastNbr());
		setRqstDt(demand.getRqstDt());
		setApsSrcRuleSetNbr(demand.getApsSrcRuleSetNbr());
		setOrgNbrCust(demand.getOrgNbrCust());
		setOrgCdCust(demand.getOrgCdCust());
		setOpenQty(demand.getOpenQty());
		setRevLvl(demand.getRevLvl());
		setOrgNbrMfrRqst(demand.getOrgNbrMfrRqst());
		setFcstGrp(demand.getFcstGrp());
		fcFcstNbr = demand.getFcFcstNbr();
		id = getFcstGrp() + sdf.format(getRqstDt());
	}

	public double getQuantityToConsume(Demand dmd, AllocationMode mode) {
		double allocatedQty = getQuantityAllocated(mode);
		if (allocatedQty > 0) {
			StringBuilder sb = new StringBuilder();
			sb.append("cannot consume once allocation has started\n");
			for (Allocation allocation : getAllocations(mode)) {
				sb.append(String.format("qty=%f. supply %s\n",allocation.getAllocQty(),allocation.getSupply()));
			}
			throw new IllegalStateException(sb.toString());
		}
		double unconsumedQty = getGrossOpenQty() - quantityConsumedByMode.get(mode);
		double dmdQty = dmd.getGrossOpenQty();
		double quantityToConsume = (unconsumedQty >= dmdQty) ? dmdQty : unconsumedQty;
		double consumedQty = getQuantityConsumed(mode);
		logger.debug(
				"65 consuming: {}\ndemand:{}\nmode:{}\ndmdQty: {}, adjFcstQty:{}, prior consumed:{} unconsumedQty: {} qtyToConsume: {}",
				this, 
				dmd, 
				mode, 
				dmdQty, 
				getGrossOpenQty(), 
				consumedQty,
				unconsumedQty,
				quantityToConsume);
		return quantityToConsume;
	}

	public void consumeThisForecast(Demand dmd, AllocationMode mode) {
		if (dmd == null) {
			throw new IllegalArgumentException("dmd is null");
		}
		if (dmd.isForecastDemand() || dmd.isSafetyStockDemand()) {
			throw new IllegalArgumentException("Demand not of correct type: " + dmd.toString());
		}
		demandsByMode.get(mode).add(dmd);
		double quantityToConsume = getQuantityToConsume(dmd, mode);
		//
		double qtyConsumed = quantityConsumedByMode.get(mode) + quantityToConsume;
		quantityConsumedByMode.put(mode, qtyConsumed);
		if (logger.isDebugEnabled()) {
			SimpleDateFormat sdf = new SimpleDateFormat(SimpleDateFormats.ISO8601_date_pretty);
			String dmdDt = sdf.format(getRqstDt());
			logger.debug("mode: {} forecastGroup {} fcstQty {} date {} dmdQty {}, quantityConsumed", mode, getFcstGrp(),
					getGrossOpenQty(), dmdDt, dmd.getGrossOpenQty(), qtyConsumed);
		}
	}
	//
	// public void consumeForecast(AllocationMode mode) {
	// consumeThisForecast(getOpenQty().floatValue(), mode);
	// }

	public double getUnconsumedQty(AllocationMode mode) {
		return getGrossOpenQty() - quantityConsumedByMode.get(mode);
	}

	@Override
	public Date getNeedByDate() {
		return getRqstDt();
	}

	@Override
	public String summaryString() {
		return String.format("DemandForecast [fcItemMastNbr: %s rqstDt: %s openQty: %s, priority: %s]",
				getFcItemMastNbr(), getRqstDt(), getGrossOpenQty(), getPriorityCode());
	}

	@Override
	public String getIdentifier() {
		return "FIM:" + getFcItemMastNbr() + "-" + this.getRqstDt();
	}

	public static String getIdentifier(int fcItemMastNbr, Date fcstDt) {
		return fcItemMastNbr + fcstDt.toString();
	}

	@Override
	public boolean isForecastDemand() {
		return true;
	}

	@Override
	public String getDemandIdentifier() {
		SimpleDateFormat sdf = SimpleDateFormatFactory.getYyyyDashMmDashDd();
		return String.format("fcItemMastNbr: %d fcstDt: %s", getFcItemMastNbr(),sdf.format(getRqstDt()));
	}

	public int getFcFcstNbr() {
		return fcFcstNbr;
	}

	public double getQuantityConsumed(AllocationMode mode) {
		return quantityConsumedByMode.get(mode);
	}

	public double getQuantityUnconsumed(AllocationMode mode) {
		double retval = getGrossOpenQty() - getQuantityConsumed(mode);
		return retval;
	}

	public double getQuantityUnallocated(AllocationMode mode) {
		logger.debug("DemandForecast.unallocatedQty");
		double rc = -01;
		rc = getGrossOpenQty() - getQuantityConsumed(mode) - getAllocatedQty(mode);
		String message = null;
		if (rc < 0 || logger.isDebugEnabled()) {
			double grossOpenQty = getGrossOpenQty();
			double quantityConsumed= getQuantityConsumed(AllocationMode.FIRST_PASS);
			double quantityUnconsumed=getQuantityUnconsumed(AllocationMode.FIRST_PASS);
			double quantityAllocated=getQuantityAllocated(AllocationMode.FIRST_PASS);
			message = "DemandForecast ["
					+ "id= " + id  
					+ "grossGrossOpenQty=" + grossOpenQty
					+ "quantityConsumed=" + quantityConsumed
					+ "quantityUnconsumed=" + quantityUnconsumed
					+ "quantityAllocated=" + quantityAllocated
					+ "quantityUnallocated=" + rc 
					+  "]";
		}
		logger.debug("getQuantityUnallocated mode {} {}",mode, message);
		if (rc < 0) {
			logger.warn( "137 demand is overallocated {} ", message);
			rc = 0;
			if (mode != AllocationMode.OVERSHIP) {
				logger.warn("Zeroing unallocated qty from {} to {}", rc, 0.0);
			}
		}
		return rc;
	}

	public String getId() {
		return id;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String format() {
		double grossOpenQty = getGrossOpenQty();
		double quantityConsumed= getQuantityConsumed(AllocationMode.FIRST_PASS);
		double quantityUnconsumed=getQuantityUnconsumed(AllocationMode.FIRST_PASS);
		double quantityAllocated=getQuantityAllocated(AllocationMode.FIRST_PASS);
		double quantityUnallocated= getQuantityUnallocated(AllocationMode.FIRST_PASS);
		return "DemandForecast ["
				+ "id= " + id  
				+ "grossGrossOpenQty=" + grossOpenQty
				+ "quantityConsumed=" + quantityConsumed
				+ "quantityUnconsumed=" + quantityUnconsumed
				+ "quantityAllocated=" + quantityAllocated
				+ "quantityUnallocated=" + quantityUnallocated
				+  "]";
	}
}
