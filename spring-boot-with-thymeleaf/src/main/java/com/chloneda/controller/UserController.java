package com.chloneda.controller;

import com.chloneda.model.User;
import com.chloneda.service.UserService;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Created by chloneda
 * @Description:
 */
@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/user",method = RequestMethod.POST)
    public User create(@ApiParam(value = "用户实体") @RequestBody User user) {
        User obj = userService.create(user);
        return obj;
    }

    @RequestMapping(value = "/user/{userId}", method = RequestMethod.DELETE)
    public void delete(@ApiParam(value = "用户ID") @PathVariable String userId){
        userService.delete(userId);
    }

    @RequestMapping(value = "/user/{userId}", method = RequestMethod.PUT)
    public User update(@ApiParam(value = "用户实体") @RequestBody User user){
        User obj=userService.update(user);
        return obj;
    }

    private static final String USER_LIST_PATH_NAME = "userList";

    @RequestMapping(value = "/user/list", method = RequestMethod.GET)
    public String getAllUser(final Model model) {
        List<User> userList = userService.findAll();
        model.addAttribute("userList",userList);
        return USER_LIST_PATH_NAME;
    }

    @RequestMapping(value = "/user/getUser/{username}", method = RequestMethod.GET)
    public User getUserByName(String username) {
        User user = userService.findUserByName(username);
        return user;
    }

}
