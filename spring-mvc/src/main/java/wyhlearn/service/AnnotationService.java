package wyhlearn.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wyhlearn.annotation.TestExceptionAnnotation;

@Service
public class AnnotationService {
    @Autowired
    private AnotherAnnotationService anotherAnnotationService;

    @TestExceptionAnnotation
    public void printSomething(String firstName, String secondName) {
        System.out.println("printSomething - execute, firstName:" + firstName + ", secondName:" + secondName);
        publicPrintSomething();
        anotherAnnotationService.publicImHere();
    }

    @TestExceptionAnnotation
    private void publicPrintSomething() {
        System.out.println("publicPrintSomething - execute");
    }
}
