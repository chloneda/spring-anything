package com.chloneda.controller;

import com.chloneda.model.User;
import com.chloneda.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @Created by chloneda
 * @Description:
 */
@RestController
@Controller
public class UserController {

    private org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(UserController.class);

    @Autowired
    private UserService testService;

    @ResponseBody
    @RequestMapping("/test")
    public List<User> test(HttpServletRequest request, HttpServletResponse response) {
        List<User> accountList = this.testService.findAccountsById(123);
        logger.info(accountList);
        return accountList;
    }

}
