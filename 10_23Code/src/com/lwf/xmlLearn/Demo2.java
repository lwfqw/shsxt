package com.lwf.xmlLearn;

import org.dom4j.*;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Iterator;

/**
 * @author lwf
 * @title: Demo2
 * @projectName 10_23Code
 * @description: TODO
 * @date 2020/10/2314:30
 */
public class Demo2 {
    public static void main(String[] args) throws IOException, DocumentException {
        print(getDoc("resources/Panda.xml"));
        write(getDoc("resources/Panda.xml"),"copy.xml");
        change(getDoc("resources/Panda.xml"),"resources/Panda.xml");
    }
    public static void change(Document document,String path) throws IOException, DocumentException {
        Element root=document.getRootElement();
        Element element = root.addElement("竹林萌主");
        element.addAttribute("属性", "卖萌");
        element.addElement("name").setText("熊哥");
        element.addElement("city").setText("成都");
        //element.addEntity("lwf","tc");

        write(document, path);
    }

    public static void print(Document doc){
        Element root=doc.getRootElement();
        Iterator iterator = root.elementIterator();
        while (iterator.hasNext()){
            Element next = (Element) iterator.next();
            System.out.println(next.element("name").getData());
            System.out.println(next.element("city").getData());
        }

    }

    public static void write(Document doc,String path) throws IOException {
        XMLWriter xmlWriter=new XMLWriter(new FileWriter(new File(path)),OutputFormat.createPrettyPrint());
        xmlWriter.write(doc);
        xmlWriter.flush();
        xmlWriter.close();
    }
    public static Document getDoc(String path) throws MalformedURLException, DocumentException {
        SAXReader saxReader=new SAXReader();
        return saxReader.read(new File(path));
    }
}
