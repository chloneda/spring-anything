package com.chloneda.controller;

import com.chloneda.dubbo.api.IUser;
import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Created by chloneda.
 */
@RestController
@RequestMapping("user")
public class UserController {

    @Reference(version = "1.0.0", check = false)
    IUser user;

    @RequestMapping("/{id}")
    public String view(@PathVariable("id") int id) {
        String result = user.getNickName(id);
        return result;
    }

    @RequestMapping("/info/{name}")
    public String view(@PathVariable("name") String name) {
        String result = user.getFullName(name);
        return result;
    }

}
