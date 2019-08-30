package com.ximalaya.webgroup.tdkservice.thrift.test;

import com.ximalaya.webgroup.tdkservice.thrift.CrossPlatformService;
import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import org.apache.thrift.transport.TTransportException;

public class ThriftClientApplication {

    public static void main(String[] args) {

        TTransport transport = null;
        try {
            transport = new TSocket("localhost", 9999);
            TProtocol protocol = new TBinaryProtocol(transport);
            CrossPlatformService.Client client = new CrossPlatformService.Client(protocol);
            transport.open();
            System.out.println(client.sayHi());
        } catch (TTransportException e) {
            e.printStackTrace();
        } catch (TException e) {
            e.printStackTrace();
        } finally {
            if (null != transport)
                transport.close();
        }
    }
}
