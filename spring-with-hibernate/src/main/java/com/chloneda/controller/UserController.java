package com.chloneda.controller;

import com.chloneda.domain.User;
import com.chloneda.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @Created by chloneda
 * @Description:
 */
@Controller
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.POST)
    public User create(@RequestBody User user){
        return userService.save(user);
    }

    @RequestMapping(value = "/{userId}",method = RequestMethod.DELETE)
    public void delete(@PathVariable("userId") String userId){
        userService.delete(userId);
    }

    @RequestMapping(value = "/update",method = RequestMethod.PUT)
    public void update(@RequestBody User user){
        userService.update(user);
    }

    @RequestMapping(value = "/{userId}",method = RequestMethod.GET)
    public User create(@PathVariable("userId") String userId){
        return userService.getById(userId);
    }
}
