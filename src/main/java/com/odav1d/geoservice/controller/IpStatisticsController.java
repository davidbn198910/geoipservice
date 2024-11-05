package com.odav1d.geoservice.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import com.odav1d.geoservice.service.IpTraceStatisticsServiceInterface;


@Controller
@Validated
public class IpStatisticsController {
	
	@Autowired
	private final IpTraceStatisticsServiceInterface ipTraceStatisticsService;

	@Autowired
    public IpStatisticsController(IpTraceStatisticsServiceInterface ipTraceStatisticsService) {
        this.ipTraceStatisticsService = ipTraceStatisticsService;
    }
	
	@GetMapping("/getStatistics")
    public String getall(Model model) {
		model.addAttribute("generalStatistics", ipTraceStatisticsService.requestsByCountryStatistics());    	
        return "statistics";
    }

}
