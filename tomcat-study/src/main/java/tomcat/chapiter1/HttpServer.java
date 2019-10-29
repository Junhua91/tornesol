package tomcat.chapiter1;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class HttpServer {

    public static final String WEB_ROOT = System.getProperty("user.dir") + File.separator + "webroot";
    private static final String SHUTDOWN_COMMAND = "/SHUTDOWN";

    private boolean shutdown = false;

    public void await() {

        ServerSocket srv = null;
        Socket socket = null;
        InputStream in = null;
        OutputStream out = null;

        try {
            srv = new ServerSocket(8080, 1, InetAddress.getByName("127.0.0.1"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        while (!shutdown) {
            try {
                socket = srv.accept();
                in = socket.getInputStream();
                out = socket.getOutputStream();

                Request request = new Request(in);
                request.parse();

                Response response = new Response(out);
                response.setRequest(request);
                response.sendStaticResource();

                socket.close();
                shutdown = request.getUri().equals(SHUTDOWN_COMMAND);
            } catch (Exception e) {
                e.printStackTrace();
                continue;
            }
        }


    }

    public static void main(String[] args) {
        HttpServer server = new HttpServer();
        server.await();
    }


}
