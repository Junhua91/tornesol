package com.junhua.tornesol.util.leetcode.graph;

import java.util.*;

/**
 * 拓扑排序：只针对有向无圈图
 */
public class TopoLogicSort {

    /**
     * 拓扑排序模版
     *
     * @param n
     * @param adjacencyList
     * @return
     */
    static public List<Integer> topologicalSort(int n, int[][] adjacencyList) {
        List<Integer> topoRes = new ArrayList<>();
        int[] inDegree = new int[n];
        for (int[] parent : adjacencyList) {
            for (int child : parent) {
                inDegree[child]++;
            }
        }

        Queue<Integer> deque = new LinkedList<>();

        // start from nodes whose indegree are 0
        for (int i = 0; i < n; i++) {
            if (inDegree[i] == 0) deque.offer(i);
        }

        while (!deque.isEmpty()) {
            int curr = deque.poll();
            topoRes.add(curr);
            for (int child : adjacencyList[curr]) {
                inDegree[child]--;
                if (inDegree[child] == 0) {
                    deque.offer(child);
                }
            }
        }

        return topoRes.size() == n ? topoRes : new ArrayList<>();
    }

    static public boolean canFinish(int numCourses, int[][] prerequisites) {
        return isTopoLogic(buildGraph(prerequisites, numCourses), numCourses);
    }

    public static ArrayList<Integer>[] buildGraph(int[][] prerequisites, int numCourses) {
        ArrayList<Integer>[] res = new ArrayList[numCourses];

        for(int i=0;i<numCourses;i++){
            res[i] = new ArrayList();
        }
        for (int i = 0; i < prerequisites.length; i++) {
            res[prerequisites[i][1]].add(prerequisites[i][0]);
        }
        return res;
    }


    public static boolean isTopoLogic(ArrayList<Integer>[] graph, int numCourses) {
        int count = 0;
        int[] degree = new int[numCourses];
        for (ArrayList<Integer> list : graph) {
            for (int num : list) {
                degree[num]++;
            }
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < degree.length; i++) {
            if (degree[i] == 0) {
                queue.offer(i);
                count++;
            }
        }
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            for (int child : graph[cur]) {
                degree[child]--;
                if (degree[child] == 0) {
                    queue.offer(child);
                    count++;
                }
            }
        }
        return count == numCourses;
    }


    public static void main(String[] args) {
        int[][] nums = {{1, 0}, {0, 1}};
        int[][] nums2 = {{0, 1}};

         ArrayList[] graph = buildGraph(nums2,2);
//        ArrayList[] graph2 = buildGraph(nums, 2);

        System.out.println(canFinish(2, nums2));

        return;
    }
}
