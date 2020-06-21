package com.pacificdataservices.diamond.planning.filter;

import org.javautil.core.json.ModelGsonMarshaller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.pacificdataservices.diamond.models.ApsSplySubPool;
import com.pacificdataservices.diamond.models.ApsSrcRule;
import com.pacificdataservices.diamond.planning.data.PlanningData;
import com.pacificdataservices.diamond.planning.demand.Demand;
import com.pacificdataservices.diamond.planning.supply.Supply;

public class ConsignmentTest extends AbstractSupplyEligibilityTest {
	private EligibleSupplyHelper helper = new EligibleSupplyHelper();
	
	private boolean trace = true;
	private Logger logger = LoggerFactory.getLogger(getClass());
	private ModelGsonMarshaller dillon = new ModelGsonMarshaller();
	@Override

	public boolean isSupplyEligibleForDemand(Supply supply, Demand demand, PlanningData planningData) {

		Boolean rc = null;
		ApsSrcRule rule = planningData.getSourcingRule(supply, demand);
		if (rule == null) {
			rc = Boolean.FALSE;
		} else {
			ApsSplySubPool subPool = helper.getSubPool(supply, demand, planningData);
//			if (trace) {
//				logger.info("ApsSrcRule: " + dillon.formatObject(rule));
//				logger.info("ApsSplySubPool: " + dillon.formatObject(subPool));
//			}
			rc = "C".equals(subPool.getSplyPoolTypeId());
		}

		return rc;
	}
}
