package com.lwf;

import com.lwf.pojo.Panda;

import java.util.List;
import java.util.Random;

/**
 * @author lwf
 * @title: ServiceTest
 * @projectName 11_19Modous
 * @description: TODO
 * @date 2020/11/1915:15
 */
public class ServiceTest {
    public String random(){
        Random random=new Random();
        String res="";
        for(int i=0;i<6;i++){
            res+=random.nextInt(10);
        }
        return res;
    }
    public List<Panda> listPanda(){
       return new FirstDao().listPanda();
    }
}
