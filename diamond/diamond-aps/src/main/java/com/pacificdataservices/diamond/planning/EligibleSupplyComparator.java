package com.pacificdataservices.diamond.planning;

import java.util.Comparator;
import java.util.Date;

import org.javautil.buckets.DateHelper;
import org.javautil.util.Day;

import com.pacificdataservices.diamond.models.ApsDmdSs;
import com.pacificdataservices.diamond.planning.data.PlanningData;
import com.pacificdataservices.diamond.planning.demand.Demand;
import com.pacificdataservices.diamond.planning.supply.Supply;
import com.pacificdataservices.diamond.planning.supply.SupplyOnhand;
import com.pacificdataservices.diamond.planning.supply.SupplyWorkOrder;

//import org.slf4j.Logger;

/**
 * @TODO document app_ctl
 * @TODO instantiate with a demand and eliminate EligibleSupply class
 * @TODO eliminate logic for past due supply as they are both currently adjusted
 */
class EligibleSupplyComparator implements Comparator<EligibleSupply> {
	public static final String revision = "$Revision: 1.2 $";
	private PlanningData planningData;
	  private boolean trace = false;
	    private StringBuffer logBuffer;
	    private java.util.Date tomorrow = DateHelper.addDays(DateHelper.getDateMidnight(), 1);
	    private int allocToReplenWindow =  0; // TODO WTF is this El Crap?
    EligibleSupplyComparator(PlanningData planningData) {
    	this.planningData = planningData;
    }
    
    /**
     * @TODO : CODE TO FIGURE OUT WHAT TO DO IF NO VALUE IS FOUND FOR THE 2 AppCtl Values
     *
     * compare two supplies and prioritize based on
     * <ol>
     *    <li><I>the sourcing rule -</I>Multiple sourcing rules may have the same
     *         priority.  This is useful when onhand and replenishments should
     *         be equally considered with the planning availability date more important
     *         than the supply type.
     *     </li>
     *     <li>Priority for supply to Customer Orders within <i>allocToReplenWindow</> is
     *         given to onhand inventory.</li>
     *    <li><I>planning availability date -  </I>the current vendor promise date plus a "fudge amount" that is
     *            added to the current promise date based on information from the vendor master.  Once the date is
     *            established, it is maintained manually to reflect on time certainty.
     *         <ul>
     *            <li>supply available prior to the requested ship date has
     *                higher priority than late supply.</li>
     *            <li>If two supplies are available prior to the requested ship date
     *                that later supply has higher priority</li>
     *            <li>If two supplies are both late, the earlier availability has higher priority</li>
     *         </ul>
     *     </li>
     *    <li><I>sum of attribute weight values - </I>
     *     </li>
     *     2003-06-13 If two supplies for same lot and supply pool and facility both are transfers, pick lower transfer.
     * </ol>
     *
     * @param p1     An EligibleSupply
     * @param p2     An EligibleSupply
     * @return <ul>
     *         <li> -1 p1 should be sourced before p2
     *         <li> 0  p1 and p2 are equivalent (should never happen as entries will be thrown away from the TreeSet
     *         <li> 1  p2 should be sourced before p1
     *         </ul>
     */
    @Override
	public int compare(EligibleSupply es1, EligibleSupply es2) {
        
        if (trace) {
            logBuffer = new StringBuffer();
        }
        
        int rc = 0;
        // check arguments
        Supply supply1 = es1.getSupply();
        Supply supply2 = es2.getSupply();
        
        java.util.Date today = planningData.getEffectiveDate();
        if (today == null) {
        	today = new Day();
        }
        /**
         * date the inventory is available for planning for supply1
         */
        Date date1 = supply1.getAdjustedAvailDate() == null ? supply1.getAvailDate() : supply1.getAdjustedAvailDate();
        Date date2 = supply2.getAdjustedAvailDate() == null ? supply2.getAvailDate() : supply2.getAdjustedAvailDate();
        Demand demand = es1.getDemand();
        Date needByDate = es1.getDemand().getNeedByDate();
        
        int testNumber = 1;
        
        int daysBetween;
        String primaryFacility = demand.getPrimarySourcingFacility();
        // compare on sourcing priority
        rc = compareSourcingRulePriority(es1, es2);
        testNumber++;
        //
        // Priority for supply to Customer Orders within <i>allocToReplenWindow</> is given to onhand inventory
        //
        /**
         * todo why not work orders or safety stock?
         * This window should change based on lead time
         */
        if (rc == 0) {
        	if (needByDate == null || today == null) {
        		throw new IllegalStateException("needByDate is " + needByDate + " today " + today);
        	}
            if (demand.isCustomerOrder() || demand.isForecast()) {
                daysBetween = DateHelper.daysBetween(today, needByDate);
                if (daysBetween < allocToReplenWindow) {
                    rc = onhandHasPriority(supply1, supply2);
                }
            }
            testNumber++;
            
            //
            if (rc == 0) {
                if (supply1.isOnhand() && !(supply2.isOnhand())) {
                    if (DateHelper.daysBetween(date2, needByDate) > allocToReplenWindow) {
                        rc = 1;
                    } else {
                        rc = -1;
                    }
                }
                testNumber++;
            }
            
            if (rc == 0) { //
                if (supply2.isOnhand() && !(supply1.isOnhand())) {
                    
                    if (DateHelper.daysBetween(date1, needByDate) > allocToReplenWindow) {
                        rc = -1;
                    } else {
                        rc = 1;
                    }
                }
                testNumber++;
            }
        }
        
        if (rc == 0) {
            if (demand instanceof ApsDmdSs) {
                rc = prioritizeSupplyForSafetyStock(es1, es2, demand);
            }
            testNumber++;
        }
        /**
         * This was added on 10/28/2004 to make sure that transfers coming into a facility have
         * a higher priority as compared to the inventory in other facilities.
         */
        // TODO FEATURE
//        if (rc == 0) {
//            rc = compareOnhandTransfers(es1, es2);
//            testNumber++;
//        }
        
        if (rc == 0) {
            rc = pastDueOnhand(es1,es2);
            testNumber++;
        }

        /*
        if (rc == 0) {
            Integer transfer1 = supply1.getPlannedTransferNbr();
            Integer transfer2 = supply2.getPlannedTransferNbr();
            
            if (transfer1 == null && transfer2 != null) {
                rc = -1;
            }
            if (transfer2 == null && transfer1 != null) {
                rc = 1;
            }
            
            if (transfer1 != null && transfer2 != null) {
                rc = transfer2.intValue() - transfer1.intValue();
            }
            testNumber++;
        }
        */
        
        if (rc == 0) {
            rc = compareCertWeighting(es1, es2);
            testNumber++;
        }
        
        /**
         * Before we go to the meaningless tie breaker incase of different
         * supply types, we give priority to On-Hand supply over replenishment
         * or Work Orders
         */
        if (rc == 0) {
            if (supply1.isOnhand()  && !(supply2.isOnhand())) {
                rc = -1;
                testNumber++;
            }
        }
        
        if (rc == 0) {
            if (supply2.isOnhand() && !supply1.isOnhand()) {
                rc = 1;
                testNumber++;
            }
        }
        
        /** 5/19/2005
         * We are now providing for the ability for stock and PO's across
         * facilities to have the same priority. If the same lot number exists
         * in 2 facilities with the same priority, the one in the primary
         * facility takes precedence. Same holds true for PO's
         */
        if (rc == 0) {
            if (supply1.isOnhand() && supply2.isOnhand()) {
                if (supply1.getFacility().equals(primaryFacility) &&
                        !supply2.getFacility().equals(primaryFacility)) {
                    rc = -1;
                }
                if (supply2.getFacility().equals(primaryFacility) &&
                        !supply1.getFacility().equals(primaryFacility)) {
                    rc = 1;
                }
            }
            testNumber++;
        }
        
        if (rc == 0) {
            if (supply1.isPurchaseOrder() && supply2.isPurchaseOrder()) {
                if (supply1.getFacility().equals(primaryFacility) &&
                        !supply2.getFacility().equals(primaryFacility)) {
                    rc = -1;
                }
                if (supply2.getFacility().equals(primaryFacility) &&
                        !supply1.getFacility().equals(primaryFacility)) {
                    rc = 1;
                }
            }
            testNumber++;
        }
        
        
        /**
         * More comparisons were added by Sriram on 9/2/2004. This is because the compareTo
         * method for String was not comparing 2 Lot Numbers correctly. We are now using
         * compareTo only if we are left with no choice
         */
        if (rc == 0) {
            if (supply1.isOnhand() && supply2.isOnhand()) {
                rc = supply1.getLotNbr().intValue() - supply2.getLotNbr().intValue();
            }
        }
        
        /**
         * @TODO doesn't check which is closer to request date.
         */
        if (rc == 0) {
            if (supply1.isPurchaseOrder() && supply2.isPurchaseOrder()) {
                rc = date1.compareTo(date2);
            }
        }
        
        if (rc == 0) {
            if (supply1.isWorkOrder() && supply2.isWorkOrder()) {
            	SupplyWorkOrder w1 = (SupplyWorkOrder) supply1;
            	SupplyWorkOrder w2 = (SupplyWorkOrder) supply2;
            	rc = (int) (w1.getWoHdrNbr() -  w2.getWoHdrNbr());
            }
        }
        
        if (rc == 0) {
            rc = supply1.getSupplyIdentifier().compareTo(supply2.getSupplyIdentifier());
        }
        
        
        if (rc == 0) {
            rc = supply1.getAvailDate().compareTo(supply2.getAvailDate());
        }
        
        if (rc == 0 && es1 != es2) {
            throw new java.lang.IllegalStateException(
                    "EligibleSupplyComparator Failure\nsupply #1\n" +
                    es1.getSupply() +
                    "\nsupply #2\n" + es2.getSupply());
        }
        
        if (rc < 0) {
            rc = -1;
        } else if (rc > 0) {
            rc = 1;
        }
        
        return rc;
    }
    
    int compareCertWeighting(EligibleSupply es1, EligibleSupply es2) {
        int rc = 0;
        int certPrty1 = es1.getSupply().getCertValue();
        int certPrty2 = es2.getSupply().getCertValue();
        if (certPrty1 < certPrty2) {
            rc = -1;
            if (trace) {
                logReason("certPrty1: " + certPrty1 + " certPrty2: " + certPrty2);
            }
        }
        if (certPrty1 > certPrty2) {
            rc = 1;
            if (trace) {
                logReason("certPrty1: " + certPrty1 + " certPrty2: " + certPrty2);
            }
        }
        return rc;
    }
    
    int compareSourcingRulePriority(EligibleSupply es1, EligibleSupply es2) {
   
        int priority1 = es1.getSupplyPriority();
        int priority2 = es2.getSupplyPriority();
        return priority1 - priority2;
    
    }
    
    int compareAvailDate(Supply supply1, Supply supply2,
            java.util.Date needByDate) {
        int rc = 0;
//        Integer transfer1 = supply1.getPlannedTransferNbr();
//        Integer transfer2 = supply2.getPlannedTransferNbr();
        java.util.Date date1 = supply1.getAvailDate();
        java.util.Date date2 = supply2.getAvailDate();
        boolean supply1Late;
        boolean supply2Late;
        //java.util.Date tomorrow = DateHelper.addDays(DateHelper.getDateMidnight(),1);
        // TODO FEATURE
//        if (transfer1 != null && date1.before(tomorrow)) {
//            date1 = tomorrow;
//        }
//        if (transfer2 != null && date2.before(tomorrow)) {
//            date2 = tomorrow;
//        }
        
        supply1Late = needByDate.compareTo(date1) == 1 ? false : true;
        supply2Late = needByDate.compareTo(date2) == 1 ? false : true;
        if (supply1Late) {
            if (supply2Late) {
                // if both are late, take the earlier one
                rc = date1.compareTo(date2);
            } else {
                rc = 1;
            }
        } else {
            if (supply2Late) {
                // if only supply 2 late
                rc = -1;
            } else {
                //
                rc = date2.compareTo(date1);
                //rc = 1;
            }
        }
        if (rc != 0) {
            if (trace) {
                logReason("compareAvailDate: " + date1 + " " + date2 + " " +
                        needByDate);
            }
        }
        return rc;
        
    }
    
    /**
     * Added by Sriram on 8/31/2004 to compare the avail date of 2 supplies.
     * This is a copy of the method CompareAvailDate above. But takes 2 extra
     * parameters. The 2 extra date parameters are the new AvailDates for the
     * Supplies adjusted for Late Replens
     */
    int compareAvailDate(EligibleSupply es1, EligibleSupply es2) {
        int returnValue = 0;
        returnValue  = pastDueOnhand(es1,es2);
        return returnValue;
    }
    
    /**
     *
     *	The if condition below was written on 10/28/2004. This was in response to a request that
     *	a facility transfer coming into the facility should have a higher priority over the on-hand
     *	supply in a different facility
     *
     */
    int compareOnhandTransfers(EligibleSupply es1, EligibleSupply es2
            ) {
        
        int rc = 0;
        
        Supply supply1 = es1.getSupply();
        Supply supply2 = es2.getSupply();
        Demand demand = es1.getDemand();
        Integer transfer1 = supply1.getPlannedTransferNbr();
        Integer transfer2 = supply2.getPlannedTransferNbr();
        String primaryFacility = demand.getPrimarySourcingFacility();
        
        if (supply1.getSplyTypeId().equals("O") &&
                supply2.getSplyTypeId().equals("O")) {
            if (transfer1 != null && transfer2 == null) {
                if (supply1.getFacility().equals(primaryFacility) &&
                        !supply2.getFacility().equals(primaryFacility)) {
                    rc = -1;
                } else {
                    if (demand.getDmdTypeCd().equals("SS")) {
                        rc = supply2.getLotNbr().intValue() -
                                supply1.getLotNbr().intValue();
                    } else {
                        rc = 1;
                    }
                }
            }
            
            if (transfer2 != null && transfer1 == null) {
                if (supply2.getFacility().equals(primaryFacility) &&
                        !supply1.getFacility().equals(primaryFacility)) {
                    rc = 1;
                } else {
                    if (demand.getDmdTypeCd().equals("SS")) {
                        rc = supply2.getLotNbr().intValue() -
                                supply1.getLotNbr().intValue();
                    } else {
                        rc = -1;
                    }
                }
            }
            
            if (transfer1 != null && transfer2 != null) {
                if (supply1.getFacility().equals(primaryFacility) &&
                        supply2.getFacility().equals(primaryFacility)) {
                    if (demand.getDmdTypeCd().equals("SS")) {
                        rc = supply2.getLotNbr().intValue() -
                                supply1.getLotNbr().intValue();
                    } else {
                        rc = transfer2.intValue() - transfer1.intValue();
                    }
                }
            }
        }
        return rc;
        
    }
    /**
     * compare two dates, with null dates collating after not null dates.
     * This is useful when one lot has an expiration and the other does not
     * the not
     */
    static int compareDateNullHigh(java.sql.Date date1, java.sql.Date date2) {
        int rc = 0;
        while (true) {
            if (date1 == null && date2 == null) {
                rc = 0;
                break;
            }
            
            if (date1 == null && date2 != null) {
                rc = -1;
                break;
            }
            
            if (date2 == null && date1 != null) {
                rc = 1;
                break;
            }
            
            rc = date1.compareTo(date2);
        }
        return rc;
        
    }
    
    private void logReason(String message) {
        logBuffer.append(message);
    }
    
    int onhandHasPriority(Supply supply1, Supply supply2) {
        int returnValue = 0;
        if (supply1 instanceof SupplyOnhand &&
                !(supply2 instanceof SupplyOnhand)) {
            returnValue = -1;
            if (trace) {
                logReason("daysBetween < " + allocToReplenWindow +
                        " onhand and replen");
                logReason("db1 " + supply1.getSupplyIdentifier() + " is Oh and " +
                        supply2.getSupplyIdentifier() +
                        " is not. So using Supply1");
            }
        }
        if (returnValue == 0) {	//  sriram
            if ((supply2 instanceof
                    SupplyOnhand &&
                    !(supply1 instanceof
                    SupplyOnhand))) {
                returnValue = 1;
                //ruleFound = true;
                if (trace) {
                    logReason("daysBetween < " + allocToReplenWindow + " replen and onhand");
                    logReason("db2 " + supply2.getSupplyIdentifier() + " is Oh and " +
                            supply1.getSupplyIdentifier() +
                            " is not. So using Supply2");
                }
            }
        }
        return returnValue;
    }
    //
    /**
     * This method was written on 12/9/2005 to evaluate 2 supplies based on
     * their availability dates and based on if they are late or not
     */
    private static int compareLateAndDate(boolean supply1Late, boolean supply2Late,
            Date date1, Date date2) {
        int returnValue = 0;
        
        if (supply1Late) {
            if (supply2Late) {
                // if both are late, take the earlier one
                returnValue = date1.compareTo(date2);
            } else {
                returnValue = 1;
            }
        } else {
            if (supply2Late) {
                // if only supply 2 late
                returnValue = -1;
            } else {
                returnValue = date1.compareTo(date2);
            }
        }
        return returnValue ;
    }
    
    
    private int pastDueOnhand(EligibleSupply es1, EligibleSupply es2) {
        int returnValue = 0;
        Demand demand = es1.getDemand();
        Supply supply1 = es1.getSupply();
        Supply supply2  = es2.getSupply();
        Date date1 = supply1.getAvailDate();
        Date date2 = supply2.getAvailDate();
        Date needByDate = demand.getNeedByDate();
        String primaryFacility = demand.getPrimarySourcingFacility();
        
        boolean supply1Late = needByDate.compareTo(date1) == 1 ? false : true;
        boolean supply2Late = needByDate.compareTo(date2) == 1 ? false : true;
        if (supply1.getSplyTypeId().equals("O") && supply2.getSplyTypeId().equals("O")) {
            if (supply1.getFacility().equals(primaryFacility) && supply2.getFacility().equals(primaryFacility)) {
                returnValue = compareLateAndDate(supply1Late, supply2Late, date1, date2) ;
            }
            if (returnValue == 0) {
                if (supply1.getFacility().equals(primaryFacility) && !supply2.getFacility().equals(primaryFacility)) {
                    returnValue = -1 ;
                }
            }
            if (returnValue == 0) {
                if (supply2.getFacility().equals(primaryFacility) && !supply1.getFacility().equals(primaryFacility)) {
                    returnValue = 1 ;
                }
            }
        }
        if (returnValue == 0) {
            if (supply1Late) {
                if (supply2Late) {
                    // if both are late, take the earlier one
                    returnValue = date1.compareTo(date2);
                } else {
                    returnValue = 1;
                }
            } else {
                if (supply2Late) {
                    // if only supply 2 late
                    returnValue = -1;
                } else {
                    returnValue = date1.compareTo(date2);
                }
            }
        }
        /**
         * @TODO clean this up
         * if the date is null, it is planned and then a lower priority
         */
        if (supply1 instanceof SupplyOnhand && supply2 instanceof SupplyOnhand) {
            
            Date aDate1 = supply1.getAvailDate();
            Date aDate2 = supply1.getAvailDate();
            if (aDate1 == null && aDate2 != null) {
                returnValue = -1;
            }
            if (aDate1 != null && aDate2 == null ) {
                returnValue = 1;
            }
            if (aDate1 != null && aDate2 != null ) {
                returnValue = aDate1.compareTo(aDate2);
            }

        }
        
        return returnValue;
        
    }
    /**
     *  This was added by Sriram on 9/1/2004 to make sure that on-hand inventory
     *  allocated to safety stock. Also, we have to make sure that newer inventory
     *  gets allocated to Safety Stock
     *
     *  More changes were made to this on 10/29/2004. These changes required that the
     *  newer inventory that gets allocated to safety stock be restricted to the primary
     *  facility for the sourcing rule. There is no need to look across facilities to
     *  find the newest inventory.this.eligibleSupplies
     */
    
    int prioritizeSupplyForSafetyStock(EligibleSupply es1, EligibleSupply es2, Demand demand) {
        String primaryFacility = demand.getPrimarySourcingFacility();
        Supply supply1 = es1.getSupply();
        Supply supply2 = es2.getSupply();
        int returnValue = 0;
        if (supply1 instanceof SupplyOnhand &&  !(supply2 instanceof SupplyOnhand)) {
            returnValue = -1;
        }
        if (supply2 instanceof SupplyOnhand && !(supply1 instanceof SupplyOnhand)) {
            returnValue = 1;
        }
        if (supply1 instanceof SupplyOnhand &&  supply2 instanceof SupplyOnhand) {
            if (supply1.getFacility().equals(primaryFacility) &&
                    !supply2.getFacility().equals(primaryFacility)) {
                returnValue = -1;
            }
            if (supply2.getFacility().equals(primaryFacility) &&
                    !supply1.getFacility().equals(primaryFacility)) {
                returnValue = 1;
            }
            if (returnValue == 0) {
                returnValue = compareCertWeighting(es1, es2);
            }
            if (returnValue == 0) {
                returnValue = supply1.getIdentifierString().compareTo(supply2.getIdentifierString());
            }
        }
        return returnValue;
    }
    
  
}
