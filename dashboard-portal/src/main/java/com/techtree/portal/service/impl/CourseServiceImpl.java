package com.techtree.portal.service.impl;

import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.techtree.common.exception.Assert;
import com.techtree.portal.mapper.CourseMapper;
import com.techtree.portal.mapper.SCMapper;
import com.techtree.portal.model.DO.Course;
import com.techtree.portal.model.DO.StudentCourseRelation;
import com.techtree.portal.model.VO.CourseInfoVo;
import com.techtree.portal.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
public class CourseServiceImpl extends ServiceImpl<CourseMapper, Course> implements CourseService {

    @Autowired
    CourseMapper courseMapper;
    @Autowired
    private SCMapper scMapper;

    QueryWrapper<Course> queryWrapper = new QueryWrapper();

    @Override
    public List<Course> getAllCourses() {
        return courseMapper.selectList(null);
    }

    @Override
    public Course getCourseById(String id) {
        Course course = courseMapper.selectById(id);
        if (ObjectUtil.isNull(course)) {
            Assert.fail("课程信息未找到");
        }
        return course;
    }

    @Override
    public List<Course> getCourseByName(String name) {
        List<Course> cname = this.query().like("cname", name).list();
        if (cname.isEmpty()) {
            Assert.fail("课程信息未找到");
        }
        return cname;
    }

    @Override
    public List<Course> getCourseByTeacher(String tName) {
        List<Course> tname = this.query().eq("tname", tName).list();
        if (tname.isEmpty()) {
            Assert.fail("课程信息未找到");
        }
        return tname;
    }

    @Override
    public List<Course> getCourseByMajor(String major) {
        List<Course> courseByMajor = this.query().eq("major", major).list();
        if (courseByMajor.isEmpty()) {
            Assert.fail("课程信息未找到");
        }
        return courseByMajor;
    }

    @Override
    public List<Course> getCourseByYearAndSemester(int year, int semester) {
        List<Course> courseByYearAndSemester = this.query().eq("year", year).eq("semester", semester).list();
        if (courseByYearAndSemester.isEmpty()) {
            Assert.fail("课程信息未找到");
        }
        return courseByYearAndSemester;
    }

    @Override
    public List<Course> getCourseByMap(Map<String, Object> courseMap) {
        List<Course> courseByMap = courseMapper.selectByMap(courseMap);
        if (courseByMap.isEmpty()) {
            Assert.fail("课程信息未找到");
        }
        return courseByMap;
    }

    @Override
    public int addCourse(Course course) {
        int insert = courseMapper.insert(course);
        if(insert == 0) {
            Assert.fail("增加课程信息失败");
        }
        return insert;
    }

    @Override
    public boolean updateCourse(Course course) {
        boolean update = this.update(course, new UpdateWrapper<Course>().eq("cid", course.getCid()));
        if(!update) {
            Assert.fail("修改课程信息失败");
        }
        return true;
    }

    @Override
    public int deleteCourseById(String id) {
        int deleteById = courseMapper.deleteById(id);
        if(deleteById == 0) {
            Assert.fail("删除课程信息失败");
        }
        return deleteById;
    }




}
