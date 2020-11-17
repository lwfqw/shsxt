package com.lwf.controller;

import com.google.gson.Gson;
import com.lwf.POJO.Panda;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author lwf
 * @title: JSONServlet
 * @projectName 11_16ServletOne
 * @description: TODO
 * @date 2020/11/1614:00
 */
@WebServlet(urlPatterns = {"/json","/js"})
public class JSONServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Panda p1=new Panda("兄约会",1);
        Panda p2=new Panda("兄约会1",1);
        Panda p3=new Panda("兄约会2",1);
        List<Panda> list=new ArrayList<>();
        list.add(p1);
        list.add(p2);
        list.add(p3);
        resp.setHeader("Access-Control-Allow-Origin", "*"); //  这里最好明确的写允许的域名
        resp.setContentType("application/json;charset=utf-8");
        resp.getWriter().write(new Gson().toJson(list));
    }
}
