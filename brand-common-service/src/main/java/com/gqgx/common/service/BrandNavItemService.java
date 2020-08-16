package com.gqgx.common.service;

import com.gqgx.common.criteria.Criteria;
import com.gqgx.common.entity.BrandNavItem;
import com.gqgx.common.paging.LayuiPage;
import com.gqgx.common.paging.PagingResult;

import java.util.List;


public interface BrandNavItemService {

    BrandNavItem getBrandNavItem(Long id);

    int saveBrandNavItem(BrandNavItem brandNavItem);

    int deleteBrandNavItem(BrandNavItem brandNavItem);

    int deleteBrandNavItemByIds(Long[] ids);

    PagingResult<BrandNavItem> findBrandNavItem(Criteria criteria);
    
    List<BrandNavItem> findBrandNavItemList(BrandNavItem item);
    
    PagingResult<BrandNavItem> findBrandNavItem(BrandNavItem item, LayuiPage page);
    
    int getMaxSeq();
}