package com.lwf.controller;

import com.lwf.pojo.MSG;
import com.lwf.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * @author lwf
 * @title: UserController
 * @projectName 11_23AOP
 * @description: TODO
 * @date 2020/11/2311:29
 */
@Controller
public class UserController {
    @Autowired
    private UserService userService;
    public MSG check(String name,String password){
        return userService.check(name, password);
    }
}
