package com.pacificdataservices.diamond.marshalling;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.IOException;

import org.javautil.hibernate.HibernateMarshallerFactory;

import com.google.gson.Gson;
import com.pacificdataservices.diamond.planning.data.PlanningData;
import com.pacificdataservices.diamond.planning.json.PlanningDataMarshallable;

public class DiamondPlanningMarshallTest {
	
    	
	
	public void testHibernateGsonWithProxyDateFormatter(PlanningData pd) throws IOException {
		Gson dillon  = HibernateMarshallerFactory.getHibernateGsonWithProxyDateFormatter();
		assertNotNull(pd);
		// PlanningData ->  PlanningDataMarshallable -> json -> PlanningDataMarshallable -> PlanningData
		PlanningDataMarshallable pdm1 = new PlanningDataMarshallable(pd);
		assertNotNull(pdm1);
		String json = dillon.toJson(pdm1);
		PlanningDataMarshallable pdm2 = PlanningDataMarshallable.fromJson(json);
		assertNotNull(pdm1.getApsSplySubPools());
		assertNotNull(pdm1.getApsSplySubPools());
		assertEquals(pdm1.getApsSplySubPools().size(),pdm2.getApsSplySubPools().size());
		System.out.println(String.format("from pdm2:%s\n",dillon.toJson(pdm2)));
		// PlanningData -> PlanningDataMarshallable -> PlanningDataMarshallable
		PlanningDataMarshallable pdm3 = new PlanningDataMarshallable(pd);
		PlanningData pd3 = pdm3.toPlanningData();
		// TODO write some tests
	}
}