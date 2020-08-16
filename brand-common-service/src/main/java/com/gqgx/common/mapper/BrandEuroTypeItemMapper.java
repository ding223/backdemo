package com.gqgx.common.mapper;

import com.gqgx.common.entity.BrandEuroTypeItem;
import tk.mybatis.mapper.common.Mapper;

public interface BrandEuroTypeItemMapper extends Mapper<BrandEuroTypeItem> {
    int deleteByIds(Long[] ids);
}