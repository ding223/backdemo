package com.gqgx.common.service;

import com.gqgx.common.criteria.Criteria;
import com.gqgx.common.entity.BrandDycTypeItem;
import com.gqgx.common.entity.vo.BrandDycTypeItemVo;
import com.gqgx.common.paging.LayuiPage;
import com.gqgx.common.paging.PagingResult;


public interface BrandDycTypeItemService {

    BrandDycTypeItem getBrandDycTypeItem(Long id);

    int saveBrandDycTypeItem(BrandDycTypeItem brandDycTypeItem);

    int deleteBrandDycTypeItem(BrandDycTypeItem brandDycTypeItem);

    int deleteBrandDycTypeItemByIds(Long[] ids);

    PagingResult<BrandDycTypeItem> findBrandDycTypeItem(Criteria criteria);
    
    PagingResult<BrandDycTypeItem> findBrandDycTypeItem(BrandDycTypeItem item, LayuiPage page);

    PagingResult<BrandDycTypeItem> findBrandDycTypeItemList(BrandDycTypeItemVo vo, LayuiPage page);
}