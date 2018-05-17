package wyhlearn.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wyhlearn.annotation.UpmExceptionAdapter;

@Service
public class AnnotationService {
    @UpmExceptionAdapter
    public void printSomething() {
        System.out.println("printSomething");
    }
}
