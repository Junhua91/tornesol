package algorithm.leetcode.strategie.twopoint;

import java.util.Arrays;
import java.util.List;

public class ReverseVowelsOfAString {

    static public String reverseVowels(String s) {

        List<Character> VOWELLIST = Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U');
        int start = 0;
        int end = s.length() - 1;

        char[] chars = s.toCharArray();

        while (start < end) {
            char c1 = chars[start];
            char c2 = chars[end];
            if (VOWELLIST.contains(c1) && VOWELLIST.contains(c2)) {
                chars[start] = c2;
                chars[end] = c1;
                start++;
                end--;
            } else if (!VOWELLIST.contains(c1) && !VOWELLIST.contains(c2)) {
                start++;
                end--;
            } else {
                if (VOWELLIST.contains(c1)) {
                    end--;
                } else {
                    start++;
                }
            }
        }
        return new String(chars);
    }

    static public String reverseVowels2(String s) {
        List<Character> VOWELLIST = Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U');
        char[] res = new char[s.length()];
        int start = 0;
        int end = s.length() - 1;
        while (start < end) {
            char c1 = s.charAt(start);
            char c2 = s.charAt(end);
            if (!VOWELLIST.contains(c1)) {
                res[start++] = c1;
            } else if (!VOWELLIST.contains(c2)) {
                res[end--] = c2;
            } else {
                res[start++] = c2;
                res[end--] = c1;
            }
        }
        return new String(res);
    }

    public static void main(String[] args) {
        String hell0 = "hello";

        System.out.println(reverseVowels(hell0));
        System.out.println(reverseVowels2(hell0));

    }
}
