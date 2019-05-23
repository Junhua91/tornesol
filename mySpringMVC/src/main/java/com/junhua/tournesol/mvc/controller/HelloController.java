package com.junhua.tournesol.mvc.controller;

import com.junhua.tournesol.mvc.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @Autowired
    private HelloService helloService;

    @ResponseBody
    @RequestMapping("/hello")
    public String hello() {

        return "success";
//        return helloService.sayHello();
    }

    @RequestMapping("/suc")
    public String success() {
        return "index";
    }


}
