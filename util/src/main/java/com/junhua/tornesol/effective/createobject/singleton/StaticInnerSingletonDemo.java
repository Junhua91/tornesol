package com.junhua.tornesol.effective.createobject.singleton;

import java.io.*;

public class StaticInnerSingletonDemo {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        StaticInnerSingleton s1 = null;
        StaticInnerSingleton s = StaticInnerSingleton.getInstance();

        FileOutputStream fos = new FileOutputStream("a.txt");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(s);
        oos.flush();
        oos.close();

        FileInputStream fis = new FileInputStream("a.txt");
        ObjectInputStream ois = new ObjectInputStream(fis);
        s1 = (StaticInnerSingleton) ois.readObject();

        System.out.println(s1);
        System.out.println(s);

    }
}
