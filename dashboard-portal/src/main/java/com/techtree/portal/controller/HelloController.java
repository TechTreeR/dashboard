package com.techtree.portal.controller;


import com.techtree.portal.annotation.CheckLogin;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@CrossOrigin
public class HelloController {


    @GetMapping("/hello")
    public String hello() {
        log.info("================INFO================");
        return "Hello World";
    }

}