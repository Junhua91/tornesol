package com.ximalaya.webgroup.tdkservice.tdk.spring;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

public class TDKConfigRegistrar implements ImportBeanDefinitionRegistrar {

    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        String className = TDKBeanPostProcessor.class.getName();
        if (registry.containsBeanDefinition(className)) return;
        BeanDefinition definition = BeanDefinitionBuilder.genericBeanDefinition(TDKBeanPostProcessor.class).getBeanDefinition();
        registry.registerBeanDefinition(className, definition);
    }
}
