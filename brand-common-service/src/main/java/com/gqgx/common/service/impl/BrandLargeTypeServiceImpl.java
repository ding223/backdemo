package com.gqgx.common.service.impl;

import com.github.pagehelper.PageHelper;
import com.gqgx.common.criteria.Criteria;
import com.gqgx.common.entity.BrandLargeType;
import com.gqgx.common.entity.RecordStatus;
import com.gqgx.common.lang.Objects;
import com.gqgx.common.mapper.BrandLargeTypeMapper;
import com.gqgx.common.paging.LayuiPage;
import com.gqgx.common.paging.PagingResult;
import com.gqgx.common.service.BrandLargeTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;
import java.util.List;

@org.springframework.stereotype.Service
public class BrandLargeTypeServiceImpl implements BrandLargeTypeService {

    @Autowired
    protected BrandLargeTypeMapper mapper;


    @Override
    public BrandLargeType getBrandLargeType(Long id) {
        
        return mapper.selectByPrimaryKey(id);
    }

    @Override
    public int saveBrandLargeType(BrandLargeType brandLargeType) {
        int count = 0;
        if(!Objects.isEmpty(brandLargeType.getId())){
            count = mapper.updateByPrimaryKeySelective(brandLargeType);
        }else{
            //insert方法是使用所有的属性作为字段使用,如INSERT INTO tb_user (AGE,USER_NAME,ID,NAME,BIRTHDAY,SEX,PASSWORD,UPDATED,CREATED) VALUES ( ?,?,?,?,?,?,?,?,? )，Parameters: null, null, null, sansan(String), null, null, null, null, null
            //insertSelective插入数据，使用不为null的属性作为字段使用，如 INSERT INTO tb_user ( ID,NAME ) VALUES ( ?,? )，Parameters: null, test_insertSelective(String)
            //TODO: 默认值
            brandLargeType.setRecordStatus(RecordStatus.ACTIVE);
            brandLargeType.setUpdateCount(0);
            brandLargeType.setCreateDate(new Date());
            count = mapper.insertSelective(brandLargeType);
        }
        return count;
    }

    @Override
    public int deleteBrandLargeType(BrandLargeType brandLargeType) {
        return mapper.deleteByPrimaryKey(brandLargeType);
    }

    @Override
    public int deleteBrandLargeTypeByIds(Long[] ids) {
        return mapper.deleteByIds(ids);
    }

    @Override
    public PagingResult<BrandLargeType> findBrandLargeType(Criteria criteria) {
        //TODO:
        throw new RuntimeException(".......未实现该方...........");
    }

    @Override
    public PagingResult<BrandLargeType> findBrandLargeType(BrandLargeType type, LayuiPage page) {
        Example example = new Example(BrandLargeType.class);

        if(type != null && !Objects.isEmpty(type.getName())) {
            example.createCriteria().andEqualTo("name", type.getName().trim());
        }
        example.createCriteria().andEqualTo("recordStatus", RecordStatus.ACTIVE);
        example.setOrderByClause("catalog ASC");

        if (page != null) {
            PageHelper.startPage(page.getPage(), page.getLimit());
        }
        List<BrandLargeType> list = mapper.selectByExample(example);

        PagingResult<BrandLargeType> pageResult = new PagingResult<>(list);
        return pageResult;

    }

    @Override
    public List<BrandLargeType> findBrandLargeTypeList(BrandLargeType type) {

        Example example = new Example(BrandLargeType.class);


        if(type != null && !Objects.isEmpty(type.getName())) {
            example.createCriteria().andEqualTo("name", type.getName().trim());
        }
        example.createCriteria().andEqualTo("recordStatus", RecordStatus.ACTIVE);

        example.setOrderByClause("catalog ASC");
        List<BrandLargeType> brandLargeTypeList = mapper.selectByExample(example);


        return brandLargeTypeList;
    }
}