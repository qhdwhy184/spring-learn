package beanlifecycle.processor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

@Component
public class TestPostProcessorFirst implements BeanPostProcessor, Ordered{
    public Object postProcessBeforeInitialization(Object o, String s) throws BeansException {
        System.out.println("First.ProcessBeforeInitialization: " + s);
        return o;
    }

    public Object postProcessAfterInitialization(Object o, String s) throws BeansException {
        System.out.println("First.ProcessAfterInitialization: " + s);
        return o;
    }

    public int getOrder() {
        return 3;
    }
}
