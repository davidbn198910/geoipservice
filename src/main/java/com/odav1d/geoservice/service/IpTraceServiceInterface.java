package com.odav1d.geoservice.service;

import com.odav1d.geoservice.integration.model.ConsumptionStatisticsResponse;
import com.odav1d.geoservice.integration.model.CountryApiResponse;
import com.odav1d.geoservice.model.IpInfo;

import java.util.List;

public interface IpTraceServiceInterface {

    IpInfo traceIp(String ipAddress);

    CountryApiResponse getCountryData(String countryCode);

    List<String> getCurrentTimeInZones(List<String> timeZones);

    double haversine(double lat1, double lon1, double lat2, double lon2);

    ConsumptionStatisticsResponse getConsumptionStatistics();
}
