package com.chloneda.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chloneda
 * @description:
 */
@RestController
public class HelloController {

    @RequestMapping("/")
    public String sayHello() {
        return "Hello,Spring Boot 2.1.6-RELEASE!";
    }

}
