package com.chloneda.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author chloneda
 * @description:
 *
 * 访问用户信息接口:http://localhost:8056/secure/getUserInfo
 * header里需要携带token
 */
@RestController
@RequestMapping(value = "/")
public class SecureController {

    /**
     * 查询用户信息，登录后才能访问
     */
    @RequestMapping(value = "/secure/getUserInfo",method = RequestMethod.GET)
    public String login(HttpServletRequest request) {
        String id = request.getAttribute("id").toString();
        String username = request.getAttribute("username").toString();
        String password = request.getAttribute("password").toString();
        return "当前用户信息id=" + id + ",username=" + username + ",password=" + password;
    }

}
