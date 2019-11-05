package com.magic.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Created by chloneda
 * @Description:
 */
@Controller
public class WebController {

    @RequestMapping("/index")
    public String index(ModelMap modelMap) {
        return "index";
    }

}
