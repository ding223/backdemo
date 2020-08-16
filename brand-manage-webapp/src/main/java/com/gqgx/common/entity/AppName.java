package com.gqgx.common.entity;

import com.gqgx.common.lang.Assert;
import com.gqgx.common.lang.Throwables;

public enum AppName
{
    AN(

            " admin platform", "10"),  CT(

        " client platform", "20"),  SE(

        " SERVICE platform", "30"),  DK(

        " DISPARK platform", "40");

    private String appcode;
    private String appdesc;

    private AppName(String desc, String appcode)
    {
        this.appdesc = desc;
        this.appcode = appcode;
    }

    public String toString()
    {
        return this.appdesc;
    }

    public String getCode()
    {
        return this.appcode;
    }

    public static AppName byCode(String str)
    {
        Assert.notNull(str);
        str = str.trim();
        if (str.equals("10")) {
            return AN;
        }
        if (str.equals("20")) {
            return CT;
        }
        if (str.equals("30")) {
            return SE;
        }
        if (str.equals("40")) {
            return DK;
        }
        throw Throwables.makeThrow("Can't Found Code Of Mapping AppName", new Object[0]);
    }
}
