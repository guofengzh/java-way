package avic.proxy.delegate;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class ProxyFactory {
    public static Subject newInstance(Object ob) {
        InvocationHandler handler = new ProxyHandler(ob);
        Class<?>[] interfaces = ob.getClass().getInterfaces() ;  // new Class<?>[] { Subject.class } ;
        ClassLoader classLoader = ob.getClass().getClassLoader() ;
        // 生成实现interfaces的(子)类，然后实例化此类，同时要指定一个Handler，Hanlder完成接口方法的实现
        // 对Subject上的接口方法的调用动态绑定到（子）类的方法的调用，此调用转向调用InvocationHandler.invoke来完成方法的实现
        // ProxyHandler的invoke()将此调用转交给RealSubject中的方法
        return (Subject)Proxy.newProxyInstance(classLoader, interfaces, handler);
    }
}