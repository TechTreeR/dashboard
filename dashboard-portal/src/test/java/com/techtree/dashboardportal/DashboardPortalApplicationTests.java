package com.techtree.dashboardportal;

import com.techtree.dashboardportal.model.DO.Student;
import com.techtree.dashboardportal.service.StudentServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class DashboardPortalApplicationTests {

    @Autowired
    StudentServiceImpl studentMapper;


    @Test
    void contextLoads() {
        System.out.println(("----- selectAll method test ------"));

    }

}
