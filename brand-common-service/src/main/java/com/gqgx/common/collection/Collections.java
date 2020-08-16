package com.gqgx.common.collection;

import org.apache.commons.collections.CollectionUtils;

import java.lang.reflect.Array;
import java.util.Collection;

public abstract class Collections extends CollectionUtils {

    public static <T> T first(Collection<T> c) {
        return (T) (isNotEmpty(c) ? get(c, 0) : null);
    }

    public static <T> T[] toArray(Collection<T> c) {
        if (isEmpty(c)) {
            return null;
        }
        T t = first(c);
        Object[] tArray = (Object[]) Array.newInstance(t.getClass(), c.size());
        c.toArray(tArray);
        return (T[]) tArray;
    }
}