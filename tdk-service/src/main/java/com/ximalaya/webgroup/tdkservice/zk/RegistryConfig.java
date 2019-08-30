package com.ximalaya.webgroup.tdkservice.zk;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RegistryConfig {

    @Bean
    public ServiceRegistry serviceRegistry() {
        return new ServiceRegistryImpl("127.0.0.1:2181");

    }
}
