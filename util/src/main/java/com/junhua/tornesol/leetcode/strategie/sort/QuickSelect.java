package com.junhua.tornesol.leetcode.strategie.sort;


/**
 * Quick select算法通常用来在未排序的数组中寻找第k小/第k大的元素。
 */
public class QuickSelect {

    public static int select(int[] elements, int k, int start, int end) {
        int pivotIndex = getPivotByPartition(elements, start, end);
        if (k == pivotIndex - start + 1) {
            return elements[pivotIndex];
        } else if (k < pivotIndex - start + 1) {
            return select(elements, k, start, pivotIndex-1);
        } else {
            return select(elements, k - (pivotIndex - start + 1), pivotIndex+1, end);
        }
    }

    /**
     * 选取第一个数为pivot，然后调整数组的顺序：pivot左边的数均小于pivot；右边的均大于pivot
     *
     * @param elements
     * @param start
     * @param end
     * @return
     */
    private static int getPivotByPartition(int[] elements, int start, int end) {
        int pivot = elements[start];
        int index = start;
        for (int i = start; i <= end; i++) {
            if (elements[i] < pivot) {
                index++;
                int temp = elements[i];
                elements[i] = elements[index];
                elements[index] = temp;
            }
        }
        elements[start] = elements[index];
        elements[index] = pivot;
        return index;
    }


    public static void main(String[] args) {
        int arr[] = {7, 10, 4, 3, 20, 15};

        int kthElement = select(arr, 5, 0, arr.length - 1);
        System.out.println("kthElement=" + kthElement);

    }

}
