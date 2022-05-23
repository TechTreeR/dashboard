package com.techtree.portal.service.impl;

import com.techtree.portal.mapper.SCMapper;
import com.techtree.portal.model.DO.StudentCourseRelation;
import com.techtree.portal.model.VO.CourseInfoVo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Dysprosium
 * @title: CourseServiceImplTest
 * @projectName dashboard-backend
 * @description: TODO
 * @date 2022-04-1823:03
 */
@SpringBootTest
class CourseServiceImplTest {

    @Autowired
    CourseServiceImpl courseService;
    @Autowired
    StudentServiceImpl studentService;
    @Autowired
    SCMapper scMapper;

    @Test
    void getAllCoursesSelectByStudent() {


        List<StudentCourseRelation> studentCourseRelations = scMapper.selectScByStudentId("101");
        List<CourseInfoVo> allCoursesSelectByStudent = studentService.getAllCoursesSelectByStudent("101");
        studentCourseRelations.forEach(System.out::println);
        allCoursesSelectByStudent.forEach(System.out::println);
    }
}