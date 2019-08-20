package com.junhua.tornesol.leetcode.datastructure.queue;


public class Student implements Comparable {

    private String name;
    private int score;

    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }


    @Override
    public int compareTo(Object o) {
        return -(this.score - ((Student) o).getScore());
    }
}
