package com.techtree.dashboardportal.service;

import com.techtree.dashboardportal.model.DO.Student;

import java.util.List;

public interface StudentService {

    List<Student> getAllStudents();
    Student getStudentById(long id);
    Student getStudentByName(String name);
    void addStudent(Student student);
    void updateStudent(Student student);
    void deleteStudentById(long id);

}
