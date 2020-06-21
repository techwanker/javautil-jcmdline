package com.pacificdataservices.diamond.planning.filter;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.pacificdataservices.diamond.models.ApsSrcRule;
import com.pacificdataservices.diamond.planning.EligibleSupplies;
import com.pacificdataservices.diamond.planning.EligibleSupply;
import com.pacificdataservices.diamond.planning.StringBean;
import com.pacificdataservices.diamond.planning.data.PlanningData;
import com.pacificdataservices.diamond.planning.demand.Demand;
import com.pacificdataservices.diamond.planning.supply.Supply;

public class EligibleSupplyFilterImpl implements EligibleSupplyFilter {
	private Logger logger = LoggerFactory.getLogger(this.getClass().getName());
	// TODO this should be a singleton
	private List<SupplyEligibilityTest> testList = new EligibilityFiltersImpl().getSupplyEligibilityTests();
	private EligibleSupplyHelper helper = new EligibleSupplyHelper();
	private ExpiryDateTest expireTest = new ExpiryDateTest();
	private IsItemOrSubstitute isItemOrSubstitute = new IsItemOrSubstitute();
	private ConsignmentTest consignmentTest = new ConsignmentTest();
	private BuybackTest buybackTest = new BuybackTest();
	private boolean trace = false;
	public String ineligibleReason;
	private StringBean stringBean = new StringBean();

	// TODO support wiring

	public EligibleSupplyFilterImpl() {
	}

	@Override
	public void setEligibleSuppliesForDemand(Demand demand, PlanningData planningData) {
		if (trace) {
			logger.debug("setEligibleSupplies for " + demand);
		}
		for (Supply supply : planningData.getSupplies()) {
			if (trace) {
				logger.debug("supply is " + supply);
			}
			EligibleSupplies eligibleSupplies = new EligibleSupplies(demand, planningData, stringBean);
			if (isEligible(demand, supply, planningData)) {
				ApsSrcRule rule = planningData.getApsSrcRule(demand, supply);
				EligibleSupply es = new EligibleSupply(supply, demand, rule);
				eligibleSupplies.add(es);
			}
			demand.setEligibleSupplies(eligibleSupplies);
		}
	}

	public boolean isConsignment(Demand demand, Supply supply, PlanningData planningData) {
		if (trace) {
			logger.debug("isConsignment enter");
		}
		boolean retval = consignmentTest.isSupplyEligibleForDemand(supply, demand, planningData);
		if (trace) {
			logger.debug("isConsignment " + retval);
		}
		return retval;
	}

	public boolean isBuyback(Demand demand, Supply supply, PlanningData planningData) {
		if (trace) {
			logger.debug("checking buyback");
		}
		boolean retval = buybackTest.isSupplyEligibleForDemand(supply, demand, planningData);
		if (trace) {
			logger.debug("isBuyback " + retval);
		}
		return retval;
	}

	public String getIneligibleReason() {
		return ineligibleReason;
	}

	/**
	 * checkSupplyCertedToDemandItem(); checkSourcingRule(); if (!(
	 * checkIsConsignment() || checkIsBuyBack())) { checkIsEquivalent();
	 * checkExplicitManufacturer(); checkApprovedManufacturer();
	 * checkAttributeCerts(); checkRevisionLevel(); checkLotDate();
	 * checkCountryOfOrigin(); }
	 * 
	 * @author jjs
	 *
	 */

	@Override
	public boolean isEligible(Demand demand, Supply supply, PlanningData planningData) {
		boolean retval = true;
		ApsSrcRule srcRule = planningData.getApsSrcRule(demand, supply);
		boolean logicError = false;
		if (trace) {
			logger.debug("demand: " + demand + "\n" + "supply: " + supply);
		}
		ineligibleReason = null;
		tests:

		while (true) {
			if (logicError) {
				logger.error("logic error");
			}
			if (trace) {
				logger.debug("check sourcing rule");
			}
			if (srcRule == null) {
				ineligibleReason = "no sourcing rule";
				logger.debug(ineligibleReason);
				retval = false;
				break;
			}
			if (trace) {
				logger.debug("checking item or subst");
			}
			if (!isItemOrSubst(demand, supply, planningData)) {
				ineligibleReason = "!isItemOrSubst";
				logger.debug("!isitemOrSubst");
				retval = false;
				break;
			}
			boolean supplyIsConsignment = isConsignment(demand, supply, planningData);
			boolean supplyIsBuyback = isBuyback(demand, supply, planningData);
			logger.debug("checking consignment and buyback");
			if (supplyIsConsignment || supplyIsBuyback) {
				logger.debug("supply is buyback or consignment");
				retval = expireTest.isSupplyEligibleForDemand(supply, demand, planningData);
				if (!retval) {
					break;
				} else {
					logger.debug("not eligible");
				}
			}
			logger.debug("testList size: {}", testList.size());
			for (SupplyEligibilityTest test : testList) {

				if (!test.isSupplyEligibleForDemand(supply, demand, planningData)) {
					logger.debug("supply {} is not eligible for demand {}", supply, demand);
					retval = false;
					demand.addIneligibleReason(supply,test);
				}
			}
			break;

		}
		logger.debug("supply " + supply + " is eligible");
		return retval;

	}

	/**
	 * 
	 * @param demand
	 * @param supply
	 * @param planningData
	 * @return true if the supply is the item ordered, or a customer or global
	 *         substitue
	 */
	private boolean isItemOrSubst(Demand demand, Supply supply, PlanningData planningData) {
		return isItemOrSubstitute.isSupplyEligibleForDemand(supply, demand, planningData);
	}

	protected void checkArguments(int ruleSet, Demand demand, Supply supply, PlanningData planningData) {
		if (demand == null) {
			throw new IllegalArgumentException("demand is null");
		}
		if (supply == null) {
			throw new IllegalArgumentException("supply is null");
		}
		if (planningData == null) {
			throw new IllegalArgumentException("planningData is null");
		}
	}

	@Override
	public boolean isApplicable() {
		throw new UnsupportedOperationException();
	}

	public boolean isEligible() {
		throw new UnsupportedOperationException();
	}
}
