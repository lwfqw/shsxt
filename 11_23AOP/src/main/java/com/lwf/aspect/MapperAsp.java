package com.lwf.aspect;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
/**
 * @author lwf
 * @title: MapperAsp
 * @projectName 11_23AOP
 * @description: dao层切面
 * @date 2020/11/2317:02
 */
@Aspect
@Component
public class MapperAsp {
    @Before("select()")
    public void before(){
        System.out.println("before");
    }
    @Pointcut("execution (* com.lwf.mapper.*.*(..) )")
    public void select(){
        System.out.println("point");
    }
    @After("select()")
    public void after(){
        System.out.println("after");
    }
    @AfterReturning(pointcut = "select()",returning = "msg")//切入点；返回值，并将返回值注入参数
    public void finish(Object msg){
        System.out.println("After return");
        System.out.println(msg.toString());
    }
    @AfterThrowing(pointcut = "select()",throwing = "e")
    public void err(Exception e){
        System.out.println("error");
        System.out.println(e.getMessage());
    }
}
