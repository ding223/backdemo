package com.gqgx.common.mapper;

import com.gqgx.common.entity.BrandSmallType;
import tk.mybatis.mapper.common.Mapper;

public interface BrandSmallTypeMapper extends Mapper<BrandSmallType> {
    int deleteByIds(Long[] ids);
}