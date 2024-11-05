package com.odav1d.geoservice.model;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

public class IpInfo {
    private String ip;
    private LocalDateTime fechaActual;
    private String pais;
    private String ciudad;
    private String isoCode;
    private String idiomas;
    private List<CurrencyInfo> currencies;
    private List<String> hora;
    private Map<String, String> languages;
    private Double distancia;
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public LocalDateTime getFechaActual() {
		return fechaActual;
	}
	public void setFechaActual(LocalDateTime fechaActual) {
		this.fechaActual = fechaActual;
	}
	public String getPais() {
		return pais;
	}
	public void setPais(String pais) {
		this.pais = pais;
	}
	public String getIsoCode() {
		return isoCode;
	}
	public void setIsoCode(String isoCode) {
		this.isoCode = isoCode;
	}
	public String getIdiomas() {
		return idiomas;
	}
	public void setIdiomas(String idiomas) {
		this.idiomas = idiomas;
	}
	
	public List<String> getHora() {
		return hora;
	}
	public void setHora(List<String> hora) {
		this.hora = hora;
	}
	public Double getDistancia() {
		return distancia;
	}
	public void setDistancia(double d) {
		this.distancia = d;
	}
	public List<CurrencyInfo> getCurrencies() {
		return currencies;
	}
	public void setCurrencies(List<CurrencyInfo> currencies) {
		this.currencies = currencies;
	}
	public Map<String, String> getLanguages() {
		return languages;
	}
	public void setLanguages(Map<String, String> languages) {
		this.languages = languages;
	}
	public String getCiudad() {
		return ciudad;
	}
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	public void setDistancia(Double distancia) {
		this.distancia = distancia;
	}
	
	
	
	

    
}
