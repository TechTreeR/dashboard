package com.techtree.portal.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.techtree.portal.model.DO.StudentCourseRelation;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * @author Dysprosium
 * @title: SCMapper
 * @projectName dashboard-backend
 * @description: TODO
 * @date 2022-04-0423:43
 */

@Mapper
public interface SCMapper extends BaseMapper<StudentCourseRelation> {


    @Select("select * from sc_relation where sid = #{id}")
    List<StudentCourseRelation> selectScByStudentId(Long id);

    @Select("select * from sc_relation where sid = #{sid} and cid = #{cid}")
    StudentCourseRelation selectScBy2Ids(Long sid, String cid);

    @Update("update Course set remains = (remains-1) where cid = #{cid}")
    int reduceRemain(String cid);

    @Update("update Course set remains = (remains+1) where cid = #{cid}")
    int increaseRemain(String cid);

    @Delete("delete from sc_relation where sid = #{sid} and cid = #{cid}")
    int deleteCourse(Long sid, String cid);


}
