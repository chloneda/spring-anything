package com.chloneda.controller;

import com.chloneda.service.UserService;
import com.chloneda.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @author chloneda
 * @description:
 */
@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/{userId}", method = RequestMethod.GET)
    public User getUserById(@PathVariable("userId") String userId) {
        return this.userService.getUserById(userId);
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public List<Map<String, Object>> getUsersList() {
        System.out.println(this.userService.getUsersList());
        return this.userService.getUsersList();
    }

    @RequestMapping(method = RequestMethod.POST)
    public int create(User user) {
        return this.userService.create(user);
    }

    @RequestMapping(value = "/{userId}", method = RequestMethod.DELETE)
    public int delete(@PathVariable("userId") String userId) {
        return this.userService.delete(userId);
    }

}
