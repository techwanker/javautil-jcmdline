package com.pacificdataservices.diamond.planning.filter;

import java.util.List;

import com.pacificdataservices.diamond.planning.data.PlanningData;
import com.pacificdataservices.diamond.planning.demand.Demand;
import com.pacificdataservices.diamond.planning.supply.Supply;

public abstract class AbstractSupplyEligibilityTest implements SupplyEligibilityTest {

	private List<SupplyEligibilityTest> onFailFilters;

	private List<SupplyEligibilityTest> onPassFilters;

	private List<SupplyEligibilityTest> orList;

	public void checkArguments(Supply supply, Demand demand, PlanningData planningData) {
		if (demand == null) {
			throw new IllegalArgumentException("Demand is null");
		}
		if (supply == null) {
			throw new IllegalArgumentException("supply is null");
		}
		if (planningData == null) {
			throw new IllegalArgumentException("planningData is null");
		}
	}

	@Override
	public List<SupplyEligibilityTest> getOnFail() {
		return onFailFilters;
	}

	public List<SupplyEligibilityTest> getOnFailFilters() {
		return onFailFilters;
	}

	@Override
	public List<SupplyEligibilityTest> getOnPass() {
		return onPassFilters;
	}

	public List<SupplyEligibilityTest> getOnPassFilters() {
		return onPassFilters;
	}

	/**
	 * Set a list of filters. If any one of these filters returns true on a call
	 * to isSupplyEligibleForDemand
	 * 
	 * @param filters
	 */
	@Override
	public List<SupplyEligibilityTest> getOrList() {
		return orList;
	}

	@Override
	public void setOnFail(List<SupplyEligibilityTest> filters) {
		this.onFailFilters = filters;
	}

	// public void setOnFailFilters(List<SupplyEligibilityTest> onFailFilters) {
	// this.onFailFilters = onFailFilters;
	// }

	@Override
	public void setOnPass(List<SupplyEligibilityTest> filters) {
		this.onPassFilters = filters;
	}

	public void setOnPassFilters(List<SupplyEligibilityTest> onPassFilters) {
		this.onPassFilters = onPassFilters;
	}

	@Override
	public void setOrList(List<SupplyEligibilityTest> filters) {
		this.orList = filters;
	}

	@Override
	public String getFailMessage() {
		String testName = getClass().getTypeName();
		return "Failed on " + testName;
	}

}
