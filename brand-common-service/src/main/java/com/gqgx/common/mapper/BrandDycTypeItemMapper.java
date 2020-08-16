package com.gqgx.common.mapper;

import com.gqgx.common.entity.BrandDycTypeItem;
import tk.mybatis.mapper.common.Mapper;

public interface BrandDycTypeItemMapper extends Mapper<BrandDycTypeItem> {
    int deleteByIds(Long[] ids);
}