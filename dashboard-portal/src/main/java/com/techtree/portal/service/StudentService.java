package com.techtree.portal.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.techtree.portal.model.DO.Course;
import com.techtree.portal.model.DO.Student;
import com.techtree.portal.model.VO.StudentTokenVo;

import java.util.List;

public interface StudentService extends IService<Student> {

    List<Student> getAllStudents();
    Student getStudentById(long id);
    Student getStudentByName(String name);
    int addStudent(Student student);
    int updateStudent(Student student);
    int deleteStudentById(long id);

    StudentTokenVo login(long id, String password);

}
