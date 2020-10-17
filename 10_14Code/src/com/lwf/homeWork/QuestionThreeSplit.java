package com.lwf.homeWork;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author lwf
 * @title: QuestionThreeSplit
 * @projectName 10_14Code
 * @description: 3、统计该段文本中每个单词出现的次数 【提示：将单词作为key， 次数作为value进行存储】
 *
 * “You can't cross the same river twice , the popular saying goes . This wisdom reminds us that everything changes  expecting to relive your bygone days of success in the same way is unrealistic . But , apparently ,  this doesn't apply to music . Over the last decade or so , for one reason or another , a number of high-profile bands have decided to stop resting on their laurels and have reunited . But why”
 *
 * 最后利用循环打印出每个单词以及其出现的次数
 *
 * String[] words = str.split(" ")
 * @date 2020/10/1410:31
 */
public class QuestionThreeSplit {
    public static HashMap<String,Integer> wordCaculate(String word){
        String[] words = word.split("\\s+");
        //转小写
        for(int i=0;i<words.length;i++){
            words[i]=words[i].toLowerCase().trim();
        }
        //存在value加1，不存在加入<单词，1>
        HashMap<String,Integer> map=new HashMap<>();
        for(String s:words){
            if(map.containsKey(s)){
                map.replace(s, map.get(s), map.get(s)+1);
            }else {
                map.put(s, 1);
            }
        }
        Set<Map.Entry<String, Integer>> entries =map.entrySet();
        for(Map.Entry entry:entries){
            System.out.println(entry.getKey()+"出现次数："+entry.getValue());
        }
        return map;
    }

    public static void main(String[] args) {
         String words="You can't cross the same river twice , the popular saying goes . This wisdom reminds us that everything changes  expecting to relive your bygone days of success in the same way is unrealistic . But , apparently ,  this doesn't apply to music . Over the last decade or so , for one reason or another , a number of high-profile bands have decided to stop resting on their laurels and have reunited . But why";
         wordCaculate(words);
    }
}
