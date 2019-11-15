package com.chloneda.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chloneda
 * @description:
 */
@RestController
public class QuickStartController {

    @RequestMapping(value = "/index",method = RequestMethod.GET)
    public String index(){
        return "Quick start Spring Boot 2.1.x!";
    }

}
