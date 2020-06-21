package com.pacificdataservices.diamond.planning.supply.priority;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.logging.Logger;

import org.javautil.buckets.DateHelper;

import com.pacificdataservices.diamond.models.ApsDmdSs;
import com.pacificdataservices.diamond.planning.AllocationMode;
import com.pacificdataservices.diamond.planning.EligibleSupply;
import com.pacificdataservices.diamond.planning.demand.Demand;
import com.pacificdataservices.diamond.planning.supply.Supply;
import com.pacificdataservices.diamond.planning.supply.SupplyReplen;
import com.pacificdataservices.diamond.planning.supply.SupplyWorkOrder;

public class EligibleSupplyRanker {
	private boolean trace = false;
	private StringBuffer logBuffer = new StringBuffer();
	private static final String className = "com.diamond9.planning.EligibleSupplyComparator";
	private static Logger logger = Logger.getLogger(className);
	private java.util.Date today = DateHelper.addDays(DateHelper.getDateMidnight(), 0);
	private java.util.Date tomorrow = DateHelper.addDays(DateHelper.getDateMidnight(), 1);
	private int lateReplenPaddingFactorDays = 60;
	private int allocToReplenWindow = 20;
	//private PlanningData planningData;
	private LinkedHashMap<String, String> tests;

	public EligibleSupplyRanker() {
	//	this.planningData = pd;
	}

	/**
	 * @todo : CODE TO FIGURE OUT WHAT TO DO IF NO VALUE IS FOUND FOR THE 2 AppCtl
	 *       Values
	 *
	 *       compare two supplies and prioritize based on
	 *       <ol>
	 *       <li><I>the sourcing rule -</I>Multiple sourcing rules may have the same
	 *       priority. This is useful when onhand and replenishments should be
	 *       equally considered with the planning availability date more important
	 *       than the supply type.</li>
	 *       <li>Priority for supply to Customer Orders within
	 *       <i>allocToReplenWindow</> is given to onhand inventory.</li>
	 *       <li><I>planning availability date - </I>the current vendor promise date
	 *       plus a "fudge amount" that is added to the current promise date based
	 *       on information from the vendor master. Once the date is established, it
	 *       is maintained manually to reflect on time certainty.
	 *       <ul>
	 *       <li>supply available prior to the requested ship date has higher
	 *       priority than late supply.</li>
	 *       <li>If two supplies are available prior to the requested ship date that
	 *       later supply has higher priority</li>
	 *       <li>If two supplies are both late, the earlier availability has higher
	 *       priority</li>
	 *       </ul>
	 *       </li>
	 *       <li><I>sum of attribute weight values - </I></li> 2003-06-13 If two
	 *       supplies for same lot and supply pool and facility both are transfers,
	 *       pick lower transfer.
	 *       </ol>
	 *
	 * @param p1 An EligibleSupply
	 * @param p2 An EligibleSupply
	 * @return
	 *         <ul>
	 *         <li>-1 p1 should be sourced before p2
	 *         <li>0 p1 and p2 are equivalent (should never happen as entries will
	 *         be thrown away from the TreeSet
	 *         <li>1 p2 should be sourced before p1
	 *         </ul>
	 */

	public String generatePriority(EligibleSupply p1) {


		Demand demand = p1.getDemand();
		Supply supply = p1.getSupply();
		java.util.Date thisDate = new java.util.Date();
		java.sql.Date today = DateHelper.toSqlDate(thisDate);

		// date the inventory is available for planning for supply1
		Date adjustedAvailDate = adjustAvailabilityDate(supply, today); // lateReplenPaddingFactorDays);
		String primaryFacility = demand.getPrimarySourcingFacility();
		tests = new LinkedHashMap<>();
		// TODO this violates the latest avail before replenishment
		if (supply.isOnhand()) {
			tests.put("TYPE:", "1-OH");
		}
		if (supply.isWorkOrder()) {
			tests.put("TYPE:", "2-WO");
		}
		if (supply.isPurchaseOrder()) {
			tests.put("TYPE:", "3-PO");
		}
		tests.put("RULE PRIORITY", String.format("%03d", p1.getSupplyPriority()));

		if (demand instanceof ApsDmdSs) {
			prioritizeSupplyForSafetyStock(supply, demand);
		}

		if (supply.isPurchaseOrder()) {
			String key = "PO-PRIME FACILITY";
			String value = supply.getFacility().equals(primaryFacility) ? "<" : ">";
			tests.put(key, value);
			tests.put("PO-AVAIL DT", adjustedAvailDate.toString());
		}

		tests.put("OH", supply.isOnhand() ? "<" : ">");
		if (supply.isOnhand()) {
			tests.put("PRIME FACILITY", supply.getFacility().equals(primaryFacility) ? "<" : ">");
/// TODO			
//			Integer transfer = supply.getPlannedTransferNbr();
//			Integer transferNumber = transfer == null ? new Integer(0) : transfer;
//			tests.put("TRANSFER", String.format("%08d", transferNumber));
			tests.put("CERT WEIGHT", String.format("%08d", supply.getCertValue()));
			tests.put("AVAIL QTY",String.format("%09.5f",supply.getAvailQty(AllocationMode.FIRST_PASS)));
			tests.put("LOT NBR", String.format("%08d", supply.getLotNbr()));
			// TODO still need a tiebreaker
			tests.put("Desparate break on Facility name ",supply.getFacility());
		}

		if (supply.isWorkOrder()) {
			SupplyWorkOrder swo = (SupplyWorkOrder) supply;
			tests.put("WORKORDER NBR", String.format("%08d", swo.getWoHdrNbr()));
		}
		tests.put("AVAILDATE", supply.getAvailDate().toString());
		if (supply.isPurchaseOrder()) {
			SupplyReplen sr = (SupplyReplen) supply;
			String key = "OeOrdDtlNbr" ;
			tests.put(key, String.format("%8d",sr.getPoLineDtlNbr()));
		}
		String priority = marshall(tests);
		return priority;
	}

	String marshall(LinkedHashMap<String, String> tests) {
		return tests.toString();
	}

	int onhandHasPriority(EligibleSupply es1, EligibleSupply es2) {
		int returnValue = 0;
		return returnValue;
	}


	/**
	 *
	 * The if condition below was written on 10/28/2004. This was in response to a
	 * request that a facility transfer coming into the facility should have a
	 * higher priority over the on-hand supply in a different facility
	 *
	 */
	int compareOnhandTransfers(EligibleSupply es1, EligibleSupply es2) {

		int rc = 0;

		Supply supply1 = es1.getSupply();
		Supply supply2 = es2.getSupply();
		Demand demand = es1.getDemand();
		Integer transfer1 = supply1.getPlannedTransferNbr();
		Integer transfer2 = supply2.getPlannedTransferNbr();
		String primaryFacility = demand.getPrimarySourcingFacility();

		if (supply1.getSplyTypeId().equals("O") && supply2.getSplyTypeId().equals("O")) {
			if (transfer1 != null && transfer2 == null) {
				if (supply1.getFacility().equals(primaryFacility) && !supply2.getFacility().equals(primaryFacility)) {
					rc = -1;
				} else {
					if (demand.getDmdTypeCd().equals("SS")) {
						rc = supply2.getLotNbr().intValue() - supply1.getLotNbr().intValue();
					} else {
						rc = 1;
					}
				}
			}

			if (transfer2 != null && transfer1 == null) {
				if (supply2.getFacility().equals(primaryFacility) && !supply1.getFacility().equals(primaryFacility)) {
					rc = 1;
				} else {
					if (demand.getDmdTypeCd().equals("SS")) {
						rc = supply2.getLotNbr().intValue() - supply1.getLotNbr().intValue();
					} else {
						rc = -1;
					}
				}
			}

			if (transfer1 != null && transfer2 != null) {
				if (supply1.getFacility().equals(primaryFacility) && supply2.getFacility().equals(primaryFacility)) {
					if (demand.getDmdTypeCd().equals("SS")) {
						rc = supply2.getLotNbr().intValue() - supply1.getLotNbr().intValue();
					} else {
						rc = transfer2.intValue() - transfer1.intValue();
					}
				}
			}
		}
		return rc;

	}

	/**
	 * compare two dates, with null dates collating after not null dates. This is
	 * useful when one lot has an expiration and the other does not the not
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

//	private int pastDueOnhand(EligibleSupply es1) {
//		int returnValue = 0;
//		Demand demand = es1.getDemand();
//		Supply supply = es1.getSupply();
//		Date date1 = supply.getAvailDate();
//		Date needByDate = demand.getNeedByDate();
//		Date tomorrowWithTime = DateHelper.addDays(DateHelper.getDateMidnight(), 1);
//		boolean supply1Planned = false;
//		java.sql.Date tomorrow = DateHelper.toSqlDate(tomorrowWithTime);
//		String primaryFacility = demand.getPrimarySourcingFacility();
//
//		if (supply.getSplyTypeId().equals("O") && date1.before(today)) {
//			date1 = tomorrow; /* TODO this is crazy need to alert */
//		}
//
//		boolean supply1Late = needByDate.compareTo(date1) == 1 ? false : true;
//		if (supply.getSplyTypeId().equals("O")) {
//			if (supply.getFacility().equals(primaryFacility)) {
//				tests.put("PRIMFACILITY", "<");
//				returnValue = compareLateAndDate(supply1Late, supply2Late, date1, date2);
//			} else {
//				tests.put("PRIMFACILITY", ">");
//			}
//		}
//		if (returnValue == 0) {
//			if (supply1Late) {
//				if (supply2Late) {
//					// if both are late, take the earlier one
//					returnValue = date1.compareTo(date2);
//				} else {
//					returnValue = 1;
//				}
//			} else {
//				if (supply2Late) {
//					// if only supply 2 late
//					returnValue = -1;
//				} else {
//					returnValue = date1.compareTo(date2);
//				}
//			}
//		}
//		/**
//		 * @todo clean this up
//		 */
//		if (supply.isOnhand()) {
//			SupplyOnhand onhand1 = (SupplyOnhand) supply;
//			supply1Planned = onhand1.getAvailDtId().equals("P");
//			if (returnValue == 0) {
//				if (supply1Planned && !supply2Planned) {
//					returnValue = -1;
//				}
//				if (returnValue == 0) {
//					if (supply2Planned && !supply1Planned) {
//						returnValue = 1;
//					}
//				}
//
//			}
//		}
//
//		return returnValue;
//
//	}

	/**
	 * This was added by Sriram on 9/1/2004 to make sure that on-hand inventory
	 * allocated to safety stock. Also, we have to make sure that newer inventory
	 * gets allocated to Safety Stock
	 *
	 * More changes were made to this on 10/29/2004. These changes required that the
	 * newer inventory that gets allocated to safety stock be restricted to the
	 * primary facility for the sourcing rule. There is no need to look across
	 * facilities to find the newest inventory.
	 */

	/**
	 * <ul>
	 * <li>Onhand has higher priority than not on hand
	 * 
	 * @param supply12
	 * @param es2
	 * @param demand
	 * @return
	 */

	void prioritizeSupplyForSafetyStock(Supply supply, Demand demand) {
		String primaryFacility = demand.getPrimarySourcingFacility();
		int returnValue = 0;
		StringBuilder sb = new StringBuilder();
		if (supply.isOnhand()) {
			tests.put("SSOH", "<");
		} else {
			tests.put("SSOH", ">");
			tests.put("PRIMFAC", supply.equals(primaryFacility) ? "<" : ">");
			tests.put("CERTWEIGHT", String.format("%3d", supply.getCertValue()));
			tests.put("LOTNBR", String.format("%8d", supply.getLotNbr()));
		}
	}

	Date adjustAvailabilityDate(Supply supply, java.util.Date today) { // int lateReplenPaddingFactorDays) {
		Date returnValue = supply.getAvailDate();
		if (supply instanceof SupplyReplen) {
			if (returnValue.before(today)) {
				returnValue = DateHelper.toSqlDate(DateHelper.addDays(today, lateReplenPaddingFactorDays));
			}
		}
		return returnValue;
	}

}
