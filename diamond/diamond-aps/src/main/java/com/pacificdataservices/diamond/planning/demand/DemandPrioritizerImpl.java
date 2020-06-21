package com.pacificdataservices.diamond.planning.demand;

import java.text.SimpleDateFormat;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.pacificdataservices.diamond.models.FcstGrp;

public class DemandPrioritizerImpl extends AbstractDemandPrioritizer implements DemandPrioritizer {

	public static final String revision = "$Revision: 1.2 $";

	private SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");

	Logger logger = LoggerFactory.getLogger(getClass());

	/**
	 * Constructs a priority String based on demand conditions.
	 * 
	 * Prioritizes based on
	 * <ol>
	 * <li>Demand is within lead time</li> 1 - demand is within lead time 2 -
	 * demand is after lead time
	 * <li>Forecast Group Type prioritization</li> Demand is within lead time
	 * uses the forecast group priority for the type of demand.<br/>
	 * Demands after lead time all use the priority for the forecast type of
	 * demand as this should not be a tie breaker at this point.</li>
	 * 
	 * @param demand
	 * @return String a computed priority code
	 */
	@Override
	public String getPriorityCode(Demand demand) {

		String retval = null;
		// check argument
		String demandType = demand.getDmdTypeCd();

		if (!(demandType.equals("OO") || demandType.equals("WO") || demandType.equals("SS")
				|| demandType.equals("FC"))) {
			throw new IllegalArgumentException("unknown type " + demandType);
		}

		StringBuilder b = new StringBuilder();
		b.append("TYPE:-");
		if ("WO".equals(demandType)) {
			b.append("1-WO-");
		} else if ("OO".equals(demandType)) {
			b.append("2-OO-");
		} else if ("SS".equals(demandType)) {
			b.append("3-SS");
		} else if ("FC".equals(demandType)) {
			b.append("4-FC");
		}
			
		// lead time
		b.append("LEADTIME:"); // within lead time
		if (demand.getWithinLeadTime()) {
			b.append("1"); // within lead time
		} else {
			b.append("2");
		}
		// demand priority
		b.append("-DMDPRTY:");
		b.append(getAsString(getDemandPriorityNumber(demand), 4));
		// 
		b.append("-NEEDBY:");
		b.append(dateFormatter.format(demand.getNeedByDate()));
		
		b.append("-");
		if (demand instanceof DemandForecast) {
			b.append("2FCSTGRPPRTY:");
			b.append(getAsString(demand.getDemandFcstGrp().getFcPrty(), 4));
			DemandForecast fcst = (DemandForecast) demand;
			b.append(dateFormatter.format(fcst.getRqstDt()));
			b.append("-FIM:");
			b.append(fcst.getFcItemMastNbr());
		} else {
			b.append("1DMDCD:");
			b.append(demand.getDmdCd());
		}
		return b.toString();

	}

	// TODO move to javautil-core
	private static String getAsString(long val, int digits) {
		StringBuffer buff = new StringBuffer();
		if (val < 0) {
			throw new IllegalArgumentException("val is negative");
		}
		String text = Long.toString(val);
		int pad = digits - text.length();
		if (pad < 0) {
			throw new IllegalArgumentException("val " + val + " has more than " + digits + " digits");
		}
		while (pad-- > 0) {
			buff.append("0");
		}
		buff.append(text);
		return buff.toString();
	}

	private static int getDemandPriorityNumber(Demand d) {
		int rc = 0;

		FcstGrp fcstGrp = d.getDemandFcstGrp();
		if (fcstGrp == null) {
			throw new IllegalStateException("fcstGrp is null for " + d);
		}
		if (d.getDmdTypeCd().equals("OO")) {
			rc = fcstGrp.getOoPrty();
		} else if (d.getDmdTypeCd().equals("WO")) {
			rc = fcstGrp.getWoPrty();
		} else if (d.getDmdTypeCd().equals("SS")) {
			rc = fcstGrp.getSsPrty();
		} else if (d.getDmdTypeCd().equals("FC")) {
			rc = fcstGrp.getFcPrty();
		}

		return rc;
	}
}
