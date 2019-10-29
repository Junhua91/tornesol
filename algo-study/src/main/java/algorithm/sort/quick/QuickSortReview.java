package algorithm.sort.quick;

import com.junhua.algorithm.comparator.ComparatorUtils;
import com.junhua.algorithm.sort.SortUtils;

import java.util.Arrays;

import static com.junhua.algorithm.sort.SortUtils.*;

public class QuickSortReview {

    public static void quickSort(int[] nums, int L, int R) {
        if (L >= R) return;
        int[] partitionXY = SortUtils.partition(nums, L, R);
        quickSort(nums, 0, partitionXY[0]);
        quickSort(nums, partitionXY[1], R);
    }

    //
    public static void quickSortRandom(int[] nums, int L, int R) {
        if (L >= R) return;
        int randomIndex = L + (int) ((R - L + 1) * Math.random());
        SortUtils.swap(nums,R,randomIndex);
        int[] partitionXY = partition(nums, L, R);
        quickSortRandom(nums, 0, partitionXY[0]);
        quickSortRandom(nums, partitionXY[1], R);
    }

    public static void main(String[] args) throws Exception {
        for (int i = 0; i < 50000; i++) {
            int[] nums = ComparatorUtils.generateRandomArray(100, 50);
            int[] nums1 = ComparatorUtils.copyArray(nums);
            int[] nums2 = ComparatorUtils.copyArray(nums);
            int[] nums3 = ComparatorUtils.copyArray(nums);
//            quickSort(nums3, 0, nums1.length - 1);
            quickSortRandom(nums3, 0, nums1.length - 1);
            Arrays.sort(nums2);
            if (!ComparatorUtils.isEqual(nums3, nums2)) {
                ComparatorUtils.printArray(nums);
                throw new Exception("error");
            }
        }
        System.out.println("success");
    }

}
