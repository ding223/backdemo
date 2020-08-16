package com.gqgx.common.mapper;

import com.gqgx.common.entity.SysMenuData;
import tk.mybatis.mapper.common.Mapper;

public interface SysMenuDataMapper extends Mapper<SysMenuData> {
    int deleteByIds(Long[] ids);
}