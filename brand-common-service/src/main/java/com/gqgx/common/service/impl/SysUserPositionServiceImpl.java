package com.gqgx.common.service.impl;

import com.gqgx.common.criteria.Criteria;
import com.gqgx.common.entity.RecordStatus;
import com.gqgx.common.entity.SysUserPosition;
import com.gqgx.common.lang.Objects;
import com.gqgx.common.mapper.SysUserPositionMapper;
import com.gqgx.common.paging.PagingResult;
import com.gqgx.common.service.SysUserPositionService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

@org.springframework.stereotype.Service
public class SysUserPositionServiceImpl implements SysUserPositionService {

    @Autowired
    protected SysUserPositionMapper mapper;

    @Override
    public SysUserPosition getSysUserPosition(Long id) {
        return mapper.selectByPrimaryKey(id);
    }

    @Override
    public int saveSysUserPosition(SysUserPosition sysUserPosition) {
        int count = 0;
        if (!Objects.isEmpty(sysUserPosition.getId())) {
            count = mapper.updateByPrimaryKeySelective(sysUserPosition);
        } else {
            sysUserPosition.setRecordStatus(RecordStatus.ACTIVE);
            sysUserPosition.setUpdateCount(0);
            sysUserPosition.setCreateDate(new Date());
            count = mapper.insertSelective(sysUserPosition);
        }
        return count;
    }

    @Override
    public int deleteSysUserPosition(SysUserPosition sysUserPosition) {
        return mapper.deleteByPrimaryKey(sysUserPosition);
    }

    @Override
    public int deleteSysUserPositionByIds(Long[] ids) {
        return mapper.deleteByIds(ids);
    }

    @Override
    public PagingResult<SysUserPosition> findSysUserPosition(Criteria criteria) {
        return null;
    }

    @Override
    public int updateUserPosition(SysUserPosition sysUserPosition) {
        return 0;
    }

    @Override
    public int delPositionByUserids(Long[] userIds) {
        return 0;
    }

    @Override
    public int deleteUserPosition(Long positionId, Long[] userId) {
        return 0;
    }

    @Override
    public List<SysUserPosition> findByUserId(Long userId) {
        return null;
    }
}