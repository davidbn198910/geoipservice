package com.odav1d.geoservice.integration.model;

import java.util.List;

import com.odav1d.geoservice.integration.model.entity.IpTraceRecord;

public class GeneralStatistics {
	private List<RequestsByCountryStatistics> requestsByCountryStatistics ;
	private IpTraceRecord shorterDistance;
	private IpTraceRecord largerDistance;
	private double averageDistance;
	
	
	public List<RequestsByCountryStatistics> getRequestsByCountryStatistics() {
		return requestsByCountryStatistics;
	}
	public void setRequestsByCountryStatistics(List<RequestsByCountryStatistics> requestsByCountryStatistics) {
		this.requestsByCountryStatistics = requestsByCountryStatistics;
	}
	public IpTraceRecord getShorterDistance() {
		return shorterDistance;
	}
	public void setShorterDistance(IpTraceRecord shorterDistance) {
		this.shorterDistance = shorterDistance;
	}
	
	public double getAverageDistance() {
		return averageDistance;
	}
	public void setAverageDistance(double averageDistance) {
		this.averageDistance = averageDistance;
	}
	public IpTraceRecord getLargerDistance() {
		return largerDistance;
	}
	public void setLargerDistance(IpTraceRecord largerDistance) {
		this.largerDistance = largerDistance;
	}
	
	
	
	

}
