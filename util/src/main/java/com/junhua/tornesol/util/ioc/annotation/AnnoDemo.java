package com.junhua.tornesol.util.ioc.annotation;

public class AnnoDemo {

    static public void main(String[] args) throws Exception {
        CustomClassPathApplicationContext context = new CustomClassPathApplicationContext("com.junhua.tornesol.util.ioc.annotation");

        User user = (User) context.getBean("user");

        user.sayHi();
        System.out.println();

    }
}
