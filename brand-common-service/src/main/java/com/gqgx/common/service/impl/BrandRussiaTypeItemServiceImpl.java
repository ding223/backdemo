package com.gqgx.common.service.impl;

import com.github.pagehelper.PageHelper;
import com.gqgx.common.criteria.Criteria;
import com.gqgx.common.entity.BrandRussiaTypeItem;
import com.gqgx.common.entity.RecordStatus;
import com.gqgx.common.lang.Objects;
import com.gqgx.common.mapper.BrandRussiaTypeItemMapper;
import com.gqgx.common.paging.LayuiPage;
import com.gqgx.common.paging.PagingResult;
import com.gqgx.common.service.BrandRussiaTypeItemService;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;
import java.util.List;

@org.springframework.stereotype.Service
public class BrandRussiaTypeItemServiceImpl implements BrandRussiaTypeItemService {

    @Autowired
    protected BrandRussiaTypeItemMapper mapper;


    @Override
    public BrandRussiaTypeItem getBrandRussiaTypeItem(Long id) {
        return mapper.selectByPrimaryKey(id);
    }

    @Override
    public int saveBrandRussiaTypeItem(BrandRussiaTypeItem brandRussiaTypeItem) {

        int count = 0;
        if (!Objects.isEmpty(brandRussiaTypeItem.getId())) {
            count = mapper.updateByPrimaryKeySelective(brandRussiaTypeItem);
        } else {
            brandRussiaTypeItem.setRecordStatus(RecordStatus.ACTIVE);
            brandRussiaTypeItem.setUpdateCount(0);
            brandRussiaTypeItem.setCreateDate(new Date());
            count = mapper.insertSelective(brandRussiaTypeItem);
        }
        return count;
    }

    @Override
    public int deleteBrandRussiaTypeItem(BrandRussiaTypeItem brandRussiaTypeItem) {
        return mapper.deleteByPrimaryKey(brandRussiaTypeItem);
    }

    @Override
    public int deleteBrandRussiaTypeItemByIds(Long[] ids) {
        return mapper.deleteByIds(ids);
    }

    @Override
    public PagingResult<BrandRussiaTypeItem> findBrandRussiaTypeItem(Criteria criteria) {
        return null;
    }

    @Override
    public PagingResult<BrandRussiaTypeItem> findBrandRussiaTypeItem(BrandRussiaTypeItem item, LayuiPage page) {
        Example example = new Example(BrandRussiaTypeItem.class);
        example.setOrderByClause("create_date DESC");

        if (!Objects.isEmpty(item.getTitle())) {
            example.createCriteria().andLike("title", item.getTitle());
        }
        if (page != null) {
            PageHelper.startPage(page.getPage(), page.getLimit());
        }
        List<BrandRussiaTypeItem> list = mapper.selectByExample(example);

        PagingResult<BrandRussiaTypeItem> pageResult = new PagingResult<>(list);
        return pageResult;
    }

    @Override
    public BrandRussiaTypeItem findBrandRussiaTypeItemByLargeId(Long largeTypeId) {
        Example example = new Example(BrandRussiaTypeItem.class);
        example.setOrderByClause("create_date DESC");
        if (!Objects.isEmpty(largeTypeId)) {
            example.createCriteria().andEqualTo("largeTypeId", largeTypeId);
        }
        List<BrandRussiaTypeItem> list = mapper.selectByExample(example);
        if (list != null && list.size() > 0) {
            BrandRussiaTypeItem Item = list.get(0);
            return Item;
        }
        return null;
    }
}