package com.gqgx.common.service;

import com.gqgx.common.criteria.Criteria;
import com.gqgx.common.entity.SysPositionOperation;
import com.gqgx.common.paging.PagingResult;


public interface SysPositionOperationService {

    SysPositionOperation getSysPositionOperation(Long id);

    int saveSysPositionOperation(SysPositionOperation sysPositionOperation);

    int deleteSysPositionOperation(SysPositionOperation sysPositionOperation);

    int deleteSysPositionOperationByIds(Long[] ids);

    PagingResult<SysPositionOperation> findSysPositionOperation(Criteria criteria);
}