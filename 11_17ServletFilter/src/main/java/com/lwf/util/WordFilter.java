package com.lwf.util;

import org.apache.log4j.Logger;
import java.io.*;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Queue;

/**
 * @author lwf
 * @title: WordFilter
 * @projectName 11_17ServletFilter
 * @description: 敏感词过滤
 * @date 2020/11/189:50
 */
public class WordFilter {
    private static final Logger loger=Logger.getLogger(WordFilter.class);
    private class Node{
        Node(Character key,HashMap<Character,Node> child){
            this.key=key;
            this.child=child;
        }
        boolean isEnd(){
            if(child.size()==0){
                return true;
            }
            return false;
        }
        Character key;
        HashMap<Character,Node> child;

        @Override
        public String toString() {
            return "key:"+key+child.toString();
        }
    }
    private Node root=new Node('#',new HashMap<Character, Node>());

    /**
     * 敏感词生成树
     * @param word
     */
    private void addWord(String word){
        Node start=root;
        for(Character c:word.toCharArray()){
            if(start.child.containsKey(c)){
                //含有该字符,start指向该字符
                loger.info("含有字符，标识下移到子节点");
                start=start.child.get(c);
            }else {
                //不含
                loger.info("不含，创建子节点，标识指向子节点");
                Node add=new Node(c, new HashMap<Character, Node>());
                start.child.put(c,add);
                start=add;
            }
        }
    }

    /**
     * 读取敏感词文件
     * @param file
     */
    public void readFilterWordFile(File file) {
        try {
            BufferedReader reader=new BufferedReader(new InputStreamReader(new FileInputStream(file)));
            String line;
            while(null!=(line=reader.readLine())){
                loger.info("读取敏感词:"+line);
                addWord(line);
            }
        } catch (FileNotFoundException e) {
            loger.error("文件未找到:"+e.getMessage());
        } catch (IOException e) {
            loger.error("读取文件错误："+e.getMessage());
        }
    }

    /**
     * 判断字符串是否包含铭感词
     * @param word
     * @return
     */
    public boolean doFilter(String word){
        Node start=root;
        Node end=root;
        for(Character c:word.toCharArray()){
          if(end.child.size()>0&&end.child.containsKey(c)){
              loger.info("匹配字母:"+c);
              end=end.child.get(c);
              if(end.isEnd()){
                  loger.info("含有敏感词:"+word);
                  return true;
              }
          }else {
              loger.info("未匹配:"+c+",后移");
              end=root;
          }
        }
        loger.info("不包含铭感词"+word);
        return false;
    }

    /**
     * 层次遍历
     */
    public void print(){
        Queue<Node> queue=new ArrayDeque<>();
        Node start=root;
        queue.add(start);
        while (!queue.isEmpty()){
            for(Node node:queue) {
                queue.remove();
                System.out.print(node.key);
                for (Character c : node.child.keySet()) {
                    queue.add(node.child.get(c));
                }
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        WordFilter filter=new WordFilter();
        filter.readFilterWordFile(new File("src/main/resources/filterWord"));
        System.out.println(filter.doFilter("北美洲美国人民"));
        System.out.println(filter.doFilter("美的国人民"));
        System.out.println(filter.doFilter("北美洲国美"));
        filter.print();
    }
}
