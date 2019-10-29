package algorithm.sort;

import com.junhua.algorithm.comparator.ComparatorUtils;

public class SortUtils {

    static public void swap(int[] nums, int i, int j) {
        int a = nums[i];
        int b = nums[j];
        b = a ^ b;
        a = a ^ b;
        b = a ^ b;
        nums[i] = a;
        nums[j] = b;
    }

    /**
     * 固定分割数： 返回等于区域的前一个数和后一个数
     *
     * @param nums
     * @param L
     * @param R
     * @return
     */
    static public int[] partition(int[] nums, int L, int R) {
        int target = nums[R];
        int LESS = L - 1;
        int C = L;
        int M = R;
        while (C < M) {
            if (nums[C] < target) {
                swap(nums, ++LESS, C++);
            } else if (nums[C] > target) {
                swap(nums, C, M--);
            } else C++;
        }
        return new int[]{LESS, M};
    }

    public static void merge(int[] nums, int L, int R) {
        int M = L + ((R - L) >> 1);
        int[] res = new int[R - L + 1];
        int index = 0;
        int pLeft = L;
        int pRight = M + 1;
        while (pLeft <= M && pRight <= R) {
            //可以做到保持稳定性：等于的时候取左边的数
            res[index++] = (nums[pLeft] <= nums[pRight]) ? nums[pLeft++] : nums[pRight++];
        }
        while (pLeft <= M) {
            res[index++] = nums[pLeft++];
        }
        while (pRight <= R) {
            res[index++] = nums[pRight++];
        }
        for (int i = 0; i < res.length; i++) {
            nums[L + i] = res[i];
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 6, 9, 4, 3};
        int[] nums2 = {1, 2, 6, 9, 4, 3};
        partition(nums1, 0, nums1.length - 1);
        ComparatorUtils.isEqual(nums1, nums2);
        return;
    }
}
