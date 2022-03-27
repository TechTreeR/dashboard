package com.techtree.portal.controller;


import com.techtree.common.api.CommonResult;
import com.techtree.portal.model.DO.Student;
import com.techtree.portal.service.impl.StudentServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "学生模块")
@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentServiceImpl studentService;

    @GetMapping("/selectById/{id}")
    @ApiOperation(value = "学生主页信息", notes = "根据学生id查询学生信息")
    @ApiImplicitParam(name = "id", value = "学生id", dataType = "long")
    public CommonResult<Student> getStudentById(@PathVariable long id) {
        Student studentById = studentService.getStudentById(id);
        return CommonResult.success(studentById, "查询学生信息成功");
    }

    @GetMapping("/selectByName/{name}")
    @ApiOperation(value = "学生主页信息", notes = "根据学生姓名查询学生信息")
    public CommonResult<Student> getStudentByName(@PathVariable String name) {
        Student studentByName = studentService.getStudentByName(name);
        return CommonResult.success(studentByName, "查询学生信息成功");
    }


    @GetMapping("/getAll")
    @ApiOperation(value = "学生主页信息", notes = "查询所有学生信息")
    public CommonResult<List<Student>> getAllStudents(){
        return CommonResult.success(studentService.getAllStudents(), "查询所有学生信息成功");
    }

    @PutMapping("/addJSON")
    @ApiOperation(value = "添加学生信息", notes = "传入新的学生信息")
    public CommonResult<String> addStudentByJSON(@RequestBody Student student) {
        studentService.addStudent(student);
        return CommonResult.success(null, "添加学生信息成功");

    }

    @PutMapping("/update")
    @ApiOperation(value = "修改学生信息", notes = "传入新的学生信息")
    public CommonResult<String> updateStudent(@RequestBody Student student) {
        studentService.updateStudent(student);
        return CommonResult.success(null, "修改学生信息成功");
    }


    @DeleteMapping("/delete")
    @ApiOperation(value = "删除学生信息", notes = "根据学生id删除学生信息")
    public CommonResult<String> deleteStudentById(@RequestParam("id") long id){
        studentService.deleteStudentById(id);
        return CommonResult.success(null, "删除学生信息成功");
    }


}
