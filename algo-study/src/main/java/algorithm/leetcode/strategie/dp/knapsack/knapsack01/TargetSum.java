package algorithm.leetcode.strategie.dp.knapsack.knapsack01;

public class TargetSum {

    static public int findTargetSumWays(int[] nums, int S) {
        if (nums == null || nums.length == 0) return 0;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        if (((S + sum)  % 2) == 1) return 0;
        int target = (S + sum) >> 1;
        int[] dp = new int[target + 1];
        int n = nums.length;
        dp[0] = 1;

        for (int i = 1; i <= n; i++) {
            int weight = nums[i - 1];
            for (int j = target; j >= weight; j--) {
                dp[j] = dp[j - weight] + dp[j];
            }
        }
        return dp[target];
    }

    public static void main(String[] args) {

        int[] nusm = {1};
        System.out.println(findTargetSumWays(nusm, 1));
    }
}
