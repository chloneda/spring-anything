package com.chloneda.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chloneda
 * @description:
 */
@RestController
@RequestMapping(value = "/aop")
public class AopController {

    @RequestMapping(value = "sayHello")
    public void sayHello(){
        System.out.println("Hello,Spring Boot Aop!!!");
    }

}
