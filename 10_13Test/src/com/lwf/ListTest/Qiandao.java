package com.lwf.ListTest;

import java.util.HashSet;
import java.util.Set;

/**
 * @author lwf
 * @title: Qiandao
 * @projectName 10_13Test
 * @description: TODO
 * @date 2020/10/1317:39
 */
public class Qiandao {
    private Set<String> yaoQing;//邀请名单
    private Set<String> arrive;//邀请来了
    private Set<String> noArrive;//邀请没来
    private Set<String> noYaoArr;//不请自来

    public static void main(String[] args) {
        Qiandao qiandao=new Qiandao();
        qiandao.qianDao("马化腾");
        qiandao.qianDao("马云");
        qiandao.qianDao("刘强东");
        qiandao.getYaoQingNoArrive();
        System.out.println("邀请名单");
        System.out.println(qiandao.getYaoQing());
        System.out.println("邀请已来");
        System.out.println(qiandao.getArrive());
        System.out.println("邀请没来");
        System.out.println(qiandao.getNoArrive());
        System.out.println("不请自来,下次邀请");
        System.out.println(qiandao.getNoYaoArr());
    }
    public Qiandao(){
        yaoQing=new HashSet<>();
        yaoQing.add("马保国");
        yaoQing.add("马云");
        yaoQing.add("王健林");
        yaoQing.add("马化腾");
        arrive=new HashSet<>();
        noArrive=new HashSet<>();
        noYaoArr=new HashSet<>();
    }

    /**
     * 签到
     * @param 签到人名
     */
    public void qianDao(String s){
        if(yaoQing.contains(s)){
            arrive.add(s);
        }else {
            noYaoArr.add(s);
        }
    }

    /**
     * 生成请了没来名单
     */
    public void getYaoQingNoArrive(){
        for(String s:yaoQing){
            if(!arrive.contains(s))
                noArrive.add(s);
        }
    }
    public Set<String> getYaoQing() {
        return yaoQing;
    }

    public void setYaoQing(Set<String> yaoQing) {
        this.yaoQing = yaoQing;
    }

    public Set<String> getArrive() {
        return arrive;
    }

    public void setArrive(Set<String> arrive) {
        this.arrive = arrive;
    }

    public Set<String> getNoArrive() {
        return noArrive;
    }

    public void setNoArrive(Set<String> noArrive) {
        this.noArrive = noArrive;
    }

    public Set<String> getNoYaoArr() {
        return noYaoArr;
    }

    public void setNoYaoArr(Set<String> noYaoArr) {
        this.noYaoArr = noYaoArr;
    }
}
