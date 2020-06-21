package com.pacificdataservices.diamond.planning.filter;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.pacificdataservices.diamond.planning.data.PlanningData;
import com.pacificdataservices.diamond.planning.demand.Demand;
import com.pacificdataservices.diamond.planning.demand.DemandCustomer;
import com.pacificdataservices.diamond.planning.supply.Supply;

public class ExpiryDateTest extends AbstractSupplyEligibilityTest {
	private Logger logger = LoggerFactory.getLogger(getClass());

	@Override
	public boolean isSupplyEligibleForDemand(Supply supply, Demand demand, PlanningData planningData) {
		Boolean retval = null; // autoboxing force to blow up if not assigned
		if (demand instanceof DemandCustomer) {
			DemandCustomer dmd = (DemandCustomer) demand;
			Date dmdExpireOnOrAfter = dmd.getLotNotExpireBeforeDt();
			Date supplyExpiredDate = supply.getExpireDt();

			if (dmdExpireOnOrAfter != null) {
				// TODO format for deffered string handling and make debug
				logger.debug("demand LotNotExpireBefore: " + dmdExpireOnOrAfter);
				logger.debug("demand supply: " + supplyExpiredDate);

				if (supplyExpiredDate == null) {
					retval = Boolean.FALSE;
				} else {

					if (dmdExpireOnOrAfter.before(supplyExpiredDate)) {
						retval = Boolean.TRUE;
					} else {
						retval = Boolean.FALSE;
					}
				}
			} else {
				retval = Boolean.TRUE;
			}
		} else {
			retval = Boolean.TRUE;
		}

		if (retval == null) {
			throw new IllegalStateException("logic error");
		}
		return retval.booleanValue();

	}
}
