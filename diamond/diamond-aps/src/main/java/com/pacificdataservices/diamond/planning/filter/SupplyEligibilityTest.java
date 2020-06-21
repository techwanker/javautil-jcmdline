package com.pacificdataservices.diamond.planning.filter;

import java.util.List;

import com.pacificdataservices.diamond.planning.data.PlanningData;
import com.pacificdataservices.diamond.planning.demand.Demand;
import com.pacificdataservices.diamond.planning.supply.Supply;

public interface SupplyEligibilityTest {
	public boolean isSupplyEligibleForDemand(Supply s, Demand d, PlanningData planningData);

	public void setOnPass(List<SupplyEligibilityTest> filters);

	public void setOnFail(List<SupplyEligibilityTest> filters);

	/**
	 * Set a list of filters. If any one of these filters returns true on a call
	 * to isSupplyEligibleForDemand
	 * 
	 * @param filters
	 */
	public void setOrList(List<SupplyEligibilityTest> filters);
	
	public List<SupplyEligibilityTest> getOnPass();

	public List<SupplyEligibilityTest> getOnFail();

	/**
	 * Set a list of filters. If any one of these filters returns true on a call
	 * to isSupplyEligibleForDemand
	 * 
	 * @param filters
	 */
	public List<SupplyEligibilityTest> getOrList();
	
	public String getFailMessage(); 
}
