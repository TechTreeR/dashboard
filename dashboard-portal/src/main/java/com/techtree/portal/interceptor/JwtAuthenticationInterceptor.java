package com.techtree.portal.interceptor;

import com.techtree.common.api.ResultCode;
import com.techtree.common.exception.Assert;
import com.techtree.portal.model.DO.Student;
import com.techtree.portal.model.VO.StudentInfoVo;
import com.techtree.portal.service.StudentService;
import com.techtree.portal.service.impl.StudentServiceImpl;
import com.techtree.portal.util.JwtUtil;
import io.jsonwebtoken.Claims;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Dysprosium
 * @title: JwtAuthenticationInterceptor
 * @projectName dashboard-backend
 * @description: TODO
 * @date 2022-03-2822:31
 */
@Slf4j
public class JwtAuthenticationInterceptor implements HandlerInterceptor {

    @Autowired
    StudentServiceImpl studentService;

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object handler) throws Exception {
        log.info("经过preHandle拦截器");
        System.out.println(httpServletRequest.toString());
        String token = httpServletRequest.getHeader("token");
        System.out.println(token);
        if(token == null)   Assert.fail(ResultCode.UNAUTHORIZED);
        JwtUtil jwtUtil = new JwtUtil();
        String userId = JwtUtil.getAudience(token);

        StudentInfoVo studentByName = studentService.getStudentByName(userId);
        System.out.println("student: " + studentByName.toString());
        if(studentByName == null)   Assert.fail(ResultCode.UNAUTHORIZED);

        JwtUtil.verifyToken(token, userId);

        String userName = JwtUtil.getClaimByName(token, "userName").asString();
        log.info("通过preHandle拦截器校验");
        return true;

    }

}