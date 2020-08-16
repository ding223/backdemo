package com.gqgx.common.mapper;

import com.gqgx.common.entity.SysMenuOperation;
import tk.mybatis.mapper.common.Mapper;

public interface SysMenuOperationMapper extends Mapper<SysMenuOperation> {
    int deleteByIds(Long[] ids);
}