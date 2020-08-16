package com.gqgx.common.service.impl;

import com.gqgx.common.criteria.Criteria;
import com.gqgx.common.entity.RecordStatus;
import com.gqgx.common.entity.SysMenuOperation;
import com.gqgx.common.lang.Objects;
import com.gqgx.common.mapper.SysMenuOperationMapper;
import com.gqgx.common.paging.PagingResult;
import com.gqgx.common.service.SysMenuOperationService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

@org.springframework.stereotype.Service
public class SysMenuOperationServiceImpl implements SysMenuOperationService {

    @Autowired
    protected SysMenuOperationMapper mapper;


    @Override
    public SysMenuOperation getSysMenuOperation(Long id) {
        return mapper.selectByPrimaryKey(id);
    }

    @Override
    public int saveSysMenuOperation(SysMenuOperation sysMenuOperation) {

        int count = 0;
        if(!Objects.isEmpty(sysMenuOperation.getId())){
            count = mapper.updateByPrimaryKeySelective(sysMenuOperation);
        }else{
            sysMenuOperation.setRecordStatus(RecordStatus.ACTIVE);
            sysMenuOperation.setUpdateCount(0);
            sysMenuOperation.setCreateDate(new Date());
            count = mapper.insertSelective(sysMenuOperation);
        }
        return count;
    }

    @Override
    public int deleteSysMenuOperation(SysMenuOperation sysMenuOperation) {

        return mapper.deleteByPrimaryKey(sysMenuOperation);
    }

    @Override
    public int deleteSysMenuOperationByIds(Long[] ids) {

        return mapper.deleteByIds(ids);
    }

    @Override
    public PagingResult<SysMenuOperation> findSysMenuOperation(Criteria criteria) {
        return null;
    }
}