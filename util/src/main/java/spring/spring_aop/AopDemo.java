package spring.spring_aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AopDemo {

    static public void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfig.class);

        context.getBean(MathCalculator.class).div(4, 2);
    }
}
