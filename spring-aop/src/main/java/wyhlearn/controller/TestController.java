package wyhlearn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import wyhlearn.service.AnnotationService;
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
}
