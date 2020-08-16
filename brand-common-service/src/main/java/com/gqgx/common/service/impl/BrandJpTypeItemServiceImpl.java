package com.gqgx.common.service.impl;

import com.github.pagehelper.PageHelper;
import com.gqgx.common.criteria.Criteria;
import com.gqgx.common.entity.*;
import com.gqgx.common.entity.vo.BrandJpTypeItemVo;
import com.gqgx.common.lang.Objects;
import com.gqgx.common.mapper.BrandJpTypeItemMapper;
import com.gqgx.common.paging.LayuiPage;
import com.gqgx.common.paging.PagingResult;
import com.gqgx.common.service.BrandJpTypeItemService;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.weekend.Weekend;
import tk.mybatis.mapper.weekend.WeekendCriteria;

import java.util.Date;
import java.util.List;

@org.springframework.stereotype.Service
public class BrandJpTypeItemServiceImpl implements BrandJpTypeItemService {

    @Autowired
    protected BrandJpTypeItemMapper mapper;


    @Override
    public BrandJpTypeItem getBrandJpTypeItem(Long id) {
        return mapper.selectByPrimaryKey(id);
    }

    @Override
    public int saveBrandJpTypeItem(BrandJpTypeItem brandJpTypeItem) {
        int count = 0;
        if(!Objects.isEmpty(brandJpTypeItem.getId())){
            count = mapper.updateByPrimaryKeySelective(brandJpTypeItem);
        }else{
            brandJpTypeItem.setRecordStatus(RecordStatus.ACTIVE);
            brandJpTypeItem.setUpdateCount(0);
            brandJpTypeItem.setCreateDate(new Date());
            count = mapper.insertSelective(brandJpTypeItem);
        }
        return count;
    }

    @Override
    public int deleteBrandJpTypeItem(BrandJpTypeItem brandJpTypeItem) {
        return mapper.deleteByPrimaryKey(brandJpTypeItem);
    }

    @Override
    public int deleteBrandJpTypeItemByIds(Long[] ids) {

        return mapper.deleteByIds(ids);
    }

    @Override
    public PagingResult<BrandJpTypeItem> findBrandJpTypeItem(Criteria criteria) {
        return null;
    }

    @Override
    public PagingResult<BrandJpTypeItem> findBrandJpTypeItem(BrandJpTypeItem item, LayuiPage page) {
        Example example = new Example(BrandJpTypeItem.class);
        example.setOrderByClause("create_date DESC");

        if(!Objects.isEmpty(item.getProjectName())) {
            example.createCriteria().andLike("projectName", "%"+item.getProjectName().trim()+"%");
        }
        if (page != null) {
            PageHelper.startPage(page.getPage(), page.getLimit());
        }
        List<BrandJpTypeItem> list = mapper.selectByExample(example);

        PagingResult<BrandJpTypeItem> pageResult = new PagingResult<>(list);
        return pageResult;
    }

    @Override
    public PagingResult<BrandJpTypeItem> findBrandJpTypeItemList(BrandJpTypeItemVo vo, LayuiPage page) {
        Example example = new Example(BrandJpTypeItem.class);
        Example.Criteria criteria = example.createCriteria();

        criteria.andEqualTo("recordStatus", RecordStatus.ACTIVE);
        example.setOrderByClause("type_no project_name ASC");
        if(!Objects.isEmpty(vo.getLargeTypeId())) {
            example.createCriteria().andEqualTo("largeTypeId", vo.getLargeTypeId());
        }

        //复杂 or条件查询
        Weekend<BrandGnSmalltypeItem> weekend = new Weekend<>(BrandGnSmalltypeItem.class);
        WeekendCriteria<BrandGnSmalltypeItem, Object> keywordCriteria = weekend.weekendCriteria();
        if (!Objects.isEmpty(vo.getFilter())) {
            keywordCriteria.orLike("typeNo", "%" + vo.getFilter().trim() + "%")
                    .orLike("projectName", "%" + vo.getFilter().trim() + "%");
        }
        weekend.and(criteria);

        if (page != null) {
            PageHelper.startPage(page.getPage(), page.getLimit());
        }
        List<BrandJpTypeItem> list = mapper.selectByExample(weekend);

        PagingResult<BrandJpTypeItem> pageResult = new PagingResult<>(list);
        return pageResult;
    }

}