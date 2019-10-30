package com.junhua.algorithm.leetcode.strategie.sort;

import com.junhua.algorithm.comparator.ComparatorUtils;

import java.util.Arrays;

public class RelativeSortArray {


    /**
     * 时间复杂度：O(m*n + n*logn), 空间复杂度：O（1）
     *
     * @param arr1
     * @param arr2
     * @return
     */
    static public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int CUR;
        int L = 0;
        int LEN = arr1.length;
        for (int num : arr2) {
            CUR = L;
            while (CUR < LEN) {
                if (arr1[CUR] == num) {
                    swap(arr1, CUR, L++);
                }
                CUR++;
            }
        }
        if (L < LEN) {
            Arrays.sort(arr1, L, LEN);
        }
        return arr1;
    }

    /**
     * 时间复杂度：O(N)
     * @param arr1
     * @param arr2
     * @return
     */
    static public int[] relativeSortArray2(int[] arr1, int[] arr2) {
        int[] cntArray = new int[1001];
        for (int num : arr1) {
            cntArray[num]++;
        }
        int index = 0;
        for (int num : arr2) {
            while (cntArray[num] > 0) {
                arr1[index++] = num;
                cntArray[num]--;
            }
        }
        for (int i = 0; i < cntArray.length; i++) {
            while (cntArray[i]-- > 0) {
                arr1[index++] = i;
            }
        }
        return arr1;
    }

    static public void swap(int[] nums, int i, int j) {
        int a = nums[i];
        int b = nums[j];
        b = a ^ b;
        a = a ^ b;
        b = a ^ b;
        nums[i] = a;
        nums[j] = b;
    }

    public static void main(String[] args) {
        int[] array1 = {2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19};
        int[] array2 = {2, 1, 4, 3, 9, 6};

        relativeSortArray2(array1, array2);

        ComparatorUtils.printArray(array1);

    }
}
