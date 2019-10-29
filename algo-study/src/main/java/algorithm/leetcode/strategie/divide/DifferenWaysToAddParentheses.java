package algorithm.leetcode.strategie.divide;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class DifferenWaysToAddParentheses {


    static public List<Integer> diffWaysToCompute(String input) {
        List<Integer> ret = new LinkedList<Integer>();
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '-' ||
                    input.charAt(i) == '*' ||
                    input.charAt(i) == '+') {
                String part1 = input.substring(0, i);
                String part2 = input.substring(i + 1);
                List<Integer> part1Ret = diffWaysToCompute(part1);
                List<Integer> part2Ret = diffWaysToCompute(part2);
                for (Integer p1 : part1Ret) {
                    for (Integer p2 : part2Ret) {
                        int c = 0;
                        switch (input.charAt(i)) {
                            case '+':
                                c = p1 + p2;
                                break;
                            case '-':
                                c = p1 - p2;
                                break;
                            case '*':
                                c = p1 * p2;
                                break;
                        }
                        ret.add(c);
                    }
                }
            }
        }
        if (ret.size() == 0) {
            ret.add(Integer.valueOf(input));
        }
        return ret;
    }


    static public List<Integer> diffWaysToCompute2(String input) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '+' || input.charAt(i) == '*' || input.charAt(i) == '-') {
                String left = input.substring(0, i);
                String right = input.substring(i + 1);
                List<Integer> leftList = diffWaysToCompute(left);
                List<Integer> rightList = diffWaysToCompute(right);
                for (int leftNode : leftList) {
                    for (int rightNode : rightList) {
                        if (input.charAt(i) == '+')
                            res.add(leftNode + rightNode);
                        else if (input.charAt(i) == '-')
                            res.add(leftNode - rightNode);
                        else
                            res.add(leftNode * rightNode);
                    }
                }
            }
        }
        if (res.size() == 0) res.add(Integer.valueOf(input));
        return res;
    }


    public static void main(String[] args) {
        List<Integer> res = diffWaysToCompute("2*3-4*5");
        List<Integer> res2 = diffWaysToCompute2("2*3-4*5");
        return;
    }
}
