package com.lwf.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author lwf
 * @title: Url
 * @projectName 11_24springMVC
 * @description: TODO
 * @date 2020/11/2611:01
 */
@RestController
public class UrlController {
    public void jump(String url, HttpServletResponse response){
        try {
            response.sendRedirect(url);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @GetMapping("/csdn")
    public void jumpCsdn(HttpServletResponse response){
        String[] url=new String[]{"https://blog.csdn.net/lwf0615/article/details/110138345","https://blog.csdn.net/lwf0615/article/details/110096870"};
        for(String string:url){
            jump(string, response);
        }
    }
}
