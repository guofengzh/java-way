package avic.proxy;

import avic.proxy.delegate.ProxyFactory;
import avic.proxy.delegate.RealSubject;
import avic.proxy.delegate.Subject;

public class Main
{
    public static void main(String[] args) {
        Subject proxy = ProxyFactory.newInstance(new RealSubject());
        Client client = new Client( proxy ) ;
        client.doSomeAction();
    }
}
