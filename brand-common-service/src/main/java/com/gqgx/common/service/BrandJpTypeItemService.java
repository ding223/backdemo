package com.gqgx.common.service;

import com.gqgx.common.criteria.Criteria;
import com.gqgx.common.entity.BrandJpTypeItem;
import com.gqgx.common.entity.vo.BrandJpTypeItemVo;
import com.gqgx.common.paging.LayuiPage;
import com.gqgx.common.paging.PagingResult;


public interface BrandJpTypeItemService {

    BrandJpTypeItem getBrandJpTypeItem(Long id);

    int saveBrandJpTypeItem(BrandJpTypeItem brandJpTypeItem);

    int deleteBrandJpTypeItem(BrandJpTypeItem brandJpTypeItem);

    int deleteBrandJpTypeItemByIds(Long[] ids);

    PagingResult<BrandJpTypeItem> findBrandJpTypeItem(Criteria criteria);
    
    PagingResult<BrandJpTypeItem> findBrandJpTypeItem(BrandJpTypeItem item, LayuiPage page);

    PagingResult<BrandJpTypeItem> findBrandJpTypeItemList(BrandJpTypeItemVo vo, LayuiPage page);
}