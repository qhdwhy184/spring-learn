package beanlifecycle;

import beanlifecycle.service.LifecycleImpl;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
    public static void main(String[] args) {
        AbstractApplicationContext context = new ClassPathXmlApplicationContext("spring-context.xml");
        context.start();
        LifecycleImpl ts = (LifecycleImpl) context.getBean("lifecycleImpl");
        context.stop();
        context.close();
    }
}
