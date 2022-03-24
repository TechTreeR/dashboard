package com.techtree.dashboardportal.controller;


import com.google.gson.Gson;
import com.techtree.dashboardportal.model.DO.Student;
import com.techtree.dashboardportal.service.impl.StudentServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
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
    @ApiOperation(value = "学生主页信息", notes = "根据学生id查询学生信息")
    @ApiImplicitParam(name = "id", value = "学生id", dataType = "long")
    public String getStudentById(@PathVariable long id) {
        return gson.toJson(studentService.getStudentById(id));
    }

    @GetMapping("/selectById/{name}")
    @ApiOperation(value = "学生主页信息", notes = "根据学生姓名查询学生信息")
    public String getStudentByName(@PathVariable String name) {
        return gson.toJson(studentService.getStudentByName(name));
    }


    @GetMapping("/getAll")
    @ApiOperation(value = "学生主页信息", notes = "查询所有学生信息")
    public String getAll(){
        return gson.toJson(studentService.getAll());
    }

    @PostMapping("/addJSON")
    @ApiOperation(value = "添加学生信息", notes = "传入新的学生信息")
    public String addStudentByJSON(@RequestBody Student student) {
        studentService.addStudent(student);
        return gson.toJson(studentService.getAll());

    }

    @PostMapping("/update")
    @ApiOperation(value = "修改学生信息", notes = "传入新的学生信息")
    public String updateStudent(@RequestBody Student student) {
        studentService.updateStudent(student);
        return gson.toJson(studentService.getAll());
    }


    @DeleteMapping("/delete")
    @ApiOperation(value = "删除学生信息", notes = "根据学生id删除学生信息")
    public String deleteStudentById(@RequestParam("id") long id){
        studentService.deleteStudentById(id);
        return gson.toJson(studentService.getAll());
    }


}
