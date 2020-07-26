package com.pacificdataservices.diamond.planning.supply.priority;

import java.text.SimpleDateFormat;

import org.javautil.buckets.DateHelper;
import org.javautil.text.StringUtils;

import com.pacificdataservices.diamond.planning.EligibleSupply;
import com.pacificdataservices.diamond.planning.data.PlanningData;
import com.pacificdataservices.diamond.planning.supply.Supply;


/**
 * Latest Supply prior to demand date
 * @author jjs
 *
 */
public class LatestOntimeAvailabilityDate implements EligibleSupplyPriorityRanker{
	// TODO need to make onhand lower priority if not within window 

//	private DateFormat YYYYMMDD = DateFormat.YYYYMMDD;
	
	// TODO this could be the number of days availability is before require date if avail before demand
	// B00010 available 10 days before demand
	// L00100 available 100 days after demand
	// L00200 available 200 days after demand
	// TODO use in execution
	private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyymmdd"); // TEST 
	@Override
	public String getPriority(EligibleSupply eligibleSupply,
			PlanningData planningData) {
				
		        int rc = 0;
		        Supply supply1 = eligibleSupply.getSupply();
		        java.util.Date availDate = supply1.getAdjustedAvailDate();
		        java.util.Date needByDate = eligibleSupply.getDemand().getNeedByDate();
		        int daysBetween = DateHelper.daysBetween(needByDate, availDate);
		        int absoluteDaysBetween = Math.abs(daysBetween);
		        
		        String absoluteDaysText = Integer.toString(absoluteDaysBetween);
		        String retval;
		        if (daysBetween < 1) {
		        	retval = "B" + StringUtils.leftPadWithChar(absoluteDaysText,5,"0");
		        } else {
		        	retval = "L" + StringUtils.leftPadWithChar(absoluteDaysText,5,"0");
		        }
	
		        return retval;
		      
		        
	}

}
