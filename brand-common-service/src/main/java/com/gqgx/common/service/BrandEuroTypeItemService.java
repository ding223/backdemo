package com.gqgx.common.service;

import com.gqgx.common.criteria.Criteria;
import com.gqgx.common.entity.BrandEuroTypeItem;
import com.gqgx.common.entity.vo.BrandEuroTypeItemVo;
import com.gqgx.common.paging.LayuiPage;
import com.gqgx.common.paging.PagingResult;


public interface BrandEuroTypeItemService {

    BrandEuroTypeItem getBrandEuroTypeItem(Long id);

    int saveBrandEuroTypeItem(BrandEuroTypeItem brandEuroTypeItem);

    int deleteBrandEuroTypeItem(BrandEuroTypeItem brandEuroTypeItem);

    int deleteBrandEuroTypeItemByIds(Long[] ids);

    PagingResult<BrandEuroTypeItem> findBrandEuroTypeItem(Criteria criteria);
    
    PagingResult<BrandEuroTypeItem> findBrandEuroTypeItem(BrandEuroTypeItem item, LayuiPage page);

    PagingResult<BrandEuroTypeItem> findBrandEuroTypeItemList(BrandEuroTypeItemVo vo, LayuiPage page);
}