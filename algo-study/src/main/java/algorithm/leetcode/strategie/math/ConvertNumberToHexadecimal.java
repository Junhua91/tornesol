package algorithm.leetcode.strategie.math;

public class ConvertNumberToHexadecimal {


    static public String toHex(int num) {
        if (num == 0) return "0";
        char[] hex = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        StringBuilder sb = new StringBuilder();
        while (num != 0) {
            sb.append(hex[num & 0xf]);
            num >>>= 4;
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(toHex(26));
        System.out.println(toHex(-1));
    }
}
