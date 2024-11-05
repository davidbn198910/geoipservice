package com.odav1d.geoservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;



@SpringBootApplication
@EnableCaching
public class GeoipserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(GeoipserviceApplication.class, args);
	}

}
