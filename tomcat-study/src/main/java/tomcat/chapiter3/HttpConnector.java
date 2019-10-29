package tomcat.chapiter3;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 负责创建一个服务器套接字；并为每一个请求创建一个HttpProcessor
 */
public class HttpConnector implements Runnable{

    boolean stopped;
    private String schema = "http";

    public void run() {
        ServerSocket serverSocket = null;
        int port  = 8080;

        try {
            serverSocket =  new ServerSocket(port,1, InetAddress.getByName("127.0.0.1"));
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }

        while(!stopped){
            Socket socket = null;
            try {
                socket = serverSocket.accept();
            } catch (IOException e) {
                e.printStackTrace();
                continue;
            }
        }
    }

    public void start(){
        new Thread(this).start();
    }

    /**
     * 返回请求协议
     * @return
     */
    public String getSchema() {
        return schema;
    }


}
