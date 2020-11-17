package com.lwf.servlet;

import com.alibaba.fastjson.JSONArray;
import com.lwf.pojo.User;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.channels.UnresolvedAddressException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author lwf
 * @title: Test1
 * @projectName 11_17ServletFilter
 * @description: TODO
 * @date 2020/11/1711:42
 */
@WebServlet("/test1")
public class Test1 extends HttpServlet {
    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        List<User> list=new ArrayList();
        User u1=new User("lwf", 12, "江西");
        User u2=new User("lwf1", 12, "江西");
        User u3=new User("lwf2", 12, "江西");
        list.add(u1);
        list.add(u2);
        list.add(u3);
        System.out.println(req.getServletContext().getRealPath("/"));
        String string = JSONArray.toJSONString(list);
        res.setContentType("application/json;charset=utf-8");
        PrintWriter writer = res.getWriter();
        System.out.println("HAHAHAAHAHA");
        writer.write(string);
        writer.flush();
        writer.close();
    }
}
