package com.lwf.interceper;

import com.lwf.pojo.User;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author lwf
 * @title: LoginIntercepter
 * @projectName 11_24springMVC
 * @description: 拦截器，没有密码的去登录
 * @date 2020/11/2616:03
 */
public class LoginIntercepter extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        User user= (User) request.getSession().getAttribute("user");
        if(user==null){
            response.sendRedirect(request.getContextPath()+"/index.jsp");
            return false;
        }else {
            return true;
        }
    }
}
