package com.gqgx.common.service;

import com.gqgx.common.criteria.Criteria;
import com.gqgx.common.entity.BrandAuTypeItem;
import com.gqgx.common.entity.vo.BrandAuTypeItemVo;
import com.gqgx.common.paging.LayuiPage;
import com.gqgx.common.paging.PagingResult;


public interface BrandAuTypeItemService {

    BrandAuTypeItem getBrandAuTypeItem(Long id);

    int saveBrandAuTypeItem(BrandAuTypeItem brandAuTypeItem);

    int deleteBrandAuTypeItem(BrandAuTypeItem brandAuTypeItem);

    int deleteBrandAuTypeItemByIds(Long[] ids);

    PagingResult<BrandAuTypeItem> findBrandAuTypeItem(Criteria criteria);
    
    PagingResult<BrandAuTypeItem> findBrandAuTypeItem(BrandAuTypeItem item, LayuiPage page);

    PagingResult<BrandAuTypeItem> findBrandAuTypeItemList(BrandAuTypeItemVo vo, LayuiPage page);
}