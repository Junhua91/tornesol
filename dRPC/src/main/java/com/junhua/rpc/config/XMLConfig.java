package com.junhua.rpc.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;


/**
 * 引入外部XML配置文件
 */
@Configuration
@ImportResource(locations = {"classpath:application-context.xml"})
public class XMLConfig {
}
