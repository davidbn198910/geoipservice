package com.odav1d.geoservice.integration.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.odav1d.geoservice.integration.model.IpApiResponse;

@Service
public class IpApiClient {

    private final RestTemplate restTemplate;
    private final String apiKey;
    private final String baseUrl;

    public IpApiClient(RestTemplate restTemplate, 
                       @Value("${ipapi.api.key}") String apiKey, 
                       @Value("${ipapi.url}") String baseUrl) {
        this.restTemplate = restTemplate;
        this.apiKey = apiKey;
        this.baseUrl = baseUrl;
    }
    
    @Cacheable(value = "ipCache", cacheManager = "ipCacheManager", key = "#ip")
    public IpApiResponse getGeoLocation(String ip) {
    	System.out.println("Consumo del servicio de consulta ip con la ip "+ip);
        String url = UriComponentsBuilder.fromHttpUrl(baseUrl + ip)
                .queryParam("access_key", apiKey)
                .toUriString();
        System.out.println("URL Servicio"+url);
        return restTemplate.getForObject(url, IpApiResponse.class);      
       
    }
}
