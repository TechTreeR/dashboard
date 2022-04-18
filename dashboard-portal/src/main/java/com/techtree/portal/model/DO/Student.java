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
@TableName(value = "Student")
@ApiModel(value = "student对象", description = "学生表")
public class Student implements Serializable {

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
    private String email;

    @ApiModelProperty(value = "生日")
    private Date birthday;

    @ApiModelProperty(value = "专业")
    private String major;

    @ApiModelProperty(value = "创建时间")
    @NotEmpty(message = "创建时间不能为空")
    private Date createdTime;

    @ApiModelProperty(value = "更新时间")
    @NotEmpty(message = "更新时间不能为空")
    private Date updatedTime;

    @ApiModelProperty(value = "软删除字段 0代表未删除 1代表已删除")
    @TableLogic
    private Integer isDeleted;

    public Student(Long id, String password, String name, String sex, Integer age) {
        this.id = id;
        this.password = password;
        this.name = name;
        this.sex = sex;
        this.age = age;
    }

    public Student(Long id, String password, String email, String name, String sex, Integer age) {
        this.id = id;
        this.password = password;
        this.email = email;
        this.name = name;
        this.sex = sex;
        this.age = age;
    }

    public Student(Long id, String name, String sex, String major) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.major = major;
    }

}
