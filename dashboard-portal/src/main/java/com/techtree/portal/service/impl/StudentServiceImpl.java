package com.techtree.portal.service.impl;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.crypto.digest.BCrypt;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.techtree.common.exception.Assert;
import com.techtree.portal.mapper.SCMapper;
import com.techtree.portal.mapper.StudentMapper;
import com.techtree.portal.model.DO.Course;
import com.techtree.portal.model.DO.Student;
import com.techtree.portal.model.DO.StudentCourseRelation;
import com.techtree.portal.model.VO.StudentInfoVo;
import com.techtree.portal.model.VO.StudentTokenVo;
import com.techtree.portal.service.StudentService;
import com.techtree.portal.util.JwtUtil;
import com.techtree.portal.util.MailServiceUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
@Slf4j
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student> implements StudentService {

    @Resource
    private StudentMapper studentMapper;
    @Resource
    private JwtUtil jwtUtil;
    @Resource
    private MailServiceUtil mailServiceUtil;
    @Resource
    private RedisTemplate<String, Object> redisTemplate;
    @Autowired
    private SCMapper scMapper;

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
            log.error("查询id为 {} 的学生信息不存在", id);
            Assert.fail("学生信息不存在");
        }
        return studentInfoVo;
    }

    @Override
    public StudentInfoVo getStudentByName(String name) {
        Student student = this.getOne(new QueryWrapper<Student>().eq("name", name));
        StudentInfoVo studentInfoVo = new StudentInfoVo(student.getId(), student.getName(), student.getSex(), student.getEmail(), student.getMajor());
        if (ObjectUtil.isNull(student)) {
            log.error("查询name为 {} 的学生信息不存在", name);
            Assert.fail("学生信息不存在");
        }
        return studentInfoVo;
    }

    @Override
    public StudentInfoVo getStudentByEmail(String email) {
        Student student = this.getOne(new QueryWrapper<Student>().eq("email", email));
        StudentInfoVo studentInfoVo = new StudentInfoVo(student.getId(), student.getName(), student.getSex(), student.getEmail(), student.getMajor());
        if (ObjectUtil.isNull(student)) {
            log.error("查询email为 {} 的学生信息不存在", email);
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
            log.error("增加学生信息 {} 不存在", student);
            Assert.fail("增加学生信息失败");
        }
        return insert;
    }

    @Override
    public boolean updateStudent(Student student) {
        boolean update = this.update(student, new UpdateWrapper<Student>().eq("id", student.getId()));
        if(!update) {
            log.error("更新学生信息 {} 不存在", student);
            Assert.fail("修改学生信息失败");
        }
        return true;
    }

    @Override
    public int deleteStudentById(long id) {
        int deleteById = studentMapper.deleteById(id);
        if(deleteById == 0) {
            log.error("删除id为 {} 的学生失败", id);
            Assert.fail("删除学生信息失败");
        }
        return deleteById;
    }

    @Override
    public StudentTokenVo login(String email, String password) {
        Student result = this.getOne(new QueryWrapper<Student>().eq("email", email));
        if(ObjectUtil.isNull(result)) {
            log.error("查询email为 {} 的学生信息不存在", email);
            Assert.fail("学生信息不存在，请注册");
        }
        boolean checkPassword = BCrypt.checkpw(password, result.getPassword());
        if(!checkPassword) {
            log.error("用户名 {} 和 密码 {} 不匹配", email, password);
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
        log.info("检查邮箱{}是否已被注册:{}", student.getEmail(), emailExist);
        if(emailExist) {
            log.error("邮箱{}已被注册", student.getEmail());
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

    @Override
    public boolean sendEmail(String to) {
        try {
            String code = String.valueOf((int)((Math.random() * 9 + 1) * 100000));
            mailServiceUtil.sendMail("support@techtree.tech", to, "验证码", code);
            redisTemplate.opsForValue().set(to, code,5, TimeUnit.MINUTES);
        } catch (Exception e) {
            Assert.fail("发送邮件失败");
        }
        return true;
    }

    @Override
    public List<StudentCourseRelation> getStudentCourses(long id) {
        List<StudentCourseRelation> sid = scMapper.selectList(new QueryWrapper<StudentCourseRelation>().eq("sid", id));
        if (sid.isEmpty()) {
            log.error("查询id为 {} 的学生信息不存在", id);
            Assert.fail("选课信息不存在");
        }
        return sid;
    }


}
