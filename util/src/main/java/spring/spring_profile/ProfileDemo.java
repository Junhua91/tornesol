package spring.spring_profile;


import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

public class ProfileDemo {

    public static void main(String[] args) {

//        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfig.class);

        //构建无参构造器
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        //设置环境变量
        context.getEnvironment().setActiveProfiles("test");
        //注册configuration 类
        context.register(MainConfig.class);
        context.refresh();
        Arrays.stream(context.getBeanDefinitionNames()).forEach(p ->
                System.out.println(p)
        );


    }
}
