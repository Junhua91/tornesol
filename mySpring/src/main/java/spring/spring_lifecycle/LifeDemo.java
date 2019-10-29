package spring.spring_lifecycle;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

public class LifeDemo {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyBeanLifeCycle.class);

        System.out.println("容器初始化完成");
        context.getBean("car");
        System.out.println(context.getBean("animal"));
        Arrays.stream(context.getBeanDefinitionNames()).forEach(p -> System.out.println(p));
        context.close();
    }
}
