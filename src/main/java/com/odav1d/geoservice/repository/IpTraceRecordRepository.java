package com.odav1d.geoservice.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.odav1d.geoservice.integration.model.entity.IpTraceRecord;

import java.util.List;
import java.util.Map;

@Repository
public interface IpTraceRecordRepository extends JpaRepository<IpTraceRecord, Long> {

	@Query("SELECT r.city as city, r.country as country, r.distanceToBuenosAires as distance, COUNT(r) as requestCount " +
		       "FROM IpTraceRecord r " +
		       "GROUP BY r.city, r.country, r.distanceToBuenosAires")
		List<Map<String, Object>> countRequestsByCityCountryAndDistance();
	
	IpTraceRecord findTop1ByOrderByDistanceToBuenosAiresAsc();

    IpTraceRecord findTop1ByOrderByDistanceToBuenosAiresDesc();
    
    @Query("SELECT AVG(r.distanceToBuenosAires) FROM IpTraceRecord r")
    Double findAverageDistance();
}