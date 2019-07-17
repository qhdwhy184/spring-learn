package wyhlearn.service;

import org.springframework.stereotype.Service;
import wyhlearn.annotation.TestAnnotation;

@Service
public class AnotherAnnotationService {
    @TestAnnotation
    public void publicImHere() {
        System.out.println("publicImHere - execute");
    }
}
