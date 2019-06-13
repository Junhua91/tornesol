package com.junhua.rpc.init.schema;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanDefinitionHolder;
import org.springframework.beans.factory.config.RuntimeBeanReference;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.beans.factory.xml.BeanDefinitionParser;
import org.springframework.beans.factory.xml.ParserContext;
import org.w3c.dom.Element;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Date;

/**
 * 解析自定义xml
 */
public class DRpcBeanDefinitionParser implements BeanDefinitionParser {

    private final Class<?> beanClass;
    private final boolean required;


    public DRpcBeanDefinitionParser(Class<?> beanClass, boolean required) {
        this.beanClass = beanClass;
        this.required = required;
    }

    @Override
    public BeanDefinition parse(Element element, ParserContext parserContext) {
        try {
            return parse(element, parserContext, beanClass, required);
        } catch (ClassNotFoundException e) {
            throw new IllegalStateException("Not found class " + beanClass.getName() + ", cause: " + e.getMessage(), e);
        }
    }

    private BeanDefinition parse(Element element, ParserContext parserContext, Class<?> beanClass, boolean required) throws ClassNotFoundException {
        RootBeanDefinition beanDefinition = new RootBeanDefinition();
        beanDefinition.setBeanClass(beanClass);
        beanDefinition.setLazyInit(false);

        String id = element.getAttribute("id");

        //在service中指定class
        String className = element.getAttribute("class");
        if (className != null && className.length() > 0) {
            RootBeanDefinition classDefinition = new RootBeanDefinition();
            classDefinition.setBeanClass(Class.forName(className));
            classDefinition.setLazyInit(false);
            beanDefinition.getPropertyValues().addPropertyValue("ref",
                    new BeanDefinitionHolder(classDefinition, id + "Impl"));
        }

        for (Method setter : beanClass.getMethods()) {
            String name = setter.getName();
            if (name.length() > 3 && name.startsWith("set")
                    && Modifier.isPublic(setter.getModifiers())
                    && setter.getParameterTypes().length == 1) {
                Class<?> type = setter.getParameterTypes()[0];
                String property = name.substring(3, 4).toLowerCase() + name.substring(4);
                String value = element.getAttribute(property);
                Object reference;

                if (isPrimitive(type)) {
                    reference = value;
                } else {
                    if ("ref".equals(property) && parserContext.getRegistry().containsBeanDefinition(value)) {
                        BeanDefinition refBean = parserContext.getRegistry().getBeanDefinition(value);
                        if (!refBean.isSingleton()) {
                            throw new IllegalStateException("The exported service ref " + value + " must be singleton! Please set the " + value + " bean scope to singleton, eg: <bean id=\"" + value + "\" scope=\"singleton\" ...>");
                        }
                    }
                    reference = new RuntimeBeanReference(value);
                }
                beanDefinition.getPropertyValues().addPropertyValue(property, reference);
            }
        }
        return beanDefinition;
    }

    private static boolean isPrimitive(Class<?> cls) {
        return cls.isPrimitive() || cls == Boolean.class || cls == Byte.class
                || cls == Character.class || cls == Short.class || cls == Integer.class
                || cls == Long.class || cls == Float.class || cls == Double.class
                || cls == String.class || cls == Date.class || cls == Class.class;
    }
}
