package com.chloneda.controller;

import com.chloneda.domain.User;
import com.chloneda.service.UserService;
import com.chloneda.utils.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Created by chloneda
 * @Description:
 *
 * 访问登录接口: http://localhost:8056/login?name=lili&password=123456
 */
@RestController
@RequestMapping("/")
public class LoginController {

    @Autowired
    private UserService userService;

    /**
     * 模拟用户 登录
     */
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String login(User user) {
        List<User> userList=userService.findAll();
        for (User aUser : userList) {
            if (aUser.getName().equals(user.getName()) && aUser.getPassword().equals(user.getPassword())) {
                System.out.println("登录成功！生成token！");
                String token = JwtUtils.createToken(aUser);
                return token;
            }
        }
        return "";
    }

}
