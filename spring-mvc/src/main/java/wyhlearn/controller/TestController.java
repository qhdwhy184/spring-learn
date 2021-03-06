package wyhlearn.controller;

import io.jaegertracing.internal.JaegerTracer;
import io.opentracing.Scope;
import io.opentracing.Tracer;
import io.opentracing.util.GlobalTracer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import wyhlearn.service.AnnotationService;
import wyhlearn.tracing.Tracing;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by wangyuanhui on 17/2/7.
 */
@Controller
public class TestController {

    @Autowired
    private AnnotationService service;
    @RequestMapping(value = "/sayJson")
    @ResponseBody
    public Map<String, String> sayJson() {
        Map<String, String> map = new HashMap<String, String>();
        map.put("hello", "world");
        return map;
    }

    @RequestMapping("/sayString")
    @ResponseBody
    public String sayString() {
        return "helloworld";
    }

    @RequestMapping("/sayJsp")
    public String sayJsp() {
        return "helloworld";
    }

    @RequestMapping("/testAnnotaion")
    public String test() {
        service.printSomething("yh", "w");
        return "helloworld";
    }

    @RequestMapping("/testot")
    public String testot() {
        try (Scope scope = GlobalTracer.get().buildSpan("testot").startActive(true)) {
            service.printSomething("23", "1");

            return "helloworld";
        }
    }
}
