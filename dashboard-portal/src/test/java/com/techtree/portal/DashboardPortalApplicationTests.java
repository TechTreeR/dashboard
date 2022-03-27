package com.techtree.portal;

import com.techtree.portal.model.DO.Course;
import com.techtree.portal.service.impl.CourseServiceImpl;
import com.techtree.portal.service.impl.StudentServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class DashboardPortalApplicationTests {

    @Autowired
    StudentServiceImpl studentMapper;
    @Autowired
    CourseServiceImpl courseService;

    @Test
    void contextLoads() {
        System.out.println(("----- selectAll method test ------"));
        List<Course> course = courseService.getAllCourses();
        for (Course course1 : course) {
            System.out.println(course1);
        }

    }

}
