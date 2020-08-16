package com.gqgx.common.mapper;

import com.gqgx.common.entity.BrandUsaTypeItem;
import tk.mybatis.mapper.common.Mapper;

public interface BrandUsaTypeItemMapper extends Mapper<BrandUsaTypeItem> {
    int deleteByIds(Long[] ids);
}