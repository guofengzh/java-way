package avic.proxy.delegate;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class ProxyFactory {
    public static Subject newInstance(Object ob) {
        InvocationHandler handler = new ProxyHandler(ob);
        Class<?>[] interfaces = ob.getClass().getInterfaces() ;  // new Class<?>[] { Subject.class } ;
        ClassLoader classLoader = ob.getClass().getClassLoader() ;
        // ����ʵ��interfaces��(��)�࣬Ȼ��ʵ�������࣬ͬʱҪָ��һ��Handler��Hanlder��ɽӿڷ�����ʵ��
        // ��Subject�ϵĽӿڷ����ĵ��ö�̬�󶨵����ӣ���ķ����ĵ��ã��˵���ת�����InvocationHandler.invoke����ɷ�����ʵ��
        // ProxyHandler��invoke()���˵���ת����RealSubject�еķ���
        return (Subject)Proxy.newProxyInstance(classLoader, interfaces, handler);
    }
}