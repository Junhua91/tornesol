package com.junhua.tornesol.offer;


/**
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
 * 如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
 */
public class NowCoder22 {

    static public boolean VerifySquenceOfBST(int[] sequence) {
        if (sequence == null || sequence.length == 0) return false;
        int start = 0, end = sequence.length - 1;
        return find(sequence, start, end);
    }

    static public boolean find(int[] sequence, int start, int end) {
        if (start >= end) return true;
        int mid = sequence[end];
        int index = start;

        //找到第一个大于mid的数
        while (sequence[index] < mid) index++;
        if (index == end) return true;
        //判断右边的数是否都大于mid
        for (int i = index; i <= end; i++) {
            if (sequence[i] < mid) return false;
        }
        boolean isLeftValid = find(sequence, start, index - 1);
        boolean isRightValid = find(sequence, index, end - 1);
        return isRightValid && isLeftValid;
    }

    public static void main(String[] args) {
//        int[] nums = {2, 4, 3, 6, 8, 7, 5};
        int[] nums2 = {2, 4};
//        System.out.println(VerifySquenceOfBST(nums));
        System.out.println(VerifySquenceOfBST(nums2));
    }

}
