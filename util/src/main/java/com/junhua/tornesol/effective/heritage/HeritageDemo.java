package com.junhua.tornesol.effective.heritage;


public class HeritageDemo {

    public static void main(String[] args) {
        SupperClass supperClass = new SubClass();
        System.out.println(supperClass.name);
    }
}
