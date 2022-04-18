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
 * @title: CourseInfoVo
 * @projectName dashboard-backend
 * @description: TODO
 * @date 2022-04-1822:27
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseInfoVo implements Serializable {

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

    @ApiModelProperty(value = "上课地点")
    private String place;

    @ApiModelProperty(value = "上课地点")
    @NotEmpty(message = "开课学院不能为空")
    private String major;

    @ApiModelProperty(value = "容量")
    private Long capacity;

    @ApiModelProperty(value = "是否已经被选")
    @NotEmpty(message = "是否已经被选不能为空")
    private boolean isSelected;


}
