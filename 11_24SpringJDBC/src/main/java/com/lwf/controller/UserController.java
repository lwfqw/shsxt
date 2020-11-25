package com.lwf.controller;

import com.lwf.pojo.User;
import com.lwf.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Map;

/**
 * @author lwf
 * @title: UserController
 * @projectName 11_24SpringJDBC
 * @description: TODO
 * @date 2020/11/249:52
 */
@Controller
public class UserController {
    //jdbctemplate
    @Autowired
    private UserService userService;
    public List<Map<String, Object>> queryAll(){
        return userService.queryAll();
    }
    //mybatis
    public List<User> all(){return userService.allMybatis();}
    public User byEmail(String email){return userService.queryByEmail(email);}

}
