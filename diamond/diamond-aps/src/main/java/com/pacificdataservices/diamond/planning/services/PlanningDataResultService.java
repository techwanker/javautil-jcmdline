package com.pacificdataservices.diamond.planning.services;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.pacificdataservices.diamond.planning.Allocator;
import com.pacificdataservices.diamond.planning.data.PlanningData;
import com.pacificdataservices.diamond.planning.json.PlanningDataMarshallable;
@Component
@Repository
@EnableAutoConfiguration
@Transactional
@EnableTransactionManagement
public class PlanningDataResultService {
	@Autowired
	private PlanningDataService pds;
	
	Logger logger = LoggerFactory.getLogger(getClass());
	
	String getPlanningDataJsonForItem(int itemNbr) throws SQLException {
		ArrayList<Integer> itemNbrs = new ArrayList<>();
		
		logger.debug("get planning data");
		itemNbrs.add(itemNbr);
		PlanningData planningData = pds.getPlanningData(itemNbrs);
		logger.debug("plannngData.getDemandCustomerById().size()  {}", planningData.getDemandCustomerById().size());
		
		logger.debug("allocate");
		Allocator allocator = new Allocator(planningData);
		allocator.allocate();
	
		logger.debug("marshall");
		PlanningDataMarshallable pdm = new PlanningDataMarshallable(planningData);
		String json = pdm.toJson();
		
		logger.debug("return");
		  return json;
	}
}
