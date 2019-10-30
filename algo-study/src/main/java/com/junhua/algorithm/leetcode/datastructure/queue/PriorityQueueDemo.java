package com.junhua.algorithm.leetcode.datastructure.queue;

import java.util.PriorityQueue;

public class PriorityQueueDemo {

    public static void main(String[] args) {
        PriorityQueue<Integer> queue = new PriorityQueue();

        queue.add(2);
        queue.add(23);
        queue.add(4);
        queue.add(7);
        queue.add(14);
        queue.add(9);
        queue.add(3);
        queue.add(25);
        queue.add(16);
        queue.add(18);
        queue.add(1);
        queue.add(6);

        System.out.println(queue.peek());
        System.out.println(queue);

        test1();
    }

    public static void test1() {
        Student stu1 = new Student("1", 39);
        Student stu2 = new Student("2", 12);
        Student stu3 = new Student("3", 31);
        Student stu4 = new Student("4", 11);
        Student stu5 = new Student("5", 10);
        Student stu6 = new Student("6", 8);
        Student stu7 = new Student("7", 5);
        Student stu8 = new Student("8", 58);

        PriorityQueue<Student> stuQueue = new PriorityQueue<>();
        stuQueue.add(stu1);
        stuQueue.add(stu2);
        stuQueue.add(stu3);
        stuQueue.add(stu4);
        stuQueue.add(stu5);
        stuQueue.add(stu6);
        stuQueue.add(stu7);
        stuQueue.add(stu8);

        System.out.println(stuQueue.peek().getName());
    }
}
