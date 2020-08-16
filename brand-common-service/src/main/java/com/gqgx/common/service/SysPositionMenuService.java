package com.gqgx.common.service;

import com.gqgx.common.criteria.Criteria;
import com.gqgx.common.entity.SysPositionMenu;
import com.gqgx.common.entity.SysPositionOperation;
import com.gqgx.common.paging.PagingResult;

import java.util.List;


public interface SysPositionMenuService {

    SysPositionMenu getSysPositionMenu(Long id);

    int saveSysPositionMenu(SysPositionMenu sysPositionMenu);

    int deleteSysPositionMenu(SysPositionMenu sysPositionMenu);
    //删除菜单下的权限
    int deletePositionMenuByIds(Long menuId, Long[] positionIds);

    int deleteSysPositionMenuByIds(Long[] ids);

    PagingResult<SysPositionMenu> findSysPositionMenu(Criteria criteria);

    public int savePostionPermisstion(Long postionId, List<SysPositionMenu> menus, List<SysPositionOperation> operations);
}