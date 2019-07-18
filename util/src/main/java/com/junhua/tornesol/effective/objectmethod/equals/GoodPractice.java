package com.junhua.tornesol.effective.objectmethod.equals;

public class GoodPractice {

    private String attribute;

    @Override
    public boolean equals(Object obj) {
        //#1. 是否是对象的引用
        if (obj == this) return true;
        //#2. instance of: 是否是正确的类型
        if (!(obj instanceof GoodPractice)) return false;
        //#3. 属性判断
        GoodPractice goodPractice = (GoodPractice) obj;
        return goodPractice.attribute == attribute;
    }
}
