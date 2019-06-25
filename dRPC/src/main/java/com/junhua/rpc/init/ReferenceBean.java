package com.junhua.rpc.init;

import com.junhua.rpc.init.invoker.DRpcInvoker;
import com.junhua.rpc.init.proxy.Invoker;
import com.junhua.rpc.init.proxy.JdkProxyFactory;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;

public class ReferenceBean implements FactoryBean, InitializingBean {

    private String interfaceName;
    private Invoker<?> finalInvoker;

    public void setInterface(String interfaceName) {
        this.interfaceName = interfaceName;
    }


    @Override
    public Object getObject() throws Exception {
        return new JdkProxyFactory().getProxy(finalInvoker);
    }

    @Override
    public Class<?> getObjectType() {
        try {
            return Class.forName(interfaceName, true, Thread.currentThread().getContextClassLoader());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    private void init() throws ClassNotFoundException {

        Class<?> clazz = Class.forName(interfaceName, true, Thread.currentThread().getContextClassLoader());
        try {
            clazz.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        finalInvoker = new DRpcInvoker(clazz);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        init();
    }
}
