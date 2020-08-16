package com.gqgx.common.service;

import com.gqgx.common.criteria.Criteria;
import com.gqgx.common.entity.BrandUsaTypeItem;
import com.gqgx.common.entity.vo.BrandUsaTypeItemVo;
import com.gqgx.common.paging.LayuiPage;
import com.gqgx.common.paging.PagingResult;


public interface BrandUsaTypeItemService {

    BrandUsaTypeItem getBrandUsaTypeItem(Long id);

    int saveBrandUsaTypeItem(BrandUsaTypeItem brandUsaTypeItem);

    int deleteBrandUsaTypeItem(BrandUsaTypeItem brandUsaTypeItem);

    int deleteBrandUsaTypeItemByIds(Long[] ids);

    PagingResult<BrandUsaTypeItem> findBrandUsaTypeItem(Criteria criteria);
    
    PagingResult<BrandUsaTypeItem> findBrandUsaTypeItem(BrandUsaTypeItem item, LayuiPage page);

    PagingResult<BrandUsaTypeItem> findBrandUsaTypeItemList(BrandUsaTypeItemVo vo, LayuiPage page);
}