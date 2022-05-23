package com.techtree.portal.service.impl;

import com.techtree.portal.model.DO.StudentCourseRelation;
import com.techtree.portal.model.VO.StudentAuthVo;
import com.techtree.portal.model.VO.StudentInfoVo;
import com.techtree.portal.model.VO.StudentTokenVo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Dysprosium
 * @title: StudentServiceImplTest
 * @projectName dashboard-backend
 * @description: TODO
 * @date 2022-05-210:07
 */
@SpringBootTest
class StudentServiceImplTest {

    @Resource
    StudentServiceImpl studentService;

    @Test
    void getAllStudents() {
        List<StudentInfoVo> allStudents = studentService.getAllStudents();
        allStudents.forEach(System.out::println);
    }


    @Test
    void getStudentByEmail() {
        StudentInfoVo studentByEmail1 = studentService.getStudentByEmail("1119493091@qq.com");
//        StudentInfoVo studentByEmail2 = studentService.getStudentByEmail("123123");
        System.out.println(studentByEmail1);
//        System.out.println(studentByEmail2);
    }

    @Test
    void checkEmailExist() {
        boolean emailExist = studentService.checkEmailExist("1119493091@qq.com");
        System.out.println(emailExist);
    }



    @Test
    void login() {
        StudentTokenVo dydydy = studentService.login("1119493091@qq.com", "dydydy");
        System.out.println(dydydy.toString());
    }


    @Test
    void sendEmail() {
        boolean result1 = studentService.sendEmail("1119493091@qq.com");
        System.out.println(result1);
        boolean result2 = studentService.sendEmail("12312312");
        System.out.println(result2);
    }

    @Test
    void getStudentCourses() {
        List<StudentCourseRelation> studentCourses = studentService.getStudentCourses("10011");
        studentCourses.forEach(System.out::println);
    }



    @Test
    void selectCourse() {
        boolean selectCourse1 = studentService.selectCourse("CPT201", "10011");
        boolean selectCourse2 = studentService.selectCourse("CPT20123123", "10011");
        System.out.println(selectCourse1);
        System.out.println(selectCourse2);
    }



}