package com.lwf.servlet;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

/**
 * @author lwf
 * @title: FileDownLoad
 * @projectName 11_17ServletFilter
 * @description: 下载文件
 * @date 2020/11/1715:06
 */
@WebServlet("/download")
public class FileDownLoad extends HttpServlet {
    @Override
    public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String path = getServletContext().getRealPath("/");
        String name=req.getParameter("fileName");
        File file=new File(path+name);
        System.out.println(file.getAbsolutePath());
        if(file.exists()&&file.isFile()){
            BufferedInputStream stream=new BufferedInputStream(new FileInputStream(file));
            res.setContentType("application/x-msdownload");
            res.setHeader("Content-Disposition", "attachment;filename=" +
                    name);
            ServletOutputStream outputStream = res.getOutputStream();
            byte[] buf=new byte[1024*5];
            int len=-1;
            while ((len=stream.read(buf))!=-1){
                outputStream.write(buf,0,len);
            }
            outputStream.close();
            stream.close();
        }else {
            res.setContentType("text/html;charset=utf-8");
            PrintWriter writer = res.getWriter();
            writer.write("失败");
            writer.close();
        }
    }
}
