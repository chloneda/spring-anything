package com.chloneda.controller;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Created by chloneda
 * @Description:
 */
@RestController
public class WebController {

    @RequestMapping(value = "/index",method = RequestMethod.GET)
    public String index(ModelMap modelMap) {
        return "index";
    }

}
