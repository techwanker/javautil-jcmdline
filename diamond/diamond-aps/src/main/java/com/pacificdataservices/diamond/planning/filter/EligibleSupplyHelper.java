package com.pacificdataservices.diamond.planning.filter;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.pacificdataservices.diamond.models.ApsSplySubPool;
import com.pacificdataservices.diamond.models.ApsSrcRule;
import com.pacificdataservices.diamond.planning.data.PlanningData;
import com.pacificdataservices.diamond.planning.demand.Demand;
import com.pacificdataservices.diamond.planning.supply.Supply;

public class EligibleSupplyHelper{
	private Logger logger = LoggerFactory.getLogger(getClass());
	public ApsSplySubPool getSubPool(Supply supply, Demand demand, PlanningData planningData) {
		ApsSplySubPool subPool = null;
	
		ApsSrcRule rule = planningData.getSourcingRule(supply, demand);

	     subPool = rule.getApsSplySubPool();
			
			if (subPool == null) {
				logger.warn("subPool not populate for supply " + supply.getId());
					throw new IllegalStateException("subPool is null for supply " + supply.getId());
			}
		return subPool;
	}
}
