package algorithm.leetcode.strategie.dynamicP;

public class MaxProductSubArray {


    public static int max(int a, int b) {
        return a > b ? a : b;
    }

    public static int max(int a, int b, int c) {
        return max(c, max(a, b));
    }

    public static int min(int a, int b) {
        return a > b ? b : a;
    }

    public static int min(int a, int b, int c) {
        return min(min(a, b), c);
    }


    public static int maxProduct(int[] nums) {

        int[] MAX = new int[nums.length];
        int[] MIN = new int[nums.length];
        MAX[0] = nums[0];
        MIN[0] = nums[0];
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            MAX[i] = max(MAX[i - 1] * nums[i], MIN[i - 1] * nums[i], nums[i]);
            MIN[i] = min(MAX[i - 1] * nums[i], MIN[i - 1] * nums[i], nums[i]);
            res = max(res, MAX[i]);
        }
        return res;
    }


    public static int maxProduct2(int[] nums) {

        int MAX = nums[0];
        int MIN = nums[0];
        int RES = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int tem = MAX;
            MAX = max(MAX * nums[i], MIN * nums[i], nums[i]);
            MIN = min(tem * nums[i], MIN * nums[i], nums[i]);
            RES = max(RES, MAX);
        }
        return RES;
    }


    public static void main(String[] args) {
        int[] nums = {-4, -3, -2};
//        int[] nums2 = {-2};
        System.out.println(maxProduct2(nums));
//        System.out.println(maxProduct2(nums2));
    }

}
