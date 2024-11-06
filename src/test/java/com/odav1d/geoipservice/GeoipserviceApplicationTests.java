package com.odav1d.geoipservice;

import static org.assertj.core.api.Assertions.assertThat;

import com.odav1d.geoservice.controller.IpFormController;
import com.odav1d.geoservice.service.IpTraceService;
import com.odav1d.geoservice.repository.IpTraceRecordRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class GeoipserviceApplicationTests {

    @Autowired
    private IpFormController ipFormController;

    @Autowired
    private IpTraceService ipTraceService;

    @Autowired
    private IpTraceRecordRepository ipTraceRecordRepository;

    @Test
    void contextLoads() {
        // Verifica que el contexto de la aplicación se carga correctamente
        assertThat(ipFormController).isNotNull();
        assertThat(ipTraceService).isNotNull();
        assertThat(ipTraceRecordRepository).isNotNull();
    }
}
