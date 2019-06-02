package com.junhua.tornesol.util.leetcode.recursion;

import java.util.ArrayList;
import java.util.List;

public class ValidateParanthese {

    public static void main(String[] args) {

        List<String> result = new ArrayList<>();

        _gen("", 3, 3, result);

        result.forEach(p -> System.out.println(p));

    }

    public static void _gen(String sublist, int left, int right, List<String> result) {

        if (left == 0 && right == 0) {
            result.add(sublist);
            return;
        }

        if (left > 0) {
            _gen(sublist + "(", left-1, right, result);
        }

        if (right > left && right > 0) {
            _gen(sublist + ")", left, right-1, result);
        }

    }
}
