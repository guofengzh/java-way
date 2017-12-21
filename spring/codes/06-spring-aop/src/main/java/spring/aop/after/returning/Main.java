package spring.aop.after.returning;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args){  
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-aop-after-retruning-config.xml");  
        Operation e = (Operation) context.getBean("opBean");  
        System.out.println("calling m...");  
        System.out.println(e.m());  
        System.out.println("calling k...");  
        System.out.println(e.k());  
    }  
}
