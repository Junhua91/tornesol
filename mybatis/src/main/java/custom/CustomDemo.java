package custom;

import model.User;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class CustomDemo {


    static public void main(String[] args) {

        InvocationHandler insertHandler = new MyInvocationHandler<>(ExtMapper.class);

        ExtMapper extMapper = (ExtMapper) Proxy.newProxyInstance(ExtMapper.class.getClassLoader(),
                new Class<?>[]{ExtMapper.class}, insertHandler);
        User user = new User();
        user.setAge(13);
        user.setName("peggi");
        extMapper.insert(user);

        Object obj = extMapper.select("peggi");



        System.out.println();
    }

}
