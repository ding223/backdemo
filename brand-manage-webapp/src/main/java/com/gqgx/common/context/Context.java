package com.gqgx.common.context;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Created by Hunter on 2020-06-28.
 */

public abstract interface Context
{
    public abstract void set(String paramString, Object paramObject);

    public abstract <T> T get(String paramString);

    public abstract Map<?, ?> getValuesMap();

    public abstract List<?> getValues();

    public abstract Iterator<?> valuesIterator();

    public abstract List<?> findValuesByREGEX(String paramString);
}
