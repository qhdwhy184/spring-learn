package BeanLifecycle.processor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

@Component
public class TestPostProcessorSecond implements BeanPostProcessor, Ordered{
    public Object postProcessBeforeInitialization(Object o, String s) throws BeansException {
        System.out.println("Second.ProcessBeforeInitialization: " + s);
        return o;
    }

    public Object postProcessAfterInitialization(Object o, String s) throws BeansException {
        System.out.println("Second.ProcessAfterInitialization: " + s);
        return o;
    }

    public int getOrder() {
        return 2;
    }
}
