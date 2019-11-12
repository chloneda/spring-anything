package com.chloneda.controller;

import com.chloneda.model.User;
import com.chloneda.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Created by chloneda
 * @Description: 访问路径：http://localhost:8056/resources/api/user/
 */
@RestController
@RequestMapping("/")
public class UserController {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/api/user",method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User obj = userService.createUser(user);
        return new ResponseEntity(obj,HttpStatus.OK);
    }

    @RequestMapping(value = "/api/user/{userId}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteUser(@PathVariable String userId){
        userService.deleteUser(userId);
        return new ResponseEntity(new HttpHeaders(), HttpStatus.OK);
    }

    @RequestMapping(value = "/api/user", method = RequestMethod.PUT)
    public ResponseEntity<User> updateUser(@RequestBody User user){
        User obj=userService.updateUser(user);
        return new ResponseEntity(obj,HttpStatus.OK);
    }

    @RequestMapping(value = "/api/user/list", method = RequestMethod.GET)
    public ResponseEntity<List<User>> getAllUser() {
        List<User> userList = userService.findAll();
        return new ResponseEntity(userList,HttpStatus.OK);
    }

    @RequestMapping(value = "/api/user/{username}", method = RequestMethod.GET)
    public ResponseEntity<User> getUser(String username) {
        User user = userService.findUser(username);
        LOGGER.info("=====> User: " + user);
        return new ResponseEntity<>(user,HttpStatus.OK);
    }

}
