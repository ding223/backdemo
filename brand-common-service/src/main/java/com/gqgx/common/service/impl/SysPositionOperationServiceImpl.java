package com.gqgx.common.service.impl;

import com.gqgx.common.criteria.Criteria;
import com.gqgx.common.entity.SysPositionOperation;
import com.gqgx.common.mapper.SysPositionOperationMapper;
import com.gqgx.common.paging.PagingResult;
import com.gqgx.common.service.SysPositionOperationService;
import org.springframework.beans.factory.annotation.Autowired;

@org.springframework.stereotype.Service
public class SysPositionOperationServiceImpl implements SysPositionOperationService {

    @Autowired
    protected SysPositionOperationMapper sysPositionOperationDAO;


    @Override
    public SysPositionOperation getSysPositionOperation(Long id) {
        return null;
    }

    @Override
    public int saveSysPositionOperation(SysPositionOperation sysPositionOperation) {
        return 0;
    }

    @Override
    public int deleteSysPositionOperation(SysPositionOperation sysPositionOperation) {
        return 0;
    }

    @Override
    public int deleteSysPositionOperationByIds(Long[] ids) {
        return 0;
    }

    @Override
    public PagingResult<SysPositionOperation> findSysPositionOperation(Criteria criteria) {
        return null;
    }
}