package com.gqgx.common.lang;

import com.gqgx.common.collection.Collections;
import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Map;

/**
 * Created by Hunter on 2020-06-23.
 */
public class Objects extends ObjectUtils
{
    public static String toString(Object object, ToStringStyle style)
    {
        return ReflectionToStringBuilder.toString(object, style);
    }

    public static boolean isEmpty(Object o)
    {
        if (o == null) {
            return true;
        }
        if (isCharSequence(o)) {
            return Strings.isEmpty((CharSequence)o);
        }
        if (isCollection(o)) {
            return Collections.isEmpty((Collection)Collection.class.cast(o));
        }
        if (isMap(o)) {
            return MapUtils.isEmpty((Map)Map.class.cast(o));
        }
        if (isArray(o)) {
            return Array.getLength(o) <= 0;
        }
        return false;
    }

    public static boolean isArray(Object o)
    {
        Class<?> t = o.getClass();
        return t.isArray();
    }

    public static boolean isMap(Object o)
    {
        return o instanceof Map;
    }

    public static boolean isCollection(Object o)
    {
        return o instanceof Collection;
    }

    public static boolean isCharSequence(Object o)
    {
        return o instanceof CharSequence;
    }
}