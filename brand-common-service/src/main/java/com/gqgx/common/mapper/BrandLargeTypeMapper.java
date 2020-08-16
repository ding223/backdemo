package com.gqgx.common.mapper;

import com.gqgx.common.entity.BrandLargeType;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

public interface BrandLargeTypeMapper extends Mapper<BrandLargeType> {
    int deleteByIds(@Param("ids") Long[] ids);
}