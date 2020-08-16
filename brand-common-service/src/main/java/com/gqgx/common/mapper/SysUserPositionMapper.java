package com.gqgx.common.mapper;

import com.gqgx.common.entity.SysUserPosition;
import tk.mybatis.mapper.common.Mapper;

public interface SysUserPositionMapper extends Mapper<SysUserPosition> {
    int deleteByIds(Long[] ids);
}