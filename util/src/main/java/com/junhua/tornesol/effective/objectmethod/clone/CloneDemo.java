package com.junhua.tornesol.effective.objectmethod.clone;

import com.junhua.tornesol.effective.objectmethod.Person;
import com.junhua.tornesol.effective.objectmethod.Pet;

/**
 * a better approach to object copying is to provide a copy construct
 * or copy factory:
 * # 1. public Yum(Yum yun){}
 * # 2. public static Yum newInstance(Yum yum){}
 */
public class CloneDemo {

    public static void main(String[] args) throws CloneNotSupportedException {
        test1();
        test2();
        test3();
    }

    /**
     * 附值不是copy，还是原来的reference
     */
    public static void test1() {
        Person p1 = new Person(18, "junhua");
        Person p2 = p1;
        System.out.println(p2 == p1);
    }

    /**
     * 继承Cloneable接口，override Object.clone方法
     *
     * @throws CloneNotSupportedException
     */
    public static void test2() throws CloneNotSupportedException {
        Person p1 = new Person(18, "junhua");
        Person p2 = (Person) p1.clone();
        System.out.println(p2 == p1);
    }

    /**
     * 对象中有其他引用, 简单的super.clone 会产生问题（深拷贝和浅拷贝）
     *
     * @throws CloneNotSupportedException
     */
    public static void test3() throws CloneNotSupportedException {
        Person p1 = new Person(18, "junhua");
        Pet pet = new Pet("max", "加菲");
        p1.setPet(pet);

        Person p2 = (Person) p1.clone();
        p2.getPet().setName("max2");
        System.out.println(p1.getPet().getName());
    }

}
