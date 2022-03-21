package com.dysprosium.dashboardbackend.Controller;


import com.dysprosium.dashboardbackend.Service.StudentServiceImpl;
import com.dysprosium.dashboardbackend.pojo.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentServiceImpl studentService;

    @RequestMapping("/selectById{id}")
    public String getStudentById(@PathVariable  int id) {
        return studentService.getStudentById(id).toString();
    }

    @RequestMapping("/queryAll")
    public String queryAll(){
        return studentService.queryAll().toString();
    }




}
