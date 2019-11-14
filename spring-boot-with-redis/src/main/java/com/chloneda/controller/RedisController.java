package com.chloneda.controller;

import com.chloneda.model.Girl;
import com.chloneda.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chloneda
 * @description: 访问路径: http://localhost:8056/api/..
 */
@RestController
@RequestMapping(value = "/api")
public class RedisController {

    @Autowired
    private RedisService redisService;

    @GetMapping(value = "saveGirl")
    public String saveCity(Girl girl){
        redisService.set(girl.getId()+"",girl);
        return "success";
    }

    @GetMapping(value = "getGirlById")
    public Girl getCity(int girlId){
        Girl girl = (Girl) redisService.get(girlId+"");
        return girl;
    }
}
