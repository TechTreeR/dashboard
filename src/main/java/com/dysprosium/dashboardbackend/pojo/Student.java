package com.dysprosium.dashboardbackend.pojo;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "student")
public class Student {
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private Long id;
    private String stuName;
}
