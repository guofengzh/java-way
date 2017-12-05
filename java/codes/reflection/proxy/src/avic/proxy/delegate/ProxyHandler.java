package avic.proxy.delegate;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class ProxyHandler implements InvocationHandler {
    private Object realSubject;
    private TxUtil tx = new TxUtil() ;
    
    public ProxyHandler(Object obj) {
        this.realSubject = obj;
    }
    public Object invoke(Object proxy, Method m, Object[] args) throws Throwable {
        Object result = null;
        try{
        	tx.turnOn("Executing '" + m.getName() + "'");
            result = m.invoke(realSubject, args);
        	tx.turnOff("Executing '" + m.getName() + "'");
        } catch (Exception e) {
            System.out.println("Executing... " + m.getName() + " ...failed");
            throw e;
        }
        return result;
    }
}