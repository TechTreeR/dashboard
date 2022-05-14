package com.techtree.portal.controller;

import com.techtree.common.api.CommonResult;
import com.techtree.portal.model.DO.Comment;
import com.techtree.portal.model.VO.CommentInfoVO;
import com.techtree.portal.service.CommentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author Dysprosium
 * @title: CommentController
 * @projectName dashboard-backend
 * @description: TODO
 * @date 2022-05-029:41
 */
@Api("评论模块")
@RestController
@RequestMapping("/comments")
@CrossOrigin
public class CommentController {

    @Autowired
    CommentService commentService;

    @GetMapping("/all")
    @ApiOperation(value = "所有评论信息", notes = "查询所有评论信息")
    public CommonResult<List<CommentInfoVO>> getAllComments() {
        List<CommentInfoVO> allComments = commentService.getAllComments();
        return CommonResult.success(allComments, "查询所有评论信息成功");
    }

    @PutMapping("/add")
    @ApiOperation(value = "添加评论信息", notes = "添加一条评论信息")
    public CommonResult<Comment> addComment(@RequestBody Comment comment) {
        commentService.addComment(comment);
        return CommonResult.success(null, "添加评论信息成功");
    }
}
