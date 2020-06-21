//package com.pacificdataservices.diamond.planning.filter;
//
//import java.util.Set;
//import java.util.TreeMap;
//import java.util.TreeSet;
//
//import com.pacificdataservices.diamond.models.OeCustMfr;
//
//public class CustomerItemManufacturers {
//	
//	// Need custNbr, itemNbr -> Include 
//	
//	TreeMap<String,CustomerItemMfrRules> customerItemRules = new TreeMap<String,CustomerItemMfrRules>();
//	
//	TreeMap<String,CustomerItemManufacturer> cims = new TreeMap<String,CustomerItemManufacturer>();
//	
//	CustomerItemMfrRules getCustomerItemMfrRules(int customerNumber, int itemNumber) {
//		return customerItemRules.get(customerNumber);
//	}
//	
////	s
//	CustomerItemManufacturer get(int customerNbr, int itemNbr, int manufacturerNbr) {
//			String key = customerNbr + "-" + itemNbr + "-" + manufacturerNbr;
//			return cims.get(key);
//	}
//	
////	public void add(OeCustMfr cim) {
////		cims.put(cim.getKey(),cim);
////		customersWithRules.put(cim.getApsCustMfrVw().getId().getOrgNbrCust(),cim);
////	}
//	
////	public boolean isApproved(int customerNbr, int supplyItemNbr, int manufacturerNbr) {
////		if 
////		CustomerItemManufacturer cim = get(customerNbr, supplyItemNbr, manufacturerNbr);
////		
////	}
//
//}
