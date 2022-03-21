package com.dysprosium.dashboardbackend.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.dysprosium.dashboardbackend.pojo.Student;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface StudentMapper extends BaseMapper<Student> {
}
