package com.lwf.Thread;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author lwf
 * @title: How2JLearn
 * @projectName 10_17Code
 * @description: synchronized同步：锁类，代码块，方法
 *               volatile：同步变量
 *               ReentranLockt:锁代码块
 * @date 2020/10/1720:00
 */
public class How2JLearn <T>{
    /**
     * 将线程不安全的Collection接口下的实现容器改为线程安全
     * @param list
     * @return
     */
    public List<T> getSafeList(List<T> list){
        return Collections.synchronizedList(list);
    }

    public static void main(String[] args) {
        Integer[] integer = new Integer[]{1,23,34,5,6,8,3,3,4,9};
        Thread t1=new MyThread();
        Thread t2=new MyThread(new How2JLearn().getSafeList(new ArrayList(Arrays.asList(integer))));
        t1.start();
        t2.start();
    }

}
class MyThread extends Thread{
    private static List<Integer> list;
    private static volatile int num=0;//计算线程运行次数
    public MyThread() {
        super();
    }
    public MyThread(List<Integer> list){
        this.list=list;
    }
    @Override
    public void run() {
        while (!list.isEmpty()) {
            num++;
            int i=list.remove(0);
            System.out.println(this.getName()+this.getId()+"列表拿出："+i);
        }
        System.out.println(num);
    }
}