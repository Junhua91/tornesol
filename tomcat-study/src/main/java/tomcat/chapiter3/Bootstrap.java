package tomcat.chapiter3;

public class Bootstrap {

    public static void main(String[] args){
        HttpConnector connector = new HttpConnector();
        connector.start();
    }
}
