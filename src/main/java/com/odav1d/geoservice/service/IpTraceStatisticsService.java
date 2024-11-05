package com.odav1d.geoservice.service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.odav1d.geoservice.integration.model.GeneralStatistics;
import com.odav1d.geoservice.integration.model.RequestsByCountryStatistics;
import com.odav1d.geoservice.repository.IpTraceRecordRepository;

@Service
public class IpTraceStatisticsService implements IpTraceStatisticsServiceInterface {
    
    private final IpTraceRecordRepository ipTraceRecordRepository;

    @Autowired
    public IpTraceStatisticsService(IpTraceRecordRepository ipTraceRecordRepository) {
        this.ipTraceRecordRepository = ipTraceRecordRepository;
    }

    @Override
    public GeneralStatistics requestsByCountryStatistics() {
        GeneralStatistics generalStatistics = new GeneralStatistics();
        List<Map<String, Object>> requestsByCountryStatistics = ipTraceRecordRepository.countRequestsByCityCountryAndDistance();

        generalStatistics.setRequestsByCountryStatistics(requestsByCountryStatistics.stream()
            .map(row -> new RequestsByCountryStatistics(
                    (String) row.get("city"),
                    (String) row.get("country"),
                    (double) row.get("distance"),
                    ((Number) row.get("requestCount")).longValue()
                ))
            .collect(Collectors.toList()));
        generalStatistics.setLargerDistance(ipTraceRecordRepository.findTop1ByOrderByDistanceToBuenosAiresDesc());
        generalStatistics.setShorterDistance(ipTraceRecordRepository.findTop1ByOrderByDistanceToBuenosAiresAsc());
        generalStatistics.setAverageDistance(ipTraceRecordRepository.findAverageDistance());

        return generalStatistics;
    }
}
