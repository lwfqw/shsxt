package com.lwf;

import com.lwf.pojo.Panda;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lwf
 * @title: FirstDao
 * @projectName 11_19Modous
 * @description: TODO
 * @date 2020/11/1915:35
 */
public class FirstDao {
    public List<Panda> listPanda(){
        List<Panda> list=new ArrayList<>();
        list.add(new Panda("熊猫1",2,"四川"));
        list.add(new Panda("熊猫1",2,"四川"));
        list.add(new Panda("熊猫1",2,"四川"));
        list.add(new Panda("熊猫1",2,"四川"));
        list.add(new Panda("熊猫1",2,"四川"));
        list.add(new Panda("熊猫1",2,"四川"));
        return list;
    }
}
