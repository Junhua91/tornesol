package com.junhua.tornesol.util.ioc.xml;

public class XmlIOCDemo {

    static public void main(String[] args) throws Exception {

        CustomXmlClassPathApplicationContext context = new CustomXmlClassPathApplicationContext("spring.xml");

        User user = (User) context.getBean("user");

        user.add();
    }

}
