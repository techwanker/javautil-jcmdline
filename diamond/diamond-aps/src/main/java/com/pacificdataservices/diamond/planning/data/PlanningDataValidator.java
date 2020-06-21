package com.pacificdataservices.diamond.planning.data;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.javautil.hibernate.HibernateMarshallerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.Gson;
import com.pacificdataservices.diamond.models.ApsSplySubPool;
import com.pacificdataservices.diamond.models.ApsSrcRule;
import com.pacificdataservices.diamond.models.ApsSrcRuleSet;
import com.pacificdataservices.diamond.models.OeCustMast;
import com.pacificdataservices.diamond.planning.Allocation;
import com.pacificdataservices.diamond.planning.AllocationMode;
import com.pacificdataservices.diamond.planning.PlanningDataException;
import com.pacificdataservices.diamond.planning.StringBean;
import com.pacificdataservices.diamond.planning.container.ApsSrcRuleSetExt;
import com.pacificdataservices.diamond.planning.demand.Demand;
import com.pacificdataservices.diamond.planning.supply.Supply;

/**
 * Everything necessary to plan a group of items is contained here.
 * 
 * This may be populated by a web service, xml or any other mechanism.
 * 
 * As this implementatio the data is populated by PlanningDataService.
 * 
 * It is expected that
 * 
 * @author jjs
 * 
 *         TODO make sure that a customer record exists for each customer demand
 *         *
 * 
 *         Note: FIXES.sql mods APS_SRC_RULE_SET
 * 
 */
public class PlanningDataValidator {
	transient private Gson dillon = HibernateMarshallerFactory.getHibernateGsonWithProxyDateFormatter();
	transient public static final int INTEGRITY_UNCHECKED = -1;
	transient public static final int INTEGRITY_VALID = 0;
	transient private StringBean stringBean = new StringBean();
	transient public static final int INTEGRITY_INVALID = 1;

	private ArrayList<String> integrityMessages;
	private ArrayList<String> integrityInfo;
	private Map<Integer,ApsSrcRuleSet> ruleSetsWithNoRules;
	private PlanningData pd;
	private int integrityState;
	private ArrayList<String> verificationMessages;
	private Logger logger = LoggerFactory.getLogger(getClass());

	public PlanningDataValidator(PlanningData pd) {
		this.pd = pd;
	}

	// ************************
	// check integrity
	// ************************
	public ArrayList<String> checkIntegrity(boolean show) {
		integrityMessages = new ArrayList<String>();

		checkNotNulls();
	    integrityMessages.addAll(checkApsSrcRules(pd.getApsSrcRules()));
		//integrityMessages.addAll(checkRuleSetsHaveRules(pd.getApsSrcRuleSets()));
		integrityMessages.addAll(checkDemandReferences(pd.getDemands()));
		integrityMessages.addAll(checkSupplyReferences(pd.getSupplies()));
		integrityMessages.addAll(checkOeCustMasts(pd.getOeCustMasts()));

		if (integrityMessages.size() > 0) {
			String message = String.format("There are %d errors, call getIntegrityMessages() to get them all",
					integrityMessages.size());
			String integrityMessage = getIntegrityMessage();
			logger.error(message + "\n" + integrityMessage);
			if (show) {
				logger.error(getIntegrityMessage());
			}
			throw new PlanningDataException(message);
		}
		return integrityMessages;
	}
	
	public String getIntegrityMessage() {
		StringBuilder sb = new StringBuilder();
		for (String message : integrityMessages) {
			sb.append(message);
			sb.append("\n");
		}
		return sb.toString(); 
	}
	
	public List<String> checkOeCustMasts(Collection<OeCustMast> custs) {
		ArrayList<String> messages = new ArrayList<String>();
		for (OeCustMast cust : custs) {
			if (cust.getNaOrg() == null) {
				String message = String.format("Customer %s has no NaOrg", cust.toString());
				messages.add(message);
			}
		}
		return messages;
	}
	

	public List<String> checkApsSrcRules(Collection<ApsSrcRule> rules) {
		ArrayList<String> messages = new ArrayList<String>();
		for (ApsSrcRule srcRule : rules) {
			ApsSplySubPool subPool = srcRule.getApsSplySubPool();
			if (subPool == null) {
				String message = String.format("ApsSrcRule %d %s has null ApsSplySubPool", srcRule.getApsSrcRuleNbr(),
						toString(srcRule));
				messages.add(message);
			}
		}
		return messages;
	}

	private List<String> checkRuleSetsHaveRules(Collection<ApsSrcRuleSet> ruleSets) {
		ArrayList<String> messages = new ArrayList<String>();
		for (ApsSrcRuleSet ruleSet : ruleSets) {
			Set<ApsSrcRule> rules = ruleSet.getApsSrcRules();
			if (rules.size() == 0) {
			    ruleSetsWithNoRules.put(ruleSet.getApsSrcRuleSetNbr(),ruleSet);
				String message = String.format("ruleSet %s has no rules", toString(ruleSet));
				integrityInfo.add(message);
			}
		}
		return messages;
	}

	private String toString(Object o) {
		return stringBean.asString(o);
	}

	private void checkNotNull(String method, Object o) {
		if (o == null) {
			integrityMessages.add("method " + method + " returns null");
			integrityState = INTEGRITY_INVALID;
		}
	}

	public void checkNotNulls() {
		checkNotNull("getApsAvailOnhand", pd.getApsAvailOnhands());
		// checkNotNull("getApsAvailReplen", getApsAvailReplens());
		// checkNotNull("getApsAvailWo", getApsAvailWos());
		checkNotNull("getApsAllocOnhandOos", pd.getApsAllocOnhandOos());
		checkNotNull("getApsAllocOnhandSss", pd.getApsAllocOnhandSss());
		checkNotNull("getApsAllocOnhandWos", pd.getApsAllocOnhandWos());
		checkNotNull("getApsAllocOnhandFcs", pd.getApsAllocOnhandFcs());
		checkNotNull("getApsAllocReplenOos", pd.getApsAllocReplenOos());
		checkNotNull("getApsAllocReplenSss", pd.getApsAllocReplenSss());
		checkNotNull("getApsAllocReplenWos", pd.getApsAllocReplenWos());
		checkNotNull("getApsAllocReplenFcs", pd.getApsAllocReplenFcs());

		checkNotNull("getFcstGrps", pd.getFcstGrps());
		checkNotNull("getFcstGrpById", pd.getFcstGrpById());
		// checkNotNull("")
		// checkNotNull("getApsAllocWoOos", getApsAllocWoOos());
		// checkNotNull("getApsAllocWoSss", getApsAllocWoSss());
		// checkNotNull("getApsAllocWoWos", getApsAllocWoWos());
		// checkNotNull("getApsAllocWoFcs", getApsAllocWoFcs());
		//
		// checkNotNull("getApsCustMfrVws",getApsCustMfrVws());
		//
		// checkNotNull("getApsAvailOnhands", getApsAvailOnhands());
		// checkNotNull("getApsAvailReplenss", getApsAvailReplens());
		// checkNotNull("getApsAvailWos", getApsAvailWos());
		//
		// checkNotNull("getApsDmdFcs", getApsDmdFcs());
		// checkNotNull("getApsDmdOos", getApsDmdOos());
		// checkNotNull("getApsDmdSss", getApsDmdSss());
		// checkNotNull("getApsDmdWos", getApsDmdWos());
		// //
		checkNotNull("getApsItemGlobalSubsts", pd.getApsItemGlobalSubsts());
		checkNotNull("getApsSplySubPools", pd.getApsSplySubPools());
		checkNotNull("getIcItemCustsSubsts", pd.getIcItemCustSubsts());
		checkNotNull("getIcItemMastEquivs", pd.getIcItemMastEquivs());
		checkNotNull("getIcItemMasts", pd.getIcItemMasts());
		checkNotNull("getDemandSafetyStocks", pd.getDemandSafetyStocks());
		//
		checkNotNull("getDemandCustomers", pd.getDemandCustomers());
		// checkNotNull("getDemandForecasts",getDemandForecasts());
		checkNotNull("getDemandWorkOrders", pd.getDemandWorkOrders());
		// checkNotNull("getDemandForecastById", getDemandForecastById());
		//
		checkNotNull("getDemandSafetyStockById", pd.getDemandSafetyStockById());
		checkNotNull("getDemandsByCustomer", pd.getDemandsByCustomer());
		checkNotNull("getDemandWorkOrderById", pd.getDemandWorkOrderById());
		checkNotNull("getIcItemMastsById", pd.getIcItemMastsById());
		// checkNotNull("getLotsById", getIcLotMastById());
		checkNotNull("getOeCustMastById", pd.getOeCustMastById());
		checkNotNull("getOeOrdDtlCerts", pd.getOeOrdDtlCerts());
		checkNotNull("getFcstGrps", pd.getFcstGrps());
		//checkNotNull("apsSrcRuleSetById", pd.getApsSrcRuleSetById());
		checkNotNull("icItemMastsById", pd.getIcItemMastsById());
	}

	private List<String> checkDemandReferences(Collection<Demand> demands) {
		ArrayList<String> messages = new ArrayList<String>();
        
		for (Demand demand : demands) {
			if (demand.getIcItemMast() == null) {
				messages.add("getIcItemMast returns null for " + toString(demand));
				ApsSrcRuleSet set = demand.getApsSrcRuleSet();
				if (set == null) {
					String message = String.format("Demand %s has no ApsSrcRuleSet ", toString(demand));
					messages.add(message);
				}
				Collection<ApsSrcRule> rules = demand.getApsSrcRuleSet().getApsSrcRules();
				if (rules.size() == 0) {
					String message = String.format("Demand %s ApsSrcRuleSet %s has no rules", toString(demand), toString(set));
					messages.add(message);
				}
				if (demand.getPrimarySourcingFacility() == null) {
					messages.add(String.format("Demand %s has no primary sourcing facility", toString(demand)));
				}
			}
		}
		return messages;
	}

	private List<String> checkSupplyReferences(Collection<Supply> supplies) {
		ArrayList<String> messages = new ArrayList<String>();
		for (Supply supply : supplies) {
			if (supply.getIcItemMast() == null) {
				messages.add("no IcItemMast for " + toString(supply));
				if (supply.getApsSplySubPoolNbr() == null) {
					messages.add("Supply has no ApsSplySubPool() " + toString(supply));
				} else {
				if (pd.getApsSplySubPoolById().get(supply.getApsSplySubPoolNbr()) == null);
					messages.add(String.format("apsSplySubPoolNbr not found for %s", toString(supply)));
				}
			}
		}
		return messages;
	}

	void checkSumAlloc(Demand demand) {
		double allowable = 0.0001;
		double sumOfAllocations = 0.0;
		for (Allocation allocation : demand.getAllocations(AllocationMode.FIRST_PASS)) {
			sumOfAllocations += allocation.getAllocQty().doubleValue();
		}
		double diff = sumOfAllocations - demand.getQuantityAllocated(AllocationMode.FIRST_PASS);
		if (diff < 0) {
			diff *= -1;
		}
		if (diff > allowable) {
			throw new IllegalStateException(
					"sumOfAllocations: " + sumOfAllocations + " demand.getQtyAllocated(AllocationMode.FIRST_PASS) "
							+ demand.getQuantityAllocated(AllocationMode.FIRST_PASS) + " + > " + allowable);
		}
		// assertEquals(sumOfAllocations,
		// demand.getQtyAllocated(AllocationMode.FIRST_PASS).doubleValue(), 0.0001);

	}

//	public String formatSourcingRules() {
//		StringBuilder sb = new StringBuilder();
//		sb.append("ApsSrcRuleSets.size(): " + apsSrcRuleSets.size() + "\n");
//		for (ApsSrcRuleSet ruleSet : apsSrcRuleSets) {
//			sb.append(toString(ruleSet));
//			sb.append("\n");
//		}
//		return sb.toString();
//	}
//
	
	public void checkApsSrcRuleSetExt() {
		TreeMap<Integer, ApsSrcRuleSetExt> extMap = pd.getApsSrcRuleSetExtById();
		if (extMap == null) {
			throw new PlanningDataException("apsSrcRuleSetById is null");
		}
		
		for (ApsSrcRuleSetExt ruleSetExt : pd.getApsSrcRuleSetExtById().values()) {
			if (ruleSetExt.getPrimaryRule() == null) {
				String message = "ApsSrcRulePrimary null for ApsSrcRuleSet " + ruleSetExt.toString() + 
						" in " + extMap.values();
				throw new PlanningDataException(message);
			}
		}
	}

	public ArrayList<String> verifyAllocations() {
		verificationMessages = new ArrayList<String>();
		for (Demand demand : pd.getDemands()) {
			double totalAlloc = 0;
			for (Allocation allocation : demand.getAllocations(AllocationMode.FIRST_PASS)) {
				totalAlloc += allocation.getAllocQty();
			}
			if (totalAlloc > demand.getGrossOpenQty()) {
				verificationMessages.add("overAllocated grossOpen " + demand.getGrossOpenQty() + " allocated "
						+ totalAlloc + " for demand: " + demand.toString());
			}
		}
		return verificationMessages;
	}
}