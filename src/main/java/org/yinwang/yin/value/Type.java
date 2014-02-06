package org.yinwang.yin.value;

public class Type {

    public static boolean subtype(Value type1, Value type2) {
        if (type1 instanceof UnionType) {
            for (Value t : ((UnionType) type1).values) {
                if (!subtype(t, type2)) {
                    return false;
                }
            }
            return true;
        } else if (type2 instanceof UnionType) {
            return ((UnionType) type2).values.contains(type1);
        } else {
            return type1.equals(type2);
        }
    }


    public static final Value BOOL = new BoolType();
    public static final Value INT = new IntType();

}
