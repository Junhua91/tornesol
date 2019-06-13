package com.junhua.rpc.controller;

import com.junhua.rpc.demo.api.AlbumModel;
import com.junhua.rpc.demo.api.IProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DRpcController {


    @Autowired
    private IProvider provider;

    @RequestMapping("/test")
    public String hello() {
        AlbumModel album = provider.queryAlbum(123L);
        return "hello";
    }
}
