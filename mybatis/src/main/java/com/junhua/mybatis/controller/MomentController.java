package com.junhua.mybatis.controller;


import com.junhua.mybatis.db.MomentDao;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class MomentController {

    @RequestMapping("/get/moment")
    public String getMomentImage() throws IOException {
        MomentDao momentDao = new MomentDao();
        return momentDao.getMoment().getImage();
    }
}
