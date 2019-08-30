package com.ximalaya.webgroup.tdkservice.zk;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.util.Map;

@Component
public class WebListener implements ServletContextListener {

    @Autowired
    private ServiceRegistry serviceRegistry;

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext servletContext = sce.getServletContext();

        ApplicationContext applicationContext = WebApplicationContextUtils.getWebApplicationContext(servletContext);
        RequestMappingHandlerMapping handlerMapping = applicationContext.getBean(RequestMappingHandlerMapping.class);
        Map<RequestMappingInfo, HandlerMethod> infoMap = handlerMapping.getHandlerMethods();

        for (RequestMappingInfo info : infoMap.keySet()) {
            String serviceName = info.getName();
            if (serviceName != null) {
                serviceRegistry.register(serviceName, "127.0.0.1:2181");
            }
        }
    }
}
