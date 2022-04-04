package com.techtree.portal.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.techtree.portal.model.DO.StudentCourseRelation;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author Dysprosium
 * @title: SCMapper
 * @projectName dashboard-backend
 * @description: TODO
 * @date 2022-04-0423:43
 */

@Mapper
public interface SCMapper extends BaseMapper<StudentCourseRelation> {
}
