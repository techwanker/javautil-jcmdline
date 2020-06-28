package com.pacificdataservices.diamond.apsweb;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.List;

import org.javautil.core.misc.Timer;
import org.javautil.dataset.MatrixDataset;
import org.javautil.file.FileHelper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.pacificdataservices.diamond.planning.Allocator;
import com.pacificdataservices.diamond.planning.data.ForecastBuckets;
import com.pacificdataservices.diamond.planning.data.PlanGroupPipeline;
import com.pacificdataservices.diamond.planning.data.PlanningData;
import com.pacificdataservices.diamond.planning.json.PlanningDataMarshallable;
import com.pacificdataservices.diamond.planning.demand.ForecastGroups;
import com.pacificdataservices.diamond.rules.CustomerItemManufacturerRules;

@Controller
public class PricePerUnitController {

	
	private PlanningDataMarshallable pdm;
	
	private Logger analytics = LoggerFactory.getLogger(getClass());

	private Logger logger = LoggerFactory.getLogger(getClass());


    @GetMapping("/pricePerUnit")
    public String pricePerUnit(@RequestParam(name="partCd", required=true) String partCd, Model model) throws IOException {

        return "pricePerUnit";
    }
    
    @GetMapping("/ppu")
    public String ppu( Model model) throws IOException {

        return "pricePerUnit";
    }
   

}
