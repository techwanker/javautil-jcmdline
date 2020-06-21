package com.pacificdataservices.diamond.planning.filter;

import com.pacificdataservices.diamond.models.OeCustMast;
import com.pacificdataservices.diamond.models.OeCustMfr;
import com.pacificdataservices.diamond.planning.container.CustomerItemManufacturers;
import com.pacificdataservices.diamond.planning.data.PlanningData;
import com.pacificdataservices.diamond.planning.demand.Demand;
import com.pacificdataservices.diamond.planning.demand.DemandCustomer;
import com.pacificdataservices.diamond.planning.supply.Supply;

/**
 * Test to see whether the supplier manufacturer complies with the customer
 * requirements.
 * 
 * This is difficult as the customer may specify that a part comply with more
 * than one engineering drawing, that is be certified to be more than one part
 * number. We refer to this as a multi-part-cert. In actuality the receiver
 * number is accompanied by a manufacturer's certificate of compliance for more
 * than one engineering diagram.
 * 
 * The fun begins when the customer has restrictions on which manufacturers he
 * trusts for a specific part.
 * 
 * If for example a part is acceptable under the 'AN' (U.S. Army-Navy) drawings
 * for one manufacturer and under the 'NAS' (National Airspace System) under a
 * different manufacturer, it is likely that the customer will trust the
 * manufacturer for certifying the other part.
 * 
 * In actuality this situation arises for contractors that service multiple
 * consumers or distributors.
 * 
 * 
 * In all probability if the manufacturer is trusted by the customer, the setup
 * rule is wrong.
 * 
 * @author jjs
 * 
 */
public class ManufacturerTest extends AbstractSupplyEligibilityTest {

	@Override
	public boolean isSupplyEligibleForDemand(Supply s, Demand d, PlanningData planningData) {
		Boolean retval = null;

		if (d instanceof DemandCustomer) {

			DemandCustomer demand = (DemandCustomer) d;

			Integer explicitDemandManufacturer = demand.getOrgNbrMfrRqst();

			if (explicitDemandManufacturer != null) { // a specific manufacturer
														// is
														// required for this
														// demand
				Integer supplyMfrNbr = s.getOrgNbrMfr();

				retval = explicitDemandManufacturer.equals(supplyMfrNbr);

			} else {
				OeCustMast cust = demand.getOeCustMast();
				Integer supplyItemNbr = s.getIcItemMast().getItemNbr();
				Integer supplyMfr = s.getOrgNbrMfr();
				CustomerItemManufacturers cim = planningData.getCustomerItemManufacturers();
				// TODO write more tests
				if (cim.hasManufacturerRequirements(cust.getOrgNbrCust(), supplyItemNbr)) {
					OeCustMfr ocm = cim.get(cust, supplyMfr, s.getIcItemMast());

					if (ocm == null) {
						retval = false;
					}
					if (ocm.getEffDtBeg() == null
							|| ocm.getEffDtBeg() != null && !ocm.getEffDtBeg().after(demand.getRqstDt())) {
						if (ocm.getEffDtEnd() == null
								|| ocm.getEffDtEnd() != null && !ocm.getEffDtEnd().before(demand.getNeedByDate())) {
							retval = true;
						}
					}

				}
				// retval = Customer.isApprovedManufacturer(cust, supplyItemNbr,
				// supplyMfr);

			}
		} else {
			retval = true;
		}
		return retval.booleanValue();  // will blowup if not set
	}

}
