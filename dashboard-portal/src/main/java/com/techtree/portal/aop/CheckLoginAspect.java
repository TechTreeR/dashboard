package com.techtree.portal.aop;

import com.techtree.common.api.ResultCode;
import com.techtree.common.exception.Assert;
import com.techtree.portal.model.DO.Student;
import com.techtree.portal.model.VO.StudentInfoVo;
import com.techtree.portal.service.impl.StudentServiceImpl;
import com.techtree.portal.util.JwtUtil;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Dysprosium
 * @title: HttpAspect
 * @projectName dashboard-backend
 * @description: TODO
 * @date 2022-03-2921:01
 */


@Aspect
@Slf4j
@Component
public class CheckLoginAspect {

    @Autowired
    StudentServiceImpl studentService;

    /**
     * 检查是否需要登陆的切面，作用在@checkLogin前后
     * @param point 切面
     * @return 切面继续进行
     * @throws Throwable
     */
    @Around("@annotation(com.techtree.portal.annotation.CheckLogin)")
    public Object checkLogin(ProceedingJoinPoint point) throws Throwable {
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        ServletRequestAttributes attributes = (ServletRequestAttributes) requestAttributes;
        HttpServletRequest request = attributes.getRequest();

        String token = request.getHeader("token");
        if(token == null)   Assert.fail(ResultCode.UNAUTHORIZED);
        JwtUtil jwtUtil = new JwtUtil();
        String userId = JwtUtil.getAudience(token);
        System.out.println(userId);
        StudentInfoVo studentByEmail = studentService.getStudentByEmail(userId);
        System.out.println("student: " + studentByEmail.toString());
        if(studentByEmail == null)   Assert.fail(ResultCode.UNAUTHORIZED);
        JwtUtil.verifyToken(token, userId);

        return point.proceed();

    }




}
