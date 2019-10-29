package algorithm.leetcode.strategie.dp;

public class ArithmeticSlices {

    static public int numberOfArithmeticSlices(int[] A) {
        int len = 2;
        int res = 0;
        for (int i = 2; i < A.length; i++) {
            if (A[i] - A[i - 1] == A[i - 1] - A[i - 2]) {
                len++;
            } else {
                if (len > 2) {
                    res += (len - 1) * (len - 2) / 2;
                    len = 2;
                }
            }
        }
        if (len > 2) {
            res += (len - 1) * (len - 2) / 2;
        }
        return res;
    }


    static public int numberOfArithmeticSlices2(int[] A) {
        int[] dp = new int[A.length];
        int res = 0;
        for (int i = 2; i < A.length; i++) {
            if (A[i] - A[i - 1] == A[i - 1] - A[i - 2]) {
                dp[i] = dp[i - 1] + 1;
            }
            res += dp[i];
        }
        return res;
    }

    public static void main(String[] args) {

        int[] A = {1, 2, 3, 4};
        System.out.println(numberOfArithmeticSlices(A));
    }


}
