package com.chloneda.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chloneda
 * @description: 访问路径: http://localhost:8056/aop/sayHello
 */
@RestController
@RequestMapping(value = "/aop")
public class AopController {

    @RequestMapping(value = "/sayHello")
    public void sayHello(){
        System.out.println("Hello,Spring Boot Aop!!!");
    }

}
