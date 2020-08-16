package com.gqgx.common.service;

import com.gqgx.common.criteria.Criteria;
import com.gqgx.common.entity.SysLoginLog;
import com.gqgx.common.paging.PagingResult;


public interface SysLoginLogService {

    SysLoginLog getSysLoginLog(Long id);

    int saveSysLoginLog(SysLoginLog sysLoginLog);

    int deleteSysLoginLog(SysLoginLog sysLoginLog);

    int deleteSysLoginLogByIds(Long[] ids);

    PagingResult<SysLoginLog> findSysLoginLog(Criteria criteria);
}