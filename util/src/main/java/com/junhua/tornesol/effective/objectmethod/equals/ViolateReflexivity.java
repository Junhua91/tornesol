package com.junhua.tornesol.effective.objectmethod.equals;


/**
 * A.equals(B) => B.equals(A)
 */
public class ViolateReflexivity {

    private String s;

    public ViolateReflexivity(String s) {
        this.s = s;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof ViolateReflexivity)
            return s.equalsIgnoreCase(
                    ((ViolateReflexivity) o).s);
        if (o instanceof String)
            return s.equalsIgnoreCase((String) o);
        return false;
    }

    //正确写法
//    @Override
//    public boolean equals(Object o) {
//        if (o instanceof ViolateReflexivity)
//            return s.equalsIgnoreCase(
//                    ((ViolateReflexivity) o).s);
//        return false;
//    }


    public static void main(String[] args) {
        ViolateReflexivity violateReflexivity = new ViolateReflexivity("reflexivity");
        String value = "reflexivity";
        System.out.println(violateReflexivity.equals(value));
        System.out.println(value.equals(violateReflexivity));
    }
}
