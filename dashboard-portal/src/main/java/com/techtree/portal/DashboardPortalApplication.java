package com.techtree.portal;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.techtree")
@MapperScan("com.techtree.portal.mapper")
public class DashboardPortalApplication {

    public static void main(String[] args) {
        SpringApplication.run(DashboardPortalApplication.class, args);
    }

}
