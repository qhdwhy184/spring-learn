package beanlifecycle.service;

import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class TestService {
    @PostConstruct
    private void testPostConstruct(){
        System.out.println("TestService.testPostConstruct");
    }
}
