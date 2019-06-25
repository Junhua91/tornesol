package com.junhua.springboot.redis;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/redis")
public class RedisController {

    @Autowired
    private RedisService redisService;

    @RequestMapping("/set")
    public void setValue(String key, String value) {
        redisService.set(key, value);
    }

}
