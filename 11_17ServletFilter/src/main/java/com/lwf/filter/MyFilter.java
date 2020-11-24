package com.lwf.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author lwf
 * @title: MyFilter
 * @projectName 11_17ServletFilter
 * @description: TODO
 * @date 2020/11/17 20:02
 */
@WebFilter("/*")
public class MyFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
//        servletRequest.setCharacterEncoding("utf-8");
//        servletResponse.setCharacterEncoding("utf-8");
        System.out.println("拦截器设置");
        if(servletRequest.getRemoteHost().equals("0:0:0:0:0:0:0:1")||servletRequest.getRemoteHost().equals("127.0.0.1")){
            filterChain.doFilter(servletRequest, servletResponse);
        }
        else {
            System.out.println("拦截访问ip"+servletRequest.getRemoteHost());
            servletResponse.setContentType("text/html;charset=utf-8");
            servletResponse.getWriter().write("古文");
        }
    }
}
