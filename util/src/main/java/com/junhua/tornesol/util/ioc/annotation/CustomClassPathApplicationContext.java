package com.junhua.tornesol.util.ioc.annotation;

import org.apache.commons.lang.StringUtils;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class CustomClassPathApplicationContext {

    private String packageName;
    private ConcurrentHashMap<String, Object> beans = null;

    public CustomClassPathApplicationContext(String packageName) throws Exception {
        beans = new ConcurrentHashMap<>();
        this.packageName = packageName;
        initBeans();
    }

    public void initBeans() throws Exception {
        //获取该包名下的class
        List<Class<?>> classes = ClassUtil.getClasses(packageName);

        ConcurrentHashMap<String, Object> annotionBeans = findClassExistAnnotation(classes);

        if (annotionBeans == null || annotionBeans.isEmpty()) {
            throw new Exception("该包下没有找到注解bean");
        }

        annotionBeans.entrySet().stream().forEach(entry -> {
            try {
                attributeAssign(entry.getValue());
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        });
    }

    public Object getBean(String beanId) throws Exception {
        if (StringUtils.isEmpty(beanId)) {
            throw new Exception("beanId 不能为空");
        }
        Object obj = beans.get(beanId);
        //注入依赖
        if (obj == null) throw new Exception("没找到beanId相应的bean");
        return obj;
    }

    /**
     * 判断类上面是否有注解, 并将注解下的bean存储到map中
     */
    public ConcurrentHashMap<String, Object> findClassExistAnnotation(List<Class<?>> classes) throws IllegalAccessException, InstantiationException, ClassNotFoundException {

        for (Class<?> clazz : classes) {
            ExtService annotation = clazz.getAnnotation(ExtService.class);

            if (annotation != null) {
                String className = clazz.getSimpleName();

                Object obj = ClassUtil.newInstance(clazz.getName(), new HashMap<>());
                beans.put(ClassUtil.toLowerCaseFirstOne(className), obj);
                continue;
            }
        }
        return beans;
    }

    /**
     * 依赖注入
     */
    public void attributeAssign(Object obj) throws IllegalAccessException {
        Field[] fields = obj.getClass().getDeclaredFields();
        for (Field field : fields) {
            ExtAutowired autowired = field.getAnnotation(ExtAutowired.class);
            if (autowired != null) {
                String fieldName = field.getName();
                //获取到依赖注入的bean
                Object bean = beans.get(fieldName);
                if (bean != null) {
                    field.setAccessible(true);
                    field.set(obj, bean);
                }
            }
        }
    }

}
