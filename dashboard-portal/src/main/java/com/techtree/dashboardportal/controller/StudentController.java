package com.techtree.dashboardportal.controller;


import com.google.gson.Gson;
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

    Gson gson = new Gson();

    @GetMapping("/selectById/{id}")
    public String getStudentById(@PathVariable long id) {
        return gson.toJson(studentService.getStudentById(id));
    }

    @GetMapping("/selectById/{name}")
    public String getStudentByName(@PathVariable String name) {
        return gson.toJson(studentService.getStudentByName(name));
    }


    @GetMapping("/getAll")
    public String getAll(){
        return gson.toJson(studentService.getAll());
    }

    @PostMapping("/addJSON")
    public String addStudentByJSON(@RequestBody Student student) {
        studentService.addStudent(student);
        return gson.toJson(studentService.getAll());

    }

    @PostMapping("/update")
    public String updateStudent(@RequestBody Student student) {
        studentService.updateStudent(student);
        return gson.toJson(studentService.getAll());
    }


    @DeleteMapping("/delete")
    public String deleteStudentById(@RequestParam("id") long id){
        studentService.deleteStudentById(id);
        return gson.toJson(studentService.getAll());
    }


}
