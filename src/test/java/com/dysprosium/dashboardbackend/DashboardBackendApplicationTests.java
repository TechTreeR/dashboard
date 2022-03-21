package com.dysprosium.dashboardbackend;

import com.dysprosium.dashboardbackend.Service.StudentServiceImpl;
import com.dysprosium.dashboardbackend.mapper.StudentMapper;
import com.dysprosium.dashboardbackend.pojo.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class DashboardBackendApplicationTests {

    @Autowired
    StudentServiceImpl studentMapper;

    @Test
    void contextLoads() {
    }

    @Test
    public void testSelect() {
        System.out.println(("----- selectAll method test ------"));
        Student studentById = studentMapper.getStudentById(101);
        System.out.println(studentById);

    }

}
