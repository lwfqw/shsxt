package com.lwf.servlet;

import com.alibaba.fastjson.JSON;
import com.lwf.pojo.Message;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author lwf
 * @title: LoginServlet
 * @projectName 11_17ServletFilter
 * @description: 登录ajax
 * @date 2020/11/1816:11
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private static final Logger logger=Logger.getLogger(LoginServlet.class);
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json;charset=utf-8");
        String name=req.getParameter("name");
        String password=req.getParameter("password");
        logger.info("登录用户:"+name+"  ,密码："+password);
        PrintWriter writer = resp.getWriter();
        if(name.equals("lwf")&&password.equals("admine")){
            writer.write(JSON.toJSONString(new Message("200","ok","http://lwf:9999/index.jsp")));
            writer.flush();
            writer.close();
            logger.info(req.getRemoteHost()+"信息正确，跳转页面");
        }else {
            writer.write(JSON.toJSONString(new Message("500","error","#")));
            writer.flush();
            writer.close();
            logger.info(req.getRemoteHost()+"信息错误");
        }
    }
}
