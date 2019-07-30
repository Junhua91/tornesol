package com.junhua.tornesol.util.leetcode.strategie.dynamicP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Triangle {

    public static List<List<Integer>> triangle = new ArrayList<>();

    public static int minimumTotal(List<List<Integer>> triangle) {
        int size = triangle.size();
        int[] min = new int[size];
        for (int m = 0; m < triangle.get(size - 1).size(); m++) {
            min[m] = triangle.get(size - 1).get(m);
        }
        for (int i = size - 2; i >= 0; i--) {
            for (int j = 0; j < triangle.get(i).size() ; j++) {
                min[j] = min(min[j], min[j + 1]) + triangle.get(i).get(j);
            }
        }
        return min[0];
    }

    public static int min(int a, int b) {
        return a > b ? b : a;
    }

    public static void main(String[] args) {
        triangle.add(Arrays.asList(2));
        triangle.add(Arrays.asList(3, 4));
        triangle.add(Arrays.asList(6, 5, 7));
        triangle.add(Arrays.asList(4, 1, 8, 3));

        System.out.println(minimumTotal(triangle));
    }
}
