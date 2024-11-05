package com.odav1d.geoservice.config;

import com.github.benmanes.caffeine.cache.Caffeine;
import org.springframework.cache.CacheManager;
import org.springframework.cache.caffeine.CaffeineCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import java.util.concurrent.TimeUnit;

@Configuration
public class CacheConfig {

    @Bean
    @Primary
    public CacheManager countryCacheManager() {
        CaffeineCacheManager cacheManager = new CaffeineCacheManager("countryCache");
        cacheManager.setCaffeine(Caffeine.newBuilder().expireAfterWrite(12, TimeUnit.HOURS));
        return cacheManager;
    }

    
    @Bean
    public CacheManager ipCacheManager() {
        CaffeineCacheManager cacheManager = new CaffeineCacheManager("ipCache");
        cacheManager.setCaffeine(Caffeine.newBuilder().expireAfterWrite(1, TimeUnit.MINUTES));
        return cacheManager;
    }
    
    @Bean
    public CacheManager currencyCacheManager() {
        CaffeineCacheManager cacheManager = new CaffeineCacheManager("currencyCache");
        cacheManager.setCaffeine(Caffeine.newBuilder().expireAfterWrite(1, TimeUnit.HOURS));
        return cacheManager;
    }
    
    @Bean
    public CacheManager generalCacheManager() {
        CaffeineCacheManager cacheManager = new CaffeineCacheManager("generalCache");
        cacheManager.setCaffeine(Caffeine.newBuilder().expireAfterWrite(1, TimeUnit.HOURS));
        return cacheManager;
    }
}
