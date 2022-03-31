package com.techtree.portal.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.techtree.portal.model.DO.Student;
import com.techtree.portal.model.VO.StudentInfoVo;
import com.techtree.portal.model.VO.StudentTokenVo;

import java.util.List;

public interface StudentService extends IService<Student> {

    List<StudentInfoVo> getAllStudents();
    StudentInfoVo getStudentById(long id);
    StudentInfoVo getStudentByName(String name);
    StudentInfoVo getStudentByEmail(String email);
    int addStudent(Student student);
    boolean updateStudent(Student student);
    int deleteStudentById(long id);

    StudentTokenVo login(String id, String password);
    boolean checkEmailExist(String email);
    int registry(Student student, String verifyCode);

}
