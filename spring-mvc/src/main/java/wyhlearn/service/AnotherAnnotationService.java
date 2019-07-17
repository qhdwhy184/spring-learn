package wyhlearn.service;

import org.springframework.stereotype.Service;
import wyhlearn.annotation.TestExceptionAnnotation;

@Service
public class AnotherAnnotationService {
    @TestExceptionAnnotation
    public void publicImHere() {
        System.out.println("publicImHere - execute");
    }
}
