package com.techtree.portal.model.VO;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

/**
 * @author Dysprosium
 * @title: StudentAuthVo
 * @projectName dashboard-backend
 * @description: TODO
 * @date 2022-04-1712:58
 */

@NoArgsConstructor
@AllArgsConstructor
@Data
public class StudentAuthVo implements Serializable {

    @ApiModelProperty(value = "主键id")
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private Long id;

    @ApiModelProperty(value = "密码")
    @NotEmpty(message = "密码不能为空")
    private String password;


    @ApiModelProperty(value = "姓名")
    @NotEmpty(message = "姓名不能为空")
    private String name;

    @ApiModelProperty(value = "性别")
    @NotEmpty(message = "性别不能为空")
    private String sex;

    @ApiModelProperty(value = "年龄")
    @NotEmpty(message = "年龄不能为空")
    private Integer age;

    @ApiModelProperty(value = "邮箱")
    @NotEmpty(message = "性别不能为空")
    private String email;

    @ApiModelProperty(value = "专业")
    private String major;

    @ApiModelProperty(value = "验证码")
    @NotEmpty(message = "验证码不能为空")
    private String verifyCode;
}
