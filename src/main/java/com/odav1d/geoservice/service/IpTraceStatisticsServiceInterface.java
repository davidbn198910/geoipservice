package com.odav1d.geoservice.service;

import com.odav1d.geoservice.integration.model.GeneralStatistics;

public interface IpTraceStatisticsServiceInterface {
    
    GeneralStatistics requestsByCountryStatistics();
}
