package com.techtree.portal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.techtree")
public class DashboardPortalApplication {

    public static void main(String[] args) {
        SpringApplication.run(DashboardPortalApplication.class, args);
    }

}
