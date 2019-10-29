package algorithm.leetcode.datastructure.bit;


import java.util.HashMap;
import java.util.Map;

/**
 * >>>: 无符号右移，左边补0
 * >>:  带符号右移，正数时左边补0；负数时，左边补1
 */
public class ReverseBits {

    static public int reverseBits(int n) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            //
            res <<= 1;
            res = res | n & 1;
            n >>= 1;
        }
        return res;
    }

    static public int reverseBits2(int n) {
        int res = 0;
        for (int i = 0; i < 4; i++) {
            res <<= 8;
            byte b = (byte) ((n >>> (i * 8)) & 0xFF);
            res |= reverseByte(b);

        }
        return res;
    }

    /**
     * 缓存byte，是想让缓存尽可能小。如果缓存的是int，那需要缓存的数就比较多
     *
     * @param b
     * @return
     */
    static public int reverseByte(byte b) {
        Map<Byte, Integer> map = new HashMap<>();
        if (map.containsKey(b)) return map.get(b);
        int res = 0;

        for (int i = 0; i < 8; i++) {
            res <<= 1;
            res = res | (b & 1);
            b >>>= 1;
        }
        map.put(b, res);
        return res;
    }

    public static void main(String[] args) {
        System.out.println(reverseBits(43261596));
        System.out.println(reverseBits2(43261596));
        System.out.println(reverseBits(-2));
        System.out.println(reverseBits2(-2));

        System.out.println(-2 >>> 1);
        System.out.println(-2 >> 1);

        //不用额外变量，交换两个数
        int a = 1;
        int b = 2;
        a = a^a^b;
        System.out.println(a);
    }
}
