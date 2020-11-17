package com.lwf.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author lwf
 * @title: Login
 * @projectName 11_16ServletOne
 * @description: TODO
 * @date 2020/11/1621:52
 */
@WebServlet("/login")
public class Login extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name=req.getParameter("name");
        String password=req.getParameter("password");
        System.out.println(name+":"+password);
        if(name.equals("lwf")&&password.equals("admine")){
            System.out.println("success");
            req.getRequestDispatcher("success.jsp").forward(req, resp);
        }
        else {
            System.out.println("fail");
            req.setAttribute("msg", "用户名或密码错误");
            req.getRequestDispatcher("index.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
