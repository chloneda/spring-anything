package com.chloneda.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chloneda
 * @description:
 */
@RestController
@RequestMapping("/docker")
public class DockerController {

    @RequestMapping(method = RequestMethod.GET)
    public String index() {
        return "My Docker!";
    }

}