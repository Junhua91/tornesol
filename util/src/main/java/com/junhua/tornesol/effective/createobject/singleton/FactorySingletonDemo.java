package com.junhua.tornesol.effective.createobject.singleton;

import java.io.*;

public class FactorySingletonDemo {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        test1();
    }

    /**
     * 如果单例涉及到序列化，需要在单例中添加readResolve方法;
     * 否则每次在deserialize的时候，都会创建一个新的instance
     *
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public static void test1() throws IOException, ClassNotFoundException {
        FactorySingleton s1 = null;
        FactorySingleton s = FactorySingleton.getInstance();

        FileOutputStream fos = new FileOutputStream("a.txt");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(s);
        oos.flush();
        oos.close();

        FileInputStream fis = new FileInputStream("a.txt");
        ObjectInputStream ois = new ObjectInputStream(fis);
        s1 = (FactorySingleton) ois.readObject();

        System.out.println(s1);
        System.out.println(s);
    }
}
