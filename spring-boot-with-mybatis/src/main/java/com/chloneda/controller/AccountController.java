package com.chloneda.controller;

import com.chloneda.model.Account;
import com.chloneda.service.AccountService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
@RequestMapping(value = "/accounts")
public class AccountController {

    private static final Logger logger = LoggerFactory.getLogger(AccountController.class);

    @Autowired
    private AccountService testService;

    @ResponseBody
    @RequestMapping("/test")
    public List<Account> test(HttpServletRequest request, HttpServletResponse response) {
        List<Account> accountList = this.testService.findAccountsById(123);
        logger.info("accountList{}: " + accountList);
        return accountList;
    }

}
