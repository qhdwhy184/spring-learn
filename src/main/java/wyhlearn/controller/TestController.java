package wyhlearn.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by wangyuanhui on 17/2/7.
 */
@Controller
public class TestController {
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
}
