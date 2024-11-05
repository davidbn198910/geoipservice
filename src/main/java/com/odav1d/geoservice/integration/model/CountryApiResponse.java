package com.odav1d.geoservice.integration.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.odav1d.geoservice.model.CurrencyInfo;

import java.util.List;
import java.util.Map;

public class CountryApiResponse {

    private Name name;
    private Map<String, Currency> currencies;
    private List<String> timezones;
    private Map<String, String> languages;
    private List <CurrencyInfo> currenciesDetail;

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }


    public List<String> getTimezones() {
        return timezones;
    }

    public void setTimezones(List<String> timezones) {
        this.timezones = timezones;
    }

    public Map<String, Currency> getCurrencies() {
		return currencies;
	}

	public void setCurrencies(Map<String, Currency> currencies) {
		this.currencies = currencies;
	}

	public static class Name {
        private String common;
        private String official;

        @JsonProperty("common")
        public String getCommon() {
            return common;
        }

        public void setCommon(String common) {
            this.common = common;
        }

        @JsonProperty("official")
        public String getOfficial() {
            return official;
        }

        public void setOfficial(String official) {
            this.official = official;
        }
    }

    public static class Currency {
        private String name;
        private String symbol;

        // Getters y Setters

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getSymbol() {
            return symbol;
        }

        public void setSymbol(String symbol) {
            this.symbol = symbol;
        }
    }

	public Map<String, String> getLanguages() {
		return languages;
	}

	public void setLanguages(Map<String, String> languages) {
		this.languages = languages;
	}

	public List<CurrencyInfo> getCurrenciesDetail() {
		return currenciesDetail;
	}

	public void setCurrenciesDetail(List<CurrencyInfo> currenciesDetail) {
		this.currenciesDetail = currenciesDetail;
	}
	
    
}