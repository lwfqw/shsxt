package DongPoxy;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author lwf
 * @title: Test
 * @projectName 11_23AOP
 * @description: TODO
 * @date 2020/11/2314:19
 */
public class JDKProxy{
    public static void main(String[] args) {
        LaoWang psl=new Psl();
        Object poxy=poxy(psl);
        LaoWang laoWang=(LaoWang)poxy;
        laoWang.done();
        SellCar sellCar=(SellCar)poxy;
        sellCar.sell();
    }
    //jdk动态代理:基于实现接口
    public static Object poxy(Object obj){
        Object poxy= Proxy.newProxyInstance(JDKProxy.class.getClassLoader(), obj.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                if(method.getName().equals("done")){
                    method.invoke(obj,args);
                    System.out.println("其实他同桌干的");
                }else if(method.getName().equals("sell")){
                    method.invoke(obj, args);
                    System.out.println("他同桌笑了");
                }else {
                    System.out.println("null");
                }
                return null;
            }
        });
        return poxy;
    }

}
