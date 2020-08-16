package com.gqgx.common.service.impl;

import com.github.pagehelper.PageHelper;
import com.gqgx.common.criteria.Criteria;
import com.gqgx.common.entity.*;
import com.gqgx.common.entity.vo.BrandUsaTypeItemVo;
import com.gqgx.common.lang.Objects;
import com.gqgx.common.mapper.BrandUsaTypeItemMapper;
import com.gqgx.common.paging.LayuiPage;
import com.gqgx.common.paging.PagingResult;
import com.gqgx.common.service.BrandUsaTypeItemService;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.weekend.Weekend;
import tk.mybatis.mapper.weekend.WeekendCriteria;

import java.util.Date;
import java.util.List;

@org.springframework.stereotype.Service
public class BrandUsaTypeItemServiceImpl implements BrandUsaTypeItemService {

    @Autowired
    protected BrandUsaTypeItemMapper mapper;


    @Override
    public BrandUsaTypeItem getBrandUsaTypeItem(Long id) {

        return mapper.selectByPrimaryKey(id);
    }

    @Override
    public int saveBrandUsaTypeItem(BrandUsaTypeItem brandUsaTypeItem) {
        int count = 0;
        if(!Objects.isEmpty(brandUsaTypeItem.getId())){
            count = mapper.updateByPrimaryKeySelective(brandUsaTypeItem);
        }else{
            brandUsaTypeItem.setRecordStatus(RecordStatus.ACTIVE);
            brandUsaTypeItem.setUpdateCount(0);
            brandUsaTypeItem.setCreateDate(new Date());
            count = mapper.insertSelective(brandUsaTypeItem);
        }
        return count;
    }

    @Override
    public int deleteBrandUsaTypeItem(BrandUsaTypeItem brandUsaTypeItem) {

        return mapper.delete(brandUsaTypeItem);
    }

    @Override
    public int deleteBrandUsaTypeItemByIds(Long[] ids) {

        return mapper.deleteByIds(ids);
    }

    @Override
    public PagingResult<BrandUsaTypeItem> findBrandUsaTypeItem(Criteria criteria) {
        return null;
    }

    @Override
    public PagingResult<BrandUsaTypeItem> findBrandUsaTypeItem(BrandUsaTypeItem item, LayuiPage page) {
        Example example = new Example(BrandUsaTypeItem.class);
        example.setOrderByClause("create_date DESC");

        if(!Objects.isEmpty(item.getProjectName())) {
            example.createCriteria().andLike("projectName", item.getProjectName().trim());
        }
        if (page != null) {
            PageHelper.startPage(page.getPage(), page.getLimit());
        }
        List<BrandUsaTypeItem> list = mapper.selectByExample(example);

        PagingResult<BrandUsaTypeItem> pageResult = new PagingResult<>(list);
        return pageResult;
    }

    @Override
    public PagingResult<BrandUsaTypeItem> findBrandUsaTypeItemList(BrandUsaTypeItemVo vo, LayuiPage page) {
        Example example = new Example(BrandUsaTypeItem.class);
        Example.Criteria criteria = example.createCriteria();

        criteria.andEqualTo("recordStatus", RecordStatus.ACTIVE);
        example.setOrderByClause("type_no project_name ASC");
        if(!Objects.isEmpty(vo.getLargeTypeId())) {
            example.createCriteria().andEqualTo("largeTypeId", vo.getLargeTypeId());
        }

        //复杂 or条件查询
        Weekend<BrandUsaTypeItem> weekend = new Weekend<>(BrandUsaTypeItem.class);
        WeekendCriteria<BrandUsaTypeItem, Object> keywordCriteria = weekend.weekendCriteria();
        if (!Objects.isEmpty(vo.getFilter())) {
            keywordCriteria.orLike("typeNo", "%" + vo.getFilter().trim() + "%")
                    .orLike("projectName", "%" + vo.getFilter().trim() + "%")
                    .orLike("projectTranslation", "%" + vo.getFilter().trim() + "%");

        }
        weekend.and(criteria);

        if (page != null) {
            PageHelper.startPage(page.getPage(), page.getLimit());
        }
        List<BrandUsaTypeItem> list = mapper.selectByExample(weekend);

        PagingResult<BrandUsaTypeItem> pageResult = new PagingResult<>(list);
        return pageResult;

    }
}