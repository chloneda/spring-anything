package com.magic.springboot.controller;

import com.magic.springboot.model.Account;
import com.magic.springboot.service.ITestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by chl
 * Description:
 */
@RestController
@Controller
public class TestController {
    private org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(TestController.class);
    @Autowired
    private ITestService testService;

    @ResponseBody
    @RequestMapping("/test")
    public List<Account> test(HttpServletRequest request, HttpServletResponse response) {
        List<Account> accountList = this.testService.findAccountsById(3);
        logger.info(accountList);
        return accountList;
    }

}
