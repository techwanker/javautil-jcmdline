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

public class MenuController {

	private Logger analytics = LoggerFactory.getLogger(getClass());

	private Logger logger = LoggerFactory.getLogger(getClass());

	@GetMapping("/menu")
	
	public String index(@RequestParam(name="partCd", required=true) String partCd,Model model) throws IOException {
		logger.error("We have arrived");
		return "menu";
	}

}
