package com.pacificdataservices.diamond.planning.demand;

import java.util.List;
import java.util.TreeMap;

import org.javautil.core.misc.Timer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.pacificdataservices.diamond.planning.data.PlanningData;


public abstract class AbstractDemandPrioritizer implements DemandPrioritizer {
	private Logger logger = LoggerFactory.getLogger(getClass());
	public AbstractDemandPrioritizer() {
		super();
	}

	/**
	 * Populates planningData.prioritizedDemands
	 * 
	 * Each demand is assigned a priority code
	 */

	@Override
	public void prioritize(PlanningData planningData) {
		if (planningData == null) {
			throw new IllegalArgumentException("planningData is null");
		}
		List<Demand> demands = planningData.getDemands();
		Timer t = new Timer(getClass(),"prioritize");
		TreeMap<String,Demand> seen = new TreeMap<String,Demand>();
		for (Demand demand : planningData.getDemands()) {
			String priorityCode = getPriorityCode(demand);
			if (priorityCode == null) {
				throw new IllegalStateException("priorityCode is null for " + demand);
			}
			demand.setPriorityCode(priorityCode);
			Demand saw = seen.get(priorityCode);
			if (saw != null) {
				throw new IllegalStateException("Duplicate priorityCode " + priorityCode + "\n" +
						saw + "\n" + demand);
			}
			seen.put(priorityCode, demand);
		}
		planningData.setPrioritizedDemands(seen);
		if (demands.size() != seen.size()) {
			throw new IllegalStateException("Prioritized Demands: " + seen.size() + " != " + demands.size());
		}
		logger.info("demand prioritization complete for " + demands.size() + " micros: " + t.getElapsedMicros());
	}

	abstract String getPriorityCode(Demand demand);
}