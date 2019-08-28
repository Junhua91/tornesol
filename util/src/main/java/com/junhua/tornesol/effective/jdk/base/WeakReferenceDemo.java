package com.junhua.tornesol.effective.jdk.base;


import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.WeakHashMap;

/**
 * 弱引用：是对一个对象（称为 referent）的引用的持有者
 * 1. 一个对象的引用可以有多处，如果某一处存在强引用，其他地方的弱引用也不会被GC回收
 * 2. 弱引用不会阻碍对象被GC；强引用会（只要有一处强引用存在，其他引用即使都被置为null，该对象也不会被GC）
 *
 */
public class WeakReferenceDemo {


    public static WeakReference<String> weakReference1;
    public static String strongReference;
    public static WeakHashMap<String, String> weakHashMap = new WeakHashMap<>();
    public static HashMap<String, String> hashMap = new HashMap<>();


    public static void main(String[] args) {
//        test1();
//        test2();
        test3();
    }


    /**
     * WeakHashMap弱引用使用: 弱引用引用的强引用被置为null时，则该强引用不会因为在弱用处被引用而导致GC被妨碍。
     */
    public static void test1() {
        //退出doWeakOp方法后，指向"value"的强引用被置为null
        doWeakMapOp();
        System.gc();
        System.out.println(weakHashMap.isEmpty());
    }


    /**
     * HashMap强引用使用：
     */
    public static void test2() {
        doMapOp();
        //弱引用的对象不一定会被回收，有一定的概率
        System.gc();
        System.out.println(hashMap.isEmpty());
    }

    /**
     * 在退出doWeakReferenceOp方法后，"value"的强引用hello被置为null，并且再也没有其他的强引用指向"value"，只有一个weakReference1弱引用指向"value"。
     * 因此"value"会在下一次GC中会被回收。
     *
     */
    public static void test3() {
        doWeakReferenceOp();
        System.gc();
        System.out.println(weakReference1.get());
    }


    public static void doWeakMapOp() {
        String hello = "value";
        weakHashMap.put(hello, "1");
    }

    public static void doMapOp() {
        //此处的hello是"value2"的强引用
        String hello = "value2";
        // map操作，导致多了一处"value2"的强引用；由于map是全局的，于是这里的"value2"由于这个map的强引用，会一直存在着，即使"value2"不再需要
        hashMap.put(hello, "1");
    }

    public static void doWeakReferenceOp() {
        String hello = new String("value");
        weakReference1 = new WeakReference<>(hello);
        System.out.println(weakReference1.get());
    }
}
