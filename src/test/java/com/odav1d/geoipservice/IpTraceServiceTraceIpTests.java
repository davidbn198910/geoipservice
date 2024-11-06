package com.odav1d.geoipservice;


import com.odav1d.geoservice.integration.client.IpApiClient;
import com.odav1d.geoservice.model.IpInfo;
import com.odav1d.geoservice.repository.IpTraceRecordRepository;
import com.odav1d.geoservice.service.IpTraceService;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@SpringBootTest
class IpTraceServiceTraceIpTests {

    @Mock
    private IpApiClient ipApiClient;

    @Mock
    private IpTraceRecordRepository ipTraceRecordRepository;

    @InjectMocks
    private IpTraceService ipTraceService;

    @Test
    void traceIp_ValidIp_ShouldReturnTraceRecord() {
        String ip = "8.8.8.8";
        

        IpInfo expectedRecord = new IpInfo();
        expectedRecord.setIp(ip);
        expectedRecord.setCiudad("Mountain View");
        expectedRecord.setCiudad("US");

        when(ipTraceService.traceIp(ip)).thenReturn(expectedRecord);

        
        IpInfo result = ipTraceService.traceIp(ip);
        
        assertThat(result).isNotNull();
        assertThat(result.getIp()).isEqualTo(ip);
        assertThat(result.getCiudad()).isEqualTo("Mountain View");
        assertThat(result.getIsoCode()).isEqualTo("US");
    }

    @Test
    void traceIp_InvalidIp_ShouldReturnNullOrThrowException() {
        String invalidIp = "999.999.999.999";

        when(ipTraceService.traceIp(invalidIp)).thenReturn(null);

        IpInfo result = ipTraceService.traceIp(invalidIp);

        assertThat(result).isNull();
    }

}
