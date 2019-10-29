package algorithm.leetcode.strategie.math;

public class AddBinary {

    static public String addBinary(String a, String b) {
        int i = a.length() - 1;
        int j = b.length() - 1;
        int add = 0;
        StringBuilder sb = new StringBuilder();
        while ((i >= 0 || j >= 0)) {
            int ai = i < 0 ? 0 : a.charAt(i) - '0';
            int bj = j < 0 ? 0 : b.charAt(j) - '0';
            int sum = ai + bj + add;
            sb.append(sum % 2);
            add = sum / 2;
            i--;
            j--;
        }
        if (add == 1) sb.append(add);
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(addBinary("1010", "1011"));
        System.out.println(addBinary("11", "1"));
    }
}
