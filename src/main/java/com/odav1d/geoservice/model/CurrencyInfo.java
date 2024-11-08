package com.odav1d.geoservice.model;

public class CurrencyInfo {
	private String code;
	private String name; 
	private String symbol;
	private String lastRate;
	private String lastRateCurrency;
	
	
	public CurrencyInfo(String code, String name, String symbol) {
        this.code = code;
        this.name = name;
        this.symbol = symbol;
    }
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
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

	public String getLastRate() {
		return lastRate;
	}

	public void setLastRate(String lastRate) {
		this.lastRate = lastRate;
	}

	public String getLastRateCurrency() {
		return lastRateCurrency;
	}

	public void setLastRateCurrency(String lastRateCurrency) {
		this.lastRateCurrency = lastRateCurrency;
	}
	
	
}
