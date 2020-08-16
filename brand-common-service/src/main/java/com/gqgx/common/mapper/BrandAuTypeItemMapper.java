package com.gqgx.common.mapper;

import com.gqgx.common.entity.BrandAuTypeItem;
import tk.mybatis.mapper.common.Mapper;

public interface BrandAuTypeItemMapper extends Mapper<BrandAuTypeItem> {
    int deleteByIds(Long[] ids);
}