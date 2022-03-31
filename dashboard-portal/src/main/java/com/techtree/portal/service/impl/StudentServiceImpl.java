package com.techtree.portal.service.impl;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.crypto.digest.BCrypt;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.techtree.common.exception.Assert;
import com.techtree.portal.mapper.StudentMapper;
import com.techtree.portal.model.DO.Student;
import com.techtree.portal.model.VO.StudentInfoVo;
import com.techtree.portal.model.VO.StudentTokenVo;
import com.techtree.portal.service.StudentService;
import com.techtree.portal.util.JwtUtil;
import com.techtree.portal.util.MailServiceUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student> implements StudentService {

    @Autowired
    StudentMapper studentMapper;
    @Resource
    private JwtUtil jwtUtil;
    @Resource
    private MailServiceUtil mailServiceUtil;
    @Resource
    private RedisTemplate<String, Object> redisTemplate;

    @Override
    public List<StudentInfoVo> getAllStudents() {
        List<Student> students = studentMapper.selectList(null);
        List<StudentInfoVo> studentInfoVos = new ArrayList<>();
        for (Student student : students) {
            studentInfoVos.add(new StudentInfoVo(student.getId(), student.getName(), student.getSex(), student.getEmail(), student.getMajor()));
        }
        return studentInfoVos;
    }

    @Override
    public StudentInfoVo getStudentById(long id) {
        Student student = studentMapper.selectById(id);
        StudentInfoVo studentInfoVo = new StudentInfoVo(student.getId(), student.getName(), student.getSex(), student.getEmail(), student.getMajor());
        if (ObjectUtil.isNull(student)) {
            Assert.fail("学生信息不存在");
        }
        return studentInfoVo;
    }

    @Override
    public StudentInfoVo getStudentByName(String name) {
        Student student = this.getOne(new QueryWrapper<Student>().eq("name", name));
        StudentInfoVo studentInfoVo = new StudentInfoVo(student.getId(), student.getName(), student.getSex(), student.getEmail(), student.getMajor());
        if (ObjectUtil.isNull(student)) {
            Assert.fail("学生信息不存在");
        }
        return studentInfoVo;
    }

    @Override
    public StudentInfoVo getStudentByEmail(String email) {
        Student student = this.getOne(new QueryWrapper<Student>().eq("email", email));
        StudentInfoVo studentInfoVo = new StudentInfoVo(student.getId(), student.getName(), student.getSex(), student.getEmail(), student.getMajor());
        if (ObjectUtil.isNull(student)) {
            Assert.fail("学生信息不存在");
        }
        return studentInfoVo;
    }


    @Override
    public boolean checkEmailExist(String email) {
        Student student = studentMapper.selectById(email);
        if (ObjectUtil.isNull(student)) {
            return false;
        }
        return true;
    }

    @Override
    public int addStudent(Student student) {
        student.setPassword(BCrypt.hashpw(student.getPassword()));
        int insert = studentMapper.insert(student);
        if(insert == 0) {
            Assert.fail("增加学生信息失败");
        }
        return insert;
    }

    @Override
    public boolean updateStudent(Student student) {
        boolean update = this.update(student, new UpdateWrapper<Student>().eq("id", student.getId()));
        if(!update) {
            Assert.fail("修改学生信息失败");
        }
        return true;
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
    public StudentTokenVo login(String email, String password) {
        Student result = this.getOne(new QueryWrapper<Student>().eq("email", email));
        if(ObjectUtil.isNull(result)) {
            Assert.fail("学生信息不存在，请注册");
        }
        boolean checkPassword = BCrypt.checkpw(password, result.getPassword());
        if(!checkPassword) {
            Assert.fail("用户名或密码输入错误，请重试");
        }
        String token = jwtUtil.createToken(email, result.getName());
        StudentTokenVo studentTokenVo = new StudentTokenVo();
        studentTokenVo.setStudent(new StudentInfoVo(result.getId(), result.getName(), result.getSex(), result.getEmail(), result.getMajor()));
        studentTokenVo.setAccessToken(token);
        return studentTokenVo;
    }

    @Override
    public int registry(Student student, String verifyCode) {
        boolean emailExist = this.checkEmailExist(student.getEmail());
        if(emailExist) {
            Assert.fail("该邮箱已被注册");
        }
        int addStudent;
        String redisCode = (String) redisTemplate.opsForValue().get(student.getEmail());
        if (redisCode.equals(verifyCode)) {
            addStudent = this.addStudent(student);
        } else {
            addStudent = 0;
            Assert.fail("验证码错误");
        }
        return addStudent;
    }


}
