package com.pacificdataservices.diamond.apsweb;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.javautil.core.misc.Timer;
import org.javautil.dataset.MatrixDataset;
import org.javautil.file.FileHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.pacificdataservices.diamond.planning.Allocator;
import com.pacificdataservices.diamond.planning.data.ForecastBuckets;
import com.pacificdataservices.diamond.planning.data.PlanGroupPipeline;
import com.pacificdataservices.diamond.planning.data.PlanningData;
import com.pacificdataservices.diamond.planning.demand.ForecastGroups;
import com.pacificdataservices.diamond.planning.json.PlanningDataMarshallable;
import com.pacificdataservices.diamond.rules.CustomerItemManufacturerRules;

public class PlanningResultController {
	private PlanningDataMarshallable pdm;

	private Logger analytics = LoggerFactory.getLogger(getClass());

	private Logger logger = LoggerFactory.getLogger(getClass());

	@GetMapping("/planningResult")
	public String plan(@RequestParam(name="partCd", required=true) String partCd, Model model) throws IOException {
		String partDescription="The description";
		model.addAttribute("partCd", partCd);
		model.addAttribute("partDescription",partDescription);
		String apsJson = getPlanningJson();
		model.addAttribute("apsJson",apsJson);
		PlanningData pd = getPlanningInfo();
		CustomerItemManufacturerRules cimr = pd.getCustomerItemManufacturerRules();
		List<MatrixDataset> cimrds = cimr.getCrosstabs();
		model.addAttribute("cimr",cimrds);
		model.addAttribute("pdm",pd);

		ForecastGroups forecastGroups= pd.getForecastGroups();
		for (ForecastBuckets fb : forecastGroups.getForecastBuckets()) {
			logger.info("fcItemMast {}, icItemMast {}", fb.getFcItemMast(), fb.getIcItemMast());
		}
		model.addAttribute("forecastGroups",forecastGroups);
		model.addAttribute("orderGroups",pd.getOrderGroups());
		PlanGroupPipeline pipeline = new PlanGroupPipeline(pd);
		model.addAttribute("pipeline",pipeline);
		return "plan";
	}


	PlanningData getPlanningInfo() throws IOException {
		PlanningData pd = PlanningDataMarshallable.planningDataFromFile(new File("src/main/resources/static/data/planGroup10.plandata.json"));
		int customerOrderCount = pd.getDemandCustomerById().values().size();
		System.out.println("Customer order count: " + customerOrderCount);
		Timer t = new Timer("allocate");
		Allocator allocator = new Allocator(pd);
		allocator.allocate();
		analytics.info("allocation {}", t.getElapsedMicros());

		return pd;
	}



	String getPlanningJson() {
		String json = null;
		try {
			json = FileHelper.getFileText("src/main/resources/static/data/10.json");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return json;
	}

}
