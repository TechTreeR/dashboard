package com.dysprosium.dashboardbackend;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.dysprosium.dashboardbackend.mapper")
public class DashboardBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(DashboardBackendApplication.class, args);
    }

}
