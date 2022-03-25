package com.techtree.dashboardportal.service;

import com.techtree.dashboardportal.model.DO.Course;
import com.techtree.dashboardportal.model.DO.Student;

import java.util.List;
import java.util.Map;

/**
 * @author Dysprosium
 * @title: CourseService
 * @projectName dashboard-backend
 * @description: TODO
 * @date 2022-03-2517:35
 */
public interface CourseService {

    List<Course> getAllCourses();
    Course getCourseById(long id);
    List<Course> getCourseByName(String name); // 需要支持模糊搜索
    List<Course> getCourseByTeacher(String tName);
    List<Course> getCourseByMajor(String major);
    List<Course> getCourseByYearAndSemester(int year, int semester);
    List<Course> getCourseByMap(Map<String, Object> courseMap);

    void addCourse(Course course);
    void updateCourse(Course course);
    void deleteCourseById(long id);





}
