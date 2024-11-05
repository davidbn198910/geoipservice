package com.odav1d.geoservice.integration.model;

public class RequestsByCountryStatistics {

    private String city;
    private String country;
    private double distance;
    private long requestCount;

    // Constructor con parámetros
    public RequestsByCountryStatistics(String city, String country, double distance, long requestCount) {
        this.city = city;
        this.country = country;
        this.distance = distance;
        this.requestCount = requestCount;
    }

    // Getters y setters
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public long getRequestCount() {
        return requestCount;
    }

    public void setRequestCount(long requestCount) {
        this.requestCount = requestCount;
    }

    // Método toString para facilitar la depuración
    @Override
    public String toString() {
        return "RequestsByCountryStatistics{" +
                "city='" + city + '\'' +
                ", country='" + country + '\'' +
                ", distance=" + distance +
                ", requestCount=" + requestCount +
                '}';
    }
}
