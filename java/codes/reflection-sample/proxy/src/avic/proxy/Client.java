package avic.proxy;

import avic.proxy.delegate.Subject;

public class Client {
    private Subject subject ;

    public Client(Subject subject) {
        this.subject = subject ;
    }

    public void doSomeAction() {
        subject.someAction("I want to execute 'doSomeAction'");
    }
}
