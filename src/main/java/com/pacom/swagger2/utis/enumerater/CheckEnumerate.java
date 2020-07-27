package com.pacom.swagger2.utis.enumerater;

public interface CheckEnumerate<T> {
    default boolean is(T t) {
        return this.equals(t);
    }

    default boolean isNot(T t) {
        return !this.equals(t);
    }

    default boolean isNotIn(T... ts) {
        for (T t : ts) {
            if (this.equals(t)) {
                return false;
            }
        }
        return true;
    }

    default boolean isIn(T... ts) {
        for (T t : ts) {
            if (this.equals(t)) {
                return true;
            }
        }
        return false;
    }

}
