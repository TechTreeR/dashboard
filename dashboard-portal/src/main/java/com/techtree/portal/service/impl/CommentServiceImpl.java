package com.techtree.portal.service.impl;

import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.conditions.query.QueryChainWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.techtree.common.exception.Assert;
import com.techtree.portal.mapper.CommentMapper;
import com.techtree.portal.model.DO.Comment;
import com.techtree.portal.model.DO.Student;
import com.techtree.portal.service.CommentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Dysprosium
 * @title: CommentServiceImpl
 * @projectName dashboard-backend
 * @description: TODO
 * @date 2022-05-0122:03
 */
@Slf4j
@Service
public class CommentServiceImpl extends ServiceImpl<CommentMapper, Comment> implements CommentService {

    @Resource
    private CommentMapper commentMapper;

    @Override
    public int addComment(long sid, String commentText) {
        Comment comment = new Comment(sid, commentText);
        log.debug("学生id为{}的用户插入评论内容为{}", sid, commentText);
        int insert = commentMapper.insert(comment);
        if (insert == 0) {
            log.error("学生id为{}的用户插入评论内容为{}失败", sid, commentText);
            Assert.fail("插入评论失败");
        }
        return insert;
    }

    @Override
    public int deleteComment(int commentId) {
        log.debug("删除id为{}的评论", commentId);
        int delete = commentMapper.deleteById(commentId);
        if (delete == 0) {
            log.error("删除id为{}的评论失败", commentId);
            Assert.fail("删除该评论失败");
        }
        return delete;
    }



    @Override
    public int updateComment(int commentId, String commentText) {
        Comment commentById = this.getCommentById(commentId);
        if(ObjectUtil.isNull(commentById)) {
            log.error("查询id为 {} 的评论信息不存在", commentId);
            Assert.fail("评论信息不存在");
        }
        commentById.setComment(commentText);
        int update = commentMapper.update(commentById, new UpdateWrapper<Comment>().eq("commentid", commentById.getCommentId()));
        if (update == 0) {
            log.error("更新id为{}的评论{}失败", commentId, commentText);
            Assert.fail("更新该评论失败");
        }
        return update;
    }

    @Override
    public List<Comment> getAllComments() {
        return commentMapper.selectList(null);
    }

    @Override
    public List<Comment> getCommentBySid(long sid) {
        List<Comment> commentBySid = this.query().eq("sid", sid).list();
        if(commentBySid.isEmpty()) {
            log.error("查询学生id为{}的评论信息不存在", sid);
            Assert.fail("评论信息未找到");
        }
        return commentBySid;
    }

    @Override
    public Comment getCommentById(int commentId) {
        Comment comment = commentMapper.selectById(commentId);
        if(ObjectUtil.isNull(comment)) {
            log.error("查询id为 {} 的评论信息不存在", commentId);
            Assert.fail("评论信息不存在");
        }

        return comment;
    }
}
