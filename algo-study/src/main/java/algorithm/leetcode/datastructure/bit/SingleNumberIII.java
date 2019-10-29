package algorithm.leetcode.datastructure.bit;


/**
 * Let a and b be the two unique numbers
 * XORing all numbers gets you (a xor b)
 * (a xor b) must be non-zero otherwise they are equal
 * If bit_i in (a xor b) is 1, bit_i at a and b are different.
 * Find bit_i using the low bit formula m & -m
 * Partition the numbers into two groups: one group with bit_i == 1 and the other group with bit_i == 0.
 * a is in one group and b is in the other.
 * a is the only single number in its group.
 * b is also the only single number in its group.
 * XORing all numbers in a's group to get a
 * XORing all numbers in b's group to get b
 * Alternatively, XOR (a xor b) with a gets you b.
 */
public class SingleNumberIII {

    static public int[] singleNumber(int[] nums) {
        int res = 0;
        for (int num : nums) {
            res = res ^ num;
        }

        int diff = res & (-res);
        int[] result = new int[2];
        for (int num : nums) {
            if ((num & diff) >0) {
                result[0] = result[0] ^ num;
            } else {
                result[1] = result[1] ^ num;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 1, 3, 2, 5};
        int[]res = singleNumber(nums);
        return;
    }

}
