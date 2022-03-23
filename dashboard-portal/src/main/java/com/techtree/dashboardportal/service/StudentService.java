package com.techtree.dashboardportal.service;

import com.techtree.dashboardportal.model.DO.Student;

import java.util.List;

public interface StudentService {

    List<Student> queryAll();

    Student getStudentById(long id);

    int insertStudent(Student student);

    int deleteStudentById(long id);

}
