package com.pacificdataservices.diamond.planning.filter;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.pacificdataservices.diamond.planning.data.PlanningData;
import com.pacificdataservices.diamond.planning.demand.Demand;
import com.pacificdataservices.diamond.planning.supply.Supply;
import com.pacificdataservices.diamond.rules.CustomerItemManufacturerRules;

/**
 * If manufacturer is explicated in Demand the Supply must have been made by that Manufacturer.
 * 
 * If the customer has rules for Manufactures, see CustomerItemManufacturerRule
 * <ul>
 *   <li>Whitelist - must be one of the approved manufacturers.</li>
 *   <li>Blacklist - may not be one of the specified manufacturers.</li>
 * </ul>
 * @author jjs
 *
 */
public class CustomerItemManufacturerTest  extends AbstractSupplyEligibilityTest {

	private boolean trace = false;

	private Logger logger = LoggerFactory.getLogger(getClass());

	@Override
	public boolean isSupplyEligibleForDemand(Supply s, Demand d, PlanningData planningData) {

		Integer manufacturerNumber = s.getOrgNbrMfr();
		Integer itemNumber = d.getItemNbrDmd();
		Integer customerNumber = d.getOrgNbrCust();
		Date demandDate = d.getNeedByDate();

		logger.debug("cust: {} item {} mfr {} dmd dt {} ",customerNumber, itemNumber , manufacturerNumber , demandDate);
		Boolean retval = null;
		if (manufacturerNumber == null) {
			logger.warn("null mfr in supply {}\ndemand {}", s,d);
			if (s.isWorkOrder()) {
				retval = true;
			} else {
				// TODO should be done in PlanningData
				String message = String.format("mfr is null in supply %s", s.toString());
				logger.warn(message);
			}
		} 
		if (retval == null) {
			if (d.getOrgNbrMfrRqst() != null) {
				logger.debug("rqstMfr: {} mfr: {}",d.getOrgNbrMfrRqst(),s.getOrgNbrMfr());
				retval = d.getOrgNbrMfrRqst().equals(manufacturerNumber);
			} else {
				logger.debug("no explicit request for mfr");
				CustomerItemManufacturerRules cimr = planningData.getCustomerItemManufacturerRules();
				if (cimr == null) {
					retval = true;
				} else {
					if (manufacturerNumber == null) {
						if (cimr.getForCustItem(customerNumber, itemNumber).size() > 0) {
							String message = "Customer has manufacturer restrictions but unknown manufacturer for supply " + s;
							logger.error(message);
							retval = false;
						} else {
							logger.debug("cimr {} custNbr {} itemNbr {} mfrNbr {} demandDate {}", cimr,customerNumber, itemNumber, manufacturerNumber, demandDate);
							retval = cimr.isApprovedMfr(customerNumber, itemNumber, manufacturerNumber, demandDate);

						}
					}
					retval = cimr.isApprovedMfr(customerNumber, itemNumber, manufacturerNumber, demandDate);
				}

			} 
		}

		return retval;
	} 
}
