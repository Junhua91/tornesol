package com.ximalaya.webgroup.tdkservice.thrift.impl;

import com.ximalaya.webgroup.tdkservice.thrift.CrossPlatformService;
import org.apache.thrift.TException;

public class CrossPlatformServiceImpl implements CrossPlatformService.Iface {

    @Override
    public String sayHi() throws TException {
        return "hi, thrift";
    }
}
