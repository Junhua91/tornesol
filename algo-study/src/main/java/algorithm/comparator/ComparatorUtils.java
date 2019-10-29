package algorithm.comparator;


/**
 * 对数器，用于检查算法的是实现是否正确
 */
public class ComparatorUtils {

    public static int[] generateRandomArray(int limitSize, int limitValue) {
        int[] array = new int[(int) ((limitSize + 1) * Math.random())];
        int len = array.length;
        for (int i = 0; i < len; i++) {
            array[i] = (int) ((limitValue + 1) * Math.random() - (limitValue + 1) * Math.random());
        }
        return array;
    }

    public static int[] copyArray(int[] nums) {
        if (nums == null) return null;
        int[] newNums = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            newNums[i] = nums[i];
        }
        return newNums;
    }

    public static boolean isEqual(int[] array1, int[] array2) {
        if (array1 == null && array2 == null) return true;
        if (array1 == null || array2 == null) return false;
        if (array1.length != array2.length) return false;
        for (int i = 0; i < array1.length; i++) {
            if (array1[i] != array2[i]) return false;
        }
        return true;
    }

    public static void printArray(int[] nums) {
        if (nums == null) return;
        for (int i = 0; i < nums.length - 1; i++) {
            System.out.print(nums[i] + "、");
        }
        System.out.print(nums[nums.length - 1]);
    }
}
