package com.techtree.portal.controller;

import com.techtree.common.api.CommonResult;
import com.techtree.common.exception.Assert;
import com.techtree.portal.model.DO.Student;
import com.techtree.portal.model.VO.StudentTokenVo;
import com.techtree.portal.service.impl.StudentServiceImpl;
import com.techtree.portal.util.MailServiceUtil;
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

@Controller
@RestController
public class AuthController {

    @Resource
    private MailServiceUtil mailServiceUtil;
    @Resource
    private RedisTemplate<String, Object> redisTemplate;
    @Resource
    StudentServiceImpl studentService;

    /**
     * 将验证码发送到指定邮箱
     * @param to 发送验证码的邮箱
     * @return 发送邮件的结果
     */
    @PostMapping("/sendCode")
    public CommonResult<Object> SendEmail(String to) {
        try {
            String code = String.valueOf((int)((Math.random() * 9 + 1) * 100000));
            mailServiceUtil.sendMail("support@techtree.tech", to, "验证码", code);
            redisTemplate.opsForValue().set(to, code,5, TimeUnit.MINUTES);
        } catch (Exception e) {
            Assert.fail("发送邮件失败");
        }
        return CommonResult.success(null, "发送验证码成功");
    }


    /**
     * 注册
     * @param student 注册的学生信息
     * @param verifyCode 验证码
     * @return  注册的结果
     */
    @PostMapping ("/registry")
    public CommonResult<Student> registry(@RequestBody Student student, @RequestParam("verifyCode") String verifyCode) {
        studentService.registry(student, verifyCode);
        return CommonResult.success(student, "注册成功");
    }

    /**
     * 登录
     * @param passwordMap 登录密码
     * @return 登陆的结果
     */
    @PostMapping("/login")
    @ApiOperation(value = "登录")
    public CommonResult<StudentTokenVo> login(@RequestBody Map<String, Object> passwordMap) {
        StudentTokenVo login = studentService.login(passwordMap.get("email").toString(), passwordMap.get("password").toString());
        System.out.println(login.toString());
        return CommonResult.success(login, "登陆成功");
    }
}
