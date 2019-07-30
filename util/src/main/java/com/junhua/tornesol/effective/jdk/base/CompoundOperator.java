package com.junhua.tornesol.effective.jdk.base;

/**
 * A compound assignment expression of the form E1 op= E2 is equivalent to E1 = (T)((E1) op (E2)),
 * where T is the type of E1, except that E1 is evaluated only once.
 */
public class CompoundOperator {

    public static void main(String[] args) {
        short x = 3;
        System.out.println(x += 4.6);
        //compile error
//        short res = 3 + 4.6;
    }
}
