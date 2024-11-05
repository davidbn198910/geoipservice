package com.odav1d.geoservice.integration.model;

import java.util.List;
import java.util.Map;

public class TraceStatistics {
    private List<Map<String, Object>> countRequestsByCityCountryAndDistance;

	public List<Map<String, Object>> getCountRequestsByCityCountryAndDistance() {
		return countRequestsByCityCountryAndDistance;
	}

	public void setCountRequestsByCityCountryAndDistance(List<Map<String, Object>> countRequestsByCityCountryAndDistance) {
		this.countRequestsByCityCountryAndDistance = countRequestsByCityCountryAndDistance;
	}
    
    
}
