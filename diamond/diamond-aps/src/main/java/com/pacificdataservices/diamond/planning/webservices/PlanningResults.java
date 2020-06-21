package com.pacificdataservices.diamond.planning.webservices;


import java.io.IOException;
import java.util.List;

import org.javautil.dataset.MatrixDataset;
import org.javautil.hibernate.HibernateMarshallerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.google.gson.Gson;
import com.pacificdataservices.diamond.planning.data.ForecastBuckets;
import com.pacificdataservices.diamond.planning.data.PlanGroupPipeline;
import com.pacificdataservices.diamond.planning.data.PlanningData;
import com.pacificdataservices.diamond.planning.demand.ForecastGroups;
import com.pacificdataservices.diamond.planning.json.PlanningDataMarshallable;
import com.pacificdataservices.diamond.planning.services.PlanningDataService;
import com.pacificdataservices.diamond.rules.CustomerItemManufacturerRules;

public class PlanningResults {
//	private PlanningDataMarshallable pdm;

//	private Logger analytics = LoggerFactory.getLogger(getClass());

	private Logger logger = LoggerFactory.getLogger(getClass());
	@Autowired
	private PlanningDataService pds;
	private	Gson dillon  = HibernateMarshallerFactory.getHibernateGsonWithProxyDateFormatter();

    public String toJson(PlanningData planningData) {
		return dillon.toJson(toConcurrentModel(planningData));
    }
    
	public  ConcurrentModel toConcurrentModel(PlanningData planningData) {
		ConcurrentModel model  = new ConcurrentModel();

		PlanningDataMarshallable planningDataMarshallable = new PlanningDataMarshallable(planningData);
							
		model.addAttribute("planningData",planningDataMarshallable);
		
		CustomerItemManufacturerRules cimr = planningData.getCustomerItemManufacturerRules();
		List<MatrixDataset> cimrds = cimr.getCrosstabs();
		model.addAttribute("cimr",cimrds);
//	

		ForecastGroups forecastGroups= planningData.getForecastGroups();
//		 TODO set icItemMast in FcItemMast in GraphBuilder
//		for (ForecastBuckets fb : forecastGroups.getForecastBuckets()) {
//			logger.info("fcItemMast {}, icItemMast {}", fb.getFcItemMast(), fb.getIcItemMast());
//		}
//		model.addAttribute("forecastGroups",forecastGroups);i
//		logger.info("<forecastGroups string\n{}\n/forecastGroups",forecastGroups);
//		logger.info("<forecastBucketsToString\n{}/forecastBucketsToString>",forecastGroups.forecastBucketsToString());
//		logger.info("<forecastGroupsToJson\n{}\n/forecastGroupsToJson>", forecastGroups.toJson());
		
		
//		model.addAttribute("orderGroups",planningData.getOrderGroups());
//		
		PlanGroupPipeline pipeline = new PlanGroupPipeline(planningData);
		logger.debug("PlanGroupPipeline\n{}",pipeline);
		String pipelineJson = dillon.toJson(pipeline);
		logger.debug("pipelineJson {}", pipelineJson);
		// TODO jjs overflow
    	model.addAttribute("pipeline",pipeline);
//		
//		logger.info("model {}",model);
		return model;
	}

	public String getPlanningResultsAsJson(String partCd) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

//	public String getPlanningResultsAsJson(String partCd) throws IOException {
//		
//		ConcurrentModel model  = getPlanningResultsAsConcurrentModel(partCd);
//		String retval = dillon.toJson(model);
//		return retval;
//	}

//	@Deprecated
//	
//	public ConcurrentModel getPlanningResultsAsConcurrentModel(String partCd) {
//		ConcurrentModel model  = new ConcurrentModel();
//		String partDescription="The description";
//		model.addAttribute("partCd", partCd);
//		model.addAttribute("partDescription",partDescription);
//		
//		
//		PlanningData planningData = pds.getPlanningDataForPartCd(partCd);
//	//	PlanningDataMarshallable planningDataMarshallable = new PlanningDataMarshallable(planningData);
//							
//	//	model.addAttribute("planningData",planningDataMarshallable);
//		
//		CustomerItemManufacturerRules cimr = planningData.getCustomerItemManufacturerRules();
//		List<MatrixDataset> cimrds = cimr.getCrosstabs();
//		
//		model.addAttribute("cimr",cimrds);
//	
//
//		ForecastGroups forecastGroups= planningData.getForecastGroups();
//		for (ForecastBuckets fb : forecastGroups.getForecastBuckets()) {
//			logger.info("fcItemMast {}, icItemMast {}", fb.getFcItemMast(), fb.getIcItemMast());
//		}
//	//	model.addAttribute("forecastGroups",forecastGroups);
//	//	model.addAttribute("orderGroups",planningData.getOrderGroups());
//		PlanGroupPipeline pipeline = new PlanGroupPipeline(planningData);
//		model.addAttribute("pipeline",pipeline);
//		logger.info("model {}", model);
//		return model;
//	}
}
