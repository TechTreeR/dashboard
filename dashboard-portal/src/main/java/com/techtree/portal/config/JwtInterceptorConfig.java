package com.techtree.portal.config;

import com.techtree.portal.interceptor.JwtAuthenticationInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author Dysprosium
 * @title: JwtInterceptorConfig
 * @projectName dashboard-backend
 * @description: TODO
 * @date 2022-03-2822:28
 */



//@Configuration
//public class JwtInterceptorConfig implements WebMvcConfigurer {
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(authenticationInterceptor())
//                .addPathPatterns("/students/**")
//                .excludePathPatterns("/students/login");
//    }
//    @Bean
//    public JwtAuthenticationInterceptor authenticationInterceptor() {
//        return new JwtAuthenticationInterceptor();
//    }
//
//
//}
