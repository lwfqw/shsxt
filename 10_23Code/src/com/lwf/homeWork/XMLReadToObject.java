package com.lwf.homeWork;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author lwf
 * @title: XMLReadToObject
 * @projectName 10_23Code
 * @description: 读取  panda.xml数据到Panda类
 * @date 2020/10/2319:24
 */
public class XMLReadToObject {
    public static void main(String[] args) throws InvocationTargetException, MalformedURLException, IllegalAccessException, DocumentException, NoSuchMethodException {
        System.out.println(getObjectFromXml("resources/Panda.xml"));
    }
    public static List<Panda> getObjectFromXml(String xml) throws MalformedURLException, DocumentException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        List<Panda> list=new ArrayList<>();
        SAXReader reader=new SAXReader();
        Document read = reader.read(new File(xml));
        Element root=read.getRootElement();
        for (Object element: root.elements("panda")){
            Element node=(Element)element;
            Panda panda=new Panda();
            panda.setName((String) node.element("name").getData());
            panda.setCity(node.element("city").getText());
            panda.setAge(Integer.valueOf(node.element("age").getText()));
            list.add(panda);
        }
        return list;
    }
}
class Panda{
    private String name;
    private String city;
    private int age;

    public Panda() {
    }

    public Panda(String name, String city, int age) {
        this.name = name;
        this.city = city;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getAge(Integer city) {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Panda{" +
                "name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", age=" + age +
                '}';
    }
}