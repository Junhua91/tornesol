package com.junhua.tornesol.util.spring.spring_lifecycle;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@PropertySource(value = {"classpath:/animal.properties"})//读取外部配置文件，保存到运行环境变量中
@Configuration
public class MyBeanLifeCycle {
    @Bean(name = "animal")
    public Animal animal() {
        Animal animal = new Animal();
        return animal;
    }
}
