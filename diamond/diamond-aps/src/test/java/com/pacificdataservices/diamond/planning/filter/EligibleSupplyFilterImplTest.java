//package com.pacificdataservices.diamond.planning.filter;
//
//import static org.junit.Assert.assertFalse;
//import static org.junit.Assert.assertNotNull;
//import static org.junit.Assert.assertTrue;
//
//import java.util.ArrayList;
//
//import org.javautil.hibernate.util.ModelGsonMarshaller;
//import org.junit.Before;
//import org.junit.Test;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//import com.pacificdataservices.diamond.models.IcCertCd;
//import com.pacificdataservices.diamond.planning.PlanningData;
//import com.pacificdataservices.diamond.planning.demand.DemandCustomer;
//import com.pacificdataservices.diamond.planning.services.PlanningDataMock;
//import com.pacificdataservices.diamond.planning.supply.SupplyOnhand;
//
//public class EligibleSupplyFilterImplTest {
//	
//	private  Logger logger = LoggerFactory.getLogger(getClass());
//	
//	private PlanningData planningData;
//	private DemandCustomer demand;
//	private SupplyOnhand supply;
//	private ModelGsonMarshaller dillon = new ModelGsonMarshaller();
//	private boolean trace = true;
//	
////	@Before
////	public void initialize() {
////		planningData = new PlanningDataMock().getSeeded();
////		demand = planningData.getCustomerOrder(1707142);
////		supply = planningData.getSupplyOnhand("TORONTO-1010911-132-2017-07-29");
////	
////		if (trace) {
////			String supplysString = dillon.formatObject(planningData.getSupplies());
////			logger.debug(supplysString);
////			String subPoolsString = dillon.formatObject(planningData.getApsSplySubPools());
////			logger.debug(subPoolsString);
////		}
////		
////		
////	}
//	@Test
//	public void isItemOrSubstTest() {
//		
//	}
//	
//	@Test
//	public void supplyIsConsignmentTest()
//	{
//		ConsignmentTest test  = new ConsignmentTest();
//		if (trace) {
//			logger.debug("supply: " + supply);
//		}
//		assertTrue(test.isSupplyEligibleForDemand(supply, demand, planningData));
//		supply = planningData.getSupplyOnhand("TORONTO-1012953-127-2017-07-29");
//		assertFalse(test.isSupplyEligibleForDemand(supply, demand, planningData));
//		
//	}
//	
//	@Test 
//	public void supplyIsBuybackTest() {
//		
//	}
//	
//	@Test
//	public void expireTest() {
//		
//	}
//
//	@Test
//	public void certTest() {
//		logger.debug("CertTest");
//		CertTest filter = new CertTest();
//		assertTrue(filter.isSupplyEligibleForDemand(supply, demand, planningData));
//		
//		IcCertCd cert = planningData.getIcCertCdById("MFGCOFC");
//		assertNotNull(cert);
//		ArrayList<IcCertCd> certs = new ArrayList<IcCertCd>();
//		certs.add(cert);
//		demand.setIcCertCds(certs);
//		assertFalse(filter.isSupplyEligibleForDemand(supply, demand, planningData));
//		
//
//	}
//
//	public void contractTest()  {
//
//	}
//
//
//	public void expiryDateTest() {
//	}
//
//	//@Test
//	public void manufacturerTest() {
//
//		
//		CustomerItemManufacturerTest mfrTest = new CustomerItemManufacturerTest();
//		
//		
//		// explicit manufacturer  
//		supply.setOrgNbrMfr(11);
//		demand.setOrgNbrMfrRqst(11);
//		assertTrue(mfrTest.isSupplyEligibleForDemand(supply, demand, planningData));
//		
//		
//		// explicit manufacturer  
//		supply.setOrgNbrMfr(11);
//		demand.setOrgNbrMfrRqst(12);
//		assertFalse(mfrTest.isSupplyEligibleForDemand(supply, demand, planningData));
//		
//
//		// explicit manufacturer  
//	
//		supply.setOrgNbrMfr(8332);
//		demand.setOrgNbrMfrRqst(null);
//		assertTrue(mfrTest.isSupplyEligibleForDemand(supply, demand, planningData));
//		
//		// explicit manufacturer 
//
//		supply.setOrgNbrMfr(11);
//		demand.setOrgNbrMfrRqst(null);
//		assertFalse(mfrTest.isSupplyEligibleForDemand(supply, demand, planningData));	
//		
//		logger.debug("testApprovedManufacturer complete");
//	}
//
//	public void countryOfOriginTest() {
//	
//	}
//
//	public void customerItemManufacturerTest() {
//
//	}
//
//	public void revisionLevelTest() {
//
//	}
//	
//
//
//}
