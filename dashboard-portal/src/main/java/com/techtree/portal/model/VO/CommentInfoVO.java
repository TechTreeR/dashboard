package com.techtree.portal.model.VO;

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
 * @title: CommentInfoVO
 * @projectName dashboard-backend
 * @description: TODO
 * @date 2022-05-1116:03
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommentInfoVO implements Serializable {
    @ApiModelProperty(value = "评论的主键id")
    @TableId(value = "commentid", type = IdType.ASSIGN_ID)
    private String commentId;

    @ApiModelProperty(value = "课程名")
//    @NotEmpty(message = "课程id不能为空")
    private String cName;

    @ApiModelProperty(value = "学生名")
//    @NotEmpty(message = "学生id不能为空")
    private String sName;

    @ApiModelProperty(value = "评论内容")
    @NotEmpty(message = "评论内容不能为空")
    private String comment;

    @ApiModelProperty(value = "创建时间")
    @NotEmpty(message = "创建时间不能为空")
    private Date createdTime;

    public CommentInfoVO(String cName, String sName, String comment, Date createdTime) {
        this.cName = cName;
        this.sName = sName;
        this.comment = comment;
        this.createdTime = createdTime;
    }
}
