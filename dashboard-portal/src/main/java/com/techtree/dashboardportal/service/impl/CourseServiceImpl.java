package com.techtree.dashboardportal.service.impl;

import com.baomidou.mybatisplus.core.conditions.AbstractWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.techtree.dashboardportal.mapper.CourseMapper;
import com.techtree.dashboardportal.model.DO.Course;
import com.techtree.dashboardportal.service.CourseService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author Dysprosium
 * @title: CourseServiceImpl
 * @projectName dashboard-backend
 * @description: TODO
 * @date 2022-03-2517:36
 */
@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    CourseMapper courseMapper;

    QueryWrapper<Course> queryWrapper = new QueryWrapper();

    @Override
    public List<Course> getAllCourses() {
        return courseMapper.selectList(null);
    }

    @Override
    public Course getCourseById(long id) {
        return courseMapper.selectById(id);
    }

    @Override
    public List<Course> getCourseByName(String name) {
        return courseMapper.selectList(queryWrapper.like("cname", name));
    }

    @Override
    public List<Course> getCourseByTeacher(String tName) {
        return courseMapper.selectList(queryWrapper.eq("tname", tName));
    }

    @Override
    public List<Course> getCourseByMajor(String major) {
        return courseMapper.selectList(queryWrapper.eq("major", major));
    }

    @Override
    public List<Course> getCourseByYearAndSemester(int year, int semester) {
        return courseMapper.selectList(queryWrapper.and(i -> i.eq("year", year).eq("semester", semester)));
    }

    @Override
    public List<Course> getCourseByMap(Map<String, Object> courseMap) {
        return courseMapper.selectByMap(courseMap);
    }

    @Override
    public void addCourse(Course course) {
        courseMapper.insert(course);
    }

    @Override
    public void updateCourse(Course course) {
        courseMapper.update(course, null);
    }

    @Override
    public void deleteCourseById(long id) {
        courseMapper.deleteById(id);
    }
}
