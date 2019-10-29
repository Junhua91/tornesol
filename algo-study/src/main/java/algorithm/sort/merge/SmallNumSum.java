package algorithm.sort.merge;


import com.junhua.algorithm.comparator.ComparatorUtils;

/**
 * 小数和：
 * <p>
 * 1、4、2、5、3
 * 1）1左边小于1的数为0 => 0
 * 2) 4左边小于4的数为1 => 1
 * 3) 2左边小于2的数为1 => 1
 * 4) 5左边小于5的数为1、4、2 => 1+4+2 = 7
 * 5) 3 左边小于3的数是 1、2 => 1+2 = 3
 * 6) 总和为 : 0+1+1+7+3 = 12
 */
public class SmallNumSum {


    /**
     * 时间复杂度O（n^2）
     *
     * @param nums
     * @return
     */
    public static int smallSum(int[] nums) {
        if (nums == null || nums.length < 2) return 0;
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] > nums[i]) {
                    res += nums[i];
                }
            }
        }
        return res;
    }

    /**
     * 归并排序的方式：O(n*log(n))
     *
     * @param nums
     * @return
     */
    public static int smallSum2(int[] nums) {
        if (nums == null || nums.length < 2) return 0;
        return sort(nums, 0, nums.length - 1);
    }

    public static int sort(int[] nums, int L, int R) {
        if (L == R) return 0;
        //>> 的优先级低于 +、-，这里一定要加上括号
        int M = L + ((R - L) >> 1);
        return sort(nums, L, M) +
                sort(nums, M + 1, R) +
                merge(nums, L, M, R);
    }


    public static int merge(int[] nums, int L, int M, int R) {
        int pLeft = L;
        int pRight = M + 1;
        int[] help = new int[R - L + 1];
        int index = 0;
        int res = 0;
        while (pLeft <= M && pRight <= R) {
            res += (nums[pLeft] < nums[pRight]) ? (R - pRight + 1) * nums[pLeft] : 0;
            help[index++] = (nums[pLeft] < nums[pRight]) ? nums[pLeft++] : nums[pRight++];
        }
        while (pLeft <= M) {
            help[index++] = nums[pLeft++];
        }
        while (pRight <= R) {
            help[index++] = nums[pRight++];
        }
        for (int i = 0; i < index; i++)
            nums[L + i] = help[i];
        return res;
    }

    public static void main(String[] args) throws Exception {
        int[] nums = ComparatorUtils.generateRandomArray(10, 50);
        for (int i = 0; i < 50000; i++) {
            int[] nums1 = ComparatorUtils.copyArray(nums);
            int[] nums2 = ComparatorUtils.copyArray(nums);
            if (smallSum(nums1) != smallSum2(nums2)) {
                throw new Exception("error");
            }
        }
        System.out.println("success");
        ComparatorUtils.printArray(nums);
    }
}
