package com.techtree.dashboardportal;

import com.techtree.dashboardportal.service.impl.StudentServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DashboardPortalApplicationTests {

    @Autowired
    StudentServiceImpl studentMapper;


    @Test
    void contextLoads() {
        System.out.println(("----- selectAll method test ------"));

    }

}
