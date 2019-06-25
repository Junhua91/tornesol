package com.junhua.tornesol.service;

import org.springframework.beans.factory.annotation.Autowired;

public class BService {

    @Autowired
    private AService aService;

    public String hi() {
        return aService.hi() + " to B";
    }
}
