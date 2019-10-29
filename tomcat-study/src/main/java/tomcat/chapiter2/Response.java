package tomcat.chapiter2;

import javax.servlet.ServletOutputStream;
import javax.servlet.ServletResponse;
import java.io.*;
import java.util.Locale;

public class Response implements ServletResponse{

    private static final int BUFFER_SIZE = 1024;
    private Request request;
    private OutputStream out;
    private PrintWriter writer;

    public Response(OutputStream out) {
        this.out = out;
    }

    public void sendStaticResource() throws IOException {
        byte[] bytes = new byte[BUFFER_SIZE];
        FileInputStream fis = null;

        try{
            File file = new File(HttpServer.WEB_ROOT,request.getUri());
            fis = new FileInputStream(file);

            int ch =  fis.read(bytes,0,BUFFER_SIZE);
            String header = "HTTP/1.1 200 OK\r\n"+"\r\n";
            while (ch != -1) {
                out.write(header.getBytes());
                out.flush();
                out.write(bytes);
                ch = fis.read(bytes, 0, BUFFER_SIZE);
            }
        } catch (IOException e) {
            e.printStackTrace();
            String errorMessage = "HTTP/1.1 404 File Not Found\r\n" + "Content-Type:text/html\r\n" + "Content-Length:23\r\n" + "\r\n" + "<h1>File Not Found</h1>";
            out.write(errorMessage.getBytes());
        }finally {
            if(fis!=null)fis.close();
        }
    }

    public String getCharacterEncoding() {
        return null;
    }

    public void setRequest(Request request) {
        this.request = request;
    }

    public String getContentType() {
        return null;
    }

    public ServletOutputStream getOutputStream() throws IOException {
        return null;
    }

    public PrintWriter getWriter() throws IOException {
        writer = new PrintWriter(out,true);
        return writer;
    }

    public void setCharacterEncoding(String charset) {

    }

    public void setContentLength(int len) {

    }

    public void setContentLengthLong(long len) {

    }

    public void setContentType(String type) {

    }

    public void setBufferSize(int size) {

    }

    public int getBufferSize() {
        return 0;
    }

    public void flushBuffer() throws IOException {

    }

    public void resetBuffer() {

    }

    public boolean isCommitted() {
        return false;
    }

    public void reset() {

    }

    public void setLocale(Locale loc) {

    }

    public Locale getLocale() {
        return null;
    }
}
