package algorithm.leetcode.strategie.divide;

public class Sqrt {

    static public int mySqrt(int x) {
        if (x <= 1) return x;
        int start = 1;
        int end = x;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            int sqrt = x / mid;
            if (sqrt == mid) return sqrt;
            else if (sqrt > mid) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return end;
    }


    /**
     * 带浮点数
     *
     * @param x
     * @return
     */
    static public float mySqrt2(int x) {
        if (x <= 1) return x;
        float l = 1;
        float h = x;
        float mid = l + (h - l) / 2;
        while (Math.abs(mid * mid - x) > 0.1) {
            if (mid * mid < x) {
                l = mid;
            } else {
                h = mid;
            }
            mid = l + (h - l) / 2;
        }
        return mid;
    }

    public static void main(String[] args) {
        System.out.println(mySqrt2(5));
        System.out.println(mySqrt2(4));
        System.out.println(mySqrt2(8));
    }

}
