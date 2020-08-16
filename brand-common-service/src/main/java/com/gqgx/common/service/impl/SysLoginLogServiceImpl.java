package com.gqgx.common.service.impl;

import com.gqgx.common.criteria.Criteria;
import com.gqgx.common.entity.RecordStatus;
import com.gqgx.common.entity.SysLoginLog;
import com.gqgx.common.lang.Objects;
import com.gqgx.common.mapper.SysLoginLogMapper;
import com.gqgx.common.paging.PagingResult;
import com.gqgx.common.service.SysLoginLogService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

@org.springframework.stereotype.Service
public class SysLoginLogServiceImpl implements SysLoginLogService {

    @Autowired
    protected SysLoginLogMapper mapper;


    @Override
    public SysLoginLog getSysLoginLog(Long id) {

        return mapper.selectByPrimaryKey(id);
    }

    @Override
    public int saveSysLoginLog(SysLoginLog sysLoginLog) {

        int count = 0;
        if(!Objects.isEmpty(sysLoginLog.getId())){
            count = mapper.updateByPrimaryKeySelective(sysLoginLog);
        }else{
            //设置创建时间时间
            sysLoginLog.setRecordStatus(RecordStatus.ACTIVE);
            sysLoginLog.setUpdateCount(0);
            sysLoginLog.setCreateDate(new Date());
            count = mapper.insertSelective(sysLoginLog);
        }
        return count;

    }

    @Override
    public int deleteSysLoginLog(SysLoginLog sysLoginLog) {

        return mapper.deleteByPrimaryKey(sysLoginLog);
    }

    @Override
    public int deleteSysLoginLogByIds(Long[] ids) {
        return mapper.deleteByIds(ids);
    }

    @Override
    public PagingResult<SysLoginLog> findSysLoginLog(Criteria criteria) {
        return null;
    }
}