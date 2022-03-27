package com.techtree.portal.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.techtree.portal.model.DO.Course;
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
