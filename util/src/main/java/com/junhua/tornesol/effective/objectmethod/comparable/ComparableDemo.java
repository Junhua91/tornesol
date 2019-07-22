package com.junhua.tornesol.effective.objectmethod.comparable;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.TreeSet;

public class ComparableDemo {


    public static void main(String[] args) {

        PhoneNumber phoneNumber = new PhoneNumber();

        BigDecimal b1 = new BigDecimal("1.0");
        BigDecimal b2 = new BigDecimal("1.00");

        //use compareTo to equality
        TreeSet treeSet = new TreeSet();
        treeSet.add(b1);
        treeSet.add(b2);
        //use equals to equality
        HashSet<BigDecimal> hashSet = new HashSet<>();
        hashSet.add(b1);
        hashSet.add(b2);
        //
        System.out.println(treeSet.size());
        System.out.println(hashSet.size());
    }
}
