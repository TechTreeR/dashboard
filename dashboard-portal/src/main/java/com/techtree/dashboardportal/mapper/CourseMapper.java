package com.techtree.dashboardportal.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.techtree.dashboardportal.model.DO.Course;
import com.techtree.dashboardportal.model.DO.Student;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author Dysprosium
 * @title: CourseMapper
 * @projectName dashboard-backend
 * @description: TODO
 * @date 2022-03-2517:46
 */
@Mapper
public interface CourseMapper extends BaseMapper<Course> {
}
