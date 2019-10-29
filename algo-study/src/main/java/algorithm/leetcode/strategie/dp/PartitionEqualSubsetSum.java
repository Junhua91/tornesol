package algorithm.leetcode.strategie.dp;

public class PartitionEqualSubsetSum {

    static public boolean canPartition(int[] nums) {

        if (nums == null || nums.length == 0) return false;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        if ((sum & 1) != 0) return false;

        int target = sum / 2;
        boolean dp[] = new boolean[target + 1];
        dp[0] = true;

        for (int num : nums) {
            for (int i = target; i >= num; i--) {
                dp[i] = dp[i] || dp[i - num];
            }
        }

        return dp[target];
    }


    static public boolean canPartition2(int[] nums) {
        if (nums == null || nums.length == 0) return false;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        if ((sum & 1) != 0) return false;
        int target = sum / 2;
        int m = nums.length;
        int n = target;
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            int weight = nums[i - 1];
            for (int j = 1; j <= n; j++) {

                if (j < weight) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j - weight] + weight, dp[i - 1][j]);
                }
            }
        }
        return dp[m][n] == target;
    }

    static public boolean canPartition3(int[] nums) {
        if (nums == null || nums.length == 0) return false;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        if ((sum & 1) != 0) return false;
        int target = sum / 2;
        int m = nums.length;
        int n = target;

        int[] dp = new int[n + 1];
        for (int i = 1; i <= m; i++) {
            int weight = nums[i - 1];
            for (int j = target; j >= 1; j--) {
                if (j >= weight) {
                    dp[j] = Math.max(dp[j], dp[j - weight] + weight);
                }
            }
        }
        return dp[n] == target;
    }

    public static void main(String[] args) {
        int[] nums = {2, 2, 3, 5};
        int[] nums2 = {1, 5, 11, 5};
        int[] nums3 = {1, 1};
        System.out.println(canPartition2(nums));
        System.out.println(canPartition3(nums));
        System.out.println(canPartition2(nums2));
        System.out.println(canPartition3(nums2));
        System.out.println(canPartition2(nums3));
        System.out.println(canPartition3(nums3));
    }
}
