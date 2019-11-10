package com.chloneda.controller;

import com.chloneda.service.UserService;
import com.chloneda.model.User;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("/")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/query", method = RequestMethod.GET)
    public User queryUserById(String userId) {
        return this.userService.queryUserById(userId);
    }

    @RequestMapping(value = "/queryAll")
    public List<Map<String, Object>> queryUsersListMap() {
        System.out.println(this.userService.queryUsersListMap());
        return this.userService.queryUsersListMap();
    }

    @RequestMapping(value = "/create", method = RequestMethod.PUT)
    public int create(User user) {
        return this.userService.create(user);
    }

    @RequestMapping(value = "delete", method = RequestMethod.DELETE)
    public int deleteUserById(String userId) {
        return this.userService.deleteUserById(userId);
    }

}
