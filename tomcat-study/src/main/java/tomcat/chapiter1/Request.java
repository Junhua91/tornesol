package tomcat.chapiter1;


import java.io.IOException;
import java.io.InputStream;

/**
 * 表示一个http请求，可以传递inputStream对象
 */
public class Request {

    private InputStream in;
    private String uri;


    public Request(InputStream in){
        this.in = in;
    }

    /**
     * 读取客户端传来的信息，将客户端需要的资源地址解析出来
     */
    public void parse(){
        StringBuffer request = new StringBuffer(2048);
        int i;
        byte[] buffer = new byte[2048];
        try{
            i = in.read(buffer);
        } catch (IOException e) {
            e.printStackTrace();
            i=-1;
        }

        for(int j=0;j<i;j++){
            request.append((char)buffer[j]);
        }

        System.out.println(request.toString());
        uri = parseUri(request.toString());
    }


    public String getUri() {
        return uri;
    }


    /**
     * 请求行格式为 "GET /index/html HTTP/1/1",取出"／index.html"
     * @param requestString
     * @return
     */
    private String parseUri(String requestString){
        int index1, index2;
        index1 = requestString.indexOf(' ');
        if(index1 != -1){
            index2 = requestString.indexOf(' ',index1+1);
            if(index2>index1)return requestString.substring(index1+1,index2);
        }
        return null;
    }

}
