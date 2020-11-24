package DongPoxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author lwf
 * @title: CglibPoxy
 * @projectName 11_23AOP
 * @description:  cglib代理:生成子类
 * @date 2020/11/2316:38
 */
public class CglibPoxy implements MethodInterceptor {
    public static void main(String[] args) {
        CglibPoxy cglibPoxy = new CglibPoxy(new Psl());
        Psl poxy = (Psl) cglibPoxy.poxy();
        poxy.done();
        poxy.done();
    }
    private Object bePoxy;
    public CglibPoxy(Object bePoxy){
        this.bePoxy=bePoxy;
    }
    public  Object poxy(){
        Enhancer enhancer=new Enhancer();
        enhancer.setSuperclass(bePoxy.getClass());
        enhancer.setCallback(this);
        return enhancer.create();
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("cglib代理");
        //代理对象方法
        methodProxy.invoke(bePoxy,objects);
        //执行后
        System.out.println("方法执行完");
        return null;
    }
}
