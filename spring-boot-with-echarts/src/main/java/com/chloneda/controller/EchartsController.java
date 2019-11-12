package com.chloneda.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chloneda
 * @description:
 */
@RestController
public class EchartsController {

    @RequestMapping("/echarts")
    public String echarts(Model model){
        System.out.println("EchartsController.echarts");
        return "echarts";
    }

}
