//package com.javautil.hibernate.util;
//
//import java.util.LinkedHashMap;
//
//import org.javautil.hibernate.util.ModelToCsv;
//import org.junit.Before;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//import com.pacificdataservices.diamond.planning.PlanningData;
//import com.pacificdataservices.diamond.planning.demand.DemandCustomer;
//import com.pacificdataservices.diamond.planning.services.PlanningDataMock;
//import com.pacificdataservices.diamond.planning.supply.SupplyOnhand;
//
//
//public class ModelToCsvTest {
//	
//	private  Logger logger = LoggerFactory.getLogger(getClass());
//	
//	private PlanningData planningData;
//	private DemandCustomer demand;
//	private SupplyOnhand supply;
//	private boolean trace = true;
//	private ModelToCsv dillon = new ModelToCsv();
//	
//	@Before
//	public void initialize() {
//		planningData = new PlanningDataMock().getSeeded();
//		demand = planningData.getCustomerOrder(1707142);
//		supply = planningData.getSupplyOnhand("TORONTO-1010911-132-2017-07-29");
//	}
//	
//	//@Test
//	public void marshallRound() {
////		String type = demand.getClass().getName();
////
////		logger.info("type is ================= " + type);
//		LinkedHashMap<String, Object> map = dillon.getAttributeNameValues(demand);
////		Gson g = new GsonBuilder().create();
////		String nameValue = g.toJson(map);
////		logger.info(nameValue);
//		String names = dillon.getAttributeNames(map);
//		logger.debug("names");
//		logger.debug(names);
//	    logger.debug("values");
//		logger.debug(dillon.toCsv(map.values()));
//	    
//	}
//
//	
//	
//	
//	
//}
//
//
