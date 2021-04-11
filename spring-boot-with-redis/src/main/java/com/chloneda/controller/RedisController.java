package com.chloneda.controller;

import com.chloneda.domain.Girl;
import com.chloneda.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chloneda
 * @description: 访问路径: http://localhost:8056/redis/..
 */
@RestController
@RequestMapping(value = "/redis")
public class RedisController {

    @Autowired
    private RedisService redisService;

    @GetMapping(value = "saveGirl")
    public String saveGirl(Girl girl){
        redisService.set(girl.getId()+"",girl);
        return "success";
    }

    @GetMapping(value = "getGirlById")
    public Girl getGirl(int girlId){
        Girl girl = (Girl) redisService.get(girlId+"");
        return girl;
    }
}
