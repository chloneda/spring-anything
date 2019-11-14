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
 * @Description: 访问路径：http://localhost:8056/resources/users/
 */
@RestController
@RequestMapping("/users")
public class UserController {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/",method = RequestMethod.POST)
    public ResponseEntity<User> create(@RequestBody User user) {
        User obj = userService.create(user);
        return new ResponseEntity(obj,HttpStatus.OK);
    }

    @RequestMapping(value = "/{userId}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteUser(@PathVariable String userId){
        userService.delete(userId);
        return new ResponseEntity(new HttpHeaders(), HttpStatus.OK);
    }

    @RequestMapping(value = "/", method = RequestMethod.PUT)
    public ResponseEntity<User> update(@RequestBody User user){
        User obj=userService.update(user);
        return new ResponseEntity(obj,HttpStatus.OK);
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ResponseEntity<List<User>> getUsersList() {
        List<User> userList = userService.findAll();
        return new ResponseEntity(userList,HttpStatus.OK);
    }

    @RequestMapping(value = "/{username}", method = RequestMethod.GET)
    public ResponseEntity<User> getUserByName(@PathVariable("username") String username) {
        User user = userService.getUserByName(username);
        LOGGER.info("=====> User: " + user);
        return new ResponseEntity<>(user,HttpStatus.OK);
    }

}
