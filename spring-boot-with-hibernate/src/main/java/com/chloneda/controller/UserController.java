package com.chloneda.controller;

import com.chloneda.model.User;
import com.chloneda.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Created by chloneda
 * @Description:
 */
@RestController
public class UserController {
    private static final Logger LOGGER= LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/getUser",method = RequestMethod.GET)
    public User getUser(String userId){
        User user=userService.getUser(userId);
        LOGGER.info("=====> User: "+user);
        return user;
    }

}
