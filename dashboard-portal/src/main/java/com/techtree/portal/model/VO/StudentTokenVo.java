package com.techtree.portal.model.VO;

import com.techtree.portal.model.DO.Student;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.io.Serializable;

/**
 * @author Dysprosium
 * @title: StudentTokenVo
 * @projectName dashboard-backend
 * @description: TODO
 * @date 2022-03-2823:45
 */



@Data
@EqualsAndHashCode(callSuper = false)
@Builder
@ApiModel(description = "获取Token返回信息封装")
@NoArgsConstructor
@AllArgsConstructor
public class StudentTokenVo implements Serializable {

    @ApiModelProperty("访问令牌")
    private String accessToken;

    @ApiModelProperty("用户对象信息")
    private StudentInfoVo student;

}
