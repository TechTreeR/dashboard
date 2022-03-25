package com.techtree.dashboardportal.service.impl;

import cn.hutool.core.util.ObjectUtil;
import com.techtree.dashboardportal.mapper.StudentMapper;
import com.techtree.dashboardportal.model.DO.Student;
import com.techtree.dashboardportal.service.StudentService;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentMapper studentMapper;

    @Override
    public List<Student> getAllStudents() {
        return studentMapper.selectList(null);

    }

    @Override
    public Student getStudentById(long id) {
        return studentMapper.selectById(id);

    }

    @Override
    public Student getStudentByName(String name) {
        return studentMapper.selectById(name);
    }

    @Override
    public void addStudent(Student student) {
        studentMapper.insert(student);
    }

    @Override
    public void updateStudent(Student student) {
        studentMapper.update(student, null);
    }

    @Override
    public void deleteStudentById(long id) {
        studentMapper.deleteById(id);
    }


}
