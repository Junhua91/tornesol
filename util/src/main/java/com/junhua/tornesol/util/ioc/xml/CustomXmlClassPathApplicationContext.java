package com.junhua.tornesol.util.ioc.xml;

import org.apache.commons.lang.StringUtils;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomXmlClassPathApplicationContext {


    private String xmlPath;

    public CustomXmlClassPathApplicationContext(String xmlPath) {
        this.xmlPath = xmlPath;
    }

    public Object getBean(String beanId) throws Exception {
        if (StringUtils.isEmpty(beanId)) {
            throw new Exception("beanId 不能为空");
        }

        List<Element> elements = readXML();
        if (elements == null || elements.isEmpty()) {
            throw new Exception("配置文件中没有配置bean信息");
        }

        String className = findClassPath(elements, beanId);
        Map propeties = findProperties(elements, beanId);

        return newInstance(className, propeties);

    }

    public String findClassPath(List<Element> elements, String beanId) throws Exception {
        Element element = findElement(elements, beanId);
        if (element == null) {
            throw new Exception("配置文件中没有该bean: " + beanId);
        } else return element.attributeValue("class");
    }


    public Map<String, String> findProperties(List<Element> elements, String beanId) throws Exception {
        Map propertyMap = new HashMap();

        Element element = findElement(elements, beanId);
        if (element == null) {
            throw new Exception("配置文件中没有该bean: " + beanId);
        } else {
            List<Element> properties = element.elements("property");
            if (properties.isEmpty()) {
            } else {
                properties.stream().forEach(property -> {
                    propertyMap.put(property.attributeValue("name"), property.attributeValue("value"));
                });
            }
        }
        return propertyMap;
    }


    private Element findElement(List<Element> elements, String beanId) {
        for (Element element : elements) {
            String xmlBeanId = element.attributeValue("id");
            if (StringUtils.isEmpty(xmlBeanId)) {
                continue;
            }

            if (xmlBeanId.equals(beanId)) {
                return element;
            }
        }
        return null;
    }

    /**
     * 反射创建对象
     *
     * @param className
     * @return
     * @throws ClassNotFoundException
     * @throws IllegalAccessException
     * @throws InstantiationException
     */
    public Object newInstance(String className, Map<String, String> properties) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Class<?> classInfo = Class.forName(className);

        Object obj = classInfo.newInstance();

        if (properties.isEmpty()) {

        } else {
            properties.entrySet().stream().forEach(entry -> {
                String key = entry.getKey();
                String value = entry.getValue();

                String setKey = "set" + key.toUpperCase().charAt(0) + key.substring(1);
                try {
                    Method f = obj.getClass().getMethod(setKey, String.class);
                    f.setAccessible(true);
                    f.invoke(obj, value);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (NoSuchMethodException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
            });
        }


        return obj;
    }


    /**
     * 解析XML文件信息: 拿到所有bean的节点信息
     *
     * @throws DocumentException
     */
    public List<Element> readXML() throws DocumentException {
        SAXReader reader = new SAXReader();
        Document document = reader.read(getResourceAsStream(xmlPath));
        Element rootElement = document.getRootElement();

        List<Element> elements = rootElement.elements();

        return elements;
    }


    /**
     * 获取当前上下文路径
     *
     * @param xmlPath
     * @return
     */
    public InputStream getResourceAsStream(String xmlPath) {
        return this.getClass().getClassLoader().getResourceAsStream(xmlPath);
    }

}
