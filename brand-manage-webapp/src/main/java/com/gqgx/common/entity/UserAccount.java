package com.gqgx.common.entity;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public abstract class UserAccount extends SysUser {
    public abstract String getFullName();

    public abstract String getAccountName();

    public abstract String getMobile();

    public abstract String getEmail();

    public abstract String getStatus();

    public abstract List<App> getOpenedApps();

    public abstract Map<String, Object> getProperties();
}
