package algorithm.leetcode.strategie.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class QueueReconstructionByHeight {

    static public int[][] reconstructQueue(int[][] people) {

        if (people == null || people.length == 0 || people[0].length == 0) return new int[][]{{0, 0}};
        Comparator<int[]> comp = new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) return o1[1] - o2[1];
                else return o2[0] - o1[0];
            }
        };

        Arrays.sort(people, comp);

        List<int[]> res = new ArrayList<>();

        for (int[] p : people) {
            res.add(p[1], p);
        }
        return res.toArray(new int[people.length][]);

    }

    public static void main(String[] args) {

        int[][] people = {{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}};

        int[][] res = reconstructQueue(people);

        return;

    }
}
