package com.techtree.dashboardbackend.controller;


import com.techtree.dashboardbackend.model.DO.Student;
import com.techtree.dashboardbackend.service.StudentServiceImpl;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(tags = "学生模块")
@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentServiceImpl studentService;

    @GetMapping("/selectById/{id}")
    public String getStudentById(@PathVariable  long id) {
        return studentService.getStudentById(id).toString();
    }

    @GetMapping("/queryAll")
    public String queryAll(){
        return studentService.queryAll().toString();
    }

    @PostMapping("/insertJSON")
    public String insertStudentByJSON(@RequestBody Student student) {
        studentService.insertStudent(student);
        return studentService.queryAll().toString();
    }

    @PostMapping("/insertForm")
    public String insertStudentByForm(@RequestParam("id") long id, @RequestParam("stuName") String stuName) {
        studentService.insertStudent(new Student(id, stuName));
        return studentService.queryAll().toString();
    }


    @DeleteMapping("/delete")
    public String deleteStudentById(@RequestParam("id") long id){
        studentService.deleteStudentById(id);
        return studentService.queryAll().toString();
    }


}
