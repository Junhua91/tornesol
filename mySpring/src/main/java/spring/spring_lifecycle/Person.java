package spring.spring_lifecycle;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;


public class Person implements InitializingBean, DisposableBean {

    public Person() {
        System.out.println("person constructor");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("person destroy");

    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("person init");
    }
}
