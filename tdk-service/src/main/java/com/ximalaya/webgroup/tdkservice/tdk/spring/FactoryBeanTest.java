package com.ximalaya.webgroup.tdkservice.tdk.spring;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.lang.Nullable;

public class FactoryBeanTest implements FactoryBean<TestBean>, InitializingBean {

    private TestBean iface;
    private Class<TestBean> ifaceClass;// require

    @Nullable
    @Override
    public TestBean getObject() throws Exception {
        return iface;
    }

    @Nullable
    @Override
    public Class<?> getObjectType() {
        return ifaceClass;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        iface = new TestBean(1, 2);
    }

    public void setIfaceClass(Class<TestBean> ifaceClass) {
        this.ifaceClass = ifaceClass;
    }
}
