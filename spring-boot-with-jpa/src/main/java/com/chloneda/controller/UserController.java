package com.chloneda.controller;

import com.chloneda.model.User;
import com.chloneda.service.UserService;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @Created by chloneda
 * @Description: 访问路径：http://localhost:8056/users
 */
@RestController
@RequestMapping("/users")
public class UserController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/", method = RequestMethod.POST)
    @ResponseStatus
    public ResponseEntity<User> create(@RequestBody User user) {
        User obj = userService.create(user);
        return new ResponseEntity(obj, HttpStatus.OK);
    }

    @RequestMapping(value = "/{userId}", method = RequestMethod.DELETE)
    @ResponseStatus
    public ResponseEntity<Void> delete(@PathVariable("userId") String userId) {
        userService.delete(userId);
        return new ResponseEntity(new HttpHeaders(), HttpStatus.OK);
    }

    @RequestMapping(value = "/", method = RequestMethod.PUT)
    @ResponseStatus
    public ResponseEntity<User> update(@RequestBody User user) {
        User obj = userService.update(user);
        return new ResponseEntity(obj, HttpStatus.OK);
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseStatus
    public ResponseEntity<List<User>> getUsersList() {
        List<User> userList = userService.findAll();
        return new ResponseEntity(userList, HttpStatus.OK);
    }

    @RequestMapping(value = "/{username}", method = RequestMethod.GET)
    @ResponseStatus
    public ResponseEntity<User> getUserByName(@PathVariable("username") String username) {
        User user = userService.getUserByName(username);
        LOGGER.info("=====> User: " + user);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @RequestMapping(value = "/listBySort", method = RequestMethod.GET)
    @ResponseStatus
    public ResponseEntity<List<User>> getUsersListBySort(@PathVariable("gender") String gender) {
        List<String> sortParameters = new ArrayList<>();
        sortParameters.add("address");
        sortParameters.add("email");
        Sort sort = new Sort(Sort.Direction.DESC, sortParameters);
        List<User> userList = userService.findUsersByGender(gender, sort);
        return new ResponseEntity(userList, HttpStatus.OK);
    }

    @RequestMapping(value = "/listByPage", method = RequestMethod.GET)
    @ResponseStatus
    public ResponseEntity<Page<User>> getUsersListByPage(
            @PathVariable("gender") String gender,
            @RequestParam(value = "pageSize", required = false) int pageSize,
            @RequestParam(value = "pageNumber", required = false) int pageNumber) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize, Sort.Direction.DESC, "p_id");
        Page<User> userPage = userService.findUsersByGender(gender, pageable);
        LOGGER.info("查询结果总行数: {}", userPage.getTotalElements());
        LOGGER.info("按照当前分页大小，总页数: {}", userPage.getTotalPages());
        return new ResponseEntity(userPage, HttpStatus.OK);
    }

}
