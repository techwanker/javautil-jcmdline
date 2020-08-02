package com.pacificdataservices.diamond.planning;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeMap;
import java.util.TreeSet;

import org.javautil.util.Timer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.pacificdataservices.diamond.models.ApsSrcRule;
import com.pacificdataservices.diamond.planning.data.PlanningData;
import com.pacificdataservices.diamond.planning.demand.Demand;
import com.pacificdataservices.diamond.planning.demand.DemandForecast;
import com.pacificdataservices.diamond.planning.filter.EligibleSupplyFilter;
import com.pacificdataservices.diamond.planning.filter.EligibleSupplyFilterImpl;
import com.pacificdataservices.diamond.planning.supply.Supply;

/**
 * 
 */
public class EligibleSupplies implements Iterable<EligibleSupply> {
	private transient Logger logger = LoggerFactory.getLogger(this.getClass().getName());
	private transient Logger analytics = LoggerFactory.getLogger(this.getClass().getName());

	@Autowired
	private EligibleSupplyFilter eligibleSupplyFilter;
	private boolean trackingInapplicable = false;

	private transient static Comparator<EligibleSupply> comparator;  // TODO isn't there a version that turns this into a string?

	private ArrayList<EligibleSupplyFilter> filters = new ArrayList<EligibleSupplyFilter>();

	private TreeSet<EligibleSupply> eligibleSupplies = null;

	private TreeMap<String, EligibleSupply> prioritizedSupply = new TreeMap<String, EligibleSupply>();

	private ArrayList<EligibleSupplyFilter> ineligible = new ArrayList<EligibleSupplyFilter>();

	private ArrayList<EligibleSupplyFilter> inapplicable = new ArrayList<EligibleSupplyFilter>();

	private StringBean stringBean;
	private Collection<Supply> supplies;

	/**
	 * @todo restore pruning of ineligible supplies for forecasts
	 * @param demand
	 * @param icLotRevLvlOnhandVwS
	 */
	public EligibleSupplies(Demand demand, PlanningData planningData, StringBean stringBean) {
		Timer t = new Timer();
		//
		Timer setupTimer = new Timer();
		this.stringBean = stringBean;
		if (logger.isDebugEnabled()) {
			logger.debug("Demand: " + stringBean.asString(demand));
			logger.debug("Supplies size " + supplies.size());
		}
		comparator = new EligibleSupplyComparator(planningData);   // TODO this was replace by a string
		eligibleSupplies = new TreeSet<EligibleSupply>(comparator);
		EligibleSupplyFilter relationship = new EligibleSupplyFilterImpl();
		if (trackingInapplicable) {
			inapplicable = new ArrayList<EligibleSupplyFilter>();
		}
		supplies = planningData.getSupplies();
		// TODO this is slow
		analytics.debug("Constructor setupTimer for demand micros {}", setupTimer.getElapsedMicros());
		//
		Timer loopTimer = new Timer();
		for (Supply supply : supplies) {
		//	suppliesConsidered++;
			if (logger.isDebugEnabled()) {
				logger.debug("examining supply " + supply.getIdentifierString());
			}
			if (relationship.isEligible(demand, supply, planningData)) {
				if (logger.isDebugEnabled()) {
					logger.debug("supply is eligible: " + supply);
				}
				ApsSrcRule rule = planningData.getApsSrcRule(demand, supply);
				add(new EligibleSupply(supply, demand, rule));
			} else {
				if (logger.isDebugEnabled()) {
					logger.debug("suppy is not eligible " + supply.getIdentifierString());
				}
				if (!(demand instanceof DemandForecast)) {
					ineligible.add(relationship);
				}
			}
		}
		analytics.debug("Constructor loopTimer micros {}", loopTimer.getElapsedMicros());
		analytics.debug("Constructor elapsed micros {}", t.getElapsedMicros());
	}

	public void add(EligibleSupply eligible) {
		if (!eligibleSupplies.add(eligible)) {
			throw new java.lang.IllegalArgumentException("Duplicate eligible supply " + eligible + "\n" + stringBean.asString(supplies));
		}  
		if (logger.isDebugEnabled()) {
		    logger.debug("setEligibleSupplies.adding prioritized {}", eligible);
		}
		EligibleSupply old = prioritizedSupply.put(eligible.getPriority(), eligible);
		if (old != null) {
			String message = String.format("Old priority: %s\n" + //
					"new priority: %s\n" + //
					"old supply:   %s\n" + //
					"new supply:   %s\n" + //
					"demand:       %s ", old.getPriority(), eligible.getPriority(), old.getSupply(),
					eligible.getSupply(), this);
			logger.error("\n" + message);
			throw new IllegalStateException(message);
		}
	}

	public int size() {
		return eligibleSupplies.size();
	}

	@Override
	public Iterator<EligibleSupply> iterator() {
		return eligibleSupplies.iterator();
	}

	/**
	 * Filters all of the supply and places in two containers, one for eligible
	 * supply and one for ineligible supply.<br>
	 * In order for supply to be eligible it must meet the following conditions
	 * <ul>
	 * <li>The demand sourcing rule set must include a rule that supports the supply
	 * type.
	 * <ul>
	 * <li>The supply pool and sub pool must match</li>
	 * <li>The facility must match</li>
	 * <li>The supply type must match</li>
	 * </ul>
	 * </li>
	 * <li>The demand certifications must be fully satisfied by the supply
	 * certifications</li>
	 * <li>If a revision level is specified on the demand, the revision level of the
	 * supply must match</li>
	 * <li>If a revision level is specified on the demand, no substitutes, either
	 * customer or global are attempted</li>
	 * <li>If no revision level is specified on the demand, a check is made for
	 * whether the supply satisfies a customer substitution or a global
	 * substitition</li>
	 * <li>If a manufacturer is explicated on the demand, the supply must match the
	 * manufacturer</li>
	 * <li>If no manufacturer is explicated on the demand a check is made for vendor
	 * approval.</li>
	 * <ul>
	 * <li>If there are no customer specified rules any manufacturer is
	 * acceptable</li>
	 * <li>If the customer has enumerated unacceptable manufacturers and the
	 * manufacturer is not black-listed, it is ok</li>
	 * <li>If the customer has enumerated acceptable manufacturers, the manufacturer
	 * must be in the list</li>
	 * </ul>
	 * 
	 * 
	 * </ul>
	 * 
	 * @param demand
	 * @return
	 */

	public Iterator<EligibleSupplyFilter> relationshipIterator() {
		return filters.iterator();
	}

	public Iterator<EligibleSupplyFilter> filterIterator() {
		return filters.iterator();
	}

	public int getIneligibleCount() {
		return ineligible.size();
	}

	public ArrayList<EligibleSupplyFilter> getIneligible() {
		return ineligible;
	}

	public ArrayList<EligibleSupplyFilter> getInapplicable() {
		return inapplicable;
	}

	public String getPrioritizedSuppliesFormatted() {
		StringBuilder sb = new StringBuilder();
		for (EligibleSupply es : prioritizedSupply.values()) {
			sb.append(es.toString());
			sb.append("\n");
		}
		return sb.toString();
	}

	public TreeMap<String, EligibleSupply> getPrioritizedSupply() {
		return prioritizedSupply;
	}
	
	public ArrayList<EligibleSupply> getEligibleSupplies() {
		ArrayList<EligibleSupply> retval =new ArrayList<EligibleSupply>();
		retval.addAll(eligibleSupplies);
		return retval;
	}

}
