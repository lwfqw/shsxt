package com.lwf.MyException;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author lwf
 * @title: GlobalExceptionHandle
 * @projectName 11_27SSM
 * @description: TODO
 * @date 2020/11/2711:07
 */
@Component
public class GlobalExceptionHandle implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {
         ModelAndView view=new ModelAndView();
         if(e instanceof TransforException){
             view.addObject("msg", "转账失败");
             view.addObject("code", e.getMessage());
         }else {
             view.addObject("msg", "全局异常");
             view.addObject("code", e.getMessage());
         }
         view.setViewName("error");
         return view;
    }
}
