package algorithm.leetcode.strategie.dp.knapsack.entierknapsack;


/**
 * 完全背包：带顺序
 */
public class CombinationSumIV {

    static public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int j = 1; j <= target; j++) {
            for (int num : nums) {
                if (j >= num)
                    dp[j] = dp[j] + dp[j - num];
            }
        }
        return dp[target];
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        System.out.println(combinationSum4(nums, 4));
    }
}
