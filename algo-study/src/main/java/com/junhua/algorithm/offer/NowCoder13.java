package com.junhua.algorithm.offer;


/**
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
 * 使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分，
 * 并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 */
public class NowCoder13 {

    static public void reOrderArray(int[] array) {

        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 1) {
                for (int j = i; j > 0; j--) {
                    if (array[j - 1] % 2 == 0) {
                        int t = array[j];
                        array[j] = array[j - 1];
                        array[j - 1] = t;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] array = {2, 4, 6, 1, 3, 5, 7};

        reOrderArray(array);
        return;
    }

}
