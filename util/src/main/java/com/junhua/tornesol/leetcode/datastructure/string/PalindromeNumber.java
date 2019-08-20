package com.junhua.tornesol.leetcode.datastructure.string;

public class PalindromeNumber {


    static public boolean isPalindrome(int x) {

        if (x == 0) return true;

        String s = String.valueOf(x);

        int start = 0;
        int end = s.length() - 1;

        while (start <= end) {
            if (s.charAt(start) != s.charAt(end)) return false;
            start++;
            end--;
        }
        return true;
    }

    static public boolean isPalindrome2(int x) {

        if (x == 0) return true;
        if (x < 0) return false;

        int reverseInt = reverseInt(x);
        return reverseInt == x;

    }

    static public int reverseInt(int x) {
        if (x == 0) return 0;
        int result = 0;
        while (x > 0) {
            result = result * 10 + x % 10;
            x = x / 10;
        }
        return result;
    }


    public static void main(String[] args) {
        int a = 123;

        System.out.println(isPalindrome2(a));
        System.out.println(isPalindrome2(121));
        System.out.println(isPalindrome2(-121));

        System.out.println(reverseInt(121));
    }
}
