package com.chloneda.controller;

import com.chloneda.domain.User;
import com.chloneda.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Created by chloneda
 * @Description:
 */
@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/{userId}", method = RequestMethod.GET)
    public User getUserById(@PathVariable("userId") String userId) {
        User user = this.userService.getUserById(userId);
        return user;
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public void create(@RequestBody User user) {
        userService.create(user);
    }

    @RequestMapping(value = "/{userId}", method = RequestMethod.DELETE)
    public void delete(@PathVariable(value = "userId") String userId) {
        userService.delete(userId);
    }

    @RequestMapping(value = "/{userId}", method = RequestMethod.PUT)
    public void update(@RequestBody User user) {
        userService.update(user);
    }

}
