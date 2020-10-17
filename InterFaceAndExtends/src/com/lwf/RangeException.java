package com.lwf;

/**
 * Created by IntelliJ IDEA.
 * User: lwf-pc
 * Auther: 罗卫飞
 * Date: 2020/9/29
 */
public class RangeException {
    //定义异常类
    static class RangeOutOfInddex extends Exception{
        public RangeOutOfInddex(){}
        public RangeOutOfInddex(String msg){
            super(msg);
        }
    }
    static class ArrayInput{
        public int []arr=new int[5];
        public void input(int index,int value) throws RangeOutOfInddex {
            if(index>4||index<0){
                throw new RangeOutOfInddex("数组越界");
            }
            arr[index]=value;
        }
    }

    public static void main(String[] args) {
        ArrayInput arrayInput=new ArrayInput();
        try {
            arrayInput.input(5,6);
        } catch (RangeOutOfInddex rangeOutOfInddex) {
            System.out.println(rangeOutOfInddex.getMessage());
            rangeOutOfInddex.printStackTrace();
        }
    }
}
