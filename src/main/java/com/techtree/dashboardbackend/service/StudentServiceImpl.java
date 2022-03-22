package com.techtree.dashboardbackend.service;

import com.techtree.dashboardbackend.mapper.StudentMapper;
import com.techtree.dashboardbackend.model.DO.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService{

    @Autowired
    StudentMapper studentMapper;

    @Override
    public List<Student> queryAll() {
        return studentMapper.selectList(null);
    }

    @Override
    public Student getStudentById(long id) {
        return studentMapper.selectById(id);
    }

    @Override
    public int insertStudent(Student student) {
        return studentMapper.insert(student);
    }

    @Override
    public int deleteStudentById(long id) {
        return studentMapper.deleteById(id);
    }


}
