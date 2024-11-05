package com.odav1d.geoservice.model;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public class IpRequest {

    @NotNull(message = "La dirección IP es obligatoria")
   /* @Pattern(
        regexp = "^((25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(25[0-5]|2[0-4][0-9]?)$",
        message = "La dirección IP no tiene un formato válido"
    )*/
    @Pattern(
    	    regexp = "^((25[0-5]|2[0-4][0-9]|1[0-9][0-9]|[1-9]?[0-9])\\.){3}(25[0-5]|2[0-4][0-9]|1[0-9][0-9]|[1-9]?[0-9])$",
    	    message = "La dirección IP no tiene un formato válido"
    	)
    private String ipAddress;

    // Constructor vacío y getters/setters
    public IpRequest() {}

    public IpRequest(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }
}
