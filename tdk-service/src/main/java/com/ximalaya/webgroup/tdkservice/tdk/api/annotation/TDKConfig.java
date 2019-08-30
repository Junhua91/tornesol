package com.ximalaya.webgroup.tdkservice.tdk.api.annotation;

import com.ximalaya.webgroup.tdkservice.tdk.spring.TDKConfigRegistrar;
import org.springframework.context.annotation.Import;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 开启TDK服务；每个项目定义一个TDKConfig类
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Import(TDKConfigRegistrar.class)
public @interface TDKConfig {
    String domain();
}
