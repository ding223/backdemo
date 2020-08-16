package com.gqgx.common.collection;

import org.apache.commons.collections.MapUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Maps
        extends MapUtils
{
    public static <K, V> Entry<K, V> first(Map<K, V> map)
    {
        if (isEmpty(map)) {
            return null;
        }
        return (Entry)map.entrySet().toArray()[0];
    }

    public static <V> V valueOfFirst(Map<?, V> map)
    {
        Entry<?, V> e = first(map);
        return (V)e.getValue();
    }

    public static <K, V> Map<K, V> newMap()
    {
        return new HashMap();
    }

    public static <K, V> Map<K, V> map(Object... keyValues)
    {
        if (keyValues!= null && (keyValues.length > 1))
        {
            Class<?> kClass = keyValues[0].getClass();
            Class<?> vClass = keyValues[1].getClass();
            return (Map<K, V>) map(kClass, vClass, keyValues);
        }
        return null;
    }

    public static <K, V> Map<K, V> map(Class<K> kClass, Class<V> vClass, Object... keyValues)
    {
        Map<K, V> m = newMap();
        Object preObj = null;
        Object[] arrayOfObject;
        int j = (arrayOfObject = keyValues).length;
        for (int i = 0; i < j; i++)
        {
            Object o = arrayOfObject[i];
            if (i % 2 == 0)
            {
                K k = kClass.cast(preObj);
                V v = vClass.cast(o);
                m.put(k, v);
            }
            preObj = o;
            i++;
        }
        return m;
    }

    public static Map<Object, Object> mapByAarray(Object... keyValues)
    {
        Map<Object, Object> m = newMap();
        Object key = null;
        Object[] arrayOfObject = keyValues;int j = keyValues.length;
        for (int i = 0; i < j; i++)
        {
            Object value = arrayOfObject[i];
            if (i % 2 == 0) {
                m.put(key, value);
            }
            key = value;
            i++;
        }
        return m;
    }
}