package com.chloneda.controller;

import com.chloneda.model.User;
import com.chloneda.service.CacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * @Created by chloneda
 * @Description: 访问路径：http://localhost:8056/api/getUser
 */
@RestController
@RequestMapping("/api")
public class CacheController {

    @Autowired
    private CacheService cacheService;

    @RequestMapping(value = "/getUser/{username}", method = RequestMethod.GET)
    public User getUser(@PathVariable String username) {
        User user = cacheService.findUserByName(username);
        return user;
    }

}
