package com.junhua.tornesol.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BService {

    @Autowired
    private AService aService;

    public String hi() {
        return aService.hi() + " to B";
    }
}
