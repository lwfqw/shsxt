package com.lwf.controller;

import com.lwf.pojo.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

/**
 * @author lwf
 * @title: LoginServlet
 * @projectName 11_20fremark
 * @description: TODO
 * @date 2020/11/209:29
 */
@WebServlet("/hi")
public class HiServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       req.setAttribute("data", new User(1,"lwf",16));
       req.setAttribute("data1", new User(2,"江西",28));
        req.setAttribute("date", new Date());
        req.getRequestDispatcher("hi.ftl").forward(req, resp);
    }
}
