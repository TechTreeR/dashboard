package com.techtree.portal.controller;

import com.techtree.common.api.CommonResult;
import com.techtree.portal.annotation.CheckLogin;
import com.techtree.portal.model.DO.Course;
import com.techtree.portal.model.DO.Student;
import com.techtree.portal.service.impl.CourseServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Dysprosium
 * @title: CourseController
 * @projectName dashboard-backend
 * @description: TODO
 * @date 2022-03-2517:29
 */

@Api(tags = "选课模块")
@RestController
@RequestMapping("/courses")
@CrossOrigin
public class CourseController {

    @Autowired
    private CourseServiceImpl courseService;


    @GetMapping("/getAll")
    @ApiOperation(value = "所有课程主页信息", notes = "查询所有课程信息")
    public CommonResult<List<Course>> getAllCourses() {
        return CommonResult.success(courseService.getAllCourses(), "查询所有课程信息成功");
    }


    @GetMapping("/selectById/{id}")
    @ApiOperation(value = "课程主页信息", notes = "查询课程信息")
    public CommonResult<Course> getCourseById(@PathVariable  String id) {
        return CommonResult.success(courseService.getCourseById(id), "查询课程信息成功");
    }


    @GetMapping("/selectByName/{name}")
    @ApiOperation(value = "课程主页信息", notes = "查询课程信息")
    public CommonResult<List<Course>> getCourseByName(@PathVariable String name) {
        return CommonResult.success(courseService.getCourseByName(name), "查询课程信息成功");
    }

    @GetMapping("/selectByTeacher/{tName}")
    @ApiOperation(value = "课程主页信息", notes = "查询课程信息")
    public CommonResult<List<Course>> getCourseByTeacher(@PathVariable String tName) {
        return CommonResult.success(courseService.getCourseByTeacher(tName), "查询课程信息成功");
    }

    @GetMapping("/selectByMajor/{tName}")
    @ApiOperation(value = "课程主页信息", notes = "查询课程信息")
    public CommonResult<List<Course>> getCourseByMajor(@PathVariable String major) {
        return CommonResult.success(courseService.getCourseByMajor(major), "查询课程信息成功");
    }

    @GetMapping("/select/{year}/{semester}")
    @ApiOperation(value = "课程主页信息", notes = "查询课程信息")
    public CommonResult<List<Course>> getCourseByYearAndSemester(@PathVariable int year, @PathVariable int semester) {
        return CommonResult.success(courseService.getCourseByYearAndSemester(year, semester), "查询课程信息成功");
    }

    @PutMapping("/add")
    @ApiOperation(value = "添加课程信息", notes = "传入新的课程信息")
    public CommonResult<String> addCourse(@RequestBody Course course) {
        courseService.addCourse(course);
        return CommonResult.success(null, "添加课程信息成功");

    }


    @PutMapping("/update")
    @ApiOperation(value = "修改课程信息", notes = "传入新的课程信息")
    public CommonResult<String> updateCourse(@RequestBody Course course) {
        courseService.updateCourse(course);
        return CommonResult.success(null, "修改课程信息成功");
    }


    @DeleteMapping("/delete")
    @ApiOperation(value = "删除学生信息", notes = "根据学生id删除学生信息")
    public CommonResult<String> deleteStudentById(@RequestParam("id") String id){
        courseService.deleteCourseById(id);
        return CommonResult.success(null, "删除课程信息成功");
    }







}
