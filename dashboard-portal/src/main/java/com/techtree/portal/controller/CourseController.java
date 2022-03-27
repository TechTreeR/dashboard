package com.techtree.portal.controller;

import com.techtree.common.api.CommonResult;
import com.techtree.portal.model.DO.Course;
import com.techtree.portal.service.impl.CourseServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
public class CourseController {

    @Autowired
    private CourseServiceImpl courseService;


    @GetMapping("/getAll")
    @ApiOperation(value = "所有课程主页信息", notes = "查询所有课程信息")
    public CommonResult<List<Course>> getAllCourses() {
        List<Course> allCourses = courseService.getAllCourses();
        allCourses.forEach(System.out::println);
        return CommonResult.success(courseService.getAllCourses(), "查询所有课程信息成功");
    }


}
