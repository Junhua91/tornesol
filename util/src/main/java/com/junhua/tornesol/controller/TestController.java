package com.junhua.tornesol.controller;


import com.junhua.tornesol.service.BService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Autowired
    private BService bService;

    @RequestMapping("/testb")
    public String hi() {
        return bService.hi();
    }
}
