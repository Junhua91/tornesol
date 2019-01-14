package com.junhua.tornesol.util.spring.spring_profile;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class MainConfig {


    @Profile("test")
    @Bean(name = "test")
    public TestBean testBean() {
        return new TestBean();
    }

    @Profile("dev")
    @Bean(name = "dev")
    public DevBean devBean() {
        return new DevBean();
    }

    @Profile("prod")
    @Bean(name = "prod")
    public ProdBean prodBean() {
        return new ProdBean();
    }
}
