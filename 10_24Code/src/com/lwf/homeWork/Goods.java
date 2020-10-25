package com.lwf.homeWork;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lwf
 * @title: Goods
 * @projectName 10_24Code
 * @description: TODO
 * @date 2020/10/2515:48
 */
public class Goods {
    public static void main(String[] args) {
        List<Goods> list=new ArrayList<>();
        list.add(new Choes(12, "adidas", Type.choes));
        list.add(new Phone(43, "huawei", Type.phone));
        list.add(new Phone(66, "chenguang", Type.pen));
        list.add(new Choes(19, "nike", Type.choes));
        list.add(new Choes(18, "nike", Type.choes));
        list.add(new Phone(49, "xiaomi", Type.phone));
        list.add(new Choes(34, "huili", Type.choes));
        list.add(new Phone(36, "meizu", Type.phone));
        list.add(new Choes(7, "hailan", Type.choes));
        //鞋子销量排行
        list.stream().filter(g->g.getType()==Type.choes).sorted((o,a)->{
            return Integer.compare(o.getSell(), a.getSell());
        }).forEach(System.out::println);
        //手机产品
        list.stream().filter(g->g.getType()==Type.phone).forEach(System.out::println);
        //几种鞋子
        System.out.println(list.stream().filter(g -> g.getType() == Type.choes).map(g -> g.getName()).distinct().count());
    }
    private int sell;
    private String name;
    private Type type;

    public Goods(int sell, String name, Type type) {
        this.sell = sell;
        this.name = name;
        this.type = type;
    }

    public int getSell() {
        return sell;
    }

    public void setSell(int sell) {
        this.sell = sell;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object obj) {
        Goods goods = (Goods)obj;
        return this.getName().equals(goods.getName());
    }

    @Override
    public String toString() {
        return "Goods{" +
                "sell=" + sell +
                ", name='" + name + '\'' +
                ", type=" + type +
                '}';
    }
}
enum Type{
    phone,choes,pen;
}
class Phone extends Goods{
    public Phone(int sell, String name, Type type) {
        super(sell, name, type);
    }
}
class Choes extends Goods{
    public Choes(int sell, String name, Type type) {
        super(sell, name, type);
    }
}
class Pen extends Goods{
    public Pen(int sell, String name, Type type) {
        super(sell, name, type);
    }
}