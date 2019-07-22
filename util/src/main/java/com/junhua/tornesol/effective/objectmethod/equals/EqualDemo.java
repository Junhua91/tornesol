package com.junhua.tornesol.effective.objectmethod.equals;

public class EqualDemo {


    public static void main(String[] args) {
        float f1 = 0.0f;
        float f2 = 0f;

        System.out.println(f1==f2);
        System.out.println(Float.compare(f1,f2)==0);

    }
}
