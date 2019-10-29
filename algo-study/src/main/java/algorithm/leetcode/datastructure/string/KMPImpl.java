package algorithm.leetcode.datastructure.string;

public class KMPImpl {


    public static int indexOf(String str1, String str2) {
        if (str1 == null || str2 == null || str1.length() < str2.length())
            return -1;

        if ("".equals(str2)) return 0;

        int[] next = getNext(str2);
        int len1 = str1.length();
        int len2 = str2.length();
        int iLeft = 0;
        int iRight = 0;

        while (iRight < len2 && iLeft < len1) {
            if (str1.charAt(iLeft) == str2.charAt(iRight)) {
                iLeft++;
                iRight++;
            } else if (next[iRight] == -1) {
                iLeft++;
            } else {
                iRight = next[iRight];
            }
        }
        if (iRight == len2) return iLeft - len2;
        return -1;
    }

    /**
     * @param p
     * @return
     */
    public static int[] getNext(String p) {

        if (p.length() == 1) return new int[]{-1};
        int[] next = new int[p.length()];
        next[0] = -1;
        next[1] = 0;
        int index = 2;
        int cnt = 0;

        while (index < p.length()) {
            if (p.charAt(index - 1) == p.charAt(cnt)) {
                next[index++] = ++cnt;
            } else if (cnt > 0) {
                cnt = next[cnt];
            } else {
                next[index++] = 0;
            }
        }
        return next;
    }

    public static void main(String[] args) {
        String hayStack = "hello";
        String hayStack2 = "aaaaa";
        String hayStack3 = "mississippi";
        String hayStack4 = "mississippi";
        String hayStack5 = "aaa";


        String needle = "ll";
        String needle2 = "aab";
        String needle3 = "issipi";
        String needle4 = "issip";
        String needle5 = "aaaa";

        int n1 = indexOf(hayStack, needle);
        int n2 = indexOf(hayStack2, needle2);
        int n3 = indexOf(hayStack3, needle3);
        int n4 = indexOf(hayStack4, needle4);
        int n5 = indexOf(hayStack5, needle5);

        return;
    }
}
