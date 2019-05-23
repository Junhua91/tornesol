package com.junhua.tournesol.mvc;

import com.junhua.tournesol.mvc.custome.ExtDispatcherServlet;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.FrameworkServlet;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.http.HttpServlet;

public class MyWebApplicationInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    //获取根容器的配置类
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{com.junhua.tournesol.mvc.RootConfig.class};
    }

    //web 容器的配置类，MVC的配置类
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{com.junhua.tournesol.mvc.AppConfig.class};
    }

    //获取DispatcherServlet的映射信息
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

}
