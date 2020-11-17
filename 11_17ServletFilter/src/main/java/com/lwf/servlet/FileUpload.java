package com.lwf.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;

/**
 * @author lwf
 * @title: FileUpload
 * @projectName 11_17ServletFilter
 * @description: 上传文件
 * @date 2020/11/1715:37
 */
@WebServlet("/upload")
@MultipartConfig//必须加
public class FileUpload extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        Part file = req.getPart("file");
        //路径可以为项目路径  getServletContext().getRealPath("/")+fileName
        file.write("C:\\Users\\lwf\\IdeaProjects\\11_17ServletFilter\\src\\main\\webapp\\"+file.getSubmittedFileName());
    }
}
