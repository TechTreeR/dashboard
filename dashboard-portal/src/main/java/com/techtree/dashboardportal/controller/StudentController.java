package com.techtree.dashboardportal.controller;


import com.techtree.dashboardportal.model.DO.Student;
import com.techtree.dashboardportal.service.StudentServiceImpl;
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
    public String getStudentById(@PathVariable long id) {
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
    public String insertStudentByForm(@RequestParam("id") long id, @RequestParam("name") String name, @RequestParam("sex") String sex, @RequestParam("age") int age, @RequestParam("password") String password, @RequestParam("email") String email) {
        studentService.insertStudent(new Student(id, name, sex, age, password, email));
        return studentService.queryAll().toString();
    }


    @DeleteMapping("/delete")
    public String deleteStudentById(@RequestParam("id") long id){
        studentService.deleteStudentById(id);
        return studentService.queryAll().toString();
    }


}
