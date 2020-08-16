package com.gqgx.common.lang;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.InvocationTargetException;

public class Throwables
{
    public static String getStackTrace(Throwable throwable)
    {
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw, true);
        throwable.printStackTrace(pw);
        return sw.getBuffer().toString();
    }

    public static ComboException comboThrow(Throwable... es)
    {
        ComboException ce = new ComboException();
        Throwable[] arrayOfThrowable = es;int j = es.length;
        for (int i = 0; i < j; i++)
        {
            Throwable e = arrayOfThrowable[i];
            ce.add(e);
        }
        return ce;
    }

    public static RuntimeException noImplement()
    {
        return new RuntimeException("Not implement yet!");
    }

    public static RuntimeException impossible()
    {
        return new RuntimeException("r u kidding me?! It is impossible!");
    }

    public static RuntimeException makeThrow(String format, Object... args)
    {
        return new RuntimeException(String.format(format, args));
    }

    public static RuntimeException wrapThrow(Throwable e, String fmt, Object... args)
    {
        return new RuntimeException(String.format(fmt, args), e);
    }

    public static RuntimeException wrapThrow(Throwable e)
    {
        if ((e instanceof RuntimeException)) {
            return (RuntimeException)e;
        }
        if ((e instanceof InvocationTargetException)) {
            return wrapThrow(((InvocationTargetException)e).getTargetException());
        }
        return new RuntimeException(e);
    }

    public static Throwable unwrapThrow(Throwable e)
    {
        if (e == null) {
            return null;
        }
        if ((e instanceof InvocationTargetException))
        {
            InvocationTargetException itE = (InvocationTargetException)e;
            if (itE.getTargetException() != null) {
                return unwrapThrow(itE.getTargetException());
            }
        }
        if (((e instanceof RuntimeException)) && (e.getCause() != null)) {
            return unwrapThrow(e.getCause());
        }
        return e;
    }
}
