package com.techtree.portal.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.techtree.portal.model.DO.Comment;
import com.techtree.portal.model.VO.CommentInfoVO;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Dysprosium
 * @title: CommentService
 * @projectName dashboard-backend
 * @description: TODO
 * @date 2022-05-0119:51
 */
@Service
public interface CommentService extends IService<Comment> {
    Integer addComment(Comment comment);
    Integer deleteComment(String commentId);
    Integer updateComment(String commentId, String commentText);

    List<CommentInfoVO> getAllComments();
    List<CommentInfoVO> getCommentBySid(Long sid);
    Comment getCommentById(String commentId);

}
