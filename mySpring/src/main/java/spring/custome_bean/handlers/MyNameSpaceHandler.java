package spring.custome_bean.handlers;

import org.springframework.beans.factory.xml.NamespaceHandlerSupport;

public class MyNameSpaceHandler extends NamespaceHandlerSupport {

    @Override
    public void init() {
        registerBeanDefinitionParser("apple", new AppleBeanDefinitionParser());
    }
}
