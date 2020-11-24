package com.lwf.MySpringFrework.context;

import java.io.ObjectInputStream;
import java.lang.reflect.InvocationTargetException;

/**
 * @author lwf
 * @title: BeanFactory
 * @projectName 11_21SpringIOC
 * @description: bean工厂
 * @date 2020/11/2110:59
 */
public interface BeanFactory {
    public Object getBean(String id) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchFieldException, NoSuchMethodException, InvocationTargetException, Exception;
}
