package beanlifecycle;

import beanlifecycle.service.TestService;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
    public static void main(String[] args) {
        AbstractApplicationContext context = new ClassPathXmlApplicationContext("spring-context.xml");
        TestService ts = (TestService) context.getBean("testService");
    }
}
