package tomcat.chapiter1;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;


/**
 * response = 状态行 + CRLF + body
 * 必须要满足上面的格式，发送的response才是valid 的
 */

public class Response {

    private static final int BUFFER_SIZE = 1024;

    public Request request;
    private OutputStream out;

    public Response(OutputStream out) {
        this.out = out;
    }

    public void setRequest(Request request){
        this.request = request;
    }

    /**
     *根据request提供的文件地址，在本地服务器上找到相应的文件返回；如果没有该文件，就返回404 错误码
     */
    public void sendStaticResource() throws IOException {
        byte[] bytes = new byte[BUFFER_SIZE];
        FileInputStream fis = null;
        try {
            File file = new File(HttpServer.WEB_ROOT, request.getUri());
            if (file.exists()) {
                fis = new FileInputStream(file);
                int ch = fis.read(bytes, 0, BUFFER_SIZE);
                String header = "HTTP/1.1 200 OK\r\n"+"\r\n";
                while (ch != -1) {
                    out.write(header.getBytes());
                    out.flush();
                    out.write(bytes);
                    ch = fis.read(bytes, 0, BUFFER_SIZE);
                }
            } else {
                String errorMessage = "HTTP/1.1 404 File Not Found\r\n" + "Content-Type:text/html\r\n" + "Content-Length:23\r\n" + "\r\n" + "<h1>File Not Found</h1>";
                out.write(errorMessage.getBytes());
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        } finally {
            if (fis != null) {
                fis.close();
            }
        }
    }

}
