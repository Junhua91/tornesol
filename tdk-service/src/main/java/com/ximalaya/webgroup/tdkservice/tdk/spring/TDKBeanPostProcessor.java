package com.ximalaya.webgroup.tdkservice.tdk.spring;

import com.ximalaya.webgroup.tdkservice.tdk.api.annotation.TDKConfig;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.core.annotation.AnnotationUtils;


public class TDKBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        Class clazz = bean.getClass();
        TDKConfig annotation = AnnotationUtils.findAnnotation(clazz, TDKConfig.class);
        if (annotation == null) return bean;
        processTDKConfig(bean, bean.getClass());
        return bean;
    }


    private void processTDKConfig(Object bean, Class clazz) {
        TDKConfig annotation = AnnotationUtils.findAnnotation(clazz, TDKConfig.class);
        if (annotation == null) return;
        String domain = annotation.domain();
        TDKConfigBeanHolder beanHolder = new TDKConfigBeanHolder(bean);
    }

}

