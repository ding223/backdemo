package com.gqgx.common.service.impl;

import com.github.pagehelper.PageHelper;
import com.gqgx.common.criteria.Criteria;
import com.gqgx.common.entity.*;
import com.gqgx.common.entity.vo.BrandKorTypeItemVo;
import com.gqgx.common.lang.Objects;
import com.gqgx.common.mapper.BrandKorTypeItemMapper;
import com.gqgx.common.paging.LayuiPage;
import com.gqgx.common.paging.PagingResult;
import com.gqgx.common.service.BrandKorTypeItemService;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.weekend.Weekend;
import tk.mybatis.mapper.weekend.WeekendCriteria;

import java.util.Date;
import java.util.List;

@org.springframework.stereotype.Service
public class BrandKorTypeItemServiceImpl implements BrandKorTypeItemService {
    @Autowired
    protected BrandKorTypeItemMapper mapper;
    @Override
    public BrandKorTypeItem getBrandKorTypeItem(Long id) {
        return mapper.selectByPrimaryKey(id);
    }

    @Override
    public int saveBrandKorTypeItem(BrandKorTypeItem brandKorTypeItem) {
        int count = 0;
        if(!Objects.isEmpty(brandKorTypeItem.getId())){
            count = mapper.updateByPrimaryKeySelective(brandKorTypeItem);
        }else{
            brandKorTypeItem.setRecordStatus(RecordStatus.ACTIVE);
            brandKorTypeItem.setUpdateCount(0);
            brandKorTypeItem.setCreateDate(new Date());
            count = mapper.insertSelective(brandKorTypeItem);
        }
        return count;
    }

    @Override
    public int deleteBrandKorTypeItem(BrandKorTypeItem brandKorTypeItem) {

        return mapper.deleteByPrimaryKey(brandKorTypeItem);
    }

    @Override
    public int deleteBrandKorTypeItemByIds(Long[] ids) {
        return mapper.deleteByIds(ids);
    }

    @Override
    public PagingResult<BrandKorTypeItem> findBrandKorTypeItem(Criteria criteria) {

        return null;
    }

    /**
     * 韩国商标分页
     * @param item
     * @param page
     * @return
     */
    @Override
    public PagingResult<BrandKorTypeItem> findBrandKorTypeItem(BrandKorTypeItem item, LayuiPage page) {
        Example example = new Example(BrandKorTypeItem.class);
        example.setOrderByClause("create_date DESC");

        if(!Objects.isEmpty(item.getProjectName())) {
            example.createCriteria().andLike("projectName", "%"+item.getProjectName().trim()+"%");
        }
        if (page != null) {
            PageHelper.startPage(page.getPage(), page.getLimit());
        }
        List<BrandKorTypeItem> list = mapper.selectByExample(example);

        PagingResult<BrandKorTypeItem> pageResult = new PagingResult<>(list);
        return pageResult;
    }

    @Override
    public PagingResult<BrandKorTypeItem> findBrandKorTypeItemList(BrandKorTypeItemVo vo, LayuiPage page) {
        Example example = new Example(BrandKorTypeItem.class);
        Example.Criteria criteria = example.createCriteria();

        criteria.andEqualTo("recordStatus", RecordStatus.ACTIVE);
        example.setOrderByClause("type_no project_name ASC");
        if(!Objects.isEmpty(vo.getLargeTypeId())) {
            example.createCriteria().andEqualTo("largeTypeId", vo.getLargeTypeId());
        }

        //复杂 or条件查询
        Weekend<BrandKorTypeItem> weekend = new Weekend<>(BrandKorTypeItem.class);
        WeekendCriteria<BrandKorTypeItem, Object> keywordCriteria = weekend.weekendCriteria();
        if (!Objects.isEmpty(vo.getFilter())) {
            keywordCriteria.orLike("typeNo", "%" + vo.getFilter().trim() + "%")
                    .orLike("projectGroup", "%" + vo.getFilter().trim() + "%")
                    .orLike("projectName", "%" + vo.getFilter().trim() + "%");
        }
        weekend.and(criteria);

        if (page != null) {
            PageHelper.startPage(page.getPage(), page.getLimit());
        }
        List<BrandKorTypeItem> list = mapper.selectByExample(weekend);

        PagingResult<BrandKorTypeItem> pageResult = new PagingResult<>(list);
        return pageResult;
    }
}