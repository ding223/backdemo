package com.gqgx.common.service;

import com.gqgx.common.criteria.Criteria;
import com.gqgx.common.entity.SysMenuOperation;
import com.gqgx.common.paging.PagingResult;


public interface SysMenuOperationService {

    SysMenuOperation getSysMenuOperation(Long id);

    int saveSysMenuOperation(SysMenuOperation sysMenuOperation);

    int deleteSysMenuOperation(SysMenuOperation sysMenuOperation);

    int deleteSysMenuOperationByIds(Long[] ids);

    PagingResult<SysMenuOperation> findSysMenuOperation(Criteria criteria);
}