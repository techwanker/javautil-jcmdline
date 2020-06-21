package com.pacificdataservices.diamond.planning.filter;

// todo jjs figure out if this test still exists in an alternate form
//public class SupplyItemSatifiesDemandItem implements SupplyEligibilityTest {
//	public boolean isSupplyEligibleForDemand(Supply s, Demand d, PlanningData planningData)
//	{
//		 if (s.isItem(demand.getItemNumberOrdered())) {
//		      results.setGoodItem(true);
//		  } else {  // not directly certed, try substitutes
//		      if (demand.isSubstitute(supply)) {
//		          results.setCustomerSubstitute(true);
//		       //   addSpecialNote("Customer Approved Substitute");
//		          results.setSubstitutionType("C");
//		          results.setGoodItem(true);
//		      } else {
//		          if (demand.isGlobalSubstitute(supply)) {
//		              results.setGlobalSubstitute(true);
//		         //     addSpecialNote("global substitute");
//		              results.setSubstitutionType("G");  // this should be a by product of the above
//		              results.setGoodItem(true);
//		          } else {
//		              results.setGoodItem(false);
//		        //      results.addIneligibleReason("item not ok ");
//		          }
//		      }
//		  }
//	}
//	public boolean isItem(Integer itemNbr) {
//        boolean retval = this.getItemNbr().equals(itemNbr);
//        if (retval == false) {
//            if (lotCerts != null) {
//                for (LotCert lotCert : lotCerts) {
//                    if (lotCert.getItemNbr().equals(itemNbr)) {
//                        retval = true;
//                        break;
//                    }
//                }
//            }
//        }
//        return retval;
//    }

// }
