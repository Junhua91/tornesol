package com.junhua.tornesol.leetcode.datastructure.graph;

import java.util.*;

public class CourseScheduleII {

    static public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] res = new int[numCourses];
        int count = 0;
        int[] degree = new int[numCourses];
        ArrayList<Integer>[] graph = buildGraph(numCourses, prerequisites);
        for (ArrayList<Integer> list : graph) {
            for (int num : list) {
                degree[num]++;
            }
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (degree[i] == 0) {
                queue.offer(i);
                count++;
            }
        }

        int index = 0;
        while (!queue.isEmpty()) {
            int i = queue.poll();
            res[index++] = i;
            for (int num : graph[i]) {
                degree[num]--;
                if (degree[num] == 0) {
                    queue.offer(num);
                    count++;
                }
            }
        }

        return count == numCourses ? res : new int[]{};


    }

    static public ArrayList<Integer>[] buildGraph(int numCourses, int[][] prerequisites) {
        ArrayList<Integer>[] graph = new ArrayList[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < prerequisites.length; i++) {
            graph[prerequisites[i][1]].add(prerequisites[i][0]);
        }
        return graph;
    }


    public static void main(String[] args) {
        int[][] prerequisites = {{1, 0}, {2, 0}, {3, 1}, {3, 2}};
        ArrayList[] graph = buildGraph(4, prerequisites);
        int[] res = findOrder(4, prerequisites);

        return;

    }
}
