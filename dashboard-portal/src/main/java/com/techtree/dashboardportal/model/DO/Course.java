package com.techtree.dashboardportal.model.DO;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Course {
    @TableId(value = "cid", type = IdType.ASSIGN_ID)
    private String cid;
    private String cname;
    private String tname;
    private String cstart;
    private String cend;
    private Float credit;
    private int year;
    private int semester;
    private String place;
    private Long capacity;
    private Long remains;
    private Boolean canSelect;
    private int startWeek;
    private int endWeek;








}
