package algorithm.leetcode.strategie.dynamicP;

public class HouseRobber {

    //0-> no robber; 1-> robber
    public static int rob(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int[][] dp = new int[nums.length][2];
        if (nums.length == 1) return nums[0];
        dp[0][1] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][1], dp[i - 1][0]);
            dp[i][1] = dp[i - 1][0] + nums[i];
        }
        return Math.max(dp[nums.length - 1][1], dp[nums.length - 1][0]);

    }

    public static void main(String[] args) {
        int[] houses = {2, 7, 9, 3, 1};
        int[] houses2 ={1,2,3,1};
        System.out.println(rob(houses));
        System.out.println(rob(houses2));

    }
}
