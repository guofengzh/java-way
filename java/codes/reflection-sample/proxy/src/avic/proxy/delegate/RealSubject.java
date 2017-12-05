package avic.proxy.delegate;

public class RealSubject implements Subject {
    @Override
    public void someAction(String data) {
        System.out.println(data);
    }
    @Override
    public int otherAction(int x) {
        return x*10;
    }
}