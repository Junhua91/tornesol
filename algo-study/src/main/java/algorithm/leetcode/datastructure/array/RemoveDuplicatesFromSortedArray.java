package algorithm.leetcode.datastructure.array;

public class RemoveDuplicatesFromSortedArray {


    static public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int index = 0, cur = 0;
        while (cur < nums.length) {
            if (nums[index] == nums[cur]) {
                cur++;
                continue;
            }
            if (nums[index] != nums[cur] && cur - index > 1) {
                nums[index + 1] = nums[cur];
            }
            index++;
            cur++;
        }
        return index + 1;
    }

    public static void main(String[] args) {

        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int[] nums2 = {1, 2};
        int[] nums3 = {1,1, 2};

        int n = removeDuplicates(nums);
        int n2 = removeDuplicates(nums2);
        int n3 = removeDuplicates(nums3);

        return;


    }
}
