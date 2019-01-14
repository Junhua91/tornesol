package com.junhua.tornesol.util.spring.spring_autowire;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"com.junhua.tornesol.util.spring.spring_autowire"})
public class MainConfig {

    @Bean(name = "bookDao2")
    public BookDao bookDao() {
        BookDao bookDao = new BookDao();
        bookDao.setLabel("2");
        return bookDao;
    }
}
