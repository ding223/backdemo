package com.gqgx.common.service;

import com.gqgx.common.criteria.Criteria;
import com.gqgx.common.entity.SysMenu;
import com.gqgx.common.entity.SysMenuTreeVO;
import com.gqgx.common.entity.vo.NodeTreeVo;
import com.gqgx.common.entity.vo.SortableVo;
import com.gqgx.common.paging.PagingResult;

import java.util.List;


public interface SysMenuService {

    SysMenu getSysMenu(Long id);

    int saveSysMenu(SysMenu sysMenu);

    int deleteSysMenu(SysMenu sysMenu);

    int deleteSysMenuByIds(Long[] ids);

    PagingResult<SysMenu> findSysMenu(Criteria criteria);

    public List<SysMenu> listAllMenus(Long companyId);

    public List<NodeTreeVo> findAll(Long companyId);

    public int saveOrUpdateMenu(SysMenu sysMenu);

    public int isExsit(SysMenu sysMenu);

    public List<SysMenuTreeVO> listAllMenuAndOperationByUserId(Long userId, Long companyId);

    List<SortableVo> sortableList();

    int maxSort();

    int reSortable(String ids);

    List<SysMenu> parList();

    List<SysMenu> menuLPowerist(Long positionId);
}