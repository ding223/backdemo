package com.gqgx.common.service;

import com.gqgx.common.criteria.Criteria;
import com.gqgx.common.entity.SysOperationLog;
import com.gqgx.common.paging.LayuiPage;
import com.gqgx.common.paging.PagingResult;


public interface SysOperationLogService {

    SysOperationLog getSysOperationLog(Long id);

    int saveSysOperationLog(SysOperationLog sysOperationLog);

    int deleteSysOperationLog(SysOperationLog sysOperationLog);

    int deleteSysOperationLogByIds(Long[] ids);

    PagingResult<SysOperationLog> findSysOperationLog(Criteria criteria);
    
    public PagingResult<SysOperationLog> findOperationLogList(SysOperationLog operationLog, LayuiPage page);
}