package algorithm.leetcode;

public class BinarySearch {

    public static void main(String[] args) {

        int[] nums = new int[]{2, 5, 12, 23, 30, 35, 37, 40, 58};

        int left = 0;
        int right = nums.length - 1;

        int target = 35;

        while (left <= right) {

            int mid = (left + right) / 2;

            if (target == nums[mid]) {
                System.out.print(mid);
                break;
            }

            if (nums[mid] > target) {
                right = mid - 1;
            }

            if (nums[mid] < target) {
                left = mid + 1;
            }
        }
    }
}
