package com.junhua.tornesol.effective.objectmethod.comparable;

import java.util.Comparator;


/**
 * 类前没有public， 表示是private package
 */
class PhoneNumber implements Comparable<PhoneNumber> {

    private int areaCode;
    private int prefix;
    private int number;

    private static final Comparator<PhoneNumber> phoneNumberComparator =
            Comparator.comparingInt(PhoneNumber::getAreaCode)
                    .thenComparingInt(PhoneNumber::getPrefix)
                    .thenComparingInt(PhoneNumber::getNumber);


    /**
     * 大于，小于,减号符号不推荐在compareTo中使用
     *
     * @param o
     * @return
     */
//    @Override
//    public int compareTo(PhoneNumber o) {
//        int result = Integer.compare(this.areaCode, o.areaCode);
//        if (result == 0) {
//            result = Integer.compare(this.prefix, o.prefix);
//            if (result == 0)
//                result = Integer.compare(this.number, o.number);
//        }
//        return result;
//    }


    /**
     * 使用Comparator：速度会慢
     *
     * @param o
     * @return
     */
    @Override
    public int compareTo(PhoneNumber o) {
        return phoneNumberComparator.compare(this, o);
    }

    public int getAreaCode() {
        return areaCode;
    }

    public int getPrefix() {
        return prefix;
    }

    public int getNumber() {
        return number;
    }
}
