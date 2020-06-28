package com.pacificdataservices.diamond.planning.webservices;


import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import org.javautil.dataset.MatrixDataset;
import org.javautil.hibernate.HibernateMarshallerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.google.gson.Gson;
import com.pacificdataservices.diamond.planning.data.ForecastBuckets;
import com.pacificdataservices.diamond.planning.data.PlanGroupPipeline;
import com.pacificdataservices.diamond.planning.data.PlanningData;
import com.pacificdataservices.diamond.planning.demand.ForecastGroups;
import com.pacificdataservices.diamond.planning.json.PlanningDataMarshallable;
import com.pacificdataservices.diamond.planning.services.PlanningDataService;
import com.pacificdataservices.diamond.rules.CustomerItemManufacturerRules;
@Controller
public class PlanningResultsController {
	private PlanningDataMarshallable pdm;

	private Logger analytics = LoggerFactory.getLogger(getClass());

	private Logger logger = LoggerFactory.getLogger(getClass());
	@Autowired
	private PlanningDataService pds;

	@GetMapping("/plan")
	public String plan(@RequestParam(name="partCd", required=true) String partCd, Model model) throws IOException, SQLException {
		String partDescription="The description";
		model.addAttribute("partCd", partCd);
		model.addAttribute("partDescription",partDescription);


		PlanningData planningData = pds.getPlanningDataForPartCd(partCd);
		PlanningDataMarshallable planningDataMarshallable = new PlanningDataMarshallable(planningData);

		model.addAttribute("planningData",planningDataMarshallable);

		CustomerItemManufacturerRules cimr = planningData.getCustomerItemManufacturerRules();
		List<MatrixDataset> cimrds = cimr.getCrosstabs();

		model.addAttribute("cimr",cimrds);


		ForecastGroups forecastGroups= planningData.getForecastGroups();
		for (ForecastBuckets fb : forecastGroups.getForecastBuckets()) {
			logger.info("fcItemMast {}, icItemMast {}", fb.getFcItemMast(), fb.getIcItemMast());
		}
		model.addAttribute("forecastGroups",forecastGroups);
		model.addAttribute("orderGroups",planningData.getOrderGroups());
		PlanGroupPipeline pipeline = new PlanGroupPipeline(planningData);
		model.addAttribute("pipeline",pipeline);
		return "plan";
	}
	//	public String getPlanningResultsAsJson(String partCd) throws IOException {
	//		
	//		ConcurrentModel model  = getPlanningResultsAsConcurrentModel(partCd);
	//		Gson dillon  = HibernateMarshallerFactory.getHibernateGsonWithProxyDateFormatter();
	//		String retval = dillon.toJson(model);
	//		return retval;
	//	}
	//	public ConcurrentModel getPlanningResultsConcurrentModel(String partCd) {
	//		ConcurrentModel model  = new ConcurrentModel();
	//		
	//		return model;
	//	}
	//
	//	public ConcurrentModel getPlanningResultsAsConcurrentModel(String partCd) {
	//		ConcurrentModel model  = new ConcurrentModel();
	//		String partDescription="The description";
	//		model.addAttribute("partCd", partCd);
	//		model.addAttribute("partDescription",partDescription);
	//		
	//		
	//		PlanningData planningData = pds.getPlanningDataForPartCd(partCd);
	//		PlanningDataMarshallable planningDataMarshallable = new PlanningDataMarshallable(planningData);
	//							
	//		model.addAttribute("planningData",planningDataMarshallable);
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
	//		model.addAttribute("forecastGroups",forecastGroups);
	//		model.addAttribute("orderGroups",planningData.getOrderGroups());
	//		PlanGroupPipeline pipeline = new PlanGroupPipeline(planningData);
	//		model.addAttribute("pipeline",pipeline);
	//		return model;
	//	}

	//	PlanningData getPlanningInfo() throws IOException {
	//		PlanningData pd = PlanningDataMarshallable.planningDataFromFile(new File("src/main/resources/static/data/planGroup10.plandata.json"));
	//		int customerOrderCount = pd.getDemandCustomerById().values().size();
	//		System.out.println("Customer order count: " + customerOrderCount);
	//		Timer t = new Timer("allocate");
	//		Allocator allocator = new Allocator(pd);
	//		allocator.allocate();
	//		analytics.info("allocation {}", t.getElapsedMicros());
	//
	//		return pd;
	//	}
	//
	//
	//
	//	String getPlanningJson() {
	//		String json = null;
	//		try {
	//			json = FileHelper.getFileText("src/main/resources/static/data/10.json");
	//		} catch (IOException e) {
	//			e.printStackTrace();
	//		}
	//		return json;
	//	}

}
