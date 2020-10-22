package com.lwf.XML;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.*;
import java.util.Stack;

/**
 * @author lwf
 * @title: ReadXml
 * @projectName 10_21Code
 * @description: TODO
 * @date 2020/10/2119:23
 */
public class ReadXml {
    //jsoup解析
    public static void readInJsoup(String src){
        //计时
        long now=System.currentTimeMillis();
        //io读取需要jsoup解析
        InputStream in = ReadXml.class.getClassLoader().getResourceAsStream(src);
        BufferedReader read= null;
        try {
            read = new BufferedReader(new InputStreamReader(in,"utf-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        int len=-1;
        char[] buf=new char[1024];
        String str="";
        while (true){
            try {
                if (!((len=read.read(buf))!=-1)) break;
            } catch (IOException e) {
                e.printStackTrace();
            }
            str+=new String(buf,0,len);
        }
        Document document= Jsoup.parse(str);
        System.out.println(document.getElementsByTag("web-app"));
        for(Element e:document.getElementsByTag("web-app")){
            //获取display和Welcomelist
            System.out.println(e.getElementsByTag("display-name").text());
            System.out.println(e.getElementsByTag("welcome-file").text());
            System.out.println(e.text());
        }
        System.out.println("Jsoup耗时"+(System.currentTimeMillis()-now));
    }

    //Sax解析 不是说Sax很快嘛，怎么比Jsoup慢那么多
    public static void readInSax(String src){
        long now=System.currentTimeMillis();
        InputStream input=ReadXml.class.getClassLoader().getResourceAsStream(src);
        SAXParserFactory spf = SAXParserFactory.newInstance();
        SAXParser saxParser = null;
        try {
            saxParser = spf.newSAXParser();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
        try {
            saxParser.parse(input, new DefaultHandler(){
                Stack<String> stack=new Stack<>();
                @Override
                public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
                    //System.out.println("firstNode:"+localName+","+qName);
                    if(qName.equals("welcome-file")){
                        stack.push(qName);
                    }
                }

                @Override
                public void endElement(String uri, String localName, String qName) throws SAXException {
                    if(!stack.isEmpty()){
                        if(qName.equals(stack.peek())){
                            stack.clear();
                        }else {
                            System.out.println("LastNode:"+localName+","+qName);
                            stack.push(qName);
                        }
                    }
                    //System.out.println("LastNode:"+localName+","+qName);
                }

                @Override
                public void characters(char[] ch, int start, int length) throws SAXException {
                    //System.out.println(new String(ch,start,length));
                    if(!stack.isEmpty()){
                        System.out.println(new String(ch,start,length));
                    }
                }

                @Override
                public void error(SAXParseException e) throws SAXException {
                    System.out.println("错误："+e.getMessage());
                }
            });
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("SAX耗时"+(System.currentTimeMillis()-now));
    }
    public static void main(String[] args) throws IOException {
        readInJsoup("web.xml");
        readInSax("web.xml");
    }
}
