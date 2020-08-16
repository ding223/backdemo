package com.gqgx.common.service.impl;

import com.gqgx.common.criteria.Criteria;
import com.gqgx.common.entity.RecordStatus;
import com.gqgx.common.entity.SysMenuData;
import com.gqgx.common.lang.Objects;
import com.gqgx.common.mapper.SysMenuDataMapper;
import com.gqgx.common.paging.PagingResult;
import com.gqgx.common.service.SysMenuDataService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

@org.springframework.stereotype.Service
public class SysMenuDataServiceImpl implements SysMenuDataService {

    @Autowired
    protected SysMenuDataMapper mapper;


    @Override
    public SysMenuData getSysMenuData(Long id) {

        return mapper.selectByPrimaryKey(id);
    }

    @Override
    public int saveSysMenuData(SysMenuData sysMenuData) {
        int count = 0;
        if(!Objects.isEmpty(sysMenuData.getId())){
            count = mapper.updateByPrimaryKeySelective(sysMenuData);
        }else{
            sysMenuData.setRecordStatus(RecordStatus.ACTIVE);
            sysMenuData.setUpdateCount(0);
            sysMenuData.setCreateDate(new Date());
            count = mapper.insertSelective(sysMenuData);
        }
        return count;
    }

    @Override
    public int deleteSysMenuData(SysMenuData sysMenuData) {

        return mapper.deleteByPrimaryKey(sysMenuData);
    }

    @Override
    public int deleteSysMenuDataByIds(Long[] ids) {

        return mapper.deleteByIds(ids);
    }

    @Override
        public PagingResult<SysMenuData> findSysMenuData(Criteria criteria) {
        return null;
    }
}