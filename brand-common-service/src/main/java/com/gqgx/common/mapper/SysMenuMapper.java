package com.gqgx.common.mapper;

import com.gqgx.common.entity.SysMenu;
import com.gqgx.common.entity.vo.SortableVo;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface SysMenuMapper extends Mapper<SysMenu> {
    int deleteByIds(Long[] ids);

    List<SysMenu> menuPowerList(Long positionId);

    List<SortableVo> sortableList();
}