package com.gqgx.common.mapper;

import com.gqgx.common.entity.BrandNavItem;
import tk.mybatis.mapper.common.Mapper;

public interface BrandNavItemMapper extends Mapper<BrandNavItem> {
    int deleteByIds(Long[] ids);
}