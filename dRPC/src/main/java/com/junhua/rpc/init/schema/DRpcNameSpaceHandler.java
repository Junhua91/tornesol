package com.junhua.rpc.init.schema;

import com.junhua.rpc.init.ReferenceBean;
import com.junhua.rpc.init.ServiceBean;
import org.springframework.beans.factory.xml.NamespaceHandlerSupport;

public class DRpcNameSpaceHandler extends NamespaceHandlerSupport {

    @Override
    public void init() {
        registerBeanDefinitionParser("service", new DRpcBeanDefinitionParser(ServiceBean.class, true));
        registerBeanDefinitionParser("reference", new DRpcBeanDefinitionParser(ReferenceBean.class, true));
    }
}
