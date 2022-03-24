package com.techtree.dashboardportal.controller;

import com.techtree.dashboardportal.model.DO.Student;
import com.techtree.dashboardportal.service.impl.StudentServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @author Dysprosium
 * @title: StudentControllerTest
 * @projectName dashboard-backend
 * @description: TODO
 * @date 2022-03-2417:39
 */
@SpringBootTest
class StudentControllerTest {

    @Autowired
    StudentServiceImpl studentMapper;

    @Test
    void getStudentById() {

    }

    @Test
    void queryAll() {

    }

    @Test
    void insertStudentByJSON() {

        List<Student> students = studentMapper.getAll();
        students.forEach(System.out::println);
    }

    @Test
    void insertStudentByForm() {
    }

    @Test
    void deleteStudentById() {
    }
}