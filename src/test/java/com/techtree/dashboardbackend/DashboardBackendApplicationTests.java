package com.techtree.dashboardbackend;

import com.techtree.dashboardbackend.service.StudentServiceImpl;
import com.techtree.dashboardbackend.model.DO.Student;
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
        studentMapper.deleteStudentById(106);
        List<Student> students = studentMapper.queryAll();
        students.forEach(System.out::println);

    }

}
