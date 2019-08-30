package com.ximalaya.webgroup.tdkservice.controller;


import com.ximalaya.mainstay.rpc.thrift.TApplicationException;
import com.ximalaya.service.content.thrift.BasicAlbum;
import com.ximalaya.webgroup.tdkservice.core.Core;
import com.ximalaya.webgroup.tdkservice.model.TestBean;
import org.apache.thrift.TException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.function.Function;

@RestController
@RequestMapping("/album")
public class HelloController {

    @Autowired
    Core core;

    private Function<Long, TestBean> helloFunction = (albumId) -> {
        String albumTitle = "";
        try {
            BasicAlbum album = core.getThrift().getAlbumService().queryBasicAlbum(albumId);
            albumTitle = album.getTitle();
        } catch (TException e) {
            e.printStackTrace();
        }

        TestBean bean = new TestBean();
        bean.setName(albumTitle);

        return bean;
    };

    @RequestMapping("/title")
    public TestBean hello(@RequestParam(name = "albumId") Long albumId) throws TApplicationException {
        return helloFunction.apply(albumId);
    }
}
