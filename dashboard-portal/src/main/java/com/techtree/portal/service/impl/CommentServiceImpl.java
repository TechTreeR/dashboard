package com.techtree.portal.service.impl;

import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.conditions.query.QueryChainWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.techtree.common.exception.Assert;
import com.techtree.portal.mapper.CommentMapper;
import com.techtree.portal.model.DO.Comment;
import com.techtree.portal.model.DO.Course;
import com.techtree.portal.model.DO.Student;
import com.techtree.portal.model.VO.CommentInfoVO;
import com.techtree.portal.model.VO.StudentInfoVo;
import com.techtree.portal.service.CommentService;
import com.techtree.portal.service.CourseService;
import com.techtree.portal.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
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
    @Autowired
    private StudentService studentService;
    @Autowired
    private CourseService courseService;

    @Override
    public Integer addComment(Comment comment) {
        log.debug("插入评论为{}", comment);
        int insert = commentMapper.insert(comment);
        if (insert == 0) {
            log.error("插入评论为{}失败", comment);
            Assert.fail("插入评论失败");
        }
        return insert;
    }

    @Override
    public Integer deleteComment(String commentId) {
        log.debug("删除id为{}的评论", commentId);
        int delete = commentMapper.deleteById(commentId);
        if (delete == 0) {
            log.error("删除id为{}的评论失败", commentId);
            Assert.fail("删除该评论失败");
        }
        return delete;
    }



    @Override
    public Integer updateComment(String commentId, String commentText) {
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
    public List<CommentInfoVO> getAllComments() {
        List<CommentInfoVO> commentResults = new ArrayList<>();
        List<Comment> comments = commentMapper.selectList(null);
        for (Comment comment : comments) {
            StudentInfoVo studentById = studentService.getStudentById(comment.getSid());
            Course courseById = courseService.getCourseById(comment.getCid());
            commentResults.add(new CommentInfoVO(courseById.getCname(), studentById.getName(), comment.getComment(), comment.getCreatedTime()));
        }
        return commentResults;
    }

    @Override
    public List<CommentInfoVO> getCommentBySid(String sid) {
        List<Comment> commentBySid = this.query().eq("sid", sid).list();
        if(commentBySid.isEmpty()) {
            log.error("查询学生id为 {} 的评论信息不存在", sid);
            Assert.fail("评论信息未找到");
        }
        List<CommentInfoVO> commentResults = new ArrayList<>();
        for (Comment comment : commentBySid) {
            StudentInfoVo studentById = studentService.getStudentById(comment.getSid());
            Course courseById = courseService.getCourseById(comment.getCid());
            commentResults.add(new CommentInfoVO(courseById.getCname(), studentById.getName(), comment.getComment(), comment.getCreatedTime()));
        }
        return commentResults;
    }

    @Override
    public Comment getCommentById(String commentId) {
        Comment comment = commentMapper.selectById(commentId);
        if(ObjectUtil.isNull(comment)) {
            log.error("查询id为 {} 的评论信息不存在", commentId);
            Assert.fail("评论信息不存在");
        }
        return comment;
    }
}
