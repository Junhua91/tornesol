package com.ximalaya.webgroup.tdkservice.tdk.spring;

import com.ximalaya.webgroup.tdkservice.model.MetaWeb;
import com.ximalaya.webgroup.tdkservice.tdk.api.*;
import com.ximalaya.webgroup.tdkservice.tdk.api.annotation.TDKHandler;
import com.ximalaya.webgroup.tdkservice.tdk.api.annotation.TDKResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.lang.reflect.Field;
import java.util.*;

public class TDKConfigBeanHolder {

    private Map<String, Handler> handlerMap = new HashMap<>();
    private List<String> groupNameList = new ArrayList<>();
    private Object bean;
    private Container container;
    private StringRedisTemplate redis;
    private ITDKRequestParam request;


    public TDKConfigBeanHolder(Object bean) {
        this.bean = bean;
        init(bean);
        initResult(bean);
    }

    private void init(Object bean) {
        Class clazz = bean.getClass();
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            initHandler(bean, field);
            initRedis(field);
        }
        initContainer(bean);
        initRequest(bean);
    }

    private void initHandler(Object bean, Field field) {
        TDKHandler handlerAnnotation = AnnotationUtils.findAnnotation(field, TDKHandler.class);
        Autowired autowiredAnnotation = AnnotationUtils.findAnnotation(field, Autowired.class);

        if (handlerAnnotation == null) return;

        String handlerName = handlerAnnotation.name();
        Handler customHandler = null;

        try {
            if (autowiredAnnotation != null) {
                field.setAccessible(true);
                customHandler = (Handler) field.get(bean);
            } else customHandler = (Handler) field.getType().newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        if (customHandler != null) {
            handlerMap.put(handlerName, customHandler);
            groupNameList.add(handlerName);
        }
    }

    private void initRedis(Field field) {
        Autowired autowiredAnnotation = AnnotationUtils.findAnnotation(field, Autowired.class);
        if (autowiredAnnotation == null) return;

        if (field.getType() == StringRedisTemplate.class) {
            field.setAccessible(true);
            try {
                redis = (StringRedisTemplate) field.get(bean);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }

    private void initResult(Object bean) {
        Class clazz = bean.getClass();
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            TDKResult resultAnnotation = AnnotationUtils.findAnnotation(field, TDKResult.class);
            if (resultAnnotation == null) continue;
            SResult<MetaWeb> result = container.invoke(request);
            field.setAccessible(true);
            try {
                field.set(bean, result);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }

    private void initContainer(Object bean) {
        if (bean instanceof ITDKConfig) {
            Container container = ((ITDKConfig) bean).getContainer();
            container.setGroupNameList(groupNameList);
            container.setHandlerMap(handlerMap);
            container.setRedis(this.redis);
            container.init();
            this.container = container;
        }
    }

    private void initRequest(Object bean) {
        if (bean instanceof ITDKConfig) {
            ITDKRequestParam request = ((ITDKConfig) bean).buildRequest();
            this.request = request;
        }
    }
}
