package com.gqgx.common.service;

import com.gqgx.common.criteria.Criteria;
import com.gqgx.common.entity.SysPositionPermissions;
import com.gqgx.common.paging.PagingResult;

import java.util.List;

public interface SysPositionPermissionsService {

    SysPositionPermissions getSysPositionPermissions(Long id);

    int saveSysPositionPermissions(SysPositionPermissions sysPositionPermissions);

    int deleteSysPositionPermissions(SysPositionPermissions sysPositionPermissions);

    int deleteSysPositionPermissionsByIds(Long[] ids);

    PagingResult<SysPositionPermissions> findSysPositionPermissions(Criteria criteria);

    public List<SysPositionPermissions> findByPostions(Long positionId);

    int deleteByPostionId(Long id);

    List<SysPositionPermissions> findByUserId(Long userId);
}