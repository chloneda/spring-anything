package com.chloneda.controller;

import com.chloneda.service.UserService;
import com.chloneda.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping(method = RequestMethod.POST)
    public int create(@RequestBody User user) {
        return this.userService.create(user);
    }

    @RequestMapping(value = "/{userId}",method = RequestMethod.POST)
    public int update(@PathVariable("userId") String usreId,@RequestBody User user) {
        user.setId(usreId);
        return this.userService.create(user);
    }

    @RequestMapping(value = "/{userId}", method = RequestMethod.DELETE)
    public int delete(@PathVariable("userId") String userId) {
        return this.userService.delete(userId);
    }

    @RequestMapping(value = "/{userId}", method = RequestMethod.GET)
    public User getUserById(@PathVariable("userId") String userId) {
        return this.userService.getUserById(userId);
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public List<Map<String, Object>> getUsersList() {
        System.out.println(this.userService.getUsersList());
        return this.userService.getUsersList();
    }

}
