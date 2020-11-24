package com.lwf.controller;

import com.lwf.mappers.impl.UserMapperImpl;
import com.lwf.pojo.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author lwf
 * @title: UserServlet
 * @projectName 11_20fremark
 * @description: TODO
 * @date 2020/11/2021:00
 */
@WebServlet("/users")
public class UserServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("utf-8");
        List<User> list= UserMapperImpl.all();
        req.setAttribute("list", list);
        req.getRequestDispatcher("userTable.ftl").forward(req, resp);
    }
}
