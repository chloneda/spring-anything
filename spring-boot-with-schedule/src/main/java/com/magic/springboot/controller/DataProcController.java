package com.magic.springboot.controller;

import com.magic.springboot.service.DataProcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by chl
 * Description:
 */
@Controller
@RestController
public class DataProcController {

    @Autowired
    private DataProcService dataProcService;

    @RequestMapping("/doQuery")
    public List doQuery(String sql){
        return  dataProcService.doQuery(sql);
    }

}
