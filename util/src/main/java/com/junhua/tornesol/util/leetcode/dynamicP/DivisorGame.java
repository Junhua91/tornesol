package com.junhua.tornesol.util.leetcode.dynamicP;


/**
 * Alice and Bob take turns playing a game, with Alice starting first.
 * <p>
 * Initially, there is a number N on the chalkboard.  On each player's turn, that player makes a move consisting of:
 * <p>
 * Choosing any x with 0 < x < N and N % x == 0.
 * Replacing the number N on the chalkboard with N - x.
 * Also, if a player cannot make a move, they lose the game.
 * <p>
 * Return True if and only if Alice wins the game, assuming both players play optimally.
 */
public class DivisorGame {


    /**
     * 状态方程：相邻的两个元素之间肯定是相反的（一个赢，一个输）
     * @param N
     * @return
     */
    public static boolean divisorGame(int N) {
        if(N==1)return false;
        boolean[] f = new boolean[N+1];
        f[2] = true;
        for (int i = 3; i <= N; i++) {
            f[i] = !f[i - 1];
        }
        return f[N];
    }

    public static void main(String[]args){
        System.out.println(divisorGame(2));
        System.out.println(divisorGame(3));
        System.out.println(divisorGame(4));
        System.out.println(divisorGame(15));
    }
}
