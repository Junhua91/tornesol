package com.junhua.springboot.rabbit_boot.controller;


import com.junhua.springboot.rabbit_boot.service.Sender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Autowired
    private Sender sender;

    @RequestMapping("/send")
    public void sendMessage(String message) {
        sender.send(message);
    }
}
