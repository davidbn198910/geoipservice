package com.odav1d.geoservice.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;

import com.odav1d.geoservice.integration.model.GeneralStatistics;
import com.odav1d.geoservice.service.IpTraceStatisticsService;


@Controller
@Validated
public class IpStatisticsController {
	
	@Autowired
    private IpTraceStatisticsService ipTraceStatisticsService;
	
	@GetMapping("/getStatistics")
    public String getall(Model model) {
		GeneralStatistics generalStatistics = ipTraceStatisticsService.requestsByCountryStatistics();
		
		
		model.addAttribute("generalStatistics", generalStatistics);    	
        return "statistics";
    }

}
