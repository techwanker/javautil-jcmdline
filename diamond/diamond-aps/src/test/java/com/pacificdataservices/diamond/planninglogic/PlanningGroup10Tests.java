package com.pacificdataservices.diamond.planninglogic;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.util.TreeMap;

import org.javautil.util.Day;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.pacificdataservices.diamond.planning.data.PlanningData;
import com.pacificdataservices.diamond.planning.demand.DemandCustomer;
import com.pacificdataservices.diamond.planning.filter.CustomerItemManufacturerTest;
import com.pacificdataservices.diamond.planning.filter.ExpiryDateTest;
import com.pacificdataservices.diamond.planning.filter.ManufacturerTest;
import com.pacificdataservices.diamond.planning.json.PlanningDataMarshallable;
import com.pacificdataservices.diamond.planning.services.SpringBootTests;
import com.pacificdataservices.diamond.planning.supply.SupplyOnhand;

public class PlanningGroup10Tests extends AbstractPlanTest {
	private final Logger logger = LoggerFactory.getLogger(getClass());
	
	@Before
	public void before() throws IOException, InstantiationException, IllegalAccessException, ParseException {
		if (getPlanningData() == null) {
			setPlanningData(PlanningDataMarshallable.planningDataFromFile(new File(SpringBootTests.planGroup10DataFile)));
		}
		AbstractPlanTestExpectedValues expected = new AbstractPlanTestExpectedValues();
		expected.setExpectedFirstDemand ("TYPE:-2-OO-LEADTIME:1-DMDPRTY:0005-NEEDBY:2019-04-26-1DMDCD:JIT286489-28");
		expected.setExpectedCustomerDemandSize ( 22);
		expected.setExpectedEligibleSize ( 5);
		expected.setExpectedSuppliesSize ( 22);
		expected.setExpectedIcItemMastSize ( 5);
		expected.setExpectedApsAvailOnhandsSize (12);
		super.setExpected(expected);
	}
	
	@Test
	public void testExpirationDate() {
		PlanningData pd = getPlanningData();
		
		ExpiryDateTest expires = new ExpiryDateTest();
		
		TreeMap<Integer, DemandCustomer> custOrders = pd.getDemandCustomerById();
		assertNotNull(custOrders);
		DemandCustomer d  = custOrders.get(custOrders.firstKey());
		assertNotNull(d);
		
		TreeMap<String, SupplyOnhand> onhand = pd.getSupplyOnhandById();
		assertNotNull(onhand);
		SupplyOnhand soh  = onhand.get(onhand.firstKey());
		assertNotNull(soh);
		
		assertNotNull(soh);
		soh.setExpireDt(null);
		d.setLotNotExpireBeforeDt(new Day(2019,1,1));
		assertFalse(expires.isSupplyEligibleForDemand(soh,d, pd));
		
		// supply expires afer required
		d.setLotNotExpireBeforeDt(new Day(2017,10,1));
		soh.setExpireDt(new Day(2017,10,31));
		assertTrue(expires.isSupplyEligibleForDemand(soh,d, pd));
	
		
		// no expire demand or supply
		soh.setExpireDt(null);
		d.setLotNotExpireBeforeDt(null);
		assertTrue(expires.isSupplyEligibleForDemand(soh,d, pd));

		// supply has expired demand does not
		soh.setExpireDt(new Day(2017,11,1));
		d.setLotNotExpireBeforeDt(null);
		assertTrue(expires.isSupplyEligibleForDemand(soh,d, pd));
	}
	
	public void testApprovedManufacturer() {
		PlanningData pd = getPlanningData();
		
		ManufacturerTest mfrTest = new ManufacturerTest();
		// get the demand
		TreeMap<Integer, DemandCustomer> custOrders = pd.getDemandCustomerById();
		assertNotNull(custOrders);
		DemandCustomer d  = custOrders.get(custOrders.firstKey());
		assertNotNull(d);
		
		
		TreeMap<String, SupplyOnhand> onhand = pd.getSupplyOnhandById();
		assertNotNull(onhand);
		SupplyOnhand soh  = onhand.get(onhand.firstKey());
		assertNotNull(soh);
		
		// explicit manufacturer  
		soh.setOrgNbrMfr(11);
		d.setOrgNbrMfrRqst(11);
		assertTrue(mfrTest.isSupplyEligibleForDemand(soh, d, pd));
		
		
		// explicit manufacturer  
		soh.setOrgNbrMfr(11);
		d.setOrgNbrMfrRqst(12);
		assertFalse(mfrTest.isSupplyEligibleForDemand(soh, d, pd));
		
		// explicit manufacturer  
		soh.setOrgNbrMfr(null);
		d.setOrgNbrMfrRqst(null);
		assertTrue(mfrTest.isSupplyEligibleForDemand(soh, d, pd));
		
		// explicit manufacturer  
	
		soh.setOrgNbrMfr(null);
		d.setOrgNbrMfrRqst(12);
		assertFalse(mfrTest.isSupplyEligibleForDemand(soh, d, pd));
		
		// explicit manufacturer 

		soh.setOrgNbrMfr(11);
		d.setOrgNbrMfrRqst(null);
		assertTrue(mfrTest.isSupplyEligibleForDemand(soh, d, pd));	
		
		logger.info("testApprovedManufacturer complete");
		
	}
	
	@Test
	public void testCustomerItemManufacturerTest() {
		PlanningData pd = getPlanningData();
	
		CustomerItemManufacturerTest mfrTest = new CustomerItemManufacturerTest();
		// get the demand
		TreeMap<Integer, DemandCustomer> custOrders = pd.getDemandCustomerById();
		assertNotNull(custOrders);
		DemandCustomer d  = custOrders.get(custOrders.firstKey());
		assertNotNull(d);

		
		TreeMap<String, SupplyOnhand> onhand = pd.getSupplyOnhandById();
		assertNotNull(onhand);
		SupplyOnhand soh  = onhand.get(onhand.firstKey());
		assertNotNull(soh);
		
		// explicit manufacturer  
		soh.setOrgNbrMfr(11);
		d.setOrgNbrMfrRqst(11);
		assertTrue(mfrTest.isSupplyEligibleForDemand(soh, d, pd));
		
		
		// explicit manufacturer  
		soh.setOrgNbrMfr(11);
		d.setOrgNbrMfrRqst(12);
		assertFalse(mfrTest.isSupplyEligibleForDemand(soh, d, pd));
		

		// explicit manufacturer  
	
		soh.setOrgNbrMfr(8332);
		d.setOrgNbrMfrRqst(null);
		assertTrue(mfrTest.isSupplyEligibleForDemand(soh, d, pd));
		
		// explicit manufacturer 

		soh.setOrgNbrMfr(11);
		d.setOrgNbrMfrRqst(null);
		assertTrue(mfrTest.isSupplyEligibleForDemand(soh, d, pd));	
		
		logger.debug("testApprovedManufacturer complete");
		
	}


}