package com.gqgx.common.service;

import com.gqgx.common.criteria.Criteria;
import com.gqgx.common.entity.SysMenuData;
import com.gqgx.common.paging.PagingResult;

public interface SysMenuDataService {

    SysMenuData getSysMenuData(Long id);

    int saveSysMenuData(SysMenuData sysMenuData);

    int deleteSysMenuData(SysMenuData sysMenuData);

    int deleteSysMenuDataByIds(Long[] ids);

    PagingResult<SysMenuData> findSysMenuData(Criteria criteria);
}