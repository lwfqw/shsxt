package com.lwf.controller;

import com.lwf.ServiceTest;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author lwf
 * @title: FistServlet
 * @projectName 11_19Modous
 * @description: TODO
 * @date 2020/11/1915:17
 */
@WebServlet("/first")
public class FistServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter writer = resp.getWriter();
        writer.write(new ServiceTest().random());
        writer.flush();
        writer.close();
    }
}
