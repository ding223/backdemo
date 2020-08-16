package com.gqgx.common.service.impl;

import com.gqgx.common.criteria.Criteria;
import com.gqgx.common.entity.SysDefaultMenu;
import com.gqgx.common.entity.SysUser;
import com.gqgx.common.paging.PagingResult;
import com.gqgx.common.service.SysDefaultMenuService;

@org.springframework.stereotype.Service
public class SysDefaultMenuServiceImpl implements SysDefaultMenuService {

    @Override
    public SysDefaultMenu getSysDefaultMenu(Long id) {
        return null;
    }

    @Override
    public int saveSysDefaultMenu(SysDefaultMenu sysDefaultMenu) {
        return 0;
    }

    @Override
    public int deleteSysDefaultMenu(SysDefaultMenu sysDefaultMenu) {
        return 0;
    }

    @Override
    public int deleteSysDefaultMenuByIds(Long[] ids) {
        return 0;
    }

    @Override
    public PagingResult<SysDefaultMenu> findSysDefaultMenu(Criteria criteria) {
        return null;
    }

    @Override
    public SysDefaultMenu findByUser(SysUser user) {
        return null;
    }

    @Override
    public void saveSysDefaultMenu(SysUser sysUser) {

    }
}