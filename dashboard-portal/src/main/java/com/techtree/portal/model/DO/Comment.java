package com.techtree.portal.model.DO;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.Date;

/**
 * @author Dysprosium
 * @title: Comment
 * @projectName dashboard-backend
 * @description: TODO
 * @date 2022-05-0119:31
 */


@AllArgsConstructor
@NoArgsConstructor
@Data
public class Comment implements Serializable {
    @ApiModelProperty(value = "评论的主键id")
    @TableId(value = "commentid", type = IdType.ASSIGN_ID)
    private String commentId;

    @ApiModelProperty(value = "课程id")
//    @NotEmpty(message = "课程id不能为空")
    private String cid;

    @ApiModelProperty(value = "学生id")
//    @NotEmpty(message = "学生id不能为空")
    private String sid;

    @ApiModelProperty(value = "评论内容")
    @NotEmpty(message = "评论内容不能为空")
    private String comment;

    @ApiModelProperty(value = "创建时间")
    @NotEmpty(message = "创建时间不能为空")
    private Date createdTime;

    @ApiModelProperty(value = "更新时间")
    @NotEmpty(message = "更新时间不能为空")
    private Date updatedTime;

    @ApiModelProperty(value = "软删除字段 0代表未删除 1代表已删除")
    @TableLogic
    private Integer isDeleted;

    public Comment(String sid, String cid, String comment) {
        this.sid = sid;
        this.cid = cid;
        this.comment = comment;
    }
}
