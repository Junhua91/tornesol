package spring.spring_annotation.config_anno;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

public class ConfigDemo {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(MainConfig.class);
        Arrays.stream(context.getBeanDefinitionNames()).forEach(p -> System.out.println(p));
    }
}
