package com.chloneda.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chloneda
 * @description:
 *  访问路径：http://localhost:8080/login
 *  用户名：root
 *  密 码：123456
 */
@RestController
@RequestMapping("/")
public class HelloController {

    @RequestMapping("/index")
    public String hello() {
        return "Hello world, Spring Security!";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        return "login";
    }

}
