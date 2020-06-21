package com.pacificdataservices.diamond.apsweb;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PlanQueryDialogController {

	
	
	private Logger analytics = LoggerFactory.getLogger(getClass());

	private Logger logger = LoggerFactory.getLogger(getClass());

    @GetMapping("/planQuery")
    public String query(Model model) throws IOException {
        return "PlanQueryDialog";
    }
    
    

}
