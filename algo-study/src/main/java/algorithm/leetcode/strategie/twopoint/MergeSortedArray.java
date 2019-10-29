package algorithm.leetcode.strategie.twopoint;

public class MergeSortedArray {

    static public void merge(int[] nums1, int m, int[] nums2, int n) {

        int p1 = 0, p2 = 0;
        int[] res = new int[m + n];
        int index = 0;
        while (p1 < m && p2 < n) {
            if (nums1[p1] < nums2[p2]) {
                res[index++] = nums1[p1++];
            } else res[index++] = nums2[p2++];
        }
        if (p1 == m) {
            for (int i = p2; i < n; i++) {
                res[index++] = nums2[i];
            }
        } else {
            for (int i = p1; i < m; i++) {
                res[index++] = nums1[i];
            }
        }
        return;
    }

    static public void merge2(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1;
        int p2 = n - 1;
        int index = n + m - 1;
        while (p1 >= 0 || p2 >= 0) {
            if (p1 < 0) {
                nums1[index--] = nums2[p2--];
            } else if (p2 < 0) {
                nums1[index--] = nums1[p1--];
            } else if (nums1[p1] > nums2[p2]) {
                nums1[index--] = nums1[p1--];
            } else {
                nums1[index--] = nums2[p2--];
            }
        }
        return;
    }


    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {2, 5, 6};

        merge2(nums1, 3, nums2, 3);
    }
}
