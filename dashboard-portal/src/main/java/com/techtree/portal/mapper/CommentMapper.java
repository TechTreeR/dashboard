package com.techtree.portal.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.techtree.portal.model.DO.Comment;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author Dysprosium
 * @title: CommentMapper
 * @projectName dashboard-backend
 * @description: TODO
 * @date 2022-05-0119:44
 */
@Mapper
public interface CommentMapper extends BaseMapper<Comment> {
}
