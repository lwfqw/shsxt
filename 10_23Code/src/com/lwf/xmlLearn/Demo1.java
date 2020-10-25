package com.lwf.xmlLearn;

import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.jsoup.Jsoup;
import org.jsoup.select.Elements;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Iterator;
import java.util.ListIterator;

/**
 * @author lwf
 * @title: Demo1
 * @projectName 10_23Code
 * @description: TODO
 * @date 2020/10/239:33
 */
public class Demo1 {
    public static void main(String[] args) throws IOException, DocumentException, SAXException, ParserConfigurationException {
//      dom4J(new File("resources/Panda.xml"));
////        System.out.println("--------------------");
////      dom(new File("resources/Panda.xml"));
        readInJsoup(new File("resources/Panda.xml"));
    }

    /**
     * dom解析
     * @param file
     *
     * @throws ParserConfigurationException
     * @throws IOException
     * @throws SAXException
     */
    public static void dom(File file) throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();
        DocumentBuilder builder=factory.newDocumentBuilder();
        Document parse = builder.parse(file);
        NodeList list=parse.getElementsByTagName("panda");
        for(int i=0;i<list.getLength();i++){
            System.out.println(list.item(i).getTextContent());
        }
    }

    /**
     * dom4j解析
     * @param file
     * @throws DocumentException
     * @throws MalformedURLException
     */
    public static void dom4J(File file) throws DocumentException, MalformedURLException {
        SAXReader reader=new SAXReader();
        org.dom4j.Document document=reader.read(file);
        Element root=document.getRootElement();
        Iterator iterator = root.elementIterator();
        while (iterator.hasNext()){
            Element element= (Element) iterator.next();
            Iterator iterator1 = element.elementIterator();
            while (iterator1.hasNext()){
                Element next = (Element) iterator1.next();
                System.out.println(next.getData());
                next.setText("雪宝");
                System.out.println(next.getData());
            }
        }

    }

    /**
     * jsoup解析
     * @param file
     * @throws IOException
     */
    public static void readInJsoup(File file) throws IOException {
        org.jsoup.nodes.Document parse = Jsoup.parse(file, "utf-8");
        Elements pandas = parse.getElementsByTag("Pandas");
        ListIterator<org.jsoup.nodes.Element> elementListIterator = pandas.listIterator();
        while (elementListIterator.hasNext()){
            org.jsoup.nodes.Element child = elementListIterator.next();
            System.out.println(child.getElementsByTag("name").text());
            System.out.println(child.getElementsByTag("city").text());
            System.out.println(child.getElementsByTag("age").text());
        }
    }
}
