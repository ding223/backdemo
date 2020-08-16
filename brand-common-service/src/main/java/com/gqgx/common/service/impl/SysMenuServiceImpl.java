package com.gqgx.common.service.impl;

import com.gqgx.common.criteria.Criteria;
import com.gqgx.common.entity.RecordStatus;
import com.gqgx.common.entity.SysMenu;
import com.gqgx.common.entity.SysMenuTreeVO;
import com.gqgx.common.entity.vo.NodeTreeVo;
import com.gqgx.common.entity.vo.SortableVo;
import com.gqgx.common.lang.Objects;
import com.gqgx.common.mapper.SysMenuMapper;
import com.gqgx.common.paging.PagingResult;
import com.gqgx.common.service.SysMenuService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

@org.springframework.stereotype.Service
public class SysMenuServiceImpl implements SysMenuService {

    @Autowired
    protected SysMenuMapper mapper;


    @Override
    public SysMenu getSysMenu(Long id) {

        return mapper.selectByPrimaryKey(id);
    }

    @Override
    public int saveSysMenu(SysMenu sysMenu) {
        int count = 0;
        if(!Objects.isEmpty(sysMenu.getId())){
            count = mapper.updateByPrimaryKeySelective(sysMenu);
        }else{
            sysMenu.setRecordStatus(RecordStatus.ACTIVE);
            sysMenu.setUpdateCount(0);
            sysMenu.setCreateDate(new Date());
            count = mapper.insertSelective(sysMenu);
        }
        return count;
    }

    @Override
    public int deleteSysMenu(SysMenu sysMenu) {

        return mapper.deleteByPrimaryKey(sysMenu);
    }

    @Override
    public int deleteSysMenuByIds(Long[] ids) {

        return mapper.deleteByIds(ids);
    }

    @Override
    public PagingResult<SysMenu> findSysMenu(Criteria criteria) {
        return null;
    }

    @Override
    public List<SysMenu> listAllMenus(Long companyId) {
        return null;
    }

    @Override
    public List<NodeTreeVo> findAll(Long companyId) {
        return null;
    }

    @Override
    public int saveOrUpdateMenu(SysMenu sysMenu) {
        return 0;
    }

    @Override
    public int isExsit(SysMenu sysMenu) {
        return 0;
    }

    @Override
    public List<SysMenuTreeVO> listAllMenuAndOperationByUserId(Long userId, Long companyId) {
        return null;
    }

    @Override
    public List<SortableVo> sortableList() {
        List<SortableVo> list = mapper.sortableList();
        return list;
    }

    @Override
    public int maxSort() {
        return 0;
    }

    @Override
    public int reSortable(String ids) {
        return 0;
    }

    @Override
    public List<SysMenu> parList() {
        return null;
    }

    @Override
    public List<SysMenu> menuLPowerist(Long positionId) {
        return mapper.menuPowerList(positionId);
    }
}