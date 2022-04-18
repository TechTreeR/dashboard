package com.techtree.portal.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.techtree.portal.model.DO.Course;
import com.techtree.portal.model.VO.CourseInfoVo;

import java.util.List;
import java.util.Map;

/**
 * @author Dysprosium
 * @title: CourseService
 * @projectName dashboard-backend
 * @description: TODO
 * @date 2022-03-2517:35
 */
public interface CourseService extends IService<Course> {

    List<Course> getAllCourses();
    Course getCourseById(String id);
    List<Course> getCourseByName(String name); // 需要支持模糊搜索
    List<Course> getCourseByTeacher(String tName);
    List<Course> getCourseByMajor(String major);
    List<Course> getCourseByYearAndSemester(int year, int semester);
    List<Course> getCourseByMap(Map<String, Object> courseMap);

    int addCourse(Course course);
    boolean updateCourse(Course course);
    int deleteCourseById(String id);




}
