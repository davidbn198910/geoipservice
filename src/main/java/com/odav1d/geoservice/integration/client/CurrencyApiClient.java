package com.odav1d.geoservice.integration.client;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.odav1d.geoservice.integration.model.CurrencyApiResponse;

@Service
public class CurrencyApiClient {

    private final RestTemplate restTemplate;
    private final String baseUrl;
    private final String apiKey;
    private final String currencies;

    public CurrencyApiClient(
            RestTemplate restTemplate,
            @Value("${currency.api.base.url}") String baseUrl,
            @Value("${currency.api.key}") String apiKey,
            @Value("${currency.api.currencies}") String currencies) {
        this.restTemplate = restTemplate;
        this.baseUrl = baseUrl;
        this.apiKey = apiKey;
        this.currencies = currencies;
    }
    
    @Cacheable(value = "currencyCache", cacheManager = "currencyCacheManager", key = "#baseCurrency")
    public CurrencyApiResponse getLatestCurrencyRate(String baseCurrency) {
    	System.out.println("Consumo de servicio de divisas con el baseCurrency "+baseCurrency);
        String url = UriComponentsBuilder.fromHttpUrl(baseUrl)
                .queryParam("base_currency", baseCurrency)
                .queryParam("currencies", currencies)
                .queryParam("apikey", apiKey)
                .toUriString();

        return restTemplate.getForObject(url, CurrencyApiResponse.class);
        
    }
}
