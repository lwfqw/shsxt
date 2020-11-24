package com.lwf.controller;

import com.google.gson.Gson;
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
 * @title: PandaServlet
 * @projectName 11_19Modous
 * @description: TODO
 * @date 2020/11/1915:40
 */
@WebServlet("/listpanda")
public class PandaServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json;charset=utf-8");
        PrintWriter writer = resp.getWriter();
        writer.write(new Gson().toJson(new ServiceTest().listPanda()));
        writer.flush();
        writer.close();
    }
}
