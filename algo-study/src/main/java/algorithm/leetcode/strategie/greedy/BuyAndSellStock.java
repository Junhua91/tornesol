package algorithm.leetcode.strategie.greedy;

public class BuyAndSellStock {

    public static void main(String[] args) {
        int[] nums = new int[]{7, 1, 5, 3, 6, 4};
        int[] nums1 = new int[]{1, 2, 3, 4, 5, 6};
        int[] nums2 = new int[]{7, 6, 5, 4, 3, 1};


        System.out.print(profiteMax(nums));
        System.out.print(profiteMax(nums1));
        System.out.print(profiteMax(nums2));
    }


    public static int profiteMax(int[] nums) {
        int benefit = 0;
        for (int i = 1; i < nums.length - 1; i++) {
            if (nums[i] > nums[i - 1]) {
                benefit += nums[i] - nums[i - 1];
            }
        }
        return benefit;
    }
}
