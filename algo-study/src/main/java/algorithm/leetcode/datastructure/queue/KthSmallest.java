package algorithm.leetcode.datastructure.queue;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KthSmallest {

    private int size;
    Comparator<Integer> comp = (o1, o2) -> o2 - o1;
    private PriorityQueue<Integer> kthSmallest = new PriorityQueue<>(comp);

    public KthSmallest(int size, int[] nums) {
        this.size = size;
        for (int num : nums) {
            add(num);
        }
    }

    public int add(int num) {
        if (kthSmallest.size() < size) {
            kthSmallest.add(num);
        } else if (kthSmallest.peek() > num) {
            kthSmallest.remove();
            kthSmallest.add(num);
        }

        return kthSmallest.peek();
    }

    public static void main(String[] args) {
        KthSmallest kthSmallest = new KthSmallest(3, new int[]{2, 49, 6, 8, 9, 80});

        System.out.println(kthSmallest.add(100));
    }
}
