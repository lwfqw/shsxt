package org.example.Servlet;

import com.alibaba.fastjson.JSONArray;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

/**
 * @author lwf
 * @title: Login
 * @projectName TestCommutiteVersion
 * @description: TODO
 * @date 2020/10/2120:43
 */
@WebServlet(value = "/login")
public class Login extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String user=req.getParameter("name");
        String pwd=req.getParameter("pwd");
        HashMap<String,String> map=new HashMap<>();
        map.put("user",user);
        map.put("pwd",pwd);
        System.out.println(map);
        resp.setCharacterEncoding("utf-8");
        PrintWriter writer = resp.getWriter();
        writer.write(JSONArray.toJSONString(map));
        writer.flush();
        writer.close();
    }
}
