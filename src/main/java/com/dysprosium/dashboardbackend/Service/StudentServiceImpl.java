package com.dysprosium.dashboardbackend.Service;

import com.dysprosium.dashboardbackend.mapper.StudentMapper;
import com.dysprosium.dashboardbackend.pojo.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl {

    @Autowired
    StudentMapper studentMapper;


    public List<Student> queryAll() {
        return studentMapper.selectList(null);
    }

    public Student getStudentById(int id) {
        return studentMapper.selectById(id);
    }


}
