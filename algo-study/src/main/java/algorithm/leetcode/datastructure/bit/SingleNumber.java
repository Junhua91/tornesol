package algorithm.leetcode.datastructure.bit;

public class SingleNumber {


    static public int singleNumber(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length ; i++) {
            res = nums[i] ^ res;
        }
        return res;
    }

    static public void main(String[] args) {
        int[] nums = {4, 1, 2, 1, 2};
        System.out.println(singleNumber(nums));
    }
}
