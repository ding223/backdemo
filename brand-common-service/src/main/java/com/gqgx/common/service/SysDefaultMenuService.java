package com.gqgx.common.service;

import com.gqgx.common.criteria.Criteria;
import com.gqgx.common.entity.SysDefaultMenu;
import com.gqgx.common.entity.SysUser;
import com.gqgx.common.paging.PagingResult;

public interface SysDefaultMenuService {
    SysDefaultMenu getSysDefaultMenu(Long id);

    int saveSysDefaultMenu(SysDefaultMenu sysDefaultMenu);

    int deleteSysDefaultMenu(SysDefaultMenu sysDefaultMenu);

    int deleteSysDefaultMenuByIds(Long[] ids);

    PagingResult<SysDefaultMenu> findSysDefaultMenu(Criteria criteria);

    SysDefaultMenu findByUser(SysUser user);

    public void saveSysDefaultMenu(SysUser sysUser);
}