package beanlifecycle.service;

import org.springframework.context.Lifecycle;
import org.springframework.context.SmartLifecycle;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class LifecycleImpl implements SmartLifecycle{
    @PostConstruct
    private void postConstruct(){
        System.out.println("LifecycleImpl.postConstruct");
    }

    public LifecycleImpl() {
        System.out.println("LifecycleImpl class instantiated..");
    }

    @Override
    public boolean isAutoStartup() {
        System.out.println("isAutoStartup method our LifecyleImpl class called..");
        return true;
    }

    @Override
    public void stop(Runnable r) {
        System.out.println("stop(Runnable) method of our LifecycleImpl class called..");
        r.run();
    }

    @Override
    public boolean isRunning() {
        System.out.println("isRunning method of our LifecycleImpl class called..");
        return true;
    }

    @Override
    public void start() {
        System.out.println("start method of our LifecycleImpl class called..");
    }

    @Override
    public void stop() {
        System.out.println("stop method of our LifecycleImpl class called..");
    }

    @Override
    public int getPhase() {
        System.out.println("getPhase method of our LifecycleImpl class called..");
        return 1;
    }
}
