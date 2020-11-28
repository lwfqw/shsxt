package com.lwf.springbootstart.intercepter;

import com.fasterxml.jackson.databind.cfg.HandlerInstantiator;
import com.lwf.springbootstart.pojo.User;
import org.aopalliance.intercept.Interceptor;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * @author lwf
 * @title: GlobalIntercepter
 * @projectName spring-boot-start
 * @description: TODO
 * @date 2020/11/2720:01
 */
public class GlobalIntercepter  implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        User user= (User) request.getSession().getAttribute("user");
        System.out.println("-----------------------拦截器");
        if(user==null){
            System.out.println("拦截");
            return false;
        }
        return true;
    }
}
