package com.lwf.interceper;

import com.lwf.pojo.Test;
import lombok.extern.log4j.Log4j;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author lwf
 * @title: RootHanderIntercepter
 * @projectName 11_24springMVC
 * @description: TODO
 * @date 2020/11/2515:02
 */
public class RootHanderIntercepter extends HandlerInterceptorAdapter {
    /*
    执行控制器（controller）前执行，类似过滤器，返回ture表允许通过，false拦截
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        String name=request.getParameter("name");
//        if (name.equals("lwf")){
//            System.out.println(name+"通过，去执行控制器");
//            return true;
//        }
//        System.out.println("拦截"+name);
//        return false;
        System.out.println("执行前");
        return true;
    }
     /*
     执行完控制器，再回到中央控制器途中执行
      */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("执行完控制器");
    }
      /*
      执行完视图解析器在回到中央控制器执行
       */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("视图完成");
    }

}
