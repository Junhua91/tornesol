package com.junhua.mybatis.service;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContextEvent;

public class InitContextLoader extends ContextLoaderListener {


    private static ApplicationContext applicationContext;

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        super.contextInitialized(sce);
        this.applicationContext = WebApplicationContextUtils.getWebApplicationContext(sce.getServletContext());
        return;
    }

    public static ApplicationContext getApplicationContext() {
        return applicationContext;
    }


    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        super.contextDestroyed(sce);
    }
}
