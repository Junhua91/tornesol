package com.junhua.tornesol.effective.createobject.singleton;

import java.io.*;

public class EnumSingletonDemo {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        EnumSingleton s1 = null;
        EnumSingleton s = EnumSingleton.JUNHUA;

        FileOutputStream fos = new FileOutputStream("a.txt");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(s);
        oos.flush();
        oos.close();

        FileInputStream fis = new FileInputStream("a.txt");
        ObjectInputStream ois = new ObjectInputStream(fis);
        s1 = (EnumSingleton) ois.readObject();

        System.out.println(s1);
        System.out.println(s);
    }
}