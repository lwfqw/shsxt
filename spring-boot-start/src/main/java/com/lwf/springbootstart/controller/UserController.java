package com.lwf.springbootstart.controller;

import com.lwf.springbootstart.pojo.User;
import com.lwf.springbootstart.service.UserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author lwf
 * @title: UserController
 * @projectName spring-boot-start
 * @description: TODO
 * @date 2020/11/2717:03
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserService userService;
    @RequestMapping("/hello")
    public Map<String,String> hello(){
        Map<String,String> map=new HashMap<>();
        map.put("name", "lwf");
        return map;
    }
    @RequestMapping(value = "/",method = RequestMethod.GET)
    public List<User> users(){
        return userService.queryAll();
    }
    @RequestMapping(value = "/",method = RequestMethod.POST)
    public  Map<String,String> login( @RequestBody User user){
        return userService.login(user.getId(), user.getPassword());
    }
}
