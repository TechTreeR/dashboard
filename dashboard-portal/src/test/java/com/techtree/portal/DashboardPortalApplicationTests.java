package com.techtree.portal;

import com.techtree.portal.model.DO.Course;
import com.techtree.portal.model.VO.StudentInfoVo;
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
        StudentInfoVo studentByEmail = studentMapper.getStudentByEmail("1119493091@qq.com");
        List<StudentInfoVo> allStudents = studentMapper.getAllStudents();
        for (StudentInfoVo allStudent : allStudents) {
            System.out.println(allStudent);
        }
    }



}
