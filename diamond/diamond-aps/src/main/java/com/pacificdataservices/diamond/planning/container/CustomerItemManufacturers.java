package com.pacificdataservices.diamond.planning.container;

import org.apache.commons.collections.map.MultiKeyMap;

import com.pacificdataservices.diamond.models.IcItemMast;
import com.pacificdataservices.diamond.models.OeCustMast;
import com.pacificdataservices.diamond.models.OeCustMfr;
import com.pacificdataservices.diamond.planning.InclusionType;
import com.pacificdataservices.diamond.planning.data.PlanningData;



public class CustomerItemManufacturers {

	//private MultiKeyMap customerItem = new MultiKeyMap
	/**
	 * Key is customerNumber, manufacturerNumber.
	 * 
	 * Value is InclusionType;
	 * 
	 * TODO need to figure out what it means if there is an entry and the date is not in the range.
	 * 
	 * TODO need to support the range of dates.
	 */
	private MultiKeyMap customerItemMap = new MultiKeyMap();
	private PlanningData planningData;

	private MultiKeyMap customerItemManufacturerMap = new MultiKeyMap();

	public CustomerItemManufacturers(PlanningData planningData) {
		if (planningData ==  null) {
			throw new IllegalArgumentException("planningData is null");
		}
		this.planningData = planningData;
	}

	public void clear() {
		customerItemMap.clear();
		//customerItemManufacturerMap.clear();
	}

	public void add(OeCustMfr customerItemManufacturer) {
		Integer customerNumber = customerItemManufacturer.getId().getOrgNbrCust();
		Integer manufacturerNumber = customerItemManufacturer.getId().getOrgNbrMfr();
		Integer itemNumber = customerItemManufacturer.getId().getItemNbr();
		customerItemMap.put(customerNumber, manufacturerNumber,Boolean.TRUE);
		customerItemManufacturerMap.put(customerNumber, manufacturerNumber, itemNumber, customerItemManufacturer);				
	}
	// TODO reconcile this with CustomerItemManufacturer and get rid of something
	protected InclusionType getInclusionType(String code) {
		if (code == null) {
			throw new IllegalArgumentException("code is null");
		}
		if (code.length() != 1) {
			throw new IllegalArgumentException("code is invalid: " + code);
		}
		char c = code.charAt(0);
		InclusionType retval = null;
		switch (c) {
		case 'I':
			retval = InclusionType.INCLUDE;
			break;
		case 'E':
			retval = InclusionType.EXCLUDE;
			break;
		default:
			throw new IllegalArgumentException("invalid code " + code);
		}
		return retval;
	}


	protected void putCustomerItemMap(OeCustMfr oeCustMfr) {
		InclusionType type = (InclusionType) customerItemManufacturerMap.get(oeCustMfr.getId().getOrgNbrCust(),  oeCustMfr.getId().getItemNbr());
		InclusionType existingType = getInclusionType(oeCustMfr.getMfrRestrictId());
		if (existingType == null) {
			customerItemMap.put(oeCustMfr.getId().getOrgNbrCust(),  oeCustMfr.getId().getItemNbr(), type);
		} else {
			if (!existingType.equals(type)) {
				throw new IllegalArgumentException("Type mismatch found for " + oeCustMfr.toString());
			}
		}

	}


	public boolean hasManufacturerRequirements(Integer customerNumber, Integer itemNumber) {
		boolean returnValue = false;
		returnValue = customerItemMap.containsKey(customerNumber, itemNumber);
		return returnValue;
	}

	public OeCustMfr get (OeCustMast customer, Integer manufacturerId, IcItemMast item) {
		Integer customerNumber = customer.getOrgNbrCust();
		Integer itemNumber = item.getItemNbr();
		OeCustMfr retval = (OeCustMfr) customerItemManufacturerMap.get(customerNumber, manufacturerId, itemNumber);
		// TOOD need to check demandDate
		return retval;
	}
}
