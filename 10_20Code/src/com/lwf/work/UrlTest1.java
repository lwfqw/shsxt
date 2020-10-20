package com.lwf.work;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * @author lwf
 * @title: UrlTest1
 * @projectName 10_20Code
 * @description: 爬菜鸟教程
 * @date 2020/10/2010:48
 */
public class UrlTest1 {
    /**
     * 得到网页
     * @param url
     * @return
     */
    public static String getP(String url){
        StringBuffer stringBuffer = new StringBuffer();
        try {
            URL url1=new URL(url);
            URLConnection connection=url1.openConnection();
            BufferedInputStream read=new BufferedInputStream(connection.getInputStream());
            int len=-1;
            byte[] buf=new byte[1024];
            while ((len=read.read(buf))!=-1){
                stringBuffer.append(new String(buf, 0, len));
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }catch (IOException r){
            r.printStackTrace();
        }
        return String.valueOf(stringBuffer);
    }

    public static void main(String[] args) throws IOException {
        System.out.println("菜鸟教程p数据");OutputStreamWriter out =null;
        BufferedReader reader = null;
        String response = "";
//        Document document = Jsoup.parse(getP("https://www.runoob.com/java/java-environment-setup.html"));
//        Elements elements=document.getElementsByTag("p");
//        for(Element element:elements){
//            System.out.println(element.text());
//        }
        URL url=new URL("http://v.juhe.cn/weather/index?format=2&cityname=上海市&key=5b159c657bee46c23f3896a077e496a8");
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestProperty("Content-Type", "json/xml");
        conn.setRequestProperty("connection", "keep-alive");
        conn.setUseCaches(false);//设置不要缓存

        conn.setDoOutput(true);
        conn.setDoInput(true);
        conn.connect();

        //读取响应
        reader = new BufferedReader(new InputStreamReader(
                conn.getInputStream()));
        String lines;
        while ((lines = reader.readLine()) != null) {
            lines = new String(lines.getBytes(), "utf-8");
            response+=lines;
        }
        reader.close();
        // 断开连接
        conn.disconnect();
        System.out.println(response);
    }
}
