package com.junhua.rpc.init;

import org.springframework.beans.factory.InitializingBean;

public class ReferenceBean implements InitializingBean {

    private String interfaceName;

    public void setInterface(String interfaceName) {
        this.interfaceName = interfaceName;
    }

    @Override
    public void afterPropertiesSet() throws Exception {



    }


}
