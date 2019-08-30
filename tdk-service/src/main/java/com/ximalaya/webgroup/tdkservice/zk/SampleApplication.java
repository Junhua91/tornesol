package com.ximalaya.webgroup.tdkservice.zk;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication(scanBasePackages = "com.ximalaya.webgroup.tdkservice.zk",
        exclude= {DataSourceAutoConfiguration.class})
public class SampleApplication {


    @RequestMapping(name = "helloService", method = RequestMethod.GET, path = "/hello")
    public String hello() {
        return "hello";
    }

    public static void main(String[] args) {
        SpringApplication.run(SampleApplication.class, args);
    }

}


