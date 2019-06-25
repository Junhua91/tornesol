package com.junhua.rpc.controller;

import com.junhua.rpc.init.ReferenceBean;
import com.junhua.rpc.init.ServiceBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DRpcController {



    @RequestMapping("/test")
    public String hello() {

        return "hello";
    }
}
