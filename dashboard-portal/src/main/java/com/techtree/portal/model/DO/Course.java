package com.techtree.portal.model.DO;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("Course")
@ApiModel(value = "course对象")
public class Course implements Serializable {
    @TableId(value = "cid", type = IdType.ASSIGN_ID)
    @ApiModelProperty(value = "课程id")
    @NotEmpty(message = "课程id不能为空")
    private String cid;

    @ApiModelProperty(value = "课程名称")
    @NotEmpty(message = "课程名称不能为空")
    private String cname;

    @ApiModelProperty(value = "教师名称")
    @NotEmpty(message = "教师名称不能为空")
    private String tname;

    @ApiModelProperty(value = "开始时间")
    private String cstart;

    @ApiModelProperty(value = "结束时间")
    private String cend;

    @ApiModelProperty(value = "学分")
    @NotEmpty(message = "学分不能为空")
    private Float credit;

    @ApiModelProperty(value = "学年")
    private int year;

    @ApiModelProperty(value = "学期")
    private int semester;

    @ApiModelProperty(value = "上课地点")
    private String place;

    @ApiModelProperty(value = "上课地点")
    @NotEmpty(message = "开课学院不能为空")
    private String major;

    @ApiModelProperty(value = "容量")

    private Long capacity;

    @ApiModelProperty(value = "余量")
    @NotEmpty(message = "余量不能为空")
    private Long remains;

    @ApiModelProperty(value = "是否可选")
    @NotEmpty(message = "是否可选不能为空")
    private Integer canSelect;

    @ApiModelProperty(value = "开始周数")
    private int startWeek;

    @ApiModelProperty(value = "结束周数")
    private int endWeek;

    @ApiModelProperty(value = "创建时间")
    @NotEmpty(message = "创建时间不能为空")
    private Date createdTime;

    @ApiModelProperty(value = "更新时间")
    @NotEmpty(message = "更新时间不能为空")
    private Date updatedTime;

    @ApiModelProperty(value = "软删除字段 0代表未删除 1代表已删除")
    @TableLogic
    private Integer isDeleted;









}
