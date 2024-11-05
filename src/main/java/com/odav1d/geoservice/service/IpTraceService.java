package com.odav1d.geoservice.service;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List; 
import java.util.Map;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.odav1d.geoservice.integration.client.CountryApiClient;
import com.odav1d.geoservice.integration.client.CurrencyApiClient;
import com.odav1d.geoservice.integration.client.IpApiClient;
import com.odav1d.geoservice.integration.model.ConsumptionStatisticsResponse;
import com.odav1d.geoservice.integration.model.CountryApiResponse;
import com.odav1d.geoservice.integration.model.CurrencyApiResponse;
import com.odav1d.geoservice.integration.model.IpApiResponse;
import com.odav1d.geoservice.integration.model.entity.IpTraceRecord;
import com.odav1d.geoservice.model.CurrencyInfo;
import com.odav1d.geoservice.model.IpInfo;
import com.odav1d.geoservice.repository.IpTraceRecordRepository;
import lombok.Data;

@Service
public class IpTraceService implements IpTraceServiceInterface {

    public final IpApiClient ipApiClient;
    public final CountryApiClient countryApiClient;
    private final CurrencyApiClient currencyApiClient;
    private final IpTraceRecordRepository ipTraceRecordRepository;
   
    @Value("${location.buenosaires.latitude}")
    private double buenosAiresLatitude;
    @Value("${location.buenosaires.longitude}")
    private double buenosAiresLongitude;
    private static final int EARTH_RADIUS = 6371;
   
    @Autowired
    public IpTraceService(IpApiClient ipApiClient, CountryApiClient countryApiClient, CurrencyApiClient currencyApiClient, IpTraceRecordRepository ipTraceRecordRepository) {
        this.ipApiClient = ipApiClient;
		this.countryApiClient = countryApiClient;
		this.currencyApiClient = currencyApiClient;
		this.ipTraceRecordRepository = ipTraceRecordRepository;
    }

    @Override
    public IpInfo traceIp(String ipAddress) {
        IpApiResponse ipApiResponse = ipApiClient.getGeoLocation(ipAddress);
        if(ipApiResponse.getCountryCode() == null) {
        	throw new NoSuchElementException("La IP no fue reconocida como pública.");
        }
        CountryApiResponse countryApiResponse = getCountryData(ipApiResponse.getCountryCode());
        List<CurrencyInfo> currencyInfoComplete = new ArrayList<>();
        for (CurrencyInfo currency : countryApiResponse.getCurrenciesDetail()) {        	
        	CurrencyApiResponse currencyApiResponse = currencyApiClient.getLatestCurrencyRate(currency.getCode());
        	currency.setLastRate(String.valueOf(currencyApiResponse.getData().getUsd().getValue()));
        	currency.setLastRateCurrency(currencyApiResponse.getData().getUsd().getCode());
        	currencyInfoComplete.add(currency);        	
        }

        double distance = haversine(buenosAiresLatitude, buenosAiresLongitude, ipApiResponse.getLatitude(), ipApiResponse.getLongitude());
   
        saveIpTraceRecord(ipApiResponse, distance);
        
        IpInfo ipInfo = new IpInfo();        
        ipInfo.setIp(ipApiResponse.getIp());
        ipInfo.setFechaActual(LocalDateTime.now());
        ipInfo.setPais(ipApiResponse.getCountryName());
        ipInfo.setIsoCode(ipApiResponse.getCountryCode());
        ipInfo.setCiudad(ipApiResponse.getCity());
        ipInfo.setHora(getCurrentTimeInZones(countryApiResponse.getTimezones()));
        ipInfo.setCurrencies(currencyInfoComplete);
        ipInfo.setLanguages(countryApiResponse.getLanguages());
        ipInfo.setDistancia(distance);
        
        return ipInfo;
    }

    @Override
    public CountryApiResponse getCountryData(String countryCode) {
    	System.out.println("Consumo método de procesar país " + countryCode);
    	CountryApiResponse countryApiResponse = countryApiClient.getCountryInfo(countryCode);
    	if (countryApiResponse == null) {
            throw new RuntimeException("No se pudo obtener información del servicio de países para el código: " + countryCode);
        }

        List<CurrencyInfo> currencies = new ArrayList<>();
        Map<String, CountryApiResponse.Currency> currencyMap = countryApiResponse.getCurrencies();

        if (currencyMap != null) {
            for (Map.Entry<String, CountryApiResponse.Currency> entry : currencyMap.entrySet()) {
                CountryApiResponse.Currency currency = entry.getValue();
                if (currency != null) {
                    CurrencyInfo currencyInfo = new CurrencyInfo(entry.getKey(), currency.getName(), currency.getSymbol());
                    currencies.add(currencyInfo);
                }
            }
        }
        countryApiResponse.setCurrenciesDetail(currencies);
		return countryApiResponse;
    }

    @Override
    public List<String> getCurrentTimeInZones(List<String> timeZones) {
    	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now(ZoneOffset.UTC);
        List<String> timesInZones = new ArrayList<>();
        for (String zone : timeZones) {
            try {
            	if(zone.equals("UTC")) {
            		zone = "UTC+00:00";
            	}
                ZoneOffset offset = ZoneOffset.of(zone.replace("UTC", ""));
                LocalDateTime localTime = now.atOffset(ZoneOffset.UTC).withOffsetSameInstant(offset).toLocalDateTime();
                timesInZones.add("Hora en " + zone + ": " + localTime.format(formatter));
            } catch (Exception e) {
            	timesInZones.add("Zona horaria inválida: " + zone);
            }
        }
        return timesInZones;
    }

    @Override
    public double haversine(double lat1, double lon1, double lat2, double lon2) {
        double dLat = Math.toRadians(lat2 - lat1);
        double dLon = Math.toRadians(lon1 - lon2);
        double a = Math.sin(dLat / 2) * Math.sin(dLat / 2)
                + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2))
                * Math.sin(dLon / 2) * Math.sin(dLon / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        return Math.round(EARTH_RADIUS * c);
    }

    @Override
    public ConsumptionStatisticsResponse getConsumptionStatistics() {
    	ConsumptionStatisticsResponse response = new ConsumptionStatisticsResponse();
    	response.setListaTotal(ipTraceRecordRepository.findAll());
		return response;
    }

    private void saveIpTraceRecord(IpApiResponse ipApiResponse, double distance) {
        IpTraceRecord record = new IpTraceRecord();
        record.setIpAddress(ipApiResponse.getIp());
        record.setCountry(ipApiResponse.getCountryName());
        record.setCity(ipApiResponse.getCity());
        record.setDistanceToBuenosAires(distance);
        record.setTimestamp(LocalDateTime.now());

        ipTraceRecordRepository.save(record);
    }
}
