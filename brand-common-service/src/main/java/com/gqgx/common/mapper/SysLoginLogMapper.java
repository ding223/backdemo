package com.gqgx.common.mapper;

import com.gqgx.common.entity.SysLoginLog;
import tk.mybatis.mapper.common.Mapper;

public interface SysLoginLogMapper extends Mapper<SysLoginLog> {
    int deleteByIds(Long[] ids);
}