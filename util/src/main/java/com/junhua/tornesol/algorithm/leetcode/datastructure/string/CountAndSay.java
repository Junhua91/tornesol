package com.junhua.tornesol.algorithm.leetcode.datastructure.string;

public class CountAndSay {

    static public String countAndSay(int n) {
        if (n == 1) return "1";
        String num = countAndSay(n - 1);
        int[] count = count(num);
        String res = say(count, num);
        return res;
    }


    static int[] count(String num) {
        int i = 0;
        int[] count = new int[num.length()];
        char[] sequence = num.toCharArray();
        while (i < sequence.length) {
            int j = i;
            while (j < sequence.length && sequence[i] == sequence[j]) {
                j++;
            }
            count[i] = j - i;
            i = j;
        }
        return count;
    }

    static String say(int[] count, String num) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < num.length(); i++) {
            int countNum = count[i];

            if (countNum != 0) {
                sb.append(countNum);
                sb.append(num.charAt(i));
            }

        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String res = countAndSay(1);
        String res2 = countAndSay(2);
        String res3 = countAndSay(3);
        String res4 = countAndSay(4);
        String res5 = countAndSay(5);
        String res6 = countAndSay(6);
        String res7 = countAndSay(7);
        String res8 = countAndSay(8);
        return;
    }
}
