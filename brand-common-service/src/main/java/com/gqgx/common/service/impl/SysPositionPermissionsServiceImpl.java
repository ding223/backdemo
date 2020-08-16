package com.gqgx.common.service.impl;

import com.gqgx.common.criteria.Criteria;
import com.gqgx.common.entity.SysPositionPermissions;
import com.gqgx.common.paging.PagingResult;
import com.gqgx.common.service.SysPositionPermissionsService;

import java.util.List;

@org.springframework.stereotype.Service
public class SysPositionPermissionsServiceImpl implements SysPositionPermissionsService {

    @Override
    public SysPositionPermissions getSysPositionPermissions(Long id) {
        return null;
    }

    @Override
    public int saveSysPositionPermissions(SysPositionPermissions sysPositionPermissions) {
        return 0;
    }

    @Override
    public int deleteSysPositionPermissions(SysPositionPermissions sysPositionPermissions) {
        return 0;
    }

    @Override
    public int deleteSysPositionPermissionsByIds(Long[] ids) {
        return 0;
    }

    @Override
    public PagingResult<SysPositionPermissions> findSysPositionPermissions(Criteria criteria) {
        return null;
    }

    @Override
    public List<SysPositionPermissions> findByPostions(Long positionId) {
        return null;
    }

    @Override
    public int deleteByPostionId(Long id) {
        return 0;
    }

    @Override
    public List<SysPositionPermissions> findByUserId(Long userId) {
        return null;
    }
}