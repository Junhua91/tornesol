package tomcat.chapiter3;


import org.apache.catalina.connector.http.HttpRequestLine;
import org.apache.catalina.connector.http.SocketInputStream;

import javax.servlet.ServletException;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;


public class HttpProcessor {

    private HttpRequestLine requestLine = new HttpRequestLine();
    private HttpRequest request;


    public void process(Socket socket){

        SocketInputStream input = null;
        OutputStream output = null;

        try {
            input = new SocketInputStream(socket.getInputStream(),2048);
            output = socket.getOutputStream();


        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void parseRequest(SocketInputStream input, OutputStream output) throws IOException, ServletException {
        input.readRequestLine(requestLine);
        String method = new String(requestLine.method,0,requestLine.methodEnd);

        String uri = null;
        String protocol = new String(requestLine.protocol,0,requestLine.protocolEnd);

        if(method.length()<1){
            throw new ServletException("Missing HTTP request method");
        } else if(requestLine.uriEnd<1){
            throw new ServletException("Missing HTTP request uri");
        }

        //解析请求过来的参数
        int question =  requestLine.indexOf("?");
        if(question >= 0 ){
            request.setQueryString(new String(requestLine.uri,question+1,requestLine.uriEnd-question-1));
            uri = new String(requestLine.uri,0,question);
        }else{
            request.setQueryString(null);
            uri = new String(requestLine.uri,0,requestLine.uriEnd);
        }

        if(!uri.startsWith("/")){
            int pos = uri.indexOf("://");
            if(pos!=-1){
                pos = uri.indexOf("/",pos+3);
                if(pos==-1){
                    uri = "";
                }else
                    uri = uri.substring(pos);
            }
        }

        String match = ";jsessionid=";
        int semicolon =  uri.indexOf(match);
        if(semicolon >= 0){
            String rest  = uri.substring(semicolon+match.length());
            int semicolon2 = rest.
        }
    }

}
