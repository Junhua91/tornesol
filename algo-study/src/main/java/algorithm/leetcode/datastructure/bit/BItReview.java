package algorithm.leetcode.datastructure.bit;

public class BItReview {

    public static void main(String[] args) {
        System.out.println(removeLastOne(3));
        System.out.println(getLastOne(3));

    }

    /**
     * n&(n-1) 移除最后一位1
     *
     * @param num
     * @return
     */
    public static int removeLastOne(int num) {
        return num & (num - 1);
    }

    /**
     * 取出最后一位1
     *
     * @param num
     * @return
     */
    public static int getLastOne(int num) {
        return num & (-num);
    }


    /**
     * 101 => 111
     * 101^111 => 010(求补码)
     *
     * @param num
     * @return
     */
    public static int getMask(int num) {
        int mask = 1 << 31;
        while ((num & mask) == 0) {
            mask >>>= 1;
        }
        return mask << 1 - 1;
    }

    /**
     * 反转一个数
     * 100110 => 011001
     *
     * @param n
     * @return
     */
    public static int reverseBit(int n) {

        int mask = 1 << 31;
        int res = 0;

        for (int i = 0; i < 32; i++) {
            res |= (n & mask);
            res <<= 1;
            mask >>>= 1;
        }

        return res;
    }

    /**
     * 统计1的个数
     *
     * @param num
     * @return
     */
    public static int[] countBits(int num) {

        int[] res = new int[num + 1];
        for (int i = 1; i <= num; i++) {
            res[i] = res[i & i - 1] + 1;
        }
        return res;
    }

}
