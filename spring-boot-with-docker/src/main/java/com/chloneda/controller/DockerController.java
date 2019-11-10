package com.chloneda.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chloneda
 * @description:
 */
@RestController
@RequestMapping("/")
public class DockerController {

    @RequestMapping("/")
    public String index() {
        return "My Docker!";
    }

}