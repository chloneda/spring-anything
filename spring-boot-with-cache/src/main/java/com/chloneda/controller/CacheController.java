package com.chloneda.controller;

import com.chloneda.domain.User;
import com.chloneda.service.CacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Created by chloneda
 * @Description: 访问路径：http://localhost:8056/cache/users
 */
@RestController
@RequestMapping("/cache")
public class CacheController {

    @Autowired
    private CacheService cacheService;

    @RequestMapping(value = "/users/{username}", method = RequestMethod.GET)
    public User getUser(@PathVariable("username") String username) {
        User user = cacheService.findUserByName(username);
        return user;
    }

}
