package algorithm.sort.normal;

import com.junhua.algorithm.sort.SortUtils;
import com.junhua.algorithm.comparator.ComparatorUtils;

import java.util.Arrays;

/**
 * 1. 时间复杂度O（n^2）,额外空间复杂度O(1)
 * 2. 稳定的：相等的元素，保持着原来的顺序
 */
public class BubbleSort {


    /**
     * 相邻元素的比较,一次将最大的元素冒泡到数组的最后
     *
     * @param nums
     * @return
     */
    static public int[] bubbleSort(int[] nums) {
        if (nums == null || nums.length < 2) return nums;
        for (int i = nums.length - 1; i >= 0; i--) {
            boolean flag = false;
            for (int j = 1; j <= i; j++) {
                if (nums[j - 1] > nums[j]) {
                    SortUtils.swap(nums, j - 1, j);
                    flag = true;
                }
            }
            if (!flag) break;
        }
        return nums;
    }


    /**
     * 1. 将最大的数沉到最下面
     * 2.  如果在一个比较周期里面没有任何一次比较，则数组已经拍好了序，没有必要再去做剩下的排序了
     *
     * @param nums
     */
    public static void bubbleSortReview(int[] nums) {
        for (int i = nums.length - 1; i >= 0; i--) {
            boolean flag = true;
            for (int j = 0; j < i; j++) {
                if (nums[j] > nums[j + 1]) {
                    SortUtils.swap(nums, j, j + 1);
                    flag = false;
                }
            }
            if (flag) break;
        }
    }


    public static void main(String[] args) {
        for (int i = 0; i < 10000; i++) {
            int[] randomNums = ComparatorUtils.generateRandomArray(10, 20);
            int[] newNums1 = ComparatorUtils.copyArray(randomNums);
            int[] newNums2 = ComparatorUtils.copyArray(randomNums);
            int[] newNums3 = ComparatorUtils.copyArray(randomNums);
            Arrays.sort(newNums1);
            bubbleSort(newNums2);
            bubbleSortReview(newNums3);
            if (!ComparatorUtils.isEqual(newNums1, newNums2)) {
                System.out.println("error");
                ComparatorUtils.printArray(randomNums);
                break;
            }

            if (!ComparatorUtils.isEqual(newNums1, newNums3)) {
                System.out.println("error");
                ComparatorUtils.printArray(randomNums);
                break;
            }
        }
        System.out.println("success");
    }

}
