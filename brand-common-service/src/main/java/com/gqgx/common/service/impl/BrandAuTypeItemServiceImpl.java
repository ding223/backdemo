package com.gqgx.common.service.impl;

import com.github.pagehelper.PageHelper;
import com.gqgx.common.criteria.Criteria;
import com.gqgx.common.entity.BrandAuTypeItem;
import com.gqgx.common.entity.RecordStatus;
import com.gqgx.common.entity.vo.BrandAuTypeItemVo;
import com.gqgx.common.lang.Objects;
import com.gqgx.common.mapper.BrandAuTypeItemMapper;
import com.gqgx.common.paging.LayuiPage;
import com.gqgx.common.paging.PagingResult;
import com.gqgx.common.service.BrandAuTypeItemService;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.weekend.Weekend;
import tk.mybatis.mapper.weekend.WeekendCriteria;

import java.util.Date;
import java.util.List;

@org.springframework.stereotype.Service
public class BrandAuTypeItemServiceImpl implements BrandAuTypeItemService {

    @Autowired
    protected BrandAuTypeItemMapper brandAuTypeItemDAO;


    @Override
    public BrandAuTypeItem getBrandAuTypeItem(Long id) {
        return brandAuTypeItemDAO.selectByPrimaryKey(id);
    }

    @Override
    public int saveBrandAuTypeItem(BrandAuTypeItem item) {
        int count = 0;
        if(!Objects.isEmpty(item.getId())){
            count = brandAuTypeItemDAO.updateByPrimaryKeySelective(item);
        }else{
            //insertSelective插入数据，使用不为null的属性作为字段使用，如 INSERT INTO tb_user ( ID,NAME ) VALUES ( ?,? )，Parameters: null, test_insertSelective(String)
            item.setRecordStatus(RecordStatus.ACTIVE);
            item.setUpdateCount(0);
            item.setCreateDate(new Date());
            count = brandAuTypeItemDAO.insertSelective(item);
        }
        return count;
    }

    @Override
    public int deleteBrandAuTypeItem(BrandAuTypeItem item) {
        return brandAuTypeItemDAO.deleteByPrimaryKey(item);
    }

    @Override
    public int deleteBrandAuTypeItemByIds(Long[] ids) {
        return brandAuTypeItemDAO.deleteByIds(ids);
    }

    @Override
    public PagingResult<BrandAuTypeItem> findBrandAuTypeItem(Criteria criteria) {
        //TODO:
        return null;
    }

    @Override
    public PagingResult<BrandAuTypeItem> findBrandAuTypeItem(BrandAuTypeItem type, LayuiPage page) {
        Example example = new Example(BrandAuTypeItem.class);

        example.setOrderByClause("create_date DESC");
        if(!Objects.isEmpty(type.getProjectName())) {
            example.createCriteria().andLike("projectName", "%"+type.getProjectName().trim()+"%");
        }
        if (page != null) {
            PageHelper.startPage(page.getPage(), page.getLimit());
        }
        List<BrandAuTypeItem> list = brandAuTypeItemDAO.selectByExample(example);
        PagingResult<BrandAuTypeItem> pageResult = new PagingResult<>(list);
        return pageResult;
    }

    @Override
    public PagingResult<BrandAuTypeItem> findBrandAuTypeItemList(BrandAuTypeItemVo item, LayuiPage page) {
        Example example = new Example(BrandAuTypeItem.class);
        Example.Criteria criteria = example.createCriteria();

        criteria.andEqualTo("recordStatus", RecordStatus.ACTIVE);
        example.setOrderByClause("type_no project_name ASC");
        if(!Objects.isEmpty(item.getLargeTypeId())) {
            example.createCriteria().andEqualTo("largeTypeId", item.getLargeTypeId());
        }

        //复杂 or条件查询
        Weekend<BrandAuTypeItem> weekend = new Weekend<>(BrandAuTypeItem.class);
        WeekendCriteria<BrandAuTypeItem, Object> keywordCriteria = weekend.weekendCriteria();
        if (!Objects.isEmpty(item.getFilter())) {
            keywordCriteria.orLike("projectName", "%" + item.getFilter().trim() + "%")
                    .orLike("typeNo", "%" + item.getFilter().trim() + "%")
                    .orLike("projectSource", "%" + item.getFilter().trim() + "%");
        }
        weekend.and(criteria);

        if (page != null) {
            PageHelper.startPage(page.getPage(), page.getLimit());
        }
        List<BrandAuTypeItem> list = brandAuTypeItemDAO.selectByExample(weekend);

        PagingResult<BrandAuTypeItem> pageResult = new PagingResult<>(list);
        return pageResult;
    }
}