package algorithm.leetcode.strategie.divide;

import java.util.Arrays;

public class FindSmallestLetterGreaterThanTarget {

    static public char nextGreatestLetter(char[] letters, char target) {

        Arrays.sort(letters);

        int l = 0;
        int h = letters.length - 1;

        while (l <= h) {
            int mid = l + (h - l) / 2;
            if (letters[mid] > target) {
                h = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return l < letters.length ? letters[l] : letters[0];
    }

    public static void main(String[] args) {
        char[] letters = {'c', 'f', 'j'};
        System.out.println(nextGreatestLetter(letters, 'j'));
    }


}
