package com.odav1d.geoservice.integration.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.odav1d.geoservice.integration.model.CountryApiResponse;

@Service
public class CountryApiClient {

    private final RestTemplate restTemplate;

    // URL de la API de RestCountries
    private static final String COUNTRY_API_URL = "https://restcountries.com/v3.1/alpha/{countryCode}";

    @Autowired
    public CountryApiClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Cacheable(value = "countryCache", cacheManager = "countryCacheManager", key = "#countryCode")
    public CountryApiResponse getCountryInfo(String countryCode) {    
    	System.out.println("Consumo del servicio con el country code "+countryCode);
        CountryApiResponse[] response = restTemplate.getForObject(COUNTRY_API_URL, CountryApiResponse[].class, countryCode);
        return response[0];
    }
}