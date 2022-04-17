package com.techtree.portal.controller;

import com.techtree.common.api.CommonResult;
import com.techtree.common.exception.Assert;
import com.techtree.portal.model.DO.Student;
import com.techtree.portal.model.VO.StudentAuthVo;
import com.techtree.portal.model.VO.StudentInfoVo;
import com.techtree.portal.model.VO.StudentTokenVo;
import com.techtree.portal.service.impl.StudentServiceImpl;
import com.techtree.portal.util.MailServiceUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @author Dysprosium
 * @title: MailController
 * @projectName dashboard-backend
 * @description: TODO
 * @date 2022-03-3014:06
 */

@Api(tags = "注册-登录模块")
@Controller
@RestController
@CrossOrigin
public class AuthController {

    @Resource
    private MailServiceUtil mailServiceUtil;
    @Resource
    private RedisTemplate<String, Object> redisTemplate;
    @Resource
    StudentServiceImpl studentService;

    /**
     * 将验证码发送到指定邮箱
     * @param emailMap 发送验证码的邮箱
     * @return 发送邮件的结果
     */
    @PostMapping("/sendCode")
    @ApiOperation(value = "发送邮件验证码", notes = "传入需要注册的邮箱")
    public CommonResult<Object> SendEmail(@RequestBody  Map<String, Object> emailMap) {
        boolean sendEmail = studentService.sendEmail(emailMap.get("to").toString());
        if (!sendEmail) return CommonResult.failed(null, "发送验证码失败");
        return CommonResult.success(null, "发送验证码成功");
    }


    /**
     * 注册
     * @param student 注册的学生信息
     * @return  注册的结果
     */
    @PostMapping ("/registry")
    @ApiOperation(value = "注册", notes = "传入需要注册的学生Json和验证码")
    public CommonResult<StudentInfoVo> registry(@RequestBody StudentAuthVo student) {
        studentService.registry(student);
        StudentInfoVo studentInfoVo = new StudentInfoVo(student.getId(), student.getName(), student.getSex(), student.getEmail(), student.getMajor());
        return CommonResult.success(studentInfoVo, "注册成功");
    }

    /**
     * 登录
     * @param passwordMap 登录密码
     * @return 登陆的结果
     */
    @PostMapping("/login")
    @ApiOperation(value = "登录", notes = "传入帐号和密码")
    public CommonResult<StudentTokenVo> login(@RequestBody Map<String, Object> passwordMap) {
        StudentTokenVo login = studentService.login(passwordMap.get("email").toString(), passwordMap.get("password").toString());

        return CommonResult.success(login, "登陆成功");
    }
}
