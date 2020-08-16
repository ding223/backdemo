package com.gqgx.common.service;

import com.gqgx.common.criteria.Criteria;
import com.gqgx.common.entity.BrandKorTypeItem;
import com.gqgx.common.entity.vo.BrandKorTypeItemVo;
import com.gqgx.common.paging.LayuiPage;
import com.gqgx.common.paging.PagingResult;


public interface BrandKorTypeItemService {

    BrandKorTypeItem getBrandKorTypeItem(Long id);

    int saveBrandKorTypeItem(BrandKorTypeItem brandKorTypeItem);

    int deleteBrandKorTypeItem(BrandKorTypeItem brandKorTypeItem);

    int deleteBrandKorTypeItemByIds(Long[] ids);

    PagingResult<BrandKorTypeItem> findBrandKorTypeItem(Criteria criteria);
    
    PagingResult<BrandKorTypeItem> findBrandKorTypeItem(BrandKorTypeItem item, LayuiPage page);


    PagingResult<BrandKorTypeItem> findBrandKorTypeItemList(BrandKorTypeItemVo vo, LayuiPage page);
}