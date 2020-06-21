//package com.javautil.hibernate.util;
//
//import static org.junit.Assert.assertEquals;
//
//import java.lang.reflect.Type;
//import java.util.ArrayList;
//import java.util.Collection;
//import java.util.List;
//
//import org.javautil.hibernate.util.ModelGsonMarshaller;
//import org.junit.Before;
//import org.junit.Test;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//import com.google.gson.Gson;
//import com.google.gson.GsonBuilder;
//import com.google.gson.reflect.TypeToken;
//import com.pacificdataservices.diamond.models.IcItemMast;
//import com.pacificdataservices.diamond.planning.PlanningData;
//import com.pacificdataservices.diamond.planning.demand.DemandCustomer;
//import com.pacificdataservices.diamond.planning.services.PlanningDataMock;
//import com.pacificdataservices.diamond.planning.supply.SupplyOnhand;
//
//public class ModelGsonModelerTest {
//
//	private Logger logger = LoggerFactory.getLogger(getClass());
//
//	private PlanningData planningData;
//	private DemandCustomer demand;
//	private SupplyOnhand supply;
//	private boolean trace = true;
//	private ModelGsonMarshaller dillon = new ModelGsonMarshaller();
//
//	@Before
//	public void initialize() {
//		planningData = new PlanningDataMock().getSeeded();
//		demand = planningData.getCustomerOrder(1707142);
//		supply = planningData.getSupplyOnhand("TORONTO-1010911-132-2017-07-29");
//	}
//
//	@Test
//	public void marshallRound() {
//		Gson g = new GsonBuilder().create();
//		Collection<IcItemMast> ims = planningData.getIcItemMasts();
//		String collItems = dillon.formatObject(ims);
//		logger.debug("text: " + collItems);
//		ArrayList<IcItemMast> restored;
//		Type collectionType = new TypeToken<List<IcItemMast>>() {
//		}.getType();
//
//		List<IcItemMast> unmarshalled = g.fromJson(collItems, collectionType);
//		String collItems2 = dillon.formatObject(unmarshalled);
//		assertEquals(collItems, collItems2);
//	}
//
////	@Test
////	public void marshallRoundtime() {
////		for (int i = 0; i < 10000; i++) {
////			Timer serializeTime = new Timer();
////			String json = dillon.formatObject(planningData);
////			long micros = serializeTime.getElapsedMicros();
////			logger.info("planningData serialize micros {}", micros);
////		}
////	}
//}
