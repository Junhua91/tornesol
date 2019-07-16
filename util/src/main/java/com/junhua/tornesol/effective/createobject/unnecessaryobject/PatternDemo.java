package com.junhua.tornesol.effective.createobject.unnecessaryobject;

import java.util.regex.Pattern;

public class PatternDemo {

    /**
     * 可以重复被使用
     */
    private static final Pattern ROMAN = Pattern.compile(
            "^(?=.)M*(C[MD]|D?C{0,3})"
                    + "(X[CL]|L?X{0,3})(I[XV]|V?I{0,3})$");

    static boolean isRomanNumeral (String s){
        return ROMAN.matcher(s).matches();
    }

    public static void main(String[] args) {
        System.out.println(isRomanNumeral("hello"));
    }
}
