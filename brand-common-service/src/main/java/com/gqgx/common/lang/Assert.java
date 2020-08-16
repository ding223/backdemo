package com.gqgx.common.lang;

import org.apache.commons.lang3.Validate;

public abstract class Assert
        extends Validate
{
    public static void noneNull(Object... objs)
    {
        Object[] arrayOfObject = objs;int j = objs.length;
        for (int i = 0; i < j; i++)
        {
            Object obj = arrayOfObject[i];
            notNull(obj);
        }
    }
}
