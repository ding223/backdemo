package com.gqgx.common.service.impl;

import com.gqgx.common.criteria.Criteria;
import com.gqgx.common.entity.RecordStatus;
import com.gqgx.common.entity.SysPositionMenu;
import com.gqgx.common.entity.SysPositionOperation;
import com.gqgx.common.lang.Objects;
import com.gqgx.common.mapper.SysPositionMenuMapper;
import com.gqgx.common.mapper.SysPositionOperationMapper;
import com.gqgx.common.paging.PagingResult;
import com.gqgx.common.service.SysPositionMenuService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

@org.springframework.stereotype.Service
public class SysPositionMenuServiceImpl implements SysPositionMenuService {

    @Autowired
    protected SysPositionMenuMapper sysPositionMenuDAO;

    @Autowired
    protected SysPositionOperationMapper sysPositionOperationDAO;


    @Override
    public SysPositionMenu getSysPositionMenu(Long id) {
        return sysPositionMenuDAO.selectByPrimaryKey(id);
    }

    @Override
    public int saveSysPositionMenu(SysPositionMenu sysPositionMenu) {
        int count = 0;
        if(!Objects.isEmpty(sysPositionMenu.getId())){
            count = sysPositionMenuDAO.updateByPrimaryKeySelective(sysPositionMenu);
        }else{
            sysPositionMenu.setRecordStatus(RecordStatus.ACTIVE);
            sysPositionMenu.setUpdateCount(0);
            sysPositionMenu.setCreateDate(new Date());
            count = sysPositionMenuDAO.insertSelective(sysPositionMenu);
        }
        return count;
    }

    @Override
    public int deleteSysPositionMenu(SysPositionMenu sysPositionMenu) {
        return 0;
    }

    @Override
    public int deletePositionMenuByIds(Long menuId, Long[] positionIds) {
        return 0;
    }

    @Override
    public int deleteSysPositionMenuByIds(Long[] ids) {
        return 0;
    }

    @Override
    public PagingResult<SysPositionMenu> findSysPositionMenu(Criteria criteria) {
        return null;
    }

    @Override
    public int savePostionPermisstion(Long postionId, List<SysPositionMenu> menus, List<SysPositionOperation> operations) {

        //删除原菜单权限
        SysPositionMenu sysPositionMenu = new SysPositionMenu();
        sysPositionMenu.setPositionId(postionId);
        sysPositionMenuDAO.delete(sysPositionMenu);

        if (!Objects.isEmpty(menus)) {
            for(SysPositionMenu menu:menus){
                this.saveSysPositionMenu(menu);
            }
        }

        SysPositionOperation sysPositionOperation = new SysPositionOperation();
        sysPositionOperation.setPositionId(postionId);
        sysPositionOperationDAO.delete(sysPositionOperation);
        if (!Objects.isEmpty(operations)) {
            for(SysPositionOperation op:operations){
                op.setRecordStatus(RecordStatus.ACTIVE);
                op.setUpdateCount(0);
                op.setCreateDate(new Date());
                sysPositionOperationDAO.insertSelective(op);
            }
        }
        return 0;
    }
}