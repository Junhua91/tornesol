package com.ximalaya.webgroup.tdkservice.thrift.test;


import com.ximalaya.webgroup.tdkservice.thrift.CrossPlatformService;
import com.ximalaya.webgroup.tdkservice.thrift.impl.CrossPlatformServiceImpl;
import org.apache.thrift.TProcessor;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TSimpleServer;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TTransportException;

public class ThriftServerApplication {

    public static void main(String[] args) {

        try {
            TProcessor tProcessor = new CrossPlatformService.Processor<CrossPlatformService.Iface>(new CrossPlatformServiceImpl());
            TServerSocket serverSocket = new TServerSocket(9999);

            TServer.Args tArgs = new TServer.Args(serverSocket);
            tArgs.processor(tProcessor);
            tArgs.protocolFactory(new TBinaryProtocol.Factory());
            TServer server = new TSimpleServer(tArgs);
            server.serve();
        } catch (TTransportException e) {
            e.printStackTrace();
        }
    }


}
