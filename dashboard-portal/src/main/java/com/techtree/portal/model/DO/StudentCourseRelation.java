package com.techtree.portal.model.DO;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

/**
 * @author Dysprosium
 * @title: StudentCourseRelation
 * @projectName dashboard-backend
 * @description: TODO
 * @date 2022-04-0423:41
 */


@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "sc_relation")
@ApiModel(value = "学生选课关系", description = "学生选课表")
public class StudentCourseRelation implements Serializable {

    @ApiModelProperty(value = "学生id")
    @NotEmpty(message = "学生id不能为空")
    private Long sid;

    @ApiModelProperty(value = "课程id")
    @NotEmpty(message = "课程id不能为空")
    private String cid;


}
