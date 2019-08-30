package com.junhua.tornesol.effective.jdk.base;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayListDemo {


    public static void main(String[] args) throws IOException {
        resizing();
        remove();
//        modCount();

        serialize();
        subList();
    }


    /**
     * 1. 内部用数组存储数据
     * 2. 默认为长度为10
     * 3. 每次扩容为原来的1.5倍: int newCapacity = oldCapacity + (oldCapacity >> 1);
     * 4. 扩容的最大长度： (minCapacity > MAX_ARRAY_SIZE) ？Integer.MAX_VALUE : MAX_ARRAY_SIZE;
     */
    public static void resizing() {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            list.add(i);
        }
    }

    /**
     * 1.  System.arraycopy: O(N)
     * 2.  elementData[--size] = null; // clear to let GC do its work
     */
    public static void remove() {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            list.add(i);
        }
        list.remove(2);
    }


    /**
     * modCount 记录ArrayList结构变化的次数：add、remove、clear
     */
    public static void modCount() {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            list.add(i);
        }
        list.stream().map(p -> {
            list.remove(p);
            return 1;
        }).forEach(System.out::println);
    }


    /**
     * 1. ArrayList 用数组来保存数据，同时使用transient来修饰该数组，使该数组默认不能被序列化：transient Object[] elementData;
     * 2. ArrayList 中提供了writeObject和readObject来控制只序列化数组中有元素填充那部分内容
     * 3. ArrayList 中的writeObject方法是private的，但是ObjectOutputStream会反射调用ArrayList的writeObject，完成序列化
     */
    public static void serialize() throws IOException {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            list.add(i);
        }
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("writeObject.txt"));
        oos.writeObject(list);
    }

    public static void subList() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 0);

        List res = list.subList(0, 20);
        List res2 = list.subList(0, 5);
        return;
    }

}
