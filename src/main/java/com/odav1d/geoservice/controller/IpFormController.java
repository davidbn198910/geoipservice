package com.odav1d.geoservice.controller;

import com.odav1d.geoservice.model.IpInfo;
import com.odav1d.geoservice.model.IpRequest;
import com.odav1d.geoservice.service.IpTraceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.validation.Valid;
import org.springframework.validation.BindingResult;
@Controller
@Validated
public class IpFormController {

    @Autowired
    private IpTraceService ipTraceService;

    // Método para mostrar el formulario
    @GetMapping("/ipform")
    public String showForm(Model model) {
        model.addAttribute("ipRequest", new IpRequest());
        return "ipform";
    }

    // Método para procesar la IP ingresada
    @PostMapping("/processIp")
    public String processIp(@Valid IpRequest ipRequest, BindingResult result, Model model) {
    	if (result.hasErrors()) {
            return "ipform";  
        }
        IpInfo ipInfo = ipTraceService.traceIp(ipRequest.getIpAddress());
        model.addAttribute("ipInfo", ipInfo);
        return "ipGeoProcessResult";
    }
    
    
}