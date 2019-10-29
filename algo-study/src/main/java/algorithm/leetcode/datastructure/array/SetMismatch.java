package algorithm.leetcode.datastructure.array;

public class SetMismatch {

    static public int[] findErrorNums(int[] nums) {


        if (nums == null || nums.length == 0) return new int[]{0};

        int[] count = new int[nums.length + 1];

        for (int i = 0; i < nums.length; i++) {
            count[nums[i]]++;
        }

        int repeatNum = 0;
        int miss = 0;

        for (int i = 1; i < count.length; i++) {
            if (count[i] > 1) repeatNum = i;
            else if (count[i] == 0) miss = i;
        }

        return new int[]{repeatNum, miss};
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 2, 4};

        int[] res = findErrorNums(nums);

        return;

    }
}
