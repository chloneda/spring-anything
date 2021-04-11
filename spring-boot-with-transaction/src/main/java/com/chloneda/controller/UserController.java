package com.chloneda.controller;

import com.chloneda.domain.User;
import com.chloneda.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chloneda
 * @description:
 */
@RestController
@RequestMapping(value = "/users")
public class UserController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.POST)
    public void create(User user) {
        boolean isCreate = userService.create(user);
        LOGGER.info("=====> User: " + user);
    }

}
