package com.gqgx.common.context;

import com.gqgx.common.collection.Maps;
import com.gqgx.common.entity.AppName;
import com.gqgx.common.entity.SysUser;
import com.gqgx.common.entity.UserAccount;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class SimpleInvocationContext
        implements InvocationContext, Serializable
{
    private static final long serialVersionUID = -5066658909073717994L;
    protected Map values = Maps.newMap();
    protected SysUser useraccount;
    protected AppName appname;

    public void set(String key, Object value)
    {
        this.values.put(key, value);
    }

    public <T> T get(String key)
    {
        return (T)this.values.get(key);
    }

    public Map<?, ?> getValuesMap()
    {
        return this.values;
    }

    public List<?> getValues()
    {
        return null;
    }

    public Iterator<?> valuesIterator()
    {
        return getValues().iterator();
    }

    public List<?> findValuesByREGEX(String regex)
    {
        return null;
    }

    public SysUser getUserAccout()
    {
        return this.useraccount;
    }

    public AppName getAppName()
    {
        return this.appname;
    }

    public static SimpleInvocationContext create(SysUser ua, AppName appName)
    {
        SimpleInvocationContext sc = new SimpleInvocationContext();
        sc.appname = appName;
        sc.useraccount = ua;
        InvocationContextHolder.setInvocationContext(sc);
        return sc;
    }
}
