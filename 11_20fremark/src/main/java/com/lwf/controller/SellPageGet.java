package com.lwf.controller;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import javax.servlet.Filter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * @author lwf
 * @title: SellPageGet
 * @projectName 11_20fremark
 * @description: TODO
 * @date 2020/11/2020:12
 */
@WebServlet("/sell")
public class SellPageGet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Configuration configuration=new Configuration();
        configuration.setServletContextForTemplateLoading(getServletContext(), "/template");
        configuration.setDefaultEncoding("utf-8");
        Template template=configuration.getTemplate("taobao.ftl");
        Map<String,Object> map=new HashMap<>();
        map.put("title", "杞里香枸杞子宁夏特级500g正宗免洗大颗粒纪构杞茶男肾红苟杞黑干");
        map.put("price", 99);
        map.put("sell", 888);
        map.put("city", "杭州");
        map.put("content","年到中年不得已，保温杯里泡枸杞。");
        map.put("shenming", "产品参数：\n" +
                "\n" +
                "生产许可证编号：SC11464010500015产品标准号：GB/T18672厂名：宁夏果果老爹食品有限公司厂址：宁夏银川市西夏区平吉堡奶牛场粮油加工厂院内厂家联系方式：400-870-0951配料表：宁夏枸杞储藏方法：请置于阴凉干燥处保质期：365 天食品添加剂：无品牌: 杞里香系列: 五星枸杞规格: 250g*2产地: 中国大陆省份: 宁夏回族自治区城市: 银川市净含量: 500g包装方式: 包装特产品类: 宁夏枸杞适用对象: 全部适用滋补品大小: 特级370粒/50g成分原料: 枸杞子 ");
        map.put("url", "https://detail.tmall.com/item.htm?spm=a220o.1000855.0.0.3f5a4bd6uHewB7&id=6956495372");
        String fileName=System.currentTimeMillis()+".html";
        FileWriter writer=new FileWriter(new File(getServletContext().getRealPath("/")+"/staticPage/"+fileName));
        resp.setContentType("text/html;charset=utf-8");
        try {
            template.process(map, writer);
            resp.sendRedirect("staticPage/"+fileName);
        } catch (TemplateException e) {
            PrintWriter writer1 = resp.getWriter();
            writer1.write("生成失败");
            writer1.flush();
            writer1.close();
        }finally {
            writer.close();
        }
    }
}
