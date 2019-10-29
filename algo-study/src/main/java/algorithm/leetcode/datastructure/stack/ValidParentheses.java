package algorithm.leetcode.datastructure.stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParentheses {

    public static boolean isValid(String s) {
        Map<Character, Character> characterMap = new HashMap<Character, Character>() {{
            put(')', '(');
            put(']', '[');
            put('}', '{');
        }};
        Stack<Character> stack = new Stack();
        char[] characterList = s.toCharArray();
        for (char c : characterList) {
            if (characterMap.containsKey(c)) {
                if (stack.isEmpty()) {
                    return false;
                }
                Character top = stack.peek();
                if (top.equals(characterMap.get(c))) {
                    stack.pop();
                } else {
                    return false;
                }
            } else {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {

        System.out.println(isValid("([)]"));
        System.out.println(isValid("{[]}"));
        System.out.println(isValid("(])"));
        System.out.println(isValid("()[]{}"));
    }


    public static boolean isValid2(String s) {

        if (s == null) return false;

        Map<Character, Character> map = new HashMap<Character, Character>() {{
            put('}', '{');
            put(']', '[');
            put(')', '(');
        }};

        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (map.containsKey(c)) {
                if (stack.isEmpty()) return false;
                Character top = stack.peek();
                if (top.equals(map.get(c))) {
                    stack.pop();
                } else return false;
            } else {
                stack.push(c);
            }
        }
        return stack.isEmpty();

    }

}
