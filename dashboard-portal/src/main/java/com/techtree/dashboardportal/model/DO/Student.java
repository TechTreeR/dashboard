package com.techtree.dashboardportal.model.DO;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "student")
public class Student {

    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private Long id;
    private String name;
    private String sex;
    private int age;
    private Date birthday;
    private String major;
    private String password;
    private String email;

    public Student(Long id, String name, String sex, int age, String password, String email) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.password = password;
        this.email = email;
    }
}
