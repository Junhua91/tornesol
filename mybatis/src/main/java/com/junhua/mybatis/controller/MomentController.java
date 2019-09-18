package com.junhua.mybatis.controller;


import com.junhua.mybatis.db.MomentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class MomentController {

    @Autowired
    private MomentDao momentDao;

    @RequestMapping("/get/moment")
    public String getMomentImage() throws IOException {
        return momentDao.getMoment().getImage();
    }

    @RequestMapping(path = "moment/insert", method = RequestMethod.GET)
    public String insert(int authorId, String content, String image) throws IOException {
        momentDao.insert(authorId, content, image);
        return "success";
    }
}
