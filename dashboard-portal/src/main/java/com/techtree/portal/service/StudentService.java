package com.techtree.portal.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.techtree.portal.model.DO.Student;
import com.techtree.portal.model.DO.StudentCourseRelation;
import com.techtree.portal.model.VO.CourseInfoVo;
import com.techtree.portal.model.VO.StudentAuthVo;
import com.techtree.portal.model.VO.StudentInfoVo;
import com.techtree.portal.model.VO.StudentTokenVo;

import java.util.List;

public interface StudentService extends IService<Student> {

    // 学生信息相关
    List<StudentInfoVo> getAllStudents();
    StudentInfoVo getStudentById(String id);
    StudentInfoVo getStudentByName(String name);
    StudentInfoVo getStudentByEmail(String email);
    int addStudent(Student student);
    boolean updateStudent(StudentInfoVo student);
    boolean updatePassword(StudentAuthVo student);
    int deleteStudentById(String id);

    // 注册登录鉴权相关
    StudentTokenVo login(String id, String password);
    boolean checkEmailExist(String email);
    int registry(StudentAuthVo student);
    boolean sendEmail(String to);

    // 选课信息相关
    List<StudentCourseRelation> getStudentCourses(String id);
    List<CourseInfoVo> getAllCoursesSelectByStudent(String id);
    boolean selectCourse(String cid, String sid);
    boolean withdrawCourse(String cid, String sid);
    List<StudentInfoVo> getCourseStudents(String cid);
}
