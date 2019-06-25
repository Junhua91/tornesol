package spring.spring_autowire;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

public class AutowireDemo {


    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfig.class);

        BookService bookService = context.getBean(BookService.class);

        Arrays.stream(context.getBeanDefinitionNames()).forEach(p -> System.out.println(p));

        System.out.println(bookService.bookDao);
    }

}
