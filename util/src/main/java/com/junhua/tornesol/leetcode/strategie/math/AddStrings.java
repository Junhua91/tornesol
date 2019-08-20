package com.junhua.tornesol.leetcode.strategie.math;

public class AddStrings {


    static public String addStrings(String num1, String num2) {


        int i = num1.length() - 1;
        int j = num2.length() - 1;
        int carry = 0;
        StringBuilder sb = new StringBuilder();

        while (i >= 0 || j >= 0) {

            int ai = (i < 0) ? 0 : num1.charAt(i--) - '0';
            int bj = (j < 0) ? 0 : num2.charAt(j--) - '0';
            int sum = ai + bj + carry;
            sb.append(sum % 10);
            carry = sum / 10;
        }

        if (carry > 0) sb.append(carry);

        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(addStrings("123", "986"));
    }
}
