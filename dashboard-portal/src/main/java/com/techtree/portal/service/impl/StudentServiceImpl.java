package com.techtree.portal.service.impl;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.crypto.digest.BCrypt;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.techtree.common.exception.Assert;
import com.techtree.portal.mapper.StudentMapper;
import com.techtree.portal.model.DO.Student;
import com.techtree.portal.model.VO.StudentTokenVo;
import com.techtree.portal.service.StudentService;
import com.techtree.portal.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student> implements StudentService {

    @Autowired
    StudentMapper studentMapper;

    @Autowired
    JwtUtil jwtUtil;


    @Override
    public List<Student> getAllStudents() {
        return studentMapper.selectList(null);

    }

    @Override
    public Student getStudentById(long id) {
        Student student = studentMapper.selectById(id);
        if (ObjectUtil.isNull(student)) {
            Assert.fail("学生信息不存在");
        }
        return student;
    }

    @Override
    public Student getStudentByName(String name) {
        Student student = studentMapper.selectById(name);
        if (ObjectUtil.isNull(student)) {
            Assert.fail("学生信息不存在");
        }
        return student;
    }

    @Override
    public int addStudent(Student student) {
        int insert = studentMapper.insert(student);
        if(insert == 0) {
            Assert.fail("增加学生信息失败");
        }
        return insert;
    }

    @Override
    public int updateStudent(Student student) {
        int update = studentMapper.update(student, null);
        if(update == 0) {
            Assert.fail("修改学生信息失败");
        }
        return update;
    }

    @Override
    public int deleteStudentById(long id) {
        int deleteById = studentMapper.deleteById(id);
        if(deleteById == 0) {
            Assert.fail("删除学生信息失败");
        }
        return deleteById;
    }

    @Override
    public StudentTokenVo login(long id, String password) {
        Student result = this.getOne(new QueryWrapper<Student>().eq("id", id));
        System.out.println("student:" + result.toString());
        if(ObjectUtil.isNull(result)) {
            Assert.fail("学生信息不存在");
        }
        boolean checkPassword = password.equals(result.getPassword());
        if(!checkPassword) {
            Assert.fail("用户名或密码输入错误，请重试");
        }
        String token = jwtUtil.createToken(String.valueOf(id), result.getName());
        StudentTokenVo studentTokenVo = new StudentTokenVo();
        studentTokenVo.setStudent(result);
        studentTokenVo.setAccessToken(token);
        return studentTokenVo;
    }


}
