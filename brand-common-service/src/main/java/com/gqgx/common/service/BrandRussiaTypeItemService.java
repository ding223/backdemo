package com.gqgx.common.service;

import com.gqgx.common.criteria.Criteria;
import com.gqgx.common.entity.BrandRussiaTypeItem;
import com.gqgx.common.paging.LayuiPage;
import com.gqgx.common.paging.PagingResult;


public interface BrandRussiaTypeItemService {

    BrandRussiaTypeItem getBrandRussiaTypeItem(Long id);

    int saveBrandRussiaTypeItem(BrandRussiaTypeItem brandRussiaTypeItem);

    int deleteBrandRussiaTypeItem(BrandRussiaTypeItem brandRussiaTypeItem);

    int deleteBrandRussiaTypeItemByIds(Long[] ids);

    PagingResult<BrandRussiaTypeItem> findBrandRussiaTypeItem(Criteria criteria);
    
    PagingResult<BrandRussiaTypeItem> findBrandRussiaTypeItem(BrandRussiaTypeItem item, LayuiPage page);
    
    BrandRussiaTypeItem findBrandRussiaTypeItemByLargeId(Long largeTypeId);
}