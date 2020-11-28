package com.lwf.MyException;

/**
 * @author lwf
 * @title: TransforException
 * @projectName 11_26SSM
 * @description: 自定义转账失败异常
 * @date 2020/11/2619:45
 */
public class TransforException extends RuntimeException{
    public TransforException() {
        super("转账失败");
    }
}
