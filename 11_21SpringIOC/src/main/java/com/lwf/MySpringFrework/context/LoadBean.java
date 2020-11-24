package com.lwf.MySpringFrework.context;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

/**
 * @author lwf
 * @title: LoadBean
 * @projectName 11_21SpringIOC
 * @description: 加载配置文件
 * @date 2020/11/2111:09
 */
public class LoadBean {
    protected static Map<String,Bean> load(String path) throws Exception {
        Map<String,Bean> res=new HashMap<>();
        Document document=null;
        try {
            InputStream resourceAsStream = LoadBean.class.getClassLoader().getResourceAsStream(path);
            String string = IOUtils.toString(resourceAsStream, "utf-8");
            document=Jsoup.parse(string);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Elements beans = document.getElementsByTag("bean");
        for(Element node:beans){
            String id=node.attr("id");
            String cls=node.attr("class");
            Map<String,Object> properties=new HashMap<>();
            for(Element attr:node.getElementsByTag("property")){
                    String pro=attr.attr("name");
                    Object value=attr.attr("value");
                    properties.put(pro, value);
                    System.out.println("属性"+pro+"--"+value);

            }
            res.put(id,new Bean(id, Class.forName(cls).newInstance(),cls, properties));

        }
        valueGive(res);
        return res;
    }
    //装配属性
    public static void valueGive(Map<String,Bean> context)throws Exception{
        for (String key:context.keySet()){
            Bean bean=context.get(key);
            if(bean.getProperties().size()!=0){
                Object o=bean.getObject();
                Class c=Class.forName(bean.getCla());
               for(Field field:c.getFields()){
                   Object o1 = bean.getProperties().get(field.getName());
                   Method method = c.getMethod("set" + field.getName().substring(0, 1).toUpperCase() + field.getName().substring(1), Object.class);
                   method.invoke(o,o1);
               }
            }
        }
    }
}
