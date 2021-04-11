package com.chloneda.controller;

import com.chloneda.domain.User;
import com.chloneda.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Created by chloneda
 * @Description:
 */
@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.POST)
    public User create(@RequestBody User user) {
        User obj = userService.create(user);
        return obj;
    }

    @RequestMapping(value = "/{userId}", method = RequestMethod.DELETE)
    public void delete(@PathVariable String userId) {
        userService.delete(userId);
    }

    @RequestMapping(value = "/{userId}", method = RequestMethod.PUT)
    public User update(@PathVariable("userId") String userId,@RequestBody User user) {
        user.setId(userId);
        User obj = userService.update(user);
        return obj;
    }

    private static final String USER_LIST_PATH_NAME = "userList";

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String getAllUser(final Model model) {
        List<User> userList = userService.findAll();
        model.addAttribute("userList", userList);
        return USER_LIST_PATH_NAME;
    }

    @RequestMapping(value = "/{username}", method = RequestMethod.GET)
    public User getUserByName(@PathVariable("username") String username) {
        User user = userService.findUserByName(username);
        return user;
    }

}
