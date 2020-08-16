package com.gqgx.common.service.impl;

import com.github.pagehelper.PageHelper;
import com.gqgx.common.criteria.Criteria;
import com.gqgx.common.entity.BrandGnSmalltypeItem;
import com.gqgx.common.entity.BrandLargeType;
import com.gqgx.common.entity.RecordStatus;
import com.gqgx.common.entity.vo.BrandGnSmalltypeItemVo;
import com.gqgx.common.lang.Objects;
import com.gqgx.common.mapper.BrandGnSmalltypeItemMapper;
import com.gqgx.common.paging.LayuiPage;
import com.gqgx.common.paging.PagingResult;
import com.gqgx.common.service.BrandGnSmalltypeItemService;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;
import java.util.List;

@org.springframework.stereotype.Service
public class BrandGnSmalltypeItemServiceImpl implements BrandGnSmalltypeItemService {

    @Autowired
    protected BrandGnSmalltypeItemMapper mapper;


    @Override
    public BrandGnSmalltypeItem getBrandGnSmalltypeItem(Long id) {

        return mapper.selectByPrimaryKey(id);
    }

    @Override
    public int saveBrandGnSmalltypeItem(BrandGnSmalltypeItem brandGnSmalltypeItem) {

        int count = 0;
        if(!Objects.isEmpty(brandGnSmalltypeItem.getId())){
            count = mapper.updateByPrimaryKeySelective(brandGnSmalltypeItem);
        }else{
            brandGnSmalltypeItem.setRecordStatus(RecordStatus.ACTIVE);
            brandGnSmalltypeItem.setUpdateCount(0);
            brandGnSmalltypeItem.setCreateDate(new Date());
            count = mapper.insertSelective(brandGnSmalltypeItem);
        }
        return count;
    }

    @Override
    public int deleteBrandGnSmalltypeItem(BrandGnSmalltypeItem brandGnSmalltypeItem) {

        return mapper.deleteByPrimaryKey(brandGnSmalltypeItem);
    }

    @Override
    public int deleteBrandGnSmalltypeItemByIds(Long[] ids) {
       return mapper.deleteByPrimaryKey(ids);
     //   return  mapper.
    }

    @Override
    public PagingResult<BrandGnSmalltypeItem> findBrandGnSmalltypeItem(Criteria criteria) {
        return null;
    }

    @Override
    public PagingResult<BrandGnSmalltypeItem> findBrandGnSmalltypeItem(BrandGnSmalltypeItem item, LayuiPage page) {
        Example example = new Example(BrandGnSmalltypeItem.class);
        example.setOrderByClause("create_date DESC");

        if(!Objects.isEmpty(item.getProjectCnname())) {
            example.createCriteria().andLike("projectCnname", "%"+item.getProjectCnname().trim()+"%");
        }
        if (page != null) {
            PageHelper.startPage(page.getPage(), page.getLimit());
        }
        List<BrandGnSmalltypeItem> list = mapper.selectByExample(example);

        PagingResult<BrandGnSmalltypeItem> pageResult = new PagingResult<>(list);
        return pageResult;
    }

    @Override
    public PagingResult<BrandGnSmalltypeItem> findBrandGnSmalltypeItemList(BrandGnSmalltypeItemVo item, LayuiPage page) {

//        Example example = new Example(BrandGnSmalltypeItem.class);
//        Example.Criteria criteria = example.createCriteria();
//        criteria.andEqualTo("recordStatus", RecordStatus.ACTIVE);
//        example.setOrderByClause("group_no, project_no ASC");
//
//        if (!Objects.isEmpty(item.getLargeTypeId())) {
//            criteria.andEqualTo("largeTypeId", item.getLargeTypeId());
//        }
//        if (!Objects.isEmpty(item.getSmallTypeId())) {
//            criteria.andEqualTo("smallTypeId", item.getSmallTypeId());
//        }
//
//        //复杂 or条件查询
//        Weekend<BrandGnSmalltypeItem> weekend = new Weekend<>(BrandGnSmalltypeItem.class);
//        WeekendCriteria<BrandGnSmalltypeItem, Object> keywordCriteria = weekend.weekendCriteria();
//        if (!Objects.isEmpty(item.getFilter())) {
//            keywordCriteria.orLike("groupNo", "%" + item.getFilter().trim() + "%")
//                    .orLike("projectNo", "%" + item.getFilter().trim() + "%")
//                    .orLike("projectCnname", "%" + item.getFilter().trim() + "%")
//                    .orLike("projectEnname", "%" + item.getFilter().trim() + "%");
//        }
//        weekend.and(criteria);
//
//        if (page != null) {
//            PageHelper.startPage(page.getPage(), page.getLimit());
//        }
//        List<BrandGnSmalltypeItem> list = brandGnSmalltypeItemDAO.selectByExample(weekend);


        //分页插件，自动添加分页语句
        if (page != null) {
            PageHelper.startPage(page.getPage(), page.getLimit());
        }
        List<BrandGnSmalltypeItem> list = mapper.findByBrandGnSmalltypeItemVo(item);

        PagingResult<BrandGnSmalltypeItem> pageResult = new PagingResult<>(list);
        return pageResult;
    }

}