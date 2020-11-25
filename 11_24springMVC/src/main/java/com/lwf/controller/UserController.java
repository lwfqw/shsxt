package com.lwf.controller;

import com.lwf.pojo.User;
import com.lwf.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @author lwf
 * @title: UserController
 * @projectName 11_24springMVC
 * @description: TODO
 * @date 2020/11/2519:48
 */
@Controller
public class UserController {
    @Autowired
    private UserService userService;
    @GetMapping("/user")
    public ModelAndView queryAll(){
        ModelAndView view=new ModelAndView();
        List<User> list=userService.queryAll();
        list.forEach(System.out::println);
        view.addObject("users",list);
        view.setViewName("listUser");
        return view;
    }
}
