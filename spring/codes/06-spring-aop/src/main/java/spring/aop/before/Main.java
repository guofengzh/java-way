package spring.aop.before;

import org.springframework.context.ApplicationContext;  
import org.springframework.context.support.ClassPathXmlApplicationContext;  

public class Main {
    public static void main(String[] args){  
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-aop-before-config.xml");  
        Operation e = (Operation) context.getBean("opBean");  
        System.out.println("calling msg...");  
        e.msg();  
        System.out.println("calling m...");  
        e.m();  
        System.out.println("calling k...");  
        e.k();  
    }  
}
