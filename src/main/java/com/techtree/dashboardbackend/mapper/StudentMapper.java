package com.techtree.dashboardbackend.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.techtree.dashboardbackend.model.DO.Student;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface StudentMapper extends BaseMapper<Student> {
}
