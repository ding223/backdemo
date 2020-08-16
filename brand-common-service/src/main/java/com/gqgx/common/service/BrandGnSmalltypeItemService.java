package com.gqgx.common.service;

import com.gqgx.common.criteria.Criteria;
import com.gqgx.common.entity.BrandGnSmalltypeItem;
import com.gqgx.common.entity.vo.BrandGnSmalltypeItemVo;
import com.gqgx.common.paging.LayuiPage;
import com.gqgx.common.paging.PagingResult;


public interface BrandGnSmalltypeItemService {

    BrandGnSmalltypeItem getBrandGnSmalltypeItem(Long id);

    int saveBrandGnSmalltypeItem(BrandGnSmalltypeItem brandGnSmalltypeItem);

    int deleteBrandGnSmalltypeItem(BrandGnSmalltypeItem brandGnSmalltypeItem);

    int deleteBrandGnSmalltypeItemByIds(Long[] ids);

    PagingResult<BrandGnSmalltypeItem> findBrandGnSmalltypeItem(Criteria criteria);
    
    PagingResult<BrandGnSmalltypeItem> findBrandGnSmalltypeItem(BrandGnSmalltypeItem item, LayuiPage page);

    PagingResult<BrandGnSmalltypeItem> findBrandGnSmalltypeItemList(BrandGnSmalltypeItemVo vo, LayuiPage page);
//    List<BrandGnSmalltypeItem> findBrandGnSmalltypeItemList(BrandGnSmalltypeItemVo vo, LayuiPage page);
}