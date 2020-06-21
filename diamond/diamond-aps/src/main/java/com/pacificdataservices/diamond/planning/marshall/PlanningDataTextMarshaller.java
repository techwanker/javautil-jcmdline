package com.pacificdataservices.diamond.planning.marshall;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

import com.pacificdataservices.diamond.models.ApsSrcRule;
import com.pacificdataservices.diamond.models.ApsSrcRuleSet;
import com.pacificdataservices.diamond.planning.Allocation;
import com.pacificdataservices.diamond.planning.AllocationMode;
import com.pacificdataservices.diamond.planning.data.PlanningData;
import com.pacificdataservices.diamond.planning.demand.Demand;
import com.pacificdataservices.diamond.planning.supply.Supply;

public class PlanningDataTextMarshaller {
	
	StringBuilder sb;
	
	public void write(String text) {
		sb.append(text);
		sb.append("\n");
	}
	
	
	public String marshall(PlanningData pd) {
		sb = new StringBuilder();
		
//		write("apsDmdOos size " + pd.getApsDmdOos().size());
//		write("apsDmdWos size " + pd.getApsDmdWos().size());
//		write("apsDmdSss size " + pd.getApsDmdSss().size());
//		write("apsDmdFcs size " + pd.getApsDmdFcs().size());
		write("demandCustomers size " + pd.getDemandCustomers().size());
		write("demandWorkOrders size " + pd.getDemandWorkOrders().size());
		write("demandSafetyStocks size " + pd.getDemandSafetyStocks().size());
//		write("demandForecasts size " + pd.getDemandForecastById().size());
//		write("demands size " + pd.getDemands().size() + " expected " +
//		       (pd.getApsDmdOos().size() + pd.getApsDmdWos().size() + 
//		       pd.getApsDmdFcs().size() + pd.getApsDmdSss().size()));
		for (Demand demand : pd.getDemands()) {
			write("demand: " + demand.getGrossOpenQty() 
			+   " "  
			+  demand.toString());
			double totalAlloc = 0;
			for (Allocation allocation : demand.getAllocations(AllocationMode.FIRST_PASS)) {
				write("   allocation " 
			 + "qty: " + allocation.getAllocQty()
				+ allocation.getSupply()) ;
				totalAlloc += allocation.getAllocQty(); 
			}
			write("rqst qty:" + demand.getGrossOpenQty() +  " " + totalAlloc);
		}
		
		for (Supply supply : pd.getSupplies()) {
			double totalAlloc = 0;
			write(supply.toString());
			for (Allocation allocation : supply.getAllocations(AllocationMode.FIRST_PASS)) {
				write(allocation.getAllocQty() + " " + allocation.getDemand().toString());
				totalAlloc += allocation.getAllocQty();
			}
			write("availQty: FIRST_PASS " + supply.getAvailQty(AllocationMode.FIRST_PASS) + " allocated " + totalAlloc);
		}
		return sb.toString();
	}
	
	
	public String formatPrioritizedDemands(TreeMap<String,Demand> demands) {
		StringBuilder sb = new StringBuilder();
		for (Entry<String, Demand> demandEntry : demands.entrySet()) {
			sb.append(demandEntry.getKey() + " " + demandEntry.getValue() + "\n");
		}
		return sb.toString();
	}
	
	public String formatAllocations(Collection<Allocation> allocations) {
		StringBuilder sb = new StringBuilder();
		for (Allocation allocation : allocations) {
			sb.append(allocation.toString());
			sb.append("\n");
		}
		return sb.toString();
	}
	
	
	public String formatAllocationsForDemand(Demand demand, AllocationMode mode) {
		StringBuilder sb = new StringBuilder();
		List<Allocation> allocations = demand.getAllocations(mode);
		sb.append("dmdQty: " + demand.getGrossOpenQty() + " allocated: " + demand.getQuantityAllocated(mode) + "\n"); 
		sb.append("demand " + demand);
		sb.append("\n");
	
		for (Allocation allocation : allocations) {
			sb.append(allocation.allocSupplyToString());
			sb.append("\n");
		}
	
		return sb.toString();
		
	}

	public String formatApsSrcRuleSetById(Map<Integer, ApsSrcRuleSet> map) {
		StringBuilder sb = new StringBuilder();
		for (Entry<Integer,ApsSrcRuleSet> e : map.entrySet()) {
			sb.append(e.getKey() + ": " + apsSrcRuleSetToString(e.getValue()) + "\n");
		}
		return sb.toString();
	}

	public String apsSrcRuleSetToString(ApsSrcRuleSet r) {
		StringBuffer sb = new StringBuffer();
		
		sb.append("ApsSrcRuleSet [apsSrcRuleSetNbr=" + r.getApsSrcRuleSetNbr() 
			//	+ ", apsSrcRuleByApsSrcRuleNbrReplen=" + r.getApsSrcRuleByApsSrcRuleNbrReplen() 
			//	+ ", apsSrcRuleByApsSrcRuleNbrPrimary=" + r.getApsSrcRuleByApsSrcRuleNbrPrimary() 
				+ ", apsSrcRuleSetCd=" + r.getApsSrcRuleSetCd() 
				+ ", apsSrcRuleSetDescr=" + r.getApsSrcRuleSetDescr() 
//				+ ", facilityFcstConsume=" + r.getFacilityFcstConsume() 
//				+ ", apsSplyPoolCdFcstConsume=" + r.getApsSplyPoolCdFcstConsume() 
				+ ", srcRuleSetStatId=" + r.getSrcRuleSetStatId()
				+ "]");
		
		for (ApsSrcRule rule : r.getApsSrcRules()) {
			sb.append(rule.toString() + "\n");
		}
		return sb.toString();
	}
	
	
	public String formatSuppliesById(Map<String,Supply> suppliesById) {
		StringBuilder sb = new StringBuilder();
		for (Entry <String,Supply> supply :  suppliesById.entrySet()) {
			sb.append(supply.getKey() + ": " + supply.getValue() + "\n");
		}
		return sb.toString();
	}
	

}
