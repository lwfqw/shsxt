package com.lwf.controller;

import com.lwf.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author lwf
 * @title: TestController
 * @projectName 11_24springMVC
 * @description: TODO
 * @date 2020/11/2417:44
 */
//返回对象以json方式
@RestController
//返回视图名
//@Controller
public class TestController {
    @Autowired
    private TestService testService;
    //value属性可以一个或多个url。value属性默认，所以“value=”可不写；类似与servlet的url，都是1对多的关系
    @RequestMapping(value = {"/test","/tes"},method = RequestMethod.GET)
    public ModelAndView test(){
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.addObject("one", testService.tests().get(0));
        modelAndView.setViewName("Test");
        System.out.println("控制器");
        return modelAndView;
    }

}
